package mmt.app.passenger;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.app.exceptions.NoSuchPassengerException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

/**
 * This class shows a passenger with a solicitated id.<p>
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
*/
public class DoShowPassengerById extends Command<TicketOffice> {

    /** _name is a String to be choosed by the user*/
    private Input<Integer> _id;

    /** This method is responsible for showing a passenger with a given id.<p>
    * @param receiver
    */
    public DoShowPassengerById(TicketOffice receiver) {
        super(Label.SHOW_PASSENGER_BY_ID, receiver);

        _id = _form.addIntegerInput(Message.requestPassengerId());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws DialogException {
        _form.parse();

        String print;
        try{
            print = _receiver.searchPassengerId( _id.value() );
            _display.addLine(print);
            _display.display();
        } catch (NoSuchPassengerIdException e){
            throw new NoSuchPassengerException( e.getId() );
        }
    }

}
