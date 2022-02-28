package Cuentas;
public class Cuenta {
	private String cui;
	private String tipoCuenta;
	private String id;
	private double fondos;
	public Cuenta(String cui,String tipoCuenta,String id,double fondos) {
		this.setCui(cui);
		this.setTipoCuenta(tipoCuenta);
		this.setId(id);
		this.setFondos(fondos);
	}
	public String getCui() {
		return cui;
	}
	public void setCui(String cui) {
		this.cui = cui;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getFondos() {
		return fondos;
	}
	public void setFondos(double fondos) {
		this.fondos = fondos;
	}
}
