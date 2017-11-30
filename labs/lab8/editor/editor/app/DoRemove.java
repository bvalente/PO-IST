package editor.app;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;

import editor.core.Editor;

/**
 * Command for removing a form.
 *
 * @author Programação com Objectos
 * @version 3.0
 */
public class DoRemove extends Command<Editor> {

    private Input<Integer> _formId;
    /**
     * Constructor.
     *
     * @param editor the target editor.
     */
    public DoRemove(Editor editor) {
        super(Label.REMOVE_FORM, editor);
        _formId = _form.addIntegerInput("Form to remove? ");
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchFormException {

        for (Form f : ){
                    
        }
    }
}
