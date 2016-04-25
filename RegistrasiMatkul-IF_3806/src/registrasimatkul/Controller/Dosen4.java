package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_4;

public class Dosen4 implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_4 v;
    
    public Dosen4(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_4();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source.equals(v.getBtnSubmit())){
            try {
                if(model.getDosen(v.gettfNip())!=null){
                    if(model.getKelas(v.gettfKode())!=null){
                        Kelas k = new Kelas(model.getKelas(v.gettfKode()).getMatakuliah(), model.getDosen(v.gettfNip()),v.gettfKode());
                        model.SaveKelas(k);
                        model.addKelas(k);
                        v.reset();
                    }
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else if(Source.equals(v.GetBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
}
