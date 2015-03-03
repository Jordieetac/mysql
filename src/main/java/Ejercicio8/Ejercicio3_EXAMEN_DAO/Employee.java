package Ejercicio8.Ejercicio3_EXAMEN_DAO;

public class Employee {

	public Employee(int sSN, String name, String lastName, String department) {
		super();
		
		SSN = sSN;
		Name = name;
		LastName = lastName;
		Department = department;
	}

	public Employee() {
		SSN = 0;
		Name = " ";
		LastName = " ";
		Department = " ";

	}

	public int SSN;

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String Name;
	public String LastName;
	public String Department;

}