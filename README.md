# SPK_Penerimaan_Karyawan_Paruh_Waktu_Metode_Analytical_Hierarchy_Process_AHP-Skripsi
DSS (Decision Support System) Sistem Penerimaan Karyawan Paruh Waktu Menggunakan Analytical Hierarchy Process AHP adalah aplikasi sistem pendukung keputusan yang merupakan penelitian berbasis pengetahuan atau turunan dari AI (Artificial Intelligence) dengan perhitungan dan bantuan AHP (Analytical Hierarchy Process) algoritma.

Sistem ini dirancang untuk mengatasi permasalahan yang ada pada Apotek Sanba Jakarta dalam kajian penelitian skripsi. Aplikasi ini berbasis desktop, dan dikembangkan dengan menggunakan bahasa pemrograman Java editor kode IDE Netbeans. database menggunakan phpmyadmin atau MySQL, library yang digunakan adalah JDBC, IReports.

# Screenshot Applikasi
<details>
  <summary>Login & SignUp</summary>
  <img src="/../main/Screenshot/1.jpg" name="login">
  <img src="/../main/Screenshot/2.jpg" name="register">
</details>
<details>
  <summary>Menu Utama</summary>
  <img src="/../main/Screenshot/3.jpg" name="menu-utama">
</details>
<details>
  <summary>Form Input</summary>
  <img src="/../main/Screenshot/4.jpg" name="calon-pelamar">
  <img src="/../main/Screenshot/5.jpg" name="tambah-calon-pelamar">
  <img src="/../main/Screenshot/6.jpg" name="kriteria">
  <img src="/../main/Screenshot/7.jpg" name="subkriteria">
  <img src="/../main/Screenshot/8.jpg" name="ranking">
  <img src="/../main/Screenshot/9.jpg" name="perhitungan-ahp">
</details>
<details>
  <summary>Report/Laporan</summary>
  <img src="/../main/Screenshot/10.jpg" name="report-calon-pelamar">
  <img src="/../main/Screenshot/11.jpg" name="report-kriteria">
  <img src="/../main/Screenshot/12.jpg" name="report-subkriteria">
  <img src="/../main/Screenshot/13.jpg" name="report-hasil-seleksi">
</details>

# Pengunaan Aplikasi
1. Upload / import SQL file di Folder DATABASE pada PhpMyAdmin atau dll.
2. Buka aplikasi DSS_PenerimaanKaryawanParuhWaktu yang berformat JAR, pada folder “DSS_PenerimaanKaryawanParuhWaktu/dist/”.
3. Tampilan menu login akan yang pertama muncul saat menjalankan aplikasi, masukkan akun user dan password yang sesuai. Jika belum memiliki akun, klik register untuk membuat akun baru.
4. Setelah berhasil masuk pada menu login, tampilan selanjutnya akan menampilkan tampilan menu utama. Dalam menu utama pilih menu yang ingin pengguna jalankan.
   - Menu Data Calon Pelamar
Dalam menu ini pengguna dapat melihat data tabel yang merupakan data dari calon pelamar yang telah disimpan di dalam aplikasi. Pengguna dapat menambahkan data calon pelamar dengan klik tombol tambah data calon pelamar, serta pada tabel tersebut dapat menghapus atau mengedit data yang telah di input.
   - Menu Kriteria
Dalam menu ini, jika pengguna mengklik tombol menu kriteria, akan menampilkan tombol lain yang berada di menu tersebut. Menu pengaturan prioritas kriteria untuk pengguna input bobot kepentingan dari kriteria yang tersedia, dan menu pengaturan prioritas subkriteria untuk pengguna input bobot kepentingan sub-kriteria pada kriteria yang terkait.
   - Menu Seleksi
Dalam menu seleksi, pengguna akan disuguhkan tabel data ranking hasil seleksi yang telah dikelola oleh program serta telah tersimpan di aplikasi. Untuk memulai seleksi dari data yang dibutuhkan oleh program seperti data calon pelamar, data pengaturan kriteria, serta data pengaturan sub-kriteria, pengguna dapat klik tombol mulai penilaian calon pelamar metode AHP. Selanjutnya akan menampilkan sebuah dialog untuk melakukan seleksi, dengan cara pilih nomor id dari calon pelamar serta nama calon pelamar tersebut. Kemudian klik mulai hitung untuk mendapatkan nilai dari matriks berpasangan, nilai matriks normalisasi, nilai vektor prioritas, nilai vektor prioritas sub-kriteria, dan nilai total penilaian calon pelamar. Simpan data hasil perhitungan tersebut untuk menyimpan serta menentukan ranking dari hasil penilaian calon pelamar yang tersedia.
    - Menu Cetak Laporan
Untuk mendapatkan laporan dari data hasil input dan data hasil kelola oleh program, pengguna mengklik tombol menu cetak laporan yang kemudian akan memunculkan tombol lain, yaitu laporan calon pelamar untuk mendapatkan data seluruh calon pelamar yang telah di input, laporan perioritas kriteria untuk mendapatkan data pengaturan bobot kepentingan kriteria, laporan prioritas sub-kriteria untuk mendapatkan data pengaturan bobot sub-kriteria, dan terakhir laporan hasil seleksi untuk mendapatkan data hasil seleksi calon pelamar dengan ranking urutan hasil penilaian calon pelamar tersebut.
    - Tombol Log out
Tombol log out yang berada pada navigasi menu, pengguna dapat keluar aplikasi, jika pengguna klik tombol log out, program akan kembali ke menu login.

# Spesifikasi Software yang digunankan
- Netbeans IDE 8.0
- XAMPP 7.4.28 (Apache, MysQL, PHP & Perl)
- IReport 5.5.0 (JasperReport Lib Netbeans IDE)

# Author
- Naufal Sholahuddin
