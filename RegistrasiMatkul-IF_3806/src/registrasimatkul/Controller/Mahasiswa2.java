package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Mahasiswa.MenuviewMahasiswa;
import registrasimatkul.View.Admin.Mahasiswa.MenuviewMahasiswa_1;

public class Mahasiswa2 implements ActionListener{
    private Aplikasi model;
    private MenuviewMahasiswa v;
    
    public Mahasiswa2(Aplikasi model){
        this.model = model;
        v = new MenuviewMahasiswa();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            model.removeMahasiswa_2(v.gettfNim());
            JOptionPane.showMessageDialog(v, "Delete Berhasil");
            v.reset();
        }
        else if(source.equals(v.getBtnPilih())){
            MahasiswaMenu j = new MahasiswaMenu(model);
            v.dispose();
        }
    }
}
