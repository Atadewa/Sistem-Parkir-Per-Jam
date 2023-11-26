import java.util.Scanner;
public class SistemParkir {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String isMember, jenisKendaraan, kode, gedung, exit;
        int idMasuk, tarifParkirAwal, tarifHelm, totalSementara, waktuParkir,tarifParkirPerjam, tarifParkirTotal, totalPembayaran, pembayaran, kembalian;
        float diskon, totalDiskon;

        //User menginputkan member atau bukan
        System.out.print("\nAnda pengguna umum atau member\t: ");
        isMember = input.nextLine();
        System.out.println("Jika anda member, masukkan 0.1; jika bukan, ,masukkan 0");
        System.out.print("Diskon\t\t\t\t:");
        diskon = input.nextFloat();

        //User menginputkan nomor polisi, jenis kendaraaan, dan gedung parkir
        System.out.print("Masukkan ID sesuai nomor polisi\t: ");
        idMasuk = input.nextInt();
        System.out.print("Masukkan jenis kendaraan Anda\t: ");
        input.nextLine();
        jenisKendaraan = input.nextLine(); 
        System.out.print("Masukkan tarif awal (2000/5000)\t: ");
        tarifParkirAwal = input.nextInt();
        System.out.print("Lokasi Parkir ? (Gedung A/B/C)\t: ");
        input.nextLine();
        gedung = input.nextLine();

        //User memilih layanan penitipan helm
        System.out.println("Apakah Anda ingin menggunakan layanan penitipan helm ?");   
        System.out.println("Tarif = Rp2.000 (Ketik 2000 untuk 'iya' atau ketik 0 untuk 'tidak')") ;
        System.out.print("Jawaban\t\t\t\t: ");
        tarifHelm = input.nextInt();

        //Pembuatan kode
        kode = "2939"+gedung+idMasuk;
        totalSementara = tarifParkirAwal+tarifHelm;

        //User keluar parkiran 
        System.out.print("\nKetik 'Exit' jika ingin keluar parkiran : ");
        input.nextLine();
        exit = input.nextLine();

        //Output Nomor struk dan total Sementara
        System.out.println("Nomor struk : " + kode);
        System.out.println("Total Sementara : "+totalSementara);
        
        //User menginputkan kode dan waktu parkir
        System.out.print("Masukkan nomor struk Anda\t: ");
        kode = input.nextLine();
        System.out.print("Waktu Anda parkir (jam) \t: ");
        waktuParkir = input.nextInt();

        //Perhitungan tarif total
        tarifParkirPerjam = (waktuParkir-1)*1000;
        tarifParkirTotal = tarifParkirAwal + tarifParkirPerjam;
        totalPembayaran = tarifParkirTotal + tarifHelm;
        totalDiskon = totalPembayaran*diskon;
        totalPembayaran -=totalDiskon;

        //Output total pembayaran 
        System.out.println("Total Pembayaran : "+totalPembayaran);

        //User melakukan pembayaran dan menerima kembalian 
        System.out.print("\nMasukkan nilai yang harus Anda bayar : ");
        pembayaran = input.nextInt();   
        kembalian = pembayaran-totalPembayaran;
        System.out.println("Kembalian : "+kembalian);  

    }
}