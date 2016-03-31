import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplikasi implements Serializable {
    private ArrayList<Dosen> DaftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> DaftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> DaftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> DaftarMatakuliah = new ArrayList<Matakuliah>();
    
    Admin admin = new Admin("Dani123","ADM1","Dani");
    /*Buat file Data*/
    public void createFile() {
        try {
            //Admin admin = new Admin("Dani123","ADM1","Dani");
           
            FileOutputStream fos1 = new FileOutputStream("matakuliah.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);

            FileOutputStream fos2 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);
            
            FileOutputStream fos3 = new FileOutputStream("mahasiswa.txt");
            ObjectOutputStream obj3 = new ObjectOutputStream(fos3);
            
            FileOutputStream fos4 = new FileOutputStream("kelas.txt");
            ObjectOutputStream obj4 = new ObjectOutputStream(fos4);

            obj1.writeObject(DaftarMatakuliah);
            obj2.writeObject(DaftarDosen);
            obj3.writeObject(DaftarMahasiswa);
            obj4.writeObject(DaftarKelas);

            obj1.flush();
            obj2.flush();
            obj3.flush();
            obj4.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*Menu Matakuliah Admin*/
    public void setMatakuliahpadaKelas(int id, Matakuliah m){ //menu Admin 1.4
        DaftarKelas.get(id).setMatakuliah(m);
    }
    
    public Matakuliah getMatakuliahpadaKelas(int id){ //menu admin 1.6
        return DaftarKelas.get(id).getMatakuliah();
    }
    
    public void deleteMatakuliahpadaKelas(int id){ //menu admin 1.5
        DaftarKelas.get(id).setMatakuliah(null);
    }
    
    public ArrayList<Matakuliah> getListMatakuliahFromFile() { //menu Admin 1.3 
        ArrayList<Matakuliah> matakuliah = new ArrayList<Matakuliah>();
        try {
            FileInputStream fis = new FileInputStream("matakuliah.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Matakuliah> m = (ArrayList<Matakuliah>)ois.readObject();
            matakuliah = m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matakuliah;
    }
    
    public void AddMatakuliah(Matakuliah m){ //menu Admin 1.1
        try {
            DaftarMatakuliah.add(m);
            FileOutputStream fos1 = new FileOutputStream("matakuliah.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarMatakuliah);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void RemoveMatakuliah(Matakuliah m){ //menu Admin 1.2
         try {
            DaftarMatakuliah.remove(m);
            FileOutputStream fos1 = new FileOutputStream("matakuliah.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarMatakuliah);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Matakuliah getMatakuliah(int id){ //menu Admin (klo perlu) 
        return DaftarMatakuliah.get(id);
    }
    
    /*Menu Dosen pada Admin*/
    public void setDosenpadaKelas(int id, Dosen d){ //menu Admin 2.4
        DaftarKelas.get(id).setDosen(d);
    }
    
    public Dosen getDosenpadaKelas(int id){ //Menu Admin 1.6
        return DaftarKelas.get(id).getDosen();
    }
    
    public void removeDosenpadaKelas(int id,Dosen d){ //Menu Admin 2.5
        if (DaftarKelas.get(id).getDosen().equals(d)){
            DaftarKelas.get(id).setDosen(null);
        }
    }
    
    public ArrayList<Dosen> getListDosenFromFile() { //menu Admin 2.3
        ArrayList<Dosen> dosen = new ArrayList<Dosen>();
        try {
            FileInputStream fis = new FileInputStream("dosen.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Dosen> m = (ArrayList<Dosen>)ois.readObject();
            dosen = m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dosen;
    }
    
    public void AddDosen(Dosen d){ //menu Admin 2.1
         try {
            DaftarDosen.add(d);
            FileOutputStream fos1 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarDosen);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void RemoveDosen(Dosen d){ //menu Admin 2.2
         try {
            DaftarDosen.remove(d);
            FileOutputStream fos1 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarDosen);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Dosen getDosen(int id){ //menu Admin 2.7
        return DaftarDosen.get(id);
    }
    
    /*Menu Admin pada mahasiswa*/
    public void AddMahasiswa(Mahasiswa m){ // menu Admin 3.1
         try {
            DaftarMahasiswa.add(m);
            FileOutputStream fos1 = new FileOutputStream("mahasiswa.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarMahasiswa);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void RemoveMahasiswa(int id){ //menu Admin 3.2
        try {
            DaftarMahasiswa.remove(id);
            FileOutputStream fos1 = new FileOutputStream("mahasiswa.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarMahasiswa);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Mahasiswa> getListMahasiswaFromFile() { //menu Admin 3.3
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
        try {
            FileInputStream fis = new FileInputStream("mahasiswa.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Mahasiswa> m = (ArrayList<Mahasiswa>)ois.readObject();
            mahasiswa = m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mahasiswa;
    }
    
    public Mahasiswa getMahasiswa(int id){ //menu Admin (klo butuh) 
        return DaftarMahasiswa.get(id);
    }
    
    /*Menu Admin pada Kelas*/
    /*public void TambahKelasMahasiswa(int id, Kelas k){ //menu Admin 4.1
        DaftarMahasiswa.get(id).AddKelas(k);
    }
    
    public void DeleteKelasMahasiswa(int id, Kelas k){ //menu Admin 4.2
        DaftarMahasiswa.get(id).RemoveKelas(k);
    }*/
    
    public ArrayList<Kelas> getListKelasFromFile() { //menu Admin 4.3 dan Menu Mahasiswa 5
        ArrayList<Kelas> kelas = new ArrayList<Kelas>();
        try {
            FileInputStream fis = new FileInputStream("kelas.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Kelas> m = (ArrayList<Kelas>)ois.readObject();
            kelas = m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kelas;
    }
    
    public void AddKelas(Kelas k){ //menu Admin 4.1
        try {
            DaftarKelas.add(k);
            FileOutputStream fos1 = new FileOutputStream("kelas.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarKelas);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void RemoveKelas(Kelas k){ //menu Admin 4.2
        try {
            DaftarKelas.remove(k);
            FileOutputStream fos1 = new FileOutputStream("kelas.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);
            obj1.writeObject(DaftarKelas);
            obj1.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public Kelas getKelas(int id){ //menu Admin (klo butuh) 
        return DaftarKelas.get(id);
    }
     
    /* Menu Mahasiswa */
    public void PilihKelas(Mahasiswa m, Kelas k){ //menu Mahasiswa 1
        m.AddKelas(k);
    }
    
    public void BatalPilihKelas(Mahasiswa m, Kelas k){ //Menu Mahasiswa 2
        m.RemoveKelas(k);
    }
    
    public ArrayList<Kelas> LihatPilihanKelas(Mahasiswa m){ //Menu Mahasiswa 3
        return m.getPilihan();
    }
    
    public Dosen LihatDosenKelas(Kelas k){ //Menu Mahasiswa 4
        return k.getDosen();
    }
    /****/
    public boolean isMahasiswaTrue(String username, String password) {
        boolean cek = false;
        for (int i = 0; i < getListMahasiswaFromFile().size(); i++) {
            if ((getListMahasiswaFromFile().get(i).getUsernameMhs().equals(username)) && 
                    getListMahasiswaFromFile().get(i).getPasswordMhs().equals(password)) {
                cek = true;
            }
        }
        return cek;
    }
    
    public void mainMenu() {
        File file1 = new File("matakuliah.txt");
        File file2 = new File("dosen.txt");
        File file3 = new File("mahasiswa.txt");
        File file4 = new File("kelas.txt");
        if ((file2.exists())&&(file1.exists())&&(file3.exists())&&(file4.exists())) {
            
        }
        else {
            createFile();
        }
        
        int pilihan1 = 1;
        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
            
            /*try {
                
                Mahasiswa m1 = new Mahasiswa("Tono","MHS1","tonotono","passwordtono",4,"Informatika");
                Mahasiswa m2 = new Mahasiswa("Tini","MHS2","tonotono","passwordtono",4,"Informatika");
                FileOutputStream fos = new FileOutputStream("coba.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeObject(m1);
                oos.writeObject(m2);
                oos.flush();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println(coba().get(1).getNama());*/
            
            System.out.println("APLIKASI REGISTRASI MATA KULIAH");
            System.out.println();
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih Menu : ");
            try {
                int pilmenu = angka.nextInt();
                switch (pilmenu) {
                    case 1 :
                        System.out.print("Masukkan Username Admin : ");
                        String UserAdm = huruf.nextLine();
                        System.out.print("Masukkan Password Admin : ");
                        String PassAdm = huruf.nextLine();
                        
                        if ((UserAdm.equals(admin.getUsernameAdm())) && (PassAdm.equals(admin.getPasswordAdm()))) {
                            System.out.println("SELAMAT DATANG ADMIN");
                            System.out.println("Silahkan pilih menu Admin yang tersedia: ");
                            System.out.println("1. Matakuliah");
                            System.out.println("2. Dosen");
                            System.out.println("3. Mahasiswa");
                            System.out.println("4. Matakuliah");
                            System.out.print("pilihan: ");
                        try{
                            int pil = angka.nextInt();
                            switch(pil){
                                case 1:
                                    System.out.println("Pilih menu pada Mahasiswa: ");
                                    System.out.println("1. Tambah Matakuliah ke dalam database");
                                    System.out.println("2. Kurang Matakuliah dalam database");
                                    System.out.println("3. Tampil Matakuliah dalam database");
                                    System.out.println("4. Masukkan Matakuliah dalam kelas");
                                    System.out.println("5. Delete Matakuliah dalam kelas");
                                    System.out.println("6. Tampil matakuliah dalam kelas ");
                                    System.out.print("pilihan: ");
                                try{
                                    int pilmatkul;
                                    pilmatkul = angka.nextInt();
                                    System.out.println();
                                    switch(pilmatkul){
                                        case 1:
                                            System.out.print("Masukkan Nama: ");
                                            String nama;
                                            nama = huruf.nextLine();
                                            System.out.println();
                                            System.out.print("Masukkan Sks: ");
                                            int sks; 
                                            sks = angka.nextInt();
                                            System.out.println();
                                            System.out.print("Masukkan Kode Matkul: ");
                                            long kode;
                                            kode = angka.nextLong();
                                            Matakuliah m = new Matakuliah(nama,sks,kode);
                                            AddMatakuliah(m);
                                            System.out.println("Berhasil memasukkan data");
                                            break;
                                            /*tambahin*/
                                            default :
                                                System.out.println("Menu tidak ada");
                                    } 
                                } catch (InputMismatchException e){
                                    System.out.println("Inputan harus antara 1 sampai 6");
                                    }
                                case 2:
                                    System.out.println("Pilih menu pada dosen: ");
                                    System.out.println("1. Tambah Dosen pada database");
                                    System.out.println("2. Delete Dosen pada database");
                                    System.out.println("3. Tampil Dosen pada database");
                                    System.out.println("4. Masukkan Dosen pada kelas");
                                    System.out.println("5. Delete Dosen pada kelas");
                                    System.out.println("6. Tampil Dosen pada kelas");
                                    System.out.print("Pilihan: ");
                                try{
                                    int pildsn;
                                    pildsn = angka.nextInt();
                                    System.out.println();
                                    switch(pildsn){
                                        case 1:
                                            System.out.println("Masukkan nama: ");
                                            String nama;
                                            nama = huruf.nextLine();
                                            System.out.println();
                                            System.out.println("Masukkan NIM: ");
                                            long nim;
                                            nim = angka.nextLong();
                                            Dosen d = new Dosen(nama,nim);
                                            AddDosen(d);
                                            System.out.println("Berhasil memasukkan data");
                                            break;
                                            /*Tambahin*/
                                            default :
                                                System.out.println("Menu tidak ada");
                                    } 
                                } catch (InputMismatchException e){
                                    System.out.println("Inputan harus antara 1 sampai 6");
                                    }
                                case 3: 
                                    System.out.println("Pilih menu pada mahasiswa: ");
                                    System.out.println("1. Tambah Mahasiswa pada database");
                                    System.out.println("2. Delete Mahasiswa pada database");
                                    System.out.println("3. Tampil Mahasiswa pada database");
                                    System.out.print("Pilihan: ");
                                try{
                                    int pilmhs;
                                    pilmhs = angka.nextInt();
                                    switch(pilmhs){
                                        case 1:
                                            System.out.print("Masukkan nama: ");
                                            String nama;
                                            nama = huruf.nextLine();
                                            System.out.println();
                                            System.out.println("Masukkan NIM: ");
                                            long nim;
                                            nim = angka.nextLong();
                                            System.out.println();
                                            System.out.println("Masukkan username: ");
                                            String usrname;
                                            usrname = huruf.nextLine();
                                            System.out.println();
                                            System.out.println("Masukkan password: ");
                                            String pass;
                                            pass = huruf.nextLine();
                                            Mahasiswa m = new Mahasiswa(nim,usrname,pass,nama);
                                            AddMahasiswa(m);
                                            System.out.println("Berhasil memasukkan data");
                                            break;
                                            /*tambahin*/
                                            default :
                                                System.out.println("Menu tidak ada");
                                    } 
                                } catch (InputMismatchException e){
                                    System.out.println("Inputan harus diantara 1 sampai 3");
                                    }
                                case 4:
                                    System.out.println("Pilih menu pada Kelas");
                                    System.out.println("1. Tambah Kelas pada database");
                                    System.out.println("2. Delete Kelas pada database");
                                    System.out.println("3. Tampil Kelas pada database");
                                    System.out.print("Pilihan: ");
                                try{
                                    int pilkls;
                                    pilkls = angka.nextInt();
                                    System.out.println();
                                    switch(pilkls){
                                        case 1:
                                            getListMatakuliahFromFile();
                                            System.out.print("pilih id sesuai urutan yang akan dimasukkan matakuliahnya: ");
                                            int pildftmatkul;
                                            pildftmatkul = angka.nextInt();
                                            if(DaftarMatakuliah.get(pildftmatkul)!=null){
                                                getListDosenFromFile();
                                                System.out.println("pilih id sesuai urutan yang akan dimasukkan dosennya: ");
                                                int pildftdsn;
                                                pildftdsn = angka.nextInt();
                                                if (DaftarDosen.get(pildftdsn)!=null){
                                                    System.out.println("Masukkan id kelas: ");
                                                    long idkls;
                                                    idkls = angka.nextLong();
                                                    Kelas k;
                                                    k = new Kelas(DaftarMatakuliah.get(pildftmatkul),DaftarDosen.get(pildftdsn),idkls);
                                                    AddKelas(k);
                                                    System.out.println("Data berhasil dimasukkan");
                                                }
                                                else{
                                                    System.out.println("Dosen tidak valid");
                                                }
                                            }
                                            else{
                                                System.out.println("Matakuliah tidak valid");
                                            }
                                            break;
                                            /*tambahin*/
                                            default :
                                                System.out.println("Menu tidak ada");
                                    } 
                                } catch (InputMismatchException e){
                                        System.out.println("Inputan harus diantara 1 sampai 3");
                                    }  
                            } 
                        } catch (InputMismatchException e){
                                    System.out.println("Inputan harus antara 1 sampai 2");
                                }
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                            break;
                        }
                       
                    case 2 :
                        System.out.print("Masukkan Username Mahasiswa : ");
                        String UserMhs = huruf.nextLine();
                        System.out.print("Masukkan Password Mahasiswa : ");
                        String PassMhs = huruf.nextLine();
                        if (isMahasiswaTrue(UserMhs, PassMhs) == true) {
                            int i = 0;
                            do{
                                i++;
                            }while (UserMhs!=getListMahasiswaFromFile().get(i).getUsernameMhs());
                            String NamaMHS = DaftarMahasiswa.get(i).getNama();
                            long NimMHS = DaftarMahasiswa.get(i).getNim();
                            Mahasiswa m = new Mahasiswa(NimMHS,UserMhs,PassMhs,NamaMHS);
                            System.out.println("SELAMAT DATANG");
                            System.out.println("Pilih Menu: ");
                            System.out.println("1. Pilih Kelas");
                            System.out.println("2. Batal Pilih Kelas");
                            System.out.println("3. Lihat Pilihan Kelas");
                            System.out.println("4. Lihat Dosen Kelas");
                            System.out.println("5. Tampil Kelas dalam database");
                            System.out.println("Pilihan: ");
                            try{
                                int pilmahs;
                                pilmahs = angka.nextInt();
                                switch(pilmahs){
                                    case 1:
                                        getListKelasFromFile();
                                        System.out.println("Input id sesuai urutan tampil");
                                        int klsid;
                                        klsid = angka.nextInt();
                                        if (DaftarKelas.get(klsid)!=null){
                                            PilihKelas(m,DaftarKelas.get(klsid));
                                        }
                                        else{
                                            System.out.println("Kelas tidak tersedia");
                                        }
                                        break;
                                        /*lanjutin*/
                                    default :
                                        System.out.println("Menu tidak ada");     
                                }
                            } catch (InputMismatchException e){
                                System.out.println("Inputan harus diantara 1 sampai 5");
                            }
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                        }
                        break;
                        
                    case 0 :
                        System.out.println("TERIMA KASIH");
                        pilihan1 = 0;
                        break;
                        
                    default :
                        System.out.println("Menu tidak ada");
                }
            } catch (InputMismatchException e) {
                System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
            }
        }
    }    
}
