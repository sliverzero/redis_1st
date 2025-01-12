package hellojpa.dto;

import hellojpa.domain.Screening;
import hellojpa.domain.VideoRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDto {

    private String title;
    private String videoRating;
    private LocalDate releaseDate;
    private String thumbnail;
    private int runningTime;
    private String genreName;
    private String theaterName;
    private LocalTime startTime;
    private LocalTime endTime;

    public static ScreeningDto of(Screening screening){
        String title = screening.getMovie().getTitle();
        String videoRating = screening.getMovie().getRating().toString();
        LocalDate releaseDate = screening.getMovie().getReleaseDate();
        String thumbnail = screening.getMovie().getThumbnail();
        int runningTime = screening.getMovie().getRunningTime();
        String genreName = screening.getMovie().getGenre().toString();
        String theaterName = screening.getTheater().getName();
        LocalTime startTime = screening.getStartTime();
        LocalTime endTime = screening.getStartTime().plusMinutes(runningTime);

        return new ScreeningDto(
                title, videoRating, releaseDate, thumbnail,
                runningTime, genreName, theaterName, startTime, endTime
        );
    }
}
