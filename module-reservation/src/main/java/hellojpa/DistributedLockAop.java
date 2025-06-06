package hellojpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class DistributedLockAop {

    private static final String REDISSON_LOCK_PREFIX = "LOCK:";

    private final RedissonClient redissonClient;
    private final AopForTransaction aopForTransaction;

    @Around("@annotation(hellojpa.DistributedLock)")
    public Object lock(final ProceedingJoinPoint joinPoint, DistributedLock distributedLock) throws Throwable {

        String key = REDISSON_LOCK_PREFIX + distributedLock.key();
        log.info("Generated Lock Key: {}", key);

        RLock rLock = redissonClient.getLock(key);

        boolean available = false;
        try {
            available = rLock.tryLock(distributedLock.waitTime(), distributedLock.leaseTime(), distributedLock.timeUnit());
            if (!available) {
                log.warn("Failed to acquire lock: {}", key);
                return false;
            }

            return aopForTransaction.proceed(joinPoint);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while acquiring lock", e);
        } finally {
            try {
                rLock.unlock();
            } catch (IllegalMonitorStateException e) {
                log.info("Redisson Lock Already Unlock {}", key);
            }
        }
    }
}