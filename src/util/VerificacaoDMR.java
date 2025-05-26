package util;

import java.util.List;
import alunos.Aluno;
import alunos.AlunoEspecial;
import disciplina.Turma;

public class VerificacaoDMR {
	public static boolean verifica(Aluno aluno, Turma turma) {
        
        if (turma.getAlunosMatriculados().size() >= turma.getCapacidadeMaxima()) {
            System.out.println("Turma cheia. Não há vagas disponíveis.");
            return false;
        }
        if (turma.getAlunosMatriculados().contains(aluno.getMatricula())) {
            System.out.println("Aluno já está matriculado nesta turma.");
            return false;
        }

        List<disciplina.Disciplina> preReqs = turma.getDisciplina().getPreRequisitos();
        for (disciplina.Disciplina pre : preReqs) {
            if (!aluno.verificarDisciplinaAprovada(pre)) {
                System.out.printf("Aluno não cumpriu o pré-requisito: %s\n", pre.getNomeDaMateria());
                return false;
            }
        }

        if (aluno instanceof AlunoEspecial) {
            int qtdMatriculas = aluno.getTurmasMatriculadas().size();
            if (qtdMatriculas >= 2) {
                   System.out.println("Aluno Especial já está matriculado em 2 disciplinas. Não pode matricular mais.");
                return false;
            }
        }

        boolean sucessoMatricula = turma.matricularAluno(aluno.getMatricula());
        if (!sucessoMatricula) {
            System.out.println("Erro ao matricular aluno na turma.");
            return false;
        }

       
        aluno.adicionarTurma(turma);
        return true;
    }
}


