
public class Numero{
	
	//variaveis
	private int _num;
	
	//construtores
	public Numero(int num){
		_num = num;
	}
	public Numero(){
		_num = 0;
	}
	
	//main
	public static void main(String [] argv){
		System.out.println("Hello World!");
	}
	
	//metodos
	public int getNum(){
		return _num;
	}
	
	public void changeNum(int newNum){
		_num = newNum;
	}
	
	public void printNum(){
		System.out.println( _num );
	}
	
	public boolean compareNum(Numero x){
		return _num == x._num;
	}
}

