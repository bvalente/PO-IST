
abstract class Empregado{
    private String _name;
    abstract private int _custo;

    Empregado(String name, int custo){
        _name = name;
        _custo = custo;
    }

    @Override
    int getCusto(){
        return _custo;
    }

    abstract List<String> operation() throws CantAddException;

}
