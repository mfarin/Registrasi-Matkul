package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Matakuliah.MenuviewMatakuliah_5;

public class Matakuliah5 implements ActionListener{
    private Aplikasi model;
    private MenuviewMatakuliah_5 v;
    
    public Matakuliah5 (Aplikasi model){
        this.model = model;
        v = new MenuviewMatakuliah_5();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source.equals(v.getBtnSubmit())){
            try {
                if(model.getKelas(v.gettfKodekelas())!=null){
                    if(model.getMatakuliah(v.gettfKodeMk())!=null){
                        model.deleteKelasD(v.gettfKodekelas(), v.gettfKodeMk());
                        model.deleteMatakuliah_Array2(v.gettfKodekelas(), v.gettfKodeMk());
                        JOptionPane.showMessageDialog(v, "Berhasil delete Matakuliah");
                        v.reset();
                    }
                    else{
                        //System.out.println("Kode Matkul tidak cocok");
                        JOptionPane.showMessageDialog(v, "Kode Matkul tidak cocok");
                    }
                }
                else{
                    //System.out.println("Kode kelas tidak cocok");
                    JOptionPane.showMessageDialog(v, "Kode kelas tidak cocok");
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else if(Source.equals(v.getBtnPilih())){
            MatakuliahMenu j = new MatakuliahMenu(model);
            v.dispose();
        }
    }
}
