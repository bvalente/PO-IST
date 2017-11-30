package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

import editor.core.Editor;
import editor.core.Form;

public class DoCreateCircle extends Command<Editor>{

    int _x, _y, _r;

    public void DoCreateCircle(Editor editor){
        super(Label.DRAW_ALL, editor);

        //inputs



    }

    public final void execute(){
        form.parse();


        Form circle = new Circle(x ,y ,raio);
        _receiver.addForm( circle );
    }
}
