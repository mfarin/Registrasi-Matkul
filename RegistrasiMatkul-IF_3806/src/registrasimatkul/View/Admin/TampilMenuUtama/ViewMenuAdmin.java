/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimatkul.View.Admin.TampilMenuUtama;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ViewMenuAdmin extends javax.swing.JFrame{

    /**
     * Creates new form viewMenuAdmin
     */
    public ViewMenuAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnMatakuliah = new javax.swing.JButton();
        BtnDosen = new javax.swing.JButton();
        BtnMahasiswa = new javax.swing.JButton();
        BtnKelas = new javax.swing.JButton();
        BtnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu Admin");

        BtnMatakuliah.setText("Matakuliah");

        BtnDosen.setText("Dosen");

        BtnMahasiswa.setText("Mahasiswa");

        BtnKelas.setText("Kelas");

        BtnExit.setText("Exit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnMahasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnMatakuliah)
                    .addComponent(jLabel1)
                    .addComponent(BtnKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(BtnMatakuliah)
                .addGap(18, 18, 18)
                .addComponent(BtnDosen)
                .addGap(18, 18, 18)
                .addComponent(BtnMahasiswa)
                .addGap(18, 18, 18)
                .addComponent(BtnKelas)
                .addGap(18, 18, 18)
                .addComponent(BtnExit)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDosen;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnKelas;
    private javax.swing.JButton BtnMahasiswa;
    private javax.swing.JButton BtnMatakuliah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
  
    public Object getBtnMatakuliah(){
        return BtnMatakuliah;
    }
    
    public Object getBtnDosen(){
        return BtnDosen;
    }
    
    public Object getBtnMahasiswa(){
        return BtnMahasiswa;
    }
    
    public Object getBtnKelas(){
        return BtnKelas;
    }
    
    public Object getBtnExit(){
        return BtnExit;
    }
    
    /**
     *
     * @param e
     */
  
    public void addListener(ActionListener e) {
        BtnMatakuliah.addActionListener(e);
        BtnDosen.addActionListener(e);
        BtnMahasiswa.addActionListener(e);
        BtnKelas.addActionListener(e);
        BtnExit.addActionListener(e);
    }
    
  
    public void viewErrorMsg(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
}
