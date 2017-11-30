public class Ponto{
    private int _x;
    private int _y;

    public Ponto ( int x, int y ){
        _x = x;
        _y = y;
    }

    public void setPonto ( int x, int y ){
        _x = x;
        _y = y;
    }

    public void setPonto ( Ponto a ) {
        _x = a._x;
        _y = a._y;
    }

    public void movePonto ( int x, int y ){
        _x += x;
        _y += y;
    }
    public void movePonto ( Ponto a ){
        _x += a._x;
        _y += a._y;
    }


    /*public Ponto getPonto (  ){
        return new Ponto(this);
    }*/

    public int getPontoX (  ){
        return (_x);
    }
    public int getPontoY (  ){
        return (_y);
    }


}
