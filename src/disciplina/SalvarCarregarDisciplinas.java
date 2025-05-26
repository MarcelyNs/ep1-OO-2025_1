package disciplina;
import java.io.*;
import java.util.List;

public class SalvarCarregarDisciplinas {

    public static void salvarDisciplinas(String nomeArquivo, List<Disciplina> disciplinas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write("Codigo|NomeDaMateria|CargaHoraria");
            bw.newLine();

            for (Disciplina d : disciplinas) {
                bw.write(String.format("%s|%s|%d", d.getCodigo(), d.getNomeDaMateria(), d.getCargaHoraria()));
                bw.newLine();
            }
            System.out.println("\nDisciplinas salvas com sucesso! ");
            System.out.println("Arquivo salvo em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("\n Erro ao salvar disciplinas: " + e.getMessage());
        }
    }

    public static void carregarDisciplinas(String nomeArquivo, List<Disciplina> disciplinas) {
        disciplinas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine(); 

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length < 3) continue;

                String codigo = partes[0].trim();
                String nome = partes[1].trim();
                int cargaHoraria = Integer.parseInt(partes[2].trim());

                disciplinas.add(new Disciplina(nome, codigo, cargaHoraria));
            }
            System.out.println("\nDisciplinas carregadas com sucesso!");
            System.out.println("Arquivo carregado de: " + nomeArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo de disciplinas não encontrado. Nenhuma disciplina carregada.");
        } catch (IOException e) {
            System.out.println("\n Erro ao carregar disciplinas: " + e.getMessage());
        }
    }
}