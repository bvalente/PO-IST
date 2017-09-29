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
 */
 
public class Garrafa{
	
	private String	 	_cor;
	private int 		_quantidade;	//medido em centilitros
	
	public Garrafa ( String cor ){
		
		_cor = new String (cor);
		_quantidade = 0;
		
	}
	
	public static void main(String[] args){
		/*Garrafa teste = new Garrafa("blue");
		Garrafa prova = new Garrafa("blue");

		addQuantidade(teste, 5);
		//System.out.println(teste._cor);
		printCor(teste);
		printQt(teste);

		compareGarrafa(teste, prova);
		addQuantidade(prova, 5);
		compareGarrafa(teste,prova);
	*/
	}
	static public void printCor(Garrafa a ){
		System.out.println(a._cor);
	}
	static public void printQt(Garrafa a ){
		System.out.println(a._quantidade);
	}
	static public boolean compareGarrafa ( Garrafa a , Garrafa b){
		if ( a._cor.equals(b._cor)){//maneira correta de verificar se duas strings sao iguais
			return ( a._quantidade == b._quantidade )
		}
	}
				
	static public void addQuantidade ( Garrafa a , int x ){
		if (a._quantidade <= 100) 
			a._quantidade += x;
	}
	static public boolean emptyGarrafa ( Garrafa a ){
		return (a._quantidade == 0);
	}

}
