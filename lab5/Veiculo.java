public class Veiculo{
	
	private String _brand;

	public Veiculo(String brand){
		_brand = new String(brand);
	}

	public void acelera(){
		System.out.println("VRUM VRUM");
	}

	public void trava(){
		System.out.println("GRRR GRRR");
	}

	public void buzina(){
		System.out.println("PII PII");
	}

	public Boolean pagaPortagem(){
		return true;
	}


}