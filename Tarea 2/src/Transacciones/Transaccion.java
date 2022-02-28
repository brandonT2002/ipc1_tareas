package Transacciones;

public class Transaccion {
	private String idOrigen;
	private String idDestino;
	private double montoTrasferencia;
	public Transaccion(String idOrigen,String idDestino,double montoTransferencia) {
		this.setIdOrigen(idOrigen);
		this.setIdDestino(idDestino);
		this.setMontoTrasferencia(montoTransferencia);
	}
	public String getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}
	public String getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}
	public double getMontoTrasferencia() {
		return montoTrasferencia;
	}
	public void setMontoTrasferencia(double montoTrasferencia) {
		this.montoTrasferencia = montoTrasferencia;
	}
}
