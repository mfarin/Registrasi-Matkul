package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Dosen;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_3;

public class Dosen3 extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_3 v;
    
    public Dosen3(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_3();
        v.setVisible(true);
        v.addListener(this);
        v.addAdapter(this);
        v.setListData(model.getListDosen());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source.equals(v.getBtnRefresh())){
            v.setDetailDosen("");
        }
        else if(Source.equals(v.getBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(v.getList())){
            try{
                Dosen d = model.getDosen(v.getSelectedNIP());
                v.setDetailDosen(d.toString());
            }catch(Exception se){
                se.printStackTrace();
            }
        }
    }
}
