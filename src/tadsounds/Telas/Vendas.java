package tadsounds.Telas;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tadsounds.Models.Cliente;
import tadsounds.Models.Instrumento;
import tadsounds.Models.ItemCarrinho;
import tadsounds.Exceptions.ClienteException;
import tadsounds.Exceptions.InstrumentoException;
import tadsounds.Models.Venda;
import tadsounds.Servicos.ServicoCliente;
import tadsounds.Servicos.ServicoInstrumento;
import tadsounds.Servicos.ServicoVenda;
import static tadsounds.Servicos.ServicoVenda.converterMoeda;

//classe que permite ao usuario realizar vendas utilizando um cliente e instrumentos
public class Vendas extends javax.swing.JInternalFrame {

    EditarCliente editarCliente = new EditarCliente();
    String ultimoCliente = null;
    String ultimoInstrumento = null;

    public Vendas() {
        initComponents();
        tabelaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaClientes.getColumnModel().getColumn(0).setWidth(0);
        tabelaInstrumentos.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaInstrumentos.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaInstrumentos.getColumnModel().getColumn(0).setWidth(0);
        tabelaCarrinho.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaCarrinho.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaCarrinho.getColumnModel().getColumn(0).setWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        botaoPesquisarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        botaoSelecionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fieldInstrumento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaInstrumentos = new javax.swing.JTable();
        botaoPesquisarInstrumento = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        botaoFinalizar = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botaoExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        botaoAlterarQtde = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboPagamento = new javax.swing.JComboBox<>();
        fieldRecebido = new javax.swing.JTextField();
        labelTroco = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botaoCalculaTroco = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Vendas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabel1.setText("Nome:");

        botaoPesquisarCliente.setText("Pesquisar");
        botaoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarClienteActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaClientes);

