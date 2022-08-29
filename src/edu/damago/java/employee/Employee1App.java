package edu.damago.java.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Facade for the interactive employee text application (version 1), based on
 * runtime arguments and structured programming techniques.
 */
public class Employee1App {

	/**
	 * Application entry point.
	 * 
	 * @param args the runtime arguments
	 * @throws IOException
	 */
	static public void main(final String[] args) throws IOException {
		final BufferedReader terminalSource = new BufferedReader(new InputStreamReader(System.in));
		Employee[] employees = {};

		while (true) {
			System.out.print("> ");
			final String line = terminalSource.readLine().trim();
			final int delimiterPosition = line.indexOf(' ');
			final String command = (delimiterPosition == -1 ? line : line.substring(0, delimiterPosition)).trim();
			final String arguments = (delimiterPosition == -1 ? "" : line.substring(delimiterPosition + 1)).trim();

			switch (command.toLowerCase()) {
			case "add":
				employees = processAddCommand(employees, arguments);
				System.out.println("ok.");
				break;
			case "remove":
				employees = processRemoveCommand(employees, arguments);
				System.out.println("ok.");
				break;
			case "display":
				processDisplayCommand(employees);
				System.out.println("ok.");
				break;
			case "save":
				processSaveCommand(employees, arguments);
				System.out.println("ok.");
				break;
			case "load":
				employees = processLoadCommand(arguments);
				System.out.println("ok.");
				break;
			case "quit":
				System.out.println("Bye!");
				return;
			default:
				processHelp(arguments);
				break;
			}
		}
	}

	static public void processHelp(final String arguments) {
		System.out.println("Available commands:");
		System.out.println("- add <id>,<surname>,<forename>,<age>: adds a new employee");
		System.out.println("- remove <index>: removes an existing employee");
		System.out.println("- display: displays all existing employees");
		System.out.println("- save <file-path>: saves a text representation of all existing employees");
		System.out.println(
				"- load <file-path>: replaces the employees with new ones based on the given text representation");
		System.out.println("- help: displays this help");
		System.out.println("- quit: terminates this program");
	}

	static public Employee[] processAddCommand(Employee[] employees, final String arguments) {
		// TODO:
		String[] addArgs = arguments.split(",");
		Employee newEmployee = new Employee();

		newEmployee.identity = Long.parseLong(addArgs[0]);
		newEmployee.surname = addArgs[1].trim();
		newEmployee.forename = addArgs[2].trim();
		newEmployee.forename = addArgs[3].trim();

		employees = Arrays.copyOf(employees, employees.length + 1);
		employees[employees.length - 1] = newEmployee;

		return employees;
	}

	static public Employee[] processRemoveCommand(final Employee[] employees, final String arguments) {
		// TODO:
		return new Employee[0]; // to be replaced!
	}

	static public void processDisplayCommand(final Employee[] employees) {
		for (int i = 0; i < employees.length - 1; i++) {
			System.out.print(employees[i].identity + ", ");
			System.out.print(false);
		}
	}

	static public void processSaveCommand(final Employee[] employees, final String arguments) {
		// TODO:
	}

	static public Employee[] processLoadCommand(final String arguments) {
		// TODO:
		return new Employee[0]; // to be replaced!
	}

	static public class Employee {
		public long identity;
		public String surname;
		public String forename;
		public int age;
	}
}