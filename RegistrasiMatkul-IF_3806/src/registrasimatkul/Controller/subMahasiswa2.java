package registrasimatkul.Controller;

import registrasimatkul.Controller.Mahasiswa.SubMahasiswaLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Mahasiswa.viewSubMahasiswa2;

public class subMahasiswa2 implements ActionListener{
    Aplikasi model;
    viewSubMahasiswa2 v;
    SubMahasiswaLog x;
    
    public subMahasiswa2(Aplikasi model){
        this.model = model;
        v = new viewSubMahasiswa2();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source.equals(v.getBtnSubmit())){
            //int NIM = 0;
            //NIM = x.verifyLog2();
            Mahasiswa mhs;
            mhs = model.MhsLogin(x.verifyLog2());
            model.subMahasiswa_1(mhs, v.gettfKodeKelas());
            //Mahasiswa mhs;
            //mhs = model.MhsLogin(NIM);
            //model.subMahasiswa_1(q, v.gettfKodeKelas());
            model.subMahasiswa_2(v.gettfKodeKelas());
        }
        else if(Source.equals(v.getBtnPilih())){
            ControllerMahasiswaUtama j = new ControllerMahasiswaUtama(model);
            v.dispose();
        }
    }
}
