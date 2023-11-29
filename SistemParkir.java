import java.util.Scanner;
public class SistemParkir {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String isMember, jenisKendaraan, layananHelm, kode, gedung, exit;
        int idMasuk, tarifParkirAwal=0, tarifHelm=0, totalSementara, waktuParkir,tarifParkirPerjam=0, tarifParkirTotal, totalPembayaran, pembayaran, kembalian;
        int jamAwal, menitAwal, jamAkhir, menitAkhir;
        float diskon=0, totalDiskon;

        System.out.println("==============================================================");
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

        //User menginputkan nomor polisi, jenis kendaraaan, dan gedung parkir
        System.out.print("Masukkan ID sesuai nomor polisi\t: ");
        idMasuk = input.nextInt();

        while (true) {
            System.out.println("Jenis kendaraan (motor/mobil)\t: "); 
            jenisKendaraan = input.next();
            if (jenisKendaraan.equalsIgnoreCase("motor")) {
                tarifParkirAwal=2000;
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Apakah Anda ingin menggunakan layanan penitipan helm ? Tarif Rp2.000");   
                System.out.println("------------------------------------------------------------------------");
            
        //Menentukan harga tarif awal dan user memilih layanan penitipan helm 
                while (true) {
                    System.out.print("(ya/tidak)\t\t\t: ");
                    layananHelm = input.next();
                    if (layananHelm.equalsIgnoreCase("ya")){
                        tarifHelm = 2000;
                        break;
                    } else if (layananHelm.equalsIgnoreCase("tidak")){
                        break;
                    } else {
                    System.out.println("Input Invalid");
                    }
                }
                System.out.println(""); 
                break;
            } else if (jenisKendaraan.equalsIgnoreCase("mobil")) {
                tarifParkirAwal=5000;
                System.out.println("");
                break;
            } else {
                System.out.println("Input Invalid");
            }
        }

        System.out.print("Lokasi Parkir ? (Gedung A/B/C)\t: ");
        gedung = input.next();

        //User menginputkan jam dan menit ketika masuk parkiran
        System.out.print("\nJam masuk parkir (07-22)\t: ");
        jamAwal = input.nextInt();
        System.out.print("Menit masuk parkir (00-59)\t: ");
        menitAwal = input.nextInt();
        
        //Pembuatan kode
        kode = "2939"+gedung+idMasuk;
        totalSementara = tarifParkirAwal+tarifHelm;
        
        //Output struk pembayaran
        System.out.println("\n===================================================================");
        System.out.println("                       STRUK PEMBAYARAN                         ");
        System.out.println("              Nomor Struk               : " + kode);        
        System.out.println("              Gedung Parkir             : " + gedung);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkirAwal);
        System.out.println("              Tarif Jam Tambahan Parkir : 0" );
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifHelm);
        }
        System.out.println("              Total Sementara           : "+totalSementara);
        System.out.println("===================================================================\n");

        //User keluar parkiran 
        System.out.print("\nKetik 'Exit' jika ingin keluar parkiran : ");
        exit = input.next();
        
        //User menginputkan kode
        System.out.print("Masukkan nomor struk Anda\t: ");
        kode = input.next();
        
        //User menginputkan jam dan menit ketika keluar parkiran
        System.out.print("\nJam keluar parkir (07-22)\t: ");
        jamAkhir = input.nextInt();
        System.out.print("Menit keluar parkir (00-59)\t: ");
        menitAkhir = input.nextInt();

        //Perhitungan waktu selama parkir (jam)
        if (jamAkhir==jamAwal) {
            waktuParkir = 1;
        } else {
            waktuParkir = jamAkhir-jamAwal;
        }

        if (jamAkhir!=jamAwal && menitAkhir > menitAwal) {
            waktuParkir+=1;
        }

        //Perhitungan tarif parkir per jam
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            if (waktuParkir==2) {
            tarifParkirPerjam = 500; //500
            } else if (waktuParkir==3) {
            tarifParkirPerjam = 1500; //500+1000
            } else if (waktuParkir==4) {
            tarifParkirPerjam = 3000; //500+1000+1500
            } else if (waktuParkir==5) {
            tarifParkirPerjam = 5000; //500+1000+1500+2000
            } else if (waktuParkir>5) {
            tarifParkirPerjam = 5000 + (waktuParkir-5)*2000; //500+1000+1500+2000+(2000 perjam)
            } 
        } 
        
        if (jenisKendaraan.equalsIgnoreCase("mobil")) {
            if (waktuParkir==2) {
            tarifParkirPerjam = 2000; //2000
            } else if (waktuParkir==3) {
            tarifParkirPerjam = 5000; //2000+3000
            } else if (waktuParkir==4) {
            tarifParkirPerjam = 9000; //2000+3000+4000
            } else if (waktuParkir==5) {
            tarifParkirPerjam = 14000; //2000+3000+4000+5000
            } else if (waktuParkir>5) {
            tarifParkirPerjam = 14000 + (waktuParkir-5)*5000; //2000+3000+4000+5000+(5000 perjam)
            }            
        }

        //Perhitungan tarif total
        tarifParkirTotal = tarifParkirAwal + tarifParkirPerjam;
        totalPembayaran = tarifParkirTotal + tarifHelm;
        totalDiskon = totalPembayaran*diskon;
        totalPembayaran -= totalDiskon;
        
        //Output nota pembayaran 
        System.out.println("\n===================================================================");
        System.out.println("                         NOTA PEMBAYARAN                         ");
        System.out.println("              Nomor struk               : " + kode);
        System.out.println("              Gedung Parkir             : " + gedung);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkirAwal);
        System.out.println("              Tarif Jam Tambahan Parkir : " + tarifParkirPerjam);
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifHelm);
        }
        if (isMember.equalsIgnoreCase("member")) {
            System.out.println("              Diskon                    : " + (int)totalDiskon);
        }
        System.out.println("              Total                     : " + totalPembayaran);
        System.out.println("===================================================================\n");

        //User melakukan pembayaran dan menerima kembalian 
        System.out.print("\nMasukkan nilai yang Anda bayar : ");
        pembayaran = input.nextInt();   
        kembalian = pembayaran-totalPembayaran;
        System.out.println("Kembalian : "+kembalian);
        
        System.out.println("\n===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                        TERIMAKASIH                            ||");
        System.out.println("||                   SELAMAT DATANG KEMBALI                      ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");

    }
}