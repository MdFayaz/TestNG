package examples.practise;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class Assignment {
	enum Command{
		JOIN, CHANGE, QUIT, PAYDAY, EMPLOYEES, UNEMPLOYEED, DUMP, END
	}
	private  HashMap<String, String> employeeCompanies = new HashMap<String, String>();
	private  HashMap<String, Integer> employeeSalary = new HashMap<String, Integer>();
	private final String UNEMPLOYED = "UNEMPLOYED";
	
	private static final String companiesFilePath = "company.txt";
	private  ArrayList<String> companies = new ArrayList<String>();
	private  ArrayList<String> employeeList = new ArrayList<String>();
	
	public Assignment(){
		companies.add(UNEMPLOYED); 
		/**
		 * For debug purpose
		 */
		companies.add("Msys");
		companies.add("IBM");
		companies.add("Polaris");
		companies.add("Verizon");
		companies.add("VMWare");
		companies.add("Netapp");
		
	}
	
	public void readCompanies() {
		BufferedReader bis = null;
		try {
			bis = new BufferedReader(new FileReader(new File(companiesFilePath)));
			String line = null;
			while((line = bis.readLine()) != null){
				companies.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static String employee  = null;
	static String company = null;
	static int initialEmployeeSal = 0;
	static int initialUnEmployeeSal = 0;
	static Command command;
	static boolean invalidArg = false;
	
	public static void main(String[] args) {
		Console c = System.console();		
		if(args.length != 3){
			System.out.println("Invalid number of parameters. Expected: command <person> <company>");
			System.out.println("Valid commands are: " + Arrays.asList(Command.values()));
		}else {
			employee =  args[1];
			company = args[2];
			command = Command.valueOf(args[3]);
		}
		
		Assignment assignment = new Assignment();
		assignment.handleErrors(invalidArg, employee, company, command);
		
		/*
		assignment.join("Fayaz", "Msys");
		assignment.change("Fayaz", "IBM");
		assignment.join("Prasad", "Msys");
		assignment.quit("Fayaz");
		assignment.join("Anshuman", "Msys");
		assignment.join("Jay", "Msys");
		assignment.join("Sri", "Msys");
		assignment.join("Bala", "Msys");
		
		assignment.join("Vijay", "IBM");
		assignment.join("Nag", "IBM");
		assignment.join("Priya", "IBM");
		
		assignment.getEmployees("Msys");
		assignment.getEmployees("IBM");
		
		assignment.change("Priya", "Msys");
		assignment.getUnEmployees();
		assignment.getEmployees("Msys");
		assignment.getEmployees("IBM");
		assignment.quit("Fayaz");
		assignment.quit("Bala");
		assignment.quit("Abcd");
		assignment.join("Fayaz", "IBM");
		assignment.getUnEmployees();
		
		assignment.payDay();
		assignment.payDay();
		assignment.payDay();*/
	}
	
	private boolean handleErrors(boolean invalidArg, String employee, String company, Command command){
		if(!invalidArg){
			if(!companies.contains(company)){
				System.out.println("Company entered is not exists. Available companies are: ");
				for(String companyFromList : companies){
					System.out.println(companyFromList);
				}
			} else if (!Command.values().equals(command)){
				System.out.println("Eneterd command is invalid. Valid commands are: ");
				System.out.println(Command.JOIN + " " + Command.CHANGE +  " " + Command.EMPLOYEES + 
						" " + Command.QUIT + " " + Command.UNEMPLOYEED + " " + Command.PAYDAY + " " + Command.DUMP);
			}
			return false;
		}
		return true;
	}
	
	private void executeCommand(Assignment assignment){
		switch(command){
			case JOIN:
				assignment.join(employee, company);
				break;
			case CHANGE:
				assignment.change(employee, company);
				break;
			case QUIT:
				assignment.quit(employee);
				break;
			case EMPLOYEES:
				assignment.getEmployees(company);
				break;
			case UNEMPLOYEED:
				assignment.getUnEmployees();
				break;
			case PAYDAY:
				assignment.payDay();
				break;
			case DUMP:
				assignment.dump();
				break;
			case END:
				assignment.exit();
				break;
		}
	}
	
	private  void join(String employee, String company){
		if(!employeeCompanies.containsKey(employee)){
			employeeCompanies.put(employee, company);
			employeeList.add(employee);
			employeeSalary.put(employee, 0);
			
			System.out.println("Employee added with company" + employeeCompanies.toString() + 
					" -- Employee List: " + employeeList );
		} else if (employeeCompanies.get(employee).equals(UNEMPLOYED)){
			employeeCompanies.put(employee, company);
		}else {
			System.out.println("An employee '" + employee + "' already exists");
		}
	}

	private  void change(String employee, String companyName){
		if(employeeCompanies.containsKey(employee) && companies.contains(companyName) && 
				employeeCompanies.get(employee) != null){
			employeeCompanies.put(employee, companyName);
			System.out.println("After employee change company " + employeeCompanies + " -- EmployeeList: " + employeeList);
		} else {
			System.out.println("Employe or Company may not exists OR Employee in the given company is not exists");
		}
	}
	
	private  void quit(String employee){
		if(employeeCompanies.containsKey(employee) && !employeeCompanies.get(employee).equals(UNEMPLOYED)){
			employeeCompanies.put(employee, companies.get(0));
			System.out.println("Unemployeed: " + employee);
		}else {
			System.out.println("Employee not exists or may be already unemployed");
		}
	}
	
	private void payDay(){
		for(Map.Entry<String, String> employeeEntry : employeeCompanies.entrySet()){
			if(!employeeEntry.getValue().equals(UNEMPLOYED)){
				employeeSalary.put(employeeEntry.getKey(), employeeSalary.get(employeeEntry.getKey()) + 5000);
			} else {
				employeeSalary.put(employeeEntry.getKey(), employeeSalary.get(employeeEntry.getKey()) + 500);
			}
		}
		System.out.println(employeeSalary);
	}
	
	private ArrayList<String> getEmployees(String company){
		ArrayList<String> employedList = new ArrayList<String>();
		for(String employee : employeeList){
			if(employeeCompanies.get(employee).equals(company)){
				employedList.add(employee);
			}
		}
		System.out.println(company + " : "+  employedList);
		return employedList;
	}
	
	private ArrayList<String> getUnEmployees(){
		ArrayList<String> unemployeedList = new ArrayList<String>();
		for(String employee : employeeList){
			if(employeeCompanies.get(employee).equals(UNEMPLOYED)){
				unemployeedList.add(employee);
			}
		}
		System.out.println("Unemployed: " + unemployeedList);
		return unemployeedList;
	}
	
	private void dump(){
		
	}
	
	private void exit(){
		System.exit(0);
	}
}
