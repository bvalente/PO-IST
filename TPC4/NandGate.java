public class NandGate extends PortaLogica{


  public NandGate (boolean value1, boolean value2) {
    //super( value1, value2 );
    setE1(value1);
    setE2(value2);
    operation = "NAND"; //'!&&' ?
  }

  public boolean getOutput () {
    output = !( getE1() && getE2() );
    return output ;
  }

  public static void main(String[] args) {

    NandGate teste = new NandGate(false, false);
    System.out.println(teste.toString());
    teste.setE1(true);
    System.out.println(teste.toString());
    teste.setE2(true);
    System.out.println(teste.toString());
  }
}
