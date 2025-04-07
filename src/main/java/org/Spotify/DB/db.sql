CREATE DATABASE SpotifyDB;
USE SpotifyDB;

CREATE TABLE Roles (
    idRol VARCHAR(37) PRIMARY KEY,
    nameRol VARCHAR(50) NOT NULL
);

CREATE TABLE Persons (
    idPerson VARCHAR(37) PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    middleName VARCHAR(50),
    lastName VARCHAR(50) NOT NULL,
    secondLastName VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Users (
    idUser VARCHAR(37) PRIMARY KEY,
    nickname VARCHAR(30) UNIQUE NOT NULL,
    passwordUser VARCHAR(255) NOT NULL,
    idRolUser VARCHAR(37),
    idPersonUser VARCHAR(37),
    FOREIGN KEY (idRolUser) REFERENCES Roles(idRol) ON DELETE SET NULL,
    FOREIGN KEY (idPersonUser) REFERENCES Persons(idPerson) ON DELETE SET NULL
);

CREATE TABLE Genders (
    idGender VARCHAR(37) PRIMARY KEY,
    nameGender VARCHAR(50) NOT NULL
);

CREATE TABLE Albums (
    idAlbum VARCHAR(37) PRIMARY KEY,
    nameAlbum VARCHAR(100) NOT NULL,
    creationAlbum DATE NOT NULL,
    likeAlbum BOOLEAN DEFAULT FALSE,
    idGenderAlbum VARCHAR(37),
    FOREIGN KEY (idGenderAlbum) REFERENCES Genders(idGender) ON DELETE SET NULL
);

CREATE TABLE Songs (
    idSong VARCHAR(37) PRIMARY KEY,
    nameSong VARCHAR(100) NOT NULL,
    creationSong VARCHAR(4),
    likeSong BOOLEAN DEFAULT FALSE,
    durationSong VARCHAR(5),
    idGender VARCHAR(37),
    idAlbum VARCHAR(37) NULL,
    pathFile VARCHAR(255) NULL,
    FOREIGN KEY (idGender) REFERENCES Genders(idGender) ON DELETE SET NULL,
    FOREIGN KEY (idAlbum) REFERENCES Albums(idAlbum) ON DELETE CASCADE
);

CREATE TABLE SongUsers (
    idSong VARCHAR(37),
    idArtist VARCHAR(37),
    PRIMARY KEY (idSong, idArtist),
    FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE,
    FOREIGN KEY (idArtist) REFERENCES Users(idUser) ON DELETE CASCADE
);

CREATE TABLE SongPersons (
    idSong VARCHAR(37),
    idPerson VARCHAR(37) null,
    PRIMARY KEY (idSong, idPerson),
    FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE,
    FOREIGN KEY (idPerson) REFERENCES Persons(idPerson) ON DELETE CASCADE
);

CREATE TABLE Playlists (
    idPlaylist VARCHAR(37) PRIMARY KEY,
    namePlaylist VARCHAR(100) NOT NULL,
    idUserPlaylist VARCHAR(37),
    FOREIGN KEY (idUserPlaylist) REFERENCES Users(idUser) ON DELETE CASCADE
);

CREATE TABLE PlaylistSongs (
    idPlaylist VARCHAR(37),
    idSong VARCHAR(37),
    PRIMARY KEY (idPlaylist, idSong),
    FOREIGN KEY (idPlaylist) REFERENCES Playlists(idPlaylist) ON DELETE CASCADE,
    FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE
);

CREATE TABLE Comments(
	idComment VARCHAR(37) PRIMARY KEY,
    dateComment DATE NOT NULL,
    contentComment VARCHAR(500) NOT NULL,
    idUserComment VARCHAR(37),
    FOREIGN KEY (idUserComment) REFERENCES Users(idUser) ON DELETE CASCADE
);

INSERT INTO Genders (idGender, nameGender) VALUES 
('550e8400-e29b-41d4-a716-446655440000', 'Pop'),
('550e8400-e29b-41d4-a716-446655440001', 'Rock'),
('550e8400-e29b-41d4-a716-446655440002', 'Hip Hop'),
('550e8400-e29b-41d4-a716-446655440003', 'Electrónica'),
('550e8400-e29b-41d4-a716-446655440004', 'Reggaetón'),
('550e8400-e29b-41d4-a716-446655440005', 'Jazz'),
('550e8400-e29b-41d4-a716-446655440006', 'Clásica'),
('550e8400-e29b-41d4-a716-446655440007', 'Metal'),
('550e8400-e29b-41d4-a716-446655440008', 'Blues'),
('550e8400-e29b-41d4-a716-446655440009', 'Salsa'),
('550e8400-e29b-41d4-a716-446655440010', 'Indie Rock'),
('550e8400-e29b-41d4-a716-446655440011', 'Trap'),
('550e8400-e29b-41d4-a716-446655440012', 'House'),
('550e8400-e29b-41d4-a716-446655440013', 'K-Pop');

-- Usando UUIDs generados manualmente (válidos para cualquier sistema)
INSERT INTO Roles (idRol, nameRol) VALUES
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', 'Admin'),
('b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', 'User'),
('c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f', 'Artist');

INSERT INTO Albums (idAlbum, nameAlbum, creationAlbum, likeAlbum, idGenderAlbum) VALUES 
('8b6f2d9a-4e60-11ee-b3ff-0242ac120003', 'No Need to Argue', '1994-10-03', FALSE, '550e8400-e29b-41d4-a716-446655440001'),
('b52a3b0c-4e60-11ee-9d42-0242ac120004', 'Mil Siluetas', '1984-06-01', FALSE, '550e8400-e29b-41d4-a716-446655440000');

INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) VALUES ('d3a7b8c2-4e5f-11ee-be56-0242ac120002', 'Psycho (Acoustic)', '2021','3:06', '550e8400-e29b-41d4-a716-446655440000', NULL, 'src/main/java/org/Spotify/Music/Psycho (Acoustic).mp3');
INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) VALUES ('5f2c1d9a-4e60-11ee-b3ff-0242ac120002', 'Who love the Sun', '1970','2:50', '550e8400-e29b-41d4-a716-446655440012', NULL, 'src/main/java/org/Spotify/Music/Who love the sun.mp3');
INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) VALUES ('8e4a3b0c-4e60-11ee-9d42-0242ac120002', 'Zombie', '1994','5:06', '550e8400-e29b-41d4-a716-446655440001', NULL, 'src/main/java/org/Spotify/Music/Zombie.mp3');
INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) VALUES ('b76c2d8e-4e60-11ee-8e1f-0242ac120002', 'Hombre lobo en Paris', '1984','3:52', '550e8400-e29b-41d4-a716-446655440000', NULL, 'src/main/java/org/Spotify/Music/hombre lobo en Paris.mp3');