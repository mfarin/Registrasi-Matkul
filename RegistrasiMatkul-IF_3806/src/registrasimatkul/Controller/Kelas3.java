package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.View.Admin.Kelas.MenuviewKelas_3;

public class Kelas3 extends MouseAdapter implements ActionListener{
    Aplikasi model;
    MenuviewKelas_3 v;
    
    public Kelas3(Aplikasi model){
        this.model = model;
        v = new MenuviewKelas_3();
        v.setVisible(true);
        v.addListener(this); 
        v.addAdapter(this);
        v.setListData(model.getListKelas());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnRefresh())){
            v.setDetailKelas("");
        }
        else if(source.equals(v.getBtnPilih())){
            KelasMenu j = new KelasMenu(model);
            v.dispose();
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(v.getList())){
            try {
                Kelas k = model.getKelas(v.getSelectedKodeKelas());
                v.setDetailKelas(k.toString());
            } catch (Exception se) {
                se.printStackTrace();
            }
            
        }
    }
}
