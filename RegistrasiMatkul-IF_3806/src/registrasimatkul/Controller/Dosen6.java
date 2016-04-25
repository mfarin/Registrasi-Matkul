package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_6;

public class Dosen6 implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_6 v;
    
    public Dosen6(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_6();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source.equals(v.getBtnSubmit())){
            ArrayList<Kelas> k;
            k = model.Dosen_6(v.gettfNip());
            String detail = "";
            for(Kelas k1 : k){
                detail += (k1.toString()) +"\n";
            }
            v.setDetailKelas(detail);
        }
        else if(Source.equals(v.getBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
}
