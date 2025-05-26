package avaliação;

import util.EntradaUsuario;

import java.util.List;

import alunos.AlunoEspecial;
import alunos.CadastrarAlunos;
import disciplina.Turma;
import util.ListaTurmas;
import util.ModeloDeModos;

public class ModoAvaliacao extends ModeloDeModos {

    @Override
    public void ExecutarModoEscolhido() {
        System.out.println("\n_____Modo Avaliação/Frequência_____");
        System.out.println("\nOpções:\n" +
                "| 1 - Lançar notas e frequência\n" +
                "| 2 - Relatórios por turma\n" +
                "| 3 - Relatórios por disciplina\n" +
                "| 4 - Relatórios por professor\n" +
                "| 5 - Boletim\n");

        int escolha = EntradaUsuario.lerInt("\n°Escolha uma opção: ");
        switch (escolha) {
            case 1:
                lancarNotasEFrequencia();
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            case 2:
                relatorioPorTurma();
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            case 3:
                relatorioPorDisciplina();
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            case 4:
                relatorioPorProfessor();
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            case 5:
                boletimPorAluno();
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            case 0:
                System.out.println("Saindo do modo Avaliação...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
    private void lancarNotasEFrequencia() {
        String codigo = EntradaUsuario.lerString("\n°Código da disciplina: ");
        String semestre = EntradaUsuario.lerString("\n°Semestre: ");
        
        for (Turma t : ListaTurmas.getTurmas()) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigo) &&
                    t.getSemestre().equalsIgnoreCase(semestre)) {

                System.out.println("\nTurma encontrada! Lançando notas e frequência...");
                for (String matricula : t.getAlunosMatriculados()) {
                    boolean isEspecial = false;

                    for (AlunoEspecial ae : CadastrarAlunos.getAlunosEspeciais()) {
                        if (ae.getMatricula().equalsIgnoreCase(matricula)) {
                            isEspecial = true;
                            break;
                        }
                    }

                    System.out.println("\nAluno: " + matricula);

                    if (isEspecial) {
                        System.out.println("Aluno Especial: não recebe notas, apenas presença.");
                        double freq = EntradaUsuario.lerDouble("Frequência (%): ");
                        t.getLancarNotasPresencas().lancarPresenca(matricula, freq);
                    } else {
                        double p1 = EntradaUsuario.lerDouble("Nota P1: ");
                        double p2 = EntradaUsuario.lerDouble("Nota P2: ");
                        double p3 = EntradaUsuario.lerDouble("Nota P3: ");
                        double l = EntradaUsuario.lerDouble("Nota Listas: ");
                        double s = EntradaUsuario.lerDouble("Nota Seminário: ");
                        double freq = EntradaUsuario.lerDouble("Frequência (%): ");

                        t.getLancarNotasPresencas().lancarNotas(matricula, p1, p2, p3, l, s);
                        t.getLancarNotasPresencas().lancarPresenca(matricula, freq);
                    }
                }
                System.out.println("Lançamento concluído!");
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }
    private void relatorioPorTurma() {
        System.out.println("\n_____Relatório por turma_____");
        String codigo = EntradaUsuario.lerString("\n°Código da disciplina: ");
        String semestre = EntradaUsuario.lerString("\n°Semestre: ");

        for (Turma t : ListaTurmas.getTurmas()) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigo) &&
                t.getSemestre().equalsIgnoreCase(semestre)) {

                System.out.println("\nTurma: " + t.getDisciplina().getNomeDaMateria() + " | Semestre: " + t.getSemestre());
                for (String m : t.getAlunosMatriculados()) {
                    double media = t.getLancarNotasPresencas().calcularMedia(m);
                    double freq = t.getLancarNotasPresencas().getPresenca(m);
                    String status = t.getLancarNotasPresencas().verificarStatus(m);
                    System.out.println("Aluno: " + m + " | Média: " + media + " | Frequência: " + freq + "% | Status: " + status);
                }
                return; 
            }
        }
        System.out.println("\nTurma não encontrada.");
    }
    private void relatorioPorDisciplina() {
    	System.out.println("\n_____Relatórios por disciplina_____");
        String codigo = EntradaUsuario.lerString("\n°Código da disciplina: ");
        for (Turma t : ListaTurmas.getTurmas()) {
            if (t.getDisciplina().getCodigo().equalsIgnoreCase(codigo)) {
                relatorioPorTurmaUnica(t);
            }
        }
    }

    private void relatorioPorTurmaUnica(Turma t) {
    	System.out.println("\n_____Relatórios por turma_____");
        System.out.println("\nTurma: " + t.getDisciplina().getNomeDaMateria() + " | Semestre: " + t.getSemestre());
        for (String m : t.getAlunosMatriculados()) {
            double media = t.getLancarNotasPresencas().calcularMedia(m);
            double freq = t.getLancarNotasPresencas().getPresenca(m);
            String status = t.getLancarNotasPresencas().verificarStatus(m);
            System.out.println("Aluno: " + m + " | Média: " + media + " | Frequência: " + freq + "% | Status: " + status);
        }
    }
    private void relatorioPorProfessor() {
    	System.out.println("\n_____Relatórios por professor_____");
        String prof = EntradaUsuario.lerString("\n°Nome do professor: ");
        for (Turma t : ListaTurmas.getTurmas()) {
            if (t.getProfessor().equalsIgnoreCase(prof)) {
                relatorioPorTurmaUnica(t);
            }
        }
    }
    private void boletimPorAluno() {
    	System.out.println("\n_____Boletim_____");
        String matricula = EntradaUsuario.lerString("\n°Matrícula do aluno: ");
        List<Turma> turmas = ListaTurmas.getTurmas();

        for (Turma t : turmas) {
            if (t.getAlunosMatriculados().contains(matricula)) {
                System.out.println("\nSemestre: " + t.getSemestre());
                System.out.println("Disciplina: " + t.getDisciplina().getNomeDaMateria());
                System.out.println("Professor: " + t.getProfessor());
                System.out.println("Presencial: " + (t.isPresencial() ? "Sim" : "Não"));
                System.out.println("Carga Horária: " + t.getDisciplina().getCargaHoraria());

                double media = t.getLancarNotasPresencas().calcularMedia(matricula);
                double freq = t.getLancarNotasPresencas().getPresenca(matricula);
                String status = t.getLancarNotasPresencas().verificarStatus(matricula);

                System.out.println("Média Final: " + media);
                System.out.println("Frequência: " + freq + "%");
                System.out.println("Status: " + status);
                System.out.println("─────────────────────────────────────────────");
            }
        }
    }

}
