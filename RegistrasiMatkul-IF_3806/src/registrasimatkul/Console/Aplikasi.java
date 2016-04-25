package registrasimatkul.Console;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
import java.util.Iterator;
import registrasimatkul.Model.*;
import registrasimatkul.Controller.Mahasiswa.SubMahasiswaLog;


public class Aplikasi implements Serializable {
    private ArrayList<Dosen> DaftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> DaftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> DaftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> DaftarMatakuliah = new ArrayList<Matakuliah>();
    
    //private static ArrayList<Kelas> kelas1 = new ArrayList<Kelas>();
    
    public String[] getListMatakuliah(){
        //ArrayList<Matakuliah> t = new ArrayList<Matakuliah>();
        ArrayList<String> KodeMatkul = new ArrayList<String>();
        for(Matakuliah mk10 : DaftarMatakuliah){
            KodeMatkul.add(String.valueOf(mk10.getKodeMatkul()));
            
        }
        return (String[]) KodeMatkul.toArray(new String[0]);
    }
    
    public String[] getListDosen(){
        //return (String[]) DaftarDosen.toArray(new String[0]);
        //ArrayList<String> KodeMatkul = new ArrayList<String>();
        //for()
        ArrayList<String> NIP = new ArrayList<String>();
        for(Dosen dsn9 : DaftarDosen){
            NIP.add(String.valueOf(dsn9.getNip()));
        }
        return (String[]) NIP.toArray(new String[0]);
    }
    
    public String[] getListMahasiswa(){
        ArrayList<String> Mhs23 = new ArrayList<String>();
        for(Mahasiswa mhs22 : DaftarMahasiswa){
            Mhs23.add(String.valueOf(mhs22.getNim()));
        }
        return (String[]) Mhs23.toArray(new String[0]);
//return (String[]) DaftarKelas.toArray(new String[0]);
    }
    
    public String[] getListKelas(){
        ArrayList<String> KodeKelas = new ArrayList<String>();
        for(Kelas kls : DaftarKelas){
            KodeKelas.add(String.valueOf(kls.getIdKelas()));
        }
        return (String[]) KodeKelas.toArray(new String[0]);
//return (String[]) DaftarMahasiswa.toArray(new String[0]);
    }
    
    public String[] getListMahasiswaKelas(){
        SubMahasiswaLog x = new SubMahasiswaLog();
        int NIM = 0;
        
        //int nim = x.verifyLog(NIM);
        ArrayList<String> mhsKelas = new ArrayList<String>();
        for(Mahasiswa mhs3 : DaftarMahasiswa){
            if(mhs3.getNim()==x.verifyLog2()){
       //System.out.println();
                int i = 0;
                                                        //int a = i++;
                do{
       //System.out.println("Kode Kelas: "+mhs3.getPilihan(i).getIdKelas());
                    mhsKelas.add(String.valueOf(mhs3.getPilihan(i).getIdKelas()));                                            //System.out.println("Nama Matakuliah: "+mhs3.getPilihan(i).getMatakuliah().getNama());
                                                            //System.out.println();
                                                            //a++;
                    i++;
                }while(i < mhs3.LuasArray());
            }
        }
        return (String[]) mhsKelas.toArray(new String[0]);
    }
    
    public ArrayList<Kelas> asd(int KodeMatkul){
        ArrayList<Kelas> x11 = new ArrayList<Kelas>();
        for(Kelas k : DaftarKelas){
            if(k.getMatakuliah().getKodeMatkul()==KodeMatkul){
                x11.add(k);
            }
        }
        return x11;
    }
    
    public ArrayList<Kelas> Dosen_6(int NIP){
        ArrayList<Kelas> x111 = new ArrayList<Kelas>();
        for(Kelas k : DaftarKelas){
            if(k.getDosen().getNip()==NIP){
                x111.add(k);
            }
        }
        return x111;
    }
    
    public void addMatakuliah(Matakuliah m){
        DaftarMatakuliah.add(m);
    }
    
    public void removeMatakuliah(Matakuliah m){
        DaftarMatakuliah.remove(m);
    }
    
    public void deleteMatakuliah_Array(int kode){
        Matakuliah zy = null;
        for(Matakuliah mk : DaftarMatakuliah){
        if(mk.getKodeMatkul() == kode){
            zy = mk;
        }
    }
        //deleteMatakuliah(kodemk);
        Iterator<Matakuliah> iterator2 = DaftarMatakuliah.iterator();
        while(iterator2.hasNext()){
            Matakuliah values3 = iterator2.next();
            if(values3.equals(zy)){
                iterator2.remove();
            }
        }        
    }
    
    public void deleteMatakuliah_Array2(int k, int m){
        Kelas x4 = null;
        for(Kelas k3 : DaftarKelas){
            if(k3.getIdKelas()==k){
                if(k3.getMatakuliah().getKodeMatkul()==m){
                    x4 = k3;
                }
            }
        }
            Iterator<Kelas> it = DaftarKelas.iterator();
            while(it.hasNext()){
                Kelas valueer = it.next();
                if(valueer.equals(x4)){
                    it.remove();
                }
            }
    }
    
    public void addDosen(Dosen m){
        DaftarDosen.add(m);
    }
    
    public void removeDosen(Dosen m){
        DaftarDosen.remove(m);
    }
    
    public void removeDosen_Array(int Nip){
        Iterator<Dosen> ite = DaftarDosen.iterator();
        Dosen x = null;
        for(Dosen d2 : DaftarDosen){
            if(d2.getNip()==Nip){
                x = d2;
            }
        }
        while(ite.hasNext()){
            Dosen value = ite.next();
            if(value.equals(x)){
                ite.remove();
            }
        }
    }
    
    public void removeDosen_Array2(int k, int dsn){
        Kelas x3 = null;
        for(Kelas k2 : DaftarKelas){
            if(k2.getIdKelas()==k){
                if(k2.getDosen().getNip()==dsn){
                    x3 = k2;
                }
            }
        }
        Iterator<Kelas> iter = DaftarKelas.iterator();
        while(iter.hasNext()){
            Kelas values = iter.next();
                if(values.equals(x3)){
                    iter.remove();
                }
        }
    }
    
