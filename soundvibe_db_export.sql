-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Agu 2023 pada 02.57
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soundvibe`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `album`
--

CREATE TABLE `album` (
  `albumId` varchar(45) NOT NULL,
  `albumName` varchar(45) DEFAULT NULL,
  `albumCover` varchar(45) DEFAULT NULL,
  `artist_artistId` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data untuk tabel `album`
--

INSERT INTO `album` (`albumId`, `albumName`, `albumCover`, `artist_artistId`) VALUES
('AL0001', 'DEKADE', 'dekade.jpg', 'A0002'),
('AL0002', 'A Rush of Blood to the Head', 'arushofbloodtothehead.jpg', 'A0003'),
('AL0003', 'Harus Bahagia', 'harusbahagia.jpg', 'A0001'),
('AL0004', 'Manusia', 'manusia.jpg', 'A0004'),
('AL0005', 'Monokrom', 'monokrom.jpg', 'A0004'),
('AL0006', 'Sentimental', 'sentimental.jpg', 'A0005'),
('AL0007', 'Kereta Kencan', 'keretakencan.jpg', 'A0006'),
('AL0008', 'In a Perfect World', 'inaperfectworld.jpg', 'A0007'),
('AL0009', 'lowkey', 'lowkey.jpg', 'A0008'),
('AL0010', 'this is what falling in love feels like', 'thisiswhatfallinginlovefeelslike.jpg', 'A0009'),
('AL0011', 'Parachutes', 'parachutes.jpg', 'A0003'),
('AL0012', 'Komang', 'komang.jpg', 'A0010'),
('AL0013', 'Tenang', 'tenang.jpg', 'A0001'),
('AL0014', 'Asmalibrasi', 'asmalibrasi.jpg', 'A0011'),
('AL0015', 'Serta Mulia', 'sertamulia.jpg', 'A0012');

-- --------------------------------------------------------

--
-- Struktur dari tabel `artist`
--

CREATE TABLE `artist` (
  `artistId` varchar(45) NOT NULL,
  `artistName` varchar(45) DEFAULT NULL,
  `artistPhoto` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data untuk tabel `artist`
--

INSERT INTO `artist` (`artistId`, `artistName`, `artistPhoto`) VALUES
('A0001', 'Yura Yunita', 'yura jpg'),
('A0002', 'Afgan', 'afgan.jpg'),
('A0003', 'Coldplay', 'coldplay.jpg'),
('A0004', 'Tulus', 'tulus.jpg'),
('A0005', 'Juicy Luicy', 'juicyluicy.jpg'),
('A0006', 'Hivi!', 'hivi.jpg'),
('A0007', 'Kodaline', 'kodaline.jpg'),
('A0008', 'NIKI', 'niki.jpg'),
('A0009', 'JVKE', 'jvke.jpg'),
('A0010', 'Raim Laode', 'raimlaode.jpg'),
('A0011', 'Soegi Bornean', 'soegibornean.jpg'),
('A0012', 'Sal Priadi', 'salpriadi.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `playlist`
--

CREATE TABLE `playlist` (
  `playlistId` varchar(45) NOT NULL,
  `playlistName` varchar(45) DEFAULT NULL,
  `playlistTotalDuration` varchar(45) DEFAULT NULL,
  `user_userId` int(11) NOT NULL,
  `song_songId` varchar(45) NOT NULL,
  `song_album_albumId` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data untuk tabel `playlist`
--

INSERT INTO `playlist` (`playlistId`, `playlistName`, `playlistTotalDuration`, `user_userId`, `song_songId`, `song_album_albumId`) VALUES
('P0001', 'My Playlist', '1:00:00', 1, 'S0001', 'AL0001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `song`
--

CREATE TABLE `song` (
  `songId` varchar(45) NOT NULL,
  `songTitle` varchar(45) DEFAULT NULL,
  `songCover` varchar(45) DEFAULT NULL,
  `songDuration` varchar(45) DEFAULT NULL,
  `album_albumId` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data untuk tabel `song`
--

INSERT INTO `song` (`songId`, `songTitle`, `songCover`, `songDuration`, `album_albumId`) VALUES
('S0001', 'Panah Asmara', 'panahasmara.jpg', '4:34', 'AL0001'),
('S0002', 'The Scientist', 'thescientist.jpg', '5:09', 'AL0002'),
('S0003', 'Harus Bahagia', 'harusbahagia.jpg', '2:53', 'AL0003'),
('S0004', 'Hati - Hati di Jalan', 'hatihatidijalan.jpg', '4:02', 'AL0004'),
('S0005', 'Monokrom', 'monokrom.jpg', '3:34', 'AL0005'),
('S0006', 'Lantas', 'lantas.jpg', '3:54', 'AL0006'),
('S0007', 'Kereta Kencan', 'keretakencan.jpg', '4:17', 'AL0007'),
('S0008', 'All I Want', 'alliwant.jpg', '5:05', 'AL0008'),
('S0009', 'lowkey', 'lowkey.jpg', '2:51', 'AL0009'),
('S0010', 'golden hour', 'goldenhour.jpg', '3:29', 'AL0010'),
('S0011', 'Yellow', 'yellow.jpg', '4:26', 'AL0011'),
('S0012', 'Komang', 'komang.jpg', '3:42', 'AL0012'),
('S0013', 'Tenang', 'tenang.jpg', '4:07', 'AL0013'),
('S0014', 'Asmalibrasi', 'asmalibrasi.jpg', '4:14', 'AL0014'),
('S0015', 'Serta Mulia', 'sertamulia.jpg', '3:09', 'AL0015');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userFriends` varchar(45) DEFAULT NULL,
  `userLikedSong` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`userId`, `userName`, `userEmail`, `userPassword`, `userFriends`, `userLikedSong`) VALUES
