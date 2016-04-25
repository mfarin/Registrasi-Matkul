package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Admin.Mahasiswa.MenuviewMahasiswa_1;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuAdmin;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.viewMenuMahasiswa;

public class Mahasiswa1 implements ActionListener{
    private Aplikasi model;
    private MenuviewMahasiswa_1 v;
    private ArrayList<Integer> kode;
    private int i;
    
    public Mahasiswa1(Aplikasi model){
        this.model = model;
        v = new MenuviewMahasiswa_1();
        v.setVisible(true);
        v.addListener(this);
        kode = new ArrayList<Integer>();
        i=0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            try{
                
                Mahasiswa m = new Mahasiswa(v.gettfNim(), v.getUserMhs(), v.getPassMhs(), model.getKelas(v.getIdKelas()), v.gettfNamaMhs());
                model.SaveMahasiswa(m, v.getIdKelas());
                model.addMahasiswa(m);
                v.reset();
                JOptionPane.showMessageDialog(v, "Input Mahasiswa berhasil");
            }catch(Exception se){
                se.printStackTrace();
            }
        }
        else if(source.equals(v.getBtnPilih())){
            MahasiswaMenu j = new MahasiswaMenu(model);
                v.dispose();
        }
    }
}
