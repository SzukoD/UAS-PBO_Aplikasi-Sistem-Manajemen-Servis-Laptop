<div align="center">

# Aplikasi Sistem Manajemen Servis Laptop  
### UAS Pemrograman Berorientasi Objek – Java Console App

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white)
![Console App](https://img.shields.io/badge/Console%20App-2b9348?style=for-the-badge)

<br>

🎓 **Dibuat oleh:**  
### **[M DAFA DWI SAPUTRA]**  
**NIM:** [24552011320]  
**Kelas:** [TIF RP 24E]

</div>

---

## 📌 Deskripsi Aplikasi
Aplikasi **Sistem Manajemen Servis Laptop** adalah program berbasis **Java Console** yang dibuat untuk memenuhi **Ujian Akhir Semester (UAS)** mata kuliah **Pemrograman Berorientasi Objek (PBO)**.

Aplikasi ini digunakan untuk membantu pengelolaan data servis laptop seperti:

- Data Pelanggan  
- Data Laptop  
- Jenis Servis  
- Status Servis  
- Transaksi Servis  
- Penyimpanan Data ke File TXT  

Program menerapkan konsep **Object Oriented Programming (OOP)** secara lengkap.

---

## ✨ Fitur Aplikasi
- Input data servis laptop  
- Menampilkan tabel data servis  
- Pencarian data berdasarkan ID  
- Edit data servis  
- Update status servis  
- nota servis  
- Penyimpanan otomatis ke file `.txt`  
- Validasi input user  

---

## 🧠 Penerapan Konsep OOP

### 1. **Class & Object**
Program memiliki 12 class utama:

- `Main`
- `FileManager`
- `TransaksiServis`
- `Laptop` *(Abstract Class)*
- `LaptopGaming`
- `LaptopOffice`
- `LaptopUltrabook`
- `Pelanggan`
- `Printable` *(Interface)*
- `Servicable` *(Interface)*
- `JenisServis` *(Enum)*
- `StatusServis` *(Enum)*

---

### 2. **Encapsulation**
Semua atribut dibuat `private` dan diakses menggunakan `getter` & `setter`.

---

### 3. **Inheritance**
Class `LaptopGaming`, `LaptopOffice`, dan `LaptopUltrabook` mewarisi class `Laptop`.

---

### 4. **Polymorphism**
Method `hitungBiayaDasar()` dioverride di setiap jenis laptop.

---

### 5. **Abstract Class**
`Laptop` digunakan sebagai template dasar semua laptop.

---

### 6. **Interface**
- `Printable` → untuk mencetak nota servis  
- `Servicable` → untuk mengatur status servis  

---

### 7. **Enum**
- `JenisServis` → jenis tindakan servis  
- `StatusServis` → status proses servis  

---

Pada aplikasi **Sistem Manajemen Servis Laptop** terdapat beberapa relasi antar class:

### 1. Association → `Main` dengan `TransaksiServis`
Class `Main` berhubungan dengan `TransaksiServis` karena digunakan untuk:
- Menambah data
- Menampilkan data
- Mengedit data
- Mencari data

Relasi ini bersifat **Association** karena `Main` hanya menggunakan objek `TransaksiServis` tanpa memilikinya secara permanen.

---

### 2. Aggregation → `TransaksiServis` dengan `Pelanggan`
Setiap transaksi servis **memiliki data pelanggan**, tetapi data pelanggan tetap bisa ada walaupun transaksi dihapus.

Contoh di kode:
```java
private Pelanggan pelanggan;
```

## 📂 Struktur Project

```java
sistemmanajemenservicelaptop/
├── FileManager.java
├── JenisServis.java
├── Laptop.java
├── LaptopGaming.java
├── LaptopOffice.java
├── LaptopUltrabook.java
├── Main.java
├── Pelanggan.java
├── Printable.java
├── Servicable.java
├── StatusServis.java
└── TransaksiServis.java
```

---

## ▶️ Cara Menjalankan Program
1. Clone repository:
git clone https://github.com/USERNAME/NAMA-REPO.git


2. Buka di NetBeans / IntelliJ / VSCode  

3. Jalankan:
Main.java


---

## 📝 Catatan
- Data servis disimpan di file `servis.txt`
- Program berbasis console (bukan GUI)
- Menggunakan Java murni tanpa database
