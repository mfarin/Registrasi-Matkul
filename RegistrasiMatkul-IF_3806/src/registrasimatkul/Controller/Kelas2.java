package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Kelas.MenuviewKelas_2;

public class Kelas2 implements ActionListener{
    Aplikasi model;
    MenuviewKelas_2 v;
    
    public Kelas2(Aplikasi model){
        this.model = model;
        v = new MenuviewKelas_2();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            model.removeKelas_2(v.gettfKodeKelas());
            JOptionPane.showMessageDialog(v, "Delete Berhasil");
            v.reset();
        }
        else if(source.equals(v.getBtnPilih())){
            KelasMenu j = new KelasMenu(model);
            v.dispose();
        }
    }
}
