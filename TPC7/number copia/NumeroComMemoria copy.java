//hello :)

public class NumeroComMemoria {
	
	private Numero _atual;
	private Numero _anterior;
	
	public NumeroComMemoria(int x){
		_atual = new Numero( x );
	}
	
	public NumeroComMemoria( ){
		_atual = new Numero( );
	}
	
	public void alterarNumero ( int x ){
		if ( _anterior == null ){
			_anterior = new Numero( _atual);
		}
		else{
			_anterior.changeNum( _atual );
		}
		
		_atual.changeNum(x);
	}
	
	public void desfazer (){
		if (_anterior != null){
			Numero auxiliar = new Numero(_atual);
			_atual.changeNum(_anterior);
			_anterior.changeNum(auxiliar);
		}
	}
	
	public Numero getAnterior (){
		if (_anterior != null)
			return _atual;
		else
			return _anterior;
	}
}
