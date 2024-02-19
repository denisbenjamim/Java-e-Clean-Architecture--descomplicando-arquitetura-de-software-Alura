package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.FabricaDeAluno;
import br.com.alura.escola.dominio.aluno.Telefone;
import br.com.alura.escola.dominio.repositorio.RepositorioAlunos;


public class RepositorioAlunosComJDBC implements RepositorioAlunos , AutoCloseable {

    private final Connection connection;

    public RepositorioAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        inserirAluno(aluno);

        inserirTelefone(aluno);
    }

    private void inserirTelefone(Aluno aluno) {
        final String sqlInsertTelefone = "INSERT INTO TELEFONE VALUES (?, ?, ?)";
        try(final PreparedStatement ps = connection.prepareStatement(sqlInsertTelefone)) {
            int i;
         
            for(Telefone telefone: aluno.getTelefones()){
                i = 1;
                ps.setString(i++, telefone.getDdd());
                ps.setString(i++, telefone.getNumero());
                ps.setString(i++, aluno.getCpf());

                ps.execute();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void inserirAluno(Aluno aluno) {
        final String sqlInsertAluno = "INSERT INTO ALUNO VALUES (?, ?, ? )";
        try(final PreparedStatement ps = connection.prepareStatement(sqlInsertAluno)) {
            int i = 1;
            ps.setString(i++, aluno.getCpf());
            ps.setString(i++, aluno.getNome());
            ps.setString(i++, aluno.getEmail());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        final Aluno aluno = getAlunoPeloCPF(cpf);

        preencherTelefonesAluno(aluno);
        return aluno;
    }

    private Aluno getAlunoPeloCPF(CPF cpf) {
        final String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
       
        try(final PreparedStatement ps = connection.prepareStatement(sql); final ResultSet rs = ps.executeQuery()) {

            ps.setString(1, cpf.getNumero());
            if(rs.next()){
                return new FabricaDeAluno().comNomeCPFEmail(rs.getString("nome"), rs.getString("id"), rs.getString("email")).criar();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void preencherTelefonesAluno(final Aluno aluno) {
        if(aluno == null){
            return;
        }

        final String sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
       
        try(final PreparedStatement ps = connection.prepareStatement(sql); final ResultSet rs = ps.executeQuery()) {

            ps.setString(1, aluno.getCpf());
            while(rs.next()){
                aluno.fabrica().comTelefone(rs.getString("ddd"), rs.getString("numero"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

    @Override
    public List<Aluno> todosAlunos() {
        final List<Aluno> alunos = getTodosAlunos();
        
        for(final Aluno aluno: alunos){
            preencherTelefonesAluno(aluno);
        }

        return alunos;
    }

    private List<Aluno> getTodosAlunos() {
        final List<Aluno> alunos = new ArrayList<>();
        final String sql = "SELECT id, nome, email FROM ALUNO";
        try(final PreparedStatement ps = connection.prepareStatement(sql); final ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                alunos.add(new FabricaDeAluno().comNomeCPFEmail(rs.getString("nome"), rs.getString("id"), rs.getString("email")).criar());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    @Override
    public void close() throws Exception {
        if(connection == null){
            return;
        }
        connection.close();
    }
}
