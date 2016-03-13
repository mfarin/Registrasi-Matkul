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
