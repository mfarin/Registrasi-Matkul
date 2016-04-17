package registrasimatkul.if_3806;
import java.io.*;
import java.util.*;

public class Mahasiswa extends Orang implements Serializable{
    //private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private Kelas pilihan[] = new Kelas[10];
    private int Nim;
    private String UsernameMhs;
    private String PasswordMhs;
    int numpilihan = 0;

    public Mahasiswa(int Nim, String UsernameMhs, String PasswordMhs, Kelas kelas, String nama) {
        super(nama);
        this.Nim = Nim;
        this.UsernameMhs = UsernameMhs;
        this.PasswordMhs = PasswordMhs;
        pilihan[numpilihan] = kelas;
    }
    
    public Mahasiswa(int Nim, String UsernameMhs, String PasswordMhS, String Nama) {
        super(Nama);
        this.Nim = Nim;
        this.UsernameMhs = UsernameMhs;
        this.PasswordMhs = PasswordMhs;
        
    }

    public void setPilihan(Kelas k, int i) {
        pilihan[i] = k;
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
        return pilihan[i];
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
        pilihan[numpilihan] = k;
        numpilihan++;
    }
    
    public void RemoveKelas(Kelas id){
        for (int i = 0; i <= 10; i++) {
            if (pilihan[i]==id ) {
                pilihan[i]=null;
            }
        }
    }
}
