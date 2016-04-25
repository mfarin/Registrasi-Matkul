package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_2;

public class Dosen2 implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_2 v;
    
    public Dosen2(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_2();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            try {
                model.deleteDosen(v.getNip());
                model.removeDosen_Array(v.getNip());
                v.reset();
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else if(source.equals(v.getBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
}
