/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Demo;

import br.unesp.rc.Dao.EmocaoDAO;
import br.unesp.rc.Dao.FabricaDAO;
import br.unesp.rc.Dao.TweetDAO;
import br.unesp.rc.Dao.UsuarioDAO;
import br.unesp.rc.Emocao.analiseEmocao;
import br.unesp.rc.Emocao.analiseMensagem;
import br.unesp.rc.Model.Emocao;
import br.unesp.rc.Model.associacaoTwitter;
import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Model.Usuario;
import br.unesp.rc.Model.categoriaTweet;
import br.unesp.rc.Twitter.adicionarTweet;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 *
 * @author marco
 */
public class telaEscreverTweet extends javax.swing.JFrame {

    /**
     * Creates new form telaEscreverTweet
     */
    private Usuario userform;
     private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
     public telaEscreverTweet() {
        initComponents();
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo2.png")));
    }
    
    public telaEscreverTweet(Usuario user) {
        userform = user;
        initComponents();
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo2.png")));
        this.setTitle("Olá, " + user.getNome());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        textboxTweet = new javax.swing.JTextArea();
        btnTweet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("O que está acontecendo ?");

        textboxTweet.setColumns(20);
        textboxTweet.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        textboxTweet.setRows(5);
        jScrollPane2.setViewportView(textboxTweet);

        btnTweet.setText("Tweet");
        btnTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTweetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTweet)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTweet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTweetActionPerformed
        // TODO add your handling code here:
        
        adicionarTweet addTweet = new adicionarTweet();
        Date date = new Date();
        Tweet twt = new Tweet();
        TweetDAO td = FabricaDAO.getTweetDAO();
        EmocaoDAO edao = FabricaDAO.getEmocaoDAO();
                
        
        analiseMensagem am = new analiseMensagem();
        analiseEmocao em = new analiseEmocao();
        em.trainModel();
        am.trainModel();
        
        try {
            if(am.classifyNewTweet(textboxTweet.getText()) == true){
                Emocao emocao = new Emocao();
                categoriaTweet catTwitter = new categoriaTweet();
                
                Status status = addTweet.adicionarTweet(textboxTweet.getText(),userform.getAt());
                twt.setIdMensagem(status.getId());
                twt.setUsuario(userform);
                twt.setMomentoPostagem(date);
                
                emocao.setEmoçao(em.classifyNewTweet(textboxTweet.getText()));
                emocao.setUsuario(userform.getNome());
                emocao.setTweet(twt.getIdMensagem());
                
                catTwitter.setCodigoCategoria("1");
                catTwitter.setDescricaoCategoria("Twitter verificado");
                catTwitter.setIdTweet(twt.getIdMensagem());
                twt.setEmocao(emocao);
                twt.setCategoriaTweet(catTwitter);
   
                System.out.println(twt.getEmocao().getEmoçao());
                
                td.salvarTweet(twt);
                edao.salvar(emocao);
                td.salvarCategoria(catTwitter);
                
                JOptionPane.showMessageDialog(null, "Tweet salvo com sucesso :) ");
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(telaEscreverTweet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TwitterException ex) {
            Logger.getLogger(telaEscreverTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnTweetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaEscreverTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaEscreverTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaEscreverTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaEscreverTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaEscreverTweet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTweet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textboxTweet;
    // End of variables declaration//GEN-END:variables
}