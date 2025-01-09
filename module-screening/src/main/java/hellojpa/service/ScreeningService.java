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
                .map(currentScreening -> {
                    String title = currentScreening.getMovie().getTitle();
                    String videoRating = currentScreening.getMovie().getRating().toString();
                    LocalDate releaseDate = currentScreening.getMovie().getReleaseDate();
                    String thumbnail = currentScreening.getMovie().getThumbnail();
                    int runningTime = currentScreening.getMovie().getRunningTime();
                    String genreName = currentScreening.getMovie().getGenre().getName();
                    String theaterName = currentScreening.getTheater().getName();
                    LocalTime startTime = currentScreening.getStartTime();
                    LocalTime endTime = currentScreening.getStartTime().plusMinutes(runningTime);

                    return new ScreeningDto(
                            title, videoRating, releaseDate, thumbnail,
                            runningTime, genreName, theaterName, startTime, endTime
                    );
                })
                .collect(Collectors.toList());
    }

}
