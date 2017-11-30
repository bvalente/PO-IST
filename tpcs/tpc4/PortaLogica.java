public abstract class PortaLogica {

  protected boolean _entrada1;
  protected boolean _entrada2;
  protected String operation;
  //protected boolean output;

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

  public abstract boolean getOutput();

  public String toString () {
    return "" + getE1() + " " + operation + " " + getE2() + " = " + "" + getOutput();
  }

}
