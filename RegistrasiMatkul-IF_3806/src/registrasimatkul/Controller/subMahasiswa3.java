package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Controller.Mahasiswa.SubMahasiswaLog;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Mahasiswa.viewSubMahasiswa3;

public class subMahasiswa3 extends MouseAdapter implements ActionListener{
    Aplikasi model;
    viewSubMahasiswa3 v;
    /*int NIM; //= x.verifyLog(NIM);
    SubMahasiswaLog x;
    int nimbaru = x.verifyLog(NIM);
    Mahasiswa mhs;
    Mahasiswa mhsbaru = model.MhsLogin(NIM);
    */
    public subMahasiswa3(Aplikasi model){
        this.model = model;
        v = new viewSubMahasiswa3();
        v.setVisible(true);
        v.addListener(this);
        v.addAdapter(this);
        v.setListData(model.getListMahasiswaKelas());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source.equals(v.getBtnRefresh())){
                v.setDetailKelas("");
            }
            else if(source.equals(v.getBtnPilih())){
                ControllerMahasiswaUtama j = new ControllerMahasiswaUtama(model);
                v.dispose();
            }
    }
    
    public void mousePressed(MouseEvent e){
        Object Source = e.getSource();
        if(Source.equals(v.getList())){
            try {
                Mahasiswa m = model.getMahasiswa2(v.getSelectedDataKelas());
                v.setDetailKelas(m.getNama());
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
    }
    
}
