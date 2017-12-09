package tadsounds.Validadores;

import tadsounds.Models.Instrumento;
import tadsounds.Exceptions.InstrumentoException;

public class ValidadorInstrumento {

    //classe que permite a validacao dos dados inseridos nos campos obrigatorios na tela de cadastro do instrumento
    public static void validar(Instrumento instrumento) throws InstrumentoException {
        if (instrumento == null) {
            throw new InstrumentoException("Instrumento não foi informado!");
        }
        if (instrumento.getNome() == null || "".equals(instrumento.getNome())) {
            throw new InstrumentoException("Nome não informado!");
        }
        if (instrumento.getDescricao() == null || "".equals(instrumento.getDescricao())) {
            throw new InstrumentoException("Descrição não informada!");
        }
        if (instrumento.getMarca() == null || "".equals(instrumento.getMarca())) {
            throw new InstrumentoException("Marca não informada!");
        }
        if (instrumento.getTipoInstrumento() == null || "SELECIONE".equals(instrumento.getTipoInstrumento())) {
            throw new InstrumentoException("Tipo não informado!");
        }
        if (instrumento.getCor() == null || "".equals(instrumento.getCor())) {
            throw new InstrumentoException("Cor não informada!");
        }
        if (instrumento.getEstoque() == null || instrumento.getEstoque() < 0) {
            throw new InstrumentoException("Quantidade não informada!");
        }
        if (instrumento.getPreco() == null || (instrumento.getPreco() < 0)) {
            throw new InstrumentoException("Preço não informado!");
        }

    }
}
