package hellojpa.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // 장르 이름
}
