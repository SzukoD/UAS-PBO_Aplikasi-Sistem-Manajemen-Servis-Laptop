package sistemmanajemenservicelaptop;

// CLASS DOMAIN PELANGGAN
// Menyimpan data pelanggan yang melakukan servis
public class Pelanggan {

    // ATRIBUT
    private String nama;   // nama pelanggan
    private String hp;     // nomor hp pelanggan
    private String alamat; // alamat pelanggan

    // CONSTRUCTOR
    // digunakan saat membuat objek pelanggan baru
    public Pelanggan(String nama, String hp, String alamat) {
        this.nama = nama;
        this.hp = hp;
        this.alamat = alamat;
    }

    // GETTER
    // mengambil nama pelanggan
    public String getNama() {
        return nama;
    }

    // GETTER
    // mengambil nomor hp pelanggan
    public String getHp() {
        return hp;
    }

    // GETTER
    // mengambil alamat pelanggan
    public String getAlamat() {
        return alamat;
    }

    // METHOD TAMBAHAN
    // menampilkan data pelanggan ke console
    public void display() {
        System.out.println(nama + " | " + hp + " | " + alamat);
    }
}
