package br.com.alura.escola.dominio.aluno;

public class Email {
    private final String regex = "^[\\w.]+@[\\w.]+\\.[\\a-zA-Z]+(\\.[\\a-zA-Z])?+$";
    private final String endereco;

    public Email(String endereco) {
        if(endereco == null || !endereco.matches(regex)){
            throw new IllegalArgumentException("E-mail invalido");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
