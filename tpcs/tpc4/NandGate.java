public class NandGate extends PortaLogica{


  public NandGate (boolean value1, boolean value2) {
    //super( value1, value2 );
    setE1(value1);
    setE2(value2);
    operation = "NAND"; //'!&&' ?
  }

  public boolean getOutput () {
    boolean output = !( getE1() && getE2() );
    return output ;
  }

}
