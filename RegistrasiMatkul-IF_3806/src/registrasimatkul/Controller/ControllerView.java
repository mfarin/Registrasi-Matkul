/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimatkul.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.View.Admin.TampilMenuUtama.View;
import registrasimatkul.View.Admin.TampilMenuUtama.ViewMenuAdmin;
import registrasimatkul.View.ViewMain;

/**
 *
 * @author USER
 */
public class ControllerView implements ActionListener {
    private Aplikasi model;
    private View v;
    
    public ControllerView(Aplikasi model){
        this.model = model;
        v = new View();
        v.setVisible(true);
        v.AddListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(v.getBtnPilih())){
            if("Dani123".equals(v.gettfUsername())){
                if("ADM1".equals(v.gettfPassword())){
                    ControllerAdminUtama j = new ControllerAdminUtama(model);
                    v.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(v, "Maaf Password anda salah");
                    v.reset();
                }
           }
           else{
                JOptionPane.showMessageDialog(v, "Maaf Username yang anda masukkan salah");
                v.reset();
            }
        }
        else if(source.equals(v.getBtnExit())){
            ControllerMenu j = new ControllerMenu(model);
            v.dispose();
        }
    }
}
