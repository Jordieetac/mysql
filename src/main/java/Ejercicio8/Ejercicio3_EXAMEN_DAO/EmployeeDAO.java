package Ejercicio8.Ejercicio3_EXAMEN_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDAO {

	private int SSN;
	private static DBconection conexion = new DBconection();

	public static void main(String[] args) {
		Employee e = new Employee();

		e = getEmployee(123234877);
		deleteEmployee(123234877);
		Employee empleado = new Employee();
		empleado.setSSN(671202623);
		empleado.setName("Torbe");
		empleado.setLastName("LaCerda");
		empleado.setDepartment("37");
		updateEmployee(empleado);

		// Se obtiene la lista de personas
		ArrayList<Employee> AllEmployees = getAllEmployees();
		// se valida si se obtubo o no informacion
		if (AllEmployees.size() > 0) {
			int numeroPersona = 0;
			// se recorre la lista de empleados asignandose cada posicion en un
			// objeto persona
			for (int i = 0; i < AllEmployees.size(); i++) {
				numeroPersona++;
				e = AllEmployees.get(i);
				System.out.println("****************Persona " + numeroPersona
						+ "**********************");
				System.out.println("SSN: " + e.getSSN());
				System.out.println("Name: " + e.getName());
				System.out.println("LastName: " + e.getLastName());
				System.out.println("Department: " + e.getDepartment());

				System.out
						.println("*************************************************\n");
			}
		} else {
			System.out.println("Actualmente no existen registros de empleados");
		}

	}

	private static Employee getEmployee(int SSN) {
		DBconection conexion = new DBconection();
		ResultSet resultado;
		Employee d = new Employee();

		resultado = conexion
				.getQuery("SELECT * FROM Employees WHERE SSN='" + SSN + "'");
		try {
			while (resultado.next()) {
				d.setSSN(Integer.parseInt(resultado.getString("SSN")));
				System.out.println("Id Persona: " + d.getSSN());
				d.setName(resultado.getString("Name"));
				System.out.println("Name: " + d.getName());
				d.setLastName(resultado.getString("LastName"));
				System.out.println("LastName: " + d.getLastName());
				d.setDepartment(resultado.getString("Department"));
				System.out.println("Department: " + d.getDepartment());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}

	public static ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> miEmpleado = new ArrayList<Employee>();
		DBconection conexion = new DBconection();
		ResultSet resultado;

		resultado = conexion.getQuery("SELECT * FROM Employees");
		try {
			while (resultado.next()) {
				Employee e = new Employee();
				e.setSSN(Integer.parseInt(resultado.getString("SSN")));
				e.setName(resultado.getString("Name"));
				e.setLastName(resultado.getString("LastName"));
				e.setDepartment(resultado.getString("Department"));

				miEmpleado.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return miEmpleado;
	}

	public static void deleteEmployee(int SSN) {
		DBconection conexion = new DBconection();
		conexion.setQuery("DELETE FROM Employees WHERE SSN='" + SSN + "'");
	}

	public static void updateEmployee(Employee employee) {
		DBconection conexion = new DBconection();
		ResultSet resultado;
		int id;
		String n, ln, d;

		id = employee.getSSN();
		n = employee.getName();
		ln = employee.getLastName();
		d = employee.getDepartment();

		String nombre = "INSERT INTO Employees(SSN,Name,LastName,Department) VALUES ('"
				+ id + "', '" + n + "', '" + ln + "', " + d + ")";
		System.out.println("Name: " + nombre);
		conexion.setQuery("INSERT INTO Employees(SSN,Name,LastName,Department) VALUES ('"
				+ id + "', '" + n + "', '" + ln + "', " + d + ")");

	}
}