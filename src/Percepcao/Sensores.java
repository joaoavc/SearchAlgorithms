package Percepcao;

/**
 * Class abstract Sensores, pai das classes que representam os diferentes cenarios 
 * quando os agentes est�o de frente para diferentes direc��es
 * 
 * @author Jo�o Cabral - 46357
 *
 */
public interface Sensores {
	
	/**
	 * Metodo utilizado na dete��o de alvos nos diferentes poss�veis tipos de sensores
	 */
	abstract void detetaAlvos();
}
