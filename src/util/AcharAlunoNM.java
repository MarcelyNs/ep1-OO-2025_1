package util;
import java.util.List;
import alunos.Aluno;
import alunos.AlunoEspecial;

public class AcharAlunoNM {
	public static Aluno buscarPorMatricula(String matricula, List<Aluno> regulares, List<AlunoEspecial> especiais) {
        for (Aluno a : regulares) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                return a;
            }
        }
        for (AlunoEspecial ae : especiais) {
            if (ae.getMatricula().equalsIgnoreCase(matricula)) {
                return ae;
            }
        }
        return null; 
    }
}