    public void addKelas(Kelas m){
        DaftarKelas.add(m);
    }
    
    public void removeKelas(Kelas m){
        DaftarKelas.remove(m);
    }
    
    public void addKelas_1(int kodemk2, int koded2, int kodek){
        for(Matakuliah mk : DaftarMatakuliah){
            if(mk.getKodeMatkul()==kodemk2){
                //System.out.print("input Nip Dosen: ");
                //int koded2 = angka.nextInt();
                for(Dosen d : DaftarDosen){
                    if(d.getNip()==koded2){
                        //System.out.print("Masukkan id Kelas baru: ");
                        //int kodek = angka.nextInt();
      //Kelas x2 = null;
                        Kelas k = new Kelas(mk,d,kodek);
                        DaftarKelas.add(k);
                        SaveKelas(k);
                    }
                }
            }
        }
    }
    
    public void removeKelas_2(int kodek3){
        Kelas x = null;
        for(Kelas k : DaftarKelas){
            if(k.getIdKelas()==kodek3){
                x = k;
            }
        }
        deleteKelas(kodek3);
        Iterator<Kelas> ite = DaftarKelas.iterator();
        while(ite.hasNext()){
            Kelas value = ite.next();
            if(value.equals(x)){
                ite.remove();
            }
        }
    }
    public void addMahasiswa(Mahasiswa m){
        DaftarMahasiswa.add(m);
    }
    
