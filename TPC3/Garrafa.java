/*Exercicio de Programacao 3
 * 
 * Bernardo Valente
 * Francisco Chan Machado
 *
 * Unica cena que não percebo e pode faltar:
 * "Deve ser possível acrescentar mais líquido a uma garrafa até a garrafa ficar cheia. 
 * Esta funcionalidade deve indicar a quantidade de líquido 
 * (medido em centilitros) a acrescentar à garrafa."
 * Q: addQuantidade dever mostrar a quantidade de liquido na garrafa?  
 * 
 * A: Acho que deve ser para fazer return da quantidade de liquido que realmente entrou na garrafa
 * Exemplo, garrafa tem 60,  adicionas 50, faz return de 40 ( porque fica cheio )
 * vou fazer esse codigo, depois vemos como fica
 */
 
public class Garrafa{
	
	private String	 	_cor;
	private int 		_quantidade;	//medido em centilitros
	
	public Garrafa ( String cor ){
		
		_cor = new String (cor);
		_quantidade = 0;
		
	}
	
	public void printCor( ){
		System.out.println( _cor );
	}
	
	public void printQt( ){
		System.out.println( _quantidade );
	}
	
	public String getCor( ){
		return new String(_cor);
		//assim devolvemos a cor, mas nao comprometemos o ponteiro privado da classe
	}
	
	public boolean compareGarrafa ( Garrafa b ){
		return _cor.equals( b._cor ) && _quantidade == b._quantidade;		
	}
				
	public int addQuantidade ( int x ){
		int adicionado;
		if ( _quantidade + x > 100 ) {
			adicionado = 100 - _quantidade;
			_quantidade = 100;
			return adicionado;
		}
		else {
			adicionado = x;
			_quantidade += adicionado;
			return adicionado;
		}
	}
	
	public void emptyGarrafa ( ){
		_quantidade = 0;
	}
	
	public boolean isEmpty ( ){
		return _quantidade == 0;
	}
	
	/* DEVELOPING HELP */
	
	public static void main (String[] args){
		Garrafa a = new Garrafa("azul");
		Garrafa b = new Garrafa("vermelho");
		Garrafa c = new Garrafa("vermelho");
		
		a.printCor();
		a.printQt();
		
		System.out.println( a.isEmpty() );
		System.out.println( a.addQuantidade( 60 ) );
		System.out.println( a.addQuantidade( 60 ) );
		System.out.println( a.isEmpty() );
		
		b.addQuantidade( 50 );
		c.addQuantidade( 50 );
		
		System.out.println( b.compareGarrafa( c ) );
		
		
	}
	/* */

}
