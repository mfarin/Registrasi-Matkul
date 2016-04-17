package registrasimatkul.if_3806;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import javax.swing.JPanel;
import registrasimatkul.if_3806.Aplikasi;
import registrasimatkul.if_3806.viewcoba;
import registrasimatkul.if_3806.View;
import registrasimatkul.if_3806.viewMenuAdmin;

public class ControllerMenu extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private viewcoba tampilan;
    
    public ControllerMenu(Aplikasi model){
        this.model = model;
        View v = new View();
        v.setVisible(true);
        v.addListener((ActionListener) this);
        tampilan = v;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (tampilan instanceof viewMenuAdmin) {
            viewMenuAdmin m = (viewMenuAdmin) tampilan;
            if (source.equals(m.getBtnMatakuliah())) {
                ViewMenuMatakuliahAdmin e = new ViewMenuMatakuliahAdmin();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                tampilan = (viewcoba) e;
            }
            else if (source.equals(m.getBtnDosen())){
                ViewMenuDosen e = new ViewMenuDosen();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                tampilan = (viewcoba) e;
            }
            else if(source.equals(m.getBtnMahasiswa())){
                viewMenuMahasiswa e = new viewMenuMahasiswa();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                tampilan = (viewcoba) e;
            }
            else if(source.equals(m.getBtnKelas())){
                ViewMenuKelas e = new ViewMenuKelas();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                tampilan = (viewcoba) e;
            }
            else if(source.equals(m.getBtnExit())){
                View e = new View();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                tampilan = (viewcoba) e;
            }
        else{
            
        }
    }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (tampilan instanceof View){
            
        }
    }
    
    
    
    
    
}
