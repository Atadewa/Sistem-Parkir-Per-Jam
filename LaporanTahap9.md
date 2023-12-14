# Laporan Tahap 9 - Penambahan Menu

Sistem Parkir Perjam adalah sebuah sistem parkir sederhana yang memungkinkan pengguna untuk melakukan beberapa operasi, seperti masuk parkir, keluar parkir, memeriksa tempat parkir, dan keluar dari program. Seluruh program dijalankan dalam loop do-while, sehingga pengguna dapat memilih menu berulang kali sampai mereka memilih untuk keluar dari program. Berikut adalah deskripsi dari empat menu utama yang ada dalam program ini:

## 1. Masuk Parkir
- Pengguna diminta untuk memilih apakah mereka pengguna umum atau member.
- Kemudian, pengguna diminta untuk memasukkan ID sesuai dengan nomor polisi kendaraan.
- Pengguna harus memasukkan jenis kendaraan (motor/mobil) untuk menentukan tarif awal parkir.
- Jika kendaraan adalah motor, pengguna diberikan opsi untuk menggunakan layanan penitipan helm.
- Pengguna diminta untuk memasukkan jam dan menit saat masuk parkir.
- Kode awal parkir dibuat berdasarkan gedung parkir, ID kendaraan, dan sejumlah informasi lainnya.
- Output struk pembayaran mencakup informasi tentang nomor struk, gedung parkir, tarif awal parkir, tarif penitipan helm (jika motor), dan total sementara.

## 2. Keluar Parkir
- Pengguna diminta untuk memasukkan nomor struk parkir.
- Jika nomor struk valid, pengguna diminta untuk memasukkan jam dan menit saat keluar parkir.
- Durasi parkir dihitung berdasarkan waktu masuk dan keluar.
- Tarif per jam dihitung berdasarkan jenis kendaraan dan durasi parkir.
- Total pembayaran dihitung termasuk tarif awal parkir, tarif jam tambahan, tarif penitipan helm (jika motor), denda (jika kehilangan struk), dan diskon (jika pengguna adalah member).
- Output nota pembayaran mencakup informasi tentang nomor struk, gedung parkir, tarif awal parkir, tarif jam tambahan, tarif penitipan helm (jika motor), diskon (jika member), denda (jika kehilangan struk), dan total pembayaran.

## 3. Cek Tempat Parkir
- Menampilkan kapasitas tempat parkir untuk motor dan mobil pada setiap gedung.

## 4. Keluar Program 
- Menampilkan laporan data parkir, termasuk jenis kendaraan, status member, nomor struk, waktu parkir, total pembayaran, dan status pembayaran.
- Informasi ini ditampilkan dalam bentuk tabel.
