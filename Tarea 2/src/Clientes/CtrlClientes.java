package Clientes;
import Cuentas.CtrlCuentas;
public class CtrlClientes {
	public static Cliente[] clientes = new Cliente[20];
	
	public static boolean verificarCui(String cui) {
		for(Cliente cliente: clientes) {
			if(cliente != null && cliente.getCui().equals(cui)) {
				return true;
			}
		}
		return false;
	}
	public static boolean nuevoCliente(String cui, String nombre, String apellido) {
		for(int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				clientes[i] = new Cliente(cui,nombre,apellido);
				return true;
			}
		}
		return false;
	}
	public static void verRegistro(String cui) {
		for(Cliente cliente: clientes) {
			if(cliente != null && cliente.getCui().equals(cui)) {
				System.out.printf("%-20s%-20s%-10s\n","CUI: " + cui, "Nombre: " + cliente.getNombre(), "Apellido: " + cliente.getApellido());
				CtrlCuentas.verCuenta(cui);
				return;
			}
		}
	}
	public static void verActividadC(String cui) {
		for(Cliente cliente: clientes) {
			if(cliente != null && cliente.getCui().equals(cui)) {
				System.out.printf("%-20s%-20s%-10s\n","CUI: " + cui, "Nombre: " + cliente.getNombre(), "Apellido: " + cliente.getApellido());
				CtrlCuentas.obtenerCuentas(cui);
				return;
			}
		}
	}
}
