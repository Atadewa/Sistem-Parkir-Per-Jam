import java.util.Scanner;
public class SistemParkir {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String isMember, jenisKendaraan, layananHelm, kode, gedung, exit;
        int idMasuk, tarifParkirAwal=0, tarifHelm=0, totalSementara, waktuParkir,tarifParkirPerjam, tarifParkirTotal, totalPembayaran, pembayaran, kembalian;
        int jamAwal, menitAwal, jamAkhir, menitAkhir;
        float diskon=0, totalDiskon;

        System.out.println("==============================================================");
        System.out.println("||                                                        ||");
        System.out.println("||                      SELAMAT DATANG                    ||");
        System.out.println("||                  DI PARKIRAN BOUGENVILLE               ||");
        System.out.println("||                                                        ||");
        System.out.println("============================================================");

        //User menginputkan member atau bukan
        System.out.print("\nAnda pengguna umum atau member\t: ");
        isMember = input.next();
        if (isMember.equalsIgnoreCase("member")) {
            diskon = 0.1f;
        } else if (isMember.equalsIgnoreCase("umum")) {
            diskon = 0;
        }

        //User menginputkan nomor polisi, jenis kendaraaan, dan gedung parkir
        System.out.print("Masukkan ID sesuai nomor polisi\t: ");
        idMasuk = input.nextInt();
        System.out.println("Tarif motor : 2000"); 
        System.out.println("Tarif mobil : 5000"); 
        System.out.print("Masukkan jenis kendaraan Anda\t: ");
        jenisKendaraan = input.next();
        System.out.print("Lokasi Parkir ? (Gedung A/B/C)\t: ");
        gedung = input.next();

        //Menentukan harga tarif awal dan user memilih layanan penitipan helm 
        if (jenisKendaraan.equalsIgnoreCase("motor")){
            tarifParkirAwal=2000;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Apakah Anda ingin menggunakan layanan penitipan helm ? Tarif Rp2.000");   
            System.out.println("------------------------------------------------------------------------");
            System.out.print("(ya/tidak)\t\t\t: ");
            layananHelm = input.next();
            if (layananHelm.equalsIgnoreCase("ya")){
                tarifHelm = 2000;
            }
        } else if (jenisKendaraan.equalsIgnoreCase("mobil")){
            tarifParkirAwal=5000;
        }
        
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
        
        //Perhitungan tarif total
        tarifParkirPerjam = (waktuParkir-1)*1000;
        tarifParkirTotal = tarifParkirAwal + tarifParkirPerjam;
        totalPembayaran = tarifParkirTotal + tarifHelm;
        totalDiskon = totalPembayaran*diskon;
        totalPembayaran -=totalDiskon;
        
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