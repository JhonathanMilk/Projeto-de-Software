package FolhaDePagamento;
import java.util.Scanner;
/**
 *
 * @author jhonathanmilk
 */
public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       
       /**/
       AgendaPagamento agenda = new AgendaPagamento ();
       Empregados [] empregados = new Empregados[10];
       
       int id = 0;
       int count = 0;

        
        while(true){
            System.out.println("Digite alguma opcao:");
            System.out.println("1 - Adicionar empregado\n"+
                               "2 - Remover empregado\n"+"3 - visualizar empregados\n"+
                               "4 - marcar ponto\n"+"5 - adicionar venda\n"+
                               "6 - Verificar historicos de venda\n"+"8 - Sair do programa\n");
            int entrada = scan.nextInt();
            scan.nextLine();
            
            if (entrada == 1){
                /*Funcao adicionar*/
                id+=1;
                
                Empregados empregado = new Empregados ();
                System.out.println("Nome empregado:");
                String nome = scan.nextLine();
                System.out.println("endereco empregado:");
                String endereco = scan.nextLine();
                System.out.println("data de nascimento:");
                String dataNascimento = scan.nextLine();
                System.out.println("Digite o tipo de empregado:");
                String tipoEmpregado = scan.nextLine();
                
                empregado.addEmpregado(nome,endereco,dataNascimento, id, tipoEmpregado);
                empregados[count] = empregado;
                agenda.empregados = empregados;
            }
            else if (entrada == 2){
                /*Funcao remover*/
                System.out.println("Digite o id do empregado que deseja remover");
                int clean = scan.nextInt();
                
                Empregados temp = new Empregados ();
                
                temp.removerEmpregado(agenda.empregados, clean);
                

            }
            else if (entrada == 3){
                for (Empregados temp : agenda.empregados){
                    if(temp != null)
                    System.out.println("nome: "+temp.nome+"\nendereco: "+temp.endereco+
                            "\ndata nascimento: "+temp.dataNascimento+"\nid: "+temp.id+"\n");
                }
            }
            else if (entrada == 4){
                
            }
            else if (entrada == 5){
                System.out.println("Digite o valor da venda:");
                Double valueVenda = scan.nextDouble();
                scan.nextLine();
                System.out.println("Digite a data da venda:");
                String dateVenda = scan.nextLine();
                System.out.println("Digite seu id:");
                int idVendedor = scan.nextInt();
                
                Empregados comissionado = new Empregados();
                comissionado.Comissao(agenda.empregados,valueVenda,dateVenda,idVendedor);
            }
            else if (entrada == 6){
                System.out.println("Digite o id do usuario: ");
                int idUser = scan.nextInt();
                
                Empregados vendas = new Empregados();
                vendas.consultarVendas(agenda.empregados, idUser);
            }
            else if (entrada == 8){
                break;
            }
            else{
                System.out.println("Opcao invalida! Tente novamente.");
            }
            count++;
        }
    }
}
