DROP DATABASE IF EXISTS SpotifyDB;
CREATE DATABASE SpotifyDB;
USE SpotifyDB;

-- Tabla de roles
CREATE TABLE Roles (
    idRole VARCHAR(37) PRIMARY KEY,
    roleName VARCHAR(50) NOT NULL
);

-- Tabla de usuarios
CREATE TABLE Users (
    idUser VARCHAR(37) PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    middleName VARCHAR(50),
    lastName VARCHAR(50) NOT NULL,
    secondLastName VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    nickname VARCHAR(50) UNIQUE NOT NULL,
    passwordUser VARCHAR(255) NOT NULL,
    idRole VARCHAR(37),
    FOREIGN KEY (idRole) REFERENCES Roles(idRole) ON DELETE SET NULL
);

-- Tabla de géneros musicales
CREATE TABLE Genders (
    idGender VARCHAR(37) PRIMARY KEY,
    nameGender VARCHAR(50) NOT NULL
);

-- Tabla de canciones
CREATE TABLE Songs (
    idSong VARCHAR(37) PRIMARY KEY,
    nameSong VARCHAR(100) NOT NULL,
    creationSong YEAR, -- Solo almacena el año
    idGender VARCHAR(37),
    route VARCHAR(500),
    FOREIGN KEY (idGender) REFERENCES Genders(idGender) ON DELETE SET NULL
);

-- Tabla de playlists
CREATE TABLE Playlists (
    idPlaylist VARCHAR(37) PRIMARY KEY,
    namePlaylist VARCHAR(100) NOT NULL,
    type VARCHAR(50), -- Tipo de playlist: "Álbum", "Mix", "Favoritos", etc.
    idUser VARCHAR(37), -- Usuario que creó la playlist
    FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

-- Tabla de relación entre playlists y canciones
CREATE TABLE PlaylistSongs (
    idPlaylist VARCHAR(37),
    idSong VARCHAR(37),
    PRIMARY KEY (idPlaylist, idSong), -- Clave primaria compuesta
    FOREIGN KEY (idPlaylist) REFERENCES Playlists(idPlaylist) ON DELETE CASCADE,
    FOREIGN KEY (idSong) REFERENCES Songs(idSong) ON DELETE CASCADE
);

-- Inserción de géneros musicales
INSERT INTO Genders (idGender, nameGender) VALUES 
('809ffcab-f2c3-46f8-b3ef-c230de6b84df', 'Rock'),
('0f3e742f-d457-4dcf-8985-a1fd237f0dd3', 'Pop'),
('49ec210d-8b20-4df7-97b6-67ac6a83e143', 'Jazz'),
('6f19bb04-fd90-43bd-9d7c-a9442061f477', 'Classical'),
('3ee966ed-2441-42e5-a6de-70facecd2ed5', 'Hip Hop'),
('aeb782ce-b6df-41fd-925a-df94d452483a', 'Electronic'),
('162f9717-0e10-4b06-951c-eb57eda3b6ac', 'Country'),
('f83e3ca9-5af3-4d62-aad1-45914cb65ce9', 'Salsa'),
('e789bd56-5d3e-4ca7-a6dc-3db2f51a03f5', 'Merengue'),
('622ec438-d949-40c0-a99f-ef01f2b35f1c', 'Bachata'),
('c53b19de-d887-48c1-8efc-d2dcf7784584', 'Reggaeton'),
('903a98ac-1a54-4323-baee-832a37a5d29c', 'Cumbia'),
('4a906ddf-6b69-452f-9e90-3162e44fc9ee', 'Ranchera'),
('d7abed76-e5da-479d-b8f5-e760bffaf8ad', 'Bolero'),
('49f07226-0072-4dad-a2da-2a5d09655e01', 'Tango'),
('a72e1d4b-9104-46ea-97e2-63745955426a', 'Samba'),
('e4ab69ac-1120-4437-a8e8-19d719ee9771', 'Bossa Nova');

-- Inserción de roles
INSERT INTO Roles (idRole, roleName) VALUES 
('11111111-1111-1111-1111-111111111111', 'ADMIN_ROLE'),
('22222222-2222-2222-2222-222222222222', 'USER_ROLE'),
('33333333-3333-3333-3333-333333333333', 'SING_ROLE');