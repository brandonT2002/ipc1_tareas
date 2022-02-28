package Cuentas;
import java.util.Random;
import Transacciones.CtrlTransacciones;
public class CtrlCuentas {
	public static Cuenta[] cuentas = new Cuenta[30];
	public static boolean verificarId(String id) {
		for(Cuenta cuenta: cuentas) {
			if(cuenta != null && cuenta.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	public static boolean crearCuenta(String cui,String tipo,String id,double fondos) {
		for(int i = 0; i < cuentas.length; i++) {
			if(cuentas[i] == null) {
				cuentas[i] = new Cuenta(cui,tipo,id,fondos);
				return true;
			}
		}
		return false;
	}
	public static boolean verificarMontoI(double monto) {
		if(monto >= 100) return true;
		return false;
	}
	public static String generarId() {
		String id = "";
		for(int i = 1; i <= 4; i ++) {
			Random rnd = new Random();
			int digito = rnd.nextInt(10);
			id += digito;
		}
		return id;
	}
	public static boolean verificarSaldoD(String id,double monto) {
		for(Cuenta cuenta: cuentas) {
			if(cuenta != null && cuenta.getId().equals(id) && cuenta.getFondos() >= monto) {
				return true;
			}
		}
		return false;
	}
	public static boolean verificarSaldoD(String id) {
		for(Cuenta cuenta: cuentas) {
			if(cuenta != null && cuenta.getId().equals(id) && cuenta.getFondos() > 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean modMonto(String id,double monto) {
		for(int i = 0; i < cuentas.length; i++) {
			if(cuentas[i] != null && cuentas[i].getId().equals(id)) {
				cuentas[i] = new Cuenta(cuentas[i].getCui(),cuentas[i].getTipoCuenta(),cuentas[i].getId(),cuentas[i].getFondos() + monto);
				return true;
			}
		}
		return false;
	}
	public static void verCuenta(String cui) {
		for(Cuenta cuenta : cuentas) {
			if(cuenta != null && cuenta.getCui().equals(cui)) {
				System.out.printf("\t%-20s%-20s%-10s\n","No. Cuenta: " + cuenta.getId(), "Tipo: " + cuenta.getTipoCuenta(), "Fondos Disponibless: " + cuenta.getFondos());
			}
		}
	}
	public static void obtenerCuentas(String cui) {
		for(Cuenta cuenta : cuentas) {
			if(cuenta != null && cuenta.getCui().equals(cui)) {
				CtrlTransacciones.verTransacciones(cuenta.getId());
			}
		}
	}
}