package tadsounds.Servicos;

import java.util.List;
import tadsounds.Dao.DAOInstrumento;
import tadsounds.Models.Instrumento;
import tadsounds.Exceptions.DataSourceException;
import tadsounds.Exceptions.InstrumentoException;
import tadsounds.Validadores.ValidadorInstrumento;

//classe que fornece certos servicos referentes ao instrumento
public class ServicoInstrumento {

    //cadastra os dados do instrumento no banco de dados atraves do DAOInstrumento
    public static void cadastrarInstrumento(Instrumento instrumento)
            throws InstrumentoException, DataSourceException {
        //verifica a integridade dos dados inseridos pelo usuario
        ValidadorInstrumento.validar(instrumento);
        try {
            //se os dados estiverem corretos, solicita ao DAO a insercao dos dados 
                //do instrumento no banco de dados
            DAOInstrumento.inserir(instrumento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //atualiza os dados do instrumento no banco de dados atraves do DAOInstrumento
    public static void atualizarInstrumento(Instrumento instrumento)
            throws InstrumentoException, DataSourceException {
        //verifica se os novos dados inseridos pelo usuario sao validos
        ValidadorInstrumento.validar(instrumento);
        try {
            //se forem validos, solicita ao DAO a atualização dos dados do instrumento
            DAOInstrumento.atualizar(instrumento);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //procura um instrumento pelo nome no banco de dados atraves do DAOInstrumento
    public static List<Instrumento> procurarInstrumento(String valor)
            throws InstrumentoException, DataSourceException {
        try {
            //se o campo de texto estiver vazio, solicitao ao DAO o retorno de todos 
                //os instrumentos ativos cadastrados
            if (valor == null) {
                return DAOInstrumento.listar();
            } else {
                //se nao estiver vazio, sera retornado instrumento com nomes que contenham os caracteres inseridos
                return DAOInstrumento.procurar(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    //retorna um instrumento atraves do DAOInstrumento
    public static Instrumento obterInstrumento(Integer id)
            throws InstrumentoException, DataSourceException {
        try {
            return DAOInstrumento.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void excluirQuarto(Integer id)
            throws InstrumentoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do quarto informado
            DAOInstrumento.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
