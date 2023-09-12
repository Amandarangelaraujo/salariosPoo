package program;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
       System.out.println("entre com o nome do departamento");
       String department = sc.nextLine();
       System.out.println("entre com o nome do trabalhador");
       String name = sc.nextLine();
       System.out.println("entre com o nome do level");
       String level = sc.nextLine();
       System.out.println("entre com o salario base");
       double baseSalary = sc.nextDouble();
       
       //PRESTA ATENÇÃO NESSA PARTE.
       Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
       System.out.print("Quantos contratos esse trabalhador terá");
       int n = sc.nextInt();
       for(int i = 0; i<n; i++){
        System.out.println("escreva os dados do contrato numero "+i);
        System.out.println("escreva a data ");
        Date contractDate =sdf.parse(sc.next());
        System.out.println("valor por hora ");
        double valuePerHour = sc.nextDouble();
        System.out.println("duração");
        int hours = sc.nextInt();
        HourContract contract = new HourContract(contractDate, valuePerHour, hours);
        worker.addContract(contract);
    }
    
    
        System.out.println("entre com o mes e ano para calcular o salário ");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));

        System.out.println("name: "+worker.getName());
        System.out.println("departamento: "+worker.getDepartment().getName());
        System.out.println("income "+mesAno+": "+worker.income(ano,mes));


       sc.close();
    }
}
