package hellojpa.service;

import hellojpa.domain.Screening;
import hellojpa.dto.ScreeningDto;
import hellojpa.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    public List<ScreeningDto> findCurrentScreenings() {

        LocalDate todayDate = LocalDate.now();
        List<Screening> currentScreenings = screeningRepository.findCurrentScreenings(todayDate);

        return currentScreenings.stream()
                .map(ScreeningDto::of) // 정적 팩토리 메서드 호출
                .toList();
    }

}
