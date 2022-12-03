
package menuutama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author NaufalSholahuddin
 */
public class PengaturanKriteria extends javax.swing.JPanel {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    
    /**
     * Creates new form Pengaturan
     */
    public PengaturanKriteria() {
        initComponents();
        updateDataTabel();

    }
    
    protected void kosong(){
        cbKriteria1.setSelectedIndex(0);
        cbKriteria2.setSelectedIndex(0);
        cbKriteria3.setSelectedIndex(0);
        cbKriteria4.setSelectedIndex(0);
    }
    
    protected void updateDataTabel(){
        Object[] Baris = {
            "Kode Kriteria",
            "Nama Kriteria",
            "Prioritas Kepentingan"
        };
        tabmode = new DefaultTableModel(null, Baris);
        tabelKriteria.setModel(tabmode);
        String sql = "SELECT * FROM kriteria ORDER BY kd_kriteria";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("kd_kriteria");
                String b = hasil.getString("nama_kriteria");
                String c = hasil.getString("prioritas_kepentingan");
                
                String[] data={a, b, c};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void getDataTabel(){
        String sql = "SELECT nama_kriteria FROM kriteria ORDER BY kd_kriteria";
        int n = 1;
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nama_kriteria");
                if(n==1){
                    cbKriteria1.setSelectedItem(a);
                }else if(n==2){
                    cbKriteria2.setSelectedItem(a);
                }else if(n==3){
                    cbKriteria3.setSelectedItem(a);
                }else{
                    cbKriteria4.setSelectedItem(a);
                }   
                n++;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void insertDataKriteria(){
        try{
            int n=1;
            do{
                String kepentingan, kodeKriteria;
                String sql = "INSERT INTO kriteria VALUES (?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                kodeKriteria = "K"+n;
                stat.setString(1, kodeKriteria);
                if(n == 1){
                    stat.setString(2, cbKriteria1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(n == 2){
                    stat.setString(2, cbKriteria2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(n == 3){
                    stat.setString(2, cbKriteria3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(2, cbKriteria4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                }
                stat.setString(3, kepentingan);
                stat.executeUpdate();
                
                n++;
            }while(n<=4);
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            kosong();
            updateDataTabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }
    
    protected void hapusDataKriteria(){
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM kriteria";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus ");
                kosong();
                updateDataTabel();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal DiHapus " + e);
            }
        }
    }
    
    protected void editDataKriteria(){
        try{
            int n=1;
            do{
                String kepentingan, kodeKriteria;
                String sql = "UPDATE kriteria set nama_kriteria=?, prioritas_kepentingan=? WHERE kd_kriteria=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                
                if(n == 1){
                    stat.setString(1, cbKriteria1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(n == 2){
                    stat.setString(1, cbKriteria2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(n == 3){
                    stat.setString(1, cbKriteria3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(1, cbKriteria4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                }
                stat.setString(2, kepentingan);
                kodeKriteria = "K"+n;
                stat.setString(3, kodeKriteria);
                stat.executeUpdate();
                n++;
            }while(n<=4);
            JOptionPane.showMessageDialog(null, "DATA Berhasil DiUbah");
            kosong();
            updateDataTabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal DiUbah "+e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judul = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKriteria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tombolSimpan = new javax.swing.JButton();
        tombolEdit = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbKriteria1 = new javax.swing.JComboBox<>();
        cbKriteria2 = new javax.swing.JComboBox<>();
        cbKriteria3 = new javax.swing.JComboBox<>();
        cbKriteria4 = new javax.swing.JComboBox<>();

        judul.setBackground(new java.awt.Color(255, 255, 255));
        judul.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        judul.setForeground(new java.awt.Color(0, 51, 153));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        judul.setText("  Pengaturan Bobot Kepentingan Kriteria");
        judul.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Kriteria", "Nama Kriteria", "Prioritas Kepentingan"
            }
        ));
        tabelKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKriteria);

        jLabel1.setText("Catatan : Edit, klik data pada tabel terlebih dahulu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tombolSimpan.setBackground(new java.awt.Color(0, 51, 102));
        tombolSimpan.setForeground(new java.awt.Color(255, 255, 255));
        tombolSimpan.setText("Simpan");
        tombolSimpan.setBorder(null);
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolEdit.setBackground(new java.awt.Color(0, 51, 102));
        tombolEdit.setForeground(new java.awt.Color(255, 255, 255));
        tombolEdit.setText("Edit");
        tombolEdit.setBorder(null);
        tombolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditActionPerformed(evt);
            }
        });

        tombolHapus.setBackground(new java.awt.Color(102, 0, 0));
        tombolHapus.setForeground(new java.awt.Color(255, 255, 255));
        tombolHapus.setText("Hapus");
        tombolHapus.setBorder(null);
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Prioritas Kepentingan dari Kriteria"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Kriteria Sangat Penting ke-1");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Kriteria penting ke-2");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Kriteria cukup penting ke-3");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Kriteria biasa ke-4");

        cbKriteria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kriteria -", "Pendidikan Terakhir", "Wawancara", "Waktu Luang", "Sikap" }));

        cbKriteria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kriteria -", "Pendidikan Terakhir", "Wawancara", "Waktu Luang", "Sikap" }));

        cbKriteria3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kriteria -", "Pendidikan Terakhir", "Wawancara", "Waktu Luang", "Sikap" }));

        cbKriteria4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kriteria -", "Pendidikan Terakhir", "Wawancara", "Waktu Luang", "Sikap" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbKriteria4, javax.swing.GroupLayout.Alignment.LEADING, 0, 266, Short.MAX_VALUE)
                    .addComponent(cbKriteria3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKriteria2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKriteria1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbKriteria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKriteria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKriteria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKriteria4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        if(cbKriteria1.getSelectedIndex() != 0 && cbKriteria2.getSelectedIndex() != 0 
                && cbKriteria3.getSelectedIndex() != 0 && cbKriteria4.getSelectedIndex() != 0){    
            insertDataKriteria();
        }else{
            JOptionPane.showMessageDialog(null, "Mohon isi semua kriteria yang ada!", "Error", ERROR_MESSAGE );
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditActionPerformed
        // TODO add your handling code here:
        editDataKriteria();
    }//GEN-LAST:event_tombolEditActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        hapusDataKriteria();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKriteriaMouseClicked
        // TODO add your handling code here:
        getDataTabel();
    }//GEN-LAST:event_tabelKriteriaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbKriteria1;
    private javax.swing.JComboBox<String> cbKriteria2;
    private javax.swing.JComboBox<String> cbKriteria3;
    private javax.swing.JComboBox<String> cbKriteria4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judul;
    private javax.swing.JTable tabelKriteria;
    private javax.swing.JButton tombolEdit;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    // End of variables declaration//GEN-END:variables
}
