package Processamento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptException;
import Agente.Agente;
import Agente.Regista;
import Ação.Acoes;


/**
 * Classe responsavel pelo os pedidos e tratamentos das respostas efetuados 
 * na comunicação com a aplicação python responsável pelo planeamento
 * @author João Cabral - 46357
 */
public class Planeamento {
	
	private Regista registaAcoes = new Regista("planos.txt");
	
	
	/**
	 * Define o pedido a realizar a aplicação python responsável pelo planeamento
	 * @param alvo
	 * @param estadoAtual
	 * @param agente
	 * @throws IOException
	 */
	public void setPedido(Estado alvo, Estado estadoAtual, Agente agente) throws IOException {
		Regista pedido = new Regista("planeamento\\pedido.txt");
		int atualX = estadoAtual.getX();
		int atualY = estadoAtual.getY();
		int alvoX = alvo.getX();
		int alvoY = alvo.getY();
		for (int i = 0; i<agente.getAmbiente().getAmbienteArrayList().size(); i++) {
			String str = "";
			for(int j = 0; j<agente.getAmbiente().getAmbienteArrayList().get(i).size(); j++) {
				str += agente.getAmbiente().getAmbienteArrayList().get(i).get(j);
			}
			pedido.regista(str);
		}
		pedido.regista(" ");
		pedido.regista(atualX+"");
		pedido.regista(atualY+"");
		pedido.regista(" ");
		pedido.regista(alvoX+"");
		pedido.regista(alvoY+"");
	}
	
	
	/**
	 * Ativação da aplicação python responsável pelo planeamento
	 * @throws ScriptException
	 * @throws IOException
	 */
	public static void realizaPedido() throws ScriptException, IOException {
		Planeamento.main(null);
	}
	
	
	/**
	 * Descodificação da resposta da plicação python, que representa o planeamento
	 * de ações até um determinado alvo
	 * @return acoes planeanadas pela aplicação python
	 */
	public ArrayList<Acoes> recebePlaneamento() {
		String str = "  <--- PLANO DE AÇÃO --->  ";
		this.registaAcoes.regista(str);
		ArrayList<Acoes> acoesPlaneadas = new ArrayList<Acoes>(); 
		try {
			Acoes acoesArr[] = Acoes.values();
			File ficheiro = new File("planeamento\\resposta.txt");
			Scanner leitor = new Scanner(ficheiro);
		    while (leitor.hasNextLine()) {
		      String acaoNum = leitor.nextLine();
		      int indexAcao = Integer.parseInt(acaoNum); 
		      acoesPlaneadas.add(acoesArr[indexAcao]);
		      str = acoesArr[indexAcao] + "";
		      this.registaAcoes.regista(str);
		    }
		    leitor.close();
		}
	    catch (FileNotFoundException e) {
	      System.out.println("Ocorreu um erro.");
	      e.printStackTrace();
	    }
		str = "-----------------------------";
		this.registaAcoes.regista(str);
		return acoesPlaneadas;
	}
	
	
	/**
	 * Main
	 * @param args
	 * @throws ScriptException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ScriptException, IOException {
		ProcessBuilder pb = new ProcessBuilder("python","planeamento\\planear.py");
		pb.start();
	}
}