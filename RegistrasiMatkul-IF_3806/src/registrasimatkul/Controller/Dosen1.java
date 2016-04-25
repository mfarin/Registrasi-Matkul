package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Dosen;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_1;

public class Dosen1 implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_1 v;
    
    public Dosen1(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_1();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(v.getBtnSubmit())){
            Dosen d = new Dosen(v.getNamaDosen(), v.getNip());
            model.SaveDosen(d);
            model.addDosen(d);
            v.reset();
        }
        else if (source.equals(v.getBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
}
