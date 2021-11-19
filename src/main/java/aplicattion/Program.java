package aplicattion;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        SimpleDateFormat sdfb = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("How many dependents does this worker have");
        int m = sc.nextInt();

        for (int i=0;i<m;++i){
            System.out.println("Enter dependent #"+ (1 + i)+" data:");

            sc.nextLine();
            System.out.print("Name:");
            String dependentName = sc.nextLine();

            System.out.print("Genre:");
            String genre = sc.nextLine();

            System.out.print("Birth Date:");
            Date birthDate = sdf.parse(sc.next());

            Dependents dependents = new Dependents(dependentName, Genre.valueOf(genre), birthDate);
            worker.addDependents(dependents);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY):");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name:"+ worker.getName());
        System.out.println("Department:"+worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear+": "+String.format("%.2f%n", worker.income(month, year))  );

        Calendar cal = Calendar.getInstance();

        System.out.println("List of Dependents:");
        int sum = 0;
        for (Dependents c : worker.getDependents()){
            ++sum;
            System.out.println("Dependent: #"+sum);
            cal.setTime(c.getBirthDate());
            System.out.println(c.getName());
            int c_day_birthay = cal.get(Calendar.DAY_OF_MONTH);
            int c_month_birthay = 1 + cal.get(Calendar.MONTH);
            int c_year_birthay = cal.get(Calendar.YEAR);
            System.out.println(c_day_birthay+"/"+c_month_birthay+"/"+c_year_birthay);

            System.out.println(c.getGenre());
        }
        sc.close();
    }
}
