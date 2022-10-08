package Agente;
import java.util.ArrayList;
import Ambiente.Ambiente;

/**
 * Class MoverAgente, class que realiza o movimento do agente no ambiente
 * @author João Cabral - 46357
 */
public class MoverAgente {
	private Ambiente ambiente;
	private ArrayList<ArrayList<Character>> ambienteArrayList;
	
	/**
	 * Construtor da class
	 * @param ambiente
	 * @param agente
	 */
	public MoverAgente(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.ambienteArrayList = this.ambiente.getAmbienteArrayList();
	}
	
	
	/**
	 * Movimentação do agente no ambiente
	 * @param x
	 * @param y
	 */
	public void moverAgente(int x, int y) {
		int[] agentCoords = getAgentePosition();
		this.ambienteArrayList.get(agentCoords[0]).set(agentCoords[1], '*');
		this.ambienteArrayList.get(y).set(x, '>');
	}
	
	
	/**
	 * Retorna a posição do agente no ambiente
	 * @return agenteCoords
	 * @return null
	 */
	public int[] getAgentePosition(){
		for (int i = 0; i<this.ambienteArrayList.size(); i++) {
			for(int j = 0; j<this.ambienteArrayList.get(i).size(); j++) {
				if(this.ambienteArrayList.get(i).get(j) == '>') {
					int [] agenteCoords = {i, j};
					return  agenteCoords;
				}
			}
		}
		return null;
	}
}