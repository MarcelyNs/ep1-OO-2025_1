package disciplina;
import util.ListaDisciplinas;
import util.ListaTurmas;

import java.io.*;
import java.util.List;

public class SalvarCarregarDisciplinaTurma {

    public static void salvar(String nomeArquivo, List<Disciplina> disciplinas, List<Turma> turmas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {

            bw.write("DISCIPLINAS");
            bw.newLine();
            bw.write("Codigo|Nome|CargaHoraria");
            bw.newLine();
            
            for (Disciplina d : disciplinas) {
                bw.write(String.format("%s|%s|%d", d.getCodigo(), d.getNomeDaMateria(), d.getCargaHoraria()));
                bw.newLine();
            }

            bw.write("TURMAS");
            bw.newLine();
            bw.write("CodigoDisciplina|Professor|Semestre|FormaAvaliacao|Presencial|Sala|Horario|CapacidadeMaxima");
            bw.newLine();
            
            for (Turma t : turmas) {
                
                String presencialStr = t.isPresencial() ? "sim" : "não";
                String sala = t.isPresencial() ? t.getSala() : "";
                
                bw.write(String.format("%s|%s|%s|%s|%s|%s|%s|%d",
                    t.getDisciplina().getCodigo(),
                    t.getProfessor(),
                    t.getSemestre(),
                    t.getFormaDeAvaliacao(),
                    presencialStr,
                    sala,
                    t.getHorario(),
                    t.getCapacidadeMaxima()));
                bw.newLine();
            }
            
            System.out.println("\nDados salvos com sucesso! 🎉");
            System.out.println("Arquivo salvo em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("\n👎 Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static void carregar(String nomeArquivo) {
        ListaDisciplinas.limparDisciplinas();
        ListaTurmas.limparTurmas();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            boolean lendoDisciplinas = false;
            boolean lendoTurmas = false;

            while ((linha = br.readLine()) != null) {
                if (linha.equalsIgnoreCase("DISCIPLINAS")) {
                    lendoDisciplinas = true;
                    lendoTurmas = false;

                    br.readLine();
                    continue;
                } else if (linha.equalsIgnoreCase("TURMAS")) {
                    lendoDisciplinas = false;
                    lendoTurmas = true;
                    br.readLine();
                    continue;
                }

                if (lendoDisciplinas) {
                    String[] partes = linha.split("\\|");
                    if (partes.length >= 3) {
                        String codigo = partes[0].trim();
                        String nome = partes[1].trim();
                        int cargaHoraria = Integer.parseInt(partes[2].trim());

                        Disciplina d = new Disciplina(nome, codigo, cargaHoraria);
                        ListaDisciplinas.adicionar(d);
                    }
                } else if (lendoTurmas) {
                    String[] partes = linha.split("\\|");
                    if (partes.length >= 8) {
                        String codigoDisciplina = partes[0].trim();
                        String professor = partes[1].trim();
                        String semestre = partes[2].trim();
                        String formaAvaliacao = partes[3].trim();
                        boolean presencial = partes[4].trim().equalsIgnoreCase("sim");
                        String sala = partes[5].trim();
                        String horario = partes[6].trim();
                        int capacidadeMaxima = Integer.parseInt(partes[7].trim());

                        Disciplina d = ListaDisciplinas.AcharCodigo(codigoDisciplina);
                        if (d != null) {
                            Turma t = new Turma(professor, d, semestre, formaAvaliacao, presencial, sala, horario, capacidadeMaxima);
                            ListaTurmas.adicionar(t);
                        } else {
                            System.out.println(" Disciplina não encontrada para código: " + codigoDisciplina + ". Turma ignorada.");
                        }
                    }
                }
            }

            System.out.println("\nDados carregados com sucesso! ");
            System.out.println("Arquivo carregado de: " + nomeArquivo);

        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo não encontrado. Nenhum dado carregado.\n");
        } catch (IOException e) {
            System.out.println("\n👎 Erro ao carregar dados: " + e.getMessage());
        }
    }
}