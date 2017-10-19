public class VeiculoPesado extends Veiculo{

	private int _nPassagens;
	
	@Override
	public void buzina (){
		System.out.println("POO POO");
	}

	public int obtemNumeroPassagens(){
		return _nPassagens;
	}

	@Override
	public Boolean pagaPortagem(){
		return false;
	}
	
}