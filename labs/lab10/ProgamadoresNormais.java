import java.util.List;

class ProgramadoresNormais extends Empregado{
    //private int _custo = 1500;

    ProgramadoresNormais(String nome){
        super(nome, 1500);
    }
    @Override
    void operation(){
        System.out.println( "a programar");
    }
}
