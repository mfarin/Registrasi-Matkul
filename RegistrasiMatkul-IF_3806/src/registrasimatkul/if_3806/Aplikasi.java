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
import java.util.ArrayList;
public class Aplikasi implements Serializable {
    private ArrayList<Dosen> DaftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> DaftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> DaftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> DaftarMatakuliah = new ArrayList<Matakuliah>();
    
    public void AddDosen(Dosen d){ //menu Admin 2.4
        DaftarDosen.add(d);
    }
    
    public void RemoveDosen(Dosen d){ //menu Admin 2.5
        DaftarDosen.remove(d);
    }
    
    public void AddMahasiswa(Mahasiswa m){ // menu Admin 3.1
        DaftarMahasiswa.add(m);
    }
    
    public void RemoveMahasiswa(int id){ //menu Admin 3.2
        DaftarMahasiswa.remove(id);
    }
    
    public void AddKelas(Kelas k){ //menu Admin 4.4
        DaftarKelas.add(k);
    }
    
    public void RemoveKelas(Kelas k){ //menu Admin 4.5
        DaftarKelas.remove(k);
    }
    
    public void AddMatakuliah(Matakuliah m){ //menu Admin 1.4
        DaftarMatakuliah.add(m);
    }
    
    public void RemoveMatakuliah(Matakuliah m){ //menu Admin 1.5
        DaftarMatakuliah.remove(m);
    }
    
    public void setMatakuliahpadaKelas(int id, Matakuliah m){ //menu Admin 1.1
        DaftarKelas.get(id).setMatakuliah(m);
    }
    
    public Matakuliah getMatakuliahpadaKelas(int id){ //menu Admin 1.2
        return DaftarKelas.get(id).getMatakuliah();
    }
    
    public void setDosenpadaKelas(int id, Dosen d){ //menu Admin 2.1
        DaftarKelas.get(id).setDosen(d);
    }
    
    public Dosen getDosenpadaKelas(int id){ //Menu Admin 2.2
        return DaftarKelas.get(id).getDosen();
    }
     
    public void TambahKelasMahasiswa(int id, Kelas k){ //menu Admin 4.1
        DaftarMahasiswa.get(id).AddKelas(k);
    }
    
    public void DeleteKelasMahasiswa(int id, Kelas k){ //menu Admin 4.2
        DaftarMahasiswa.get(id).RemoveKelas(k);
    }

    public ArrayList<Dosen> getDaftarDosen() {  //menu Admin 2.3
        return DaftarDosen;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() { //menu Admin 3.3
        return DaftarMahasiswa;
    }

    public ArrayList<Kelas> getDaftarKelas() { //menu Admin 4.3 dan Menu Mahasiswa 5
        return DaftarKelas;
    }

    public ArrayList<Matakuliah> getDaftarMatakuliah() { //menu Admin 1.3 
        return DaftarMatakuliah;
    }
    
    public Mahasiswa getMahasiswa(int id){ //menu Admin 3.4 
        return DaftarMahasiswa.get(id);
    }
    
    public Dosen getDosen(int id){ //menu Admin 2.6
        return DaftarDosen.get(id);
    }
    
    public Kelas getKelas(int id){ //menu Admin 4.6 
        return DaftarKelas.get(id);
    }
    
    public Matakuliah getMatakuliah(int id){ //menu Admin 4.6 
        return DaftarMatakuliah.get(id);
    }
    
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
}
