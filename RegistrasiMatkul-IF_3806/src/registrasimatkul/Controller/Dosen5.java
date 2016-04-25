package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.Dosen.MenuviewDosen_5;

public class Dosen5 implements ActionListener{
    private Aplikasi model;
    private MenuviewDosen_5 v;
   
    public Dosen5(Aplikasi model){
        this.model = model;
        v = new MenuviewDosen_5();
        v.setVisible(true);
        v.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnSubmit())){
            try {
                if(model.getKelas(v.gettfKodeKelas())!=null){
                    if(model.getDosen(v.gettfNip())!=null){
                        model.deleteKelasDosen(v.gettfKodeKelas(), v.gettfNip());
                        model.removeDosen_Array2(v.gettfKodeKelas(), v.gettfNip());
                        JOptionPane.showMessageDialog(v, "Delete Berhasil");
                        v.reset();
                    }
                    else{
                        //System.out.println("Nip yang dimasukkan salah");
                        JOptionPane.showMessageDialog(v, "Nip yang dimasukkan tidak terdaftar");
                    }
                }
                else{
                    //System.out.println("Kode kelas yang dimasukkan salah");
                    JOptionPane.showMessageDialog(v, "Kode Kelas tidak terdaftar");
                }
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        else if (source.equals(v.getBtnPilih())){
            DosenMenu j = new DosenMenu(model);
            v.dispose();
        }
    }
}
