package mmt.app.passenger;

import mmt.core.TicketOffice;
import mmt.app.exceptions.BadPassengerNameException;
import mmt.app.exceptions.DuplicatePassengerNameException;
import mmt.core.exceptions.InvalidPassengerNameException;
import mmt.core.exceptions.NonUniquePassengerNameException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
* This class allows to register a passenger.<p>
* This class requests a name of the passenger.
* Assigns an numeric identifier and a category : NORMAL. <p>
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/
public class DoRegisterPassenger extends Command<TicketOffice> {

    /** _name is a String to be choosed by the user*/
    private Input<String> _name;

    /** This method is responsible for the passenger registration.<p>
    * The user must be chosen by the user.<p>
    * @param receiver
    */
    public DoRegisterPassenger(TicketOffice receiver) {
        super(Label.REGISTER_PASSENGER, receiver);

        _name = _form.addStringInput(Message.requestPassengerName());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() {
        _form.parse();

        _receiver.registerPassenger(_name.toString());
    }

}
