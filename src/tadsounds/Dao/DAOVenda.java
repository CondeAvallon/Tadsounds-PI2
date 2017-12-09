package tadsounds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tadsounds.Models.Cliente;
import tadsounds.Models.Instrumento;
import tadsounds.Models.ItemCarrinho;
import tadsounds.Models.Venda;
import tadsounds.Servicos.ServicoCliente;
import tadsounds.Servicos.ServicoInstrumento;
import tadsounds.UtilidadesBD.Conexao;

//classe que realiza a manutencao das vendas no banco de dados
public class DAOVenda {

    //insere os dados da venda no banco de dados e retorna o id da ultima venda realizada
    public static int inserir(tadsounds.Models.Venda venda) throws SQLException, Exception {
        String sql = "INSERT INTO Venda(IdCliente, FormaPagamento, DataVenda, ValorTotal)"
                + "VALUES(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int ultimaChave;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, venda.getCliente().getId());
            preparedStatement.setString(2, venda.getFormaPagamento());
            Timestamp dataBD = new Timestamp(venda.getDate().getTime());
            preparedStatement.setTimestamp(3, dataBD);
            preparedStatement.setFloat(4, venda.getTotal());
            preparedStatement.execute();

            //retorna o id gerado da ultima venda inserida no banco de dados
            ResultSet chaveVenda = preparedStatement.getGeneratedKeys();
            ultimaChave = 1;
            while (chaveVenda.next()) {
                ultimaChave = chaveVenda.getInt(1);
            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return ultimaChave;
    }

    //insere os dados dos itens da venda no banco de dados, usando o id da venda como parametro
    public static void inserirItemVenda(ItemCarrinho itemCarrinho, int chaveVenda) throws SQLException, Exception {
        String sql = "INSERT INTO ItemCarrinho(IdInstrumento, IdVenda, Quantidade, Subtotal)"
                + "VALUES (?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, itemCarrinho.getInstrumento().getId());
            preparedStatement.setInt(2, chaveVenda);
            preparedStatement.setInt(3, itemCarrinho.getQuantidade());
            preparedStatement.setFloat(4, itemCarrinho.getSubtotal());
            preparedStatement.execute();

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //decrementa a quantidade vendidade do instrumento no estoque
    public static void decrementoEstoque(Venda venda) throws SQLException, Exception {
        String sql = "UPDATE Instrumento SET Estoque = ? "
                + "WHERE Instrumento.IdInstrumento = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (ItemCarrinho c : venda.getCarrinho()) {
                preparedStatement.setInt(1, c.getInstrumento().getEstoque());
                preparedStatement.setInt(2, c.getInstrumento().getId());
                preparedStatement.executeUpdate();
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //retorna os dados das vendas que foram realizadas dentro do periodo nos parametros
        // e retorna um array com as vendas retornadas
    public static ArrayList<Venda> gerarRelatorioVendas(Timestamp dataInicio, Timestamp dataTermino)
            throws SQLException, Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        String inicio = new SimpleDateFormat("yyyy-MM-dd").format(dataInicio);
        String termino = new SimpleDateFormat("yyyy-MM-dd").format(dataTermino);

        try {
            connection = Conexao.getConnection();
            String query = "SELECT Cliente.IdCliente, Venda.IdVenda, Venda.IdCliente, Venda.FormaPagamento, Venda.DataVenda, Venda.ValorTotal FROM Venda\n"
                    + "INNER JOIN Cliente ON Cliente.IdCliente = Venda.IdCliente\n"
                    + "WHERE Venda.DataVenda BETWEEN '" + inicio + "' AND '" + termino + "'";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet rs = preparedStatement.executeQuery();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

            //laco de repeticao para cada item da tabela retornada do banco de dados
            while (rs.next()) {
                Venda venda = new Venda();
                //insere os dados retornados do banco de dados na venda
                Cliente clienteVenda = new Cliente();
                int idCliente = rs.getInt("Cliente.IdCliente");
                clienteVenda = ServicoCliente.obterCliente(idCliente);
                venda.setCliente(clienteVenda);
                Timestamp t = rs.getTimestamp("Venda.DataVenda");
                String data = formatador.format(t);
                Date dataVenda = formatador.parse(data);
                venda.setFormaPagamento(rs.getString("Venda.FormaPagamento"));
                venda.setDate(dataVenda);
                venda.setTotal(rs.getFloat("Venda.ValorTotal"));
                venda.setId(rs.getInt("Venda.IdVenda"));
                //adiciona a venda no array de vendas
                vendas.add(venda);
            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return vendas;
    }

    //retorna os itens de vendas das vendas realizadas dentro do periodo nos parametros 
        //e adiciona os itens nas vendas, que foram passadas em um array por parametro
    public static ArrayList<Venda> gerarRelatorioItensVendas(ArrayList<Venda> vendas, Timestamp dataInicio, Timestamp dataTermino)
            throws SQLException, Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String inicio = new SimpleDateFormat("yyyy-MM-dd").format(dataInicio);
        String termino = new SimpleDateFormat("yyyy-MM-dd").format(dataTermino);

        try {
            connection = Conexao.getConnection();
            String query = "SELECT ItemCarrinho.SubTotal, ItemCarrinho.IdVenda, ItemCarrinho.IdInstrumento, Instrumento.Nome, ItemCarrinho.Quantidade, Instrumento.Tipo, Instrumento.Marca\n"
                    + "FROM ItemCarrinho INNER JOIN Venda ON ItemCarrinho.IdVenda = Venda.IdVenda\n"
                    + "INNER JOIN Instrumento ON Instrumento.IdInstrumento = ItemCarrinho.IdInstrumento\n"
                    + "WHERE Venda.DataVenda BETWEEN '" + inicio + "' AND '" + termino + "'\n"
                    + "ORDER BY Venda.IdVenda";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();

            //laco de repeticao para cada item da tabela retornada do banco de dados
            while (rs.next()) {
                for (int i = 0; i < vendas.size(); i++) {
                    //insere os dados retornados do banco de dados no item de venda (item de carrinho)
                    int idItemVenda = rs.getInt("ItemCarrinho.IdVenda");
                    if (idItemVenda == vendas.get(i).getId()) {
                        int idInstrumento = rs.getInt("ItemCarrinho.IdInstrumento");
                        ItemCarrinho itemCarrinho = new ItemCarrinho();
                        Instrumento instrumento = new Instrumento();
                        instrumento = ServicoInstrumento.obterInstrumento(idInstrumento);
                        itemCarrinho.setInstrumento(instrumento);
                        itemCarrinho.setQuantidade(rs.getInt("ItemCarrinho.Quantidade"));
                        itemCarrinho.setSubtotal(rs.getFloat("ItemCarrinho.SubTotal"));
                        vendas.get(i).getCarrinho().add(itemCarrinho);
                    }

                }

            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return vendas;
    }
}
