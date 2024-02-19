package br.com.alura.escola.infra.aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.repositorio.RepositorioAlunos;


public class RepositorioAlunosEmMemoria implements RepositorioAlunos {
    private Map<String, Aluno> matriculados = new HashMap<>();

    @Override
    public void matricular(Aluno aluno) {
        matriculados.put(aluno.getCpf(), aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return matriculados.get(cpf.getNumero());
    }

    @Override
    public List<Aluno> todosAlunos() {
       return new ArrayList<>(matriculados.values());
    }

}
