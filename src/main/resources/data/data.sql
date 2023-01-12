INSERT INTO performer (id,name)
    VALUES (1, 'Vows');

INSERT INTO track (id,number,title,duration,performer_id)
VALUES
    (1,1,'Settle Down','00:04:17',1),
    (2,2,'Cameo Lover','00:04:02',1),
    (3,3,'Two Way Street','00:04:28',1),
    (4,4,'Old Flame','00:04:27',1),
    (5,5,'Good Intent','00:03:32',1),
    (6,6,'Plain Gold Ring','00:04:02',1),
    (7,7,'Call Me','00:04:32',1),
    (8,8,'Limbo','00:03:51',1),
    (9,9,'Wandering Limbs','00:05:26',1),
    (10,10,'Withdraw','00:04:06',1),
    (11,11,'The Build Up','00:08:22',1);

INSERT INTO album(id, title, release_date,performer_id)
VALUES (1,'Kimbra - the original', '2011-08-29',1);

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



