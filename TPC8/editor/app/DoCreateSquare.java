package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;

import editor.core.Editor;
import editor.core.Square;

/**
 * Command for creating lines.
 *
 * @author Programação com Objectos
 * @version 3.0
 **/
public class DoCreateSquare extends Command<Editor> {

    private Input<Integer> _originX;
    private Input<Integer> _originY;
    private Input<Integer> _side;
    /**
     * Constructor.
     *
     * @param editor the target editor.
     **/
    public DoCreateSquare(Editor editor) {
	super(Label.CREATE_SQUARE, editor);
	_originX = _form.addIntegerInput("Origin X coordinate? ");
	_originY = _form.addIntegerInput("Origin Y coordinate? ");
	_side = _form.addIntegerInput("Side? ");
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
	_form.parse();

	Square sq = new Square(_receiver, _originX.value(), _originY.value(),
			  _side.value());

	_display.add("-------- NEW OBJECT --------");
	_display.addLine("Form created with id  #" + sq.getId());
	_display.addLine("----------------------------");
	_display.display();
   }

}
