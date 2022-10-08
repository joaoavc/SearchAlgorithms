package Ação;
import Agente.Agente;

/**
 * A classe Avancar representa o atuador responsável pela ação do agente - avançar
 * @author João Cabral - 46357
 */
public class AtuadorAvancar implements Atuador {
	
	private boolean avancou = false;

	/**
	 * Este metódo permite realizar o avanço do agente
	 */
	@Override
	public void realizarAcao(int x, int y, Agente agente) {
		agente.getMoverAgente().moverAgente(x, y);
		//String str = "O agente avança direcionado frontalmente para " + agente.getDirecao() + ".";
		//System.out.println(str);
		//System.out.println(" ");
		//ambiente.viewAmbiente();
		System.out.println(" ");
		this.setAvancou(true);
	}
	
	
	/**
	 * Define se avançou
	 * @param avancou
	 */
	public void setAvancou(boolean avancou) {
		this.avancou = avancou;
	}
	
	
	/**
	 * Devolve se avançou
	 * @return this.avancou
	 */
	public boolean getAvancou() {
		return this.avancou; 
	}
}