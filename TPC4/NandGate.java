public class NandGate extends PortaLogica{

  private final String operacao;
  private boolean output;

  public NandGate (boolean value1, boolean value2) {
    super( value1, value2 );
    operacao = "NAND"; //'!&&' ?
  }

  public boolean getOuput () {
    output = !( getE1() && getE2() );
    /*if  (output == true){
      System.out.println("aasdsad");
    }*/
    return output ;
  }

  public String toString() {
    return super.toString( operacao, output );
  }

  /*public static void main(String[] args) {
     new NandGate(true, false);
    toString(operacao, getOutput());
    System.out.println("cona");
  }*/
}
