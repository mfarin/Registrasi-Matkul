package registrasimatkul.Model;

public class Matakuliah {
    private String nama;
    private int sks;
    private int kodeMatkul;
	
    public Matakuliah(String nama, int sks, int kodeMatkul){
	this.nama=nama;
	this.sks=sks;
	this.kodeMatkul=kodeMatkul;
    }
	
    public void setNama(String nama){
	this.nama=nama;
    }
	
    public String getNama(){
	return nama;
    }
	
    public void setSks(int sks){
	this.sks=sks;
    }
	
    public int getSks(){
	return sks;
    }
	
    public void setKodeMatkul(int kodeMatkul){
	this.kodeMatkul=kodeMatkul;
    }
	
    public int getKodeMatkul(){
	return kodeMatkul;
    }

    @Override
    public String toString() {
        return "Nama Matakuliah: "+getNama()+"\n"+
                "SKS: "+getSks()+"\n"+
                "Kode Matkul: "+getKodeMatkul();
    }
    
    
}
