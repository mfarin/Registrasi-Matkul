package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Matakuliah;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_3;

public class Matakuliah3 extends MouseAdapter implements ActionListener{
    Aplikasi model;
    MenuviewMatakuliah_3 v;
    
    public Matakuliah3(Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_3();
        v.setVisible(true);
        v.addListener(this);
        v.AddAdapter(this);
        v.SetListData(model.getListMatakuliah());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnRefresh())){
            v.setDetailMK("");
        }
        else if(source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
        
    }
    
    public void mousePressed(MouseEvent e){
        Object Source = e.getSource();
        if(Source.equals(v.getList())){
            try{
                Matakuliah m = model.getMatakuliah(v.getSelectedKodeMK());
                //System.out.println("asd");
                v.setDetailMK(m.toString());
            } catch(Exception se){
                se.printStackTrace();
            }
        }
    }
}
