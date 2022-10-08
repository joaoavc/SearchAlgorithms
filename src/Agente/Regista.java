package Agente;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe responsável pelo registo de informação num ficheiro
 * @author João Cabral - 46357
 */
public class Regista {
	
	private String nomeFicheiro;
	
	/**
	 * Construtor da class
	 * @param filename
	 */
	public Regista(String filename)  {
		this.nomeFicheiro = filename;
		this.criaFicheiro(this.nomeFicheiro);
	}
	
	
	/**
	 * Registo no ficheiro
	 * @param avancou
	 */
	public void regista(String registo) {
		this.escreveFicheiro(this.nomeFicheiro, registo);
	}
	
	
	/**
	 * Cria um ficheiro com nome de ficheiro fornecido 
	 * @param filename
	 */
	public void criaFicheiro(String filename) {
		try {
		      File file = new File(filename);
		      if (file.createNewFile()) {
		        //System.out.println("Ficheiro criado: " + file.getName());
		      } 
		      else {
		    	  FileWriter empty = new FileWriter(filename);
		    	  empty.write("");
		    	  empty.close();
		        //System.out.println("Ficheiro já existe."); 
		      }
		 } 
		catch (IOException e) {
		      //System.out.println("Ocorreu um erro.");
		      e.printStackTrace();
		}
	}
	
	
	/**
	 * Definição de espaço que permite manter os ficheiros alinhados
	 * @param numChar
	 * @return espaco
	 */
	public static String getEspaco(int numChar) {
		String espaco = "";
		if(numChar == 12)
			espaco = "   ";
		else if(numChar == 13)
			espaco= "   ";
		else if(numChar == 14)
			espaco= "  ";
		else if(numChar == 15)
			espaco= " ";
		return espaco;
	}
	
	
	/**
	 * Escreve no ficheiro 
	 * @param filename
	 * @param name
	 */
	public void escreveFicheiro(String filename, String num){
		try {
			FileWriter myWriter = new FileWriter(filename, true);
		    myWriter.write(num+ "\n");
		    myWriter.close();
		      //System.out.println("Escreveu no ficheiro.");
		} 
		catch (IOException e) {
		     // System.out.println("Um erro ocorreu.");
		      e.printStackTrace();
		}
	}
}