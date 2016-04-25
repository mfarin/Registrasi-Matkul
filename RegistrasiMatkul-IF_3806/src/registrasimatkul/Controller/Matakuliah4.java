package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Model.Kelas;
import registrasimatkul.Model.Matakuliah;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_4;

public class Matakuliah4 implements ActionListener{
    private Aplikasi model;
    private MenuviewMatakuliah_4 v;

    public Matakuliah4(Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_4();
        v.setVisible(true);
        v.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(v.getBtnSubmit())){
            try{
                if (model.getMatakuliah(v.gettfKodeMK())!=null){
                        Matakuliah mk = new Matakuliah(model.getMatakuliah(v.gettfKodeMK()).getNama(), model.getMatakuliah(v.gettfKodeMK()).getSks(), v.gettfKodeMK());
                    if (model.getKelas(v.gettfIdKelas())!=null){
                        Kelas k1 = new Kelas(mk,model.getDosen(model.getKelas(v.gettfIdKelas()).getDosen().getNip()), v.gettfIdKelas());
                        model.SaveKelas(k1);
                        //model.removeMatakuliah(mk);
                        model.addKelas(k1);
                        JOptionPane.showMessageDialog(v, "Berhasil memasukkan Matakuliah");
                        v.reset();
                    }
                    else{
                        //System.out.println("Maaf Id Kelas yang diinputkan salah");
                        JOptionPane.showMessageDialog(v, "Maaf Id Kelas yang diinputkan salah");
                    }
                }
                else{
                    //System.out.println("Maaf Kode MK yang dimasukkan salah");
                    JOptionPane.showMessageDialog(v, "Maaf Kode MK yang dimasukkan salah");
                }
            }catch(Exception se){
                se.printStackTrace();
            }
        }
        else if (source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
    }
    
}
