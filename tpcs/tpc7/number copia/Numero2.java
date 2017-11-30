package number;
/**
 * This class represents a number. <p>
 *
 * @author Francisco Machado
 * @author Bernardo Valente
 * @version 1.0
 */

public class Numero {
    
    /**
     * Guarda o valor do numero
     */
    private int _valor;
    
    /**
     *	Construtor que nao recebe argumentos e inicia o numero a 0
     */
    public Numero() {
        _valor = 0;
    }
    
    /**
     *	Construtor que recebe como argumento um valor e inicia o numero com esse valor
     */
    public Numero(int x){
        _valor = x;
    }
    
    /**
     *	Altera o valor do numero pelo valor que recebe como argumento
     */
    public void alteraValor(int n) {
        _valor = n;
    }
    
    /**
     *	Retorna o valor do numero
     */
    public int obtemValor() {
        return _valor;
    }
    
    /**
     *	Retorna o numero no formato de String
     */
    public String toString() {
        return "" + _valor;
    }
    
    /**
     *	Recebe um numero e compara-o com o valor do numero da propria class, retornando um boolean
     */
    public boolean eIgual(Numero n) {
        return _valor == n.obtemValor();
    }
    
    public static void main(String[] args) {
        Numero n1 = new Numero();
        Numero n2 = new Numero();
        
        System.out.println("n1.valor = " + n1.obtemValor());
        System.out.println("n1 == n2 -> " + n1.eIgual(n2));
        
        n2.alteraValor(4);
        
        System.out.println("n1 = " + n1 + " n2 = " + n2);
        System.out.println("n1 == n2 -> " + n1.eIgual(n2));
    }
}
