package alunos;

import java.util.List;

import disciplina.Disciplina;
import disciplina.Turma;
import util.EntradaUsuario;
import util.ListaDisciplinas;
import util.ListaTurmas;
import util.VerificacaoDMR;

public class MatricularAlunos {
    public static void matricularAlunoEmTurma(List<Aluno> regulares, List<AlunoEspecial> especiais) {
        System.out.println("\n_____Matrícula de Aluno em Turma_____");
        String matricula = EntradaUsuario.lerString("\n°Matrícula do aluno: ");
        Aluno aluno = null;

        for (Aluno a : regulares) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                aluno = a;
                break;
            }
        }

        if (aluno == null) {
            for (AlunoEspecial ae : especiais) {
                if (ae.getMatricula().equalsIgnoreCase(matricula)) {
                    aluno = ae;
                    break;
                }
            }
        }

        if (aluno == null) {
            System.out.println("\nAluno não encontrado.");
            return;
        }

        String codigoDisciplina = EntradaUsuario.lerString("\n°Código da disciplina: ");
        Disciplina disciplina = ListaDisciplinas.AcharCodigo(codigoDisciplina);

        if (disciplina == null) {
            System.out.println("\nDisciplina não encontrada.");
            return;
        }

        List<Turma> turmas = ListaTurmas.getTurmas();
        int count = 0;

        System.out.println("\nOpções de turmas disponíveis da disciplina " + disciplina.getNomeDaMateria() + ":");
        for (Turma t : turmas) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                System.out.println("| " + (++count) + " - Professor: " + t.getProfessor() +
                        " | Horário: " + t.getHorario() +
                        " | Semestre: " + t.getSemestre() +
                        " | Vagas: " + (t.getCapacidadeMaxima() - t.getAlunosMatriculados().size()));
            }
        }

        if (count == 0) {
            System.out.println("\nNenhuma turma disponível para essa disciplina.");
            return;
        }

        int opcao = EntradaUsuario.lerInt("\n °Escolha uma opção: ");
        count = 0;
        Turma turmaEscolhida = null;

        for (Turma t : turmas) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                count++;
                if (count == opcao) {
                    turmaEscolhida = t;
                    break;
                }
            }
        }

        if (turmaEscolhida == null) {
            System.out.println("\nOpção inválida! Tente novamente.");
            return;
        }

        boolean sucesso = VerificacaoDMR.verifica(aluno, turmaEscolhida);
        if (sucesso) {
            System.out.println("Matrícula realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a matrícula.");
        }
    }
}