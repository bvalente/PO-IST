/*Exercicio de Programacao 3
 * 
 * Bernardo Valente
 * Francisco Chan Machado
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

}
