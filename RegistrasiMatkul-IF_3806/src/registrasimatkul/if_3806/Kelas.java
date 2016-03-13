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
public class Kelas {
    private Matakuliah[] matakuliah = new Matakuliah[10];
    private Dosen[] dosen = new Dosen[10];;
    private long idKelas;
    private int numDosen;
    private int numMatkul;
	
    public Kelas(long idKelas){
	this.idKelas = idKelas;
    }
        
    public void setDosen(Dosen d){
	numDosen = 0;
	do{
            numDosen++;
	} while((numDosen<10)&&(dosen[numDosen] != null));
        if(numDosen<10){
            dosen[numDosen]=d;
	}
        else{
            System.out.println("Tidak dapat menambah dosen lagi!");
        }
    }
	
    public void addMatkul(Matakuliah matkul){
	numMatkul = 0;
	do{
            numMatkul++;
	} while((numMatkul<10)&&(matakuliah[numMatkul] != null));
        if(numMatkul < 10){
            this.matakuliah[numMatkul]=matkul;
	}
        else{
            System.out.println("Tidak dapat menambah matakuliah lagi!");
        }
    }
	
    public void setIdKelas(long idKelas){
	this.idKelas=idKelas;
    }
	
    public long getIdKelas(){
	return idKelas;
    }
	
    public void deleteDosen(Dosen d){
        numDosen = 0;
        do{
            numDosen++;
        } while((numDosen<10) && (dosen[numDosen]!=d));
        if(numDosen < 10){
            dosen[numDosen]=null;	
	}
	else{
            System.out.println("Dosen kosong");
	}
    }
	
    public void deleteMatkul(Matakuliah matkul){
        numMatkul = 0;
        do{
            numMatkul++;
        } while((numMatkul<10) && (matakuliah[numMatkul]!=matkul));
        if(numMatkul < 10){
            this.matakuliah[numMatkul]=null;
        }
        else{
            System.out.println("Matakuliah kosong");
        }
    }
}
