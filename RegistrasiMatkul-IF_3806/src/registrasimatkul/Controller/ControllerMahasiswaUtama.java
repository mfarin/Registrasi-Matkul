package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Mahasiswa.viewMahasiswaUtama;
import registrasimatkul.View.ViewMain;

public class ControllerMahasiswaUtama implements ActionListener{
    Aplikasi model;
    viewMahasiswaUtama v;
    
    public ControllerMahasiswaUtama(Aplikasi model){
        this.model = model;
        v = new viewMahasiswaUtama();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source.equals(v.getBtn1())){
            subMahasiswa1 j = new subMahasiswa1(model);
            v.dispose();
        }
        else if(Source.equals(v.getBtn2())){
            subMahasiswa2 j = new subMahasiswa2(model);
            v.dispose();
        }
        else if(Source.equals(v.getBtn3())){
            subMahasiswa3 j = new subMahasiswa3(model);
            v.dispose();
        }
        /*else if(Source.equals(v.getBtn4())){
            subMahasiswa4 j = new subMahasiswa4(model);
            v.dispose();
        }
        else if(Source.equals(v.getBtn5())){
            subMahasiswa j = new subMahasiswa(model);
            v.dispose();
        }
        else if(Source.equals(v.getBtn0())){
            ControllerMenu j = new ControllerMenu(model);
            v.dispose();
        }*/
    }
}
