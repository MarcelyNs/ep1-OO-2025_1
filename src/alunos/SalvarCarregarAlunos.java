package alunos;
import java.io.*;

import java.util.List;
public class SalvarCarregarAlunos {
	public static void salvarAlunos(String nomeArquivo, List<Aluno> regulares, List<AlunoEspecial> especiais) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write("Tipo de Aluno|Nome|Matricula|Curso");
            bw.newLine();

            for (Aluno a : regulares) {
                bw.write(String.format("regular|%s|%s|%s", a.getNome(), a.getMatricula(), a.getCurso()));
                bw.newLine();
            }

            for (AlunoEspecial ae : especiais) {
                bw.write(String.format("especial|%s|%s|%s", ae.getNome(), ae.getMatricula(), ae.getCurso()));
                bw.newLine();
            }

            System.out.println("\nAlunos salvos com sucesso!");
            System.out.println("Foi salvo em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("\n Erro ao salvar arquivo de alunos: " + e.getMessage());
        }
    }

    public static void carregarAlunos(String nomeArquivo, List<Aluno> regulares, List<AlunoEspecial> especiais) {
        regulares.clear();
        especiais.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length < 4) continue;

                String tipo = partes[0].trim();
                String nome = partes[1].trim();
                String matricula = partes[2].trim();
                String curso = partes[3].trim();

                if (tipo.equalsIgnoreCase("regular")) {
                    regulares.add(new Aluno(nome, matricula, curso));
                } else if (tipo.equalsIgnoreCase("especial")) {
                    especiais.add(new AlunoEspecial(nome, matricula, curso));
                }
            }
            System.out.println("\nAlunos carregados com sucesso!");
            System.out.println("Foi carregado em: " + nomeArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo não encontrado. Nenhum aluno carregado.");
        } catch (IOException e) {
            System.out.println("\n Erro ao carregar arquivo de alunos: " + e.getMessage());
        }
    }
}


