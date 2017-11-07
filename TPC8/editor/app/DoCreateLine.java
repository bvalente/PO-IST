package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;

import editor.core.Editor;
import editor.core.Line;

/**
 * Command for creating lines.
 *
 * @author Programação com Objectos
 * @version 3.1
 **/
public class DoCreateLine extends Command<Editor> {

    private Input<Integer> _originX;
    private Input<Integer> _originY;
    private Input<Integer> _endX;
    private Input<Integer> _endY;
    /**
     * Constructor.
     *
     * @param editor the target editor.
     **/
    public DoCreateLine(Editor editor) {
	super(Label.CREATE_LINE, editor);
	_originX = _form.addIntegerInput("Origin X coordinate? ");
	_originY = _form.addIntegerInput("Origin Y coordinate? ");
	_endX = _form.addIntegerInput("End X coordinate? ");
	_endY = _form.addIntegerInput("End Y coordinate? ");
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
	_form.parse();

	Line l = new Line(_receiver, _originX.value(), _originY.value(),
			  _endX.value(), _endY.value());

	_display.add("-------- NEW OBJECT --------");
	_display.addLine("Form created with id #" + l.getId());
	_display.addLine("----------------------------");
	_display.display();
   }

}
