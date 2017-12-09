package tadsounds.Telas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tadsounds.Models.Cliente;
import tadsounds.Models.Instrumento;
import tadsounds.Models.Venda;
import tadsounds.Models.ItemCarrinho;
import tadsounds.Servicos.ServicoVenda;

//classe que permite ao usuario gerar relatorios das vendas realizadas durante o periodo selecionado
public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelDatas = new javax.swing.JPanel();
        btPesquisar = new javax.swing.JButton();
        labelInicio = new javax.swing.JLabel();
        labelTermino = new javax.swing.JLabel();
        pickerInicio = new org.jdesktop.swingx.JXDatePicker();
        pickerTermino = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRelatorio = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório");

        jPanelDatas.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        labelInicio.setText("Data Inicio");

        labelTermino.setText("Data Término");

        javax.swing.GroupLayout jPanelDatasLayout = new javax.swing.GroupLayout(jPanelDatas);
        jPanelDatas.setLayout(jPanelDatasLayout);
        jPanelDatasLayout.setHorizontalGroup(
            jPanelDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatasLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(labelInicio)
                .addGap(3, 3, 3)
                .addComponent(pickerInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(labelTermino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pickerTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btPesquisar)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanelDatasLayout.setVerticalGroup(
            jPanelDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInicio)
                    .addComponent(labelTermino)
                    .addComponent(btPesquisar)
                    .addComponent(pickerInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickerTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Produto", "Quantidade", "Tipo do Instrumento", "Marca", "Forma Pagamento", "Data Venda", "Total Venda"
            }
        ));
        jScrollPane1.setViewportView(tableRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botao que realiza a pesquisa dos relatorios, atraves do ServicoVenda, de acordo com o periodo selecionado
    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        //armazena as datas selecionadas pelo usuario
        Date dataInicio = pickerInicio.getDate();
        Date dataTermino = pickerTermino.getDate();
        try {
            //solicita ao ServicoVenda e armazena as vendas com data dentro do periodo nos parametros
            ArrayList<Venda> listaRelatorio = ServicoVenda.listarVendasPeriodo(rootPane, dataInicio, dataTermino);
            if (listaRelatorio == null || listaRelatorio.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Não há dados "
                        + "de venda para exibição do relatório", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel modelRelatorio = (DefaultTableModel) tableRelatorio.getModel();
            modelRelatorio.setRowCount(0);

            float total = 0;

            //insere os dados das vendas na tabela de relatorio
            for (Venda venda : listaRelatorio) {
                Cliente clienteVenda = venda.getCliente();

                if (clienteVenda != null) {
                    Object[] linhaReserva = new Object[8];
                    String nomeCliente = clienteVenda.getNome();
                    linhaReserva[0] = nomeCliente;
                    modelRelatorio.addRow(linhaReserva);
                }
                ArrayList<ItemCarrinho> listItensVenda = venda.getCarrinho();
                if (listItensVenda != null || !listItensVenda.isEmpty()) {
                    for (ItemCarrinho itemCarrinho : listItensVenda) {
                        Instrumento instrumento = itemCarrinho.getInstrumento();
                        if (instrumento != null) {
                            Object[] linhaItem = new Object[8];
                            linhaItem[1] = instrumento.getNome();
                            linhaItem[2] = itemCarrinho.getQuantidade();
                            linhaItem[3] = instrumento.getTipoInstrumento();
                            linhaItem[4] = instrumento.getMarca();
                            modelRelatorio.addRow(linhaItem);
                        }
                    }
                }

                Object[] linhaOutros = new Object[8];
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                //solicita ServicoVenda a conversao do valor para moeda
                String valorTotalVenda = ServicoVenda.converterValor(venda.getTotal());
                
                linhaOutros[5] = venda.getFormaPagamento();
                linhaOutros[6] = formatador.format(venda.getDate());
                linhaOutros[7] = valorTotalVenda;
                total += venda.getTotal();
                modelRelatorio.addRow(linhaOutros);

                Object[] linhaBranca = new Object[8];
                modelRelatorio.addRow(linhaBranca);
            }
            Object[] linhaTotal = new Object[8];
            //solicita ServicoVenda a conversao do valor para moeda
            String valorTotal = ServicoVenda.converterValor(total);
            linhaTotal[0] = "Valor total";
            linhaTotal[7] = valorTotal;
            modelRelatorio.addRow(linhaTotal);

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanelDatas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelTermino;
    private org.jdesktop.swingx.JXDatePicker pickerInicio;
    private org.jdesktop.swingx.JXDatePicker pickerTermino;
    private javax.swing.JTable tableRelatorio;
    // End of variables declaration//GEN-END:variables
}
