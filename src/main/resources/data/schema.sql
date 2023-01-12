create table performer (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

create table track (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    performer_id BIGINT,
    number   INT          NOT NULL,
    title    VARCHAR(200) NOT NULL,
    duration TIME NOT NULL,
    FOREIGN KEY (performer_id) REFERENCES performer (id)
    );

create table album
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    performer_id BIGINT,
    release_date DATE NOT NULL,
    FOREIGN KEY (performer_id) REFERENCES performer (id)
);

create table tracks_albums
(
    track_id BIGINT NOT NULL,
    album_id BIGINT NOT NULL,
    FOREIGN KEY (track_id) REFERENCES track (id),
    FOREIGN KEY (album_id) REFERENCES album (id)
);