package Percepcao;

/**
 * Class abstract Sensores, pai das classes que representam os diferentes cenarios 
 * quando os agentes estão de frente para diferentes direcções
 * 
 * @author João Cabral - 46357
 *
 */
public interface Sensores {
	
	/**
	 * Metodo utilizado na deteção de alvos nos diferentes possíveis tipos de sensores
	 */
	abstract void detetaAlvos();
}
