package Ambiente;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class Ambiente representa o ambiente onde o Agente opera 
 * @author João Cabral - 46357
 */
public class Ambiente {
	private File ficheiro;
	private ArrayList<ArrayList<Character>> ambiente; 
	
	
	/**
	 * Construtor da class
	 * @param ficheiro
	 */
	public Ambiente(File ficheiro) {
		this.ficheiro = ficheiro;
		this.ambiente = new ArrayList<ArrayList<Character>>();
		this.ambienteToArrayList();
	}
	
	
	/**
	 * O ambiente presente no ficheiro é armazenado, com o auxilio de ArrayList<Character>, de maneira a ser utilizado pelo Agente
	 */
	private void ambienteToArrayList() {
		try {
		      Scanner leitor = new Scanner(ficheiro);
		      while (leitor.hasNextLine()) {
		    	ArrayList<Character> linhaAmbiente = new ArrayList<Character>();
		        String data = leitor.nextLine();
		        for(int ind = 0; ind < data.length(); ind++) {
		        	char simbolo = data.charAt(ind);
		        	linhaAmbiente.add(simbolo);
		        }
		        this.ambiente.add(linhaAmbiente);
		      }
		      leitor.close();
	    }
		catch (FileNotFoundException e) {
		      System.out.println("Ocorreu um erro.");
		      e.printStackTrace();
		}
	}
	
	
	/**
	 * Devolve a posição no Ambiente
	 * @param x
	 * @param y
	 * @return posInAmbiente
	 */
	public char getPositionInAmbiente(int x, int y) {
		char posInAmbiente = this.ambiente.get(y).get(x);
		return posInAmbiente;
	}
	
	
	/**
	 * Visualização, em consola, do ambiente
	 */
	public void viewAmbiente() {
		System.out.println("<--- Ambiente de simulação --->");
		System.out.println("");
		for (int i = 0; i<ambiente.size(); i++) {
			for(int j = 0; j<ambiente.get(i).size(); j++) {
				System.out.print(ambiente.get(i).get(j));
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * Devolve o ambiente em forma de ArrayList
	 * @return this.ambiente
	 */
	public ArrayList<ArrayList<Character>> getAmbienteArrayList() {
		return this.ambiente;
	}
}