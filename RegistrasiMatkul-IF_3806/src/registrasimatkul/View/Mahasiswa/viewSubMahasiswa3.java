/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimatkul.View.Mahasiswa;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author USER
 */
public class viewSubMahasiswa3 extends javax.swing.JFrame {

    /**
     * Creates new form viewSubMahasiswa3
     */
    public viewSubMahasiswa3() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txDetailKelas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txDataKelas = new javax.swing.JList<>();
        BtnPilih = new javax.swing.JButton();
        BtnRef = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lihat Pilihan Kelas");

        txDetailKelas.setColumns(20);
        txDetailKelas.setRows(5);
        jScrollPane1.setViewportView(txDetailKelas);

        txDataKelas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(txDataKelas);

        BtnPilih.setText("OK");

        BtnRef.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnPilih)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPilih)
                    .addComponent(BtnRef))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPilih;
    private javax.swing.JButton BtnRef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> txDataKelas;
    private javax.swing.JTextArea txDetailKelas;
    // End of variables declaration//GEN-END:variables
    public int getSelectedDataKelas(){
        return Integer.parseInt(txDataKelas.getSelectedValue());    
    }
    
    public Object getList(){
        return txDataKelas;
    }
    
    public Object getBtnPilih(){
        return BtnPilih;
    }
    
    public Object getBtnRefresh(){
        return BtnRef;
    }
    
    public void setDetailKelas(String s){
        txDetailKelas.setText(s);
    }
    
    public void setListKodeKelas(String list[]){
        txDataKelas.setListData(list);
    }
    
    public void addAdapter(MouseAdapter e){
        txDataKelas.addMouseListener(e);
    }
    
    public void setListData(String[] m){
        txDataKelas.setListData(m);
    }
    
    public void addListener(ActionListener e){
      BtnPilih.addActionListener(e);
      BtnRef.addActionListener(e);  
    }
}

    
