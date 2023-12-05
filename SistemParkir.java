import java.util.Scanner;
public class SistemParkir {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String isMember, jenisKendaraan, layananHelm, kode, kodeAwal, exit, kodeAkhir,strukHilang = "";
        char gedung;
        int idMasuk, totalSementara, waktuParkir, totalPembayaran, pembayaran, denda = 0, kembalian;
        int jamAwal, menitAwal, jamAkhir, menitAkhir;
        float diskon = 0, totalDiskon;

        //tarifParkirAwal, tarifParkirPerjam, tarifParkirAkhir, tarifHelm
        int tarifParkir [] = new int [4];

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
            jamAwal = input.nextInt();
            System.out.print("Menit masuk parkir (00-59)\t: ");
            menitAwal = input.nextInt();
            if ( (jamAwal >= 7 && jamAwal <= 22) && (menitAwal >= 0 && menitAwal < 60)){
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
            jamAkhir = input.nextInt();
            System.out.print("Menit keluar parkir (00-59)\t: " );
            menitAkhir = input.nextInt();
            if (( jamAkhir >= jamAwal && jamAkhir < 22) && (menitAkhir >= 0 && menitAkhir < 60) ) {
                break;
            } else {
                System.out.println("Input Invalid!\n");
            }

            
        }
        //Perhitungan waktu selama parkir (jam)
        if (jamAkhir == jamAwal) {
            waktuParkir = 1;
        } else {
            waktuParkir = jamAkhir-jamAwal;
        }

        if (jamAkhir != jamAwal && menitAkhir > menitAwal) {
            waktuParkir += 1;
        }

        //Perhitungan tarif parkir per jam
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            if (waktuParkir == 2) {
            tarifParkir[1] = 500; //500
            } else if (waktuParkir == 3) {
            tarifParkir[1] = 1500; //500+1000
            } else if (waktuParkir == 4) {
            tarifParkir[1] = 3000; //500+1000+1500
            } else if (waktuParkir == 5) {
            tarifParkir[1] = 5000; //500+1000+1500+2000
            } else if (waktuParkir > 5) {
            tarifParkir[1] = 5000 + (waktuParkir-5)*2000; //500+1000+1500+2000+(2000 perjam)
            } 
        } 
        
        if (jenisKendaraan.equalsIgnoreCase("mobil")) {
            if (waktuParkir == 2) {
            tarifParkir[1] = 2000; //2000
            } else if (waktuParkir == 3) {
            tarifParkir[1] = 5000; //2000+3000
            } else if (waktuParkir == 4) {
            tarifParkir[1] = 9000; //2000+3000+4000
            } else if (waktuParkir == 5) {
            tarifParkir[1] = 14000; //2000+3000+4000+5000
            } else if (waktuParkir > 5) {
            tarifParkir[1] = 14000 + (waktuParkir-5)*5000; //2000+3000+4000+5000+(5000 perjam)
            }            
        }

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