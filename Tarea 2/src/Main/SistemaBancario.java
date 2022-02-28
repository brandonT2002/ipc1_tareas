package Main;
import java.util.Scanner;
import Clientes.*;
import Cuentas.CtrlCuentas;
import Transacciones.CtrlTransacciones;
public class SistemaBancario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 6) {
			System.out.println("SISTEMA BANCARIO");
			System.out.println("1. Crear Cliente");
			System.out.println("2. Crear Cuenta");
			System.out.println("3. Realizar Transacción");
			System.out.println("4. Ver Clientes");
			System.out.println("5. Historial de Transacciones");
			System.out.println("6. Salir");
			System.out.print("Seleccione una Opción: ");
			opcion = sc.nextInt();
			System.out.println();
			switch(opcion) {
				case 1:
					System.out.println("Crear Usuario");
					String cui;
					do {
						System.out.print("CUI: ");
						cui = sc.next();
						if(CtrlClientes.verificarCui(cui)) {
							System.out.println("El CUI ingresado ya existe en el sistema");
						}
					}while(CtrlClientes.verificarCui(cui));
					System.out.print("Nombre: ");
					String nombre = sc.next();
					System.out.print("Apellido: ");
					String apellido = sc.next();
					if(CtrlClientes.nuevoCliente(cui, nombre, apellido)) {
						System.out.println("Cliente registrado");
					}else {
						System.out.println("Sistema lleno");
					}
					break;
				case 2:
					boolean vacio = false;
					System.out.println("Crear Cuenta");
					do {
						System.out.print("CUI: ");
						cui = sc.next();
						if(!CtrlClientes.verificarCui(cui)) {
							System.out.println("El CUI ingresado no existe en el sistema");
							vacio = true;
							break;
						}
					}while(!CtrlClientes.verificarCui(cui));
					if(vacio) break;
					System.out.print("Tipo de Cuenta: ");
					String tipo = sc.next();
					double fondo;
					do {
						System.out.print("Fondos Iniciales: ");
						fondo = sc.nextDouble();
						if(!CtrlCuentas.verificarMontoI(fondo)) {
							System.out.println("Monto Mínimo Inicial de Q 100");
						}
					}while(!CtrlCuentas.verificarMontoI(fondo));
					String id;
					do {
						 id = CtrlCuentas.generarId();
					}while(CtrlCuentas.verificarId(id));
					if(CtrlCuentas.crearCuenta(cui, tipo, id, fondo)) {
						System.out.println("Cuenta Creada con el número " + id);
					}else {
						System.out.println("Sistema lleno");
					}
					break;
				case 3:
					vacio = false;
					String idO;
					do {
						System.out.print("Cuenta Origen: ");
						idO = sc.next();
						if(!CtrlCuentas.verificarId(idO)) {
							System.out.println("La cuenta de origen no existe en el sistema");
							vacio = true;
							break;
						}
						else if(!CtrlCuentas.verificarSaldoD(idO)) {
							System.out.println("La cuenta de origen no tiene fondos suficientes");
							vacio = true;
							break;
						}
					}while(!CtrlCuentas.verificarId(idO));
					if(vacio) break;
					
					String idD;
					do{
						System.out.print("Cuenta Destino: ");
						idD = sc.next(); 
						if(!CtrlCuentas.verificarId(idD)) {
							System.out.println("La cuenta de destino no existe en el sistema");
							vacio = true;
							break;
						}
					}while(!CtrlCuentas.verificarId(idD));
					if(vacio) break;
					double monto;
					do {
						System.out.print("Monto a transferir: ");
						monto = sc.nextDouble();
						if(CtrlCuentas.verificarSaldoD(idO, monto)) {
							CtrlTransacciones.transferir(idO, idD, monto);
							CtrlCuentas.modMonto(idO, - monto);
							CtrlCuentas.modMonto(idD, monto);
							System.out.println("Transferencia exitosa");
							break;
						}else {
							System.out.println("No hay fondos suficientes");
						}
					}while(!CtrlCuentas.verificarSaldoD(idO,monto));
					break;
				case 4:
					System.out.print("CUI del cliente: ");
					cui = sc.next();
					CtrlClientes.verRegistro(cui);
					break;
				case 5:
					System.out.print("CUI del cliente: ");
					cui = sc.next();
					CtrlClientes.verActividadC(cui);
					break;
				case 6:
					System.out.println("Finalizado");
					break;
				default:
					System.out.println("Opción inválida");
			}
			System.out.println();
		}
		sc.close();
	}

}
