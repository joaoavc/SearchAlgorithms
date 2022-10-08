package Ação;

import Agente.Agente;


/**
 * A interface Atuador representa os metódos que todas as classes
 * que representam os atuadores necessitam de implementar. 
 * 
 * @author João Cabral - 46357
 *
 */
public interface Atuador {
	
	/**
	 * Metódo que permite realiza a ação relacionada com o atuador
	 * 
	 * @param ambiente
	 * @param x
	 * @param y
	 * @param agente
	 */
	
	public void realizarAcao( int x, int y, Agente agente);
}