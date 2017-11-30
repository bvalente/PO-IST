/*codigo para (ser mais facil) ver se as funcoes booleanas estão a funcionar bem */

public class Garrafa{
	
	private String	 	_cor;
	private int 		_quantidade;	//medido em centilitros
	
	public Garrafa ( String cor ){
		
		_cor = new String (cor);
		_quantidade = 0;
		
	}
	
	public static void main(String[] args){
		Garrafa teste = new Garrafa("blue");
		Garrafa prova = new Garrafa("blue");

		addQuantidade(teste, 5);
		//System.out.println(teste._cor);
		printCor(teste);
		printQt(teste);

		compareGarrafa(teste, prova);
		addQuantidade(prova, 5);
		compareGarrafa(teste,prova);
	}
	static public void printCor(Garrafa a ){
		System.out.println(a._cor);
	}
	static public void printQt(Garrafa a ){
		System.out.println(a._quantidade);
	}
	static public boolean compareGarrafa ( Garrafa a , Garrafa b){
		if ( a._cor.equals(b._cor)) {//maneira correta de verificar se duas strings sao iguais
			System.out.println("a");
			
			if ( a._quantidade == b._quantidade ) {
				
				System.out.println("cona");
				return true;
			}
		}
		return false;
	}
	

	static public void addQuantidade ( Garrafa a , int x ){
		if (a._quantidade <= 100) 
			a._quantidade += x;
	}
	static public boolean emptyGarrafa ( Garrafa a ){
		return (a._quantidade == 0);
	}

}
