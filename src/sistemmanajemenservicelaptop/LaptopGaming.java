package sistemmanajemenservicelaptop;

// Class turunan dari Laptop (Inheritance)
// punya method mulaiServis & selesaiServis
public class LaptopGaming extends Laptop implements Servicable {

    // ATRIBUT KHUSUS
    private int ram;

    // CONSTRUCTOR
    // memanggil constructor parent (Laptop)
    public LaptopGaming(String sn,String model,int tahun,StatusServis status,int ram){
        super(sn,model,tahun,status); // Memanggil constructor Laptop
        this.ram=ram;
    }

    // OVERRIDE METHOD ABSTRACT
    // Implementasi dari method abstract di class Laptop
    // Biaya dasar laptop gaming lebih mahal + tambahan dari RAM
    public double hitungBiayaDasar(){ 
        return 300000+(ram*10000); 
    }

    // IMPLEMENT INTERFACE
    // Method dari interface Servicable
    public void mulaiServis(){ 
        setStatus(StatusServis.DIPROSES); // Saat servis dimulai
    }

    public void selesaiServis(){ 
        setStatus(StatusServis.SELESAI); // Saat servis selesai
    }

    // GETTER
    // Mengambil nilai RAM
    public int getRam(){ 
        return ram; 
    }

    // SETTER
    // Mengubah nilai RAM saat edit data
    public void setRam(int ram){
        this.ram = ram;
    }

}
