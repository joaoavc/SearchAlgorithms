package A��o;

import Agente.Agente;


/**
 * A interface Atuador representa os met�dos que todas as classes
 * que representam os atuadores necessitam de implementar. 
 * 
 * @author Jo�o Cabral - 46357
 *
 */
public interface Atuador {
	
	/**
	 * Met�do que permite realiza a a��o relacionada com o atuador
	 * 
	 * @param ambiente
	 * @param x
	 * @param y
	 * @param agente
	 */
	
	public void realizarAcao( int x, int y, Agente agente);
}