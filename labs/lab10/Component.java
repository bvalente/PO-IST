import java.util.List;

abstract class Component{

    //construtor
    Component (){

    }

    abstract void operation();

    abstract void addComponent(Component c) throws CantAddException;

    abstract int getCusto();

}