    public void Mahasiswa_1(int nim, String user, String pass, int kode_kelas, String nama){
        for(Kelas yz : DaftarKelas){
            try{
                if(yz.getIdKelas()==kode_kelas){
                //System.out.println(getKelas(kodek[idx]));
                Mahasiswa m = new Mahasiswa(nim,user,pass,yz,nama);
                DaftarMahasiswa.add(m);
                SaveMahasiswa(m,kode_kelas);
            }
        } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Kelas> Mahasiswa_3(int nim){
        ArrayList<Kelas> k22 = new ArrayList<Kelas>();
        for(Mahasiswa m : DaftarMahasiswa){
            if(m.getNim()==nim){
                for(Kelas k : DaftarKelas){
                    if(m.getPilihan2(k.getIdKelas())!=null){
                        k22.add(k);
                    }
                }
            }
        }
        return k22;
    }
    
    public void removeMahasiswa_2(int nim){
        Mahasiswa xy = null;
        for(Mahasiswa m : DaftarMahasiswa){
            if(m.getNim()==nim){
                xy = m;
            }
        }
        deleteMahasiswa(nim);
        Iterator<Mahasiswa> iterator = DaftarMahasiswa.iterator();
        while(iterator.hasNext()){
            Mahasiswa values2 = iterator.next();
            if(values2.equals(xy)){
                iterator.remove();
            }
        }
    }
    
    public void subMahasiswa_1(Mahasiswa q, int idKelas){
        for(Kelas kelas : DaftarKelas){                            //System.out.println(getKelas(kodek[idx]));
            if(kelas.getIdKelas()==idKelas){
                Mahasiswa m2 = new Mahasiswa(q.getNim(),q.getUsernameMhs(),q.getPasswordMhs(),kelas,q.getNama());
                                                                        //SaveMahasiswa(m2,idx);
                DaftarMahasiswa.add(m2);
                SaveMahasiswa(m2,idKelas);
            }
        }
    }
    
    public void subMahasiswa_2(int kodek5){
        //System.out.println("Masukkan id kelas yang akan dihapus: ");
        //int kodek5 = angka.nextInt();
        Mahasiswa yx = null;
        for(Mahasiswa mhs2 : DaftarMahasiswa){
                                                    //int i = 0;
                                                    //do{
            Kelas k2 = mhs2.getPilihan2(kodek5);
            if(k2!=null){
                                                    //if(mhs2.getPilihan2(kodek5).getIdKelas()==kodek5){
                yx = mhs2;
                                                        //DaftarKelas.remove(yx);
                                                        
            }
                                                    //i++;
                                                    //}while(i < mhs2.LuasArray());
        }
        deleteMahasiswa(yx.getNim(),kodek5);
                                                //System.out.println(yx.);
        Iterator<Mahasiswa> iterator3 = DaftarMahasiswa.iterator();
        while(iterator3.hasNext()){
            Mahasiswa values4 = iterator3.next();
            if(values4.equals(yx)){
                                                     
                iterator3.remove();
            }
        }
    }
    public Mahasiswa MhsLogin(int nim){
        Mahasiswa q = null;
        for(Mahasiswa mhs : DaftarMahasiswa){
                if(mhs.getNim()==nim){
                    q = mhs;
                }
        }
        return q;
    }
    
    public void removeMahasiswa(Mahasiswa m){
        DaftarMahasiswa.remove(m);
    }
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
                     "', "+p.getPilihan2(i).getIdKelas()+", '"+p.getUsernameMhs()+"', '"+p.getPasswordMhs()+"')";
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
               Mahasiswa m9;
               for(Kelas k9 : DaftarKelas){
                   if(k9.getIdKelas()==Kelas){
                       m9 = new Mahasiswa(NIM,User,Password,k9,Nama);
                       DaftarMahasiswa.add(m9);
                   }
               }
               
               //System.out.println("NIM: "+NIM);
               //System.out.println("Nama: "+Nama);
               //System.out.println("Kelas: "+Kelas);
               //System.out.println("Username: "+User);
               //System.out.println("Password: "+Password);
              
               //Mahasiswa m = new Mahasiswa(NIM,User,Password,Kelas,Nama);
               //DaftarMahasiswa.add(m);
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
            Dosen d9;
            while(rs.next()){
               int NIP = rs.getInt(1);
               String Nama = rs.getString(2);
               
               d9 = new Dosen(Nama,NIP);
               DaftarDosen.add(d9);
               //System.out.println("NIP: "+NIP);
               //System.out.println("Nama: "+Nama);
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
            Kelas k9;
            while(rs.next()){
               int IdKelas = rs.getInt(1);
               String Dosen = rs.getString(2);
               int nip = rs.getInt(3);
               String Matakuliah = rs.getString(4);
               int kodematkul = rs.getInt(5);
               for(Dosen d8 : DaftarDosen){
                   if(d8.getNip()==nip){
                       for(Matakuliah mk8 : DaftarMatakuliah){
                           if(mk8.getKodeMatkul()==kodematkul){
                               k9 = new Kelas(mk8, d8, IdKelas);
                               DaftarKelas.add(k9);
                           }
                       }
                   }
               }
               
               
               //System.out.println("ID Kelas: "+IdKelas);
               //System.out.println("Dosen: "+Dosen);
               //System.out.println("Nip: "+nip);
               //System.out.println("Matakuliah: "+Matakuliah);
               //System.out.println("Kode Matakuliah: "+kodematkul);
               //Kelas kx = new Kelas(rs.getInt(1),)
               //Dk9 = new Kelas()
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
        }   catch(Exception se){
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
            Matakuliah m9 = null;
            while(rs.next()){
               int KODE = rs.getInt(1);
               String Nama = rs.getString(2);
               int Sks = rs.getInt(3);
               
               //System.out.println("Kode matakuliah: "+KODE);
               //System.out.println("Nama: "+Nama);
               //System.out.println("Sks: "+Sks);
               m9 = new Matakuliah(Nama,Sks,KODE);
               DaftarMatakuliah.add(m9);
           }
        } catch(Exception se){
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
    
    public int[] getMatakuliahAll() throws Exception{
        int[] p = null;
        String sql = "Select KODE_MATAKULIAH From Matakuliah";
        ResultSet rs = statement.executeQuery(sql);
        int i = 0;
        while(rs.next()){
            Matakuliah m = new Matakuliah(rs.getString(2), rs.getInt(3), rs.getInt(1));
            p[i] = m.getKodeMatkul();
            i++;
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
       //if(p.getDosen()!=null){
            Dosen d = getDosen(p.getDosen().getNip());
            p.setDosen(d);
       //}
        
        //lanjutin setMatkul
        //if(p.getDosen()!=null){
            Matakuliah m = getMatakuliah(p.getMatakuliah().getKodeMatkul());
            p.setMatakuliah(m);
        //}
       return p;
    }
    public Mahasiswa getMahasiswa2(int nim){
        Mahasiswa p = null;
        for(Mahasiswa k : DaftarMahasiswa){
            if(k.getNim()==nim){
                for(Kelas k2 : DaftarKelas){
                    if(k.getPilihan2(k2.getIdKelas())!=null){
                        p = k;
                    }
                }
            }
        }
        return p;
    }
    
    public Mahasiswa getMahasiswa(int NIM) throws Exception{
       Mahasiswa p = null;
       //Kelas k = null;
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
           //k = getKelas(p.getPilihan(i).getIdKelas());
           k = getKelas(p.getPilihan(i).getIdKelas());
           //p.setPilihan(k, i);
           p.setPilihan(k, i);
           i++;
       }while(i<k1.size());
       /*for(Kelas k2 : DaftarKelas){
           if(k2.getIdKelas()==rs.getInt("ID_KELAS")){
               do{
                   p.setPilihan(k2, i);
                   i++;
               }while(i < p.LuasArray());
               i=0;
       }
       }*/
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
        printMatakuliah();
        printDosen();
        printKelas();
        printMahasiswa();
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
                                                    DaftarMatakuliah.add(m);
                                                    SaveMatakuliah(m);
                                                    System.out.println("Berhasil memasukkan data");
                                                break;
                                                
                                                case 2:
                                                    //System.out.println(DaftarMatakuliah.get(0));
                                                    System.out.print("Masukan kode Matkul :");
                                                    int kodemk=angka.nextInt();
                                                    Matakuliah zy = null;
                                                    for(Matakuliah mk : DaftarMatakuliah){
                                                            if(mk.getKodeMatkul() == kodemk){
                                                                zy = mk;
                                                            }
                                                    }
                                                    deleteMatakuliah(kodemk);
                                                    Iterator<Matakuliah> iterator2 = DaftarMatakuliah.iterator();
                                                    while(iterator2.hasNext()){
                                                        Matakuliah values3 = iterator2.next();
                                                        if(values3.equals(zy)){
                                                            iterator2.remove();
                                                        }
                                                    }
                                                    //String x = huruf.next();
                                                    //try{
                                                        //System.out.println(getMatakuliah(kodemk));
                                                        //int ai = 0;
                                                        
                                                        
                                                        //DaftarMatakuliah.remove(m1);
                                                    //} catch(Exception e){
                                                      //  System.out.println("Kode yang dimasukkan salah");
                                                    //}
                                                   
                                                break;
                                                case 3:
                                                    System.out.println("Daftar Matakuliah");
                                                    //int ab = 0;
                                                    //int c = 0;
                                                    //do{
                                                    for(Matakuliah mk : DaftarMatakuliah){
                                           
                                                            System.out.println("Nama Matakuliah: " +mk.getNama());
                                                            System.out.println("Sks Matakuliah: "+ mk.getSks());
                                                            System.out.println("Kode Matakuliah: "+ mk.getKodeMatkul());
                                                            System.out.println();
                                                        
                                                        //ab++;
                                                    }
                                                        //c = ab--;
                                                    //}while(DaftarMatakuliah.get(ab)!=null);
                                                    //printMatakuliah();
                                                    System.out.println();
                                                break;
                                                case 4:
                                                    /*System.out.print("Masukkan Nama: ");
                                                    //String nama;
                                                    nama = huruf.next();
                                                    System.out.println();
                                                    System.out.print("Masukkan Sks: ");
                                                    //int sks; 
                                                    sks = angka.nextInt();*/
                                                    System.out.println();
                                                    System.out.print("Masukkan Kode matakuliah: ");
                                                    int kodemk2=angka.nextInt();
                                                    for(Matakuliah mk2 : DaftarMatakuliah){
                                                        if(mk2.getKodeMatkul()==kodemk2){
                                                            System.out.print("Masukkan kode id Kelas: ");
                                                            int kodek = angka.nextInt();
                                                            System.out.print("Masukkan nip dosen yang mengajar pada kelas tersebut: ");
                                                            int koded5 = angka.nextInt();
                                                            Iterator<Kelas> ite = DaftarKelas.iterator();
                                                            Kelas x = null;
                                                            for(Kelas k2 : DaftarKelas){
                                                                if((k2.getIdKelas()==kodek)&&(k2.getDosen().getNip()==koded5)){
                                                                   x = k2;
                                                                } 
                                                            }
                                                            Kelas k3 = new Kelas(mk2,x.getDosen(),x.getIdKelas());
                                                            DaftarKelas.add(k3);
                                                            SaveKelas(k3);
                                                        }
                                                    }
                                                    //Matakuliah mk2 = new Matakuliah(nama,sks,kodemk2);
                                                    /*try{
                                                        int ac = 0;
                                                        do{
                                                            ac++;
                                                        }while((DaftarMatakuliah.get(ac)!=null)&&(DaftarMatakuliah.get(ac).getKodeMatkul()!=kodemk2));
                                                        if(DaftarMatakuliah.get(ac).getKodeMatkul()==kodemk2){
                                                            System.out.print("Masukkan Kode Id Kelas: ");
                                                            int kodek = angka.nextInt();
                                                            int ad = 0;
                                                            do{
                                                                ad++;
                                                            }while((DaftarKelas.get(ad)!=null)&&(DaftarKelas.get(ad).getIdKelas()==kodek));
                                                            if(DaftarKelas.get(ad).getIdKelas()==kodek){
                                                                Kelas k = new Kelas(DaftarKelas.get(ad).getMatakuliah(),DaftarKelas.get(ad).getDosen(),kodek);
                                                                DaftarKelas.add(k);
                                                            }
                                                        }
                                                            /*if(getMatakuliah(kodemk2)!=null){
                                                                Matakuliah mk2 = new Matakuliah(getMatakuliah(kodemk2).getNama(),getMatakuliah(kodemk2).getSks(),kodemk2);
                                                                System.out.print("masukan kode id kelas :");
                                                                int kodek;
                                                                kodek = angka.nextInt();
                                                                if(getKelas(kodek)!=null){
                                                                    Kelas k1 = new Kelas(mk2,getDosen(getKelas(kodek).getDosen().getNip()),kodek);
                                                                    //SaveKelas(k1);
                                                                    DaftarKelas.add(k1);
                                                                }
                                                            } 
                                                    } catch(Exception e){
                                                            e.printStackTrace();
                                                      }*/
                                                break;
                                                case 5:
                                                    System.out.print("Masukan kode kelas :");
                                                    int kodek1=angka.nextInt();
                                                    System.out.print("Masukkan kode matakuliah: ");
                                                    int kodemk1 = angka.nextInt();
                                                    Kelas x4 = null;
                                                    for(Kelas k3 : DaftarKelas){
                                                        if(k3.getIdKelas()==kodek1){
                                                            
                                                            if(k3.getMatakuliah().getKodeMatkul()==kodemk1){
                                                                //DaftarKelas.remove(k3);
                                                                x4 = k3;
                                                            }
                                                        }
                                                    }
                                                    deleteKelasD(kodek1,kodemk1);
                                                    Iterator<Kelas> it = DaftarKelas.iterator();
                                                    while(it.hasNext()){
                                                        Kelas valueer = it.next();
                                                        if(valueer.equals(x4)){
                                                            it.remove();
                                                        }
                                                    }
                                                    /*try{
                                                        int ae = 0;
                                                        do{
                                                            ae++;
                                                        }while((DaftarKelas.get(ae)!=null)&&(DaftarKelas.get(ae).getIdKelas()!=kodek1));
                                                        if(DaftarKelas.get(ae).getIdKelas()==kodek1){
                                                            System.out.print("Masukkan kode matakuliah yang ingin dihapus: ");
                                                            int kodemk1 = angka.nextInt();
                                                            int af = 0;
                                                            do{
                                                                af++;
                                                            }while((DaftarKelas.get(af)!=null)&&(DaftarKelas.get(af).getMatakuliah().getKodeMatkul()!=kodek1));
                                                            if(DaftarKelas.get(af).getMatakuliah().getKodeMatkul()==kodemk1){
                                                                if(ae==af){
                                                                    Kelas k = new Kelas(DaftarKelas.get(af).getMatakuliah(),DaftarKelas.get(ae).getDosen(),DaftarKelas.get(af).getIdKelas());
                                                                    DaftarKelas.remove(k);
                                                                }
                                                            }
                                                        }
                                                        /*if (getKelas(kodek1)!=null){
                                                            System.out.print("Masukkan kode matakuliah yang ingin dihapus: ");
                                                            int kodemk1 = angka.nextInt();
                                                            if (getMatakuliah(kodemk1)!=null){
                                                                deleteKelasD(kodek1,kodemk1);
                                                            }
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/ 
                                                break;
                                                case 6:
                                                    System.out.println("Daftar Matakuliah Dalam kelas");
                                                    System.out.print("Masukkan kode matakuliah: ");
                                                    int kodemk3 = angka.nextInt();
                                                    for(Kelas k5 : DaftarKelas){
                                                        if(k5.getMatakuliah().getKodeMatkul()==kodemk3){
                                                            System.out.println("Kode Kelas: "+k5.getIdKelas());
                                                            System.out.println("Nama Matkul: "+k5.getMatakuliah().getNama());
                                                            System.out.println("Kode Matkul: "+k5.getMatakuliah().getKodeMatkul());
                                                            System.out.println("Nama Dosen: "+k5.getDosen().getNama());
                                                            System.out.println();
                                                        }
                                                    }
                                                    /*int ag = 0;
                                                    try{
                                                        do{
                                                            ag++;
                                                        }while((DaftarKelas.get(ag)!=null)&&(DaftarKelas.get(ag).getMatakuliah().getKodeMatkul()!=kodemk3));
                                                        if(DaftarKelas.get(ag).getMatakuliah().getKodeMatkul()==kodemk3){
                                                            int ah = 0;
                                                            do{
                                                                System.out.print("Kode Kelas: "+DaftarKelas.get(ah).getIdKelas());
                                                                System.out.print("Nama Matakuliah: "+DaftarKelas.get(ah).getMatakuliah().getNama());
                                                                System.out.print("Sks Matakuliah: "+DaftarKelas.get(ah).getMatakuliah().getSks());
                                                                System.out.print("Kode Matakuliah: "+DaftarKelas.get(ah).getMatakuliah().getKodeMatkul());
                                                                System.out.print("Dosen Pengajar: "+DaftarKelas.get(ah).getDosen().getNama());
                                                                System.out.println();
                                                                ah++;
                                                            }while(DaftarKelas.get(ah)!=null);
                                                        }
                                                        /*if (getMatakuliah(kodemk3)!=null){
                                                            printKelasMatkul(kodemk3);
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/
                                                break;
                                                case 0:
                                                    z1=1;
                                                break;
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus antara 0 sampai 6");
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
                                                    DaftarDosen.add(d);
                                                    SaveDosen(d);
                                                    System.out.println("Berhasil memasukkan data");
                                                break;
                                                case 2:
                                                    System.out.print("Masukan NIP dosen :");
                                                    int koded=angka.nextInt();
                                                    Iterator<Dosen> ite = DaftarDosen.iterator();
                                                    //while (ite.hasNext()){
                                                        //if(Value.equals())
                                                    //}
                                                    Dosen x = null;
                                                    for(Dosen d2 : DaftarDosen){
                                                        if(d2.getNip()==koded){
                                                            x = d2;
                                                        }
                                                    }
                                                    //Dosen x = null;
                                                    //deleteDosen(koded);
                                                    deleteDosen(koded);
                                                            while(ite.hasNext()){
                                                                Dosen value = ite.next();
                                                                if(value.equals(x)){
                                                                    ite.remove();
                                                                }
                                                            }
                                                        //}
                                                    //}
                                                    /*int ai = 0;
                                                    try{
                                                            System.out.println(getDosen(koded));
                                                            do{
                                                                ai++;
                                                            }while((DaftarDosen.get(ai)!=null)&&(DaftarDosen.get(ai).getNip()!=koded));
                                                            if(DaftarDosen.get(ai).getNip()==koded){
                                                                Dosen d1 = new Dosen(DaftarDosen.get(ai).getNama(), DaftarDosen.get(ai).getNip());
                                                                DaftarDosen.remove(d1);
                                                            }
                                                            //deleteDosen(koded);
                                                        
                                                    }catch(Exception e){
                                                        e.getMessage();
                                                    }*/
                                                break;
                                                case 3:
                                                    System.out.print("Daftar Dosen");
                                                    for(Dosen d3 : DaftarDosen){
                                                        System.out.println("Nama Dosen: "+d3.getNama());
                                                        System.out.println("Nip Dosen: "+d3.getNip());
                                                        System.out.println();
                                                    }
                                                    /*int aj = 0;
                                                    do{
                                                        System.out.println("Nama Dosen: "+DaftarDosen.get(aj).getNama());
                                                        System.out.println("Nip Dosen: "+DaftarDosen.get(aj).getNip());
                                                        System.out.println();
                                                        aj++;
                                                    }while(DaftarDosen.get(aj)!=null);
                                                    //printDosen();*/
                                                    System.out.println();
                                                break;
                                                case 4:
                                                    System.out.print("Masukkan NIP Dosen: ");
                                                    int nip1 = angka.nextInt();
                                                    for(Dosen d4 : DaftarDosen){
                                                        if (d4.getNip()==nip1){
                                                            System.out.print("Masukkan kode kelas: ");
                                                            int kodek4 = angka.nextInt();
                                                            System.out.print("Masukkan kode matakuliah yang ingin diajar oleh dosen tersebut: ");
                                                            int kodemk5 = angka.nextInt();
                                                            Kelas x1 = null;
                                                            for(Kelas k4 : DaftarKelas){
                                                                if((k4.getIdKelas()==kodek4)&&(k4.getMatakuliah().getKodeMatkul()==kodemk5)){
                                                                    x1 = k4;
                                                                }
                                                            }
                                                            Kelas k5 = new Kelas(x1.getMatakuliah(),d4,x1.getIdKelas());
                                                            DaftarKelas.add(k5);
                                                            SaveKelas(k5);
                                                        }
                                                    }
                                                    /*int ak = 0;
                                                    try{
                                                        do{
                                                            ak++;
                                                        }while((DaftarDosen.get(ak)!=null)&&(DaftarDosen.get(ak).getNip()!=nip1));
                                                        if(DaftarDosen.get(ak).getNip()==nip1){
                                                            System.out.print("Masukkan Id Kelas: ");
                                                            int kodek3 = angka.nextInt();
                                                            int al = 0;
                                                            do{
                                                                al++;
                                                            }while((DaftarKelas.get(al)!=null)&&(DaftarKelas.get(al).getIdKelas()!=kodek3));
                                                            if(DaftarKelas.get(al).getIdKelas()==kodek3){
                                                                Kelas k = new Kelas(DaftarKelas.get(al).getMatakuliah(), DaftarDosen.get(ak), DaftarKelas.get(al).getIdKelas());
                                                                DaftarKelas.add(k);
                                                            }                                                            }
                                                        /*if (getDosen(nip1)!=null){
                                                            System.out.println("Masukkan Id Kelas yang akan dimasukkan: ");
                                                            int kodek3 = angka.nextInt();
                                                            if(getKelas(kodek3)!=null){
                                                                Kelas k = new Kelas(getKelas(kodek3).getMatakuliah(),getDosen(nip1),kodek3);
                                                                SaveKelas(k);
                                                            }
                                                        }
                                                    }catch(Exception e){
                                                        e.getMessage();
                                                    }*/
                                                break;
                                                case 5:
                                                    System.out.print("Masukan kode kelas :");
                                                    int kodek1=angka.nextInt();
                                                    System.out.print("Masukkan Nip Dosen: ");//+k2.getMatakuliah().getKodeMatkul()+": ");
                                                    int koded2 = angka.nextInt();
                                                    Kelas x3 = null;
                                                    for(Kelas k2 : DaftarKelas){
                                                        if(k2.getIdKelas()==kodek1){
                                                            /*System.out.print("Apakah ingin lanjut mendelete dosen "+k2.getDosen().getNama()+"?(1/0)");
                                                            int pilihan = angka.nextInt();
                                                            if (pilihan==0){
                                                                break;
                                                            }*/
                                                            //else{
                                                                //System.out.print("Masukkan Nip Dosen untuk matakuliah"+k2.getMatakuliah().getKodeMatkul()+": ");
                                                                //int koded2 = angka.nextInt();
                                                            //for(Dosen d4 : DaftarDosen){
                                                                if(k2.getDosen().getNip()==koded2){
                                                                    //DaftarKelas.remove(k2);
                                                                    x3 = k2;
                                                                }
                                                            //}
                                                            //}
                                                        }
                                                    }
                                                    deleteKelasDosen(kodek1,koded2);
                                                        Iterator<Kelas> iter = DaftarKelas.iterator();
                                                        while(iter.hasNext()){
                                                            Kelas values = iter.next();
                                                            if(values.equals(x3)){
                                                                iter.remove();
                                                            }
                                                        }
                                                    /*int am = 0;
                                                    try{
                                                        do{
                                                            am++;
                                                        }while((DaftarKelas.get(am)!=null)&&(DaftarKelas.get(am).getIdKelas()!=kodek1));
                                                        if(DaftarKelas.get(am).getIdKelas()==kodek1){
                                                            System.out.print("Masukkan Nip Dosen: ");
                                                            int koded2 = angka.nextInt();
                                                            int an = 0;
                                                            do{
                                                                an++;
                                                            }while((DaftarDosen.get(an)!=null)&&(DaftarDosen.get(an).getNip()!=koded2));
                                                            if(DaftarDosen.get(an).getNip()==koded2){
                                                                if(DaftarKelas.get(am).getDosen()==DaftarDosen.get(an)){
                                                                    Kelas k2 = new Kelas(DaftarKelas.get(am).getMatakuliah(), DaftarKelas.get(am).getDosen(), DaftarKelas.get(am).getIdKelas());
                                                                    DaftarKelas.remove(k2);
                                                                }
                                                            }
                                                        }
                                                        /*if (getKelas(kodek1)!=null){
                                                            System.out.print("Masukkan id Dosen: ");
                                                            int koded2 = angka.nextInt();
                                                            if (getDosen(koded2)!=null){
                                                                deleteKelasDosen(kodek1,koded2);
                                                            }
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/
                                                break;
                                                case 6:
                                                    System.out.println("Daftar Dosen Dalam kelas");
                                                    System.out.print("Masukkan NIP dosen: ");
                                                    int koded3 = angka.nextInt();
                                                    for(Kelas k5 : DaftarKelas){
                                                        if(k5.getDosen().getNip()==koded3){
                                                            System.out.println("Nip Dosen: "+k5.getDosen().getNip());
                                                            System.out.println("Nama Dosen: "+k5.getDosen().getNama());
                                                            System.out.println("Kode Kelas: "+k5.getIdKelas());
                                                            System.out.println("Nama Matakuliah: "+k5.getMatakuliah().getNama());
                                                            System.out.println();
                                                        }
                                                    }
                                                    /*int ao = angka.nextInt();
                                                    try{
                                                        do{
                                                            System.out.println("Nip Dosen: "+DaftarKelas.get(ao).getDosen().getNip());
                                                            System.out.println("Nama Dosen: "+DaftarKelas.get(ao).getDosen().getNama());
                                                            System.out.println("Kode Kelas: "+DaftarKelas.get(ao).getIdKelas());
                                                            System.out.println("Nama Matakuliah yang diajarkan: "+DaftarKelas.get(ao).getMatakuliah().getNama());
                                                            System.out.println();
                                                            ao++;
                                                        }while(DaftarKelas.get(ao)!=null);
                                                        /*if(getDosen(koded3)!=null){
                                                            printKelasDosen(koded3);
                                                        }
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/
                                                break;
                                                case 0:
                                                    z2=1;
                                                break;
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus antara 0 sampai 6");
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
                                                    //int kodek[] = new int[10];
                                                    //int idx = 0;
                                                    //int y;
                                                    //do{
                                                        System.out.println("Masukkan ID Kelas: ");
                                                        //kodek[idx] = angka.nextInt();
                                                        int kodek12 = angka.nextInt();
                                                        for(Kelas yz : DaftarKelas){
                                                        try{
                                                                //if(yz.getIdKelas()==kodek[idx]){
                                                                //System.out.println(getKelas(kodek[idx]));
                                                                if(yz.getIdKelas()==kodek12){    
                                                                    Mahasiswa m = new Mahasiswa(nim,usrname,pass,yz,nama);
                                                                    DaftarMahasiswa.add(m);
                                                                    SaveMahasiswa(m,kodek12);
                                                                }
                                                        } catch(Exception e){
                                                            e.printStackTrace();
                                                        }
                                                        }
                                            
                                                        //idx++;
                                                        //System.out.println("Apakah ingin menambah jumlah kelas?(1/0)");
                                                        //y = angka.nextInt();
                                                    //} while(y!=0);
                                                break;
                                                case 2:
                                                    System.out.println("Masukkan NIM mahasiswa yang akan di delete");
                                                    int nim2 = angka.nextInt();
                                                    Mahasiswa xy = null;
                                                    for(Mahasiswa m : DaftarMahasiswa){
                                                        if(m.getNim()==nim2){
                                                            xy = m;
                                                        }
                                                    }
                                                    deleteMahasiswa(nim2);
                                                    Iterator<Mahasiswa> iterator = DaftarMahasiswa.iterator();
                                                    while(iterator.hasNext()){
                                                        Mahasiswa values2 = iterator.next();
                                                        if(values2.equals(xy)){
                                                            iterator.remove();
                                                        }
                                                    }
                                                    /*try{
                                                            System.out.println(getMahasiswa(nim2));
                                                            deleteMahasiswa(nim2);
                                                        
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/
                                                break;
                                                case 3:
                                                    System.out.println("Tampil Mahasiswa");
                                                    for(Mahasiswa m : DaftarMahasiswa){
                                                        System.out.println("Nama Mahasiswa: "+m.getNama());
                                                        System.out.println("Nim Mahasiswa: "+m.getNim());
                                                        System.out.println("Username Mahasiswa: "+m.getUsernameMhs());
                                                        System.out.println("Password Mahasiswa: "+m.getPasswordMhs());
                                                        int ix = 0;
                                                        do{
                                                            System.out.println("Kode Kelas: "+m.getPilihan(ix).getIdKelas());
                                                            System.out.println();
                                                            ix++;
                                                        }while(ix < m.LuasArray());
                                                    }
                                                    //printMahasiswa();
                                                break;
                                                case 0:
                                                    z3 = 1;
                                                break;
                                                
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                } 
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus diantara 0 sampai 3");
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
                                                        for(Matakuliah mk : DaftarMatakuliah){
                                                            if(mk.getKodeMatkul()==kodemk2){
                                                                System.out.print("input Nip Dosen: ");
                                                                int koded2 = angka.nextInt();
                                                                for(Dosen d : DaftarDosen){
                                                                    if(d.getNip()==koded2){
                                                                        System.out.print("Masukkan id Kelas baru: ");
                                                                        int kodek = angka.nextInt();
                                                                        //Kelas x2 = null;
                                                                        Kelas k = new Kelas(mk,d,kodek);
                                                                        DaftarKelas.add(k);
                                                                        SaveKelas(k);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        /*try{
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
                                                        }*/
                                                break;
                                                case 2:
                                                    System.out.print("Masukkan id kelas: ");
                                                    int kodek3 = angka.nextInt();
                                                    Kelas x = null;
                                                    for(Kelas k : DaftarKelas){
                                                        if(k.getIdKelas()==kodek3){
                                                            x = k;
                                                        }
                                                    }
                                                    deleteKelas(kodek3);
                                                    Iterator<Kelas> ite = DaftarKelas.iterator();
                                                    while(ite.hasNext()){
                                                        Kelas value = ite.next();
                                                        if(value.equals(x)){
                                                            ite.remove();
                                                        }
                                                    }
                                                    /*try{
                                                            System.out.println(getKelas(kodek3));
                                                            deleteKelas(kodek3);
                                                        
                                                    } catch(Exception e){
                                                        e.printStackTrace();
                                                    }*/
                                                break;
                                                case 3:
                                                    for(Kelas k3 : DaftarKelas){
                                                        System.out.println("Kode Kelas: "+k3.getIdKelas());
                                                        System.out.println("Nama Matakuliah: "+k3.getMatakuliah().getNama());
                                                        System.out.println("Nama Dosen: "+k3.getDosen().getNama());
                                                        System.out.println();
                                                    }
                                                    /*try{
                                                        
                                                            printKelas();
                                                        
                                                    } catch(Exception e){
                                                        e.getMessage();
                                                    }*/
                                                break;
                                                case 0:
                                                    z4 = 1;
                                                break;
                                                
                                                default :
                                                    System.out.println("Menu tidak ada");
                                                break;
                                                }
                                            }   catch (InputMismatchException e){
                                                    System.out.println("Inputan harus diantara 0 sampai 3");
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
                                        System.out.println("Inputan harus antara 0 sampai 4");
                                    }
                            }while(z!=1);
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                            break;
                        }
                    break;   
                    case 2 :
                        System.out.print("Masukkan NIM Mahasiswa : ");
                        int NIM = angka.nextInt();
                        /*String UserMhs = huruf.next();
                        int user = Integer.parseInt(UserMhs);
                        System.out.print("Masukkan Password Mahasiswa: ");
                        String PassMhs = huruf.next();
                        int Pass = Integer.parseInt(PassMhs);*/
                        //try{
                        //Mahasiswa m23 = new Mahasiswa(1,null,null,null,null);
                        Mahasiswa q = null;
                            for(Mahasiswa mhs : DaftarMahasiswa){
                                //int verUser = Integer.parseInt(mhs.getUsernameMhs());
                                //int verPass = Integer.parseInt(mhs.getPasswordMhs());
                                //System.out.println(NIM);
                                //System.out.println(PassMhs);
                                //System.out.println(mhs.getUsernameMhs());
                                //System.out.println(mhs.getPasswordMhs());
                                if(mhs.getNim()==NIM){
                                    q = mhs;
                                    //System.out.println("========");
                                    //System.out.println(q.getUsernameMhs());
                                    //System.out.println(q.getPasswordMhs());
                                }
                            }
                                if(q!=null){
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
                                                //printKelas();
                                                //int kodek[] = new int[10];
                                                        //int idx = 0;
                                                        //int y;
                                                        //do{
                                                            System.out.println("Masukkan ID Kelas: ");
                                                            int kodek14 = angka.nextInt();
                                                            try{
                                                                for(Kelas kelas : DaftarKelas){
                                                                    //System.out.println(getKelas(kodek[idx]));
                                                                    if(kelas.getIdKelas()==kodek14){
                                                                        Mahasiswa m2 = new Mahasiswa(q.getNim(),q.getUsernameMhs(),q.getPasswordMhs(),kelas,q.getNama());
                                                                    //SaveMahasiswa(m2,idx);
                                                                        DaftarMahasiswa.add(m2);
                                                                        SaveMahasiswa(m2,kodek14);
                                                                    }
                                                                }

                                                            } catch(Exception e){
                                                                e.printStackTrace();
                                                            }
                                                            //idx++;
                                                            //System.out.println("Apakah ingin menambah jumlah kelas?(1/0)");
                                                            //y = angka.nextInt();
                                                        //} while(y!=0);
                                            break;
                                            case 2:
                                                System.out.println("Masukkan id kelas yang akan dihapus: ");
                                                int kodek5 = angka.nextInt();
                                                Mahasiswa yx = null;
                                                for(Mahasiswa mhs2 : DaftarMahasiswa){
                                                    //int i = 0;
                                                    //do{
                                                    Kelas k2 = mhs2.getPilihan2(kodek5);
                                                    if(k2!=null){
                                                    //if(mhs2.getPilihan2(kodek5).getIdKelas()==kodek5){
                                                        yx = mhs2;
                                                        //DaftarKelas.remove(yx);
                                                        
                                                    }
                                                    //i++;
                                                    //}while(i < mhs2.LuasArray());
                                                }
                                                deleteMahasiswa(yx.getNim(),kodek5);
                                                //System.out.println(yx.);
                                                Iterator<Mahasiswa> iterator3 = DaftarMahasiswa.iterator();
                                                while(iterator3.hasNext()){
                                                    Mahasiswa values4 = iterator3.next();
                                                    if(values4.equals(yx)){
                                                        iterator3.remove();
                                                    }
                                                }
                                                
                                                /*if (getKelas(kodek5)!=null){
                                                    System.out.println(getKelas(kodek5));
                                                    deleteMahasiswa(getMahasiswaPass(PassMhs).getNim(),kodek5);
                                                }*/
                                            break;
                                            case 3:
                                                //printMahasiswa(getMahasiswaPass(PassMhs).getNim());
                                                System.out.println("Nama Mahasiswa: "+q.getNama());
                                                System.out.println("Nim Mahaiswa: "+q.getNim());
                                                System.out.println("Daftar Kelas yang diambil: ");
                                                for(Mahasiswa mhs3 : DaftarMahasiswa){
                                                    if(mhs3.getNim()==q.getNim()){
                                                        System.out.println();
                                                        int i = 0;
                                                        //int a = i++;
                                                        do{
                                                            System.out.println("Kode Kelas: "+mhs3.getPilihan(i).getIdKelas());
                                                            System.out.println("Nama Matakuliah: "+mhs3.getPilihan(i).getMatakuliah().getNama());
                                                            System.out.println();
                                                            //a++;
                                                            i++;
                                                        }while(i < mhs3.LuasArray());
                                                    }
                                                }
                                            break;
                                            case 4:
                                                System.out.println("Masukkan Id Kelas: ");
                                                int kodek6 = angka.nextInt();
                                                for(Kelas kls : DaftarKelas){
                                                    if(kls.getIdKelas()==kodek6){
                                                        System.out.println("Nama Dosen: "+kls.getDosen().getNama());
                                                        System.out.println("Matakuliah yang diajarkan: "+kls.getMatakuliah().getNama());
                                                        System.out.println();
                                                    }
                                                }
                                                /*if (getKelas(kodek6)!=null){
                                                    printKelas(getKelas(kodek6).getIdKelas());
                                                }*/
                                            break;
                                            case 5:
                                                for(Kelas k : DaftarKelas){
                                                    System.out.println("Kode Kelas: "+k.getIdKelas());
                                                    System.out.println("Matakuliah: "+k.getMatakuliah().getNama());
                                                    System.out.println("Dosen yang mengajar: "+k.getDosen().getNama());
                                                    System.out.println();
                                                }
                                                //printKelas();
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
                                        System.out.println("Inputan harus diantara 0 sampai 5");
                                    }
                                    } while(t!=0);
                                }
                                //else{
                                  //  System.out.println("Username atau Password yang dimasukkan salah");
                                //}
                            //}
                            //if (getMahasiswaUser(UserMhs)!=null)  {
                                //System.out.print("Masukkan Password Mahasiswa : ");
                                //String PassMhs = huruf.next();
                                //if (getMahasiswaPass(PassMhs)!=null){
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
                                    
                                ///}
                                //else{
                                  //  System.out.println("Data inputan password Mahasiswa salah");
                                //}
                            ///}
                            //else{
                                //System.out.println("Data inputan Username Mahasiswa salah");
                            //}
                        //} catch(Exception e){
                          //  e.printStackTrace();
                        //}
                    break;
                    case 0 : 
                        System.out.println("TERIMA KASIH");
                        /*for(Matakuliah matkul6 : DaftarMatakuliah){
                            try{
                                if(getMatakuliah(matkul6.getKodeMatkul())==null){
                                    SaveMatakuliah(matkul6); 
                                }
                            }catch(Exception se){
                                se.printStackTrace();
                            }
                            
                        }*/
                        /*for(Dosen dsn6 : DaftarDosen){
                            try {
                                if(getDosen(dsn6.getNip())==null){
                                SaveDosen(dsn6);
                            }
                            } catch (Exception se) {
                                se.printStackTrace();
                            }
                        }*/
                        /*for(Kelas kls6 : DaftarKelas){
                            try {
                                if(getKelas(kls6.getIdKelas())!=null){
                                    //SaveKelas(kls6);
                                }
                                else{
                                    SaveKelas(kls6);
                                }
                            } catch (Exception se) {
                                se.printStackTrace();
                            }
                        }*/
                        /*int i = 0;
                        for(Mahasiswa mhs6 : DaftarMahasiswa){
                            do{
                                try{
                                    if(getMahasiswa(mhs6.getNim()).getPilihan(i).getIdKelas()!=mhs6.getPilihan(i).getIdKelas()){
                                        SaveMahasiswa(mhs6,i);
                                        //i++;
                                    }
                                    i++;
                                } catch(Exception se){
                                se.printStackTrace();
                            }
                            }while(i< mhs6.LuasArray());
                            i=0;
                        }*/
                        pilihan1 = 0;
                }
            } catch (InputMismatchException e) {
                    System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
                }
        }
    }    
}
