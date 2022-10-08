package Percepcao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import A��o.Acoes;
import Processamento.Estado;

/**
 * Classe que representa a percep��o do agente, fornecida pelo sensor panor�mico
 * @author Jo�o Cabral - 46357
 */
public class Percepcao {
	private SensorPanoramico sensorPanoramico;
	private List<Object> percepcao;
	private HashMap<Acoes, int[]> percepcaoAdjacente = new HashMap<>();
	
	/**
	 * Construtor da classe
	 * @param sensorPanoramico
	 */
	public Percepcao(SensorPanoramico sensorPanoramico) {
		this.setDirecaoDePercepcao();
		this.sensorPanoramico = sensorPanoramico;
		this.sensorPanoramico.setEstados();
		this.sensorPanoramico.detetaAlvos();
		percepcao = new ArrayList <Object>();
		percepcao.add(this.sensorPanoramico.getEstados());
		percepcao.add(this.sensorPanoramico.getAlvosList());
	}
	
	
	/**
	 * Devolve uma lista que cont�m a lista de estados(0) e a lista de alvos(1)
	 * @return percepcao
	 */
	public List<Object> percepcaoAmbiente(){
		return this.percepcao;
	}
	
	
	/**
	 * Devolve o estado adjacente correspondente ao estado e a��o fornecidas,
	 * caso haja um obastaculo adjacente nessa dire��o � devolvido o estado fornecido
	 * @param estado
	 * @param acao
	 * @return estadoSeguinte || estado
	 */
	public Estado estadoSeguinte(Estado estado, Acoes acao) {
		Estado estadoSeguinte = null;
		int [] direcao = percepcaoAdjacente.get(acao);
		int newX = estado.getX() + direcao[0];
		int newY = estado.getY() + direcao[1];
		char posicaoNoAmbiente = this.sensorPanoramico.getConstituinteDoAmbiente(newX, newY);
		boolean verificaPosicao = posicaoNoAmbiente != 'O';
		if(verificaPosicao) {
			estadoSeguinte = new Estado(newX, newY, 1);
			return estadoSeguinte;
		}
		return estado;
	}
	
	
	/**
	 * Devolve o mapeamento entre avan�os nas diferentes dire��es e o seu passo correspondente
	 * @return percepcaoAdjacente
	 */
	public HashMap<Acoes, int[]> getPercepcaoAdjacente(){
		return this.percepcaoAdjacente;
	}
	
	
	/**
	 * Devolve o sensor panor�mico
	 * @return sensorPanoramico
	 */
	public SensorPanoramico getSensorPanoramico() {
		return this.sensorPanoramico;
	}
	
	
	/**
	 * Redefine a percep��o (lista de alvos e lista de estados)
	 */
	public void resetPercepcao() {
		percepcao = new ArrayList <Object>();
		percepcao.add(this.sensorPanoramico.getEstados());
		percepcao.add(this.sensorPanoramico.getAlvosList());
	}
	
	
	/**
	 * Define o passo adjacente para as diferentes dire�oes
	 */
	public void setDirecaoDePercepcao() {
		int[] norte = {0, -1};
		int[] sul = {0, 1};
		int[] este = {1, 0};
		int[] oeste = {-1, 0};
		int[] nordeste = {1, -1};
		int[] noroeste = {-1, -1};
		int[] sudeste = {1, 1};
		int[] sudoeste = {-1, 1};
		percepcaoAdjacente.put(Acoes.AVAN�AR_NORTE, norte);
		percepcaoAdjacente.put(Acoes.AVAN�AR_SUL, sul);
		percepcaoAdjacente.put(Acoes.AVAN�AR_ESTE, este);
		percepcaoAdjacente.put(Acoes.AVAN�AR_OESTE, oeste);
		percepcaoAdjacente.put(Acoes.AVAN�AR_NORDESTE, nordeste);
		percepcaoAdjacente.put(Acoes.AVAN�AR_NOROESTE, noroeste);
		percepcaoAdjacente.put(Acoes.AVAN�AR_SUDESTE, sudeste);
		percepcaoAdjacente.put(Acoes.AVAN�AR_SUDOESTE, sudoeste);
	}
}