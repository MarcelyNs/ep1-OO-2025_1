package disciplina;
import java.util.List;
import alunos.Aluno;
import alunos.AlunoEspecial;
import util.AcharAlunoNM;
import util.ListaTurmas;

public class ListarTurmas {
	public static void listarTurmasEAlunos(List<Aluno> regulares, List<AlunoEspecial> especiais) {
        System.out.println("\n_____Lista de Turmas Disponíveis_____");

        if (ListaTurmas.getTurmas().isEmpty()) {
            System.out.println("\nNenhuma turma cadastrada.");
            return;
        }

        for (Turma turma : ListaTurmas.getTurmas()) {
            System.out.println("\n Disciplina: " + turma.getDisciplina().getNomeDaMateria());
            System.out.println("Código: " + turma.getDisciplina().getCodigo());
            System.out.println("Professor: " + turma.getProfessor());
            System.out.println("Semestre: " + turma.getSemestre());
            System.out.println("Capacidade Máxima: " + turma.getCapacidadeMaxima());
            System.out.println("Vagas Disponíveis: " + (turma.getCapacidadeMaxima() - turma.getAlunosMatriculados().size()));
            System.out.println("Forma de Avaliação: " + turma.getFormaDeAvaliacao());
            System.out.println("Presencial: " + (turma.isPresencial() ? "Sim" : "Não"));
            System.out.println("Sala: " + (turma.isPresencial() ? turma.getSala() : "Não tem sala"));
            System.out.println("Horário: " + turma.getHorario());

            System.out.println("\n Alunos Matriculados (" + turma.getAlunosMatriculados().size() + "):");

            if (turma.getAlunosMatriculados().isEmpty()) {
                System.out.println("\nNenhum aluno matriculado nesta turma.");
            } else {
                for (String matricula : turma.getAlunosMatriculados()) {
                    Aluno aluno = AcharAlunoNM.buscarPorMatricula(matricula, regulares, especiais);
                    if (aluno != null) {
                        System.out.println("\n| Nome: " + aluno.getNome() + "\n | Matrícula: " + matricula);
                    } else {
                        System.out.println("- Matrícula: " + matricula + " (Aluno não encontrado na lista geral)");
                    }
                }
            }
            System.out.println("─────────────────────────────────────────");
        }
    }
	public static void listarTurmasDisponiveis() {
	    System.out.println("\n_____Lista de Turmas com Vagas Disponíveis_____");
	    if (ListaTurmas.getTurmas().isEmpty()) {
	        System.out.println("\nNenhuma turma cadastrada.");
	        return;
	    }

	    for (Turma turma : ListaTurmas.getTurmas()) {
	        int vagasDisponiveis = turma.getCapacidadeMaxima() - turma.getAlunosMatriculados().size();
	        if (vagasDisponiveis > 0) {
	            System.out.println("\n Disciplina: " + turma.getDisciplina().getNomeDaMateria());
	            System.out.println("Código: " + turma.getDisciplina().getCodigo());
	            System.out.println("Professor: " + turma.getProfessor());
	            System.out.println("Semestre: " + turma.getSemestre());
	            System.out.println("Vagas Disponíveis: " + vagasDisponiveis);
	            System.out.println("Horário: " + turma.getHorario());
	            System.out.println("─────────────────────────────────────────");
	        }
	    }
	}
}


