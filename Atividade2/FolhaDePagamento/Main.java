/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FolhaDePagamento;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author jhonathanmilk
 */
public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       
       /**/
       AgendaPagamento agenda = new AgendaPagamento ();
       ArrayList <Empregados> empregados = new ArrayList <>();
       agenda.empregados = empregados;
       
              
       int id = 0;
        
       while(true){
            System.out.println("Digite alguma opcao:");
            System.out.println("1 - Adicionar empregado\n"+
                               "2 - Remover empregado\n"+"3 - visualizar empregados\n"+
                               "4 - marcar ponto\n"+"5 - adicionar venda\n"+
                               "6 - Verificar historicos de vendas\n"+"7 - Realizar pagamentos\n"+"8 - Sair do programa\n");
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
                System.out.println("O empregado pertence ao sindicato? (Y / N)");
                String valueSindicato = scan.nextLine();
                boolean sindicatoValidacao = false;
                        
                sindicatoValidacao = (valueSindicato == "Y" || valueSindicato == "y") ? true : false;
                
                if (tipoEmpregado.equals("Assalariado") || tipoEmpregado.equals("assalariado")){
                    
                    System.out.println("O empregado é comissionado? Pressione Y para sim / N para não");
                    String comissioned = scan.nextLine();
                    
                    if (comissioned.equals("N") || comissioned.equals("n")){
                        
                        Empregados assalariado = new EmpAssalariado (2000,nome,endereco,dataNascimento, id, "Assalariado", sindicatoValidacao);
                        empregados.add(assalariado);                        
                    }                    
                    else if (comissioned.equals("Y") || comissioned.equals("y")){
                        
                        Empregados comissionado = new EmpComissionado (0, 2000, nome, endereco, dataNascimento, id, "Comissionado", sindicatoValidacao);
                        empregados.add(comissionado);                        
                    }
                    else{
                        System.out.println("Opcao invalida");
                    }
                    
                }
                else if (tipoEmpregado.equals("Horista") || tipoEmpregado.equals("horista")){
                    Empregados horista = new EmpHorista (0, nome, endereco, dataNascimento, id, "Horista", sindicatoValidacao);
                    empregados.add(horista);
                }
                else{
                    System.out.println("Tipo de empregado inválido");
                }
                
            }
            
            else if (entrada == 2){
                /*Funcao remover*/
                
                if(empregados.isEmpty()){
                    System.out.println("Lista de empregados vazia, por favor adicionar empregados!");
                    continue;
                }
                
                System.out.println("Digite o id do empregado que deseja remover:");
                int clean = scan.nextInt();
                boolean verifica = false;
                int i=0;
                
                for(Empregados search : empregados){
     //               System.out.println(i);
                    if(search.getId() == clean){
                        verifica = true;
                        break;
                    }
                    i++;
                }
                
                if(verifica){
                    empregados.remove(i);
                }else{
                    System.out.println("Empregado nao localizado");
                }                                        
            }
            
            else if (entrada == 3){ //Funçao visualizar empregados
                for(Empregados print : empregados){
                    System.out.println(print);
                }                            
            }
            
            else if (entrada == 4){
                System.out.println("Por favor, digite seu ID");
                int idHorista = scan.nextInt();
                System.out.println("Digite a quantidade de horas trabalhadas");
                double horasTrabalhadas = scan.nextDouble();
                
                EmpHorista empHorista = new EmpHorista();
                empHorista.submeterCartao(empregados, horasTrabalhadas, idHorista);
            }
            
            else if (entrada == 5){ //Adicionar Venda
                
                System.out.println("Digite o valor da venda:");
                Double valueVenda = scan.nextDouble();
                scan.nextLine();
                System.out.println("Digite a data da venda:");
                String dateVenda = scan.nextLine();
                System.out.println("Digite seu id:");
                int idVendedor = scan.nextInt();
                
                EmpComissionado addComissao = new EmpComissionado();
                addComissao.Comissao(empregados, valueVenda, dateVenda, idVendedor);
            }
            
            else if (entrada == 6){ //verificar historico de vendas;
                System.out.println("Digite o id do empregado: ");
                int idVendedor = scan.nextInt();
                
                EmpComissionado printVendas = new EmpComissionado();
                printVendas.printVendas(empregados, idVendedor);
            }
            
            else if (entrada == 7){
                System.out.println("Qual tipo de empregado para realizar os pagamentos? Digite:\n"
                        + "(1 - horista\n2 - assalariado\n3 - Assalariado comissionado)\n");
                int entry = scan.nextInt();
                
                if (entry == 1){
                    
                }
                else if (entry == 2){
                    
                }
                else if (entry == 3){
                    
                }
                else{
                    System.out.println("Opcao inválida");
                }
            }
            
            else if (entrada == 8){
                break;
            }
            else{
                System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }
}
