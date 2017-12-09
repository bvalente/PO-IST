package mmt.app.itineraries;

import mmt.core.TicketOffice;
import mmt.app.exceptions.BadDateException;
import mmt.app.exceptions.BadTimeException;
import mmt.app.exceptions.NoSuchItineraryException;
import mmt.app.exceptions.NoSuchPassengerException;
import mmt.app.exceptions.NoSuchStationException;
import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import pt.tecnico.po.ui.Form;

/**
* §3.4.3. Add new itinerary.
*/
public class DoRegisterItinerary extends Command<TicketOffice> {

    private Input<Integer> _id;
    private Input<String> _departureStation;
    private Input<String> _arrivalStation;
    private Input<String> _departureDate;  //(YYYY-MM-DD)
    private Input<String> _departureTime;

    private Form _choiceForm;
    private Input<Integer> _userChoice;


    /**
    * @param receiver
    */
    public DoRegisterItinerary(TicketOffice receiver) {
        super(Label.REGISTER_ITINERARY, receiver);

        _id = _form.addIntegerInput(Message.requestPassengerId());
        _departureStation = _form.addStringInput(Message.requestDepartureStationName());
        _arrivalStation =_form.addStringInput(Message.requestArrivalStationName());
        _departureDate = _form.addStringInput(Message.requestDepartureDate());
        _departureTime = _form.addStringInput(Message.requestDepartureTime());

         _choiceForm = new Form();
        _userChoice = _choiceForm.addIntegerInput(Message.requestItineraryChoice());

    }

    /** @see pt.tecnico.po.ui.Command#execute() */

    @Override
    public final void execute() throws DialogException {
        _form.parse();
        List<String> stringList;
        try {
            //search com os argumentos.tostring()
            stringList = _receiver.searchItineraries(_id.value(), _departureStation.toString(),
                _arrivalStation.toString(), _departureDate.toString(), _departureTime.toString());

            if (!stringList.isEmpty()){
                //show them
                for (String str : stringList){
                    _display.addLine(str);
                }
                _display.display();
                //parse do numero do itinerario que o cliente escolher
                _choiceForm.parse();
                //usar a funcao commitItinerary to add
                _receiver.commitItinerary(_id.value(), _userChoice.value());
            }

            // must call (at least) _receiver.searchItineraries(...) and _receiver.commitItinerary(...)
        } catch (NoSuchPassengerIdException e) {
            throw new NoSuchPassengerException(e.getId());
        } catch (NoSuchStationNameException e) {
            throw new NoSuchStationException(e.getName());
        } catch (NoSuchItineraryChoiceException e) {
            throw new NoSuchItineraryException(e.getPassengerId(), e.getItineraryId());
        } catch (BadDateSpecificationException e) {
            throw new BadDateException(e.getDate());
        } catch (BadTimeSpecificationException e) {
            throw new BadTimeException(e.getTime());
        }

    }
}
