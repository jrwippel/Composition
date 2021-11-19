package aplicattion;

import entities.Department;
import entities.HourContract;
import entities.WorkLevel;
import entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[]args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name:");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data:");

        System.out.print("Name:");
        String workerName = sc.nextLine();

        System.out.print("Level:");
        String workerLevel = sc.nextLine();

        System.out.print("Base salary:");
        double workerSalary = sc.nextDouble();

        System.out.print("How many contracts to this worker?");
        int n = sc.nextInt();
        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel), workerSalary, new Department(departmentName));
        for (int i=0;i<n;i++){
            System.out.println("Enter contract #" + (i + 1) +" data:");
            System.out.print("Date (DD/MM/YYYY):");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour:");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours):");
            int durationHour = sc.nextInt();
            HourContract hourContract = new HourContract(contractDate, valuePerHour, durationHour);
            worker.addContract(hourContract);
        }
        System.out.print("Enter month and year to calculate income (MM/YYYY):");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name:"+ worker.getName());
        System.out.println("Department:"+worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear+":"+worker.income(month, year) );
        sc.close();
    }
}
