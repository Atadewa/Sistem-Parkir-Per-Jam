# Laporan Tahap 3 - Pemilihan Bersarang

## Fitur yang membutuhkan konsep pemilihan bersarang
- Menentukan tarif parkir awal dan adanya tawaran layanan penitipan helm untuk pengguna motor.
- Menentukan tarif parkir per jam dari jenis kendaraan motor dan mobil.

## Kondisi yang dibutuhkan
- Jika jenis kendaraan motor (tarif parkir awal) :
<br>
User dikenakan tarif parkir awal 2000 dan akan mendapatkan tawaran layanan 
penitipan helm. Jika user menyetujui layanan penitipan helm, maka dikenakan tarif 
sebesar 2000.

- Jika jenis kendaraan mobil (tarif parkir awal) :
<br>
User dikenakan tarif awal parkir 5000 dan tidak akan mendapatkan tawaran layanan 
penitipan helm.

- Jika jenis kendaraan motor (tarif parkir per jam) :
    - Jika waktu parkir == 2 jam, maka tarif parkir perjamnyaa sebesar 500
    - Jika waktu parkir == 3 jam, maka tarif parkir perjamnyaa sebesar 1500
    - Jika waktu parkir == 4 jam, maka tarif parkir perjamnyaa sebesar 3000
    - Jika waktu parkir == 5 jam, maka tarif parkir perjamnyaa sebesar 5000
    - Jika waktu parkir > 5 jam, maka tarif parkir perjamnyaa sebesar 5000 + (waktu parkir - 5) * 2000

- Jika jenis kendaraan mobil (tarif parkir per jam) :
    - Jika waktu parkir == 2 jam, maka tarif parkir perjamnyaa sebesar 2000
    - Jika waktu parkir == 3 jam, maka tarif parkir perjamnyaa sebesar 5000
    - Jika waktu parkir == 4 jam, maka tarif parkir perjamnyaa sebesar 9000
    - Jika waktu parkir == 5 jam, maka tarif parkir perjamnyaa sebesar 14000
    - Jika waktu parkir > 5 jam, maka tarif parkir perjamnyaa sebesar 14000 + (waktu parkir - 5) * 5000


