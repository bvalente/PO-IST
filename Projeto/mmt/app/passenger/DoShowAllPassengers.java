package mmt.app.passenger;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
//imported classes
import java.util.List;

/**
 * This class shows all resgitered passengers ordered by their id.<p>
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
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
