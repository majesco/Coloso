/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import components.DataMemory;
import components.InstructionMemory;
import components.RegisterBank;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import stages.MainStages;

/**
 *
 * @author nicolasjimenez
 */
public class IDE extends javax.swing.JFrame implements Observer {

    RegisterBank registers = RegisterBank.getInstance();
    DataMemory dataMem = DataMemory.getInstance();

    InstructionMemory instrMem = InstructionMemory.getInstance();

    /**
     * Creates new form IDE
     */
    public IDE() {

        registers.addObserver(this);
        System.out.println(  registers.countObservers());
        
        setTitle("Coloso IDE");
        setResizable(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        textEditor = new javax.swing.JEditorPane();
        rightPanel = new javax.swing.JPanel();
        R0label = new javax.swing.JLabel();
        R1label = new javax.swing.JLabel();
        R2label = new javax.swing.JLabel();
        R3label = new javax.swing.JLabel();
        R4label = new javax.swing.JLabel();
        R5label = new javax.swing.JLabel();
        R6label = new javax.swing.JLabel();
        R7label = new javax.swing.JLabel();
        R8label = new javax.swing.JLabel();
        R9label = new javax.swing.JLabel();
        R10label = new javax.swing.JLabel();
        R11label = new javax.swing.JLabel();
        SPlabel = new javax.swing.JLabel();
        LRlabel = new javax.swing.JLabel();
        PClabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        newMenu = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenu();
        savemenu = new javax.swing.JMenu();
        settingsMenu = new javax.swing.JMenu();
        memoryMenu = new javax.swing.JMenu();
        executeMenu = new javax.swing.JMenu();
        resetMenu = new javax.swing.JMenu();
        stepForwardMenu = new javax.swing.JMenu();
        stepBackwardsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textEditor.setBackground(new java.awt.Color(0, 0, 0));
        textEditor.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        textEditor.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(textEditor);

        R0label.setText("R0     0x0");

        R1label.setText("R1     0x0");

        R2label.setText("R2     0x0");

        R3label.setText("R3     0x0");

        R4label.setText("R4     0x0");

        R5label.setText("R5     0x0");

        R6label.setText("R6     0x0");

        R7label.setText("R7     0x0");

        R8label.setText("R8     0x0");

        R9label.setText("R9     0x0");

        R10label.setText("R10   0x0");

        R11label.setText("R11   0x0");

        SPlabel.setText("SP     0x0     ");

        LRlabel.setText("LR     0x0");

        PClabel.setText("PC     0x0");

        jLabel11.setText("Clock Cycles");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(R0label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R1label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R2label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R3label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R4label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R5label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R6label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R7label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R8label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R9label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R10label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R11label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SPlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LRlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PClabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(R0label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R1label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R2label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R3label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R4label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R5label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R6label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R7label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R8label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R9label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R10label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(R11label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LRlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PClabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        jList1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setAlignmentY(0.1F);
        jScrollPane3.setViewportView(jList1);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(74, 35));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(604, 35));

        newMenu.setText("New");
        newMenu.setToolTipText("");
        newMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(newMenu);

        openMenu.setText("Open");
        openMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(openMenu);

        savemenu.setText("Save");
        savemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savemenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(savemenu);

        settingsMenu.setText("Settings");
        jMenuBar1.add(settingsMenu);

        memoryMenu.setText("Memory");
        jMenuBar1.add(memoryMenu);

        executeMenu.setText("Execute");
        executeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                executeMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(executeMenu);

        resetMenu.setText("Reset");
        resetMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(resetMenu);

        stepForwardMenu.setText("Step Forward");
        jMenuBar1.add(stepForwardMenu);

        stepBackwardsMenu.setText("Step Backward");
        jMenuBar1.add(stepBackwardsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newMenuMouseClicked

        String text = textEditor.getText();

        if (!text.equals("")) {
            saveFile(text);
            textEditor.setText(null);
        }
    }//GEN-LAST:event_newMenuMouseClicked

    private void openMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMenuMouseClicked

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            String textToOpen = "";
            File selectedFile = fileChooser.getSelectedFile();

            Scanner sc = null;
            try {
                sc = new Scanner(selectedFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                textToOpen += str;
                textToOpen += System.lineSeparator();

            }
            textEditor.setText(textToOpen);
        }
    }//GEN-LAST:event_openMenuMouseClicked

    private void savemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savemenuMouseClicked

        String text = textEditor.getText();

        if (!text.equals("")) {
            saveFile(text);
            textEditor.setText(null);
        }
    }//GEN-LAST:event_savemenuMouseClicked

    private void executeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_executeMenuMouseClicked

        String code = textEditor.getText();


    }//GEN-LAST:event_executeMenuMouseClicked

