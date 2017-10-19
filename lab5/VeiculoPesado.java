public class VeiculoPesado extends Veiculo{

	private int _nPassagens;

	public VeiculoPesado(String brand, Portagem p){
		super(brand, p);
	}

	@Override
	public void buzina (){
		System.out.println("POO POO");
	}

	public int obtemNumeroPassagens(){
		return _nPassagens;
	}

	@Override
	public void passaPortagem(int cabine){
        _portagem.contabilizaPassagemGratuita(cabine);
	}
}
