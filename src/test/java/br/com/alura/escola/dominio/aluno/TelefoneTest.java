package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TelefoneTest {

    private final String dddValido = "13";
    private final String numeroValido = "997279686";

    @Test
    void naoDeveCriarTelefonesCasoDDDInvalido(){
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(null, numeroValido));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("", numeroValido));   
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("013", numeroValido));   
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("1", numeroValido));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("A", numeroValido));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("A1", numeroValido));
    }

    @Test
    void naoDeveCriarTelefonesCasoNumeroInvalido(){
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, null));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, ""));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, "9972796G6"));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, "9972796861"));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, "9727968"));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone(dddValido, "9727968a"));
    }

    @Test
    void deveCriarTelefoneComNoveDigitos(){
        final String ddd = "13";
        final String telfone = "997279686";

        final Telefone  retorno = new Telefone(ddd, telfone);
        assertEquals(ddd, retorno.getDdd());
        assertEquals(telfone, retorno.getNumero());
        assertEquals(9, retorno.getNumero().length());
    }

    @Test
    void deveCriarTelefoneComOitoDigitos(){
        final String ddd = "13";
        final String telfone = "97279686";

        final Telefone  retorno = new Telefone(ddd, telfone);
        assertEquals(ddd, retorno.getDdd());
        assertEquals(telfone, retorno.getNumero());
        assertEquals(8, retorno.getNumero().length());
    }
}
