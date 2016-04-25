package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.Model.Mahasiswa;
import registrasimatkul.View.Admin.Mahasiswa.MenuviewMahasiswa_3;

public class Mahasiswa3 extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    private MenuviewMahasiswa_3 v;
    
    public Mahasiswa3(Aplikasi model){
        this.model = model;
        v = new MenuviewMahasiswa_3();
        v.setVisible(true);
        v.addListener(this);
        v.addAdapter(this);
        v.setListData(model.getListMahasiswa());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnRefresh())){
            v.setDetailMhs("");
        }
        else if(source.equals(v.getBtnPilih())){
            MahasiswaMenu j = new MahasiswaMenu(model);
            v.dispose();
        }
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(v.getList())){
            ArrayList<Kelas> k1 = new ArrayList<Kelas>();
            try{
                Mahasiswa m = model.getMahasiswa(v.getSelectedKodeMhs());
                k1 = model.Mahasiswa_3(m.getNim());
                String mhs = null;
                for(Kelas kx : k1){
                    mhs = "Nama Mhs: "+m.getNama()+"\n"+
                            "Nim: "+m.getNim()+"\n"+
                            k1.toString();
                }
                //v.setDetailMhs(m.toString());
                v.setDetailMhs(mhs);
            }catch(Exception se){
                se.printStackTrace();
            }
        }
    }
}
