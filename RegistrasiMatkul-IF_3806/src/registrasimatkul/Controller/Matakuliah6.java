package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_6;

public class Matakuliah6 implements ActionListener{
    private Aplikasi model;
    private MenuviewMatakuliah_6 v;
    
    public Matakuliah6(Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_6();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            ArrayList<Kelas> k;
            k = model.asd(v.gettfKodeMK());
            String detail = "";
            for(Kelas k1 : k){
                detail += (k1.toString()) + "\n";
            }
            v.setDetailMK(detail);
            /*if (k!=null){
                v.setDetailMK(k.toString());
            }*/
        }
        else if(source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
    }
}
