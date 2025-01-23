CREATE TABLE movie (
    movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    rating VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    thumbnail VARCHAR(255) NOT NULL,
    running_time INT NOT NULL,
    genre VARCHAR(255) NOT NULL
)CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE theater (
    theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
)CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE seat (
    seat_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    theater_id BIGINT NOT NULL,
    seat_row VARCHAR(255) NOT NULL,
    seat_column INT NOT NULL,
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
)CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE screening (
    screening_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    theater_id BIGINT NOT NULL,
    start_time TIME NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
)CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;