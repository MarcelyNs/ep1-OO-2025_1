package disciplina;

import util.ModeloDeModos;

import java.io.File;

import util.EntradaUsuario;
import util.ListaDisciplinas;
import util.ListaTurmas;

public class ModoDisciplina extends ModeloDeModos {
    @Override
    public void ExecutarModoEscolhido() {
        System.out.println("\n_____Modo Disciplina_____");
        System.out.println("\nOpções:\n"
        		+ " \n| 1- Cadastrar Disciplina\n"
                + " \n| 2- Criar turmas\n"
                + " \n| 3- Listar turmas disponíveis\n"
                + " \n| 4- Salvar e carregar os dados");

        int escolha = EntradaUsuario.lerInt("\n°Escolha uma opção: ");

        switch (escolha) {
            case 1:
                while (true) {
                    CadastrarDisciplina.cadastrarDisciplinaNova();
                    String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                    if (resposta.equals("sim")) {
                        System.out.println("\n--------------------------------------------------------------------------------");
                        break;
                    } else if (resposta.equals("não") || resposta.equals("nao")) {
                        System.out.println("\n--------------------------------------------------------------------------------");
                        continue;
                    } else {
                        System.out.println("\n Por gentileza, tente novamente e escolha entre as opções: 'sim' ou 'não'.");
                    }
                }
                break;

            case 2:
                while (true) {
                    CriarTurmas.cadastrarTurmaNova();
                    String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                    if (resposta.equals("sim")) {
                        System.out.println("\n--------------------------------------------------------------------------------");
                        break;
                    } else if (resposta.equals("não") || resposta.equals("nao")) {
                        System.out.println("\n--------------------------------------------------------------------------------");
                        continue;
                    } else {
                        System.out.println("\n Por gentileza, tente novamente e escolha entre as opções: 'sim' ou 'não'.");
                    }
                }
                break;

            case 3:
                ListarTurmas.listarTurmasDisponiveis();
                break;

            case 4:
                String nomeArquivo = "dados" + File.separator + "turmasDisciplina.txt";

                boolean opcaoValidaTurma = false;
                while (!opcaoValidaTurma) {
                    System.out.println("\n|1 - Salvar Disciplinas e Turmas");
                    System.out.println("|2 - Carregar Disciplinas e Turmas");

                    int escolhaSalvarOuCarregar = EntradaUsuario.lerInt("\n°Escolha uma opção: ");

                    if (escolhaSalvarOuCarregar == 1) {
                        SalvarCarregarDisciplinaTurma.salvar(
                            nomeArquivo,
                            ListaDisciplinas.getDisciplinas(),
                            ListaTurmas.getTurmas()
                        );
                        System.out.println("\nDados de Disciplinas e Turmas salvos com sucesso! ");
                        System.out.println("Arquivo salvo: " + nomeArquivo);
                        opcaoValidaTurma = true;

                    } else if (escolhaSalvarOuCarregar == 2) {
                        SalvarCarregarDisciplinaTurma.carregar(nomeArquivo);
                        System.out.println("\nDados de Disciplinas e Turmas carregados com sucesso! ");
                        System.out.println("Arquivo carregado: " + nomeArquivo);

                        while (true) {
                            String visualizar = EntradaUsuario.lerString("\n°Deseja visualizar os dados carregados? (sim/não): ").toLowerCase();

                            if (visualizar.equals("sim")) {
                                System.out.println("\nLista de Disciplinas:");
                                ListaDisciplinas.listarTodasDisciplinas();

                                System.out.println("\nLista de Turmas:");
                                for (Turma turma : ListaTurmas.getTurmas()) {
                                    turma.exibirInformacoes();
                                }
                                break;

                            } else if (visualizar.equals("não") || visualizar.equals("nao")) {
                                System.out.println("\nDados carregados com sucesso, mas não foram exibidos.");
                                break;

                            } else {
                                System.out.println("\n Resposta inválida! Por favor, responda apenas com 'sim' ou 'não'.");
                            }
                        }
                        opcaoValidaTurma = true;

                    } else {
                        System.out.println("\nOpção inválida! Por favor, tente novamente.");
                    }
                }
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");

        }
    }
}