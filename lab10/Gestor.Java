import java.util.List;
class Gestor extends Empregado{
    Gestor(String nome){
        super(nome, 1000);
    }
    @Override
    void operation(){
        System.out.println( "a gerir");
    }
}
