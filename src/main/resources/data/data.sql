INSERT INTO performer (name)
    VALUES ('Vows');

INSERT INTO track (number,title,duration,performer_id)
VALUES
    (1,'Settle Down','00:04:17',1),
    (2,'Cameo Lover','00:04:02',1),
    (3,'Two Way Street','00:04:28',1),
    (4,'Old Flame','00:04:27',1),
    (5,'Good Intent','00:03:32',1),
    (6,'Plain Gold Ring','00:04:02',1),
    (7,'Call Me','00:04:32',1),
    (8,'Limbo','00:03:51',1),
    (9,'Wandering Limbs','00:05:26',1),
    (10,'Withdraw','00:04:06',1),
    (11,'The Build Up','00:08:22',1);

INSERT INTO album(title, release_date,performer_id)
VALUES ('Kimbra - the original', '2011-08-29',1);

INSERT INTO tracks_albums (track_id,album_id)
VALUES (1,1),
       (2,1),
       (3,1),
       (4,1),
       (5,1),
       (6,1),
       (7,1),
       (8,1),
       (9,1),
       (10,1),
       (11,1);



