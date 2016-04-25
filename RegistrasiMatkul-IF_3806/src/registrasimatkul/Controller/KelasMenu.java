package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuKelas;

public class KelasMenu implements ActionListener{
    Aplikasi model;
    ViewMenuKelas v;
    
    public KelasMenu(Aplikasi model){
        this.model = model;
        v = new ViewMenuKelas();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtn1())){
            Kelas1 j = new Kelas1(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn2())){
            Kelas2 j = new Kelas2(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn3())){
            Kelas3 j = new Kelas3(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn0())){
            ControllerAdminUtama j = new ControllerAdminUtama(model);
            v.dispose();
        }
    }
}
