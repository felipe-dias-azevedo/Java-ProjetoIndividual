
package felipe.continuada;

import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public final class TelaPrograma extends javax.swing.JFrame {

    Integer idAtualProduto;
    List<ProdutoBanco> produtos;

    public void mostrarProduto(ProdutoBanco produto) {
        String nomeCategoria = DadosProduto.definirCategoria(produto.getCategoria());
        Double valorDesconto = DadosProduto.definirValorDesconto(produto.getCategoria(), produto.getPreco());
        Integer percentualDesconto = DadosProduto.definirDesconto(produto.getCategoria());
        atualizarTela(produto.getId(), produto.getNome(), valorDesconto, percentualDesconto, nomeCategoria, produto.getPreco());
    }
    
    public void atualizarTela(Integer idProduto, String nomeProduto, Double valorProduto, Integer DescontoProduto, String categoriaProduto, Double valorProdutoSemDesconto) {
        lbProduto.setText(String.format("Produto: %d", idProduto));
        lbNome.setText(String.format("Nome: %s", nomeProduto));
        lbPreco.setText(String.format("Preço s/ desconto: R$ %.0f  Preço atual: R$ %.0f", valorProdutoSemDesconto, valorProduto));
        lbDesconto.setText(String.format("Desconto: %d %%", DescontoProduto));
        lbCategoria.setText(String.format("Categoria: %s", categoriaProduto));
    }
    
    public void MostrarPrimeiroRegistro() {
        produtos = Connection.selectProdutos();
        ProdutoBanco primeiroRegistro = produtos.get(idAtualProduto);
        mostrarProduto(primeiroRegistro);
    }
    
    public TelaPrograma() {
        this.idAtualProduto = 0;
        
        initComponents();
        MostrarPrimeiroRegistro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        voltarBtn = new javax.swing.JButton();
        avancarBtn = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        lbProduto = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbDesconto = new javax.swing.JLabel();
        lbPreco = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn1.setText("Comprar");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        voltarBtn.setText("  <  ");
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        avancarBtn.setText("  >  ");
        avancarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avancarBtnActionPerformed(evt);
            }
        });

        btn2.setText("Cadastrar novo Produto");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        lbProduto.setText("Produto: X");

        lbNome.setText("Nome: X");

        lbDesconto.setText("Desconto: X %");

        lbPreco.setText("Preço: R$ X");

        lbCategoria.setText("Categoria: X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avancarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(btn2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(lbDesconto)
                            .addComponent(lbPreco)
                            .addComponent(lbCategoria))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2)
                    .addComponent(lbProduto))
                .addGap(18, 18, 18)
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDesconto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(voltarBtn)
                    .addComponent(avancarBtn))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // DELETAR PRODUTO

        ProdutoBanco produto = produtos.get(idAtualProduto);
        
        Connection.deleteProduto(produto);
        
        produtos = Connection.selectProdutos();
        
        if (idAtualProduto + 1 < produtos.size()) {
            idAtualProduto += 1;
            produto = produtos.get(idAtualProduto);
            mostrarProduto(produto);
        } else {
            idAtualProduto -= 1;
            produto = produtos.get(idAtualProduto);
            mostrarProduto(produto);
        }
        
        JOptionPane.showMessageDialog(null, "Produto Comprado com Sucesso!", null, WIDTH);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // ABRIR TELA CADASTRAR PRODUTO
        
        TelaCadastrarProduto tela = new TelaCadastrarProduto();
        tela.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btn2ActionPerformed

    private void avancarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avancarBtnActionPerformed
        // BOTAO AVANCAR
        
        if (idAtualProduto + 1 < produtos.size()) {
            idAtualProduto += 1;
            ProdutoBanco produto = produtos.get(idAtualProduto);
            mostrarProduto(produto);
        }
        
    }//GEN-LAST:event_avancarBtnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        // BOTAO VOLTAR
        
        if (idAtualProduto - 1 >= 0) {
            idAtualProduto -= 1;
            ProdutoBanco produto = produtos.get(idAtualProduto);
            mostrarProduto(produto);
        }
        
    }//GEN-LAST:event_voltarBtnActionPerformed


    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(TelaPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrograma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avancarBtn;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDesconto;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbProduto;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
