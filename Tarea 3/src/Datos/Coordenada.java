package Datos;
public class Coordenada {
	private String titulo;
	private int valores;
	public Coordenada(String titulo, int valores) {
		this.setTitulo(titulo);
		this.setValores(valores);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getValores() {
		return valores;
	}
	public void setValores(int valores) {
		this.valores = valores;
	}
}
