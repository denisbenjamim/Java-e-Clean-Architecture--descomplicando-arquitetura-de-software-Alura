package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.FabricaDeAluno;

public class MatricularAlunoDTO {
    private final String nome;
    private final String cpf;
    private final String email;

    public MatricularAlunoDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Aluno criarAluno(){
        return new FabricaDeAluno().comNomeCPFEmail(nome, cpf, email).criar();
    }

}
