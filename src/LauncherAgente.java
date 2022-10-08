import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Agente.Agente;
import RepresentacaoGrafica.AmbienteGUI;


/**
 * Class responsavel pelo inicio da execução do agente
 * @author João Cabral - 46357
 */
public class LauncherAgente {
	
	/**
	 * Criar e mostrar a GUI do Ambiente de Smulação
	 * @param agente
	 */
	private static void createAndShowGuiA(Agente agente) {
		JFrame frame = new JFrame("Ambiente de Simulação");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(new AmbienteGUI(agente));
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true); 
	    frame.pack();
	    frame.setBounds(10,10,1000,1000);
	}
	
	
	/**
	 * Main do launcher do agente
	 * @param args
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws InvocationTargetException, InterruptedException, IOException, ScriptException {
		System.out.println("[X] INÍCIO DA APLICAÇÃO [X]");
		System.out.println(" ");
		System.out.println(" ");
		File ficheiro = new File("amb_p3.das");
		Agente agente = new Agente(ficheiro);
		agente.executar();
		SwingUtilities.invokeAndWait (new Runnable() {
	         public void run() {
	            createAndShowGuiA(agente);
	         }
	      });
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("[X] FIM DA APLICAÇÃO [X]");
	}
}