package app;
import alunos.ModoAluno;
import avaliação.ModoAvaliacao;
import java.util.Scanner;
import disciplina.ModoDisciplina;
import util.ModeloDeModos;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) { 
        	System.out.println("\n______Bem-vindo(a) ao Sistema Acadêmico da FCTE!______\n \nOpções:\n \n| 1- Modo Aluno\n \n| 2- Modo Disciplina\n \n| 3- Modo Avaliação\n \n| 4- Finalizar Ação ");
            System.out.println("\n °Escolha uma opção: ");
            int opcao = sc.nextInt(); 
            sc.nextLine();
            ModeloDeModos escolhido = null;
            switch (opcao) {
                case 1:
                   escolhido = new ModoAluno();
                   System.out.println("\nO Modo Aluno foi selecionado");
                    break;

                case 2:
                	escolhido = new ModoDisciplina();
                	System.out.println("\nO Modo Disciplina foi selecionado");
                    break;

                case 3:
                    escolhido = new ModoAvaliacao();
                    System.out.println("\nO Modo Avaliação foi selecionado");
                    break;

                case 4:
                    System.out.println("\nSaindo do sistema...");
                    sc.close();  
                    return; 
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
            
            while (true) {
                escolhido.ExecutarModoEscolhido();
                System.out.println("\n°Deseja voltar ao menu principal? (sim/não): ");
                String resposta = sc.nextLine().toLowerCase();

                if (resposta.equals("sim")) {
                	System.out.println("\n--------------------------------------------------------------------------------");
                    break;
                } 
                if (resposta.equals("não")||resposta.equals("nao")) {
                	System.out.println("\n--------------------------------------------------------------------------------");
                	continue;
                }
                else {
                	System.out.println("\n Por gentileza, tente novamente e escolha entre as opções: 'sim' ou 'não'.");
                	continue;
                }
            }
        }
    }
}


