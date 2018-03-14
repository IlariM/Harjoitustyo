CREATE TABLE IF NOT EXISTS elokuva(
id int(5) NOT NULL AUTO_INCREMENT,
nimi varchar(50) DEFAULT NULL,
ohjaaja varchar(50) DEFAULT null,
arvio int(10) DEFAULT 0,
kommentti varchar(100) DEFAULT null,
PRIMARY KEY(id)
);