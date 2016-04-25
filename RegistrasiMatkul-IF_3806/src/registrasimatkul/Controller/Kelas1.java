package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Kelas.MenuviewKelas_1;

public class Kelas1 implements ActionListener{
    Aplikasi model;
    MenuviewKelas_1 v;
    
    public Kelas1(Aplikasi model){
        this.model = model;
        v = new MenuviewKelas_1();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            model.addKelas_1(v.gettfKodeMk(), v.gettfNip(), v.gettfIdKelas());
            JOptionPane.showMessageDialog(v, "Input Berhasil");
            v.reset();
        }
        else if(source.equals(v.getBtnPilih())){
            KelasMenu j = new KelasMenu(model);
            v.dispose();
        }
    }
}
