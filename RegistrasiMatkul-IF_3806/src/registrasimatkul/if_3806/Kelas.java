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
public class Kelas {
    private Matakuliah matakuliah;
    private Dosen dosen;
    private long idKelas;

    public Kelas(Matakuliah matakuliah, Dosen dosen, long idKelas) {
        this.matakuliah = matakuliah;
        this.dosen = dosen;
        this.idKelas = idKelas;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public void setIdKelas(long idKelas) {
        this.idKelas = idKelas;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public long getIdKelas() {
        return idKelas;
    }
}
