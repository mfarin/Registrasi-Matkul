/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimatkul.View.Mahasiswa;

import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class viewMahasiswaUtama extends javax.swing.JFrame {

    /**
     * Creates new form viewMahasiswaUtama
     */
    public viewMahasiswaUtama() {
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

        jLabel1 = new javax.swing.JLabel();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        Btn3 = new javax.swing.JButton();
        Btn4 = new javax.swing.JButton();
        Btn5 = new javax.swing.JButton();
        Btn0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu Mahasiswa");

        Btn1.setText("Pilih Kelas");

        Btn2.setText("Batal Pilih Kelas");

        Btn3.setText("Lihat Pilihan Kelas");

        Btn4.setText("Lihat Dosen Kelas");

        Btn5.setText("Tampil Kelas Dalam Database");

        Btn0.setText("Keluar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn5)
                            .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Btn1)
                .addGap(18, 18, 18)
                .addComponent(Btn2)
                .addGap(18, 18, 18)
                .addComponent(Btn3)
                .addGap(18, 18, 18)
                .addComponent(Btn4)
                .addGap(18, 18, 18)
                .addComponent(Btn5)
                .addGap(18, 18, 18)
                .addComponent(Btn0)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn0;
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton Btn4;
    private javax.swing.JButton Btn5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    public Object getBtn1(){
        return Btn1;
    }
    
    public Object getBtn2(){
        return Btn2;
    }
    
    public Object getBtn3(){
        return Btn3;
    }
    
    public Object getBtn4(){
        return Btn4;
    }
    
    public Object getBtn5(){
        return Btn5;
    }
    
    public Object getBtn0(){
        return Btn0;
    }
    
    public void addListener(ActionListener e){
        Btn1.addActionListener(e);
        Btn2.addActionListener(e);
        Btn3.addActionListener(e);
        Btn4.addActionListener(e);
        Btn5.addActionListener(e);
        Btn0.addActionListener(e);
    }
}
