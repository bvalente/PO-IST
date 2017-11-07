package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

import editor.core.Editor;
import editor.core.Form;
import editor.core.Line;

import java.util.ArrayList;
import java.util.Collections;
import editor.core.LineComparator;

/**
 * Command for drawing all forms held by the editor.
 *
 * @author Programação com Objectos
 * @version 3.1
 */
public class DoDrawLines extends Command<Editor> {
    /**
     * Constructor.
     *
     * @param editor the target editor.
     */
    public DoDrawLines(Editor editor) {
	super(Label.DRAW_ALL_LINES, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        ArrayList<Line> list = new ArrayList<Line>();

    	_display.add("-------- LINES --------");
    	for (Form f: _receiver.getForms()) {
            if ( f instanceof  Line  ){
                list.add((Line) f);
            }
    	}
        //ordenar a list
        Collections.sort(list, new LineComparator());


        //juntar todos ao display
        for (Line f: list){
            _display.addLine(f.draw());
        }
    	_display.addLine("----------------------------");
    	_display.display();
    }

    public static int[] obtemAutoria(){
        int[] vector = new int[3];
        vector[0] = 42;
        vector[1] = 87521;
        vector[2] = 87530;

        return vector;
    }
}
