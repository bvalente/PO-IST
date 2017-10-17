public class Linha extends Forma{

    private Ponto _destino;

    public Linha(Ponto origem, Ponto destino){
        _origem = new Ponto(origem);
        _destino = new Ponto(destino);
    }
    @Override
    public void mover( int x, int y ){
        _origem.movePonto(x,y);
        _destino.movePonto(x,y);
    }
    @Override
    public void mover( Ponto vetor ){
        _origem.movePonto(vetor);
        _destino.movePonto(vetor);
    }

    public String desenhar(){
        return "Linha" + " x ( origem ):" + _origem.getPontoX() + " y ( origem ):" + _origem.getPontoY() + " x ( destino ):" + _destino.getPontoX() + " y ( destino ): " + _destino.getPontoY();
    }
}
