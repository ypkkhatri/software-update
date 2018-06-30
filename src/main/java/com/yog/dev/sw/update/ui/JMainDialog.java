package com.yog.dev.sw.update.ui;

import com.yog.dev.sw.update.beans.Dependency;
import com.yog.dev.sw.update.beans.Update;
import com.yog.dev.sw.update.utils.FileUtils;
import com.yog.dev.sw.update.utils.PropertyUtils;
import com.yog.dev.sw.update.xml.UrlXMLParser;
import java.io.StringWriter;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Yougeshwar
 */
public class JMainDialog extends javax.swing.JDialog {

    private String version;
    private final String appName;
    private final String currentVersion;
    private final String updateXmlUrl;
    private final String destLibDir;
    private Update update;

    public JMainDialog(String appName, String currentVersion, String updateXmlUrl) {
        this(appName, currentVersion, updateXmlUrl, "libs/");
    }

    public JMainDialog(String appName, String currentVersion, String updateXmlUrl, String destLibDir) {
        this.appName = appName;
        this.currentVersion = currentVersion;
        this.updateXmlUrl = updateXmlUrl;
        this.destLibDir = destLibDir.endsWith("/") ? destLibDir : destLibDir + "/";
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        progressPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        cancelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Software Update");
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("<html>Obutech oPOS <b><i>New Version Available</i></b> with important bugfixes and features.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Current Version:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("New Version:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Patch Size:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("1.2.56");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("1.2.57");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("from 4.1 to 4.61 MB");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Downloading...");

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 252, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(updateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        doUpdate();
    }//GEN-LAST:event_updateButtonActionPerformed

    public void init() {
        this.version = PropertyUtils.getValue("app.version");
        
        setTitle(appName + " Update - SUv" + this.version);
        jLabel5.setText(currentVersion);

        getRootPane().setDefaultButton(updateButton);
        UrlXMLParser parser = new UrlXMLParser();
        try {
            update = parser.loadXML(updateXmlUrl);
            jLabel1.setText("<html>" + appName + " <b><i>New Version Available</i></b> with important bugfixes and features.");
            jLabel6.setText(update.getVersion());
            jLabel7.setText(numberFormat(update.getFullSize()) + " MB");
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            ex.printStackTrace(pw);
            JOptionPane.showMessageDialog(this, sw.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doUpdate() {
        new Thread(() -> {
            try {
                cancelButton.setEnabled(false);
                updateButton.setEnabled(false);
                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

                jProgressBar1.setMinimum(0);
                jProgressBar1.setMaximum(update.getDependencies().size() + update.getMainFiles().size() + 1);

                int c = 1;
                for (int i = 0; i < update.getDependencies().size(); i++) {
                    Dependency d = update.getDependencies().get(i);
                    String to = this.destLibDir + d.getFile().substring(d.getFile().lastIndexOf("/") + 1);

                    FileUtils.download(d.getFile(), to, true);

                    jProgressBar1.setValue(c++);
                }

                for (int i = 0; i < update.getMainFiles().size(); i++) {
                    String mainFile = update.getMainFiles().get(i);
                    String toFileName = mainFile.substring(mainFile.lastIndexOf("/") + 1).replaceAll("%20", " ");
                    FileUtils.download(mainFile, toFileName, false);
                    jProgressBar1.setValue(c++);
                }

                jProgressBar1.setValue(c++);

                JOptionPane.showMessageDialog(this, "Software updated with new version, restart application to see changes");
                System.exit(0);
            } catch (Exception ex) {
                StringWriter sw = new StringWriter();
                java.io.PrintWriter pw = new java.io.PrintWriter(sw);
                ex.printStackTrace(pw);
                JOptionPane.showMessageDialog(JMainDialog.this, ex.toString());
            }
            cancelButton.setEnabled(true);
            updateButton.setEnabled(true);
        }).start();
    }

    private String numberFormat(double num) {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(num);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
