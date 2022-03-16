package Datos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ploteo {
	public static Coordenada[] coordenadas = new Coordenada[100];
	
	public static void leer(String ruta) {
		try {
			BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream(ruta),"utf-8"));
			Scanner sc = new Scanner(archivo);
			String[] actual;
			Coordenada cord;
			while(sc.hasNextLine()) {
				try {
					actual = sc.nextLine().split(",");
					cord = new Coordenada(actual[0],Integer.parseInt(actual[1]));
					insertar(cord);
				}catch(Exception e) {
					
				}
			}
			sc.close();
			//imprimir();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error de lectura");
		}
	}
	public static boolean insertar(Coordenada cord) {
		for(int i = 0; i < coordenadas.length; i++) {
			if(coordenadas[i] == null) {
				coordenadas[i] = cord;
				return true;
			}
		}
		return false;
	}
	public static boolean limpiar() {
		for(int i = 0; i < coordenadas.length; i++) {
			if(coordenadas[i] != null) {
				coordenadas[i] = null;
			}else {
				return true;
			}
		}
		return true;
	}
	public static void imprimir() {
		for(int i = 0; i < coordenadas.length; i++) {
			if(coordenadas[i] != null) {
				System.out.println(coordenadas[i].getValores() + " " + coordenadas[i].getTitulo());
			}
		}
	}
}
