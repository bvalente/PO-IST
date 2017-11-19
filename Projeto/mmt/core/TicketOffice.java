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

//FIXME import other classes if necessary
import java.io.File;
import java.util.List;

/**
* Façade for handling persistence and other functions.
*/
public class TicketOffice {

    /** The object doing most of the actual work. */
    private TrainCompany _trainCompany = new TrainCompany();

    //FIXME define other fields

    public void reset() {
        _trainCompany = new TrainCompany();
    }

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

    public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream inob = new ObjectInputStream(new FileInputStream(filename));
        _trainCompany = (TrainCompany)inob.readObject();

    }

    public void importFile(String datafile) throws ImportFileException {

        try{
            _trainCompany = new NewParser().parseFile( datafile );
        } catch (ImportFileException e){
            //FIXME not done
        }
    }

    //FIXME complete and implement the itinerary search (and pre-commit store) method
    public Itinerary /*FIXME choose return type */ searchItineraries(int passengerId, String departureStation, String arrivalStation, String departureDate,
    String departureTime) /*FIXME define thrown exceptions */ {
        //FIXME implement method
        return new Itinerary();
    }

    //FIXME complete and implement the itinerary commit method
    public Itinerary /*FIXME choose return type */ commitItinerary(int passengerId, int itineraryNumber) /*FIXME define thrown exceptions */ {
        //FIXME implement method
        return new Itinerary();
    }

    /** Registers a passenger.
    *
    * @param name string with passenger name to be registered
    *
    */
    public void registerPassenger(String name){
        _trainCompany.registerPassenger(name);
    }

    /** Changes a passenger name.
    *
    * @param id passenger numeric identification.
    * @param name new passenger name.
    *
    */
    public void changePassengerName(int id,String name) throws NoSuchPassengerIdException{
        _trainCompany.changePassengerName(id, name);
    }

    /** Searchs a passenger by id.
    *
    * @param id passenger numeric identification.
    * @return passenger details.
    *
    */
    public String searchPassengerId( int id ) throws NoSuchPassengerIdException{
        return _trainCompany.searchPassengerId(id);
    }

    /** Searchs a service by id.
    *
    * @param id service numeric identification.
    * @return service details.
    *
    */
    public List<String> searchServiceId( int id ) throws NoSuchServiceIdException{
        return _trainCompany.searchServiceId(id);
    }

    /** Shows all passengers registered in a train company.
    *
    * @return string list of passengers details.
    *
    */
    public List<String> showAllPassengers(){
        return _trainCompany.showAllPassengers();
    }

    /** Shows all services.
    *
    * @return string list of services and all their details.
    *
    */
    public List<String> showAllServices(){
        return _trainCompany.showAllServices();
    }

    /** Shows all services arriving at a given stations.
    *
    * @param station string of station name.
    * @return string list of services and all their details.
    *
    */
    public List<String> showServicesArrivingAtStation(String station) throws NoSuchStationNameException{
        return _trainCompany.showServicesArrivingAtStation(station);
    }

    /** Shows all services departing at a given stations.
    *
    * @param station string of station name.
    * @return string list of services and all their details.
    *
    */
    public List<String> showServicesDepartingFromStation(String station) throws NoSuchStationNameException{
        return _trainCompany.showServicesDepartingFromStation(station);
    }


    //FIXME add other functions if necessary

    }
