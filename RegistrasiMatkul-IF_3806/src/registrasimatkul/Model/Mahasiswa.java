package registrasimatkul.Model;

import java.io.*;
import java.util.ArrayList;

public class Mahasiswa extends Orang implements Serializable{
    //private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private int Nim;
    private String UsernameMhs;
    private String PasswordMhs;
    //int numKelas;

    public Mahasiswa(int Nim, String UsernameMhs, String PasswordMhs, Kelas kelas, String nama) {
        super(nama);
        this.Nim = Nim;
        this.UsernameMhs = UsernameMhs;
        this.PasswordMhs = PasswordMhs;
        //pilihan[numpilihan] = kelas;
        pilihan.add(kelas);
    }
    
    public Mahasiswa(int Nim, String UsernameMhs, String PasswordMhs, String Nama) {
        super(Nama);
        this.Nim = Nim;
        this.UsernameMhs = UsernameMhs;
        this.PasswordMhs = PasswordMhs;
    }
    
    public Mahasiswa(int NIM, String User, String Pass, int index, Matakuliah idKelas, Dosen idDosen, String Nama){
        super(Nama);
        this.Nim = NIM;
        this.UsernameMhs = User;
        this.PasswordMhs = Pass;
        this.pilihan.get(index).setMatakuliah(idKelas);
        this.pilihan.get(index).setDosen(idDosen);
    }

    public void setPilihan(Kelas k, int i) {
        //pilihan[i] = k;
        pilihan.get(i).equals(k);
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

    public void setUsernameMhs(String UsernameMhs) {
        this.UsernameMhs = UsernameMhs;
    }

    public void setPasswordMhs(String PasswordMhs) {
        this.PasswordMhs = PasswordMhs;
    }

    public Kelas getPilihan(int i) {
        return pilihan.get(i);
    }
    
    public Kelas getPilihan2(int IdKelas){
        Kelas v = null;
        for(Kelas x : pilihan){
            if(x.getIdKelas()==IdKelas){
                v = x;
            }
        }
        return v;
    }

    public int getNim() {
        return Nim;
    }

    public String getUsernameMhs() {
        return UsernameMhs;
    }

    public String getPasswordMhs() {
        return PasswordMhs;
    }
    
    public void AddKelas(Kelas k){
        //pilihan[numpilihan] = k;
        //numpilihan++;
        pilihan.add(k);
    }
    
    public void RemoveKelas(Kelas id){
        /*for (int i = 0; i <= 10; i++) {
            if (pilihan[i]==id ) {
                pilihan[i]=null;
            }
        }*/
        pilihan.remove(id);
    }
    
    public int LuasArray(){
        return pilihan.size();
    }

    @Override
    public String toString() {
        //ArrayList<Kelas> pilih = new ArrayList<Kelas>();
        //String x2 = "";
        //for(Kelas x : pilihan){
          //  x2 += (x.getMatakuliah().getNama())+"\n";
        //}
        //return x2;
        for(Kelas k : pilihan){
            k.toString();
        }
        
        return  "Nama Mahasiswa: "+getNama()+"\n"+
                "NIM: "+getNim()+"\n";
                
                //"Kelas: "+x2;
    }
    
    
}

