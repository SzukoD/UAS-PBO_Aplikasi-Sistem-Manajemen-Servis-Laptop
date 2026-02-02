package sistemmanajemenservicelaptop;

// Class ABSTRACT
public abstract class Laptop {

    // ATRIBUT
    // enkapsulasi
    private String serialNumber; 
    private String model;        
    private int tahun;           
    private StatusServis status;  

    // CONSTRUCTOR 
    // Constructor berparameter
    public Laptop(String sn, String model, int tahun, StatusServis status) {
        this.serialNumber = sn; // Mengisi serial number
        this.model = model;     // Mengisi model laptop
        this.tahun = tahun;     // Mengisi tahun laptop
        this.status = status;   // Mengisi status servis
    }

    // ABSTRACT METHOD
    // Method abstract dioverride di subclass
    // Digunakan untuk menghitung biaya dasar servis tiap jenis laptop
    public abstract double hitungBiayaDasar();

    // Method untuk menampilkan info singkat laptop
    public void displayInfo() {
        System.out.println(serialNumber + " | " + model + " | " + tahun + " | " + status);
    }

    // GETTER
    // Getter untuk mengambil nilai atribut
    public String getSerialNumber() { 
        return serialNumber; 
    }

    public String getModel() { 
        return model; 
    }

    public int getTahun() { 
        return tahun; 
    }

    public StatusServis getStatus() { 
        return status; 
    }

    // SETTER
    // Setter untuk mengubah nilai atribut (enkapsulasi)
    public void setStatus(StatusServis s) { 
        status = s; // Mengubah status servis laptop
    }

    // UNTUK EDIT DATA LAPTOP DI MENU EDIT
    public void setSerialNumber(String sn) {
        this.serialNumber = sn; 
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun; 
    }
}
