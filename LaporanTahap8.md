# Laporan Tahap 8 - Function

## Fitur yang membutuhkan konsep function
- Menambahkan fungsi perhitungan denda
- Menambahkan fungsi perhitungan durasi parkir per jam
- Menambahkan fungsi perhitungan tarif parkir per jam

## Kondisi yang dibutuhkan
- Menambahkan fungsi bernama hitungDenda  dengan parameter (Scanner input, String kodeAwal) yang memiliki variabel counter, bertugas memberi denda jika struk hilang dan dipanggil melalui main.
- Menambahkan fungsi bernama hitungWaktu dengan parameter (int[][]waktuParkir) yang memiliki variabel durasi, dan dipanggil di dalam main untuk menentukan durasi waktu parkir. 
- Menambahkan fungsi bernama hitungTarifPerjam dengan parameter (String jenis, int[] tarifParkir, int[][]tarifJam, int waktuParkir) yang bertugas melakukan perhitungan tarif perjam sesuai hasil dari durasi waktu parkir yang ada dalam fungsi hitungWaktu, lalu dipanggil di main untuk menyimpan nilai tarif parkir.