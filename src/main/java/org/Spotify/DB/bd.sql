DROP DATABASE IF EXISTS SpotifyDB;
CREATE DATABASE SpotifyDB;
USE SpotifyDB;

CREATE TABLE Roles (
    idRole VARCHAR(37) PRIMARY KEY,
    roleName VARCHAR(50) NOT NULL
);

CREATE TABLE Users (
    idUser VARCHAR(37) PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    middleName VARCHAR(50),
    lastName VARCHAR(50) NOT NULL,
    secondLastName VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    nickname VARCHAR(50) UNIQUE NOT NULL,
    passwordUser VARCHAR(255) NOT NULL,
    idRole VARCHAR(200),
    FOREIGN KEY (idRole) REFERENCES Roles(idRole) ON DELETE SET NULL
);

CREATE TABLE Genders (
    idGender VARCHAR(37) PRIMARY KEY,
    nameGender VARCHAR(50) NOT NULL
);

CREATE TABLE Albums (
    idAlbum VARCHAR(37) PRIMARY KEY,
    nameAlbum VARCHAR(100) NOT NULL,
    creationAlbum DATE NOT NULL,
    idArtist VARCHAR(200),
    idGender VARCHAR(200),
    FOREIGN KEY (idArtist) REFERENCES Users(idUser) ON DELETE CASCADE,
    FOREIGN KEY (idGender) REFERENCES Genders(idGender) ON DELETE SET NULL
);

CREATE TABLE Songs (
    idSong VARCHAR(37) PRIMARY KEY,
    nameSong VARCHAR(100) NOT NULL,
    idGender VARCHAR(200),
    idAlbum VARCHAR(200),
    idArtist VARCHAR(200),
    route varchar(500),
    FOREIGN KEY (idGender) REFERENCES Genders(idGender) ON DELETE SET NULL,
    FOREIGN KEY (idAlbum) REFERENCES Albums(idAlbum) ON DELETE CASCADE,
    FOREIGN KEY (idArtist) REFERENCES Users(idUser) ON DELETE CASCADE
);

CREATE TABLE Playlists (
    idPlaylist VARCHAR(37) PRIMARY KEY,
    namePlaylist VARCHAR(100) NOT NULL,
    idUser VARCHAR(200),
    idSong VARCHAR(200),
    FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE,
    FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE NO ACTION
);

INSERT INTO Genders (idGender, nameGender) VALUES ('809ffcab-f2c3-46f8-b3ef-c230de6b84df', 'Rock');
INSERT INTO Genders (idGender, nameGender) VALUES ('0f3e742f-d457-4dcf-8985-a1fd237f0dd3', 'Pop');
INSERT INTO Genders (idGender, nameGender) VALUES ('49ec210d-8b20-4df7-97b6-67ac6a83e143', 'Jazz');
INSERT INTO Genders (idGender, nameGender) VALUES ('6f19bb04-fd90-43bd-9d7c-a9442061f477', 'Classical');
INSERT INTO Genders (idGender, nameGender) VALUES ('3ee966ed-2441-42e5-a6de-70facecd2ed5', 'Hip Hop');
INSERT INTO Genders (idGender, nameGender) VALUES ('aeb782ce-b6df-41fd-925a-df94d452483a', 'Electronic');
INSERT INTO Genders (idGender, nameGender) VALUES ('162f9717-0e10-4b06-951c-eb57eda3b6ac', 'Country');
INSERT INTO Genders (idGender, nameGender) VALUES ('f83e3ca9-5af3-4d62-aad1-45914cb65ce9', 'Salsa');
INSERT INTO Genders (idGender, nameGender) VALUES ('e789bd56-5d3e-4ca7-a6dc-3db2f51a03f5', 'Merengue');
INSERT INTO Genders (idGender, nameGender) VALUES ('622ec438-d949-40c0-a99f-ef01f2b35f1c', 'Bachata');
INSERT INTO Genders (idGender, nameGender) VALUES ('c53b19de-d887-48c1-8efc-d2dcf7784584', 'Reggaeton');
INSERT INTO Genders (idGender, nameGender) VALUES ('903a98ac-1a54-4323-baee-832a37a5d29c', 'Cumbia');
INSERT INTO Genders (idGender, nameGender) VALUES ('4a906ddf-6b69-452f-9e90-3162e44fc9ee', 'Ranchera');
INSERT INTO Genders (idGender, nameGender) VALUES ('d7abed76-e5da-479d-b8f5-e760bffaf8ad', 'Bolero');
INSERT INTO Genders (idGender, nameGender) VALUES ('49f07226-0072-4dad-a2da-2a5d09655e01', 'Tango');
INSERT INTO Genders (idGender, nameGender) VALUES ('a72e1d4b-9104-46ea-97e2-63745955426a', 'Samba');
INSERT INTO Genders (idGender, nameGender) VALUES ('e4ab69ac-1120-4437-a8e8-19d719ee9771', 'Bossa Nova');

INSERT INTO Roles (idRole, roleName) VALUES ('11111111-1111-1111-1111-111111111111', 'ADMIN_ROLE');
INSERT INTO Roles (idRole, roleName) VALUES ('22222222-2222-2222-2222-222222222222', 'USER_ROLE');
INSERT INTO Roles (idRole, roleName) VALUES ('33333333-3333-3333-3333-333333333333', 'SING_ROLE');