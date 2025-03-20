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
    creationSong Date,
    likeSong BOOLEAN DEFAULT FALSE,
    durationSong VARCHAR(5),
    idGender VARCHAR(37),
    idAlbum VARCHAR(37) NULL,
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