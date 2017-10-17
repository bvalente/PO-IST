public abstract class Forma {

	protected Ponto _origem;

	public void mover(int x, int y){
		_origem.movePonto(x,y);
	}

	public void mover(Ponto a){
		_origem.movePonto(a);
	}
	public abstract String desenhar();
}