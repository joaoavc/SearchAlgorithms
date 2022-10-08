package RepresentacaoGrafica;

import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.*;
import Agente.Agente;
import Agente.PontoCardeal;
import A��o.Acoes;
import Processamento.Estado;

/**
 * Representa��o gr�fica de o ambiente de simula��o
 * @author Jo�o Cabral - 46357
 */
@SuppressWarnings("serial")
public class AmbienteGUI extends GUI {

	
	/**
	 * Construtor da classe
	 * @param agente
	 */
   public AmbienteGUI(Agente agente) {
	  super(agente);
	  createGrid();
   }

   
   /**
    * Cria��o do grid correspondente ao ambiente
    */
   @Override
   public void createGrid() { 
	  setLayout(new GridLayout(32, 32, 1, 1));
      for (int i = 0; i<32; i++) {
			for(int j = 0; j<32; j++) {
				JPanel panel;
		        if(ambiente.getPositionInAmbiente(j, i) == 'O') {
		        	panel = new JPanel();
		            panel.setBackground(Color.GRAY);
		        }
		        else if(ambiente.getPositionInAmbiente(j, i) == 'A') {
		        	panel = new JPanel();
			        panel.setBackground(Color.GREEN);
		        }
		        else if(ambiente.getPositionInAmbiente(j, i) == '*') {
		        	Estado estado = new Estado(j, i, 1);
		        	Acoes acao = agente.MovimentoAgente.get(estado);
		        	PontoCardeal direcao = Seta.AcaoDirecao.get(acao);
		        	panel = new Seta(direcao, Color.BLACK);
		        	panel.setBackground(new Color(255,255,224));
		        }
		        else if(ambiente.getPositionInAmbiente(j, i) == '>') {
		        	panel = new AgenteNoAmbienteGrafico();
		        }
		        else {
		        	panel = new JPanel();
		        	panel.setBackground(Color.WHITE);
		        }
		        add(panel);
		        panel.setPreferredSize(PREF_SIZE);
		        setBackground(Color.BLACK);
			}
      	}
   }
}