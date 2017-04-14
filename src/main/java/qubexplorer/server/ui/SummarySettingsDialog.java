package qubexplorer.server.ui;

import qubexplorer.ClassifierType;
import qubexplorer.IssueType;
import qubexplorer.Severity;

/**
 *
 * @author Victor
 */
public class SummarySettingsDialog extends javax.swing.JDialog {

    public enum Option {

        ACCEPT,
        CANCEL
    }

    private Option option;

    /**
     * Creates new form ProyectChooser
     */
    public SummarySettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Option showDialog() {
        setLocationRelativeTo(getParent());
        setVisible(true);
        return option;
    }

    public String[] getAssignees() {
        return assigneesTextfield.getText().split("\\s*,\\s*");
    }
    
    public void setAssignees(String[] asignees) {
        assigneesTextfield.setText(String.join(", ", asignees));
    }
    
    public void setClassifierType(ClassifierType type) {
        if(Severity.getType().getClass().isInstance(type)) {
            groupBySeverityButton.setSelected(true);
        }else if(IssueType.getType().getClass().isInstance(type)) {
            groupByTypeButton.setSelected(true);
        }
    }
    
    public ClassifierType<?> getClassifierType() {
        return groupBySeverityButton.isSelected() ? Severity.getType() :  IssueType.getType();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRetrieval = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        credentialsWarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        assigneesTextfield = new javax.swing.JTextField();
        groupBySeverityButton = new javax.swing.JRadioButton();
        groupByTypeButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.title")); // NOI18N
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        credentialsWarning.setForeground(new java.awt.Color(204, 0, 0));
        credentialsWarning.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(credentialsWarning, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.credentialsWarning.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.jLabel5.text")); // NOI18N

        assigneesTextfield.setText(org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.assigneesTextfield.text")); // NOI18N

        buttonGroupRetrieval.add(groupBySeverityButton);
        groupBySeverityButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(groupBySeverityButton, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.groupBySeverityButton.text")); // NOI18N

        buttonGroupRetrieval.add(groupByTypeButton);
        org.openide.awt.Mnemonics.setLocalizedText(groupByTypeButton, org.openide.util.NbBundle.getMessage(SummarySettingsDialog.class, "SummarySettingsDialog.groupByTypeButton.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(groupBySeverityButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(groupByTypeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(credentialsWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                            .addComponent(assigneesTextfield))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(assigneesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credentialsWarning)
                    .addComponent(groupBySeverityButton)
                    .addComponent(groupByTypeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        option = Option.ACCEPT;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        option = Option.CANCEL;
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        option = Option.CANCEL;
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assigneesTextfield;
    private javax.swing.ButtonGroup buttonGroupRetrieval;
    private javax.swing.JLabel credentialsWarning;
    private javax.swing.JRadioButton groupBySeverityButton;
    private javax.swing.JRadioButton groupByTypeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

}
