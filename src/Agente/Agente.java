package Agente;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.script.ScriptException;

import Agente.MoverAgente;
import Agente.Regista;
import Ambiente.Ambiente;
import A��o.Acoes;
import A��o.Atuador;
import A��o.AtuadorAvancar;
import Percepcao.Percepcao;
import Percepcao.SensorPanoramico;
import Processamento.Estado;
import Processamento.Processamento;

/**
 * Classe que representa o Agente
 * @author Jo�o Cabral - 46367
 */
public class Agente {
	private Ambiente ambiente;
	private MoverAgente moveAgente;
	public HashMap<Estado, Acoes> MovimentoAgente = new HashMap<>();
	private SensorPanoramico sp;
	private Percepcao percepcao;
	private Processamento processamento;
	private Atuador atuador;
	private Regista registaAcoes = new Regista("accoes.txt");
	
	/**
	 * Construtor da class Agente.
	 * @param ficheiro
	 */
	public Agente(File ficheiro) {
		this.ambiente = new Ambiente(ficheiro);
		this.moveAgente = new MoverAgente(this.ambiente);
		this.ambiente.viewAmbiente();
		this.sp = new SensorPanoramico(this.ambiente);
		this.percepcao = new Percepcao(this.sp);
		this.atuador = new AtuadorAvancar();
		this.processamento = new Processamento(this.percepcao);
	}
	
	
	/**
	 * M�todo que inicia a execu��o do sistema r�botico que este Agente representa
	 * @throws IOException 
	 * @throws ScriptException 
	 * @throws InterruptedException 
	 */
	public void executar() throws IOException, ScriptException, InterruptedException {
		System.out.println("In�cio da execu��o do Agente.");
		System.out.println(" ");
		while(this.processamento.getHaAlvosPorRecolher()) {
			this.processamento.executar(this);
		}
	}
	
	
	/**
	 * Devolve o mover do agente
	 */
	public MoverAgente getMoverAgente() {
		return this.moveAgente;
	}
	
	
	/**
	 * Devolve o ambiente
	 * @return ambiente
	 */
	public Ambiente getAmbiente() {
		return this.ambiente;
	}
	
	
	/**
	 * Devolve o atuador
	 * @return atuador
	 */
	public Atuador getAtuador() {
		return this.atuador;
	}
	
	
	/**
	 * Devolve o processamento do agente
	 * @return processamento
	 */
	public Processamento getProcessamento() {
		return this.processamento;
	}
	
	
	/**
	 * Devolve o registrador de a��es
	 * @return registaAcoes
	 */
	public Regista getRegistaAcoes() {
		return this.registaAcoes;
	}
}