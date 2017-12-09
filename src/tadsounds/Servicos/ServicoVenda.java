package tadsounds.Servicos;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tadsounds.Dao.DAOVenda;
import tadsounds.Models.Cliente;
import tadsounds.Models.Venda;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Exceptions.VendaException;
import tadsounds.Models.ItemCarrinho;
import tadsounds.Validadores.ValidadorVenda;

//classe que fornece certos servicos referentes a venda e ao relatorio
public class ServicoVenda {

    //realiza a insercao dos dados da venda no banco de dados atraves do DAOVenda
    public static void fazerVenda(Venda venda) throws VendaException, DataSourceException {
        //verifica a integridade dos dados da venda
        ValidadorVenda.validar(venda);
        try {
            //armazena o id(chave primaria) da venda realizada
            int chaveVenda = DAOVenda.inserir(venda);
            //solicita ao DAO a insercao dos itens de venda na venda, usando o id retornado anteriormente
                //e solicita ao DAO o decremento das quantidades vendidas dos instrumentos no estoque
            for (int i = 0; i < venda.getCarrinho().size(); i++) {
                ItemCarrinho itemCarrinho = venda.getCarrinho().get(i);
                DAOVenda.inserirItemVenda(itemCarrinho, chaveVenda);
                DAOVenda.decrementoEstoque(venda);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //verifica se o instrumento a ser adicionado ja esta adiciona no carrinho
    public static boolean verificarInstrSelec(JRootPane rootPane, DefaultTableModel tabelaInstrModel,
            DefaultTableModel tabelaCarrinhoModel, int row) {
        boolean instr = false;
        try {
            Integer idInstrumentoAComprar = (Integer) tabelaInstrModel.getValueAt(row, 0);
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                Integer idInstrumentoComprado = (Integer) tabelaCarrinhoModel.getValueAt(i, 0);
                //se o id do instrumento for igual ao de algum instrumento que ja esteja no carrinho
                    //retornara false
                if (idInstrumentoAComprar == idInstrumentoComprado) {
                    instr = false;
                    return instr;
                } else {
                    //se nao, retornara true
                    instr = true;
                }
            }
            //retornara true tambem se nao tiver nenhum instrumento no carrinho
            if (tabelaCarrinhoModel.getRowCount() == 0) {
                instr = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Instrumento "
                    + "não selecionado!", "Instrumento",
                    JOptionPane.ERROR_MESSAGE);
        }
        return instr;
    }

    //verifica se ha algum cliente selecionado, para que o usuario possa adicionar instrumentos no carrinho
    public static boolean verificarClienteSelec(Cliente clienteVenda, JTable tabelaClientes) {
        boolean clienteSelecionado = false;
        try {
            int linhaSelCli = tabelaClientes.getSelectedRow();

            if (linhaSelCli >= 0) {
                clienteVenda = ServicoCliente.
                        obterCliente((Integer) tabelaClientes.getValueAt(linhaSelCli, 0));
                return true;
            }
        } catch (Exception ex) {

        }
        return clienteSelecionado;
    }

    //atualiza o label que apresenta o valor total da venda, somando os subtotais
    public static float atualizarTotalLabel(DefaultTableModel tabelaCarrinhoModel,
            JTable tabelaCarrinho, JLabel labelTotal) {
        NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
        float totalLabel = 0;
        String preco = "";
        try {
            for (int i = 0; i < tabelaCarrinhoModel.getRowCount(); i++) {
                if (tabelaCarrinho.getValueAt(i, 0) != null) {
                    float subtotal = converterMoeda(tabelaCarrinhoModel, i, 4);
                    totalLabel += subtotal;
                }
                preco = formatadorReal.format(totalLabel);
            }
            labelTotal.setText(preco);
        } catch (Exception e) {
            System.out.println("erro");
        }
        return totalLabel;
    }

    //limpa a tabela de instrumentos
    public static void limpaTabelaInstrumento(JTextField field, DefaultTableModel tabelaInstrModel) {
        field.setText("");
        tabelaInstrModel.setRowCount(0);
    }

    //converte o valor de uma moeda (R$) para float
    public static float converterMoeda(DefaultTableModel tabelaCarrinhoModel, int coluna, int linha) {
        float valor = 0;
        try {
            String valorMoeda = (String) tabelaCarrinhoModel.getValueAt(coluna, linha);
            String valorConvertido = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(valorMoeda).toString();
            valor = Float.parseFloat(valorConvertido);
        } catch (Exception ex) {

        }
        return valor;
    }

    //converte o valor de um float para moeda (R$)
    public static String converterValor(float valor) {
        String moeda = "";
        try {
            NumberFormat formatadorReal = NumberFormat.getCurrencyInstance();
            moeda = formatadorReal.format(valor);
        } catch (Exception ex) {

        }
        return moeda;
    }

    //limpa os campos da tela de vendas para serem usados na proxima venda
    public static void limpaTabelaVendas(JLabel labelCliente, DefaultTableModel tabelaCarrinhoModel,
            JTextField fieldCliente, DefaultTableModel tabelaClienteModel, JComboBox formaPagamento,
            JTextField fieldRecebido, JLabel labelTroco) {
        labelCliente.setText("");
        tabelaCarrinhoModel.setRowCount(0);
        tabelaClienteModel.setRowCount(0);
        fieldCliente.setText("");
        formaPagamento.setSelectedIndex(0);
        fieldRecebido.setText("");
        labelTroco.setText("R$ 00,00");
    }

    //verifica se o campo de forma de pagamento esta selecionado
    public static boolean verificarFormaPgto(JComboBox comboPagamento) {
        boolean selecionado = false;
        if (comboPagamento.getSelectedIndex() == 0) {
            return selecionado;
        } else {
            selecionado = true;
        }
        return selecionado;
    }

    //gera relatorio das vendas dentro do periodo informado nos parametros
    public static ArrayList<Venda> listarVendasPeriodo(JRootPane rootPane, Date dataInicio, Date dataTermino) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Venda> vendas = new ArrayList<Venda>();
        try {
            //converte as dates em timestamp para ser usado no DAO
            Timestamp inicio = new Timestamp(dataInicio.getTime());
            Timestamp termino = new Timestamp(dataTermino.getTime());
            //solicita ao DAO os dados das vendas dentro do periodo e retorna um array com as vendas
            vendas = DAOVenda.gerarRelatorioVendas(inicio, termino);
            //solicita ao DAO a insercao dos itens de vendas nas vendas dentro do periodo e as retorna
                //com os itens de venda inseridos
            vendas = DAOVenda.gerarRelatorioItensVendas(vendas, inicio, termino);
        } catch (Exception ex) {

        }

        ArrayList<Venda> vendasPeriodo = new ArrayList();
        //verifica se o periodo escolhido pelo usuario para gerar relatorios nao eh maior do que 30 dias
        int dias = calcularDifDias(dataInicio, dataTermino);
        try {
            if (dias > 30) {
                JOptionPane.showMessageDialog(rootPane, "Data inválida! "
                        + "Limite de 30 dias!", "Relatório",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                for (Venda venda : vendas) {
                    //converte as datas para o formato dd/MM/yyyy
                    String dataIni = formatador.format(dataInicio);
                    Date dateIni = (Date) formatador.parse(dataIni);
                    String dataTer = formatador.format(dataTermino);
                    Date dateTer = (Date) formatador.parse(dataTer);
                    String dataVenda = formatador.format(venda.getDate());
                    Date dateVenda = (Date) formatador.parse(dataVenda);

                    //se a data da venda estiver dentro do periodo selecionado, a venda eh armazenada
                        //e enviada quando o servico for solicitado
                    if ((dataInicio.before(venda.getDate()) && dataTermino.after(venda.getDate()))
                            || dateIni.equals(dateVenda)
                            || dateTer.equals(dateVenda)) {
                        vendasPeriodo.add(venda);
                    }
                }
            }
        } catch (Exception ex) {

        }

        return vendasPeriodo;
    }

    //calcula a diferena de dias entre as datas escolhidas na tela de relatorio
    public static int calcularDifDias(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    //calcula o troco na tela de vendas
    public static float calcularTroco(JTextField fieldRecebido, JLabel labelTotal) {
        float troco = 0;
        try {
            String totalLabel = labelTotal.getText();
            String valorConvertido = DecimalFormat.getCurrencyInstance(Locale.getDefault()).parse(totalLabel).toString();
            float valorTotal = Float.parseFloat(valorConvertido);
            String receb = fieldRecebido.getText().replaceAll(",", ".");
            float recebido = Float.parseFloat(receb);
            troco = recebido - valorTotal;
        } catch (Exception ex) {

        }
        return troco;
    }

}
