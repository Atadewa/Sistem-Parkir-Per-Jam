# Laporan Tahap 1 - Variabel dan Operasis

## Identifikasi Variabel

| String         | int               | float       |
|----------------|-------------------|-------------|
| isMember       | idMasuk           | diskon      |
| jenisKendaraan | tarifParkirAwal   | totalDiskon |
| kode           | tarifHelm         |             |
| gedung         | totalSementara    |             |
| exit           | waktuParkir       |             |
|                | tarifParkirPerjam |             |
|                | tarifParkirTotal  |             |
|                | totalPembayaran   |             |
|                | pembayaran        |             |
|                | kembalian         |             |

## Implementasi Operasi

| Variabel          | Operasi                                    | 
|-------------------|--------------------------------------------|
| kode              | "2939" + gedung + idMasuk                  |
| totalSementara    | tarifParkirAwal+tarifHelm                  |
| tarifParkirPerjam | (waktuParkir-1)*1000                       | 
| tarifParkirTotal  | tarifParkirAwal + tarifParkirPerjam        |
| totalDiskon       | totalPembayaran*diskon                     |
| totalPembayaran   | tarifParkirTotal + tarifHelm - totalDiskon |
| kembalian         | pembayaran - totalPembayaran               |