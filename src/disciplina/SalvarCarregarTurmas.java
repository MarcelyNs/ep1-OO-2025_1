package disciplina;

import java.io.*;
import java.util.List;

public class SalvarCarregarTurmas {

    public static void salvarTurmas(String nomeArquivo, List<Turma> turmas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write("Professor|CodigoDisciplina|Semestre|FormaAvaliacao|Presencial|Sala|Horario|Capacidade|AlunosMatriculados");
            bw.newLine();

            for (Turma t : turmas) {
  
                String alunos = String.join(",", t.getAlunosMatriculados());

                bw.write(String.format("%s|%s|%s|%s|%b|%s|%s|%d|%s",
                    t.getProfessor(),
                    t.getDisciplina().getCodigo(),
                    t.getSemestre(),
                    t.getFormaDeAvaliacao(),
                    t.isPresencial(),
                    t.isPresencial() ? t.getSala() : "",
                    t.getHorario(),
                    t.getCapacidadeMaxima(),
                    alunos
                ));
                bw.newLine();
            }
            System.out.println("\nTurmas salvas com sucesso! ");
            System.out.println("Arquivo salvo em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("\n Erro ao salvar turmas: " + e.getMessage());
        }
    }

    public static void carregarTurmas(String nomeArquivo, List<Turma> turmas, List<Disciplina> disciplinas) {
        turmas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine(); 

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length < 9) continue;

                String professor = partes[0].trim();
                String codigoDisciplina = partes[1].trim();
                String semestre = partes[2].trim();
                String formaAvaliacao = partes[3].trim();
                boolean presencial = Boolean.parseBoolean(partes[4].trim());
                String sala = partes[5].trim();
                String horario = partes[6].trim();
                int capacidade = Integer.parseInt(partes[7].trim());
                String alunosStr = partes[8].trim();

                Disciplina disciplina = null;
                for (Disciplina d : disciplinas) {
                    if (d.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                        disciplina = d;
                        break;
                    }
                }
                if (disciplina == null) {
                    System.out.println("Disciplina " + codigoDisciplina + " não encontrada para a turma do professor " + professor);
                    continue;
                }

                Turma turma = new Turma(professor, disciplina, semestre, formaAvaliacao, presencial, sala, horario, capacidade);

                if (!alunosStr.isEmpty()) {
                    String[] alunos = alunosStr.split(",");
                    for (String aluno : alunos) {
                        turma.matricularAluno(aluno.trim());
                    }
                }

                turmas.add(turma);
            }
            System.out.println("\nTurmas carregadas com sucesso!");
            System.out.println("Arquivo carregado de: " + nomeArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo de turmas não encontrado. Nenhuma turma carregada.");
        } catch (IOException e) {
            System.out.println("\n👎 Erro ao carregar turmas: " + e.getMessage());
        }
    }
}


