package CodigoAula;

/**
 *
 * @author jhonathanmilk
 */

public class Main{
    public static void main(String[] args){
    
        Employee employee1 = new Employee("Bruna", "Recife", 10.0);

        Employee employee2 = new Employee("Joao","Alagoas", 5);

        System.out.println(employee1.printEmployeeInfo(employee2));
    }
}
