package mmt.app.service;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.app.exceptions.NoSuchServiceException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

import java.util.List;

/**
* This class shows a service with a given number (previously solicitated).<p>
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/
public class DoShowServiceByNumber extends Command<TicketOffice> {

    private Input<Integer> _id;

    /** This method is responsible for showing a service with a given identification number.<p>
    *
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
