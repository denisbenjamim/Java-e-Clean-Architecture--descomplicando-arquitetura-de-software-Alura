package br.com.alura.escola.dominio.indicacao;

import java.time.LocalDateTime;

import br.com.alura.escola.dominio.aluno.Aluno;


public class Indicacao {
    private final Aluno indicado;
    private final Aluno indicante;
    private final LocalDateTime dataIndicacao;

    Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataIndicacao = LocalDateTime.now();
    }

    Aluno getIndicado() {
        return indicado;
    }

    Aluno getIndicante() {
        return indicante;
    }

    LocalDateTime getDataIndicacao() {
        return dataIndicacao;
    }
    
    
}
