/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadePS2;
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
       EmpAssalariado [] empAssalariado = new EmpAssalariado[20];
       EmpComissionado [] empComissionado = new EmpComissionado[20];
       EmpHorista [] empHorista = new EmpHorista[20];
       
       agenda.comissionado = empComissionado;
       agenda.assalariado = empAssalariado;
       agenda.horista = empHorista;
       
       int id = 0;
       int count = 0;
       
       int salariedCount = 0;
       int comissionedCount = 0;
       int horistaCount = 0;

        
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
               
                System.out.println("Nome empregado:");
                String nome = scan.nextLine();
                System.out.println("endereco empregado:");
                String endereco = scan.nextLine();
                System.out.println("data de nascimento:");
                String dataNascimento = scan.nextLine();
                System.out.println("Digite o tipo de empregado: (Assalariado/Horista)");
                String tipoEmpregado = scan.nextLine();
                
         //       Empregados empregado = new Empregados ();
                if (tipoEmpregado.equals("Assalariado") || tipoEmpregado.equals("assalariado")){
                    
                    System.out.println("O empregado é comissionado? Pressione Y para sim / N para não");
                    String comissioned = scan.nextLine();
                    
                    if (comissioned.equals("N") || comissioned.equals("n")){
                        
                        EmpAssalariado assalariado = new EmpAssalariado ();
                        assalariado.addEmpregado(nome,endereco,dataNascimento, id, tipoEmpregado);
                        assalariado.addAssalariado(20000);
                        empAssalariado[salariedCount] = assalariado;
                        salariedCount++;
                        
                    }                    
                    else if (comissioned.equals("Y") || comissioned.equals("y")){
                        
                        EmpComissionado comissionado = new EmpComissionado ();
                        comissionado.addEmpregado(nome,endereco,dataNascimento, id, tipoEmpregado);
                        comissionado.addAssalariado(20000);
                        empComissionado[comissionedCount] = comissionado;
                        comissionedCount++;
                        
                    }
                    else{
                        System.out.println("Opcao invalida");
                    }
                    
                }
                else if (tipoEmpregado.equals("Horista") || tipoEmpregado.equals("horista")){
                    EmpHorista horista = new EmpHorista ();
                    horista.addEmpregado(nome,endereco,dataNascimento, id, tipoEmpregado);
                    horista.addHorista(0);
                    empHorista[horistaCount] = horista;
                    horistaCount++;
                }
                else{
                    System.out.println("Tipo de empregado inválido");
                }
                
            }
            
            else if (entrada == 2){
                /*Funcao remover*/
                System.out.println("Digite o id do empregado que deseja remover");
                int clean = scan.nextInt();
                
                Empregados temp = new Empregados ();
                
                
                temp.removerEmpregado(agenda, clean);
                
            }
            else if (entrada == 3){ //Funçao visualizar empregados
                
                System.out.println("Empregados Horistas:\n");
                
                System.out.println("Empregados Assalariados:\n");

                EmpAssalariado imprimirAssalariado = new EmpAssalariado();
                imprimirAssalariado.printarEmpregados(empAssalariado);  
                
                System.out.println("Empregados Assalariados Comissionados:\n");

                EmpComissionado imprimirComissionado = new EmpComissionado();
                imprimirComissionado.printarEmpregados(empComissionado);
                              
            }
            
            else if (entrada == 4){
                
            }
            
            else if (entrada == 5){ //Adicionar Venda
                
                System.out.println("Digite o valor da venda:");
                Double valueVenda = scan.nextDouble();
                scan.nextLine();
                System.out.println("Digite a data da venda:");
                String dateVenda = scan.nextLine();
                System.out.println("Digite seu id:");
                int idVendedor = scan.nextInt();
                
                
                EmpComissionado vendaComissao = new EmpComissionado();
                
                vendaComissao.Comissao(empComissionado, valueVenda, dateVenda, idVendedor);                                               
            }
            
            else if (entrada == 6){ //verificar historico de vendas;
                System.out.println("Digite o id do usuario: ");
                int idUser = scan.nextInt();
                
                EmpComissionado buscarComissao = new EmpComissionado();
                buscarComissao.consultarVendas(empComissionado, idUser);
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
