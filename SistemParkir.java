import java.util.Scanner;

public class SistemParkir {
    
    static int hitungWaktu(int[][]waktuParkir){
        int durasi;
        if (waktuParkir[1][0] == waktuParkir[0][0]) {
            durasi = 1;
        } else {
            durasi = waktuParkir[1][0]-waktuParkir[0][0];
        }
    
        if (waktuParkir[1][0] != waktuParkir[0][0] && waktuParkir[1][1] > waktuParkir[0][1]) {
            durasi += 1;
        }
        return durasi;
    }

    static void hitungTarifPerjam (String jenis, int[] tarifParkir, int[][]tarifJam, int waktuParkir) {
        //Menentukan tarif per jam untuk motor
        if (jenis.equalsIgnoreCase("motor")) {
            if (waktuParkir == 2) {
            tarifParkir[1] = tarifJam[0][0]; //500
            } else if (waktuParkir == 3) {
            tarifParkir[1] = tarifJam[0][1]; //500+1000
            } else if (waktuParkir == 4) {
            tarifParkir[1] = tarifJam[0][2]; //500+1000+1500
            } else if (waktuParkir == 5) {
            tarifParkir[1] = tarifJam[0][3]; //500+1000+1500+2000
            } else if (waktuParkir > 5) {
            tarifParkir[1] = tarifJam[0][4]; //500+1000+1500+2000+(2000 perjam)
            } 
        } 
        
        //Menentukan tarif parkir per jam untuk mobil
        if (jenis.equalsIgnoreCase("mobil")) {
            if (waktuParkir == 2) {
            tarifParkir[1] = tarifJam[1][0]; //2000
            } else if (waktuParkir == 3) {
            tarifParkir[1] = tarifJam[1][1]; //2000+3000
            } else if (waktuParkir == 4) {
            tarifParkir[1] = tarifJam[1][2]; //2000+3000+4000
            } else if (waktuParkir == 5) {
            tarifParkir[1] = tarifJam[1][3]; //2000+3000+4000+5000
            } else if (waktuParkir > 5) {
            tarifParkir[1] = tarifJam[1][4]; //2000+3000+4000+5000+(5000 perjam)
            }            
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String isMember, jenisKendaraan, layananHelm, kode, kodeAwal, exit, kodeAkhir,strukHilang = "";
        char gedung;
        int idMasuk, totalSementara, durasi, totalPembayaran, pembayaran, denda = 0, kembalian;
        float diskon = 0, totalDiskon;

        //tarifParkirAwal, tarifParkirPerjam, tarifParkirAkhir, tarifHelm
        int tarifParkir [] = new int [4];

        //jamAwal, menitAwal
        //jamAkhir, menitAkhir
        int waktuParkir[][] = new int [2][2];

        System.out.println("============================================================");
        System.out.println("||                                                        ||");
        System.out.println("||                      SELAMAT DATANG                    ||");
        System.out.println("||                  DI PARKIRAN BOUGENVILLE               ||");
        System.out.println("||                                                        ||");
        System.out.println("============================================================");

        //User menginputkan member atau bukan
        while (true) {
            System.out.print("\nAnda pengguna umum atau member\t: ");
            isMember = input.next();
            if (isMember.equalsIgnoreCase("member")) {
                diskon = 0.1f;
                break;
            } else if (isMember.equalsIgnoreCase("umum")) {
                break;
            } else {
                System.out.println("Input Invalid!");
            }
        }

        //User menginputkan nomor polisi
        System.out.print("Masukkan ID sesuai nomor polisi\t: ");
        idMasuk = input.nextInt();
        
        //User menginputkan jenis kendaraaan untuk menentukan tarif awal parkir
        while (true) {
            System.out.print("Jenis kendaraan (motor/mobil)\t: "); 
            jenisKendaraan = input.next();
            if (jenisKendaraan.equalsIgnoreCase("motor")) {
                tarifParkir[0]=2000;

                //User memilih layanan penitipan helm 
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Apakah Anda ingin menggunakan layanan penitipan helm ? Tarif Rp2.000");   
                System.out.println("------------------------------------------------------------------------");
                while (true) {
                    System.out.print("(ya/tidak)\t\t\t: ");
                    layananHelm = input.next();
                    if (layananHelm.equalsIgnoreCase("ya")){
                        tarifParkir[2] = 2000;
                        break;
                    } else if (layananHelm.equalsIgnoreCase("tidak")){
                        break;
                    } else {
                    System.out.println("Input Invalid!");
                    }
                }
                System.out.println(""); 
                break;
            } else if (jenisKendaraan.equalsIgnoreCase("mobil")) {
                tarifParkir[0]=5000;
                System.out.println("");
                break;
            } else {
                System.out.println("Input Invalid");
            }
        }

        //User menginputkan gedung parkir
        while (true) {
            System.out.print("Lokasi Parkir ? (Gedung A/B/C)\t: ");
            gedung = input.next().charAt(0);
            if (gedung =='A' || gedung == 'B' || gedung == 'C') {
                break;
            } else {
                System.out.println("Input Invalid!");
            }   
        }

        //User menginputkan jam dan menit ketika masuk parkiran
        while (true) {
            System.out.print("Jam masuk parkir (07-22)\t: ");
            waktuParkir[0][0] = input.nextInt();
            System.out.print("Menit masuk parkir (00-59)\t: ");
            waktuParkir[0][1] = input.nextInt();
            if ( (waktuParkir[0][0] >= 7 && waktuParkir[0][0] <= 22) && (waktuParkir[0][1] >= 0 && waktuParkir[0][1] < 60)){
                break;
            } else {
                System.out.println("Inputan Invalid!\n");
            }
        }
        
        //Pembuatan kode dan perhitungan total sementara
        kodeAwal = "2939"+gedung+idMasuk;
        totalSementara = tarifParkir[0]+tarifParkir[2];
        
        //Output struk pembayaran
        System.out.println("\n===================================================================");
        System.out.println("                       STRUK PEMBAYARAN                         ");
        System.out.println("              Nomor Struk               : " + kodeAwal);        
        System.out.println("              Gedung Parkir             : " + gedung);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkir[0]);
        System.out.println("              Tarif Jam Tambahan Parkir : 0" );
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifParkir[2]);
        }
        System.out.println("              Total Sementara           : "+totalSementara);
        System.out.println("===================================================================\n");

        //User keluar parkiran 
        while (true) {
            System.out.print("\nKetik 'Exit' jika ingin keluar parkiran : ");
            exit = input.next();
            if (exit.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Input Invalid!");
            }   
        }
        
        //User memasukkan nomor struk/kode sampai benar
        //Terdapat opsi kehilangan struk setiap 3x salah memasukkan kode, dan dikenai denda 20.000
        for (int counter = 0; true ;) {
            System.out.print("Masukkan nomor struk Anda\t: ");
            kodeAkhir = input.next();
            if (kodeAkhir.equals(kodeAwal)) {
                break;
            } else {
                System.out.println("Input Invalid!");
                counter++;
            }   
            if (counter%3 == 0) {
                System.out.println("Apakah Anda kehilangan struk pembayaran");
                while (true) {
                    System.out.print("ya/tidak  : ");
                    strukHilang = input.next();
                    if (strukHilang.equalsIgnoreCase("ya")) {
                        denda = 20000;
                        break;
                    } else if (strukHilang.equalsIgnoreCase("tidak")) {
                        System.out.println("");
                        break;
                    } else {
                        System.out.println("Input Invalid!");
                    }
                }
                if (strukHilang.equalsIgnoreCase("ya")) {
                    break;
                }
            }
        }

        //User menginputkan jam dan menit ketika keluar parkiran
        System.out.println(" ");
        while (true) {
            System.out.print("Jam keluar parkir (07-22)\t: ");
            waktuParkir[1][0] = input.nextInt();
            System.out.print("Menit keluar parkir (00-59)\t: " );
            waktuParkir[1][1] = input.nextInt();
            if (( waktuParkir[1][0] >= waktuParkir[0][0] && waktuParkir[1][0] < 22) && (waktuParkir[1][1] >= 0 && waktuParkir[1][1] < 60) ) {
                break;
            } else {
                System.out.println("Input Invalid!\n");
            }           
        }

        //Perhitungan waktu selama parkir (jam)
        durasi = hitungWaktu (waktuParkir);

        //Perhitungan tarif parkir per jam
        int tarifJam [][] = {
            //Baris 1-Tarif perjam untuk motor
            {500, 1500, 3000, 5000, 5000 + (durasi-5)*2000},
            //Baris 2-Tarif perjam untuk mobil
            {2000, 5000, 9000, 14000 + (durasi-5)*5000}
        };

        //Menentukan Tarif Parkir Perjam
        hitungTarifPerjam (jenisKendaraan, tarifParkir, tarifJam, durasi);

        //Perhitungan tarif total
        tarifParkir[3] = tarifParkir[0] + tarifParkir[1] + tarifParkir[2];
        totalPembayaran = tarifParkir[3] + denda;
        totalDiskon = totalPembayaran*diskon;
        totalPembayaran -= totalDiskon;
        
        //Output nota pembayaran
        System.out.println("\n===================================================================");
        System.out.println("                         NOTA PEMBAYARAN                         ");
        System.out.println("              Nomor struk               : " + kodeAwal);
        System.out.println("              Gedung Parkir             : " + gedung);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkir[0]);
        System.out.println("              Tarif Jam Tambahan Parkir : " + tarifParkir[1]);
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifParkir[2]);
        }
        if (isMember.equalsIgnoreCase("member")) {
            System.out.println("              Diskon                    : " + (int)totalDiskon);
        }
        if (strukHilang.equalsIgnoreCase("ya")) {
            System.out.println("              Denda Kehilangan Struk    : "+denda);
        }
        System.out.println("              Total                     : " + totalPembayaran);
        System.out.println("===================================================================\n");
        System.out.println("");

        //User melakukan pembayaran 
        //Perulangan untuk melakukan pembayaran jika uang kurang dari totalPembayaran
        do {
            System.out.print("Masukkan nilai uang yang Anda bayar : ");
            pembayaran = input.nextInt();
            if (pembayaran < totalPembayaran) {
                System.out.println("Uang Anda tidak cukup");
            }  
        } while (pembayaran < totalPembayaran);

        //User menerima kembalian
        kembalian = pembayaran-totalPembayaran;
        System.out.println("Kembalian : " + kembalian);
        
        System.out.println("\n===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                        TERIMAKASIH                            ||");
        System.out.println("||                   SELAMAT DATANG KEMBALI                      ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");
   }

}