package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioAlunosEmMemoria;

public class MatricularAlunoTest {
    @Test
    void devePersistirAluno() {
        final RepositorioAlunosEmMemoria repositorio = new RepositorioAlunosEmMemoria();
        final MatricularAluno useCase = new MatricularAluno(repositorio);
        
        useCase.executar(new MatricularAlunoDTO("Beltrano", "123.123.123-12", "fulano@fulano.com.br"));
        final Aluno retorno = repositorio.buscarPorCPF(new CPF("123.123.123-12"));

        assertEquals("Beltrano", retorno.getNome());
        assertEquals("123.123.123-12", retorno.getCpf());
        assertEquals("fulano@fulano.com.br", retorno.getEmail());
    }
}
