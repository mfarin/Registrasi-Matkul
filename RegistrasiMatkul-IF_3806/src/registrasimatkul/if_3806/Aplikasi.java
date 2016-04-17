package registrasimatkul.if_3806;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;


public class Aplikasi implements Serializable {
    private ArrayList<Dosen> DaftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> DaftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> DaftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> DaftarMatakuliah = new ArrayList<Matakuliah>();
    
    Admin admin = new Admin("Dani123","ADM1","Dani");
    
    private String driverName = "com.mysql.jdbc.Driver";   
   private String jdbc = "jdbc:mysql://";  
   private String host = "localhost:";  
   private String port = "3306/";   
   private String database = "regmatkul";  
   private String url = "jdbc:mysql://localhost:3306/regmatkul?zeroDateTimeBehavior=convertToNull";  
   private String username = "root";  
   private String password = "";  
   
   private Connection connection;
   private Statement statement;
   
   
    public Connection getKoneksi() throws SQLException {  
     if (connection == null) {  
       try {  
         Class.forName(driverName);  
         System.out.println("Class Driver Ditemukan");  
         try {  
           connection = DriverManager.getConnection(url, username, password);  
           System.out.println("Koneksi Database Sukses");  
         } catch (SQLException se) {  
           System.out.println("Koneksi Database Gagal : " + se);  
           System.exit(0);  
         }  
       } catch (ClassNotFoundException cnfe) {  
         System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);  
         System.exit(0);  
       }  
     }  
     return connection;  
   }
    
   public void CreateTable() throws SQLException {
   try{
        System.out.println("Creating Table: ");
        statement = connection.createStatement();
        String sql = "Create Table Mahasiswa " +
           "(NIM INTEGER not NULL, " +
           "NAMA VARCHAR(20), " +
           "ID_KELAS INTEGER, " +
           "UsernameMhs VARCHAR(15), " +
           "Password Varchar(10))";
        statement.executeUpdate(sql);
        sql = "Create Table Dosen " +
                "(NIP INTEGER not NULL, " +
                "NAMA VARCHAR(20))";
        statement.executeUpdate(sql);
        sql = "Create Table Kelas " +
                "(ID_KELAS INTEGER NOT NULL, " +
                "DOSEN VARCHAR(20), " +
                "NIP INTEGER, " +
                "MATAKULIAH VARCHAR(20), " +
                "KODE_MATAKULIAH INTEGER)";
        statement.executeUpdate(sql);
        sql = "CREATE TABLE Matakuliah " +
                "(KODE_MATAKULIAH INTEGER NOT NULL, " +
                "NAMA VARCHAR(20), " +
                "SKS INTEGER)";
        statement.executeUpdate(sql);
   }catch(SQLException se){
            se.printStackTrace();
        }
    }
 
   public void SaveMahasiswa(Mahasiswa p, int i){
        try{
            System.out.println("Add Table Content: ");
            statement = connection.createStatement();
             String sql = "INSERT INTO Mahasiswa VALUES("+p.getNim()+", '"+p.getNama()+
                     "', "+p.getPilihan(i).getIdKelas()+", '"+p.getUsernameMhs()+"', '"+p.getPasswordMhs()+"')";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void SaveDosen(Dosen p){
        try{
            System.out.println("Add Table Content: ");
            statement = connection.createStatement();
             String sql = "INSERT INTO Dosen VALUES("+p.getNip()+",'"+p.getNama()+"')";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void SaveKelas(Kelas p){
        try{
            System.out.println("Add Table Content: ");
            statement = connection.createStatement();
             String sql = "INSERT INTO Kelas VALUES("+p.getIdKelas()+",'"+p.getDosen().getNama()+
                     "', "+p.getDosen().getNip()+", '"+p.getMatakuliah().getNama()+"', "+p.getMatakuliah().getKodeMatkul()+")";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void SaveMatakuliah(Matakuliah p){
        try{
            System.out.println("Add Table Content: ");
            statement = connection.createStatement();
             String sql = "INSERT INTO Matakuliah VALUES("+p.getKodeMatkul()+",'"+p.getNama()+
                     "', "+p.getSks()+")";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void deleteMahasiswa(int NIM){
       try{
           statement = connection.createStatement();
           String sql = "DELETE From Mahasiswa " +
                   "Where NIM="+NIM;
           statement.executeUpdate(sql);
       }catch(SQLException se){
           se.printStackTrace();
       }
    }
    public void deleteMahasiswa(int NIM, int id){
       try{
           statement = connection.createStatement();
           String sql = "DELETE From Mahasiswa " +
                   "Where NIM="+NIM+" AND ID_KELAS="+id;
           statement.executeUpdate(sql);
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
   
    public void deleteDosen(int NIP){
       try{
           statement = connection.createStatement();
           String sql = "DELETE From Dosen " +
                   "Where NIP="+NIP;
           statement.executeUpdate(sql);
       }catch(SQLException se){
           se.printStackTrace();
       }
    }
    
    public void deleteKelas(int IdKelas){
       try{
           statement = connection.createStatement();
           String sql = "DELETE From Kelas Where ID_KELAS="+IdKelas;
           statement.executeUpdate(sql);
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    
    public void deleteKelasD(int IdKelas,int kodematkul){
        try{
            statement = connection.createStatement();
            String sql = "Delete From Kelas " +
                    "Where ID_KELAS="+IdKelas+" AND KODE_MATAKULIAH="+kodematkul;
            statement.executeUpdate(sql);
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    public void deleteKelasDosen(int IdKelas,int NIP){
        try{
            statement = connection.createStatement();
            String sql = "Delete From Kelas " +
                    "Where ID_KELAS="+IdKelas+" AND NIP="+NIP;
            statement.executeUpdate(sql);
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    public void deleteMatakuliah(int KODE){
       try{
           statement = connection.createStatement();
           String sql = "DELETE From Matakuliah " +
                   "Where KODE_MATAKULIAH="+KODE;
           statement.executeUpdate(sql);
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    
    public void printMahasiswa(int NIM){
       String sql = "Select * FROM Mahasiswa WHERE NIM="+NIM;
       try{
           statement = connection.createStatement();    
           ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               //int Id_Pelanggan = rs.getInt("Id_Pelanggan");
               String Nama = rs.getString(2);
               String User = rs.getString(4);
               int Kelas = rs.getInt(3);
               String Password = rs.getString(5);
               //Pelanggan p = new Pelanggan(idPelanggan,Nama,Address);
               //System.out.println("ID: "+Id_Pelanggan);
               System.out.println("NIM: "+NIM);
               System.out.println("Nama: "+Nama);
               System.out.println("Kelas: "+Kelas);
               System.out.println("Username: "+User);
               System.out.println("Password: "+Password);
               //System.out.println("Address: "+Address);
           }
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    
    public void printMahasiswa(){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM MAHASISWA";
            ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               int NIM = rs.getInt(1);
               String Nama = rs.getString(2);
               String User = rs.getString(4);
               int Kelas = rs.getInt(3);
               String Password = rs.getString(5);
               
               System.out.println("NIM: "+NIM);
               System.out.println("Nama: "+Nama);
               System.out.println("Kelas: "+Kelas);
               System.out.println("Username: "+User);
               System.out.println("Password: "+Password);
               
           }
        } catch(SQLException se){
            se.printStackTrace();
            }
    }
    public void printDosen(int NIP){
       String sql = "Select * FROM Dosen WHERE NIP="+NIP;
       try{
           statement = connection.createStatement();    
           ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               String Nama = rs.getString(2);
               
               System.out.println("NIP: "+NIP);
               System.out.println("Nama: "+Nama);
           }
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    
    public void printDosen(){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Dosen";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
               int NIP = rs.getInt(1);
               String Nama = rs.getString(2);
               
               System.out.println("NIP: "+NIP);
               System.out.println("Nama: "+Nama);
           }
        } catch(SQLException se){
                se.printStackTrace();
            }
    }
    
    public void printKelas(int IdKelas){
       String sql = "Select * FROM Kelas WHERE ID_KELAS="+IdKelas;
       try{
           statement = connection.createStatement();    
           ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               String Dosen = rs.getString(2);
               int nip = rs.getInt(3);
               String Matakuliah = rs.getString(4);
               int kodematkul = rs.getInt(5);
               
               System.out.println("ID Kelas: "+IdKelas);
               System.out.println("Dosen: "+Dosen);
               System.out.println("Nip: "+nip);
               System.out.println("Matakuliah: "+Matakuliah);
               System.out.println("Kode Matakuliah: "+kodematkul);
           }
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    public void printKelas(){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Kelas";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
               int IdKelas = rs.getInt(1);
               String Dosen = rs.getString(2);
               int nip = rs.getInt(3);
               String Matakuliah = rs.getString(4);
               int kodematkul = rs.getInt(5);
               
               System.out.println("ID Kelas: "+IdKelas);
               System.out.println("Dosen: "+Dosen);
               System.out.println("Nip: "+nip);
               System.out.println("Matakuliah: "+Matakuliah);
               System.out.println("Kode Matakuliah: "+kodematkul);
            }
        }   catch(SQLException se){
                se.printStackTrace();
            }
    }
    
    public void printKelasMatkul(int kodematkul){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Kelas Where KODE_MATAKULIAH="+kodematkul;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
               int IdKelas = rs.getInt(1);
               String Dosen = rs.getString(2);
               int nip = rs.getInt(3);
               String Matakuliah = rs.getString(4);
               
               System.out.println("ID Kelas: "+IdKelas);
               System.out.println("Dosen: "+Dosen);
               System.out.println("Nip: "+nip);
               System.out.println("Matakuliah: "+Matakuliah);
               System.out.println("Kode Matakuliah: "+kodematkul);
            }
        }   catch(SQLException se){
                se.printStackTrace();
            }
    }
    
    public void printKelasDosen(int kodedosen){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Kelas Where NIP="+kodedosen;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
               int IdKelas = rs.getInt(1);
               String Dosen = rs.getString(2);
               String Matakuliah = rs.getString(4);
               int kodematkul = rs.getInt(5);
               
               System.out.println("ID Kelas: "+IdKelas);
               System.out.println("Dosen: "+Dosen);
               System.out.println("Nip: "+kodedosen);
               System.out.println("Matakuliah: "+Matakuliah);
               System.out.println("Kode Matakuliah: "+kodematkul);
            }
        }   catch(SQLException se){
                se.printStackTrace();
            }
    }
    
    public void printMatakuliah(int KODE){
       String sql = "Select * FROM Matakuliah WHERE KODE_MATAKULIAH="+KODE;
       try{
           statement = connection.createStatement();    
           ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               String Nama = rs.getString(2);
               Integer Sks = rs.getInt(3);
               
               System.out.println("Kode matakuliah: "+KODE);
               System.out.println("Nama: "+Nama);
               System.out.println("Sks: "+Sks);
           }
       }catch(SQLException se){
           se.printStackTrace();
       }
   }
    
    public void printMatakuliah(){
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Matakuliah";
            ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               int KODE = rs.getInt(1);
               String Nama = rs.getString(2);
               Integer Sks = rs.getInt(3);
               
               System.out.println("Kode matakuliah: "+KODE);
               System.out.println("Nama: "+Nama);
               System.out.println("Sks: "+Sks);
           }
        } catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    public Matakuliah getMatakuliah(int kodemk) throws Exception{
       Matakuliah p = null;
       String sql = "Select * FROM Matakuliah WHERE KODE_MATAKULIAH="+kodemk;
       ResultSet rs = statement.executeQuery(sql);
       while(rs.next()){
           p = new Matakuliah(rs.getString(2),rs.getInt(3),rs.getInt(1));
       }
       return p;
    }
    
    public Dosen getDosen(int Nip) throws Exception{
       Dosen p = null;
       String sql = "Select * FROM Dosen WHERE NIP="+Nip;
       ResultSet rs = statement.executeQuery(sql);
       while(rs.next()){
           p = new Dosen(rs.getString(2),rs.getInt(1));
       }
       return p;
    }
    
    public Kelas getKelas(int IdKelas) throws Exception{
       Kelas p = null;
       String sql = "Select * FROM Kelas WHERE ID_KELAS="+IdKelas;
       ResultSet rs = statement.executeQuery(sql);
      
       while (rs.next())
       {
           p = new Kelas(new Matakuliah(null, 0, rs.getInt("KODE_MATAKULIAH")), new Dosen(null, rs.getInt("NIP")), rs.getInt("ID_KELAS"));
       }
       
       //setDoenDosen
        Dosen d = getDosen(p.getDosen().getNip());
        p.setDosen(d);
        
        //lanjutin setMatkul
        Matakuliah m = getMatakuliah(p.getMatakuliah().getKodeMatkul());
        p.setMatakuliah(m);
       return p;
    }
    
    public Mahasiswa getMahasiswa(int NIM) throws Exception{
       Mahasiswa p = null;
       String sql = "Select * FROM Mahasiswa WHERE NIM="+NIM;
       ResultSet rs = statement.executeQuery(sql);
       while(rs.next()){
           //Kelas k = getKelas(rs.getInt(3));
           p = new Mahasiswa(rs.getInt(1),rs.getString(4),rs.getString(5), new Kelas(null,null,rs.getInt("ID_KELAS")), rs.getString(2));
       }
       int i = 0;
       Kelas k;
       ArrayList <Kelas> k1 = new ArrayList<>();
       do{
           k = getKelas(p.getPilihan(i).getIdKelas());
           p.setPilihan(k, i);
           i++;
       }while(i<k1.size());
       return p;
    }
    
    public Mahasiswa getMahasiswaUser(String User) throws Exception{
       Mahasiswa p = null;
       String sql = "Select * FROM Mahasiswa WHERE UsernameMhs='"+User+"'";
       ResultSet rs = statement.executeQuery(sql);
       while(rs.next()){
           //Kelas k = getKelas(rs.getInt(3));
           p = new Mahasiswa(rs.getInt(1),rs.getString(4),rs.getString(5), new Kelas(null,null,rs.getInt("ID_KELAS")), rs.getString(2));
       }
       int i = 0;
       Kelas k;
       ArrayList<Kelas> k1 = new ArrayList<>();
       do{
           k = getKelas(p.getPilihan(i).getIdKelas());
           p.setPilihan(k, i);
           i++;
       }while(i<k1.size());
       return p;
    }
    
    public Mahasiswa getMahasiswaPass(String Pass) throws Exception{
       Mahasiswa p = null;
       String sql = "Select * FROM Mahasiswa WHERE Password='"+Pass+"'";
       ResultSet rs = statement.executeQuery(sql);
       while(rs.next()){
           //Kelas k = getKelas(rs.getInt(3));
           p = new Mahasiswa(rs.getInt(1),rs.getString(4),rs.getString(5), new Kelas(null,null,rs.getInt("ID_KELAS")), rs.getString(2));
       }
       int i = 0;
       Kelas k;
       ArrayList<Kelas> k1 = new ArrayList<>();
       do{
           k = getKelas(p.getPilihan(i).getIdKelas());
           p.setPilihan(k, i);
           i++;
       }while(i<k1.size());
       return p;
    } 
    public void mainMenu() {
        try{
            getKoneksi();
        }catch(Exception e){
            System.out.println("Tidak terkoneksi");
        }
        try{
            CreateTable();
        }catch(Exception e){
            System.out.println("Tabel telah dibuat");
        }
        int pilihan1 = 1;
        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
         
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
                        String UserAdm = huruf.next();
                        System.out.print("Masukkan Password Admin : ");
                        String PassAdm = huruf.next();
                        
                        if ((UserAdm.equals(admin.getUsernameAdm())) && (PassAdm.equals(admin.getPasswordAdm()))) {
                            int z = 0;
                            do{
                                System.out.println("SELAMAT DATANG ADMIN");
                                System.out.println("Silahkan pilih menu Admin yang tersedia: ");
                                System.out.println("1. Matakuliah");
                                System.out.println("2. Dosen");
                                System.out.println("3. Mahasiswa");
                                System.out.println("4. Kelas");
                                System.out.println("0. Keluar");
                                System.out.print("pilihan: ");
                                try{
                                    int pil = angka.nextInt();
                                    switch(pil){
                                    case 1:
                                        int z1 = 0;
                                        do{
                                            System.out.println("Pilih menu pada Matakuliah: ");
                                            System.out.println("1. Tambah Matakuliah ke dalam database");
                                            System.out.println("2. Kurang Matakuliah dalam database");
                                            System.out.println("3. Tampil Matakuliah dalam database");
                                            System.out.println("4. Masukkan Matakuliah dalam kelas");
                                            System.out.println("5. Delete Matakuliah dalam kelas");
                                            System.out.println("6. Tampil matakuliah dalam kelas ");
                                            System.out.println("0. Keluar");
                                            System.out.print("pilihan: ");
                                            try{
                                                int pilmatkul;
                                                pilmatkul = angka.nextInt();
                                                System.out.println();
                                                switch(pilmatkul){
                                                case 1:
                                                    System.out.print("Masukkan Nama: ");
                                                    String nama;
                                                    nama = huruf.next();
                                                    System.out.println();
                                                    System.out.print("Masukkan Sks: ");
                                                    int sks; 
                                                    sks = angka.nextInt();
                                                    System.out.println();
                                                    System.out.print("Masukkan Kode Matkul: ");
                                                    int kode;
                                                    kode = angka.nextInt();
                                                    Matakuliah m = new Matakuliah(nama,sks,kode);
                                                    
                                                    SaveMatakuliah(m);
                                                    System.out.println("Berhasil memasukkan data");
                                                break;
                                                
                                                case 2:
                                                    //System.out.println(DaftarMatakuliah.get(0));
                                                    System.out.print("Masukan kode Matkul :");
                                                    int kodemk=angka.nextInt();
                                                    
                                                    //String x = huruf.next();
                                                    try{
                                                        System.out.println(getMatakuliah(kodemk));
                                                        deleteMatakuliah(kodemk);    
                                                        
                                                    } catch(Exception e){
                                                        System.out.println("Kode yang dimasukkan salah");
                                                    }
                                                   
                                                break;
                                                case 3:
                                                    System.out.println("Daftar Matakuliah");
                                                    printMatakuliah();
                                                    System.out.println();
                                                break;
                                                case 4:
                                                    System.out.print("Masukkan Nama: ");
                                                    //String nama;
                                                    nama = huruf.next();
                                                    System.out.println();
                                                    System.out.print("Masukkan Sks: ");
                                                    //int sks; 
                                                    sks = angka.nextInt();
                                                    System.out.println();
                                                    System.out.print("Masukkan Kode matakuliah: ");
                                                    int kodemk2=angka.nextInt();
                                                    Matakuliah mk2 = new Matakuliah(nama,sks,kodemk2);
                                                    try{
                                                            if(getMatakuliah(kodemk2)!=null){
                                                                System.out.print("masukan kode id kelas :");
                                                                int kodek;
                                                                kodek = angka.nextInt();
                                                                if(getKelas(kodek)!=null){
                                                                    Kelas k1 = new Kelas(mk2,getKelas(kodek).getDosen(),kodek);
                                                                    SaveKelas(k1);
                                                                }
                                                            } 
                                                    } catch(Exception e){
                                                            e.printStackTrace();
                                                      }
                                                break;
                                                case 5:
                                                    System.out.print("Masukan kode kelas :");
                                                    int kodek1=angka.nextInt();
                                                    try{
                                                        if (getKelas(kodek1)!=null){
                                                            System.out.print("Masukkan kode matakuliah yang ingin dihapus: ");
                                                            int kodemk1 = angka.nextInt();
                                                            if (getMatakuliah(kodemk1)!=null){
                                                                deleteKelasD(kodek1,kodemk1);
                                                            }
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    } 
                                                break;
                                                case 6:
                                                    System.out.println("Daftar Matakuliah Dalam kelas");
                                                    System.out.print("Masukkan kode matakuliah: ");
                                                    int kodemk3 = angka.nextInt();
                                                    try{
                                                        if (getMatakuliah(kodemk3)!=null){
                                                            printKelasMatkul(kodemk3);
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                break;
                                                case 0:
                                                    z1=1;
                                                break;
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus antara 1 sampai 6");
                                                }
                                        }while(z1!=1);
                                    break;
                                    case 2:
                                        int z2 = 0;
                                        do{
                                            System.out.println("Pilih menu pada dosen: ");
                                            System.out.println("1. Tambah Dosen pada database");
                                            System.out.println("2. Delete Dosen pada database");
                                            System.out.println("3. Tampil Dosen pada database");
                                            System.out.println("4. Masukkan Dosen pada kelas");
                                            System.out.println("5. Delete Dosen pada kelas");
                                            System.out.println("6. Tampil Dosen pada kelas");
                                            System.out.println("0. Keluar");
                                            System.out.print("Pilihan: ");
                                            try{
                                                int pildsn;
                                                pildsn = angka.nextInt();
                                                System.out.println();
                                                switch(pildsn){
                                                case 1:
                                                    System.out.println("Masukkan nama: ");
                                                    String nama;
                                                    nama = huruf.next();
                                                    System.out.println();
                                                    System.out.println("Masukkan NIP: ");
                                                    int nip;
                                                    nip = angka.nextInt();
                                                    Dosen d = new Dosen(nama,nip);
                                                    SaveDosen(d);
                                                    System.out.println("Berhasil memasukkan data");
                                                break;
                                                case 2:
                                                    System.out.print("Masukan NIP dosen :");
                                                    int koded=angka.nextInt();
                                                    try{
                                                            System.out.println(getDosen(koded));
                                                            deleteDosen(koded);
                                                        
                                                    }catch(Exception e){
                                                        e.getMessage();
                                                    }
                                                break;
                                                case 3:
                                                    System.out.print("Daftar Dosen");
                                                    printDosen();
                                                    System.out.println();
                                                break;
                                                case 4:
                                                    System.out.print("Masukkan NIP Dosen: ");
                                                    int nip1 = angka.nextInt();
                                                    try{
                                                        if (getDosen(nip1)!=null){
                                                            System.out.println("Masukkan Id Kelas yang akan dimasukkan: ");
                                                            int kodek3 = angka.nextInt();
                                                            if(getKelas(kodek3)!=null){
                                                                Kelas k = new Kelas(getKelas(kodek3).getMatakuliah(),getDosen(nip1),kodek3);
                                                                SaveKelas(k);
                                                            }
                                                        }
                                                    }catch(Exception e){
                                                        e.getMessage();
                                                    }
                                                break;
                                                case 5:
                                                    System.out.print("Masukan kode kelas :");
                                                    int kodek1=angka.nextInt();
                                                    try{
                                                        if (getKelas(kodek1)!=null){
                                                            System.out.print("Masukkan id Dosen: ");
                                                            int koded2 = angka.nextInt();
                                                            if (getDosen(koded2)!=null){
                                                                deleteKelasDosen(kodek1,koded2);
                                                            }
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                break;
                                                case 6:
                                                    System.out.println("Daftar Dosen Dalam kelas");
                                                    System.out.print("Masukkan kode NIP dosen: ");
                                                    int koded3;
                                                    koded3 = angka.nextInt();
                                                    try{
                                                        if(getDosen(koded3)!=null){
                                                            printKelasDosen(koded3);
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                break;
                                                case 0:
                                                    z2=1;
                                                break;
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus antara 1 sampai 6");
                                                }
                                        }while(z2!=1);
                                    break;
                                    case 3:
                                        int z3 = 0;
                                        do{
                                            System.out.println("Pilih menu pada mahasiswa: ");
                                            System.out.println("1. Tambah Mahasiswa pada database");
                                            System.out.println("2. Delete Mahasiswa pada database");
                                            System.out.println("3. Tampil Mahasiswa pada database");
                                            System.out.println("0. Keluar");
                                            System.out.print("Pilihan: ");
                                            try{
                                                int pilmhs;
                                                pilmhs = angka.nextInt();
                                                switch(pilmhs){
                                                case 1:
                                                    System.out.print("Masukkan nama: ");
                                                    String nama;
                                                    nama = huruf.next();
                                                    System.out.println();
                                                    System.out.println("Masukkan NIM: ");
                                                    int nim;
                                                    nim = huruf.nextInt();
                                                    System.out.println();
                                                    System.out.println("Masukkan username: ");
                                                    String usrname;
                                                    usrname = huruf.next();
                                                    System.out.println();
                                                    System.out.println("Masukkan password: ");
                                                    String pass;
                                                    pass = huruf.next();
                                                    int kodek[] = new int[10];
                                                    int idx = 0;
                                                    int y;
                                                    do{
                                                        System.out.println("Masukkan ID Kelas: ");
                                                        kodek[idx] = angka.nextInt();
                                                        try{
                                                                System.out.println(getKelas(kodek[idx]));
                                                                Mahasiswa m = new Mahasiswa(nim,usrname,pass,getKelas(kodek[idx]),nama);
                                                                SaveMahasiswa(m,idx);
                                                            
                                                        } catch(Exception e){
                                                            e.printStackTrace();
                                                        }
                                                        idx++;
                                                        System.out.println("Apakah ingin menambah jumlah kelas?(1/0)");
                                                        y = angka.nextInt();
                                                    } while(y!=0);
                                                break;
                                                case 2:
                                                    System.out.println("Masukkan NIM mahasiswa yang akan di delete");
                                                    int nim2 = angka.nextInt();
                                                    try{
                                                            System.out.println(getMahasiswa(nim2));
                                                            deleteMahasiswa(nim2);
                                                        
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                break;
                                                case 3:
                                                    System.out.println("Tampil Mahasiswa");
                                                    printMahasiswa();
                                                break;
                                                case 0:
                                                    z3 = 1;
                                                break;
                                                
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus diantara 1 sampai 3");
                                                }
                                        }while(z3!=1);
                                    break;
                                    case 4:
                                        int z4 = 0;
                                        do{
                                            System.out.println("Pilih menu pada Kelas");
                                            System.out.println("1. Tambah Kelas pada database");
                                            System.out.println("2. Delete Kelas pada database");
                                            System.out.println("3. Tampil Kelas pada database");
                                            System.out.println("0. Keluar");
                                            System.out.print("Pilihan: ");
                                            try{
                                                int pilkls;
                                                pilkls = angka.nextInt();
                                                System.out.println();
                                                switch(pilkls){
                                                    case 1:
                                                        System.out.print("Input id matakuliah: ");
                                                        int kodemk2 = angka.nextInt();
                                                        try{
                                                            if(getMatakuliah(kodemk2)!=null){
                                                                System.out.print("Input Nip Dosen: ");
                                                                int nip = angka.nextInt();
                                                                if (getDosen(nip)!=null){
                                                                    System.out.print("Masukkan id Kelas: ");
                                                                    int kodek2 = angka.nextInt();
                                                                    Kelas k = new Kelas(getMatakuliah(kodemk2),getDosen(nip),kodek2);
                                                                    SaveKelas(k);
                                                                }
                                                            }
                                                        } catch(Exception e){
                                                            e.getMessage();
                                                        }
                                                break;
                                                case 2:
                                                    System.out.print("Masukkan id kelas: ");
                                                    int kodek3 = angka.nextInt();
                                                    try{
                                                            System.out.println(getKelas(kodek3));
                                                            deleteKelas(kodek3);
                                                        
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }
                                                break;
                                                case 3:
                                                    try{
                                                        
                                                            printKelas();
                                                        
                                                    } catch(Exception e){
                                                        e.getMessage();
                                                    }
                                                break;
                                                case 0:
                                                    z4 = 1;
                                                break;
                                                
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                }
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus diantara 1 sampai 3");
                                                }
                                        }while(z4!=1);
                                    break;    
                                    case 0:
                                        z=1;
                                    break;
                                    
                                    default:
                                        System.out.println("Inputan anda salah");
                                    break;
                                    } 
                                }   catch (InputMismatchException e){
                                        System.out.println("Inputan harus antara 1 sampai 2");
                                    }
                            }while(z!=1);
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                            break;
                        }
                    break;   
                    case 2 :
                        System.out.print("Masukkan Username Mahasiswa : ");
                        String UserMhs = huruf.next();
                        try{
                            if (getMahasiswaUser(UserMhs)!=null)  {
                                System.out.print("Masukkan Password Mahasiswa : ");
                                String PassMhs = huruf.next();
                                if (getMahasiswaPass(PassMhs)!=null){
                                    /*ArrayList <Kelas> m = new ArrayList<>();
                                    ArrayList <Mahasiswa> m3 = new ArrayList<>();
                                    int z = 0;
                                    Kelas k;
                                    do{
                                        Mahasiswa m2 = new Mahasiswa(getMahasiswaPass(PassMhs).getNim(), getMahasiswaUser(UserMhs).getUsernameMhs(),getMahasiswaPass(PassMhs).getPasswordMhs(),getMahasiswaPass(PassMhs).getPilihan(z), getMahasiswaPass(PassMhs).getNama());
                                        m3.add(m2);
                                        k = getKelas(m2.getPilihan(z).getIdKelas());
                                        m.add(k);// = new Mahasiswa(getMahasiswaPass(PassMhs).getNim(), getMahasiswaUser(UserMhs).getUsernameMhs(),getMahasiswaPass(PassMhs).getPasswordMhs(),getMahasiswaPass(PassMhs).getPilihan(z), getMahasiswaPass(PassMhs).getNama());
                                        z++;
                                    } while(z<=m.size());*/
                                    int t = 1;
                                    do{
                                        System.out.println("SELAMAT DATANG");
                                        System.out.println("Pilih Menu: ");
                                        System.out.println("1. Pilih Kelas");
                                        System.out.println("2. Batal Pilih Kelas");
                                        System.out.println("3. Lihat Pilihan Kelas");
                                        System.out.println("4. Lihat Dosen Kelas");
                                        System.out.println("5. Tampil Kelas dalam database");
                                        System.out.println("0. Keluar");
                                        System.out.println("Pilihan: ");
                                        try{
                                            int pilmahs;
                                            pilmahs = angka.nextInt();
                                            switch(pilmahs){
                                            case 1:
                                                printKelas();
                                                int kodek[] = new int[10];
                                                        int idx = 0;
                                                        int y;
                                                        do{
                                                            System.out.println("Masukkan ID Kelas: ");
                                                            kodek[idx] = angka.nextInt();
                                                            try{
                                                                    System.out.println(getKelas(kodek[idx]));
                                                                    Mahasiswa m2 = new Mahasiswa(getMahasiswaPass(PassMhs).getNim(),getMahasiswaUser(UserMhs).getUsernameMhs(),getMahasiswaPass(PassMhs).getPasswordMhs(),getKelas(kodek[idx]),getMahasiswaPass(PassMhs).getNama());
                                                                    SaveMahasiswa(m2,idx);

                                                            } catch(Exception e){
                                                                e.printStackTrace();
                                                            }
                                                            idx++;
                                                            System.out.println("Apakah ingin menambah jumlah kelas?(1/0)");
                                                            y = angka.nextInt();
                                                        } while(y!=0);
                                            break;
                                            case 2:
                                                System.out.println("Masukkan id kelas yang akan dihapus: ");
                                                int kodek5 = angka.nextInt();
                                                if (getKelas(kodek5)!=null){
                                                    System.out.println(getKelas(kodek5));
                                                    deleteMahasiswa(getMahasiswaPass(PassMhs).getNim(),kodek5);
                                                }
                                            break;
                                            case 3:
                                                printMahasiswa(getMahasiswaPass(PassMhs).getNim());
                                            break;
                                            case 4:
                                                System.out.println("Masukkan Id Kelas: ");
                                                int kodek6 = angka.nextInt();
                                                if (getKelas(kodek6)!=null){
                                                    printKelas(getKelas(kodek6).getIdKelas());
                                                }
                                            break;
                                            case 5:
                                                printKelas();
                                            break;
                                            case 0 :
                                                System.out.println("TERIMA KASIH");
                                                t = 0;
                                            break;
                                            default :
                                                System.out.println("Menu tidak ada");
                                            break;
                                            }
                                        
                                    } catch (InputMismatchException e){
                                        System.out.println("Inputan harus diantara 1 sampai 5");
                                    }
                                    } while(t!=0);
                                }
                                else{
                                    System.out.println("Data inputan password Mahasiswa salah");
                                }
                            }
                            else{
                                System.out.println("Data inputan Username Mahasiswa salah");
                            }
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    break;
                    case 0 : 
                        System.out.println("TERIMA KASIH");
                        pilihan1 = 0;
                }
            } catch (InputMismatchException e) {
                    System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
                }
        }
    }    
}

