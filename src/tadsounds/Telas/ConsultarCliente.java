package tadsounds.Telas;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tadsounds.Models.Cliente;
import tadsounds.Exceptions.ClienteException;
import tadsounds.Servicos.ServicoCliente;

//classe onde o usuario consulta clientes e escolhe entre alterar ou exclui-lo
public class ConsultarCliente extends javax.swing.JInternalFrame {

    EditarCliente editarCliente = new EditarCliente();
    String ultimaPesquisa = null;

    public ConsultarCliente() {
        initComponents();
        tabelaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaClientes.getColumnModel().getColumn(0).setWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldPesquisa = new javax.swing.JTextField();
        botaoConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabel1.setText("Nome:");

        fieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPesquisaActionPerformed(evt);
            }
        });

        botaoConsultar.setText("Consultar");
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAlterar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPesquisaActionPerformed
    }//GEN-LAST:event_fieldPesquisaActionPerformed

    //botao que consulta o cliente pelo nome
    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        boolean resultadoPesquisa = false;
        ultimaPesquisa = fieldPesquisa.getText();
        try {
            resultadoPesquisa = atualizaLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ", "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoConsultarActionPerformed

    //botao que abre a tela de edicao dos dados do cliente selecionado atraves do ServicoCliente
    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        try {
            final int row = tabelaClientes.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) tabelaClientes.getValueAt(row, 0);
                //solicitao ao ServicoCliente o retorno do cliente
                Cliente cliente = ServicoCliente.obterCliente(id);
                editarCliente.dispose();
                editarCliente = new EditarCliente();
                editarCliente.setCliente(cliente);
                editarCliente.setTitle(cliente.getNome());
                this.getParent().add(editarCliente);
                this.openFrameInCenter(editarCliente);
                editarCliente.toFront();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível exibir os dados deste cliente",
                    "Erro ao abrir os detalhes", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    //botao que permite ao usuario excluir (desativar) o cliente selecionado atraves do ServicoCliente
    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        if (tabelaClientes.getSelectedRow() >= 0) {
            final int row = tabelaClientes.getSelectedRow();
            String nome = (String) tabelaClientes.getValueAt(row, 1);
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Excluir o cliente \"" + nome + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    Integer id = (Integer) tabelaClientes.getValueAt(row, 0);
                    //solicita ao ServicoCliente a exclusao (desativar) do cliente
                    ServicoCliente.excluirCliente(id);
                    this.atualizaLista();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    //exibe a tela de edicao dos dados do cliente
    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                final int row = tabelaClientes.getSelectedRow();
                Integer id = (Integer) tabelaClientes.getValueAt(row, 0);
                //solicitao ao ServicoCliente o retorno do cliente
                Cliente cliente = ServicoCliente.obterCliente(id);
                editarCliente.dispose();
                editarCliente = new EditarCliente();
                editarCliente.setCliente(cliente);
                editarCliente.setTitle(cliente.getNome());
                this.getParent().add(editarCliente);
                editarCliente.toFront();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Não é possível exibir os dados deste cliente",
                        "Erro ao abrir os detalhes", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    //atualiza a lista de clientes exibidos na tabela
    public boolean atualizaLista() throws ClienteException, Exception {
        //solicita ao ServicoCliente o retorno do cliente
        List<Cliente> resultado = ServicoCliente.procurarCliente(ultimaPesquisa);
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0);
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }
        //insere os dados do cliente na tabela
        for (int i = 0; i < resultado.size(); i++) {
            Cliente cliente = resultado.get(i);
            if (cliente != null) {
                Object[] row = new Object[4];
                row[0] = cliente.getId();
                row[1] = cliente.getNome();
                row[2] = cliente.getCpf();
                row[3] = cliente.getTelefone();
                modelo.addRow(row);
            }
        }
        return true;
    }

    //exibe a tela no centro do sistema
    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
