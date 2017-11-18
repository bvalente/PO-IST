package mmt.app.service;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.app.exceptions.NoSuchStationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;


//FIXME import other classes if necessary

/**
* 3.2.4 Show services arriving at station.
*/
public class DoShowServicesArrivingAtStation extends Command<TicketOffice> {

    private Input<String> _station;

    /**
    * @param receiver
    */
    public DoShowServicesArrivingAtStation(TicketOffice receiver) {
        super(Label.SHOW_SERVICES_ARRIVING_AT_STATION, receiver);
        _station = _form.addStringInput(Message.requestStationName());
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws DialogException {
        _form.parse();

        
    }

}
