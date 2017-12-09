package tadsounds.TelaPrincipal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import tadsounds.Telas.CadastrarCliente;
import tadsounds.Telas.CadastrarInstrumento;
import tadsounds.Telas.ConsultarCliente;
import tadsounds.Telas.ConsultarInstrumento;
import tadsounds.Telas.Relatorio;
import tadsounds.Telas.Vendas;

public class TelaPrincipal extends javax.swing.JFrame {

    CadastrarCliente cadastrarCliente = null;
    ConsultarCliente consultarCliente = null;
    CadastrarInstrumento cadastrarProduto = null;
    ConsultarInstrumento consultarProduto = null;
    Relatorio relatorio = null;
    Vendas venda = null;

    public TelaPrincipal() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/IconeTadsounds.png")));
    }

    public CadastrarCliente getCadastrarCliente() {
        return cadastrarCliente;
    }

    public void setCadastrarCliente(CadastrarCliente cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }

    public ConsultarCliente getConsultarCliente() {
        return consultarCliente;
    }

    public void setConsultarCliente(ConsultarCliente consultarCliente) {
        this.consultarCliente = consultarCliente;
    }
    
    public ConsultarInstrumento getConsultarProduto() {
        return consultarProduto;
    }
    
    public void setConsultarProduto (ConsultarInstrumento consultarProduto) {
        this.consultarProduto = consultarProduto;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane() {
            private Image image;
            {
                try {
                    image = ImageIO.read(new File("src/Imagens/Fundo4.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        btCadastrarCliente = new javax.swing.JMenuItem();
        btConsultarCliente = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenu();
        btCadastrarProduto = new javax.swing.JMenuItem();
        btConsultarProduto = new javax.swing.JMenuItem();
        MenuVenda = new javax.swing.JMenu();
        btVenda = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        btRelatorio = new javax.swing.JMenuItem();
        btSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TadSounds");

        desktop.setToolTipText("");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));

        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cliente.png"))); // NOI18N
        menuCliente.setText("Clientes");

        btCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AdicionarCliente.png"))); // NOI18N
        btCadastrarCliente.setText("Cadastrar Cliente");
        btCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(btCadastrarCliente);

        btConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ConsultarCliente.png"))); // NOI18N
        btConsultarCliente.setText("Consultar Cliente");
        btConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(btConsultarCliente);

        jMenuBar1.add(menuCliente);

        menuProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Produto.png"))); // NOI18N
        menuProduto.setText("Instrumento");

        btCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AdicionarProduto.png"))); // NOI18N
        btCadastrarProduto.setText("Cadastrar Instrumento");
        btCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarProdutoActionPerformed(evt);
            }
        });
        menuProduto.add(btCadastrarProduto);

        btConsultarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ConsultarProduto.png"))); // NOI18N
        btConsultarProduto.setText("Consultar Instrumento");
        btConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarProdutoActionPerformed(evt);
            }
        });
        menuProduto.add(btConsultarProduto);

        jMenuBar1.add(menuProduto);

        MenuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Venda.png"))); // NOI18N
        MenuVenda.setText("Venda");

        btVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/RealizarVenda.png"))); // NOI18N
        btVenda.setText("Realizar Venda");
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });
        MenuVenda.add(btVenda);

        jMenuBar1.add(MenuVenda);

        menuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Relatorio.png"))); // NOI18N
        menuRelatorio.setText("Relatório");

        btRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/GerarRelatorio.png"))); // NOI18N
        btRelatorio.setText("Gerar Relatório");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(btRelatorio);

        jMenuBar1.add(menuRelatorio);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btSairMenuSelected(evt);
            }
        });
        jMenuBar1.add(btSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        if (venda == null || !venda.isDisplayable()) {
            venda = new Vendas();
            desktop.add(venda);
            this.openFrameInCenter(venda);
        }
        venda.toFront();
    }//GEN-LAST:event_btVendaActionPerformed

    private void btCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarProdutoActionPerformed
        if (cadastrarProduto == null || !cadastrarProduto.isDisplayable()) {
            cadastrarProduto = new CadastrarInstrumento();
            desktop.add(cadastrarProduto);
            this.openFrameInCenter(cadastrarProduto);
        }
        cadastrarProduto.toFront();
    }//GEN-LAST:event_btCadastrarProdutoActionPerformed

    private void btSairMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btSairMenuSelected
        System.exit(0);
    }//GEN-LAST:event_btSairMenuSelected

    private void btCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarClienteActionPerformed
        if (cadastrarCliente == null || !cadastrarCliente.isDisplayable()) {
            cadastrarCliente = new CadastrarCliente();
            desktop.add(cadastrarCliente);
            this.openFrameInCenter(cadastrarCliente);
        }
        cadastrarCliente.toFront();
    }//GEN-LAST:event_btCadastrarClienteActionPerformed

    private void btConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarClienteActionPerformed
        if (consultarCliente == null || !consultarCliente.isDisplayable()) {
            consultarCliente = new ConsultarCliente();
            desktop.add(consultarCliente);
            this.openFrameInCenter(consultarCliente);
        }
        consultarCliente.toFront();
    }//GEN-LAST:event_btConsultarClienteActionPerformed

    private void btConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarProdutoActionPerformed
        if (consultarProduto == null || !consultarProduto.isDisplayable()) {
            consultarProduto = new ConsultarInstrumento();
            desktop.add(consultarProduto);
            this.openFrameInCenter(consultarProduto);
        }
        consultarProduto.toFront();
    }//GEN-LAST:event_btConsultarProdutoActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        if (relatorio == null || !relatorio.isDisplayable()) {
            relatorio = new Relatorio();
            desktop.add(relatorio);
            this.openFrameInCenter(relatorio);
        }
        relatorio.toFront();        relatorio.toFront();    }//GEN-LAST:event_btRelatorioActionPerformed

    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuVenda;
    private javax.swing.JMenuItem btCadastrarCliente;
    private javax.swing.JMenuItem btCadastrarProduto;
    private javax.swing.JMenuItem btConsultarCliente;
    private javax.swing.JMenuItem btConsultarProduto;
    private javax.swing.JMenuItem btRelatorio;
    private javax.swing.JMenu btSair;
    private javax.swing.JMenuItem btVenda;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenu menuRelatorio;
    // End of variables declaration//GEN-END:variables
}
