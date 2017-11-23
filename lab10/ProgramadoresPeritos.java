import java.util.List;
class ProgramadoresPeritos extends Empregado{
    ProgramadoresPeritos(String nome){
        super(nome, 10000);
    }
    @Override
    void operation(){
        System.out.println( "a programar muito");
    }
}
