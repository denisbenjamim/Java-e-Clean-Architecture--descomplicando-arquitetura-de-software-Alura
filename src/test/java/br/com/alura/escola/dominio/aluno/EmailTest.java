package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void naoDeveCriarEmailsComEnderecosInvalidos(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Email(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Email("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Email("emailInvalido");
        });
    }

    @Test
    void deveCriarEmailsComEnderecosInvalidos(){
        final String email1 = "denis.benjamim@gmail.com";
        final String email2 = "denis.benjamim@gmail.com.br";
        final String email3 = "benjamim@gmail.com";
        final String email4 = "benjamim@gmail.com.br";

        assertEquals(email1, new Email(email1).getEndereco());
        assertEquals(email2, new Email(email2).getEndereco());
        assertEquals(email3, new Email(email3).getEndereco());
        assertEquals(email4, new Email(email4).getEndereco());
    }
}
