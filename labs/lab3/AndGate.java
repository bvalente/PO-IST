public class AndGate{
	
	private boolean _entrada1;
	private boolean _entrada2;
	
	public AndGate(){
		_entrada1 = false;
		_entrada2 = false;
	}
	
	public void changeE1( boolean valor ){
		_entrada1 = valor;
	}
	
	public void changeE2( boolean valor ){
		_entrada2 = valor;
	}
	
	public boolean getOutput (){
		return _entrada1 && _entrada2;
		
	}
	public boolean getE1(){
		return _entrada1;
	}
	public boolean getE2(){
		return _entrada2;
	}
	
	
	static public void main (String[] argv){
		System.out.print("Hello");
	}
}
