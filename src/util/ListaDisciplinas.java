package util;

import java.util.ArrayList;
import java.util.List;
import disciplina.Disciplina;

public class ListaDisciplinas {
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public static Disciplina AcharCodigo(String codigo) {
        for (Disciplina ae : disciplinas) {
            if (ae.getCodigo().equalsIgnoreCase(codigo)) {
                return ae;
            }
        }
        return null;
    }

    public static Disciplina AcharNome(String nome) {
        for (Disciplina ae : disciplinas) {
            if (ae.getNomeDaMateria().equalsIgnoreCase(nome)) {
                return ae;
            }
        }
        return null;
    }

    public static boolean adicionar(Disciplina a) {
        disciplinas.add(a);
        return true;
    }

    public static List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public static void adicionarTodas(List<Disciplina> novas) {
        disciplinas.addAll(novas);
    }
    
    public static void limparDisciplinas() {
        disciplinas.clear();
    }

    public static void listarTodasDisciplinas() {
        System.out.println("\n_____Lista de Disciplinas_____");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        for (Disciplina ea : disciplinas) {
            System.out.printf("Matéria: %s | Código: %s | Carga Horária: %d\n",
                ea.getNomeDaMateria(), ea.getCodigo(), ea.getCargaHoraria());
        }
    }
}

