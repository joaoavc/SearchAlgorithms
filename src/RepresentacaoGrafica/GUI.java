package RepresentacaoGrafica;

import java.awt.Dimension;
import javax.swing.JPanel;
import Agente.Agente;
import Ambiente.Ambiente;

/**
 * Classe abstrata que representa as interfaces gráficas
 * @author João Cabral - 46357
 */
public abstract class GUI extends JPanel {
	
	protected static final long serialVersionUID = 1L;
	protected static final Dimension PREF_SIZE = new Dimension(35, 35);
	protected JPanel panel;
	protected Ambiente ambiente;
	protected Agente agente;
	
	/**
	 * Construtor da classe
	 * @param agente
	 */
	public GUI(Agente agente) {
		Seta.setAngulo();
		Seta.setDirecao();
		this.agente = agente;
		this.ambiente = this.agente.getAmbiente();
	}
	
	
	/**
	 * Criar o grid da GUI
	 */
	public abstract void createGrid();
}
