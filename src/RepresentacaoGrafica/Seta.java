package RepresentacaoGrafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.HashMap;
import javax.swing.JPanel;
import Agente.PontoCardeal;
import A��o.Acoes;

/**
 * Representa��o gr�fica de uma seta
 * @author Jo�o Cabral - 46357
 */
@SuppressWarnings("serial")
public class Seta extends JPanel{
	Path2D arrow = new Arrow();
	double theta = 0;
	PontoCardeal direcao;
	protected static HashMap<PontoCardeal, Integer> AnguloMovimento = new HashMap<>();
	public static HashMap<Acoes, PontoCardeal> AcaoDirecao = new HashMap<>();
	private Color c;
	
	/**
	 * Construtor da classe
	 * @param direcao
	 * @param c
	 */
	public Seta(PontoCardeal direcao, Color c) {
		this.direcao = direcao;
		this.c = c;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.c);
		if(this.direcao == null)
			this.theta = 0;
		else
			this.theta = AnguloMovimento.get(this.direcao);
	    Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        double x = (getWidth() - arrow.getBounds().getWidth()) / 2d;
        double y = (getHeight() - arrow.getBounds().getHeight()) / 2d;
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.rotate(Math.toRadians(this.theta), arrow.getBounds().getWidth() / 2d, arrow.getBounds().getHeight() / 2d);
        Shape s = at.createTransformedShape( arrow );
        g2d.draw(s);
        g2d.dispose();
	}
	
	
	/**
	 * Defini��o dos angulos correspondentes as dire�oes
	 * e das A�oes correspondentes a dire��es
	 */
	public static void setAngulo() {
		AnguloMovimento.put(PontoCardeal.ESTE, 0);
		AnguloMovimento.put(PontoCardeal.SUDESTE, 45);
		AnguloMovimento.put(PontoCardeal.SUL, 90);
		AnguloMovimento.put(PontoCardeal.SUDOESTE, 135);
		AnguloMovimento.put(PontoCardeal.OESTE, 180);
		AnguloMovimento.put(PontoCardeal.NOROESTE, 225);
		AnguloMovimento.put(PontoCardeal.NORTE, 270);
		AnguloMovimento.put(PontoCardeal.NORDESTE, 315);
	}
	
	
	/**
	 * Defini��o de a��es correspondentes a dire��es
	 */
	public static void setDirecao() {
		AcaoDirecao.put(Acoes.AVAN�AR_ESTE, PontoCardeal.ESTE);
		AcaoDirecao.put(Acoes.AVAN�AR_SUDESTE, PontoCardeal.SUDESTE);
		AcaoDirecao.put(Acoes.AVAN�AR_SUL, PontoCardeal.SUL);
		AcaoDirecao.put(Acoes.AVAN�AR_SUDOESTE, PontoCardeal.SUDOESTE);
		AcaoDirecao.put(Acoes.AVAN�AR_OESTE, PontoCardeal.OESTE);
		AcaoDirecao.put(Acoes.AVAN�AR_NOROESTE, PontoCardeal.NOROESTE);
		AcaoDirecao.put(Acoes.AVAN�AR_NORTE, PontoCardeal.NORTE);
		AcaoDirecao.put(Acoes.AVAN�AR_NORDESTE, PontoCardeal.NORDESTE);
	}


/**
 * Classe que representa o desenho de uma seta
 * @author Jo�o Cabral - 46357
 */
	public class Arrow extends Path2D.Double {
	    public Arrow() {
	        moveTo(0, 10);
	        lineTo(35, 10);
	        moveTo(35 - 15, 0);
	        lineTo(35, 10);
	        moveTo(35 - 15, 20);
	        lineTo(35, 10);
	    }
	}
}