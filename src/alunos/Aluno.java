package alunos;

import java.util.ArrayList;
import java.util.List;

import disciplina.Disciplina;
import disciplina.Turma;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private List<Turma> turmasMatriculadas;
    private List<Disciplina> disciplinasAprovadas;  // para controle dos pré-requisitos

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.turmasMatriculadas = new ArrayList<>();
        this.disciplinasAprovadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }
    public void setTurmasMatriculadas(List<Turma> turmasMatriculadas) {
        this.turmasMatriculadas = turmasMatriculadas;
    }
    public List<Disciplina> getDisciplinasAprovadas() {
        return disciplinasAprovadas;
    }
    public void setDisciplinasAprovadas(List<Disciplina> disciplinasAprovadas) {
        this.disciplinasAprovadas = disciplinasAprovadas;
    }

    public void adicionarTurma(Turma turma) {
        if (!turmasMatriculadas.contains(turma)) {
            turmasMatriculadas.add(turma);
        }
    }

    public void adicionarDisciplinaAprovada(Disciplina disciplina) {
        if (!disciplinasAprovadas.contains(disciplina)) {
            disciplinasAprovadas.add(disciplina);
        }
    }

   
    public boolean verificarDisciplinaAprovada(Disciplina disciplina) {
        return disciplinasAprovadas.contains(disciplina);
    }

    
    public boolean restricaoDisciplina() {
        return turmasMatriculadas.size() < 2;
    }

    public void exibirInformacoes() {
        System.out.println("\nAluno Regular:");
        System.out.println("\nNome: " + nome);
        System.out.println("\nMatrícula: " + matricula);
        System.out.println("\nCurso: " + curso);
    }
}