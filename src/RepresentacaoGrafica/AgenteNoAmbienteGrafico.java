package RepresentacaoGrafica;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Representação gráfica do agente
 * @author João Cabral - 46357
 */
@SuppressWarnings("serial")
public class AgenteNoAmbienteGrafico extends JPanel {
	private int raio = 25;
	private int localizacao = 0;
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK); 
        g.drawOval(localizacao+1, localizacao, raio, raio);
        g.setColor(Color.YELLOW);
        g.fillOval(localizacao+1, localizacao, raio, raio);
    }
}


