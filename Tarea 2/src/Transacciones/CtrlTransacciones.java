package Transacciones;
public class CtrlTransacciones {
	public static Transaccion[] transacciones = new Transaccion[50];
	public static boolean verficarSaldo(double fondos) {
		for(Transaccion transaccion: transacciones) {
			if(transaccion != null && transaccion.getMontoTrasferencia() >= 0) {
				return true;
			}
		}
		return false;
	}
	public static boolean transferir(String idOrigen,String idDestino,double montoTransf) {
		for(int i = 0; i < transacciones.length; i++) {
			if(transacciones[i] == null) {
				transacciones[i] = new Transaccion(idOrigen,idDestino,montoTransf);
				return true;
			}
		}
		return false;
	}
	public static void verTransaccion(String cui) {
		for(Transaccion transaccion: transacciones) {
			if(transaccion != null) {
				System.out.printf("%-25s%-25s%-25s\n","Cuenta de Origen: " + transaccion.getIdOrigen(), "Cuenta de Destino: " + transaccion.getIdDestino(), "Saldo Transferido: " + transaccion.getMontoTrasferencia());
			}
		}
	}
	public static void verTransacciones(String id) {
		for(Transaccion transaccion: transacciones) {
			if(transaccion != null && (transaccion.getIdOrigen().equals(id) || transaccion.getIdDestino().equals(id)))	 {
				System.out.printf("\t%-25s%-25s%-25s\n","Cuenta de Origen: " + transaccion.getIdOrigen(), "Cuenta de Destino: " + transaccion.getIdDestino(), "Saldo Transferido: " + transaccion.getMontoTrasferencia());
			}
		}
	}
}
