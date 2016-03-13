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
public class Mahasiswa extends Orang {
    private Kelas[] pilihan;
    private long Nim;
    private int jumlKelas;
	
    public Mahasiswa(String Nama,long Nim,int totalKelas){
	super(Nama);
	this.Nim = Nim;
	jumlKelas = totalKelas;
	pilihan = new Kelas[totalKelas];
    }
	public void setNim(long Nim){
		this.Nim = Nim;
	}
	
	public long getNim(){
		return Nim;
	}
	
	public void setJumlahKelas(int x){
		jumlKelas = x;
	}
	
	public int getJumlahKelas(){
		return jumlKelas;
	}
	
	public void tambahKelas(Kelas k){
		int x = 0;
		do{
			x++;
		} while((x<getJumlahKelas())&&(pilihan[x] != null));
		if (x<getJumlahKelas()){
			pilihan[x] = k;
		}
		else{
			System.out.println("Anda sudah tidak bisa memilih kelas lagi");
		}
	}
	
	public void kurangkelas(Kelas id){
		int cari = 0;
		do{
			if (pilihan[cari]!=id){
				cari++;
			}
		} while((cari<getJumlahKelas())&&(pilihan[cari]!=id));
		if (cari<getJumlahKelas()){
			pilihan[cari] = null;
		}
		else{
			System.out.println("Kelas yang dicari tidak ada");
		}
	}
	
	public Kelas getKelas(int i){
		if (pilihan[i]!=null){
			return pilihan[i];
		}
		else{
			return null;
		}
	}
}
