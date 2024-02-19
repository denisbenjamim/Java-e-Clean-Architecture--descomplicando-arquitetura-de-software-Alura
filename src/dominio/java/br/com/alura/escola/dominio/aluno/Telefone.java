package br.com.alura.escola.dominio.aluno;

public class Telefone {
    private final String regexDDD = "^[\\d]{2}$";
    private final String regexNumero = "^[\\d]{8,9}$";
    private final String ddd;
    private final String numero;

    
    public Telefone(String ddd, String numero) {
        if(ddd == null || !ddd.matches(regexDDD)){
            throw new IllegalArgumentException("DDD inválido!");
        }

        if(numero == null || !numero.matches(regexNumero)){
            throw new IllegalArgumentException("Número inválido!");
        }

        this.ddd = ddd;
        this.numero = numero;
    }
    
    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
