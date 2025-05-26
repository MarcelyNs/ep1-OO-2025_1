package alunos;
import java.util.ArrayList;

import util.EntradaUsuario;
import java.util.List;

public class CadastrarAlunos {
	private static List<Aluno> alunosRegulares = new ArrayList<>();
    private static List<AlunoEspecial> alunosEspeciais = new ArrayList<>();
    
    public static List<Aluno> getAlunosRegulares() {
        return alunosRegulares;
    }
    public static List<AlunoEspecial> getAlunosEspeciais() {
        return alunosEspeciais;
    }
    
   
    public static void CadastrarAlunoNovo() {
        System.out.println("\n_____Cadastrar Aluno_____");
    
    	 String matricula = " ";
    	 while (true) {
    		 matricula = EntradaUsuario.lerString("\n°Informe a matrícula do discente: ");
             
    		 if(! (matricula.length() == 9 && matricula.matches("\\d{9}"))) {
            	 System.out.println("\n Matrícula inválida! A matricula deve conter apenas 9 digitos.");
            	 continue;
             }
             
             boolean matriculaUnica = true;
             for (Aluno a : alunosRegulares) {
                 if (a.getMatricula().equals(matricula)) {
                     matriculaUnica = false;
                     break;
                 }
             }
             for (AlunoEspecial ae : alunosEspeciais) {
                 if (ae.getMatricula().equals(matricula)) {
                     matriculaUnica = false;
                     break;
                 }
             }
             if (matriculaUnica) {
            	 break;
            	 }
             else {
            	 System.out.println("\n Matrícula já cadastrada! Por favor, tente novamente."); 
             }
             }
    	     
    	 String nome = EntradaUsuario.lerString("\n° Nome completo do discente: ");
         String curso = EntradaUsuario.lerString("\n° Curso no qual o discente está inscrito: ");
        
        while(true) {
        	System.out.println("\n° O discente é de regime especial? (sim/não): ");
            String resposta = EntradaUsuario.lerString("Resposta:").toLowerCase();;
       
            if (resposta.equals("sim")) {
                AlunoEspecial alunoEsp = new AlunoEspecial(nome, matricula, curso);
                alunosEspeciais.add(alunoEsp);
                System.out.println("\nAluno cadastrado com sucesso!🎉");
                break;
            } 
            if(resposta.equals("não")||resposta.equals ("nao")) {
                Aluno aluno = new Aluno(nome, matricula, curso);
                alunosRegulares.add(aluno);
                System.out.println("\nAluno(a) cadastrado com sucesso!");
                break;
            }
            else {
            	System.out.println("\n Por gentileza, tente novamente e escolha entre as opções: 'sim' ou 'não'.");
            	continue;
            }
            
        }
        	
        
	}

	}



