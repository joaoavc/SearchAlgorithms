package Percepcao;
import java.util.ArrayList;
import java.util.List;
import Ambiente.Ambiente;
import Processamento.Estado;

/**
 * A classe SensorPanoramico representa o sensor panorâmico que o agente possui
 * @author João Cabral - 46357
 */
public class SensorPanoramico implements Sensores {
	private Ambiente ambiente;
	ArrayList<ArrayList<Character>> ambienteList;
	private ArrayList<Estado> alvosList = new ArrayList<Estado>();
	private List<Estado> estados;
	
	
	/**
	 * Construtor da classe
	 * @param ambiente
	 */
	public SensorPanoramico(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.ambienteList = this.ambiente.getAmbienteArrayList();
		this.detetaAlvos();
	}
	
	
	/**
	 * Preenchimento da lista de estados possíveis do agente
	 */
	public void setEstados(){
		this.estados = new ArrayList<Estado>();
		for (int i = 0; i<this.ambienteList.size(); i++) {
			for(int j = 0; j<this.ambienteList.get(i).size(); j++) {
				char pos = this.ambienteList.get(i).get(j);
				if (pos!= 'O') {
					Estado state = new Estado(j, i, 1);
					estados.add(state);
				}
			}
		}
	}
	
	
	/**
	 * Deteção dos alvos presentes no ambiente
	 */
	@Override
	public void detetaAlvos() {
		alvosList = new ArrayList<Estado>();
		for (int i = 0; i<ambienteList.size(); i++) {
			for(int j = 0; j<ambienteList.get(i).size(); j++) {
				char pos = ambienteList.get(i).get(j);
				if (pos == 'A') {
					Estado state = new Estado(j, i, 1);
					this.alvosList.add(state);
				}
			}
		}		
	}
	
	
	/**
	 * Devolve a lista de estados possíveis do agente
	 * @return estados
	 */
	public List<Estado> getEstados(){
		return this.estados;
	}
	
	
	/**
	 * Devolve a lista de alvos
	 * @return
	 */
	public List<Estado> getAlvosList() {
		return this.alvosList;
	}
	
	
	/**
	 * Devolve o caracter correspondente a representação do ambiente na posição fornecida
	 * @param x
	 * @param y
	 * @return representacaoAmbiente
	 */
	public char getConstituinteDoAmbiente(int x, int y) {
		char representacaoAmbiente = this.ambiente.getPositionInAmbiente(x, y);
		return representacaoAmbiente;
	}
	
	
	/**
	 * Remove o alvo da lista de alvos
	 * @param estado
	 */
	public boolean removeAlvo(Estado estado) {
		return this.alvosList.remove(estado);
	}
}