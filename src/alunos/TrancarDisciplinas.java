package alunos;
import util.AcharAlunoNM;
import util.EntradaUsuario;
import disciplina.Turma;
import java.util.Iterator;
public class TrancarDisciplinas {
	public static void trancarDisciplina() {
		System.out.println("_____Trancar Disciplina_____");
		 String matricula = EntradaUsuario.lerString("\n°Matrícula do aluno: ");
		 Aluno aluno = AcharAlunoNM.buscarPorMatricula(
		            matricula, 
		            CadastrarAlunos.getAlunosRegulares(), 
		            CadastrarAlunos.getAlunosEspeciais()
		        );
	        if (aluno == null) {
	            System.out.println("\nAluno não encontrado, por favor tente novamente.");
	            return;
	        }

	        if (aluno.getTurmasMatriculadas().isEmpty()) {
	            System.out.println("\nAluno não está matriculado em nenhuma disciplina. ");
	            return;
	        }

        System.out.println("\nDisciplinas matriculadas:");
        int i = 1;
        for (Turma t : aluno.getTurmasMatriculadas()) {
            System.out.println("| " + i + " - " + t.getDisciplina().getNomeDaMateria() + 
                               "\n | Código: " + t.getDisciplina().getCodigo() + 
                               "\n | Semestre: " + t.getSemestre());
            i++;
        }

        int opcao = EntradaUsuario.lerInt("\n°Selecione o número da disciplina que deseja trancar: ");

        if (opcao < 1 || opcao > aluno.getTurmasMatriculadas().size()) {
            System.out.println("\nOpção inválida! Tente novamente.");
            return;
        }

        Turma turma = aluno.getTurmasMatriculadas().get(opcao - 1);

        turma.getAlunosMatriculados().remove(aluno.getMatricula());

 
        aluno.getTurmasMatriculadas().remove(turma);

        System.out.println("\nDisciplina trancada com sucesso!");
    }

	 public static void trancarSemestre() {
		 System.out.println("\n_____Trancacar Semestre_____");
	        String matricula = EntradaUsuario.lerString("\n°Matrícula do aluno: ");
	        Aluno aluno = AcharAlunoNM.buscarPorMatricula(
	            matricula, 
	            CadastrarAlunos.getAlunosRegulares(), 
	            CadastrarAlunos.getAlunosEspeciais()
	        );

	        if (aluno == null) {
	            System.out.println("\nAluno não encontrado, por favor tente novamente.");
	            return;
	        }
	        boolean trancouAlgo = false;
	        String semestre = EntradaUsuario.lerString("Digite o semestre que deseja trancar (ex: 2024.1): ");

	        Iterator<Turma> iterator = aluno.getTurmasMatriculadas().iterator();
	        while (iterator.hasNext()) {
	            Turma t = iterator.next();
	            if (t.getSemestre().equalsIgnoreCase(semestre)) {
	                t.getAlunosMatriculados().remove(aluno.getMatricula());
	                iterator.remove();
	                trancouAlgo = true;
	            }
	        }

	        if (trancouAlgo) {
	            System.out.println("\nTodas as disciplinas do semestre " + semestre + " foram trancadas com sucesso! ");
	        } 
	        else {
	            System.out.println("\nAluno não possui disciplinas matriculadas nesse semestre. ");
	        }
	    }
	}


