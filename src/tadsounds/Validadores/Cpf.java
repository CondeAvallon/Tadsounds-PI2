package tadsounds.Validadores;

import java.util.Scanner;
import tadsounds.Models.Cliente;

//classe que permite a validacao do cpf inserido pelo usuario
public class Cpf {

    public boolean validacaoCpf(Cliente cliente) {
        String cpf = cliente.getCpf();
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");

        String separaDig11 = cpf.substring(10);
        String separaDig10 = cpf.substring(9, 10);
        String separaDig9 = cpf.substring(8, 9);
        String separaDig8 = cpf.substring(7, 8);
        String separaDig7 = cpf.substring(6, 7);
        String separaDig6 = cpf.substring(5, 6);
        String separaDig5 = cpf.substring(4, 5);
        String separaDig4 = cpf.substring(3, 4);
        String separaDig3 = cpf.substring(2, 3);
        String separaDig2 = cpf.substring(1, 2);
        String separaDig1 = cpf.substring(0, 1);

        int digito1 = Integer.parseInt(separaDig1);
        int digito2 = Integer.parseInt(separaDig2);
        int digito3 = Integer.parseInt(separaDig3);
        int digito4 = Integer.parseInt(separaDig4);
        int digito5 = Integer.parseInt(separaDig5);
        int digito6 = Integer.parseInt(separaDig6);
        int digito7 = Integer.parseInt(separaDig7);
        int digito8 = Integer.parseInt(separaDig8);
        int digito9 = Integer.parseInt(separaDig9);
        int digito10 = Integer.parseInt(separaDig10);
        int digito11 = Integer.parseInt(separaDig11);

        int multDigito1 = digito1 * 10;
        int multDigito2 = digito2 * 9;
        int multDigito3 = digito3 * 8;
        int multDigito4 = digito4 * 7;
        int multDigito5 = digito5 * 6;
        int multDigito6 = digito6 * 5;
        int multDigito7 = digito7 * 4;
        int multDigito8 = digito8 * 3;
        int multDigito9 = digito9 * 2;

        int somaPasso2 = multDigito1 + multDigito2 + multDigito3 + multDigito4
                + multDigito5 + multDigito6 + multDigito7 + multDigito8 + multDigito9;

        int restoPasso3 = somaPasso2 % 11;

        int subPasso4 = 11 - restoPasso3;

        if (subPasso4 != 10) {
            if (subPasso4 != digito10) {
                if (subPasso4 != 0) {
                    return false;
                }
            }
        }

        digito1 = digito1 * 11;
        digito2 = digito2 * 10;
        digito3 = digito3 * 9;
        digito4 = digito4 * 8;
        digito5 = digito5 * 7;
        digito6 = digito6 * 6;
        digito7 = digito7 * 5;
        digito8 = digito8 * 4;
        digito9 = digito9 * 3;
        digito10 = digito10 * 2;

        int somaPasso7 = digito1 + digito2 + digito3 + digito4 + digito5 + digito6
                + digito7 + digito8 + digito9 + digito10;

        int restoPasso8 = somaPasso7 % 11;

        int subPasso9 = 11 - restoPasso8;

        if (subPasso9 != 10) {
            if (subPasso9 != digito11) {
                if (subPasso9 != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
