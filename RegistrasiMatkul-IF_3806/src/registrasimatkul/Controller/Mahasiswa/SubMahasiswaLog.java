package registrasimatkul.Controller.Mahasiswa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Controller.ControllerMahasiswaUtama;
import registrasimatkul.Controller.ControllerMenu;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Mahasiswa.MahasiswaLogin;

public class SubMahasiswaLog implements ActionListener{
    Aplikasi model;
    MahasiswaLogin v;
    static int nimmhs;
    
    public SubMahasiswaLog(Aplikasi model){
        this.model = model;
        v = new MahasiswaLogin();
        v.setVisible(true);
        v.addListener(this);
    }
    public SubMahasiswaLog(){
        
    }
    
    public Mahasiswa LogMhs(int nim){
        Mahasiswa x = model.MhsLogin(nim);
        return x;
    }
    
    public int verifyLog(int nim){
        nim = 0;
        nim = v.gettfNim();
        return nim;
    }
    
    public int verifyLog2(){
        return nimmhs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnPilih())){
            //nimmhs = v.getfNim();
            Mahasiswa y = LogMhs(v.gettfNim());
            if (y!=null){
                nimmhs = v.gettfNim();
                ControllerMahasiswaUtama j = new ControllerMahasiswaUtama(model);
                v.dispose();
            }
            else{
                JOptionPane.showMessageDialog(v, "Maaf NIM yang dimasukkan tidak terdaftar");
            }
        }
        else if(source.equals(v.getBtnExit())){
            ControllerMenu j = new ControllerMenu(model);
            v.dispose();
        }
    }
    
}
