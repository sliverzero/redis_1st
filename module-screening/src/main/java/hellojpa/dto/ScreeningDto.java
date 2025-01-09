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
}
