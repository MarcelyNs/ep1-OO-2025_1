package disciplina;

import util.EntradaUsuario;

import util.ListaDisciplinas;

public class CadastrarDisciplina {
	public static void cadastrarDisciplinaNova() {
        System.out.println("\n_____Cadastrar Disciplina_____");
        String nomeDaMateria = " ";
        while (true) {
            nomeDaMateria = EntradaUsuario.lerString("\n° Nome da Disciplina: ");
            if (ListaDisciplinas.AcharNome(nomeDaMateria) != null) {
                System.out.println("\n Nome já cadastrado! Por favor, tente novamente.");
                continue;
            }
            break;
        }

        String codigo = " ";
        while (true) {
            codigo = EntradaUsuario.lerString("\n° Código da Disciplina: ");
            if (ListaDisciplinas.AcharCodigo(codigo) != null) {
                System.out.println("\n Código já cadastrado! Por favor, tente novamente.");
                continue;
            }
            break;
        }

        int cargaHoraria = EntradaUsuario.lerInt("\n° Digite a carga horária da disciplina (coloque apenas números): ");
        Disciplina novaDisciplina = new Disciplina(nomeDaMateria, codigo, cargaHoraria);
        while (true) {
            String resposta = EntradaUsuario.lerString("\n° Deseja adicionar um pré-requisito? (sim/não): ").toLowerCase();

            if (resposta.equals("sim")) {
                String codPreReq = EntradaUsuario.lerString("\n° Informe o código da disciplina pré-requisito: ");
                Disciplina preReq = ListaDisciplinas.AcharCodigo(codPreReq);
                if (preReq != null) {
                    novaDisciplina.adicionarPreRequisito(preReq);
                    System.out.println("\nPré-requisito adicionado com sucesso!");
                } else {
                    System.out.println("\nCódigo não encontrado! Pré-requisito não adicionado.");
                }
            } else if (resposta.equals("não") || resposta.equals("nao")) {
                break;
            } else {
                System.out.println("\n Por gentileza, responda 'sim' ou 'não'.");
            }
        }
        if (ListaDisciplinas.adicionar(novaDisciplina)) {
            System.out.println("\nDisciplina cadastrada com sucesso! ");
        } else {
            System.out.println("\n Não foi possível cadastrar a disciplina.");
        }
    }
}