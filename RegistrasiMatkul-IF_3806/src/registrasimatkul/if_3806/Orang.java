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
public abstract class Orang {
    private String nama;
	
    /**
     *
     * @param nama
     */
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
