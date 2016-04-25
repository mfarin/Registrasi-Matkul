package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.View;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuAdmin;

public class ControllerAdminUtama implements ActionListener{
    private Aplikasi model;
    private ViewMenuAdmin v;
    
    public ControllerAdminUtama(Aplikasi model){
        this.model = model;
        v = new ViewMenuAdmin();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnMatakuliah())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnDosen())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnMahasiswa())){
            MahasiswaMenu j = new MahasiswaMenu(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnKelas())){
            KelasMenu j = new KelasMenu(model);
            v.dispose();
        }
        else if(source.equals(v.getBtnExit())){
            ControllerView j = new ControllerView(model);
            v.dispose();
        }
    }
    
    
}
