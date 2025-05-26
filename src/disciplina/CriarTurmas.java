package disciplina;
import java.util.List;

import util.EntradaUsuario;
import util.ListaDisciplinas;
import util.ListaTurmas;

public class CriarTurmas {
    public static void cadastrarTurmaNova() {
        System.out.println("\n_____Cadastrar Turma_____");

        String codigoDisciplina;
        Disciplina disciplina = null;
        while (true) {
            codigoDisciplina = EntradaUsuario.lerString("\n°Código da disciplina: ");
            disciplina = ListaDisciplinas.AcharCodigo(codigoDisciplina);
            if (disciplina == null) {
                System.out.println("Disciplina não encontrada. Tente novamente.");
            } else {
                break;
            }
        }

        String professor = EntradaUsuario.lerString("\n°Professor responsável: ");
        String semestre = EntradaUsuario.lerString("\n°Semestre (ex: 2023.1): ");
        String formaAvaliacao = null;

        while (true) {
            System.out.println("\nOpções de forma de avaliação:");
            System.out.println("a) Media Final = (P1 + P2 + P3 + L + S) / 5");
            System.out.println("b) Media Final = (P1 + P2 * 2 + P3 * 3 + L + S) / 8");
            String opcao = EntradaUsuario.lerString("\n°Escolha uma opção: ");
            if (opcao.equals("a")) {
                formaAvaliacao = "Media Final = (P1 + P2 + P3 + L + S) / 5";
                break;
            } else if (opcao.equals("b")) {
                formaAvaliacao = "Media Final = (P1 + P2 * 2 + P3 * 3 + L + S) / 8";
                break;
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
                continue;
            }
        }

        boolean presencial = false;
        while (true) {
            String resposta = EntradaUsuario.lerString("\n°Turma presencial? (sim/não): ").toLowerCase();
            if (resposta.equals("sim")) {
                presencial = true;
                break;
            } 
            if (resposta.equals("não") || resposta.equals("nao")) {
                presencial = false;
                break;
            } else {
                System.out.println("\n Por gentileza, tente novamente e escolha entre as opções: 'sim' ou 'não'.");
                continue;
            }
        }

        String sala = "";
        if (presencial) {
            sala = EntradaUsuario.lerString("\n°A sala será: ");
        }

        String horario = "";
        List<Turma> turmas = ListaTurmas.getTurmas();

        while (true) {
            horario = EntradaUsuario.lerString("\n°Informe o horário (ex: Seg 18h-20h): ");
            boolean conflitoProfessor = false;
            boolean conflitoSala = false;

            for (Turma t : turmas) {
                if (t.getSemestre().equalsIgnoreCase(semestre)) {
                    if (t.getProfessor().equalsIgnoreCase(professor) &&
                        t.getHorario().equalsIgnoreCase(horario)) {
                        conflitoProfessor = true;
                    }
                    if (presencial && t.isPresencial() &&
                        t.getSala().equalsIgnoreCase(sala) &&
                        t.getHorario().equalsIgnoreCase(horario)) {
                        conflitoSala = true;
                    }
                }
            }

            if (conflitoProfessor) {
                System.out.println("\nO professor já possui uma turma nesse horário e semestre! Por favor, informe outro horário.");
                continue;
            } 
            if (conflitoSala) {
                System.out.println("\nJá existe uma turma nessa sala e horário no mesmo semestre. Por favor, informe outro horário.");
                continue;
            } 
            else {
                break; 
            }
        }

        int capacidade = EntradaUsuario.lerInt("\n°Capacidade máxima de alunos: ");

        Turma novaTurma = new Turma(professor, disciplina, semestre, formaAvaliacao, presencial, sala, horario, capacidade);

        ListaTurmas.adicionar(novaTurma);
        System.out.println("\nTurma cadastrada com sucesso!");
    }
}	