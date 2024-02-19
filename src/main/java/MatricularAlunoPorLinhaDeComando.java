import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.dominio.repositorio.RepositorioAlunos;
import br.com.alura.escola.infra.aluno.RepositorioAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        final RepositorioAlunos repositorioAlunos = new RepositorioAlunosEmMemoria();
        final MatricularAluno matricular = new MatricularAluno(repositorioAlunos);
        final MatricularAlunoDTO alunoDTO = new MatricularAlunoDTO("Denis Benjamim", "332.174.618-27", "denis.benjamim@gmail.com");
        
        matricular.executar(alunoDTO);
    }
}
