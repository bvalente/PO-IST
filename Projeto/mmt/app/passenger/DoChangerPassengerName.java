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

//FIXME import other classes if necessary
import mmt.core.Passenger;

/**
 * §3.3.4. Change passenger name.
 */
public class DoChangerPassengerName extends Command<TicketOffice> {

  private Input<String> _name;
  private Input<Integer> _id;

  /**
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
      try{
          _receiver.changePassengerName(_id.value(), _name.toString());
      } catch (NoSuchPassengerIdException e){
          throw new NoSuchPassengerException( e.getId() );
      }
  }
}
