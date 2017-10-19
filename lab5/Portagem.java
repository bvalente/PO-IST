public class Portagem{

    private int _numVeic;
    private int _numCobr;
    private int[] _cabines = new int[10]; 

    public Portagem(){
        _numVeic = 0;
        _numCobr = 0;

        for (int i : _cabines){
            i = 0;

        }
    }

    public obtemNumeroVeiculos(){
        return _numVeic;
    }

    public obtemCobrancas(){
        return _numCobr;
    }

    public contabilizaPassagemGratuita(int cabine){
        _numVeic += 1;
        _cabine[cabine] += 1;
    }
    public contabilizaPassagemPaga(int cabine){
        _numVeic += 1;
        _numCobr += 1;
        _cabine[cabine] += 1;
    }
    public obtemNumeroVeiculos(int cabine){
        return _cabine[cabine];
    }


}
