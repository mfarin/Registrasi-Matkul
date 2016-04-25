package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_1;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuMatakuliahAdmin;

public class MatakuliahMenu implements ActionListener{
    private Aplikasi model;
    private ViewMenuMatakuliahAdmin v;
    
    public MatakuliahMenu(Aplikasi model){
        this.model = model;
        v = new ViewMenuMatakuliahAdmin();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnData1())){
            Matakuliah1 j= new Matakuliah1(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData2())){
            Matakuliah2 j = new Matakuliah2(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData3())){
            Matakuliah3 j = new Matakuliah3(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData4())){
            Matakuliah4 j = new Matakuliah4(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData5())){
            Matakuliah5 j = new Matakuliah5(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData6())){
            Matakuliah6 j = new Matakuliah6(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnData7())){
            ControllerAdminUtama j = new ControllerAdminUtama(model);
            v.dispose();
        }
    }
}
