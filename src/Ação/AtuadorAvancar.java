package A��o;
import Agente.Agente;

/**
 * A classe Avancar representa o atuador respons�vel pela a��o do agente - avan�ar
 * @author Jo�o Cabral - 46357
 */
public class AtuadorAvancar implements Atuador {
	
	private boolean avancou = false;

	/**
	 * Este met�do permite realizar o avan�o do agente
	 */
	@Override
	public void realizarAcao(int x, int y, Agente agente) {
		agente.getMoverAgente().moverAgente(x, y);
		//String str = "O agente avan�a direcionado frontalmente para " + agente.getDirecao() + ".";
		//System.out.println(str);
		//System.out.println(" ");
		//ambiente.viewAmbiente();
		System.out.println(" ");
		this.setAvancou(true);
	}
	
	
	/**
	 * Define se avan�ou
	 * @param avancou
	 */
	public void setAvancou(boolean avancou) {
		this.avancou = avancou;
	}
	
	
	/**
	 * Devolve se avan�ou
	 * @return this.avancou
	 */
	public boolean getAvancou() {
		return this.avancou; 
	}
}