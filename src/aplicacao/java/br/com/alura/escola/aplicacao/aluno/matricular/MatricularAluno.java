package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.repositorio.RepositorioAlunos;

//Serviço
public class MatricularAluno {
    private final RepositorioAlunos repositorio;

    public MatricularAluno(RepositorioAlunos repositorio) {
        this.repositorio = repositorio;
    }
    
    public void executar(final MatricularAlunoDTO alunoDTO){
        final Aluno novo = alunoDTO.criarAluno();
        repositorio.matricular(novo);
    }
}
