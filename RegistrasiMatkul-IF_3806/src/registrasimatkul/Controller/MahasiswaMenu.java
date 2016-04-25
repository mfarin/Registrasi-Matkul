package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.View;
import registrasimatkul.View.Admin.TampilMenuUtama.viewMenuMahasiswa;

public class MahasiswaMenu implements ActionListener {
    private Aplikasi model;
    private viewMenuMahasiswa v;
    
    public MahasiswaMenu(Aplikasi model){
        this.model = model;
        v = new viewMenuMahasiswa();
        v.setVisible(true);
        v.AddListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtn1())){
            Mahasiswa1 j = new Mahasiswa1(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn2())){
            Mahasiswa2 j = new Mahasiswa2(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn3())){
            Mahasiswa3 j = new Mahasiswa3(model);
            v.dispose();
//Mahasiswa3 j = new Mahasiswa3(model);
            //v.dispose();
        }
        else if(source.equals(v.getBtn0())){
            ControllerAdminUtama j = new ControllerAdminUtama(model);
            v.dispose();
        }
    }
}