    private void resetMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMenuMouseClicked

        int length = registers.getRegisters().size();

        for (int i = 0; i < length; i++) {

            registers.getRegisters().set(i, "0");
        }

        int lengthMem = dataMem.getDataMemory().size();

        for (int i = 0; i < lengthMem; i++) {

            dataMem.getDataMemory().set(i, "0");
        }

        int lengthInst = dataMem.getDataMemory().size();

        for (int i = 0; i < lengthInst; i++) {

            instrMem.getInstructions().set(i, "0");
        }

    }//GEN-LAST:event_resetMenuMouseClicked

    private void saveFile(String text) {

        FileDialog fd = new FileDialog(this, "Save Your File", FileDialog.SAVE);
        fd.setSize(400, 200);
        fd.setVisible(true);
        try {
            try (FileWriter fw = new FileWriter(fd.getDirectory() + fd.getFile())) {
                fw.write(text); // t1 is the name of your textarea
            } // t1 is the name of your textarea
        } catch (Exception e) {
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {


        MainStages stages = new MainStages();
        stages.start();
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
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new IDE().setVisible(true);

            }
        });
    }

    private javax.swing.JMenu jMenu9;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LRlabel;
    private javax.swing.JLabel PClabel;
    private javax.swing.JLabel R0label;
    private javax.swing.JLabel R10label;
    private javax.swing.JLabel R11label;
    private javax.swing.JLabel R1label;
    private javax.swing.JLabel R2label;
    private javax.swing.JLabel R3label;
    private javax.swing.JLabel R4label;
    private javax.swing.JLabel R5label;
    private javax.swing.JLabel R6label;
    private javax.swing.JLabel R7label;
    private javax.swing.JLabel R8label;
    private javax.swing.JLabel R9label;
    private javax.swing.JLabel SPlabel;
    private javax.swing.JMenu executeMenu;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu memoryMenu;
    private javax.swing.JMenu newMenu;
    private javax.swing.JMenu openMenu;
    private javax.swing.JMenu resetMenu;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JMenu savemenu;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JMenu stepBackwardsMenu;
    private javax.swing.JMenu stepForwardMenu;
    private javax.swing.JEditorPane textEditor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable obs, Object obj) {

        System.out.println("quiere cambiar");
        if (obs == registers) {

            R0label.setText(registers.getRegisters().get(0));
            R1label.setText(registers.getRegisters().get(1));
            R2label.setText(registers.getRegisters().get(2));
            R3label.setText(registers.getRegisters().get(3));
            R4label.setText(registers.getRegisters().get(4));
            R5label.setText(registers.getRegisters().get(5));
            R6label.setText(registers.getRegisters().get(6));
            R7label.setText(registers.getRegisters().get(7));
            R8label.setText(registers.getRegisters().get(8));
            R9label.setText(registers.getRegisters().get(9));
            R10label.setText(registers.getRegisters().get(10));
            R11label.setText(registers.getRegisters().get(11));
            SPlabel.setText(registers.getRegisters().get(13));
            LRlabel.setText(registers.getRegisters().get(14));
            PClabel.setText(registers.getRegisters().get(15));

        }

    }
}
