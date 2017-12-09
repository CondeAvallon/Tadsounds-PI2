package tadsounds.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tadsounds.Models.Instrumento;
import tadsounds.UtilidadesBD.Conexao;

//classe que realiza a manutencao de instrumentos no banco de dados
public class DAOInstrumento {

    //insere os dados do instrumento no banco de dados
    public static void inserir(Instrumento instrumento) throws SQLException, Exception {
        String sql = "INSERT INTO Instrumento(Nome, Marca, Descricao, Estoque, Cor, Tipo, Preco, Ativo)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, instrumento.getNome());
            preparedStatement.setString(2, instrumento.getMarca());
            preparedStatement.setString(3, instrumento.getDescricao());
            preparedStatement.setInt(4, instrumento.getEstoque());
            preparedStatement.setString(5, instrumento.getCor());
            preparedStatement.setString(6, instrumento.getTipoInstrumento());
            preparedStatement.setFloat(7, instrumento.getPreco());
            preparedStatement.setBoolean(8, true);
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

    //retorna uma tabela de todos os instrumentos ativos
    public static List<Instrumento> listar() throws SQLException, Exception {
        String sql = "SELECT * FROM Instrumento WHERE(Ativo = ?)";
        List<Instrumento> listaInstrumentos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            rs = preparedStatement.executeQuery();
            //laco de repeticao para cada item da tabela retornada do banco de dados
            while (rs.next()) {
                if (listaInstrumentos == null) {
                    listaInstrumentos = new ArrayList<Instrumento>();
                }
                //insere os dados retornados do banco de dados no instrumento
                Instrumento instrumento = new Instrumento();
                instrumento.setId(rs.getInt("IdInstrumento"));
                instrumento.setNome(rs.getString("Nome"));
                instrumento.setMarca(rs.getString("Marca"));
                instrumento.setDescricao(rs.getString("Descricao"));
                instrumento.setEstoque(rs.getInt("Estoque"));
                instrumento.setCor(rs.getString("Cor"));
                instrumento.setTipoInstrumento(rs.getString("Tipo"));
                instrumento.setPreco(rs.getFloat("Preco"));
                listaInstrumentos.add(instrumento);
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaInstrumentos;
    }

    //procura um ou mais instrumentos, que estejam ativos, pelo nome
    public static List<Instrumento> procurar(String valor) throws SQLException, Exception {
        String sql = "SELECT * FROM Instrumento WHERE Nome LIKE ? AND Ativo = ?";
        List<Instrumento> listaInstrumentos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + valor + "%");
            preparedStatement.setBoolean(2, true);
            rs = preparedStatement.executeQuery();
            //laco de repeticao para cada item da tabela retornada do banco de dados
            while (rs.next()) {
                if (listaInstrumentos == null) {
                    listaInstrumentos = new ArrayList<>();
                }
                //insere os dados retornados do banco de dados no instrumento
                Instrumento instrumento = new Instrumento();
                instrumento.setId(rs.getInt("IdInstrumento"));
                instrumento.setNome(rs.getString("Nome"));
                instrumento.setMarca(rs.getString("Marca"));
                instrumento.setDescricao(rs.getString("Descricao"));
                instrumento.setEstoque(rs.getInt("Estoque"));
                instrumento.setCor(rs.getString("Cor"));
                instrumento.setTipoInstrumento(rs.getString("Tipo"));
                instrumento.setPreco(rs.getFloat("Preco"));
                listaInstrumentos.add(instrumento);
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaInstrumentos;
    }

    //retorna um instrumento, que esteja ativo, a partir do seu id
    public static Instrumento obter(Integer id) throws SQLException, Exception {
        String sql = "SELECT * FROM Instrumento WHERE IdInstrumento = ? AND Ativo = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                //insere os dados retornados do banco de dados no instrumento
                Instrumento instrumento = new Instrumento();
                instrumento.setId(rs.getInt("IdInstrumento"));
                instrumento.setNome(rs.getString("Nome"));
                instrumento.setMarca(rs.getString("Marca"));
                instrumento.setDescricao(rs.getString("Descricao"));
                instrumento.setEstoque(rs.getInt("Estoque"));
                instrumento.setCor(rs.getString("Cor"));
                instrumento.setTipoInstrumento(rs.getString("Tipo"));
                instrumento.setPreco(rs.getFloat("Preco"));
                return instrumento;
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return null;
    }

    //atualiza os dados do instrumento no banco de dados
    public static void atualizar(Instrumento instrumento) throws SQLException, Exception {
        String sql = "UPDATE Instrumento SET Nome = ?, Marca = ?, Descricao = ?, Estoque = ?, Cor = ?, Tipo = ?"
                + ", Preco = ? WHERE(IdInstrumento = ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, instrumento.getNome());
            preparedStatement.setString(2, instrumento.getMarca());
            preparedStatement.setString(3, instrumento.getDescricao());
            preparedStatement.setInt(4, instrumento.getEstoque());
            preparedStatement.setString(5, instrumento.getCor());
            preparedStatement.setString(6, instrumento.getTipoInstrumento());
            preparedStatement.setFloat(7, instrumento.getPreco());
            preparedStatement.setInt(8, instrumento.getId());
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

    //desativa um instrumento a partir do seu id
    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE Instrumento SET Ativo = ? WHERE(IdInstrumento = ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Conexao.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
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
}
