package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

import editor.core.Editor;
import editor.core.Form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Command for drawing all forms held by the editor.
 * 
 * @author Programação com Objectos
 * @version 3.1
 */
public class DoDrawOrderedById extends Command<Editor> {
    /**
     * Constructor.
     * 
     * @param editor the target editor.
     */
    public DoDrawOrderedById(Editor editor) {
	super(Label.DRAW_FORMS_ORDERDED, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
	_display.add("-------- FORMS --------");

        Comparator<Form> comparator;
        ArrayList<Form> coll = new ArrayList<>(_receiver.getForms());

        comparator = new Comparator<Form>() {
            public int compare(Form f1, Form f2) {
               return f1.getId() - f2.getId();
            }
        };

        Collections.sort(coll, comparator);
	for (Form f: coll) {
	    _display.addLine(f.draw());
	}

	_display.addLine("----------------------------");
	_display.display();
    }
}
