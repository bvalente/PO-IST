package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

import editor.core.Editor;
import editor.core.Form;

/**
 * Command for drawing all forms held by the editor.
 * 
 * @author Programação com Objectos
 * @version 3.1
 */
public class DoDraw extends Command<Editor> {
    /**
     * Constructor.
     * 
     * @param editor the target editor.
     */
    public DoDraw(Editor editor) {
	super(Label.DRAW_ALL, editor);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
	_display.add("-------- FORMS --------");
	for (Form f: _receiver.getForms()) {
	    _display.addLine(f.draw());
	}

	_display.addLine("----------------------------");
	_display.display();
    }
}
