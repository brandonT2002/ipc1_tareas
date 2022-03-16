package InterfazG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import Componentes.Boton;
import Componentes.Colores;
import Componentes.Etiqueta;
import Componentes.Texto;
import Datos.Ploteo;
//import static Datos.Ploteo.coordenadas;
public class Inicio extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Texto titulo;
	Boton abrir,generar;
	String ruta;
	JPanel marco;
	JPanel grafica;
	public Inicio() {
		super("Biblioteca");
		this.setLayout(null);
		this.setBounds(-10,0,1390,760);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Colores.blanco);
		
		elementos();
	}
	public
	void elementos() {
		marco = new JPanel();
		marco.setLayout(null);
		marco.setBackground(null);
		marco.setBounds(5,5,1355,703);
		marco.setBorder(BorderFactory.createLineBorder(Colores.azul3,3));
		add(marco);
		
		marco.add(new Etiqueta(90,60,60,30,"Título",Colores.celeste1,18,false));
		
		titulo = new Texto();
		titulo.setBounds(165,60,760,30);
		marco.add(titulo);
		
		abrir = new Boton("Abrir");
		abrir.ubicacion(940,60,150,30);
		abrir.texto(Colores.blanco,15);
		abrir.diseño(3,Colores.verde2,Colores.verde3);
		abrir.addActionListener(this);
		marco.add(abrir);
		
		generar = new Boton("Generar");
		generar.ubicacion(1105,60,150,30);
		generar.texto(Colores.blanco,15);
		generar.diseño(3,Colores.verde2,Colores.verde3);
		generar.addActionListener(this);
		marco.add(generar);
		
		generarG();
	}
	void actualizar() {
		grafica.setVisible(false);
		marco.remove(grafica);
		generarG();
	}
	void generarG() {
		grafica = new JPanel();
		grafica.setLayout(null);
		grafica.setBackground(Colores.blanco);
		grafica.setBounds(90,115,1165,520);
		grafica.removeAll();
		grafica.add(new Grafico(titulo.getText()));
		marco.add(grafica);
	}
	void examinar() {
    	JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	ruta = String.valueOf(chooser.getSelectedFile());
        }
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == abrir) {
			examinar();
		}
		else if(e.getSource() == generar) {
			if(ruta != null) {
				if(!titulo.getText().replace(" ","").equals("")) {
					Ploteo.limpiar();
					Ploteo.leer(ruta);
					actualizar();
					Grafico.saveImg();
					titulo.setText("");
					ruta = null;
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese un Título");
				}
			}else {
				JOptionPane.showMessageDialog(null, "No se ha cargado ningún archivo");
			}
		}
	}
}
