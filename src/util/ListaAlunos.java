package util;
import java.util.List;
import alunos.Aluno;
import alunos.AlunoEspecial; 
public class ListaAlunos {
	public static void listarTodosOsAlunos(List<Aluno> regulares, List<AlunoEspecial> especiais) {
		   System.out.println("\n_____________Listas de Alunos__________________");
	    System.out.println("\n Alunos Regulares:");
	    if (regulares.isEmpty()) {
	        System.out.println("\nNenhum aluno regular cadastrado.");
	    } else {
	        for (Aluno a : regulares) {
	            System.out.println("\n|Nome: " + a.getNome());
	            System.out.println("\n|Matrícula: " + a.getMatricula());
	            System.out.println("\n|Curso: " + a.getCurso());
	            System.out.println("──────────────────────────────────────────────────────\n");;
	        }
	    }
	    
	    System.out.println("\n Alunos Especiais:");
	    if (especiais.isEmpty()) {
	        System.out.println("\nNenhum aluno especial cadastrado.");
	    } else {
	        for (AlunoEspecial ae : especiais) {
	            System.out.println("\n|Nome: " + ae.getNome());
	            System.out.println("\n|Matrícula: " + ae.getMatricula());
	            System.out.println("\n|Curso: " + ae.getCurso());
	            System.out.println("\n|Restrições: máximo 2 disciplinas, sem notas");
	            System.out.println("──────────────────────────────────────────────────────\n");;	        }
	    }
	}


}
