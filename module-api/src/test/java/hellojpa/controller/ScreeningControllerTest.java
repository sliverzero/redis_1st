/*
package hellojpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hellojpa.domain.Genre;
import hellojpa.domain.VideoRating;
import hellojpa.dto.ScreeningDto;
import hellojpa.dto.SearchCondition;
import hellojpa.service.ScreeningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ScreeningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ScreeningService screeningService;  // @Autowired로 실제 서비스 주입

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ScreeningController(screeningService))  // 실제 서비스 주입
                .build();
    }

    @Test
    void getCurrentScreenings_ReturnsFilteredResponse() throws Exception {
        // Given
        ScreeningDto screeningDto1 = new ScreeningDto(
                "Movie Title 1",
                VideoRating.ALL,
                LocalDate.now(),
                "https://xxx1",
                120,
                Genre.ACTION
        );
        ScreeningDto screeningDto2 = new ScreeningDto(
                "Movie Title 2",
                VideoRating.ALL,
                LocalDate.now(),
                "https://xxx2",
                110,
                Genre.DRAMA
        );
        ScreeningDto screeningDto3 = new ScreeningDto(
                "Movie Title 3",
                VideoRating.ALL,
                LocalDate.now(),
                "https://xxx3",
                100,
                Genre.ACTION
        );

        SearchCondition searchCondition = new SearchCondition("Movie Title 1", "ACTION");

        // When & Then
        mockMvc.perform(get("/screening/movies")
                        .param("title", "Movie Title 1")
                        .param("genre", "ACTION")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())  // 요청 및 응답 출력
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.code").value("success"))
                .andExpect(jsonPath("$.message").value("요청에 성공했습니다."))
                .andExpect(jsonPath("$.data").isArray())  // data가 배열로 반환되는지 확인
                .andExpect(jsonPath("$.data[0].title").value("Movie Title 1"))
                .andExpect(jsonPath("$.data[0].genre").value("ACTION"))
                .andExpect(jsonPath("$.data[0].releaseDate").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.data[0].rating").value("ALL"))
                .andExpect(jsonPath("$.data[0].thumbnail").value("https://xxx1"))
                .andExpect(jsonPath("$.data[0].runningTime").value(120));
    }

}
*/