
public class TrenaryAndGate{
	
	private boolean _entrada1;
	private boolean _entrada2;
	private boolean _entrada3;
	
	public TrenaryAndGate(){
		_entrada1 = false;
		_entrada2 = false;
		_entrada3 = false;
	}
	
	public void changeE1( boolean valor ){
		_entrada1 = valor;
	}
	
	public void changeE2( boolean valor ){
		_entrada2 = valor;
	}

	public void changeE3( boolean valor ){
		_entrada3 = valor;
	}
	
	public boolean getOutput (){
		AndGate gate1 = new AndGate();
		AndGate gate2 = new AndGate();
		
		gate1.changeE1(_entrada1);
		gate1.changeE2(_entrada2);
		gate2.changeE1(gate1.getOutput());
		gate2.changeE2(_entrada3);
		
		return gate2.getOutput();
		
	}
	
	public boolean getE1(){
		return _entrada1;
	}
	public boolean getE2(){
		return _entrada2;
	}
	public boolean getE3(){
		return _entrada3;
	}
	
	
	static public void main (String[] argv){
		System.out.print("Hello");
	}
	
}
