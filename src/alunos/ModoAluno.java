package alunos;

import java.io.File;
import java.util.Scanner;
import util.ListaAlunos;
import util.ModeloDeModos;
import util.EntradaUsuario;

public class ModoAluno extends ModeloDeModos {
    @Override
    public void ExecutarModoEscolhido() {
        System.out.println("\n_____Modo Aluno_____");
        System.out.println("\nOpções:\n"
        		+ " \n| 1 - Cadastrar Aluno\n"
        		+ " \n| 2 - Listas de Alunos\n"
        		+ " \n| 3 - Matricular Aluno\n"
        		+ " \n| 4 - Trancar disciplinas e semestre\n"
        		+ " \n| 5 - Salvar e carregar os dados");

        Scanner sc = EntradaUsuario.getScanner();
        System.out.print("\n°Escolha uma opção: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
            	boolean continuar = true;
                while (continuar) {
                    CadastrarAlunos.CadastrarAlunoNovo();
                    while (true) {
                        String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                        if (resposta.equals("sim")) {
                            System.out.println("\n--------------------------------------------------------------------------------");
                            continuar = false; 
                            break;
                        } else if (resposta.equals("não") || resposta.equals("nao")) {
                            System.out.println("\n--------------------------------------------------------------------------------");
                            break; 
                        } else {
                            System.out.println("\n Por gentileza, tente novamente e escolha entre: 'sim' ou 'não'.");
                        }
                    }
                }
                break;

            case 2:
                ListaAlunos.listarTodosOsAlunos(
                        CadastrarAlunos.getAlunosRegulares(),
                        CadastrarAlunos.getAlunosEspeciais()
                );
                System.out.println("\n--------------------------------------------------------------------------------");
                break;

            case 3:
            	boolean continuar1 = true;
                while (continuar1) {
                    MatricularAlunos.matricularAlunoEmTurma(
                            CadastrarAlunos.getAlunosRegulares(),
                            CadastrarAlunos.getAlunosEspeciais()
                    );

                    while (true) {
                        String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                        if (resposta.equals("sim")) {
                            System.out.println("\n--------------------------------------------------------------------------------");
                            continuar1 = false; 
                            break;
                        } else if (resposta.equals("não") || resposta.equals("nao")) {
                            System.out.println("\n--------------------------------------------------------------------------------");
                            break; 
                        } else {
                            System.out.println("\n Por gentileza, tente novamente e escolha entre: 'sim' ou 'não'.");
                        }
                }
                }
                break;

            case 4:
                System.out.println("\n|1 - Trancar disciplina específica");
                System.out.println("|2 - Trancar semestre inteiro");
                int escolhaTrancar = EntradaUsuario.lerInt("\n°Escolha uma opção: ");

                if (escolhaTrancar == 1) {
                	boolean continuar11 = true;
                    while (continuar11) {
                        TrancarDisciplinas.trancarDisciplina();
                        while (true) {
                            String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                            if (resposta.equals("sim")) {
                                System.out.println("\n--------------------------------------------------------------------------------");
                                continuar11 = false; 
                                break;
                            } else if (resposta.equals("não") || resposta.equals("nao")) {
                                System.out.println("\n--------------------------------------------------------------------------------");
                                break; 
                            } else {
                                System.out.println("\n Por gentileza, tente novamente e escolha entre: 'sim' ou 'não'.");
                            }
                        }
                    }
                } 
                if (escolhaTrancar == 2) {
                    boolean continuar11 = true;

                    while (continuar11) {
                        TrancarDisciplinas.trancarSemestre();

                        while (true) {
                            String resposta = EntradaUsuario.lerString("\n°Deseja voltar? (sim/não): ").toLowerCase();

                            if (resposta.equals("sim")) {
                                System.out.println("\n--------------------------------------------------------------------------------");
                                continuar11 = false; 
                                break;
                            } else if (resposta.equals("não") || resposta.equals("nao")) {
                                System.out.println("\n--------------------------------------------------------------------------------");
                                break; 
                            } else {
                                System.out.println("\n Por gentileza, tente novamente e escolha entre: 'sim' ou 'não'.");
                            }
                        }
                    }
                }
                else {
                    System.out.println("\nOpção inválida.");
                }
                break;

            case 5:
                String nomeArquivo = "dados" + File.separator + "alunos.txt";

                boolean opcaoValida = false;
                while (!opcaoValida) {
                    System.out.println("\n|1 - Salvar Alunos");
                    System.out.println("|2 - Carregar Alunos");

                    int escolhaSalvarOuCarregar = EntradaUsuario.lerInt("\n°Escolha uma opção: ");

                    if (escolhaSalvarOuCarregar == 1) {
                        SalvarCarregarAlunos.salvarAlunos(
                                nomeArquivo,
                                CadastrarAlunos.getAlunosRegulares(),
                                CadastrarAlunos.getAlunosEspeciais()
                        );
                        opcaoValida = true;

                    } else if (escolhaSalvarOuCarregar == 2) {
                        SalvarCarregarAlunos.carregarAlunos(
                                nomeArquivo,
                                CadastrarAlunos.getAlunosRegulares(),
                                CadastrarAlunos.getAlunosEspeciais()
                        );

                        while (true) {
                            String visualizar = EntradaUsuario.lerString("\n°Deseja visualizar os dados carregados? (sim/não): ").toLowerCase();

                            if (visualizar.equals("sim")) {
                                System.out.println("\nLista de alunos carregados:");
                                ListaAlunos.listarTodosOsAlunos(
                                        CadastrarAlunos.getAlunosRegulares(),
                                        CadastrarAlunos.getAlunosEspeciais()
                                );
                                break;

                            } else if (visualizar.equals("não") || visualizar.equals("nao")) {
                                System.out.println("\nDados carregados com sucesso, mas não foram exibidos.");
                                break;

                            } else {
                                System.out.println("\n Resposta inválida! Por favor, responda apenas com 'sim' ou 'não'.");
                            }
                        }
                        opcaoValida = true;

                    } else {
                        System.out.println("\nOpção inválida! Por favor, tente novamente.");
                    }
                }
                System.out.println("\n--------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
}