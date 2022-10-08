package Processamento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptException;
import Agente.Agente;
import Ação.Acoes;
import Percepcao.Percepcao;
import RepresentacaoGrafica.Seta;

/**
 * A classe Processamento representa o processamento efectuado pelo agente
 * @author João Cabral - 46357
 */
public class Processamento {
	private Percepcao percepcao;
	private boolean haAlvosPorRecolher = true;
	private List<Acoes> acoesPlaneadas;
	private Planeamento planeamento;
	
	/**
	 * Construtor da classe
	 * @param percepcao
	 * @param atuador
	 */
	public Processamento( Percepcao percepcao) {
		this.percepcao = percepcao;
		Seta.setDirecao();
		this.acoesPlaneadas = new ArrayList<Acoes>();
		this.planeamento = new Planeamento();
	}
	
	
	/**
	 * Executa o processamento
	 * @param agente
	 * @throws IOException 
	 * @throws ScriptException 
	 * @throws InterruptedException 
	 */
	public void executar(Agente agente) throws IOException, ScriptException, InterruptedException {
		
		Estado estado = this.estadoAtualAgente(agente);
		Estado estadoAlvo = this.getAlvoPorRecolher();
		this.planeamento.setPedido(estadoAlvo, estado, agente);
		Planeamento.realizaPedido();
		Thread.sleep(500);
		this.acoesPlaneadas = this.planeamento.recebePlaneamento();
		this.realizaCaminhoPlaneado(agente);
	}
	
	
	/**
	 * Açoes realizadas caso um Alvo seja recolhido
	 * @param pos
	 * @param agente
	 */
	private void alvoEncontrado(char pos, Agente agente) {
		if(pos == 'A') { // Alvo recolhido
			System.out.println("ALVO RECOLHIDO!!");
			System.out.println(" ");
			agente.getAmbiente().viewAmbiente();
			System.out.println(" ");
			this.percepcao.getSensorPanoramico().detetaAlvos();
			this.percepcao.resetPercepcao();
		}
	}
	
	
	/**
	 * Devolve se ainda há alvos por recolher
	 * @return
	 */
	public boolean getHaAlvosPorRecolher() {
		return this.haAlvosPorRecolher;
	}
	
	
	/**
	 * Define o número de alvos que falta recolher
	 * @return
	 */
	private int numDeAlvosPorRecolher() {
		return this.percepcao.getSensorPanoramico().getAlvosList().size();
	}
	
	
	/**
	 * Define se há ainda ha alvos por recolher 
	 * @param alvosPR
	 */
	private void setHaAlvosPorRecolher(boolean alvosPR) {
		this.haAlvosPorRecolher = alvosPR;
	}
	
	
	/**
	 * O agente realiza o caminho planeado, e regista esse caminho realizado
	 * 
	 * @param agente
	 */
	private void realizaCaminhoPlaneado(Agente agente) {
		for (Acoes acao : this.acoesPlaneadas) {
			int[]nextStep = this.percepcao.getPercepcaoAdjacente().get(acao);
			Estado estado = this.estadoAtualAgente(agente);
			String str = "MOVER(" + Seta.AcaoDirecao.get(acao) +")";
			agente.getRegistaAcoes().regista(str);
			agente.MovimentoAgente.put(estado, acao);
			int nextX = estado.getX()+nextStep[0];
			int nextY = estado.getY()+nextStep[1];
			char pos = agente.getAmbiente().getPositionInAmbiente(nextX, nextY);
			agente.getAtuador().realizarAcao(nextX, nextY, agente);
			this.alvoEncontrado(pos, agente);
			if(this.numDeAlvosPorRecolher() == 0) {
				this.setHaAlvosPorRecolher(false);
			}
		}
	}
	
	
	/**
	 * Devolve o estado atual do agente
	 * @param agente
	 * @return estado
	 */
	private Estado estadoAtualAgente(Agente agente) {
		int[] agenteCoords = agente.getMoverAgente().getAgentePosition();
		int y = agenteCoords[0];
		int x = agenteCoords[1];
		Estado estado = new Estado(x, y, 1);
		return estado;
	}
	
	
	/**
	 * Devolve alvos ainda não recolhidos
	 * @return alvo por recolher
	 */
	private Estado getAlvoPorRecolher() {
		return this.percepcao.getSensorPanoramico().getAlvosList().get(0);
	}
}