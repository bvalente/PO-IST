public class Portagem{

    private int _numVeic;
    private int _numCobr;
    private int[] _cabine = new int[10];

    public Portagem(){
        _numVeic = 0;
        _numCobr = 0;

        for (int i : _cabine){
            i = 0;
        }
    }



    public int obtemNumeroVeiculos(){
        return _numVeic;
    }

    public int obtemCobrancas(){
        return _numCobr;
    }

    public void contabilizaPassagemGratuita(int cabine){
        _numVeic += 1;
        _cabine[cabine] += 1;
    }
    public void contabilizaPassagemPaga(int cabine){
        _numVeic += 1;
        _numCobr += 1;
        _cabine[cabine] += 1;
    }
    public int obtemNumeroVeiculos(int cabine){
        return _cabine[cabine];
    }

    public static void main(String[] args) {

        Portagem port = new Portagem();
        Veiculo[] array = new Veiculo[8];
        int i = 1;
        int n = 42 % 8;
        for (int j = 0; j < 8; j++){
            if (i <= 3)
                array[j] = new Veiculo( "XPTO" + ( n + ( i - 1 )), port );
            else
                array[j] = new VeiculoPesado( "XPTO" + ( n + ( i - 1 )), port );
            i++;
        }

        for (Veiculo v : array){
            System.out.println(v.obtemMarca());
            v.buzina();
            v.trava();
            v.acelera();
            v.passaPortagem(2);
            }
    }
}
