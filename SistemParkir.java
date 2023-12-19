import java.util.Scanner;

public class SistemParkir {

    // Deklarasi variabel
    static String layananHelm, exit, strukHilang = "", kodeAkhir;
    static int urutanMasuk = 0, urutanKeluar = 0, menu, jmlKendaraan = 0, kembalian, nopol;
    static float totalDiskon;

    // Deklarasi array
    static String isMember[] = new String[20000];
    static String jenisKendaraan[] = new String[20000];
    static String kodeAwal[] = new String[20000];
    static String hurufParkir[] = new String[20000];
    static boolean gedungMotor[] = new boolean[50];
    static boolean gedungMobil[] = new boolean[25];
    static char gedung[] = new char[20000];
    static float diskon[] = new float[20000];
    static int idMasuk[] = new int[20000];
    static int tarifParkir[][] = new int[20000][4];
    static int waktuParkir[][] = new int[20000][4];
    static int kapasitasGedung[] = {50,25};
    static int angkaParkir[] = new int[20000];
    static int kodeTempatParkir[] = new int[20000];
    static int durasi[] = new int[20000];
    static int totalSementara[] = new int[20000];
    static int denda[] = new int[20000];
    static int totalPembayaran[] = new int[20000];
    static int pembayaran[] = new int[20000];

