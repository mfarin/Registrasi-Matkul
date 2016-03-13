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
public class Dosen extends Orang{
    private long nip;

    /**
     *
     * @param nama
     * @param nip
     */
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
