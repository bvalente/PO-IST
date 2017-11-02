package number;

/**
 * Esta classe representa um Numero inteiro. <p>
 * E possivel saber o valor representado pelo numero bem como alterá-lo. <p>
 * As funcionalidades desta classe ainda permitem representar um numero numa
 * String e comparar dois numeros. <p>
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
 */

public class Numero{

	/** int_num corresponde ao valor inteiro de Numero.
	*/
	private int _num;

	/** Construtor de um Numero
	*
	*  @param num E o valor atribuido ao numero.
	*/
	public Numero(int num){
		_num = num;
	}
	/** Cria uma instancia que inicialmente representa o valor 0.
	*/
	public Numero(){
		_num = 0;
	}

	/** Constructor de um Numero
	*
	*  @param x._num E o valor atribuido ao numero.
	*/
	public Numero(Numero x){
		_num = x._num;
	}

	//main
	public static void main(String [] argv){
		System.out.println("Hello World!");
	}

	/** Metodo retorna o valor inteiro de um Numero.
	* A este metodo nao sao passados quaisquer argumentos.
	*
	* @return valor inteiro de Numero
	*/
	public int getNum(){
		return _num;
	}
	/** Metodo altera o valor de um Numero.
	* E passado como argumento um inteiro, este valor sera atribuido ao Numero.
	*
	* @param newNum valor atribuido ao Numero.
	*/
	public void changeNum(int newNum){
		_num = newNum;
	}

	/** Metodo altera o valor de um Numero.
	* E passado como argumento um Numero com um valor que E atribuido ao Numero.
	*
	* @param newNum Numero com um valor que E atribuido ao Numero.
	*/
	public void changeNum(Numero newNum){
		_num = newNum._num;
	}

	/** Devolve o numero representado por uma dada instância como uma String.
	*
	*/
	public void printNum(){
		System.out.println( _num );
	}

	/** Metodo compara duas instancias de Numero.
	* Retorna um valor booleano.
	*
	* @param x Numero a comparar.
	* @return Valor inteiro de um Numero x
	*/
	public boolean compareNum(Numero x){
		return _num == x.getNum();
	}
}
