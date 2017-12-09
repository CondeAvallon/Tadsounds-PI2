package tadsounds.Telas;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tadsounds.Models.Instrumento;
import tadsounds.Exceptions.InstrumentoException;
import tadsounds.Servicos.ServicoInstrumento;
import tadsounds.Servicos.ServicoVenda;

//classe onde o usuario consulta instrumentos e escolhe entre alterar ou exclui-lo
public class ConsultarInstrumento extends javax.swing.JInternalFrame {

    EditarInstrumento editarProduto = new EditarInstrumento();
    String ultimaPesquisa = null;
    
    

    public ConsultarInstrumento() {
        initComponents();
        jTabelaResultados.getColumnModel().getColumn(0).setMinWidth(0);
        jTabelaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
        jTabelaResultados.getColumnModel().getColumn(0).setWidth(0);
    }
    
    //atualiza a lista de instrumentos exibidos na tabela
    public boolean atualizarLista() throws InstrumentoException, Exception {
        //solicita ao ServicoInstrumento o retorno do instrumento
        List<Instrumento> resultado = ServicoInstrumento.
                procurarInstrumento(ultimaPesquisa);

        DefaultTableModel model = (DefaultTableModel) jTabelaResultados.getModel();
        model.setRowCount(0);

        if (resultado == null || resultado.size() <= 0) {
            return false;
        }
        
        //insere os dados do instrumento na tabela
        for (int i = 0; i < resultado.size(); i++) {
            Instrumento instrumento = resultado.get(i);
            String preco = ServicoVenda.converterValor(instrumento.getPreco());
            if (instrumento != null) {
                Object[] row = new Object[5];
                row[0] = instrumento.getId();
                row[1] = instrumento.getNome();
                row[2] = instrumento.getMarca();
                row[3] = instrumento.getEstoque();
                row[4] = preco;
                model.addRow(row);
            }
        }

        return true;
    }

//    //exibe a tela de edicao dos dados do instrumento
//    private void tabelaResultadosMouseClicked(java.awt.event.MouseEvent evt) {
//        if (evt.getClickCount() == 2) {
//            try {
//                final int row = jTabelaResultados.getSelectedRow();
//                Integer id = (Integer) jTabelaResultados.getValueAt(row, 0);
//
//                Instrumento instrumento = ServicoInstrumento.obterInstrumento(id);
//
//                editarProduto = new EditarInstrumento();
//                editarProduto.setInstrumento(instrumento);
//                editarProduto.setTitle("Instrumento: " + instrumento.getNome());
//                this.getParent().add(editarProduto);
//                this.openFrameInCenter(editarProduto);
//                editarProduto.toFront();
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(rootPane, "Não é possível "
//                        + "exibir os detalhes deste instrumento.",
//                        "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }

    //exibe a tela no centro do sistema
    public void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaResultados = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Instrumento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Instrumento"));

        jLabel1.setText("Nome:");

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConsultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar))
                .addGap(53, 53, 53))
        );

        jTabelaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaResultados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTabelaResultados);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAlterar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAlterar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botao que permite ao usuario excluir (desativar) o instrumento selecionado atraves do ServicoInstrumento
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTabelaResultados.getSelectedRow() >= 0) {

            final int row = jTabelaResultados.getSelectedRow();
            String nome = (String) jTabelaResultados.getValueAt(row, 1);
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Excluir o instrumento \"" + nome + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    Integer id = (Integer) jTabelaResultados.getValueAt(row, 0);
                    //solicita ao ServicoInstrumento a exclusao (desativar) do instrumento
                    ServicoInstrumento.excluirQuarto(id);
                    this.atualizarLista();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    //botao que abre a tela de edicao dos dados do instrumento selecionado atraves do ServicoInstrumento
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try {
            final int row = jTabelaResultados.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) jTabelaResultados.getValueAt(row, 0);

                //solicitao ao ServicoInstrumento o retorno do instrumento
                Instrumento instrumento = ServicoInstrumento.obterInstrumento(id);

                editarProduto.dispose();
                editarProduto = new EditarInstrumento();
                editarProduto.setInstrumento(instrumento);
                editarProduto.setTitle("Instrumento " + instrumento.getNome());
                this.getParent().add(editarProduto);
                this.openFrameInCenter(editarProduto);
                editarProduto.toFront();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível "
                    + "exibir os detalhes deste instrumento.",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    //botao que consulta o instrumento pelo nome
    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        boolean resultSearch = false;

        if (tfPesquisa.getText() != null
                && !tfPesquisa.getText().equals("")) {
            try {
                ultimaPesquisa = tfPesquisa.getText();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Só é possível"
                        + " pesquisar por um valor inteiro válido",
                        "Campo de pesquisa inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            ultimaPesquisa = null;
        }

        try {
            resultSearch = atualizarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!resultSearch) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou "
                    + "resultados ", "Sem resultados",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaResultados;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
