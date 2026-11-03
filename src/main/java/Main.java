import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Usando valor de N para definir o tamanho do vetor.
        int N = 100;
        int VetorIdade[] = new int[N];
        String VetorNome[] = new String[N];
        
        //Processamento e Menu;
        int op;
        do {
            System.out.println("### Menu ###");
            System.out.println("1 - Cadastrar Aluno\n2 - Listar alunos\n3 - Consultar alunos\n4 - Alterar aluno\n5 - Excluir aluno\n6 - Sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    
                    System.out.println("<<<Cadastre o aluno>>>");
                    
                    //Usa uma condição dentro de while: checa para ver se o valor de Instance
                    //dentro do vetor já não possui um nome agregado. Caso tenha, ele soma +1 a
                    //Instance e passa para o próximo valor. Caso seja null, para e realiza o
                    //pedido para receber um valor de entrada tanto para o nome quanto para a idade.
                    int Instance = 0;
                    
                    //Checa para ver se o último valor possível no vetor já não possui um valor
                    //Caso possua, significa que não há mais espaço disponivel no vetor.
                    if (VetorNome[99] != null) {
                        System.out.println("Cadastro já alcançou o limite de 100 cadastrados.");
                    }
                    
                    while (VetorNome[Instance] != null) {
                        Instance += 1;
                    }
                    
                    //Pede os valores para os vetores.
                    sc.nextLine();
                    System.out.println("Insira o nome do aluno:");
                    VetorNome[Instance] = sc.nextLine();
                    
                    System.out.println("Insira a idade do aluno:");
                    VetorIdade[Instance] = sc.nextInt();
                    
                    System.out.println("Aluno Cadastrado com sucesso!");
                    //Retoma Instance a 0 para toda vez fazer a checagem correta.       
                    break;
                case 2:
                    
                    System.out.println("<<<Listando alunos>>>");
                    
                    for (int i = 0; i < N; i++) {
                        if (VetorNome[i] == null) {
                            break;
                        }else{
                            System.out.println("Nome: " + VetorNome[i] + " | Idade: " + VetorIdade[i]);
                        }
                    }
                    
                    break;
                case 3:
                    
                    System.out.println("<<<Consultar aluno>>>");
                    int op1;
                    do {
                        System.out.println("1 - Consultar por nome\n2 - Consultar por idade\n3 - Voltar");
                        op1 = sc.nextInt();
                        switch (op1) {
                            case 1:
                                
                                System.out.println("Consultando por nome\nInsira o nome inteiro do aluno com os respectivos maiusculos nos lugares devidos: (Caso contrario, o sistema pode não encontrar)");
                                sc.nextLine();
                                String ConsultarPorNome = sc.nextLine();
                                
                                boolean flagNome = false;
                                for (int i = 0; i < N; i++) {
                                    if (VetorNome[i] == null) {
                                        break;
                                    }
                                    if (VetorNome[i].equalsIgnoreCase(ConsultarPorNome)) {
                                        System.out.println("Nome: " + VetorNome[i] + " | Idade: " + VetorIdade[i]);
                                        flagNome = true;
                                    }
                                }
                                if (flagNome == false) {
                                    System.out.println("Aluno nao encontrado");
                                }
                                
                                break;
                            case 2:
                                
                                System.out.println("Consultando por idade\nInsira a idade do aluno:");
                                sc.nextLine();
                                int ConsultaPorIdade = sc.nextInt();
                                
                                boolean flagIdade = false;
                                for (int i = 0; i < N; i++) {
                                    if (VetorIdade[i] == ConsultaPorIdade) {
                                        System.out.println("Nome: " + VetorNome[i] + " | Idade: " + VetorIdade[i]);
                                        flagIdade = true;
                                    }
                                }
                                if (flagIdade == false) {
                                    System.out.println("Aluno não encontrado");
                                }
                                
                                break;
                            case 3:
                                
                                System.out.println("Voltando...");
                                break;
                            default:
                                
                                System.out.println("Opção Invalida");
                        }
                    } while (op1 != 3);
                    break;
                case 4: {
                    System.out.println("<<<Alteracao de aluno>>>");
                    System.out.println("Digite o nome a ser pesquisado para alterar:");
                    sc.nextLine();
                    String nomePesquisa = sc.nextLine();
                    int posicaoAlterar = -1;
                    for (int i = 0; i < N; i++) {
                        if (VetorNome[i] == null) {
                            break;
                        }
                        if (VetorNome[i].equalsIgnoreCase(nomePesquisa)) {
                            posicaoAlterar = i;
                        }
                    }
                    if (posicaoAlterar != -1) {
                        System.out.println("Voce quer alterar o nome do aluno?\n 1 - Sim, 2 - Nao");
                        int querAlterar = sc.nextInt();
                        if (querAlterar == 1) {
                            System.out.println("Insira o nome do aluno para alterar:");
                            sc.nextLine();
                            VetorNome[posicaoAlterar] = sc.nextLine();
                        }
                        System.out.println("Voce quer alterar a idade do aluno?\n 1 - Sim, 2 - Nao");
                        querAlterar = sc.nextInt();
                        if (querAlterar == 1) {
                            System.out.println("Insira a idade do aluno para alterar:");
                            sc.nextLine();
                            VetorIdade[posicaoAlterar] = sc.nextInt(); 
                        }
                    
                        System.out.println("Dados do aluno alterado com sucesso!");
                    }
                    break; }
                case 5: {
                    System.out.println("<<<Excluir aluno>>>");
                    System.out.println("Digite o nome a ser pesquisado para excluir:");
                    sc.nextLine();
                    String nomePesquisa = sc.nextLine();
                    int posicaoExcluir = -1;
                    for (int i = 0; i < N; i++) {
                        if (VetorNome[i] == null) {
                            break;
                        }
                        if (VetorNome[i].equalsIgnoreCase(nomePesquisa)) {
                            posicaoExcluir = i;
                        }
                    }
                    if (posicaoExcluir != -1) {
                        for (int i = posicaoExcluir; i < N - 1; i++) {
                            VetorNome[i] = VetorNome[i+1];
                            VetorIdade[i] = VetorIdade[i+1];
                        }
                        
                        System.out.println("Exclusao de aluno realizada com sucesso.");
                    } else {
                        System.out.println("Nenhum aluno encontrado com o nome " + nomePesquisa);
                    }
                    break; }
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }  
        } while (op != 6);
    }
}