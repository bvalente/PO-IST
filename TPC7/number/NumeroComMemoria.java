package number;

/**
 * Esta classe representa um Numero Com Memoria. <p>
 *
 * Inclui todas as funcionalidades de Numero.  <p>
 * É possivel desfazer a ultima alteração realizada. Se utilizarmos esta funcionalidade duas vezes o numero fica inalterado.
 *
 * Caso não exista valor anterior é devolvido o próprio valor do número.
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
 */

public class NumeroComMemoria extends Numero{
	
	private int _valorAnterior;

	public void alteraValor(int n) {
		_valorAnterior = obtemValor();
		super.alteraValor(n);
	}

	public void desfazer() {
		alteraValor(_valorAnterior);
	}

	public int obtemValorAnterior() {
		return _valorAnterior;
	}

	public static void main(String[] args) {
		NumeroComMemoria n1 = new NumeroComMemoria();

		n1.alteraValor(4);
		System.out.println("n1 = " + n1 );

		n1.desfazer();
		System.out.println("n1 = " + n1 );

		n1.desfazer();
		System.out.println("n1 = " + n1 );
	}
	}
