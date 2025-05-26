package avaliação;

import java.util.HashMap;
import java.util.Map;
import disciplina.Turma;
import alunos.CadastrarAlunos;
import alunos.AlunoEspecial;

public class LancarNotasPresencas {
    private Turma turma;

    private Map<String, double[]> notas;
    private Map<String, Double> presencas;

    public LancarNotasPresencas(Turma turma) {
        this.turma = turma;
        this.notas = new HashMap<>();
        this.presencas = new HashMap<>();
    }

    private boolean isAlunoEspecial(String matricula) {
        for (AlunoEspecial ae : CadastrarAlunos.getAlunosEspeciais()) {
            if (ae.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }
        return false;
    }

    public void lancarNotas(String matricula, double p1, double p2, double p3, double l, double s) {
        if (isAlunoEspecial(matricula)) {
            System.out.println("Aluno Especial não recebe notas. Apenas presença.");
            return;
        }
        notas.put(matricula, new double[]{p1, p2, p3, l, s});
    }

    public void lancarPresenca(String matricula, double frequencia) {
        presencas.put(matricula, frequencia);
    }

    public double calcularMedia(String matricula) {
        if (isAlunoEspecial(matricula)) {
            return 0.0; 
     }

        double[] n = notas.get(matricula);
        if (n == null) return 0;

        String forma = turma.getFormaDeAvaliacao();
        if (forma.contains("/ 5")) {
            return (n[0] + n[1] + n[2] + n[3] + n[4]) / 5.0;
        } else if (forma.contains("/ 8")) {
            return (n[0] + n[1] * 2 + n[2] * 3 + n[3] + n[4]) / 8.0;
        } else {
            return 0;
        }
    }

    public String verificarStatus(String matricula) {
        Double freq = presencas.get(matricula);
        if (freq == null) return "Sem dados de frequência.";

        if (isAlunoEspecial(matricula)) {
            if (freq < 75.0) {
                return "Reprovado por falta";
            } else {
                return "Aprovado";
            }
        } else {
            double media = calcularMedia(matricula);
            if (media < 5.0) return "Reprovado por nota";
            if (freq < 75.0) return "Reprovado por falta";
            return "Aprovado";
        }
    }

    public double getPresenca(String matricula) {
        return presencas.getOrDefault(matricula, 0.0);
    }

    public double[] getNotas(String matricula) {
        return notas.getOrDefault(matricula, new double[]{0, 0, 0, 0, 0});
    }
}