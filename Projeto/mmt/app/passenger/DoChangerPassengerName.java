package mmt.app.passenger;

import mmt.core.TicketOffice;
import mmt.app.exceptions.BadPassengerNameException;
import mmt.app.exceptions.DuplicatePassengerNameException;
import mmt.app.exceptions.NoSuchPassengerException;
import mmt.core.exceptions.InvalidPassengerNameException; //BadPassengerNameException
import mmt.core.exceptions.NoSuchPassengerIdException; //NoSuchPassengerException
import mmt.core.exceptions.NonUniquePassengerNameException; //DuplicatePassengerNameException
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * This class allows to modify a registered passenger name.<p>
 * It requests an id and name of the passenger that is supposed to be altered.<p>
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
 */
public class DoChangerPassengerName extends Command<TicketOffice> {

    /** _name is a String to be choosed by the user*/
    private Input<String> _name;
    /** _name is a Integer to bechoosed by the user*/
    private Input<Integer> _id;

    /** This method is responsible to associate the private variables to values selected by the user
    *
    * @param receiver
    */
    public DoChangerPassengerName(TicketOffice receiver) {
        super(Label.CHANGE_PASSENGER_NAME, receiver);
        _id = _form.addIntegerInput(Message.requestPassengerId());
        _name = _form.addStringInput(Message.requestPassengerName());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */

    @Override
    public final void execute() throws DialogException {
        _form.parse();

        try{
            _receiver.changePassengerName(_id.value(), _name.toString());
        } catch (NoSuchPassengerIdException e){
            throw new NoSuchPassengerException( e.getId() );
        }
    }
}
