package InterfazG;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils; 
import Datos.Coordenada;
import static Datos.Ploteo.coordenadas;

import java.io.File;
import java.io.IOException;

public class Grafico extends JPanel{
	static JFreeChart chart;
	private static final long serialVersionUID = 1L;
    public Grafico(String titulo){
    	setBounds(0,0,1165,520);
        setVisible(true);
        init(titulo);
    }

    public void init(String titulo) {
        // Creando el Grafico
        chart = ChartFactory.createBarChart(
        		titulo,
        		"x",
        		"y", 
        		dataset(),
        		PlotOrientation.VERTICAL, true,true, false
        );
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(getWidth(),getHeight()));
        add(chartPanel);
    }
    private DefaultCategoryDataset dataset() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	for(Coordenada coord : coordenadas) {
    		if(coord != null) {
    			dataset.setValue(coord.getValores(), coord.getTitulo(),"");
    		}
    	}
        return dataset;
    }
    public static void saveImg() {
    	int width=640;
        int height=480;               
        File lineChart=new File("Grafica.png");              
        try {
			ChartUtils.saveChartAsPNG(lineChart, chart, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}