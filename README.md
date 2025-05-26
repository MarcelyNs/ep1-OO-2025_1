# Sistema Acadêmico - FCTE

## Descrição do Projeto

Desenvolvimento de um sistema acadêmico para gerenciar alunos, disciplinas, professores, turmas, avaliações e frequência, utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

O enunciado do trabalho pode ser encontrado aqui:
- [Trabalho 1 - Sistema Acadêmico](https://github.com/lboaventura25/OO-T06_2025.1_UnB_FCTE/blob/main/trabalhos/ep1/README.md)

## Dados do Aluno

- **Nome completo:** Marcely do Nascimento Silva
- **Matrícula:** 241025701
- **Curso:** Engenharias
- **Turma:** 06

---

## Instruções para Compilação e Execução

1. **Compilação:**  
  Os arquivos .java do projeto estão organizados em pastas dentro da pasta src. Para compilar todo o projeto e gerar os arquivos .class dentro da pasta bin, siga estes passos:

  1° Abra o Prompt de Comando do Windows.

  2° Navegue até a pasta src do seu projeto. Por exemplo, execute:

   ````bash

cd C:\Users\neofr\eclipse-workspace\SistemaAcadêmicoFCTE\src
`````
3° Compile todos os arquivos .java e envie os .class gerados para a pasta bin (que fica uma pasta acima de src), usando o seguinte comando:

````bash
for /R %f in (*.java) do javac -d ../bin "%f"
````
Explicação do comando:

***for /R %f in (*.java)*** — procura recursivamente todos os arquivos .java dentro da pasta src e suas subpastas.

***javac -d ../bin "%f"*** — compila cada arquivo .java e coloca o arquivo .class correspondente dentro da pasta bin.

2. **Execução:**
   Depois de compilar, é preciso navegar até a pasta bin onde estão os arquivos .class. Para isso:

1° A partir da pasta src, suba um nível usando o comando:

````bash
cd ..
````
2° Em seguida, entre na pasta bin:

````bash
cd bin
````
3° Agora execute o programa principal com:

````bash
java app.Main
````
Explicação dos comandos cd:
***cd .. ***— sobe um nível na hierarquia de pastas (do src para a pasta do projeto).

***cd bin*** — entra na pasta bin, onde os arquivos compilados estão.
   

4. **Estrutura de Pastas:**  
   /app          -> Contém a classe principal Main.java
   /alunos       -> Classes relacionadas aos alunos (Aluno, AlunoEspecial,  etc.)
   /disciplina   -> Classes de disciplinas e turmas
   /avaliacao    -> Classes para lançamento de notas e frequência
   /util         -> Classes utilitárias (EntradaUsuario, Listas, Verificação, etc.)
   /dados        -> Arquivos de persistência (alunos.txt, turmasDisciplinas.txt)

3. **Versão do JAVA utilizada:**  
   java version "21.0.6"

---

## Vídeo de Demonstração

- [Inserir o link para o vídeo no YouTube/Drive aqui]

---

## Prints da Execução

1. Menu Principal:  
 ![image](https://github.com/user-attachments/assets/f176b809-41fa-4969-9196-14850aa5b80d)



2. Cadastro de Aluno:  
   ![Inserir Print 2](caminho/do/print2.png)

3. Relatório de Frequência/Notas:  
   ![Inserir Print 3](caminho/do/print3.png)

---

## Principais Funcionalidades Implementadas

- [x] Cadastro, listagem, matrícula e trancamento de alunos (Normais e Especiais)
- [x] Cadastro de disciplinas e criação de turmas (presenciais e remotas)
- [x] Matrícula de alunos em turmas, respeitando vagas e pré-requisitos
- [x] Lançamento de notas e controle de presença
- [x] Cálculo de média final e verificação de aprovação/reprovação
- [x] Relatórios de desempenho acadêmico por aluno, turma e disciplina
- [x] Persistência de dados em arquivos (.txt ou .csv)
- [x] Tratamento de duplicidade de matrículas
- [x] Uso de herança, polimorfismo e encapsulamento

---

## Observações (Extras ou Dificuldades)

 No começo do projeto, encontrei bastante dificuldade para entender como aplicar o conceito de polimorfismo corretamente no código. Isso me fez refletir bastante sobre a estrutura das classes e como elas poderiam interagir de forma mais eficiente. Embora eu não tenha implementado funcionalidades extras complexas, adicionei uma validação importante para que a matrícula do aluno não possa ter mais de 9 dígitos, evitando erros de cadastro. Além disso, modifiquei o sistema para que as turmas disponíveis sejam exibidas no momento da matrícula, o que facilita muito a escolha pelo usuário. Essas mudanças, apesar de simples, contribuíram para tornar o sistema mais seguro e fácil de usar. Durante o desenvolvimento, percebi o quanto pequenos detalhes fazem diferença na experiência final. Por isso, acredito que essas melhorias são valiosas, na minha opinião.

---

## Contato

- [Opcional: E-mail pessoal do aluno.]

