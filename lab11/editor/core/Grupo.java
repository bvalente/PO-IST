package editor.core;

import java.util.List;
import java.util.ArrayList;

public class Grupo extends Form{

    List<Form> lista ;
    public Grupo(){
        super(0,0);
        lista = new ArrayList<Form>();
    }
    public Grupo(int x, int y){
        this();

    }

    public Grupo(Editor e, int x, int y){
        this();
    }


    void addToList(Form f){
        lista.add(f);
    }

    public String draw(){
        String str = new String();
        for ( Form f : lista){
            str.concat( f.draw() );
        }

        return str;
    }

    public void move(int x, int y){

        for ( Form f : lista){
             f.move(x,y);
        }
    }

}
