public class Veiculo{

	protected String _brand;
    protected Portagem _portagem;

	public Veiculo(String brand, Portagem p){
		_brand = new String(brand);
        _portagem = p;
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


    public String obtemMarca(){
        return new String (_brand);
    }

    public void passaPortagem(int cabine){
        _portagem.contabilizaPassagemPaga(cabine);
    }


}
