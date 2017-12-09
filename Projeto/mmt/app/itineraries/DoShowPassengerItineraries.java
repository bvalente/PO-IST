package mmt.app.itineraries;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.app.exceptions.NoSuchPassengerException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

import java.util.List;
/**
* §3.4.2. Show all itineraries (for a specific passenger).
*/
public class DoShowPassengerItineraries extends Command<TicketOffice> {

    private Input<Integer> _passengerId;

    /**
    * @param receiver
    */
    public DoShowPassengerItineraries(TicketOffice receiver) {
        super(Label.SHOW_PASSENGER_ITINERARIES, receiver);

        _passengerId = _form.addIntegerInput(Message.requestPassengerId());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws DialogException {
        _form.parse();

        List<String> print;
        try{
            print = _receiver.showItineraries(_passengerId.value());
            if ( print == null ){
                _display.addLine( Message.noItineraries(_passengerId.value()));
            } else{
                for ( String string : print ){
                    _display.addLine(string);
                }
            }
            _display.display();
        } catch (NoSuchPassengerIdException e){
            throw new NoSuchPassengerException (e.getId());
        }
    }

}
