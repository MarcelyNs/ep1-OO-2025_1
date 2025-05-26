package util;

import java.util.ArrayList;
import java.util.List;
import disciplina.Turma;

public class ListaTurmas {
    private static List<Turma> turmas = new ArrayList<>();

    public static boolean adicionar(Turma turma) {
        for (Turma t : turmas) {
            if (t.getDisciplina().getCodigo().equals(turma.getDisciplina().getCodigo())
                && t.getHorario().equals(turma.getHorario())
                && t.getSemestre().equals(turma.getSemestre())) {
                return false; 
            }
        }
        turmas.add(turma);
        return true;
    }

    public static List<Turma> getTurmas() {
        return turmas;
    }
    
    public static void limparTurmas() {
        turmas.clear();
    }
}