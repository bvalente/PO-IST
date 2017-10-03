public class NandGate{

	private boolean _entrada1;
	private boolean _entrada2;
	
	public NandGate( boolean value1, boolean value2 ){
		_entrada1 = value1;
		_entrada2 = value2;
		
	}
	
	public void changeE1( boolean valor ){
		_entrada1 = valor;
	}
	
	public void changeE2( boolean valor ){
		_entrada2 = valor;
	}

	public boolean getOutput(){
		return ! (_entrada1 && _entrada2);
	}

	public String printResultado(){
		String value1 = Boolean.toString(_entrada1);
		String value2 = Boolean.toString(_entrada2);
		String result = Boolean.toString(this.getOutput());
		
		return value1 + " NAND " + value2 + " = " + result;
	}
		
	public static void main(String[] args){
		NandGate a = new NandGate();
		System.out.println(a.printResultado);
	}
}
