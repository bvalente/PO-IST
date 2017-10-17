public class Circulo extends Forma{

    private int _raio;

    public Circulo ( Ponto origem, int raio){
        _origem = new Ponto(origem);
        _raio = raio;
    }
    public void Circulo(int x, int y, int raio){
        _origem = new Ponto(x, y);
        _raio = raio;
    }
    public String desenhar(){
        return "Circulo" + " x : " + _origem.getPontoX() + " y : " + _origem.getPontoY() + " raio : " + _raio;
    }

}
