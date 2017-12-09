
package tadsounds.Validadores;

import tadsounds.Models.Venda;
import tadsounds.Exceptions.VendaException;

//permite a validacao da venda inserida pelo usuario
public class ValidadorVenda {
    
    public static void validar(Venda venda) throws VendaException {
        if (venda == null) {
            throw new VendaException("Venda inválida");
        } 
    }
    
}
