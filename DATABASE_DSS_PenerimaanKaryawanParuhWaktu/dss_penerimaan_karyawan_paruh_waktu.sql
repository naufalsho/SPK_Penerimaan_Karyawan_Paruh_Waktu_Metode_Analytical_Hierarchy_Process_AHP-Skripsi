-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Agu 2022 pada 06.58
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dss_penerimaan_karyawan_paruh_waktu`
--
DROP DATABASE IF EXISTS `dss_penerimaan_karyawan_paruh_waktu`;
CREATE DATABASE IF NOT EXISTS `dss_penerimaan_karyawan_paruh_waktu` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dss_penerimaan_karyawan_paruh_waktu`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` char(3) NOT NULL,
  `namalengkap` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `namalengkap`, `user`, `password`) VALUES
('001', 'Naufal Sholahuddin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `biodata_kandidat`
--

CREATE TABLE `biodata_kandidat` (
  `no_id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jeniskel` varchar(50) NOT NULL,
  `usia` int(5) NOT NULL,
  `pendidikan_terakhir` varchar(50) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `alamat` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `biodata_kandidat`
--

INSERT INTO `biodata_kandidat` (`no_id`, `nama`, `jeniskel`, `usia`, `pendidikan_terakhir`, `no_hp`, `alamat`) VALUES
(1, '1', 'Laki-Laki', 1, 'S1', '085XXXX', '1'),
(2, 'Nama2', 'Perempuan', 21, 'S1', '085XXX', 'Bogor'),
(3, 'Nama3', 'Laki-Laki', 12, 'SD', '085XX', 'Jakarta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `bobot_kandidat`
--

CREATE TABLE `bobot_kandidat` (
  `no_id` int(5) NOT NULL,
  `nilai_wawancara` int(5) NOT NULL,
  `waktu_luang` varchar(100) NOT NULL,
  `sikap1` varchar(100) NOT NULL,
  `sikap2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bobot_kandidat`
--

INSERT INTO `bobot_kandidat` (`no_id`, `nilai_wawancara`, `waktu_luang`, `sikap1`, `sikap2`) VALUES
(1, 100, 'PAGI', 'GOOD', 'JUJUR'),
(2, 90, 'Item 2', 'Item 2', 'Item 2'),
(3, 100, 'Item 2', 'Item 2', 'Item 2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `calon_pelamar`
--

CREATE TABLE `calon_pelamar` (
  `no_id` varchar(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jeniskel` varchar(30) NOT NULL,
  `pendidikan_terakhir` varchar(20) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nilai_wawancara` int(3) NOT NULL,
  `waktu_luang` varchar(20) NOT NULL,
  `sikap` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `calon_pelamar`
--

INSERT INTO `calon_pelamar` (`no_id`, `nama`, `jeniskel`, `pendidikan_terakhir`, `no_hp`, `alamat`, `nilai_wawancara`, `waktu_luang`, `sikap`) VALUES
('01', 'Heru', 'Laki-Laki', 'D3', '085xxx', 'Bogor', 80, 'SIANG', 'Loyalitas Tinggi'),
('02', 'Fitria', 'Perempuan', 'S1', '08xxx', 'Jakarta', 60, 'PAGI', 'Jujur'),
('03', 'Laswi', 'Laki-Laki', 'SMP dan ke bawah', '0838xxx', 'Depok', 90, 'PAGI', 'Jujur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kriteria`
--

CREATE TABLE `kriteria` (
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kriteria`
--

INSERT INTO `kriteria` (`kd_kriteria`, `nama_kriteria`, `prioritas_kepentingan`) VALUES
('K1', 'Sikap', 'Sangat Penting ke-1'),
('K2', 'Waktu Luang', 'Penting ke-2'),
('K3', 'Wawancara', 'Cukup Penting ke-3'),
('K4', 'Pendidikan Terakhir', 'Biasa ke-4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `register`
--

CREATE TABLE `register` (
  `id` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `register`
--

INSERT INTO `register` (`id`, `email`, `user`, `password`) VALUES
(1, 'mail@gmail.com', 'admin', 'admin'),
(2, '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `seleksi`
--

CREATE TABLE `seleksi` (
  `no_id` char(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `hasil_penilaian` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `seleksi`
--

INSERT INTO `seleksi` (`no_id`, `nama`, `no_hp`, `hasil_penilaian`) VALUES
('01', 'Heru', '085xxx', '0.20'),
('02', 'Fitria', '08xxx', '0.91'),
('03', 'Laswi', '0838xxx', '0.96');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sub_kriteria`
--

CREATE TABLE `sub_kriteria` (
  `no_sub` int(3) NOT NULL,
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `nama_sub_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `sub_kriteria`
--

INSERT INTO `sub_kriteria` (`no_sub`, `kd_kriteria`, `nama_kriteria`, `nama_sub_kriteria`, `prioritas_kepentingan`) VALUES
(1, 'K4', 'Pendidikan Terakhir', 'S1', 'Sangat Penting ke-1'),
(2, 'K4', 'Pendidikan Terakhir', 'D3', 'Penting ke-2'),
(3, 'K4', 'Pendidikan Terakhir', 'SMA', 'Cukup Penting ke-3'),
(4, 'K4', 'Pendidikan Terakhir', 'SMP dan Kebawah', 'Biasa ke-4'),
(5, 'K3', 'Wawancara', 'Lebih Dari 80', 'Sangat Penting ke-1'),
(6, 'K3', 'Wawancara', 'Lebih Dari 60', 'Cukup Penting ke-2'),
(7, 'K3', 'Wawancara', 'Kurang Atau Sama Dengan 60', 'Biasa ke-3'),
(8, 'K2', 'Waktu Luang', 'PAGI', 'Sangat Penting ke-1'),
(9, 'K2', 'Waktu Luang', 'SIANG', 'Cukup Penting ke-2'),
(10, 'K2', 'Waktu Luang', 'SORE', 'Biasa ke-3'),
(11, 'K1', 'Sikap', 'Jujur', 'Sangat Penting ke-1'),
(12, 'K1', 'Sikap', 'Amanah', 'Penting ke-2'),
(13, 'K1', 'Sikap', 'Tanggung Jawab', 'Cukup Penting ke-3'),
(14, 'K1', 'Sikap', 'Loyalitas Tinggi', 'Biasa ke-4');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `biodata_kandidat`
--
ALTER TABLE `biodata_kandidat`
  ADD PRIMARY KEY (`no_id`);

--
-- Indeks untuk tabel `bobot_kandidat`
--
ALTER TABLE `bobot_kandidat`
  ADD UNIQUE KEY `no_id` (`no_id`);

--
-- Indeks untuk tabel `calon_pelamar`
--
ALTER TABLE `calon_pelamar`
  ADD PRIMARY KEY (`no_id`);

--
-- Indeks untuk tabel `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`kd_kriteria`);

--
-- Indeks untuk tabel `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `seleksi`
--
ALTER TABLE `seleksi`
  ADD UNIQUE KEY `no_id` (`no_id`);

--
-- Indeks untuk tabel `sub_kriteria`
--
ALTER TABLE `sub_kriteria`
  ADD PRIMARY KEY (`no_sub`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `biodata_kandidat`
--
ALTER TABLE `biodata_kandidat`
  MODIFY `no_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `register`
--
ALTER TABLE `register`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
