package mmt.app.service;

import mmt.core.TicketOffice;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

//FIXME import other classes if necessary
import java.util.List;

/**
* This class shows all Services registered in a trainCompany ordered by their id.<p>
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/
public class DoShowAllServices extends Command<TicketOffice> {

    /**
    * @param receiver
    */
    public DoShowAllServices(TicketOffice receiver) {
        super(Label.SHOW_ALL_SERVICES, receiver);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() {
        List<String> list = _receiver.showAllServices();
        for (String string : list){
            _display.addLine(string);
        }
        _display.display();
    }

}
