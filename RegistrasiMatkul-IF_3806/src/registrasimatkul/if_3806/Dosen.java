package registrasimatkul.if_3806;

public class Dosen extends Orang {
    private int nip;
    public Dosen(String nama,int nip){
        super(nama);
        this.nip = nip;	
    }
	public void setNip(int nip){
		this.nip = nip;
		
	}
	public int getNip(){
		return nip;	
	}
}
