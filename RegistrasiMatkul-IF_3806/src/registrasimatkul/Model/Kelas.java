package registrasimatkul.Model;

public class Kelas {
    private Matakuliah matakuliah;
    private Dosen dosen;
    private int idKelas;
    //private String Nama;

    public Kelas(Matakuliah matakuliah, Dosen dosen, int idKelas) {
        this.matakuliah = matakuliah;
        this.dosen = dosen;
        this.idKelas = idKelas;
        //this.Nama = Nama;
    }

    public Kelas(){
        
    }
    
    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }
    
    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public int getIdKelas() {
        return idKelas;
    }

    @Override
    public String toString() {
        return "Kode Kelas: "+getIdKelas()+"\n"+
                "Matakuliah: "+getMatakuliah().getNama()+"\n"+
                "Dosen: "+getDosen().getNama()+"\n"+"\n";
    }
    
    
}
