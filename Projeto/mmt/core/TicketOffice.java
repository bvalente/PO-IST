package mmt.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.ImportFileException;
import mmt.core.exceptions.MissingFileAssociationException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import mmt.core.exceptions.NonUniquePassengerNameException;

import java.io.File;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
/**
* Façade for handling persistence and other functions.
*/
public class TicketOffice {

    /** The object doing most of the actual work. */
    private TrainCompany _trainCompany = new TrainCompany();

    /**
    * Resets the TrainCompany, erasing the passengers info.
    */
    public void reset() {

        // Reset TrainCompany but keep services
        _trainCompany.reset();
    }

    /**
    * Saves the state of the TrainCompany.
    * @param filename String with the file to write to.
    */
    public void save(String filename) throws IOException {

        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(_trainCompany);
            out.close();

        } catch (FileNotFoundException e) {
            File file = new File(filename);
            file.createNewFile();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(_trainCompany);
            out.close();
        }
    }

    /**
    * Loads the TrainCompany saved previously in another instance of the program.
    * @param filename String with the name of the file to load.
    */
    public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream inob = new ObjectInputStream(new FileInputStream(filename));
        _trainCompany = (TrainCompany)inob.readObject();
    }

    /**
    * Parses the file given when the program executes.
    * @param datafile String of the name to import.
    */
    public void importFile(String datafile) throws ImportFileException {

        _trainCompany = new NewParser().parseFile( datafile );
    }

    //FIXME complete and implement the itinerary search (and pre-commit store) method
    public Itinerary /*List <Itinerary> */searchItineraries(int passengerId, String departureStation, String arrivalStation, String departureDate,
    String departureTime) throws NoSuchPassengerIdException  {/* BadTimeException, BadDateException*/
        //try
        Passenger passenger = _trainCompany.getPassenger(passengerId);
        LocalTime time = LocalTime.parse(departureTime); //not sure if this is the correct way to do it
        LocalDate date = LocalDate.parse(departureDate);

        //for para ver todas os servicos da station de partida. para usar com o compute
        //criar trainstop
        //TrainStop ts = TrainStop( _trainCompany.getStation(departureStation) ,  );

        Station station = _trainCompany.getStation(arrivalStation);


        return new Itinerary();
    }

    //FIXME complete and implement the itinerary commit method
    public Itinerary /*FIXME choose return type */ commitItinerary(int passengerId, int itineraryNumber) /*FIXME define thrown exceptions */ {
        //FIXME implement method
        return new Itinerary();
    }

    public List<String> showItineraries(int passengerId)throws NoSuchPassengerIdException{
        Passenger passenger = _trainCompany.getPassenger(passengerId);
        return passenger.showAllItineraries();

    }

    public List<String> showAllItineraries(){
        return _trainCompany.showAllItineraries();
    }
    /** Registers a passenger.
    *
    * @param name string with passenger name to be registered
    */
    public void registerPassenger(String name){
        _trainCompany.registerPassenger(name);
    }

    /** Changes a passenger name.
    *
    * @param id passenger numeric identification.
    * @param name new passenger name.
    */
    public void changePassengerName(int id,String name) throws NoSuchPassengerIdException{
        _trainCompany.changePassengerName(id, name);
    }

    /** Searchs a passenger by id.
    *
    * @param id passenger numeric identification.
    * @return passenger details.
    */
    public String searchPassengerId( int id ) throws NoSuchPassengerIdException{
        return _trainCompany.searchPassengerId(id);
    }

    /** Searchs a service by id.
    *
    * @param id service numeric identification.
    * @return service details.
    */
    public List<String> searchServiceId( int id ) throws NoSuchServiceIdException{
        return _trainCompany.searchServiceId(id);
    }

    /** Shows all passengers registered in a train company.
    *
    * @return string list of passengers details.
    */
    public List<String> showAllPassengers(){
        return _trainCompany.showAllPassengers();
    }

    /** Shows all services.
    *
    * @return string list of services and all their details.
    */
    public List<String> showAllServices(){
        return _trainCompany.showAllServices();
    }

    /** Shows all services arriving at a given stations.
    *
    * @param station string of station name.
    * @return string list of services and all their details.
    */
    public List<String> showServicesArrivingAtStation(String station) throws NoSuchStationNameException{
        return _trainCompany.showServicesArrivingAtStation(station);
    }

    /** Shows all services departing at a given stations.
    *
    * @param station string of station name.
    * @return string list of services and all their details.
    */
    public List<String> showServicesDepartingFromStation(String station) throws NoSuchStationNameException{
        return _trainCompany.showServicesDepartingFromStation(station);
    }

}
