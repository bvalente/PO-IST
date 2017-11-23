import java.util.List;
import java.util.ArrayList;

class Equipa extends Component{

    List<Component> lista = new ArrayList<Component>();

    @Override
    void addComponent(Component c) throws CantAddException{
        lista.add(c);
    }

    @Override
    List<String> operation(){
        List<String> stringList = new ArrayList<String>();
        for (Component c : lista){
            stringList.addAll( c.operation() );
        }
        return stringList;
    }

    @Override
    int getCusto (){
        int count = 0;
        for (Component c :lista){
            count += c.getCusto();
        }
        return count;
    }
}
