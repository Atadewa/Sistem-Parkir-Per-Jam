# Laporan Tahap 2 - Pemilihan

## Fitur yang membutuhkan konsep pemilihan 
- Menentukan diskon untuk member
- Menentukan tarif parkir awal
- Menawarkan layanan penitipan helm
- Menentukan tarif layanan penitipan helm
- Menampilkan tarif layanan penitipan helm
- Menentukan lama waktu parkir
- Menentukan tarif parkir per jam

## Kondisi yang dibutuhkan
- Jika user adalah member, maka akan mendapatkan diskon 10%. Jika user bukan 
member, maka tidak mendapatkan diskon.
- Jika user menggunakan motor, maka tarif awal parkir 2000. Jika user menggunakan 
mobil, maka tarif awal parkir 5000.
- Jika user menggunakan motor, maka akan ditawarkan layanan penitipan helm. Jika 
user menggunakan mobil, maka tidak akan mendapatkan tawaran layanan penitipan 
helm.
- Jika user menggunakan layanan penitipan helm, maka tarifnya 2000. Jika user tdiak 
menggunakan layanan tersebut, maka tarif 0.
- Jika user menggunakan motor, maka akan ditampilkan tarif layanan penitipan helm. 
Jika user menggunakan mobil, maka system tidak menampilkan tarif layanan 
penitipan helm.
- Jika jam akhir parkir = jam awal parkir, maka waktu parkir = 1. Jika jam akhir 
parkir != jam awal parkir, maka waktu parkir = jam akhir parkir -jam awal parkir. 
Selanjutnya, jika jam akhir parkir != jam awal parkir dan menit dari jam akhir parkir 
lebih dari menit dari jam awal parkir, maka waktu parkir + 1.