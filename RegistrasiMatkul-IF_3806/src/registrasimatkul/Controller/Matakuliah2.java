package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_2;

public class Matakuliah2 implements ActionListener{
    private Aplikasi model;
    private MenuviewMatakuliah_2 v;
    
    public Matakuliah2(Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_2();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            try {
                model.deleteMatakuliah(v.gettfKodeMatkul());
                //model.removeMatakuliah(v.gettfKodeMatkul());
                model.deleteMatakuliah_Array(v.gettfKodeMatkul());
                v.reset();
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else if(source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
    }
}
