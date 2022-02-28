package Clientes;
public class Cliente {
	private String cui;
	private String nombre;
	private String apellido;
	public Cliente(String cui,String nombre,String apellido) {
		this.setCui(cui);
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	public String getCui() {
		return cui;
	}
	public void setCui(String cui) {
		this.cui = cui;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
