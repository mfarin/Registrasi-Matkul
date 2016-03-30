/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimatkul.if_3806;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.*;

public class Mahasiswa extends Orang implements Serializable{
    private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private long Nim;
    private String UsernameMhs;
    private String PasswordMhs;

    public Mahasiswa(long Nim, String UsernameMhs, String PasswordMhs, String nama) {
        super(nama);
        this.Nim = Nim;
        this.UsernameMhs = UsernameMhs;
        this.PasswordMhs = PasswordMhs;
    }

    public void setPilihan(ArrayList<Kelas> pilihan) {
        this.pilihan = pilihan;
    }

    public void setNim(long Nim) {
        this.Nim = Nim;
    }

    public void setUsernameMhs(String UsernameMhs) {
        this.UsernameMhs = UsernameMhs;
    }

    public void setPasswordMhs(String PasswordMhs) {
        this.PasswordMhs = PasswordMhs;
    }

    public ArrayList<Kelas> getPilihan() {
        return pilihan;
    }

    public long getNim() {
        return Nim;
    }

    public String getUsernameMhs() {
        return UsernameMhs;
    }

    public String getPasswordMhs() {
        return PasswordMhs;
    }
    
    public void AddKelas(Kelas k){
        pilihan.add(k);
    }
    
    public void RemoveKelas(Kelas id){
        for (int i = 0; i < pilihan.size(); i++) {
            if (pilihan.get(i).equals(id) ) {
                pilihan.remove(i);
            }
        }
    }
}
