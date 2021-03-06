/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kangagui;

import java.io.File;
import pojos.Tag;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import pojos.Hordozo;

/**
 *
 * @author Droti
 */
public class HordozokKezeleseDialog extends javax.swing.JDialog {

    private java.awt.Frame parent;
    private List<Tag> hordozok;
    private DefaultTableModel dtm;

    public HordozokKezeleseDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Hordozók kezelése");
        setLocationRelativeTo(parent);

        this.parent = parent;

        

        listaFrissit();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUjHordozo = new javax.swing.JButton();
        btnTorles = new javax.swing.JButton();
        btnKilepes = new javax.swing.JButton();
        btModosit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHordozok = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnUjHordozo.setText("Új hordozó");
        btnUjHordozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjHordozoActionPerformed(evt);
            }
        });

        btnTorles.setText("Törlés");
        btnTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorlesActionPerformed(evt);
            }
        });

        btnKilepes.setText("Kilépés");
        btnKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKilepesActionPerformed(evt);
            }
        });

        btModosit.setText("Módosít");
        btModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModositActionPerformed(evt);
            }
        });

        lstHordozok.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstHordozok);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTorles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUjHordozo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModosit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKilepes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUjHordozo)
                        .addGap(18, 18, 18)
                        .addComponent(btnTorles)
                        .addGap(27, 27, 27)
                        .addComponent(btModosit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(btnKilepes))
                    .addComponent(jScrollPane2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUjHordozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjHordozoActionPerformed
        HordozoAdatokDialog had = new HordozoAdatokDialog(parent, true, null);
            had.setVisible(true);

            if (had.isMentes()) {

                Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(had.getHordozo());
                session.getTransaction().commit();
                session.close();

               listaFrissit();

            }
    }//GEN-LAST:event_btnUjHordozoActionPerformed

    private void btnTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorlesActionPerformed
        Hordozo selected = (Hordozo) lstHordozok.getSelectedValue();

        if (selected==null) { //figyelmeztetés, hogy nincs kiválasztva
            JOptionPane.showMessageDialog(rootPane, "Nincsen kiválasztva hordozó", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
        } else {
            int valasz = JOptionPane.showConfirmDialog(rootPane, "Biztosan törölni szeretné a kiválasztott hordozót?", "Törlési megerősítés",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (valasz == JOptionPane.YES_OPTION) {

                
                Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(selected);
                session.getTransaction().commit();
                session.close();

                listaFrissit();

            }
            
            File kep = new File(selected.getKep());
            kep.delete();
        }
    }//GEN-LAST:event_btnTorlesActionPerformed

    private void btModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModositActionPerformed
        Hordozo selected = (Hordozo) lstHordozok.getSelectedValue();
        if (selected==null) { //figyelmeztetés, hogy nincs kiválasztva
            JOptionPane.showMessageDialog(rootPane, "Nincsen kiválasztva hordozó", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
        } else {
            

            HordozoAdatokDialog had = new HordozoAdatokDialog(parent, true, selected);
            had.setVisible(true);

            if (had.isMentes()) {

                Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(had.getHordozo());
                session.getTransaction().commit();
                session.close();

               listaFrissit();

            }

        }
    }//GEN-LAST:event_btModositActionPerformed

    private void btnKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKilepesActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnKilepesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btModosit;
    private javax.swing.JButton btnKilepes;
    private javax.swing.JButton btnTorles;
    private javax.swing.JButton btnUjHordozo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstHordozok;
    // End of variables declaration//GEN-END:variables

    public void listaFrissit() {
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        hordozok = session.createQuery("FROM Hordozo").list();
        session.close();
        lstHordozok.setListData(hordozok.toArray());
    }
}
