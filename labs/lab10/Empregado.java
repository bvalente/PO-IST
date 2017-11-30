import java.util.List;

abstract class Empregado{
    private String _name;
    private int _custo;

    Empregado(String name, int custo){
        _name = name;
        _custo = custo;
    }


    int getCusto(){
        return _custo;
    }

    void addComponent(Component c) throws CantAddException{
        throw new CantAddException();
    }


    abstract void operation();

}
