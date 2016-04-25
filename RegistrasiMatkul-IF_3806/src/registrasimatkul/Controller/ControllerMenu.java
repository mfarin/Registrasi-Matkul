package registrasimatkul.Controller;

import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuDosen;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuKelas;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuMatakuliahAdmin;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuAdmin;
import registrasimatkul.View.Admin.TampilMenuUtama.View;
import registrasimatkul.View.Admin.TampilMenuUtama.viewMenuMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import javax.swing.JPanel;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.ViewMain;
import registrasimatkul.if_3806.*;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Controller.Mahasiswa.SubMahasiswaLog;

public class ControllerMenu implements ActionListener {
    private Aplikasi model;
    private ViewMain v;
    private SubMahasiswaLog x;
    
    public ControllerMenu(Aplikasi model){
        this.model = model;
        v = new ViewMain();
        v.setVisible(true);
        v.AddListener(this);
        model.printMatakuliah();
        model.printDosen();
        model.printKelas();
        model.printMahasiswa();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(v.getBtnAdmin())) {
                //View j = new View();
                ControllerView j = new ControllerView(model);
                v.dispose();
            }
            else if (source.equals(v.getBtnMahasiswa())){
                SubMahasiswaLog j = new SubMahasiswaLog(model);
                v.dispose();
            }
            else if(source.equals(v.getBtnExit())){
                System.exit(0);
            }
        else{
            
        }
    }    
}

