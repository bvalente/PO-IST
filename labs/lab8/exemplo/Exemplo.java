package exemplo;

import exemplo.excepcao.ArgumentoInvalidoException;

public class Exemplo {

  public void fazAlgo(Object arg) throws ArgumentoInvalidoException {
    if (arg == null)
      throw new ArgumentoInvalidoException("Argumento Ã© nulo");

    System.out.println("Fiz algo " + arg.toString());
  }

  public static void main(String[] args) {

    try {
      Exemplo e = new Exemplo();

      e.fazAlgo("sem problemas");

      e.fazAlgo(null);

    } catch(ArgumentoInvalidoException e) {
      System.out.println("Apanhei a excepÃ§Ã£o Argumento invÃ¡lido. RazÃ£o: " + e.obtemMensagem());
    } catch(Exception e) {
        System.out.println("Apanhei uma excepÃ§Ã£o " + e.getClass().getName());
    }
  }
}
