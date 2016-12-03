/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import components.DataMemory;
import components.InstructionMemory;
import components.RegisterBank;
import compiler.Compiler;
import stages.MainStages;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author jose
 */
public class IDE extends javax.swing.JFrame implements Observer {

    /**
     * Variables from the simulator
     */
    private final RegisterBank registers;
    private final DataMemory dataMem;
    private final InstructionMemory instrMem;
    private final MainStages main;

    /**
     * Creates new form IDE
     */
    public IDE() {

        registers = RegisterBank.getInstance();
        dataMem = DataMemory.getInstance();
        instrMem = InstructionMemory.getInstance();
        main = new MainStages();

        registers.addObserver(this);
        dataMem.addObserver(this);
        setTitle("Coloso IDE");
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

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textEditor = new javax.swing.JEditorPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
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
        R12label = new javax.swing.JLabel();
        SPlabel = new javax.swing.JLabel();
        LRlabel = new javax.swing.JLabel();
        PClabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Mem00 = new javax.swing.JLabel();
        Mem04 = new javax.swing.JLabel();
        Mem08 = new javax.swing.JLabel();
        Mem0C = new javax.swing.JLabel();
        Mem10 = new javax.swing.JLabel();
        Mem14 = new javax.swing.JLabel();
        Mem18 = new javax.swing.JLabel();
        Mem1C = new javax.swing.JLabel();
        Mem20 = new javax.swing.JLabel();
        Mem24 = new javax.swing.JLabel();
        Mem28 = new javax.swing.JLabel();
        Mem2C = new javax.swing.JLabel();
        Mem30 = new javax.swing.JLabel();
        Mem34 = new javax.swing.JLabel();
        Mem38 = new javax.swing.JLabel();
        Mem3C = new javax.swing.JLabel();
        Mem40 = new javax.swing.JLabel();
        Mem44 = new javax.swing.JLabel();
        Mem48 = new javax.swing.JLabel();
        Mem4C = new javax.swing.JLabel();
        Mem50 = new javax.swing.JLabel();
        Mem54 = new javax.swing.JLabel();
        Mem58 = new javax.swing.JLabel();
        Mem5C = new javax.swing.JLabel();
        Mem60 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(965, 670));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("Abrir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("Guardar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("Ejecutar");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setText("Reset");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jScrollPane1.setViewportView(textEditor);

        R0label.setText("C0");

        R1label.setText("C1");

        R2label.setText("C2");

        R3label.setText("C3");

        R4label.setText("C4");

        R5label.setText("C5");

        R6label.setText("C6");

        R7label.setText("C7");

        R8label.setText("C8");

        R9label.setText("C9");

        R10label.setText("C10");

        R11label.setText("C11");

        R12label.setText("C12");

        SPlabel.setText("SP");

        LRlabel.setText("LR");

        PClabel.setText("PC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R2label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R0label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R1label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R3label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R4label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R5label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R6label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R7label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R8label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R9label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R10label, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(R11label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(R12label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SPlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LRlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PClabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(R0label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R1label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R2label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R3label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R4label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R5label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R6label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R7label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R8label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R9label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R10label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R11label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(R12label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SPlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LRlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PClabel)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registros", jPanel1);

        Mem00.setText("0x00000000");

        Mem04.setText("0x00000004");

        Mem08.setText("0x00000008");

        Mem0C.setText("0x0000000C");

        Mem10.setText("0x00000010");

        Mem14.setText("0x00000014");

        Mem18.setText("0x00000018");

        Mem1C.setText("0x0000001C");

        Mem20.setText("0x00000020");

        Mem24.setText("0x00000024");

        Mem28.setText("0x00000028");

        Mem2C.setText("0x0000002C");

        Mem30.setText("0x00000030");

        Mem34.setText("0x00000034");

        Mem38.setText("0x00000038");

        Mem3C.setText("0x0000003C");

        Mem40.setText("0x00000040");

        Mem44.setText("0x00000044");

        Mem48.setText("0x00000048");

        Mem4C.setText("0x0000004C");

        Mem50.setText("0x00000050");

        Mem54.setText("0x00000054");

        Mem58.setText("0x00000058");

        Mem5C.setText("0x0000005C");

        Mem60.setText("0x00000060");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mem00, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem0C, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(Mem10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem1C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem2C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem3C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem4C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem5C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mem60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mem00)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem08)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem0C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem1C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem2C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem3C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem4C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem5C)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mem60)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Memoria", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Calendarización", jPanel3);

        jLabel1.setText("CPI: ");

        jLabel2.setText("IPS: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String text = textEditor.getText();

        if (!text.equals("")) {
            saveFile(text);
            textEditor.setText(null);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String text = textEditor.getText();

        if (!text.equals("")) {
            saveFile(text);
            textEditor.setText(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String code = textEditor.getText();
        resetFunction(false);

        if (code.equals("")) {
            return;
        }

        Compiler compiler = new Compiler(code);

        ArrayList<String> instructions = compiler.compile();

        int cantidadInstruciones = 0;
        for (String instruction : instructions) {
            cantidadInstruciones++;
            System.out.println("SALIDA COMPILADOR " + instruction);
            instrMem.addInstruction(instruction);
        }
        System.out.println("puntero " + instrMem.getPointer());

        main.start(cantidadInstruciones);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        resetFunction(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IDE().setVisible(true);
        });
    }

    @Override
    public void update(Observable obs, Object obj) {
        if (obs == registers) {

            R0label.setText("C0:    " + registers.getRegisters().get(0));
            R1label.setText("C1:    " + registers.getRegisters().get(1));
            R2label.setText("C2:    " + registers.getRegisters().get(2));
            R3label.setText("C3:    " + registers.getRegisters().get(3));
            R4label.setText("C4:    " + registers.getRegisters().get(4));
            R5label.setText("C5:    " + registers.getRegisters().get(5));
            R6label.setText("C6:    " + registers.getRegisters().get(6));
            R7label.setText("C7:    " + registers.getRegisters().get(7));
            R8label.setText("C8:    " + registers.getRegisters().get(8));
            R9label.setText("C9:    " + registers.getRegisters().get(9));
            R10label.setText("C10:  " + registers.getRegisters().get(10));
            R11label.setText("C11:  " + registers.getRegisters().get(11));
            R12label.setText("C12:  " + registers.getRegisters().get(12));
            SPlabel.setText("SP:    " + registers.getRegisters().get(13));
            LRlabel.setText("LR:    " + registers.getRegisters().get(14));
            PClabel.setText("PC:    " + registers.getRegisters().get(15));
            
            Mem00.setText("0x00000000: "+dataMem.getDataMemory().get(0));
            Mem04.setText("0x00000004: "+dataMem.getDataMemory().get(4));
            Mem08.setText("0x00000008: "+dataMem.getDataMemory().get(8));
            Mem0C.setText("0x0000000C: "+dataMem.getDataMemory().get(12));
            Mem10.setText("0x00000010: "+dataMem.getDataMemory().get(16));
            Mem14.setText("0x00000014: "+dataMem.getDataMemory().get(20));
            Mem18.setText("0x00000018: "+dataMem.getDataMemory().get(24));
            Mem1C.setText("0x0000001C: "+dataMem.getDataMemory().get(28));
            Mem20.setText("0x00000020: "+dataMem.getDataMemory().get(32));
            Mem24.setText("0x00000024: "+dataMem.getDataMemory().get(36));
            Mem28.setText("0x00000028: "+dataMem.getDataMemory().get(40));
            Mem2C.setText("0x0000002C: "+dataMem.getDataMemory().get(44));
            Mem30.setText("0x00000030: "+dataMem.getDataMemory().get(48));
            Mem34.setText("0x00000034: "+dataMem.getDataMemory().get(52));
            Mem38.setText("0x00000038: "+dataMem.getDataMemory().get(56));
            Mem3C.setText("0x0000003C: "+dataMem.getDataMemory().get(60));
            Mem40.setText("0x00000040: "+dataMem.getDataMemory().get(64));
            Mem44.setText("0x00000044: "+dataMem.getDataMemory().get(68));
            Mem48.setText("0x00000048: "+dataMem.getDataMemory().get(72));
            Mem4C.setText("0x0000004C: "+dataMem.getDataMemory().get(76));
            Mem50.setText("0x00000050: "+dataMem.getDataMemory().get(80));
            Mem54.setText("0x00000054: "+dataMem.getDataMemory().get(84));
            Mem58.setText("0x00000058: "+dataMem.getDataMemory().get(88));
            Mem5C.setText("0x0000005C: "+dataMem.getDataMemory().get(92));
            Mem60.setText("0x00000060: "+dataMem.getDataMemory().get(96));
            

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LRlabel;
    private javax.swing.JLabel Mem00;
    private javax.swing.JLabel Mem04;
    private javax.swing.JLabel Mem08;
    private javax.swing.JLabel Mem0C;
    private javax.swing.JLabel Mem10;
    private javax.swing.JLabel Mem14;
    private javax.swing.JLabel Mem18;
    private javax.swing.JLabel Mem1C;
    private javax.swing.JLabel Mem20;
    private javax.swing.JLabel Mem24;
    private javax.swing.JLabel Mem28;
    private javax.swing.JLabel Mem2C;
    private javax.swing.JLabel Mem30;
    private javax.swing.JLabel Mem34;
    private javax.swing.JLabel Mem38;
    private javax.swing.JLabel Mem3C;
    private javax.swing.JLabel Mem40;
    private javax.swing.JLabel Mem44;
    private javax.swing.JLabel Mem48;
    private javax.swing.JLabel Mem4C;
    private javax.swing.JLabel Mem50;
    private javax.swing.JLabel Mem54;
    private javax.swing.JLabel Mem58;
    private javax.swing.JLabel Mem5C;
    private javax.swing.JLabel Mem60;
    private javax.swing.JLabel PClabel;
    private javax.swing.JLabel R0label;
    private javax.swing.JLabel R10label;
    private javax.swing.JLabel R11label;
    private javax.swing.JLabel R12label;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JEditorPane textEditor;
    // End of variables declaration//GEN-END:variables

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

    private void resetFunction(boolean wipe) {

        int length = registers.getRegisters().size();

        registers.writeAddress("0000", "00000000000000000000000000000000");
        registers.writeAddress("0001", "00000000000000000000000000000000");
        registers.writeAddress("0010", "00000000000000000000000000000000");
        registers.writeAddress("0011", "00000000000000000000000000000000");
        registers.writeAddress("0100", "00000000000000000000000000000000");
        registers.writeAddress("0101", "00000000000000000000000000000000");
        registers.writeAddress("0110", "00000000000000000000000000000000");
        registers.writeAddress("0111", "00000000000000000000000000000000");
        registers.writeAddress("1000", "00000000000000000000000000000000");
        registers.writeAddress("1001", "00000000000000000000000000000000");
        registers.writeAddress("1010", "00000000000000000000000000000000");
        registers.writeAddress("1011", "00000000000000000000000000000000");
        registers.writeAddress("1100", "00000000000000000000000000000000");
        registers.writeAddress("1101", "00000000000000000000000000000000");
        registers.writeAddress("1110", "00000000000000000000000000000000");
        registers.writeAddress("1111", "00000000000000000000000000000000");

        int lengthMem = dataMem.getDataMemory().size();

        for (int i = 0; i < lengthMem; i++) {

            dataMem.getDataMemory().set(i, "0");
        }

        int lengthInst = dataMem.getDataMemory().size();

        for (int i = 0; i < lengthInst; i++) {

            instrMem.getInstructions().set(i, "0");
        }
        if (wipe) {
            textEditor.setText("");
        }
        instrMem.setPointer(0);

        R0label.setText("C0:    " + registers.getRegisters().get(0));
        R1label.setText("C1:    " + registers.getRegisters().get(1));
        R2label.setText("C2:    " + registers.getRegisters().get(2));
        R3label.setText("C3:    " + registers.getRegisters().get(3));
        R4label.setText("C4:    " + registers.getRegisters().get(4));
        R5label.setText("C5:    " + registers.getRegisters().get(5));
        R6label.setText("C6:    " + registers.getRegisters().get(6));
        R7label.setText("C7:    " + registers.getRegisters().get(7));
        R8label.setText("C8:    " + registers.getRegisters().get(8));
        R9label.setText("C9:    " + registers.getRegisters().get(9));
        R10label.setText("C10:  " + registers.getRegisters().get(10));
        R11label.setText("C11:  " + registers.getRegisters().get(11));
        R12label.setText("C12:  " + registers.getRegisters().get(12));
        SPlabel.setText("SP:    " + registers.getRegisters().get(13));
        LRlabel.setText("LR:    " + registers.getRegisters().get(14));
        PClabel.setText("PC:    " + registers.getRegisters().get(15));
    }
}
