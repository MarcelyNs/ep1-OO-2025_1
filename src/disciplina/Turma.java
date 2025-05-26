package disciplina;

import java.util.ArrayList;
import java.util.List;

import avaliação.LancarNotasPresencas;

public class Turma {
    private String professor;
    private Disciplina disciplina; 
    private String semestre;             
    private String formaDeAvaliacao;       
    private boolean presencial;             
    private String sala;                   
    private String horario;                 
    private int capacidadeMaxima;
    private List<String> alunosMatriculados;
    private LancarNotasPresencas lancarNotasPresencas;

    public Turma(String professor, Disciplina disciplina, String semestre, String formaDeAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.formaDeAvaliacao = formaDeAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? sala : null;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunosMatriculados = new ArrayList<>();
        this.lancarNotasPresencas = new LancarNotasPresencas(this);
    }
    public String getProfessor() {
		return professor;
	}
    public Disciplina getDisciplina() {
		return disciplina;
	}
    public String getSemestre() {
		return semestre;
	}
    public String getFormaDeAvaliacao() {
		return formaDeAvaliacao;
	}
    public boolean isPresencial() {
		return presencial;
	}
    public String getSala() {
		return sala;
	}
    public String getHorario() {
		return horario;
	}
    public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
    public List<String> getAlunosMatriculados() {
		return alunosMatriculados;
	}
    public void setProfessor(String professor) {
		this.professor = professor;
	}
    public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
    public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
    public void setFormaDeAvaliacao(String formaDeAvaliacao) {
		this.formaDeAvaliacao = formaDeAvaliacao;
	}
    public void setPresencial(boolean presencial) {
		this.presencial = presencial;
	}
    public void setSala(String sala) {
		this.sala = sala;
	}
    public void setHorario(String horario) {
		this.horario = horario;
	}
    public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
    public void setLancarNotasPresencas(LancarNotasPresencas lancarNotasPresencas) {
		this.lancarNotasPresencas = lancarNotasPresencas;
	}
    public void setAlunosMatriculados(List<String> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

    public boolean matricularAluno(String matriculaAluno) {
        if (alunosMatriculados.size() >= capacidadeMaxima) {
            return false; 
        }
        if (!alunosMatriculados.contains(matriculaAluno)) {
            alunosMatriculados.add(matriculaAluno);
            return true;
        }
        return false;
    }

    public void exibirInformacoes() {
        System.out.println("\nProfessor que irá ministrar as aulas:" + professor);
        System.out.println("\nDisciplina: " + disciplina.getNomeDaMateria() + " (" + disciplina.getCodigo() + ")");
        System.out.println("\nA forma de avaliação será: " + formaDeAvaliacao);
        System.out.println("\nAula Presencial: " + (presencial ? "Sim" : "Não"));
        System.out.println("\nSala de aula: " + (presencial ? sala : "Não tem Sala"));
        System.out.println("\nHorário: " + horario);
        System.out.println("\nCapacidade máxima: " + capacidadeMaxima);
        System.out.println("\nLista de Alunos matriculados na turma (" + alunosMatriculados.size() + "): " + alunosMatriculados);
    }

    public LancarNotasPresencas getLancarNotasPresencas() {
        return lancarNotasPresencas;
    }
}