
package felipe.continuada1;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class GerenciadorProcessos extends javax.swing.JFrame {

    Integer qtdClicks = 0;
    
    Hardware CPU = new Hardware();
    Hardware RAM = new Hardware();
    Hardware DISCO = new Hardware();
    
    void configurarHardware(Hardware hardware, String tipoHardware, Integer valorMaximo, String tipoOutput, JProgressBar pbBarra) {        
        hardware.nome = tipoHardware;
        hardware.maximoPossivel = valorMaximo;
        hardware.minimo =  hardware.maximoPossivel;
        hardware.mascara = tipoOutput;
        pbBarra.setMaximum(hardware.maximoPossivel);
    }
    
    void atribuirLeitura(Hardware hardware, Integer novoValor, JLabel lbAtual, JProgressBar pbBarra, JLabel lbMinimo, JLabel lbMaximo, JLabel lbMedia) {
        
        hardware.atualizarLeitura(novoValor);
        
        atualizarTela(hardware, lbAtual, pbBarra, lbMinimo, lbMaximo, lbMedia);
    }
    
    void atualizarTela(Hardware hardware, JLabel lbAtual, JProgressBar pbBarra, JLabel lbMinimo, JLabel lbMaximo, JLabel lbMedia) {
        pbBarra.setValue(hardware.atual);
        
        lbAtual.setText(String.format(hardware.mascara, hardware.atual));
        
        lbMinimo.setText(String.format(("Mínimo: " + hardware.mascara), hardware.minimo));
        
        lbMaximo.setText(String.format(("Máximo: " + hardware.mascara), hardware.maximo));
        
        lbMedia.setText(String.format(("Média: " + hardware.mascara), hardware.soma / qtdClicks));
        
    }
    /*
    Integer maxValCPU = 0;
    Integer minValCPU = 100;
    Double avgValCPU = 0.0;
    Double totalCPU = 0.0;
    
    Double maxValRAM = 0.0;
    Double minValRAM = 8.00;
    Double avgValRAM = 0.0;
    Double totalRAM = 0.0;
    
    Double maxValDISCO = 0.0;
    Double minValDISCO = 100.0;
    Double avgValDISCO = 0.0;
    Double totalDISCO = 0.0;
    */
    
    
    public GerenciadorProcessos() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barCPU = new javax.swing.JProgressBar();
        valCPU = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valRAM = new javax.swing.JLabel();
        barRAM = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        valDISCO = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barDISCO = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        maxCPU = new javax.swing.JLabel();
        minCPU = new javax.swing.JLabel();
        avgCPU = new javax.swing.JLabel();
        maxRAM = new javax.swing.JLabel();
        minRAM = new javax.swing.JLabel();
        avgRAM = new javax.swing.JLabel();
        avgDISCO = new javax.swing.JLabel();
        minDISCO = new javax.swing.JLabel();
        maxDISCO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        valCPU.setText("0% USO");

        jLabel2.setText("Processador CPU");

        valRAM.setText("0.00 GB");

        jLabel4.setText("Memória RAM");

        valDISCO.setText("0.0 MB/s");

        jLabel6.setText("Disco HDD");

        jButton1.setText("Ler Dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        maxCPU.setText("Máximo: 0");

        minCPU.setText("Mínimo: 0");

        avgCPU.setText("Média: 0");

        maxRAM.setText("Máximo: 0");

        minRAM.setText("Mínimo: 0");

        avgRAM.setText("Média: 0");

        avgDISCO.setText("Média: 0");

        minDISCO.setText("Mínimo: 0");

        maxDISCO.setText("Máximo: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxCPU)
                            .addComponent(minCPU)
                            .addComponent(avgCPU)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(valCPU)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(barRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(avgRAM)
                            .addComponent(minRAM)
                            .addComponent(maxRAM)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(valRAM)))
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel6))
                    .addComponent(avgDISCO)
                    .addComponent(minDISCO)
                    .addComponent(maxDISCO)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(valDISCO)
                                .addGap(43, 43, 43)))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(valCPU)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(barCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addGap(38, 38, 38)
                            .addComponent(maxCPU)
                            .addGap(18, 18, 18)
                            .addComponent(minCPU)
                            .addGap(18, 18, 18)
                            .addComponent(avgCPU))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(valDISCO)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(barDISCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addGap(38, 38, 38)
                            .addComponent(maxDISCO)
                            .addGap(18, 18, 18)
                            .addComponent(minDISCO)
                            .addGap(18, 18, 18)
                            .addComponent(avgDISCO)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valRAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(barRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(maxRAM)
                        .addGap(18, 18, 18)
                        .addComponent(minRAM)
                        .addGap(18, 18, 18)
                        .addComponent(avgRAM)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //qtdClicks++;
        //Double CPUatual = Math.random() * 101;
        //Double RAMatual = Math.random() * 8000;
        //Double RAMatualGB = RAMatual / 1000;
        //Double DISCOatual = Math.random() * 100;
        /*
        valCPU.setText(String.format("%d%% USO", CPUatual.intValue()));
        valRAM.setText(String.format("%.2f GB", RAMatualGB));
        valDISCO.setText(String.format("%.1f MB/s", DISCOatual));
        
        barCPU.setValue(CPUatual.intValue());
        barRAM.setMaximum(8000);
        barRAM.setValue(RAMatual.intValue());
        barDISCO.setValue(DISCOatual.intValue());
        
        if (CPUatual.intValue() > maxValCPU) {
            maxValCPU = CPUatual.intValue();
            maxCPU.setText(String.format("Máximo: %d %%", maxValCPU));
        }
        if (CPUatual.intValue() < minValCPU) {
            minValCPU = CPUatual.intValue();
            minCPU.setText(String.format("Mínimo: %d %%", minValCPU));
        }
        
        if (RAMatualGB > maxValRAM) {
            maxValRAM = RAMatualGB;
            maxRAM.setText(String.format("Máximo: %.2f GB", maxValRAM));
        }
        if (RAMatualGB < minValRAM) {
            minValRAM = RAMatualGB;
            minRAM.setText(String.format("Mínimo: %.2f GB", minValRAM));
        }
        
        if (DISCOatual > maxValDISCO) {
            maxValDISCO = DISCOatual;
            maxDISCO.setText(String.format("Máximo: %.1f MB/s", maxValDISCO));
        }
        if (DISCOatual < minValDISCO) {
            minValDISCO = DISCOatual;
            minDISCO.setText(String.format("Mínimo: %.1f MB/s", minValDISCO));
        }
        
        totalCPU += CPUatual.intValue();
        totalRAM += RAMatualGB;
        totalDISCO += DISCOatual;
        
        avgValCPU = totalCPU / qtdClicks;
        avgValRAM = totalRAM / qtdClicks;
        avgValDISCO = totalDISCO / qtdClicks;
        
        avgCPU.setText(String.format("Média: %.1f %%", avgValCPU));
        avgRAM.setText(String.format("Média: %.2f GB", avgValRAM));
        avgDISCO.setText(String.format("Média: %.1f MB/s", avgValDISCO));*/
        
        /* ------------------------------NEW---------------------------------- */
        
        
        qtdClicks++;
        
        if (qtdClicks == 1) {
            configurarHardware(CPU, "CPU", 100, "%d%% USO", barCPU);
            
            configurarHardware(RAM, "Memória", 8000, "%d MB", barRAM);
            
            configurarHardware(DISCO, "Disco", 100, "%d%% USO", barDISCO);
        }
        
        // valores aletórios p/ as 3 leituras
        Integer CPUatual = ThreadLocalRandom.current().nextInt(0, CPU.maximoPossivel + 1);
        
        Integer RAMatual = ThreadLocalRandom.current().nextInt(0, RAM.maximoPossivel + 1);
        
        Integer DISCOatual = ThreadLocalRandom.current().nextInt(0, DISCO.maximoPossivel + 1);
        
        
        atribuirLeitura(CPU, CPUatual, valCPU, barCPU, minCPU, maxCPU, avgCPU);
        
        atribuirLeitura(RAM, RAMatual, valRAM, barRAM, minRAM, maxRAM, avgRAM);
        
        atribuirLeitura(DISCO, DISCOatual, valDISCO, barDISCO, minDISCO, maxDISCO, avgDISCO);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciadorProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciadorProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciadorProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciadorProcessos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciadorProcessos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgCPU;
    private javax.swing.JLabel avgDISCO;
    private javax.swing.JLabel avgRAM;
    private javax.swing.JProgressBar barCPU;
    private javax.swing.JProgressBar barDISCO;
    private javax.swing.JProgressBar barRAM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel maxCPU;
    private javax.swing.JLabel maxDISCO;
    private javax.swing.JLabel maxRAM;
    private javax.swing.JLabel minCPU;
    private javax.swing.JLabel minDISCO;
    private javax.swing.JLabel minRAM;
    private javax.swing.JLabel valCPU;
    private javax.swing.JLabel valDISCO;
    private javax.swing.JLabel valRAM;
    // End of variables declaration//GEN-END:variables
}
