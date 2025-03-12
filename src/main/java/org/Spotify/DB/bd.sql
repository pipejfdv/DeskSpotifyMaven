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