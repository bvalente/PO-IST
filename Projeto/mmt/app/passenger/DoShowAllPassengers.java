package mmt.app.passenger;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;


//FIXME import other classes if necessary
import java.util.List;

/**
* §3.3.1. Show all passengers.
*/
public class DoShowAllPassengers extends Command<TicketOffice> {

    /**
    * @param receiver
    */
    public DoShowAllPassengers(TicketOffice receiver) {
        super(Label.SHOW_ALL_PASSENGERS, receiver);

    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() {

        List<String> list = _receiver.showAllPassengers();
        for (String string : list){
            _display.addLine(string);
        }
        _display.display();

    }

}
