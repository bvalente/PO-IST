import java.util.List;

abstract class Component{

    //construtor
    abstract Component (){

    }

    abstract List<String> operation();

    abstract void addComponent() throws CantAddException;

    abstract int getCusto();

}