(1, 'Matthew Julian', '2072001@maranatha.ac.id', '2072001', 'Susan', '15'),
(2, 'Jeremia Daud', '2072021@maranatha.ac.id', '2072021', 'Susan', '14'),
(3, 'John Doe', 'johndoe@email.com', 'johndoe', 'Susan', '13'),
(4, 'susanbones', 'susanbones@email.com', 'susanbones', NULL, NULL),
(5, 'frank', 'frank@email.com', '12345', NULL, NULL),
(6, 'George Stanley', 'george@email.com', '12345', NULL, NULL),
(7, 'Josh', 'josh@email.com', '12345', NULL, NULL),
(8, 'Donald', 'donald@email.com', '12345', NULL, NULL),
(9, 'Badu', 'badu@email.com', '', NULL, NULL),
(10, 'Eric', 'eric@email.com', '12345', NULL, NULL),
(11, 'Steven', 'steven@email.com', 'steven', NULL, NULL),
(12, 'Jason', 'jason@email.com', 'jason', NULL, NULL),
(13, 'Udin', 'udin@email.com', '12345', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`albumId`,`artist_artistId`),
  ADD KEY `fk_album_artist1_idx` (`artist_artistId`);

--
-- Indeks untuk tabel `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`artistId`);

--
-- Indeks untuk tabel `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`playlistId`,`user_userId`,`song_songId`,`song_album_albumId`),
  ADD KEY `fk_Playlist_user1_idx` (`user_userId`),
  ADD KEY `fk_Playlist_song1_idx` (`song_songId`,`song_album_albumId`);

--
-- Indeks untuk tabel `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`songId`,`album_albumId`),
  ADD KEY `fk_song_album1_idx` (`album_albumId`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `fk_album_artist1` FOREIGN KEY (`artist_artistId`) REFERENCES `artist` (`artistId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `fk_Playlist_song1` FOREIGN KEY (`song_songId`,`song_album_albumId`) REFERENCES `song` (`songId`, `album_albumId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Playlist_user1` FOREIGN KEY (`user_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `song`
--
ALTER TABLE `song`
  ADD CONSTRAINT `fk_song_album1` FOREIGN KEY (`album_albumId`) REFERENCES `album` (`albumId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