        botaoSelecionar.setText("Selecionar");
        botaoSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botaoPesquisarCliente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoSelecionar)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSelecionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrumento"));

        jLabel4.setText("Instrumento");

        tabelaInstrumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Instrumento", "Estoque", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaInstrumentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaInstrumentos);

        botaoPesquisarInstrumento.setText("Pesquisar");
        botaoPesquisarInstrumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarInstrumentoActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fieldInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoPesquisarInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botaoAdicionar)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoPesquisarInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoFinalizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botaoFinalizar.setText("FINALIZAR");
        botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTotal.setText("R$ 00,00");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        labelCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Instrumento", "Quantidade", "Preço", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCarrinho.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabelaCarrinho);

        botaoAlterarQtde.setText("Alterar Quantidade");
        botaoAlterarQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarQtdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoAlterarQtde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoAlterarQtde))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Forma de Pagamento");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Valor Recebido");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Troco");

        comboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "Dinheiro", "Débito", "Crédito" }));

        labelTroco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTroco.setText("R$ 00,00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(fieldRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(labelTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTroco)
                            .addComponent(fieldRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Total");

        botaoCalculaTroco.setText("Calcular Troco");
        botaoCalculaTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalculaTrocoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(botaoCalculaTroco))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(botaoFinalizar))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCalculaTroco))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //botao que realiza a pesquisa de clientes pelo nome
    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        boolean resultadoPesquisa = false;
        ultimoCliente = fieldNome.getText();
        try {
            resultadoPesquisa = atualizarCliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ", "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed

    //botao que seleciona o cliente escolhido pelo usuario
    private void botaoSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarActionPerformed
        try {
            Cliente clienteVenda = null;
            final int row = tabelaClientes.getSelectedRow();
            if (row >= 0) {
                Integer id = (Integer) tabelaClientes.getValueAt(row, 0);
                //solicita ao ServicoCliente o retorno do cliente selecionado
                clienteVenda = ServicoCliente.obterCliente(id);
                labelCliente.setText(clienteVenda.getNome());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível adicionar o cliente",
                    "Erro ao adicionar o cliente", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botaoSelecionarActionPerformed

    //botao que realiza a pesquisa do instrumento pelo nome
    private void botaoPesquisarInstrumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarInstrumentoActionPerformed
        boolean resultadoPesquisa = false;
        ultimoInstrumento = fieldInstrumento.getText();
        try {
            resultadoPesquisa = atualizarInstrumento();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados ", "Sem resultados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoPesquisarInstrumentoActionPerformed

    //botao que adiciona o instrumento selecionado no carrinho
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        try {
            Cliente clienteVenda = null;
            //solicita ao ServicoVenda a confirmacao de que ha um cliente selecinado
            boolean clienteSelec = ServicoVenda.verificarClienteSelec(clienteVenda, tabelaClientes);
            //se nao houver cliente selecionado, o usuario nao podera adicionar instrumentos no carrinho
            if (!clienteSelec) {
                JOptionPane.showMessageDialog(rootPane, "Cliente não selecionado! ",
                        "Cliente",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int row = tabelaInstrumentos.getSelectedRow();
            DefaultTableModel tabelaInstrModel = ((DefaultTableModel) tabelaInstrumentos.getModel());
            DefaultTableModel tabelaCarrinhoModel = (DefaultTableModel) tabelaCarrinho.getModel();

            //solicita ao ServicoVenda a confirmacao de que o instrumento a ser adicionado ja nao esta no carrinho
            boolean verificacao = ServicoVenda.verificarInstrSelec(rootPane, tabelaInstrModel,
                    tabelaCarrinhoModel, row);
            //se o instrumento selecionado ja estiver no carrinho, aparecera uma msg de erro e nao sera possivel adiciona-lo
            if (verificacao == false && tabelaCarrinho.getValueAt(0, 0) != null) {
                JOptionPane.showMessageDialog(rootPane, "O instrumento já "
                        + "está no carrinho ", "Instrumento indisponível",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            //pergunta ao usuario quantas unidades do instrumento deseja adicionar ao carrinho
            if (row >= 0) {
                Integer qtdeInstrumento = null;
                String respQtdeInstrumentos = JOptionPane.showInputDialog(this, "Quantas unidades?");
                if (respQtdeInstrumentos == null) {
                    return;
                }
                Instrumento instrumento;
                try {
                    qtdeInstrumento = Integer.parseInt(respQtdeInstrumentos);

                    int rowInstrAdc = tabelaInstrumentos.getSelectedRow();
                    int qtdeEmEstoque = 0;
                    int idQtdeAlterar = (Integer) tabelaInstrumentos.getValueAt(rowInstrAdc, 0);
                    //solicita ao ServicoInstrumento o retorno do instrumento selecionado
                    instrumento = ServicoInstrumento.obterInstrumento(idQtdeAlterar);
                    qtdeEmEstoque = instrumento.getEstoque();

                    //se a quantidade inserida pelo usuario for menor ou igual a 0, aparecera uma msg de erro
                    if (qtdeInstrumento <= 0) {
                        JOptionPane.showMessageDialog(rootPane, "Quantidade de "
                                + "instrumentos inválida", "Quantidade inválida",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    //se a quantidade for maior que a quantidade em estoque, aparecera uma msg de erro    
                    } else if (qtdeInstrumento > qtdeEmEstoque) {
                        JOptionPane.showMessageDialog(rootPane, "Quantidade solicitada "
                                + "maior do que em estoque!", "Quantidade inválida",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade de "
                            + "instrumentos inválida2", "Quantidade inválida",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //insere os dados do instrumento na tabela do carrinho
                Object[] rowObj = new Object[5];
                float subtotal = instrumento.getPreco() * qtdeInstrumento;
                //converte o preco do instrumento (float) em moeda (R$)
                NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
                String precoInstrumento = formatadorReal.format(instrumento.getPreco());
                String valorSubtotal = formatadorReal.format(subtotal);
                rowObj[0] = instrumento.getId();
                rowObj[1] = instrumento.getNome();
                rowObj[2] = qtdeInstrumento;
                rowObj[3] = precoInstrumento;
                rowObj[4] = valorSubtotal;
                tabelaCarrinhoModel.addRow(rowObj);

                //solicita ao ServicoVenda a atualizacao do valor total da venda na tela
                ServicoVenda.atualizarTotalLabel(tabelaCarrinhoModel, tabelaCarrinho, labelTotal);
                //solicita ao ServicoVenda a limpeza da tabela de instrumentos, para que o usuario possa
                    //adicionar outros instrumentos se quiser
                ServicoVenda.limpaTabelaInstrumento(fieldInstrumento, tabelaInstrModel);

            } else {
                JOptionPane.showMessageDialog(rootPane, "O instrumento não "
                        + "está disponível ", "Instrumento indisponível",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não é possível adicionar o instrumento",
                    "Erro ao adicionar o instrumento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    //botao que finaliza a venda e insere os dados da venda no banco de dados atraves do ServicoVenda
    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
        try {
            Venda venda = new Venda();
            Cliente clienteVenda = null;
            int linhaSelCli = tabelaClientes.getSelectedRow();
            //solicita ao ServicoCliente o retorno do cliente da venda
            if (linhaSelCli >= 0) {
                clienteVenda = ServicoCliente.
                        obterCliente((Integer) tabelaClientes.getValueAt(linhaSelCli, 0));
            }

            float totalVenda = 0;
            DefaultTableModel tabelaCarrinhoModel = (DefaultTableModel) tabelaCarrinho.getModel();
            DefaultTableModel tabelaClienteModel = (DefaultTableModel) tabelaClientes.getModel();
            //insere os dados da tabela carrinho nos itens do carrinho (itens de venda) 
            if (tabelaCarrinhoModel.getRowCount() > 0) {
                for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                    if (tabelaCarrinho.getValueAt(i, 0) != null) {
                        //solicitao ao ServicoInstrumento o retorno do instrumento do item do carrinho
                        Instrumento instrumento = ServicoInstrumento.obterInstrumento(
                                (Integer) tabelaCarrinho.getValueAt(i, 0));
                        ItemCarrinho itemCarrinho = new ItemCarrinho();
                        itemCarrinho.setInstrumento(instrumento);
                        itemCarrinho.setQuantidade(
                                (Integer) tabelaCarrinhoModel.getValueAt(i, 2));
                        //converte o valor da moeda na tabela para float
                        float subtotal = converterMoeda(tabelaCarrinhoModel, i, 4);
                        //insere o subtotal do item nos dados do item do carrinho
                        itemCarrinho.setSubtotal(subtotal);
                        //solicita ao ServicoVenda a atualizacao do valor total da venda e armazena o valor
                        totalVenda = ServicoVenda.atualizarTotalLabel(tabelaCarrinhoModel, tabelaCarrinho, labelTotal);
                        //insere o item de venda nos dados da venda
                        venda.getCarrinho().add(itemCarrinho);
                        //insere o valor total da venda nos dados da venda
                        venda.setTotal(totalVenda);
                        //decrementa a quantidade do instrumento vendida do estoque
                        instrumento.setEstoque(instrumento.getEstoque()
                                - (Integer) tabelaCarrinhoModel.getValueAt(i, 2));
                    }
                }
            }

            if (clienteVenda == null || totalVenda == 0) {
                JOptionPane.showMessageDialog(rootPane, "Informar os dados "
                        + "da venda!", "Venda inválida",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            //insere o cliente da venda nos dados da venda
            venda.setCliente(clienteVenda);
            Date date = new Date();
            //insere a data da venda nos dados da venda
            venda.setDate(date);

            if (!ServicoVenda.verificarFormaPgto(comboPagamento)) {
                JOptionPane.showMessageDialog(rootPane, "Forma de pagamento "
                        + "não selecionada!", "Forma de Pagamento",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String formaPagamento = (String) comboPagamento.getSelectedItem();
            //insere a forma de pagamento da venda nos dados da venda
            venda.setFormaPagamento(formaPagamento);

            JOptionPane.showMessageDialog(rootPane, "Venda efetuada"
                    + " com sucesso!",
                    "Venda efetuada",
                    JOptionPane.INFORMATION_MESSAGE);

            //solicita ao ServicoVenda a insercao da venda no banco de dados
            ServicoVenda.fazerVenda(venda);
            //solicita ao ServicoVenda a limpeza das tabelas para a proxima venda
            ServicoVenda.limpaTabelaVendas(labelCliente, tabelaCarrinhoModel, fieldNome,
                    tabelaClienteModel, comboPagamento, fieldRecebido, labelTroco);
            //solicita ao ServicoVenda a atualizacao da label do valor total da venda
            ServicoVenda.atualizarTotalLabel(tabelaCarrinhoModel, tabelaCarrinho, labelTotal);
            labelTotal.setText("R$ 00,00");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_botaoFinalizarActionPerformed

    //botao que excluir um instrumento da tabela do carrinho
    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        try {
            DefaultTableModel tabelaCarrinhoModel = (DefaultTableModel) tabelaCarrinho.getModel();
            int tabelaRemover = tabelaCarrinho.getSelectedRow();
            if (tabelaCarrinho.getValueAt(tabelaRemover, 0) != null) {
                int opcao = JOptionPane.showConfirmDialog(rootPane, "Confirmar exclusão?",
                        "Exclusão",
                        JOptionPane.INFORMATION_MESSAGE);
                if (opcao == JOptionPane.YES_OPTION) {
                    tabelaCarrinhoModel.removeRow(tabelaRemover);
                    ServicoVenda.atualizarTotalLabel(tabelaCarrinhoModel, tabelaCarrinho, labelTotal);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Item não selecionado!",
                        "Item",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    //botao que altera a quantidade de um instrumento na tabela do carrinho
    private void botaoAlterarQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarQtdeActionPerformed
        try {
            DefaultTableModel tabelaCarrinhoModel = (DefaultTableModel) tabelaCarrinho.getModel();
            int tabelaQtdAlterar = tabelaCarrinho.getSelectedRow();
            int qtdeEmEstoque = 0;
            int idQtdeAlterar = (Integer) tabelaCarrinhoModel.getValueAt(tabelaQtdAlterar, 0);
            //solicita ao ServicoInstrumento o retorno do instrumento selecionado
            Instrumento instrumento = ServicoInstrumento.obterInstrumento(idQtdeAlterar);
            //armazena a quantidade em estoque do instrumento
            qtdeEmEstoque = instrumento.getEstoque();

            //se a tabela nao estiver vazia, solicita ao usuario a nova quantidade
            if (tabelaCarrinho.getValueAt(tabelaQtdAlterar, 0) != null) {
                int novaQtde = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Digite a nova quantidade",
                        "Alterar Quantidade",
                        JOptionPane.INFORMATION_MESSAGE));
                //se a nova quantidade for menor ou igual a quantidade em estoque, a quantidade e os valores sao atualizados
                if (novaQtde <= qtdeEmEstoque) {
                    tabelaCarrinhoModel.setValueAt(novaQtde, tabelaQtdAlterar, 2);
                    float subtotal = instrumento.getPreco() * novaQtde;
                    NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
                    String valor = formatadorReal.format(subtotal);
                    tabelaCarrinhoModel.setValueAt(valor, tabelaQtdAlterar, 4);
                    //solicitao ao ServicoVenda a atualizacao da label do valor total da venda
                    ServicoVenda.atualizarTotalLabel(tabelaCarrinhoModel, tabelaCarrinho, labelTotal);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade solicitada "
                            + "maior do que em estoque!", "Quantidade inválida",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Item não selecionado!",
                        "Item",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_botaoAlterarQtdeActionPerformed

    //botao que calcula o troco 
    private void botaoCalculaTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalculaTrocoActionPerformed
        try {
            NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
            //solicitao ao ServicoVenda o calculo do troco e armezena o valor
            float troco = ServicoVenda.calcularTroco(fieldRecebido, labelTotal);
            float recebido = Float.parseFloat(fieldRecebido.getText().replaceAll(",", "."));
            //armazena o valor total da venda
            String total = labelTotal.getText();
            //converte o valor total em float
            String valorConvertido = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(total).toString();
            float totalLabel = Float.parseFloat(valorConvertido);
            //se o campo do valor recebido estiver vazio ou o valor for menor que 0, aparecera uma msg de erro
            if (fieldRecebido == null || troco < 0) {
                JOptionPane.showMessageDialog(rootPane, "Valor recebido "
                        + "inválido!", "Valor Recebido",
                        JOptionPane.ERROR_MESSAGE);
            //se o valor recebido for menor do que o valor total da venda, aparecera uma msg de erro
            } else if (recebido < totalLabel) {
                JOptionPane.showMessageDialog(rootPane, "Valor recebido "
                        + "menor do que o total da venda!", "Valor Recebido",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //se o campo do valor recebido nao estiver vazio e for maior que o total da venda, o valor do troco sera exibido
                String valorTroco = formatadorReal.format(troco);
                labelTroco.setText(valorTroco);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Valor recebido "
                    + "inválido!", "Valor Recebido",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoCalculaTrocoActionPerformed

    //atualiza e insere os dados do instrumento na tabela de instrumentos
    public boolean atualizarInstrumento() throws InstrumentoException, Exception {
        //solicitao ao ServicoInstrumento o retorno do instrumento selecionado
        List<Instrumento> resultado = ServicoInstrumento.procurarInstrumento(ultimoInstrumento);
        DefaultTableModel model = (DefaultTableModel) tabelaInstrumentos.getModel();
        model.setRowCount(0);
        if (resultado == null || resultado.size() <= 0) {
            return false;
        }
        for (int i = 0; i < resultado.size(); i++) {
            Instrumento instrumento = resultado.get(i);
            NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
            String precoInstrumento = formatadorReal.format(instrumento.getPreco());
            //insere os dados do instrumento na tabela
            if (instrumento != null) {
                Object[] row = new Object[4];
                row[0] = instrumento.getId();
                row[1] = instrumento.getNome();
                row[2] = instrumento.getEstoque();
                row[3] = precoInstrumento;
                model.addRow(row);
            }
        }

        return true;
    }

    //atualiza e insere os dados do cliente na tabela de clientes
    public boolean atualizarCliente() throws ClienteException, Exception {
        //solicitao ao ServicoCliente o retorno do cliente selecionado
        List<Cliente> resultado = ServicoCliente.procurarCliente(ultimoCliente);
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
                row[3] = cliente.getEmail();
                modelo.addRow(row);
            }
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAlterarQtde;
    private javax.swing.JButton botaoCalculaTroco;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoPesquisarInstrumento;
    private javax.swing.JButton botaoSelecionar;
    private javax.swing.JComboBox<String> comboPagamento;
    private javax.swing.JTextField fieldInstrumento;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldRecebido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTroco;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaInstrumentos;
    // End of variables declaration//GEN-END:variables
}
