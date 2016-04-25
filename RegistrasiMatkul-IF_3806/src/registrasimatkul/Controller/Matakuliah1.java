package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Matakuliah;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_1;

public class Matakuliah1 implements ActionListener{
    private Aplikasi model;
    private MenuviewMatakuliah_1 v;
    
    public Matakuliah1(Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_1();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            Matakuliah m = new Matakuliah(v.getMatakuliah(), v.getSks(), v.getKodeMK());
            model.SaveMatakuliah(m);
            model.addMatakuliah(m);
            JOptionPane.showMessageDialog(v, "Input Matakuliah berhasil");
            v.reset();
        }
        else if(source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
    }
}
