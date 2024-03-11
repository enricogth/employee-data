package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char ch = input.next().charAt(0);
			
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			
			System.out.println("Hours: ");
			int hours = input.nextInt();
			
			System.out.println("Value per hour: ");
			double valuePerHour = input.nextDouble();
			
			//do an if, for the answer in variable 'ch', (y/n)
			if (ch == 'y') {
				System.out.println("Additional charge: ");
				double additionalCharge = input.nextDouble();
				
				//transfer all these datas to emp, instanced as OutsourcedEmployee, because it has additionalCharge value
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);
			}
			
			//now if it doens't has additionalCharge, intance as Employee
			else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS: ");
		
		//to show all datas, use for each (Employee emp) in the (list)
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
			
		}
		
		
		
		input.close();

	}

}
