package Processamento;

/**
 * Classe que representa o estado
 * @author João Cabral - 46357
 */
public class Estado {
	private int x;
	private int y;
	private int id;

	/**
	 * Construtor da class
	 * @param x
	 * @param y
	 * @param id
	 */
	public Estado(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	@Override
	public int hashCode()
	{
	    return (this.x+1)*100 + this.y;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Estado state = (Estado)o;
	   if(this.x == state.x && this.y == state.y)
		   return true;
	   else
		   return false;
	}
	
	
	/**
	 * Devolve o valor de ID do estado
	 * @return this.id
	 */
	public int getID() {
		return this.id;
	}
	
	
	/**
	 * Devolve a coordenada X do estado
	 * @return this.x
	 */
	public int getX() {
		return this.x;
	}
	
	
	/**
	 * Devolve a coordenada Y do estado
	 * @return this.y
	 */
	public int getY() {
		return this.y;
	}
}