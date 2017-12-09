package tadsounds.Servicos;

import java.util.List;
import tadsounds.Dao.DAOCliente;
import tadsounds.Models.Cliente;
import tadsounds.Exceptions.ClienteException;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Validadores.ValidadorCliente;

//classe que fornece certos servicos referentes ao cliente
public class ServicoCliente {

    //cadastra os dados do cliente no banco de dados atraves do DAOCliente
    public static void cadastrarCliente(Cliente cliente) throws ClienteException, DataSourceException {
        //verifica a integridade dos dados inseridos pelo usuario
        ValidadorCliente.validar(cliente);
        try {
            //se os dados estiverem corretos, solicita ao DAO a insercao dos dados 
                //do cliente no banco de dados
            DAOCliente.inserir(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //procura um cliente pelo nome no banco de dados atraves do DAOCliente
    public static List<Cliente> procurarCliente(String nome) throws ClienteException, DataSourceException {
        try {
            //se o campo de texto estiver vazio, solicitao ao DAO o retorno de todos 
                //os clientes ativos cadastrados
            if (nome == null || "".equals(nome)) {
                return DAOCliente.listar();
            } else {
                //se nao estiver vazio, sera retornado clientes com nomes que contenham os caracteres inseridos
                return DAOCliente.procurar(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //atualiza os dados do cliente no banco de dados atraves do DAOCliente
    public static void atualizarCliente(Cliente cliente) throws ClienteException, DataSourceException {
        //verifica se os novos dados inseridos pelo usuario sao validos
        ValidadorCliente.validar(cliente);
        try {
            //se forem validos, solicita ao DAO a atualização dos dados do cliente
            DAOCliente.atualizar(cliente);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

    //retorna um cliente atraves do DAOCliente
    public static Cliente obterCliente(Integer id) throws ClienteException, DataSourceException {
        try {
            return DAOCliente.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }

    //desativa um cliente atraves do DAOCliente
    public static void excluirCliente(Integer id) throws ClienteException, DataSourceException {
        try {
            DAOCliente.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados ", e);
        }
    }
}
