public class Quadrado extends Forma{

	private int _lado;

	public Quadrado(Ponto origem, int lado){
		_origem = origem;
		_lado = lado;
	}
	public Quadrado(int x, int y, int lado){
		_origem = new Ponto(x, y);
		_lado = lado;
	}
	public String desenhar(){
		return "Quadrado" + " x : " + _origem.getPontoX() + " y : " + _origem.getPontoY() + " lado : " + _lado;
	}

}
