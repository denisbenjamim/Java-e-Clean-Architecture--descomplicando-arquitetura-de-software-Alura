package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CPFTest {

    @Test
    void naoDeveCriarCpfsCasoInvalidos(){
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("332.174.618-2"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("332.174.618-2A"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("33217461827"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("332.174.618.27"));
        assertThrows(IllegalArgumentException.class, () -> new CPF("332.174.618-277"));
    }

    @Test
    void deveCriarCpf(){
        final String cpf1 = "123.456.789-00";

        assertEquals(cpf1, new CPF(cpf1).getNumero());
    }
}
