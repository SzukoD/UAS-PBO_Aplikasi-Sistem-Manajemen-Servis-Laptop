package sistemmanajemenservicelaptop;

// Class turunan dari Laptop (Inheritance)
// punya method mulaiServis & selesaiServis
public class LaptopOffice extends Laptop implements Servicable {

    // ATRIBUT KHUSUS
    private double berat; // berat laptop dalam Kg

    // CONSTRUCTOR
    // memanggil constructor parent (Laptop)
    public LaptopOffice(String sn,String model,int tahun,StatusServis status,double berat){
        super(sn,model,tahun,status); // Memanggil constructor Laptop
        this.berat=berat;
    }

    // OVERRIDE METHOD ABSTRACT
    // Biaya dasar laptop office berdasarkan berat
    public double hitungBiayaDasar(){ 
        return 200000+(berat*50000); 
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
    // Mengambil nilai berat laptop
    public double getBerat(){ 
        return berat; 
    }
    
    // SETTER
    // Mengubah nilai berat saat edit data
    public void setBerat(double berat){
        this.berat = berat;
    }

}
