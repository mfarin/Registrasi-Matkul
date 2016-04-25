package registrasimatkul.Controller;

import registrasimatkul.Controller.Mahasiswa.SubMahasiswaLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Mahasiswa.viewSubMahasiswa1;
//import registrasimatkul.Controller.SubMahasiswaLog;

public class subMahasiswa1 implements ActionListener{
    Aplikasi model;
    viewSubMahasiswa1 v;
    SubMahasiswaLog x;
    
    public subMahasiswa1(Aplikasi model){
        this.model = model;
        v = new viewSubMahasiswa1();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source.equals(v.getBtnSubmit())){
            int NIM = 0;
            NIM =  x.verifyLog(NIM);
            Mahasiswa mhs;
            mhs = model.MhsLogin(NIM);
            model.subMahasiswa_1(mhs, v.gettfKodeKelas());
            v.reset();
        }
        else if(Source.equals(v.getBtnPilih())){
            ControllerMahasiswaUtama j = new ControllerMahasiswaUtama(model);
            v.dispose();
        }
        
    }
}
