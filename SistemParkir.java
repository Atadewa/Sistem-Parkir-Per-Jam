import java.util.Scanner;
public class SistemParkir {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        //Deklarasi Variabel
        String jenisKendaraan, gedung, exit;
        int idMasuk, tarifParkirAwal, tarifHelm, waktuParkir, totalPembayaran, pembayaran;

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

        //Output total Sementara
        System.out.println("Total Sementara : ");
        
        //User menginputkan waktu parkir
        System.out.print("Waktu Anda parkir (jam) \t: ");
        waktuParkir = input.nextInt();

        //Output total pembayaran 
        System.out.println("Total Pembayaran : ");

        //User melakukan pembayaran
        System.out.print("\nMasukkan nilai yang harus Anda bayar : ");
        pembayaran = input.nextInt();        

    }
}