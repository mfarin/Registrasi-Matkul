package registrasimatkul.if_3806;
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
}
