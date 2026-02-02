package sistemmanajemenservicelaptop; 

import java.util.*;

public class Main { 

    // Menyimpan seluruh data transaksi servis di memori
    // Data langsung dibaca dari file txt saat program dijalankan
    static ArrayList<TransaksiServis> list = FileManager.baca();

    // Nilai awal = jumlah data yang sudah ada di file
    static int counter = list.size();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int pilih; 
        do {
            // Tampilan judul menu sistem
            System.out.println("\n==================================");
            System.out.println("   SISTEM MANAJEMEN SERVIS LAPTOP");
            System.out.println("==================================");
            System.out.println("1. Input Servis Laptop");
            System.out.println("2. Data Servis Laptop");
            System.out.println("3. Pencarian Servis");
            System.out.println("4. Edit Data Servis");
            System.out.println("5. Status Servis Laptop");
            System.out.println("6. Keluar");
            System.out.println("----------------------------------");

            pilih = inputInt("Masukkan angka menu: ");

            // Percabangan pilihan menu
            switch (pilih) {
                case 1: tambah(); break;        
                case 2: tampilTabel(); break;   
                case 3: cari(); break;         
                case 4: edit(); break;          
                case 5: status(); break;       
                case 6: System.out.println("Terima kasih!"); break; 
                default: System.out.println("Menu tidak tersedia!"); 
            }

        } while (pilih != 6); 
    }

    // INPUT DATA
    static void tambah() {

        System.out.println("\n========== INPUT DATA SERVIS ==========");

        // Input data pelanggan
        String nama = inputString("Nama Pelanggan : ");
        String hp = inputHp("No HP          : ");
        String alamat = inputString("Alamat         : ");

        Pelanggan p = new Pelanggan(nama, hp, alamat);

        // Input data laptop
        String sn = inputSerial("Serial Number  : ");
        String model = inputString("Model Laptop   : ");
        int tahun = inputInt("Tahun Laptop   : ");

        // Memilih jenis laptop
        System.out.println("Jenis Laptop");
        System.out.println("1. Gaming");
        System.out.println("2. Office");
        System.out.println("3. Ultrabook");

        int jl;
        while (true) {
            jl = inputInt("Pilih (1-3): ");
            if (jl >= 1 && jl <= 3) break;
            System.out.println("Pilihan jenis laptop hanya 1 - 3!");
        }

        Laptop l;

        if (jl == 1) {
            int ram = inputInt("RAM (GB)       : ");
            l = new LaptopGaming(sn, model, tahun, StatusServis.MENUNGGU, ram);
        } 
        else if (jl == 2) {
            double berat = inputDouble("Berat (kg)     : ");
            l = new LaptopOffice(sn, model, tahun, StatusServis.MENUNGGU, berat);
        } 
        else {
            boolean fp = inputBoolean("Fingerprint (true/false): ");
            l = new LaptopUltrabook(sn, model, tahun, StatusServis.MENUNGGU, fp);
        }

        // Memilih jenis servis
        System.out.println("\nJenis Servis");
        System.out.println("1. Upgrade RAM");
        System.out.println("2. Ganti Pasta");
        System.out.println("3. Install Ulang");
        System.out.println("4. Bongkar Bersih");
        System.out.println("5. Lainnya");

        int jsIn;
        while (true) {
            jsIn = inputInt("Pilih (1-5): ");
            if (jsIn >= 1 && jsIn <= 5) break;
            System.out.println("Pilihan servis hanya 1 - 5!");
        }

        JenisServis js = JenisServis.values()[jsIn - 1];

        String keluhan = inputString("Keluhan        : ");

        TransaksiServis t = new TransaksiServis(
                "TR" + (++counter), p, l, js, keluhan);

        list.add(t);
        FileManager.simpan(t);

        System.out.println("Data berhasil ditambahkan!");
    }

    // TABEL DATA
    static void tampilTabel() {

        if (list.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }

        System.out.println("\n=================================================================================");
        System.out.printf("| %-4s | %-12s | %-10s | %-12s | %-12s | %-10s |\n",
                "ID", "Nama", "Model", "Servis", "Keluhan", "Status");
        System.out.println("=================================================================================");

        for (TransaksiServis t : list) {
            System.out.printf("| %-4s | %-12s | %-10s | %-12s | %-12s | %-10s |\n",
                    t.getId(),
                    t.getPelanggan().getNama(),
                    t.getLaptop().getModel(),
                    t.getJenisServis(),
                    t.getKerusakan(),
                    t.getLaptop().getStatus());
        }

        System.out.println("=================================================================================");
    }

    // EDIT
    static void edit() {

        tampilTabel();
        String id = inputString("Masukkan ID: ");

        for (TransaksiServis t : list) {
            if (t.getId().equalsIgnoreCase(id)) {

                t.tampilkan();

                System.out.println("\n1. Edit Status");
                System.out.println("2. Edit Data Laptop");
                System.out.println("3. Edit Keluhan");

                int pilih;
                while (true) {
                    pilih = inputInt("Pilih (1-3): ");
                    if (pilih >= 1 && pilih <= 3) break;
                    System.out.println("Menu edit hanya 1 - 3!");
                }

                if (pilih == 1) {
                    System.out.println("1.MENUNGGU 2.DIPROSES 3.SELESAI 4.DIAMBIL");

                    int st;
                    while (true) {
                        st = inputInt("Pilih (1-4): ");
                        if (st >= 1 && st <= 4) break;
                        System.out.println("Status hanya 1 - 4!");
                    }

                    t.getLaptop().setStatus(StatusServis.values()[st - 1]);
                } 
                else if (pilih == 2) {

                    Laptop l = t.getLaptop();

                    l.setSerialNumber(inputSerial("Serial Baru: "));
                    l.setModel(inputString("Model Baru : "));
                    l.setTahun(inputInt("Tahun Baru : "));

                    if (l instanceof LaptopGaming)
                        ((LaptopGaming) l).setRam(inputInt("RAM Baru: "));
                    else if (l instanceof LaptopOffice)
                        ((LaptopOffice) l).setBerat(inputDouble("Berat Baru: "));
                    else
                        ((LaptopUltrabook) l)
                            .setFingerprint(inputBoolean("Fingerprint (true/false): "));
                } 
                else {
                    t.setKerusakan(inputString("Keluhan Baru: "));
                }

                FileManager.tulisUlang(list);
                System.out.println("Data berhasil diperbarui!");
                return;
            }
        }

        System.out.println("ID tidak ditemukan.");
    }

    // STATUS
    static void status() {
        for (TransaksiServis t : list)
            System.out.println(t.getId() + " -> " + t.getLaptop().getStatus());
    }

    // CARI
    static void cari() {
        String id = inputString("Masukkan ID: ");
        for (TransaksiServis t : list)
            if (t.getId().equalsIgnoreCase(id))
                t.printNota();
    }

    // VALIDASI
    static int inputInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Harus angka!");
            }
        }
    }

    static double inputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Harus angka desimal!");
            }
        }
    }

    static String inputString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.trim().isEmpty()) return s;
            System.out.println("Tidak boleh kosong!");
        }
    }

    static boolean inputBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().toLowerCase();
            if (s.equals("true") || s.equals("false"))
                return Boolean.parseBoolean(s);
            System.out.println("Masukkan true / false!");
        }
    }

    static String inputHp(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();

            if (s.trim().isEmpty()) {
                System.out.println("No HP tidak boleh kosong!");
                continue;
            }
            if (s.contains(" ")) {
                System.out.println("No HP tidak boleh ada spasi!");
                continue;
            }
            if (!s.matches("\\d+")) {
                System.out.println("No HP harus angka semua!");
                continue;
            }
            return s;
        }
    }

    static String inputSerial(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();

            if (s.trim().isEmpty()) {
                System.out.println("Serial Number tidak boleh kosong!");
                continue;
            }
            if (s.contains(" ")) {
                System.out.println("Serial Number tidak boleh ada spasi!");
                continue;
            }
            return s;
        }
    }
}
