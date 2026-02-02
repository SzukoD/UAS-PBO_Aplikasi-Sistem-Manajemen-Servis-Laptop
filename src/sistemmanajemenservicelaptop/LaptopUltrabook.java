package sistemmanajemenservicelaptop;

// Class turunan dari Laptop (Inheritance)
// punya method mulaiServis & selesaiServis
public class LaptopUltrabook extends Laptop implements Servicable {

    // ATRIBUT KHUSUS
    private boolean fingerprint; // apakah ada fitur fingerprint

    // CONSTRUCTOR
    // memanggil constructor parent (Laptop)
    public LaptopUltrabook(String sn,String model,int tahun,StatusServis status,boolean fp){
        super(sn,model,tahun,status); // Memanggil constructor Laptop
        this.fingerprint=fp;
    }

    // OVERRIDE METHOD ABSTRACT
    // Biaya dasar ultrabook tergantung ada fingerprint atau tidak
    public double hitungBiayaDasar(){ 
        return fingerprint ? 350000 : 250000; 
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
    // Mengecek apakah ada fingerprint
    public boolean isFingerprint(){ 
        return fingerprint; 
    }
    
    // SETTER
    // Mengubah fitur fingerprint saat edit data
    public void setFingerprint(boolean fp){
        this.fingerprint = fp;
    }

}
