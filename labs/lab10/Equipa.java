import java.util.List;
import java.util.ArrayList;

class Equipa extends Component{

    List<Component> lista = new ArrayList<Component>();

    void addComponent(Component c) throws CantAddException{
        lista.add(c);
    }


    void operation(){
        for (Component c : lista){
            c.operation();
        }
    }

    
    int getCusto (){
        int count = 0;
        for (Component c :lista){
            count += c.getCusto();
        }
        return count;
    }
}
