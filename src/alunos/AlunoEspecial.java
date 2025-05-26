package alunos;

;

public class AlunoEspecial extends Aluno {
    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }
    @Override
    public boolean restricaoDisciplina() {
        return getTurmasMatriculadas().size() < 2;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("\nAluno de Regime Especial:");
        System.out.println("\nNome: " + getNome());
        System.out.println("\nMatrícula: " + getMatricula());
        System.out.println("\nCurso: " + getCurso());
        System.out.println("\nObs: Não recebe notas, apenas presença. Máximo de 2 disciplinas.");
    }
}
