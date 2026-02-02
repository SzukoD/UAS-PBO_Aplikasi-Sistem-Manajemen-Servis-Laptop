package sistemmanajemenservicelaptop; 

import java.io.*;   
import java.util.*;

public class FileManager {

    static String FILE = "servis.txt";

    // SIMPAN
    // Method untuk MENAMBAHKAN data transaksi baru ke file
    public static void simpan(TransaksiServis t) {
        try {
            // FileWriter dengan mode append = true (tidak menimpa data lama)
            FileWriter fw = new FileWriter(FILE, true);

           
            fw.write(
                t.getId() + "|" +                     
                t.getPelanggan().getNama() + "|" +    
                t.getPelanggan().getHp() + "|" +      
                t.getPelanggan().getAlamat() + "|" +  
                t.getLaptop().getSerialNumber() + "|" + 
                t.getLaptop().getModel() + "|" + 
                t.getLaptop().getTahun() + "|" + 
                t.getJenisLaptop() + "|" +        
                t.getSpesifikasi() + "|" +         
                t.getJenisServis() + "|" +         
                t.getKerusakan() + "|" +              
                t.getLaptop().getStatus() + "\n"      
            );

            // Menutup file setelah selesai menulis
            fw.close();
        } catch (Exception e) {
            // Pesan error jika gagal simpan
            System.out.println("Gagal simpan file");
        }
    }

    // MEMBACA
    // Method untuk MEMBACA seluruh data dari file txt ke ArrayList
    public static ArrayList<TransaksiServis> baca() {

        // List kosong untuk menampung data dari file
        ArrayList<TransaksiServis> list = new ArrayList<>();

        try {
            // Mengecek apakah file ada
            File f = new File(FILE);
            if (!f.exists()) return list; // Jika tidak ada → return kosong

            // Membuka file untuk dibaca
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            // Membaca file baris demi baris
            while ((line = br.readLine()) != null) {

                // Memisahkan data berdasarkan "|"
                String[] d = line.split("\\|");

                // Membuat object pelanggan dari data file
                Pelanggan p = new Pelanggan(d[1], d[2], d[3]);

                // Membuat object laptop berdasarkan jenisnya
                Laptop l;
                int tahun = Integer.parseInt(d[6]);
                StatusServis st = StatusServis.valueOf(d[11]);

                // Polymorphism → menentukan subclass laptop
                if (d[7].equals("GAMING")) {
                    l = new LaptopGaming(d[4], d[5], tahun, st, Integer.parseInt(d[8]));
                } else if (d[7].equals("OFFICE")) {
                    l = new LaptopOffice(d[4], d[5], tahun, st, Double.parseDouble(d[8]));
                } else {
                    l = new LaptopUltrabook(d[4], d[5], tahun, st, Boolean.parseBoolean(d[8]));
                }

                // Membuat object transaksi servis
                TransaksiServis t = new TransaksiServis(
                        d[0],                     
                        p,                        
                        l,                        
                        JenisServis.valueOf(d[9]),
                        d[10]                     
                );

                // Menambahkan ke list
                list.add(t);
            }

            // Menutup file setelah selesai membaca
            br.close();

        } catch (Exception e) {
            // Pesan error jika gagal baca
            System.out.println("Gagal baca file");
        }

        // Mengembalikan list transaksi hasil baca file
        return list;
    }

    // TULIS ULANG (UPDATE FILE)
    // Method untuk MENIMPA file saat data diedit
    public static void tulisUlang(ArrayList<TransaksiServis> list) {
        try {
            // FileWriter tanpa append → overwrite file lama
            FileWriter fw = new FileWriter(FILE);

            // Menulis ulang semua data transaksi dari list
            for (TransaksiServis t : list) {
                fw.write(
                    t.getId() + "|" +
                    t.getPelanggan().getNama() + "|" +
                    t.getPelanggan().getHp() + "|" +
                    t.getPelanggan().getAlamat() + "|" +
                    t.getLaptop().getSerialNumber() + "|" +
                    t.getLaptop().getModel() + "|" +
                    t.getLaptop().getTahun() + "|" +
                    t.getJenisLaptop() + "|" +
                    t.getSpesifikasi() + "|" +
                    t.getJenisServis() + "|" +
                    t.getKerusakan() + "|" +
                    t.getLaptop().getStatus() + "\n"
                );
            }

            // Menutup file setelah selesai menulis
            fw.close();
        } catch (Exception e) {
            // Pesan error jika gagal update
            System.out.println("Gagal tulis ulang file");
        }
    }
}
