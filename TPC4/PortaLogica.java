public class PortaLogica {

  private boolean _entrada1;
  private boolean _entrada2;

  public PortaLogica ( boolean value1, boolean value2 ) {
    setE1 ( value1 ) ;
    setE2 ( value2 ) ;
  }

  public boolean getE1 () {
    return _entrada1 ;
  }
  
  public  boolean getE2 () {
    return _entrada2 ;
  }

  public void setE1 ( boolean value ) {
		_entrada1 = value ;
	}

	public void setE2 ( boolean value ) {
		_entrada2 = value ;
	}

  protected String toString ( String operacao, boolean result ) {
    return "" + getE1() + " " + operacao + " " + getE2() + " = " + "" + result;
  }
}
