package br.com.alura.escola.dominio.repositorio;

import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;


public interface RepositorioAlunos {
    
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(CPF cpf);
    List<Aluno> todosAlunos();

}
