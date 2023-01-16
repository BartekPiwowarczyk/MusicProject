INSERT INTO performer (name)
    VALUES ('Wykonawca1'),
            ('Wykonawca2');

INSERT INTO track (number,title,duration,performer_id)
VALUES
    (1,'track1','00:02:45',1),
    (2,'track2','00:02:20',1),
    (3,'track3','00:02:45',1),
    (1,'track4','00:03:50',2),
    (2,'track5','00:01:10',2);

INSERT INTO album(title, release_date,performer_id)
VALUES ('Album1', '2010-01-02',1),
        ('Album2', '2011-01-02',2);

INSERT INTO tracks_albums (track_id,album_id)
VALUES (1,1),
       (2,1),
       (3,1),
       (4,2),
       (5,2);