    // Function dari menu 1 (Masuk parkir)
    static void menuMasukParkir() {

        Scanner input = new Scanner(System.in);

        // User menginputkan member atau bukan
        while (true) {
            System.out.print("Anda pengguna umum atau member\t: ");
            isMember[urutanMasuk] = input.next();
            if (isMember[urutanMasuk].equalsIgnoreCase("member")) {
                diskon[urutanMasuk] = 0.1f;
                break;
            } else if (isMember[urutanMasuk].equalsIgnoreCase("umum")) {
                break;
            } else {
                System.out.println("Input Invalid!\n");
            }
        }

        // User menginputkan nomor polisi
        System.out.print("Masukkan ID sesuai nomor polisi\t: ");
        idMasuk[urutanMasuk] = input.nextInt();

        // User menginputkan jenis kendaraaan untuk menentukan tarif awal parkir
        while (true) {
            System.out.print("Jenis kendaraan (motor/mobil)\t: ");
            jenisKendaraan[urutanMasuk] = input.next();
            if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("motor")) {
                tarifParkir[urutanMasuk][0] = 2000;
                gedung[urutanMasuk] = 'A';
                kapasitasGedung[0]--;

                // User memilih layanan penitipan helm jika jenis kendaraan motor
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Apakah Anda ingin menggunakan layanan penitipan helm ? Tarif Rp2.000");
                System.out.println("------------------------------------------------------------------------");
                while (true) {
                    System.out.print("(ya/tidak)\t\t\t: ");
                    layananHelm = input.next();
                    if (layananHelm.equalsIgnoreCase("ya")) {
                        tarifParkir[urutanMasuk][2] = 2000;
                        break;
                    } else if (layananHelm.equalsIgnoreCase("tidak")) {
                        break;
                    } else {
                        System.out.println("Input Invalid!");
                    }
                }
                System.out.println("");
                break;
            } else if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("mobil")) {
                tarifParkir[urutanMasuk][0] = 5000;
                gedung[urutanMasuk] = 'B';
                kapasitasGedung[1]--;
                System.out.println("");
                break;
            } else {
                System.out.println("Input Invalid");
            }
        }

        
        // User menginputkan jam dan menit ketika masuk parkiran
        while (true) {
            System.out.print("Jam masuk parkir (07-22)\t: ");
            waktuParkir[urutanMasuk][0] = input.nextInt();
            System.out.print("Menit masuk parkir (00-59)\t: ");
            waktuParkir[urutanMasuk][1] = input.nextInt();
            if ((waktuParkir[urutanMasuk][0] >= 7 && waktuParkir[urutanMasuk][0] <= 22) && (waktuParkir[urutanMasuk][1] >= 0 && waktuParkir[urutanMasuk][1] < 60)) {
                break;
            } else {
                System.out.println("Inputan Invalid!\n");
            }
        }

        //User memilih tempat parkir
        if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("motor")) {
            cekDenahParkirMotor();
            while (true) {
                System.out.println("\nSilahkan Pilih Tempat Parkir");
                System.out.print("Huruf (A-J): ");
                hurufParkir[urutanMasuk] = input.next();
                System.out.print("Angka (1-5): ");
                angkaParkir[urutanMasuk] = input.nextInt();
                
                if ((hurufParkir[urutanMasuk].equals("A") || 
                hurufParkir[urutanMasuk].equals("B")|| 
                    hurufParkir[urutanMasuk].equals("C")|| 
                    hurufParkir[urutanMasuk].equals("D")|| 
                    hurufParkir[urutanMasuk].equals("E")|| 
                    hurufParkir[urutanMasuk].equals("F")|| 
                    hurufParkir[urutanMasuk].equals("G")|| 
                    hurufParkir[urutanMasuk].equals("H")|| 
                    hurufParkir[urutanMasuk].equals("I")|| 
                    hurufParkir[urutanMasuk].equals("J")) && (
                    angkaParkir[urutanMasuk] == 1 ||    
                    angkaParkir[urutanMasuk] == 2 ||    
                    angkaParkir[urutanMasuk] == 3 ||    
                    angkaParkir[urutanMasuk] == 4 ||    
                    angkaParkir[urutanMasuk] == 5 )) {

                    isiTempatParkir();

                    if (gedungMotor[kodeTempatParkir[urutanMasuk]] == true) {
                        System.out.println("Sudah terisi oleh kendaraan lain!");
                        continue;
                    } else {
                        gedungMotor[kodeTempatParkir[urutanMasuk]] = true;
                        break;
                    }
                    
                } else {
                    System.out.println("Input Invalid!");
                } 
            }
        }

        if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("mobil")) {
            cekDenahParkirMobil();
            while (true) {
                System.out.println("\nSilahkan Pilih Tempat Parkir");
                System.out.print("Huruf (K-O) : ");
                hurufParkir[urutanMasuk] = input.next();
                System.out.print("Angka (6-10): ");
                angkaParkir[urutanMasuk] = input.nextInt();

                if ((hurufParkir[urutanMasuk].equals("K") || 
                hurufParkir[urutanMasuk].equals("L")|| 
                hurufParkir[urutanMasuk].equals("M")|| 
                hurufParkir[urutanMasuk].equals("N")|| 
                hurufParkir[urutanMasuk].equals("O")) && (
                    angkaParkir[urutanMasuk] == 6 ||    
                    angkaParkir[urutanMasuk] == 7 ||    
                    angkaParkir[urutanMasuk] == 8 ||    
                    angkaParkir[urutanMasuk] == 9 ||    
                    angkaParkir[urutanMasuk] == 10 )) {
                        
                        isiTempatParkir();
                        
                        if (gedungMobil[kodeTempatParkir[urutanMasuk]] == true) {
                            System.out.println("Sudah terisi oleh kendaraan lain!");
                            continue;
                        } else {
                            gedungMobil[kodeTempatParkir[urutanMasuk]] = true;
                            break;
                        }
                        
                } else {
                    System.out.println("Input Invalid!");
                } 
            }
        }
        
        // Pembuatan kode dan perhitungan total sementara
        kodeAwal[urutanMasuk] = "2939" + gedung[urutanMasuk] + idMasuk[urutanMasuk];
        totalSementara[urutanMasuk] = tarifParkir[urutanMasuk][0] + tarifParkir[urutanMasuk][2];
        
        // Output struk pembayaran
        System.out.println("\n===================================================================");
        System.out.println("                       STRUK PEMBAYARAN                         ");
        System.out.println("              Nomor Struk               : " + kodeAwal[urutanMasuk]);
        System.out.println("              Gedung Parkir             : " + gedung[urutanMasuk]);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkir[urutanMasuk][0]);
        System.out.println("              Tarif Jam Tambahan Parkir : 0");
        if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifParkir[urutanMasuk][2]);
        }
        System.out.println("              Total Sementara           : " + totalSementara[urutanMasuk]);
        System.out.println("===================================================================\n");
    }

    //Deteksi Kode Tempat Parkir
    static void isiTempatParkir() {
        int bil = 0;
        if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("motor")) {
            for (int i = 1; i <= 5; i++) {
                if (hurufParkir[urutanMasuk].equals("A")) {
                        if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("B")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("C")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("D")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("E")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("F")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("G")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("H")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("I")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("J")) {
                    if (angkaParkir[urutanMasuk] == i) {
                        kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
            }
        }

        bil = 0;
        if (jenisKendaraan[urutanMasuk].equalsIgnoreCase("mobil")) {
            for (int i = 6; i <= 10; i++) {
                if (hurufParkir[urutanMasuk].equals("K")) {
                    if (angkaParkir[urutanMasuk] == i) {
                    kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("L")) {
                    if (angkaParkir[urutanMasuk] == i) {
                    kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("M")) {
                    if (angkaParkir[urutanMasuk] == i) {
                    kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("N")) {
                    if (angkaParkir[urutanMasuk] == i) {
                    kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
                if (hurufParkir[urutanMasuk].equals("O")) {
                    if (angkaParkir[urutanMasuk] == i) {
                    kodeTempatParkir[urutanMasuk] = bil;
                    }
                }
                bil++;
            }
        }
    }

    // Function dari menu 2(Keluar parkir)
    static void menuKeluarParkir() {

        Scanner input = new Scanner(System.in);
        for (int counter = 0; true;) {
            boolean isTrue = true;
            System.out.print("Masukkan nomor struk Anda\t: ");
            kodeAkhir = input.next();

            for (int i = 0; i < kodeAwal.length; i++) {
                if (kodeAkhir.equals(kodeAwal[i])) {
                    urutanKeluar = i;
                    isTrue = false;
                    break;
                }
            }
            
            if (!isTrue) {
                break;
            } else {
                System.out.println("Input Invalid!");
                counter++;
                if (counter % 3 == 0) {
                    System.out.println("\nApakah Anda kehilangan struk pembayaran");

                    while (isTrue) {
                        System.out.print("ya/tidak  : ");
                        strukHilang = input.next();

                        if (strukHilang.equalsIgnoreCase("ya")) {
                            isTrue = true;
                            while (isTrue) {
                                System.out.print("\nMasukkan nomor polisi Anda : ");
                                nopol = input.nextInt();

                                for (int j = 0; j < idMasuk.length; j++) {
                                    if (nopol == idMasuk[j]) {
                                        urutanKeluar = j;
                                        denda[j] = 20000;
                                        isTrue = false;
                                        break;
                                    }
                                }
                                if (isTrue) {
                                    System.out.println("Input Invalid!");
                                }
                            }
                        } else if (strukHilang.equalsIgnoreCase("tidak")) {
                            System.out.println("");
                            break;
                        } else {
                            System.out.println("Input Invalid!");
                        }
                    }
                }
                if (!isTrue) {
                    break;
                }
            }
        }

        // User menginputkan jam dan menit ketika keluar parkiran
        System.out.println();
        while (true) {
            System.out.print("Jam keluar parkir (07-22)\t: ");
            waktuParkir[urutanKeluar][2] = input.nextInt();
            System.out.print("Menit keluar parkir (00-59)\t: ");
            waktuParkir[urutanKeluar][3] = input.nextInt();
            if ((waktuParkir[urutanKeluar][2] >= waktuParkir[urutanKeluar][0] && waktuParkir[urutanKeluar][2] < 22) && (waktuParkir[urutanKeluar][3] >= 0 && waktuParkir[urutanKeluar][3] < 60)) {
                break;
            } else {
                System.out.println("Input Invalid!\n");
            }
        }

        // Perhitungan waktu selama parkir (jam)
        hitungWaktu();

        // Perhitungan tarif parkir per jam
        int tarifJam[][] = {
                // Baris 1-Tarif perjam untuk motor
                { 500, 1500, 3000, 5000, 5000 + (durasi[urutanKeluar] - 5) * 2000 },
                // Baris 2-Tarif perjam untuk mobil
                { 2000, 5000, 9000, 14000, 14000 + (durasi[urutanKeluar] - 5) * 5000 }
        };

        // Menentukan Tarif Parkir Perjam
        hitungTarifPerjam(tarifJam);

        // Perhitungan tarif total
        tarifParkir[urutanKeluar][3] = tarifParkir[urutanKeluar][0] + tarifParkir[urutanKeluar][1] + tarifParkir[urutanKeluar][2];
        totalPembayaran[urutanKeluar] = tarifParkir[urutanKeluar][3] + denda[urutanKeluar];
        totalDiskon = totalPembayaran[urutanKeluar] * diskon[urutanKeluar];
        totalPembayaran[urutanKeluar] -= totalDiskon;

        // Output nota pembayaran
        System.out.println("\n===================================================================");
        System.out.println("                         NOTA PEMBAYARAN                         ");
        System.out.println("              Nomor struk               : " + kodeAwal[urutanKeluar]);
        System.out.println("              Gedung Parkir             : " + gedung[urutanKeluar]);
        System.out.println("              Tarif Awal Parkir         : " + tarifParkir[urutanKeluar][0]);
        System.out.println("              Tarif Jam Tambahan Parkir : " + tarifParkir[urutanKeluar][1]);
        if (jenisKendaraan[urutanKeluar].equalsIgnoreCase("motor")) {
            System.out.println("              Tarif Penitipan Helm      : " + tarifParkir[urutanKeluar][2]);
        }
        if (isMember[urutanKeluar].equalsIgnoreCase("member")) {
            System.out.println("              Diskon                    : " + (int) totalDiskon);
        }
        if (strukHilang.equalsIgnoreCase("ya")) {
            System.out.println("              Denda Kehilangan Struk    : " + denda[urutanKeluar]);
        }
        System.out.println("              Total                     : " + totalPembayaran[urutanKeluar]);
        System.out.println("===================================================================\n");
        System.out.println("");

        // User melakukan pembayaran
        // Perulangan untuk melakukan pembayaran jika uang kurang dari
        // totalPembayaran[urutanKeluar]
        do {
            System.out.print("Masukkan nilai uang yang Anda bayar : ");
            pembayaran[urutanKeluar] = input.nextInt();
            if (pembayaran[urutanKeluar] < totalPembayaran[urutanKeluar]) {
                System.out.println("Uang Anda tidak cukup");
            }
        } while (pembayaran[urutanKeluar] < totalPembayaran[urutanKeluar]);
        
        // User menerima kembalian
        kembalian = pembayaran[urutanKeluar] - totalPembayaran[urutanKeluar];
        System.out.println("Kembalian : " + kembalian);
        
        
        if (jenisKendaraan[urutanKeluar].equalsIgnoreCase("motor")) {
            gedungMotor[kodeTempatParkir[urutanKeluar]] = false;
            kapasitasGedung[0]++;
        } else {
            gedungMobil[kodeTempatParkir[urutanKeluar]] = false;
            kapasitasGedung[1]++;
        }
    }

    static void cekDenahParkirMotor() {
        System.out.println("\n           DENAH PARKIR MOTOR  ");
        System.out.println("---------------------------------------------\n");
        System.out.println("  A   B   C   D   E   F   G   H   I   J\n");
        int spasi = 0;
        int urutan = 1;
        for (int i = 0; i < gedungMotor.length; i++) {
            if (spasi == 0 || spasi %10 == 0) {
                System.out.print("|");
            }
            if (gedungMotor [i] == false) {
                System.out.print("   |");
            } else {
                System.out.print(" X |");
            }
            spasi++;
            if (spasi%10 == 0) {
                System.out.println("  " + urutan + "\n");
                urutan++;
            }
        }
        System.out.println("---------------------------------------------");
    }

    static void cekDenahParkirMobil (){
        System.out.println("\n  DENAH PARKIR MOBIL  ");
        System.out.println("-------------------------\n");
        System.out.println("  K   L   M   N   O\n");
        int spasi = 0;
        int urutan = 6;
        for (int i = 0; i < gedungMobil.length; i++) {
            if (spasi == 0 || spasi %5 == 0) {
                System.out.print("|");
            }
            if (gedungMobil [i] == false) {
                System.out.print("   |");
            } else {
                System.out.print(" X |");
            }
            spasi++;
            if (spasi%5 == 0) {
                System.out.println("  " + urutan + "\n");
                urutan++;
            }
        }
        System.out.println("-------------------------");
    }
    
    // Fungsi untuk menampilkan informasi tempat parkir pada suatu gedung
    static void cekTempatParkir() {
        System.out.println("---------------------------------------------------");
        System.out.println("             CEK TEMPAT PARKIR (KAPASITAS)           ");
        System.out.println("---------------------------------------------------");
        
        System.out.println("Tempat parkir motor : " + kapasitasGedung[0]);
        System.out.println("Tempat parkir mobil : " + kapasitasGedung[1]);
        cekDenahParkirMotor();
        cekDenahParkirMobil();
    }
    
    static void keluarProgram() {
        System.out.println("Laporan Data Parkir");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %s | %s | %s | %s | %s | %s | %s |\n", "NO", "Jenis Kendaraan", "Status", "Kode Struk", "Waktu Parkir", "Total Pembayaran", "Status Pembayaran");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (int i = 0; i < idMasuk.length; i++) {
            if (idMasuk[i] != 0 && pembayaran[i] != 0) {
                System.out.printf("| %2d | %-15s | %-6s | %-10s | %-12s | %-16s | %-17s |\n", (i + 1), jenisKendaraan[i], isMember[i], kodeAwal[i], durasi[i] + " jam", "Rp " + totalPembayaran[i], "V");
            }
            if (idMasuk[i] != 0 && pembayaran[i] == 0) {
                System.out.printf("| %2d | %-15s | %-6s | %-10s | %-12s | %-16s | %-17s |\n", (i + 1), jenisKendaraan[i], isMember[i], kodeAwal[i], "-", "Rp " + "-", "X");
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    static void hitungWaktu() {
        if (waktuParkir[urutanKeluar][0] == waktuParkir[urutanKeluar][2]) {
            durasi[urutanKeluar] = 1;
        } else {
            durasi[urutanKeluar] = waktuParkir[urutanKeluar][2] - waktuParkir[urutanKeluar][0];
        }

        if (waktuParkir[urutanKeluar][2] != waktuParkir[urutanKeluar][0] && waktuParkir[urutanKeluar][3] > waktuParkir[urutanKeluar][1]) {
            durasi[urutanKeluar] += 1;
        }
    }

    static void hitungTarifPerjam(int[][] tarifJam) {
        // Menentukan tarif per jam untuk motor
        if (jenisKendaraan[urutanKeluar].equalsIgnoreCase("motor")) {
            if (durasi[urutanKeluar] == 2) {
                tarifParkir[urutanKeluar][1] = tarifJam[0][0]; // 500
            } else if (durasi[urutanKeluar] == 3) {
                tarifParkir[urutanKeluar][1] = tarifJam[0][1]; // 500+1000
            } else if (durasi[urutanKeluar] == 4) {
                tarifParkir[urutanKeluar][1] = tarifJam[0][2]; // 500+1000+1500
            } else if (durasi[urutanKeluar] == 5) {
                tarifParkir[urutanKeluar][1] = tarifJam[0][3]; // 500+1000+1500+2000
            } else if (durasi[urutanKeluar] > 5) {
                tarifParkir[urutanKeluar][1] = tarifJam[0][4]; // 500+1000+1500+2000+(2000 perjam)
            }
        }

        // Menentukan tarif parkir per jam untuk mobil
        if (jenisKendaraan[urutanKeluar].equalsIgnoreCase("mobil")) {
            if (durasi[urutanKeluar] == 2) {
                tarifParkir[urutanKeluar][1] = tarifJam[1][0]; // 2000
            } else if (durasi[urutanKeluar] == 3) {
                tarifParkir[urutanKeluar][1] = tarifJam[1][1]; // 2000+3000
            } else if (durasi[urutanKeluar] == 4) {
                tarifParkir[urutanKeluar][1] = tarifJam[1][2]; // 2000+3000+4000
            } else if (durasi[urutanKeluar] == 5) {
                tarifParkir[urutanKeluar][1] = tarifJam[1][3]; // 2000+3000+4000+5000
            } else if (durasi[urutanKeluar] > 5) {
                tarifParkir[urutanKeluar][1] = tarifJam[1][4]; // 2000+3000+4000+5000+(5000 perjam)
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("||                                                        ||");
        System.out.println("||                      SELAMAT DATANG                    ||");
        System.out.println("||                  DI PARKIRAN BOUGENVILLE               ||");
        System.out.println("||                                                        ||");
        System.out.println("============================================================");

        do {

            System.out.println("\n==========================");
            System.out.println("||          MENU        ||");
            System.out.println("||----------------------||");
            System.out.println("|| 1. Masuk Parkir      ||");
            System.out.println("|| 2. Keluar Parkir     ||");
            System.out.println("|| 3. Cek Tempat Parkir ||");
            System.out.println("|| 4. Keluar Program    ||");
            System.out.println("==========================\n");

            System.out.print("Pilih Menu : ");
            menu = input.nextInt();

            System.out.println();

            switch (menu) {
                case 1:
                if (kapasitasGedung[0] == 0 && kapasitasGedung[1] == 0) {
                    System.out.println("PARKIRAN PENUH !");
                } else {
                    menuMasukParkir();
                    urutanMasuk++;
                    jmlKendaraan++;
                }
                    break;

                case 2:
                    if (jmlKendaraan == 0) {
                        System.out.println("Tidak Ada Kendaraan yang Parkir!");
                    } else {
                        menuKeluarParkir();
                        jmlKendaraan--;
                    }
                    break;

                case 3:
                    if (kapasitasGedung[0] == 0 && kapasitasGedung[1] == 0) {
                        System.out.println("PARKIRAN PENUH !");
                    } else {
                        cekTempatParkir();
                    }
                    break;

                case 4:
                    if (idMasuk[0] == 0) {
                        System.out.println("Belum Ada Kendaraan yang Parkir!");
                        isiTempatParkir();
                    } else {
                        keluarProgram();
                    }
                    break;

                default:
                    System.out.println("Input Invalid!\n");
                    break;
            }

        } while (menu != 4);

        System.out.println("\n===================================================================");
        System.out.println("||                                                               ||");
        System.out.println("||                        TERIMAKASIH                            ||");
        System.out.println("||                   SELAMAT DATANG KEMBALI                      ||");
        System.out.println("||                                                               ||");
        System.out.println("===================================================================");
    }

}