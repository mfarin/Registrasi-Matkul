public class Dosen extends Orang {
    private long nip;
    public Dosen(String nama,long nip){
        super(nama);
        this.nip = nip;	
    }
	public void setNip(long nip){
		this.nip = nip;
		
	}
	public long getNip(){
		return nip;	
	}
}
