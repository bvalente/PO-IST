package mmt.app.service;

import mmt.core.TicketOffice;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.app.exceptions.NoSuchStationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

import java.util.List;

/**
* This class shows all services departing from a given station.<p>
* The services are ordered by their arriving time.<p>
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
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

        try{
            List<String> list =_receiver.showServicesArrivingAtStation(_station.toString());
            for (String s : list){
                _display.addLine(s);
            }
            _display.display();
        }
        catch (NoSuchStationNameException e){
            throw  new NoSuchStationException(e.getName());
        }
    }

}
