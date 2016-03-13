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

public class Matakuliah{
	
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

public class Kelas {
	private  Matakuliah[] matakuliah= new Matakuliah[10];
	private Dosen[] dosen= new Dosen[10];
	private long idKelas;
	private int numDosen=0;
	private int numMatkul=0;
	
	public void setDosen(Dosen d){
		if(numDosen<9){
			d[numDosen]=dosen;
		}
		numDosen++;
	}
	
	public void addMatkul(Matakuliah matakuliah){
		if(numMatkul < 9){
			this.matakuliah[numMatkul]=matakuliah;
			
		}
		numMatkul++;
	}
	
	public void setIdKelas(long idKelas){
		this.idKelas=idKelas;
	}
	
	public long getIdKelas(){
		return idKelas;
	}
	
	public void deleteDosen(Dosen d){
		if(numDosen > 0){
			d[numDosen]=null;
			
		}
		else{
			System.out.println("Dosen kosong");
		}
		numDosen--;
	}
	
	public void deleteMatkul(Matakuliah matakuliah){
		if(numMatkul > 0){
			this.matakuliah[numMatkul]=null;
		}
		else{
			System.out.println("Matakuliah kosong");
		}
		numMatkul--;
	}
}
public abstract class Orang {
	private String nama;
	
	public Orang( String nama){
		this.nama = nama;
		
	}
	public void setNama(String nama){
		this.nama = nama;
		
	}
	public String getNama(){
		return this.nama;
		
	}
	
}
public class Dosen extends Orang{
	private long nip;
	
	public class Dosen(long nip){
		this.nip = nip;	
		
	}
	public void setNip(long nip){
		this.nip = nip;
		
	}
	public long getNip(){
		return this.nip;
		
	}
	
	
}

