/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peter.mavenrunner;

import javax.swing.JOptionPane;

/**
 *
 * @author peter
 */
public class MavenGoalDialog extends javax.swing.JDialog {

	public boolean isCancel = true;

	/**
	 * Creates new form MavenGoalDialog
	 */
	public MavenGoalDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
	 * Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        goalsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        profileTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        skipTestsCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelTextField = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertiesTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.jLabel1.text")); // NOI18N

        goalsTextField.setText(org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.goalsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.jLabel2.text")); // NOI18N

        profileTextField.setText(org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.profileTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.jLabel4.text")); // NOI18N

        nameTextField.setText(org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.nameTextField.text")); // NOI18N

        skipTestsCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(skipTestsCheckBox, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.skipTestsCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(saveButton, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.saveButton.text")); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelTextField, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.cancelTextField.text")); // NOI18N
        cancelTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(cancelTextField);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(MavenGoalDialog.class, "MavenGoalDialog.jLabel3.text")); // NOI18N

        propertiesTextArea.setColumns(20);
        propertiesTextArea.setRows(5);
        jScrollPane1.setViewportView(propertiesTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(nameTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(skipTestsCheckBox)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(profileTextField)
                                    .addComponent(goalsTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(goalsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(profileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skipTestsCheckBox)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		if (nameTextField.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Name cannot be empty", "error", JOptionPane.ERROR_MESSAGE);
		} else {
			isCancel = false;
			setVisible(false);
		}
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTextFieldActionPerformed
		isCancel = true;
		setVisible(false);
    }//GEN-LAST:event_cancelTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelTextField;
    public javax.swing.JTextField goalsTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nameTextField;
    public javax.swing.JTextField profileTextField;
    public javax.swing.JTextArea propertiesTextArea;
    private javax.swing.JButton saveButton;
    public javax.swing.JCheckBox skipTestsCheckBox;
    // End of variables declaration//GEN-END:variables
}