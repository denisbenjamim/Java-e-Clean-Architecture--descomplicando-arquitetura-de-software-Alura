package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {
    private Aluno aluno;

    public FabricaDeAluno() {}

    FabricaDeAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public FabricaDeAluno comNomeCPFEmail(final String nome, final String cpf, final String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(final String ddd, String numero){
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }
}
