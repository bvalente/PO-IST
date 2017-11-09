package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;

import editor.core.Editor;
import editor.core.Circle;

/**
 * Command for creating circles.
 * 
 * @author Programação com Objectos
 * @version 3.1
 */
public class DoCreateCircle extends Command<Editor> {

    private Input<Integer> _centerX;
    private Input<Integer> _centerY;
    private Input<Integer> _radius;

    /**
     * Constructor.
     * 
     * @param editor the target editor.
     */
    public DoCreateCircle(Editor editor) {
	super(Label.CREATE_CIRCLE, editor);
        _centerX = _form.addIntegerInput("Origin X coordinate? ");
        _centerY = _form.addIntegerInput("Origin Y coordinate? ");
        _radius = _form.addIntegerInput("Radius ? ");

    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

	_form.parse();

	Circle c = new Circle(_receiver, _centerX.value(), _centerY.value(), _radius.value());

	_display.add("-------- NEW OBJECT --------");
	_display.addLine("Form created with id #" + c.getId());
	_display.addLine("----------------------------");
	_display.display();
    }
}
