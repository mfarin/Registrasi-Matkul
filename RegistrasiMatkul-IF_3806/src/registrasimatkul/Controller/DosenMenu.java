package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuDosen;

public class DosenMenu implements ActionListener{
    Aplikasi model;
    ViewMenuDosen v;
    
    public DosenMenu(Aplikasi model){
        this.model = model;
        v = new ViewMenuDosen();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtn1())){
            Dosen1 j = new Dosen1(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn2())){
            Dosen2 j = new Dosen2(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn3())){
            Dosen3 j = new Dosen3(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn4())){
            Dosen4 j = new Dosen4(model);
        }
        else if(source.equals(v.getBtn5())){
            Dosen5 j = new Dosen5(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn6())){
            Dosen6 j = new Dosen6(model);
            v.dispose();
        }
        else if(source.equals(v.getBtn0())){
            ControllerAdminUtama j = new ControllerAdminUtama(model);
            v.dispose();
        }
    }
}
