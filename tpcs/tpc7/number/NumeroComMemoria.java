package number;

/**
 * Esta classe representa um Numero Com Memoria. <p>
 *
 * Inclui todas as funcionalidades de Numero.  <p>
 * e possivel desfazer a ultima alteracao realizada. Se utilizarmos esta funcionalidade duas vezes o numero fica inalterado.
 *
 * Caso nao exista valor anterior e devolvido o proprio valor do numero.
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
 */

public class NumeroComMemoria extends Numero{

	/** int _valorAnterior guarda o ultimo valor de Numero
	*/
	private int _valorAnterior;

	/** {@inheritDoc}
	O ultimo valor e preservado.
	*
	* @param n Novo valor a atribuir a numero.
	*/
	@Override

	public void changeNum(int n) {
		_valorAnterior = getNum();
		super.changeNum(n);
	}

	/** Metodo atribui a Numero o valor que tinha antes de ser alterado.
	*/
	public void desfazer() {
		changeNum(_valorAnterior);
	}

	/** Metodo retorna o valor que NumeroComMemoria tinha antes de ser alterado
	*
	* @return valor Anterior
	*
	*/
	public int obtemValorAnterior() {
		return _valorAnterior;
	}

	public static void main(String[] args) {
		NumeroComMemoria n1 = new NumeroComMemoria();

		n1.changeNum(4);
		System.out.println("n1 = " + n1 );

		n1.desfazer();
		System.out.println("n1 = " + n1 );

		n1.desfazer();
		System.out.println("n1 = " + n1 );
	}
	}
