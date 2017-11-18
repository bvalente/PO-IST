package mmt.app.service;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.app.exceptions.NoSuchServiceException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

//FIXME import other classes if necessary
import java.util.List;
/**
* 3.2.2 Show service by number.
*/
public class DoShowServiceByNumber extends Command<TicketOffice> {

    private Input<Integer> _id;

    /**
    * @param receiver
    */
    public DoShowServiceByNumber(TicketOffice receiver) {
        super(Label.SHOW_SERVICE_BY_NUMBER, receiver);
        _id = _form.addIntegerInput(Message.requestServiceId());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws DialogException {
        _form.parse();

        List<String> print;
        try{
            print = _receiver.searchServiceId(_id.value());
            for ( String string : print){
                _display.addLine(string);
            }
            _display.display();
        } catch (NoSuchServiceIdException e){
            throw new NoSuchServiceException (e.getId());
        }


    }

}
