package qubexplorer.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.sonar.wsclient.issue.ActionPlan;
import org.sonar.wsclient.services.Rule;
import qubexplorer.ActionPlanFilter;
import qubexplorer.Counting;
import qubexplorer.IssueFilter;
import qubexplorer.RuleFilter;
import qubexplorer.Severity;
import qubexplorer.SeverityFilter;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//qubexplorer.info//Info//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "InfoTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "qubexplorer.info.InfoTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_InfoAction",
        preferredID = "InfoTopComponent")
@Messages({
    "CTL_InfoAction=Info",
    "CTL_InfoTopComponent=Sonar - Project Summary",
    "HINT_InfoTopComponent=This is a Info window"
})
public final class SonarMainTopComponent extends TopComponent {
    private Project project;
    private String sonarQubeUrl;
    private String resourceKey;

    public SonarMainTopComponent() {
        initComponents();
        setName(Bundle.CTL_InfoTopComponent());
        setToolTipText(Bundle.HINT_InfoTopComponent());
        ActionListener actionListener = new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
                 JComponent component = (JComponent)ae.getSource();
                 IssueFilter[] filters;
                 if(actionPlansCombo.getSelectedItem() instanceof ActionPlan) {
                     filters=new IssueFilter[2];
                     filters[1]=new ActionPlanFilter((ActionPlan)actionPlansCombo.getSelectedItem());
                 }else{
                     filters=new IssueFilter[1];
                 }
                 if(component.getClientProperty("severity") != null) {
                     filters[0]=new SeverityFilter((Severity)component.getClientProperty("severity"));
                 }else{
                     filters[0]=new RuleFilter((Rule)component.getClientProperty("rule"));
                 }
                 new IssuesWorker(project, sonarQubeUrl, resourceKey, filters).execute();
             }

         };
        severityPanelBlocker.addActionListener(actionListener);
        severityPanelCritical.addActionListener(actionListener);
        severityPanelMajor.addActionListener(actionListener);
        severityPanelMinor.addActionListener(actionListener);
        severityPanelInfo.addActionListener(actionListener);
        actionPlansCombo.setRenderer(new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
                if(value instanceof ActionPlan) {
                    ActionPlan actionPlan = (ActionPlan)value;
                    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
                    label.setText(actionPlan.name()+" - "+dateFormat.format((actionPlan).deadLine()));
                }
                return label;
            }
            
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        severityPanelBlocker = new qubexplorer.ui.RuleCountPanel();
        severityPanelCritical = new qubexplorer.ui.RuleCountPanel();
        severityPanelMajor = new qubexplorer.ui.RuleCountPanel();
        severityPanelMinor = new qubexplorer.ui.RuleCountPanel();
        severityPanelInfo = new qubexplorer.ui.RuleCountPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        totalCount = new javax.swing.JTextField();
        listAllIssues = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        rulesCompliance = new javax.swing.JLabel();
        actionPlansCombo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        jButton1.setFont(jButton1.getFont().deriveFont(jButton1.getFont().getSize()+5f));
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton1.text")); // NOI18N

        jButton2.setFont(jButton2.getFont().deriveFont(jButton2.getFont().getSize()+5f));
        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton2.text")); // NOI18N
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+5f));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel1.text")); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel2.text")); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel3.text")); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel4.text")); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton3.text")); // NOI18N
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton4, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton4.text")); // NOI18N
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton5, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton5.text")); // NOI18N
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton16, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton16.text")); // NOI18N
        jButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jButton16)))
        );

        jButton17.setFont(jButton17.getFont().deriveFont(jButton17.getFont().getSize()+5f));
        org.openide.awt.Mnemonics.setLocalizedText(jButton17, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton17.text")); // NOI18N

        jButton18.setFont(jButton18.getFont().deriveFont(jButton18.getFont().getSize()+5f));
        org.openide.awt.Mnemonics.setLocalizedText(jButton18, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton18.text")); // NOI18N
        jButton18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getSize()+5f));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel6.text")); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel12.text")); // NOI18N

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel13.text")); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel14.text")); // NOI18N

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel15.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton19, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton19.text")); // NOI18N
        jButton19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton20, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton20.text")); // NOI18N
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton21, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton21.text")); // NOI18N
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.openide.awt.Mnemonics.setLocalizedText(jButton22, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jButton22.text")); // NOI18N
        jButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jButton22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(true);
        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        severityPanelBlocker.setAlignmentY(0.0F);
        severityPanelBlocker.setSeverity(qubexplorer.Severity.BLOCKER);
        jPanel4.add(severityPanelBlocker);

        severityPanelCritical.setAlignmentY(0.0F);
        severityPanelCritical.setSeverity(qubexplorer.Severity.CRITICAL);
        jPanel4.add(severityPanelCritical);

        severityPanelMajor.setAlignmentY(0.0F);
        severityPanelMajor.setSeverity(qubexplorer.Severity.MAJOR);
        jPanel4.add(severityPanelMajor);

        severityPanelMinor.setAlignmentY(0.0F);
        severityPanelMinor.setSeverity(qubexplorer.Severity.MINOR);
        jPanel4.add(severityPanelMinor);

        severityPanelInfo.setAlignmentY(0.0F);
        severityPanelInfo.setSeverity(qubexplorer.Severity.INFO);
        jPanel4.add(severityPanelInfo);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getSize()+8f));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.jLabel7.text")); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 1, 1));
        jPanel6.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);

        totalCount.setEditable(false);
        totalCount.setColumns(10);
        totalCount.setFont(totalCount.getFont().deriveFont(totalCount.getFont().getSize()+7f));
        totalCount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalCount.setText(org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.totalCount.text")); // NOI18N
        totalCount.setBorder(null);
        totalCount.setOpaque(false);
        jPanel7.add(totalCount);

        org.openide.awt.Mnemonics.setLocalizedText(listAllIssues, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.listAllIssues.text")); // NOI18N
        listAllIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllIssuesActionPerformed(evt);
            }
        });
        jPanel7.add(listAllIssues);

        jPanel6.add(jPanel7, java.awt.BorderLayout.LINE_END);
        jPanel6.add(jSeparator2, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel6);

        jScrollPane1.setViewportView(jPanel4);

        title.setFont(title.getFont().deriveFont(title.getFont().getSize()+10f));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(title, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.title.text")); // NOI18N

        rulesCompliance.setFont(rulesCompliance.getFont().deriveFont(rulesCompliance.getFont().getSize()+15f));
        rulesCompliance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(rulesCompliance, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.rulesCompliance.text")); // NOI18N

        actionPlansCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPlansComboActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(SonarMainTopComponent.class, "SonarMainTopComponent.actionPlan.label")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionPlansCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rulesCompliance)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rulesCompliance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionPlansCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void listAllIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllIssuesActionPerformed
        IssueFilter[] filters;
        if(actionPlansCombo.getSelectedItem() instanceof ActionPlan) {
            filters=new IssueFilter[] {new ActionPlanFilter((ActionPlan)actionPlansCombo.getSelectedItem())};
        }else{
            filters=new IssueFilter[0];
        }
        new IssuesWorker(project, sonarQubeUrl, resourceKey, filters).execute();
    }//GEN-LAST:event_listAllIssuesActionPerformed

    private void actionPlansComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPlansComboActionPerformed
        IssueFilter[] filters;
        if(actionPlansCombo.getSelectedItem() instanceof ActionPlan) {
            filters=new IssueFilter[] { new ActionPlanFilter((ActionPlan)actionPlansCombo.getSelectedItem()) };
        }else{
            filters=new IssueFilter[0];
        }
        new CountsWorker(project, sonarQubeUrl, resourceKey, filters).execute();
    }//GEN-LAST:event_actionPlansComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionPlansCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton listAllIssues;
    private javax.swing.JLabel rulesCompliance;
    private qubexplorer.ui.RuleCountPanel severityPanelBlocker;
    private qubexplorer.ui.RuleCountPanel severityPanelCritical;
    private qubexplorer.ui.RuleCountPanel severityPanelInfo;
    private qubexplorer.ui.RuleCountPanel severityPanelMajor;
    private qubexplorer.ui.RuleCountPanel severityPanelMinor;
    private javax.swing.JLabel title;
    private javax.swing.JTextField totalCount;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    public void setSonarQubeUrl(String sonarQubeUrl) {
        this.sonarQubeUrl = sonarQubeUrl;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }
    
    public void setProject(Project project) {
        this.project = project;
        title.setText(ProjectUtils.getInformation(project).getDisplayName());
    }
    
    public void setActionPlans(List<ActionPlan> plans) {
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        model.addElement(org.openide.util.NbBundle.getMessage(Bundle.class, "SonarMainTopComponent.actionPlansCombo.none"));
        for(ActionPlan plan: plans) {
            model.addElement(plan);
        }
        actionPlansCombo.setModel(model);
    }
    
    public void setCounting(Counting counting) {
        severityPanelBlocker.setExpanded(false);
        severityPanelCritical.setExpanded(false);
        severityPanelMajor.setExpanded(false);
        severityPanelMinor.setExpanded(false);
        severityPanelInfo.setExpanded(false);
        severityPanelBlocker.setRuleCounts(counting.getRuleCounts(Severity.BLOCKER));
        severityPanelCritical.setRuleCounts(counting.getRuleCounts(Severity.CRITICAL));
        severityPanelMajor.setRuleCounts(counting.getRuleCounts(Severity.MAJOR));
        severityPanelMinor.setRuleCounts(counting.getRuleCounts(Severity.MINOR));
        severityPanelInfo.setRuleCounts(counting.getRuleCounts(Severity.INFO));
        int sum=0;
        for(Severity severity: Severity.values()) {
            sum+=counting.getCount(severity);
        }
        NumberFormat numberFormat=NumberFormat.getIntegerInstance();
        totalCount.setText(numberFormat.format(sum));
        listAllIssues.setEnabled(sum > 0);
        NumberFormat format=NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(1);
        format.setMaximumFractionDigits(1);
        rulesCompliance.setText(format.format(counting.getRulesCompliance())+" %");
        revalidate();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        //String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
    public static void main(String[] args) {
        final JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SonarMainTopComponent());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}
