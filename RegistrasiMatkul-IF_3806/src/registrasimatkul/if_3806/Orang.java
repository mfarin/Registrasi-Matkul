public abstract class Orang {
    private String nama;

	public Orang(String nama){
		this.nama = nama;
	}
    public void setNama(String nama){
		this.nama = nama;	
    }
    
    public String getNama(){
		return nama;	
    }
}
