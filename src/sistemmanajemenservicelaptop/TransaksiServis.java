package sistemmanajemenservicelaptop;

// Menghubungkan Pelanggan + Laptop + Jenis Servis
// Implement interface Printable untuk cetak nota
public class TransaksiServis implements Printable {

    // ATRIBUT
    private String id;          
    private Pelanggan pelanggan;
    private Laptop laptop;      
    private JenisServis jenis;  
    private String kerusakan;   

    // CONSTRUCTOR
    // digunakan saat membuat transaksi baru
    public TransaksiServis(String id, Pelanggan p, Laptop l, JenisServis j, String k) {
        this.id = id;
        this.pelanggan = p;
        this.laptop = l;
        this.jenis = j;
        this.kerusakan = k;
    }

    // GETTER
    // mengambil ID transaksi
    public String getId() { 
        return id; 
    }

    // mengambil data pelanggan
    public Pelanggan getPelanggan() { 
        return pelanggan; 
    }

    // mengambil data laptop
    public Laptop getLaptop() { 
        return laptop; 
    }

    // mengambil jenis servis
    public JenisServis getJenisServis() { 
        return jenis; 
    }

    // mengambil keluhan/kerusakan
    public String getKerusakan() { 
        return kerusakan; 
    }

    // SETTER
    // mengubah keluhan saat edit data
    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }

    // METHOD IDENTIFIKASI JENIS LAPTOP
    // mengecek turunan class Laptop
    public String getJenisLaptop() {
        if (laptop instanceof LaptopGaming) return "GAMING";
        if (laptop instanceof LaptopOffice) return "OFFICE";
        return "ULTRABOOK";
    }

    // METHOD SPESIFIKASI LAPTOP (UNTUK FILE TXT)
    public String getSpesifikasi() {
        if (laptop instanceof LaptopGaming)
            return ((LaptopGaming) laptop).getRam() + "";
        if (laptop instanceof LaptopOffice)
            return ((LaptopOffice) laptop).getBerat() + "";
        return ((LaptopUltrabook) laptop).isFingerprint() + "";
    }

    // METHOD MENAMPILKAN DATA LENGKAP KE CONSOLE
    public void tampilkan() {
        System.out.println("ID            : " + id);
        System.out.println("Nama Pelanggan: " + pelanggan.getNama());
        System.out.println("HP            : " + pelanggan.getHp());
        System.out.println("Alamat        : " + pelanggan.getAlamat());

        // DATA LAPTOP
        System.out.println("Serial Number : " + laptop.getSerialNumber());
        System.out.println("Model Laptop  : " + laptop.getModel());
        System.out.println("Tahun Laptop  : " + laptop.getTahun());
        System.out.println("Jenis Laptop  : " + getJenisLaptop());

        // SPESIFIKASI DENGAN SATUAN
        if (laptop instanceof LaptopGaming) {
            System.out.println("RAM           : " +
                ((LaptopGaming) laptop).getRam() + " GB");
        } 
        else if (laptop instanceof LaptopOffice) {
            System.out.println("Berat         : " +
                ((LaptopOffice) laptop).getBerat() + " Kg");
        } 
        else {
            System.out.println("Fingerprint   : " +
                (((LaptopUltrabook) laptop).isFingerprint() ? "Ada" : "Tidak"));
        }

        // DATA SERVIS
        System.out.println("Jenis Servis  : " + jenis);
        System.out.println("Keluhan       : " + kerusakan);
        System.out.println("Status Servis : " + laptop.getStatus());
    }

    // IMPLEMENT INTERFACE PRINTABLE
    // mencetak nota transaksi servis
    @Override
    public void printNota() {
        System.out.println("\n========== NOTA SERVIS ==========");
        tampilkan(); // panggil method tampilkan data
        System.out.println("Biaya Dasar   : " + laptop.hitungBiayaDasar());
        System.out.println("==================================");
    }
}
