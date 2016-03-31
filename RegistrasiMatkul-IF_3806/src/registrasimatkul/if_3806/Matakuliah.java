public class Matakuliah {
    private String nama;
    private int sks;
    private long kodeMatkul;
	
    public Matakuliah(String nama, int sks, long kodeMatkul){
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
	
    public void setKodeMatkul(long kodeMatkul){
	this.kodeMatkul=kodeMatkul;
    }
	
    public long getKodeMatkul(){
	return kodeMatkul;
    }
}
