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
        //FIXME implement this function
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


    //FIXME add methods for passenger registration and passenger name update
    public void registerPassenger(String name){
        _trainCompany.registerPassenger(name);
    }

    public void changePassengerName(int id,String name) throws NoSuchPassengerIdException{
        _trainCompany.changePassengerName(id, name);
    }

    public String searchPassengerId( int id ) throws NoSuchPassengerIdException{
        return _trainCompany.searchPassengerId(id);
    }

    public List<String> searchServiceId( int id ) throws NoSuchServiceIdException{
        return _trainCompany.searchServiceId(id);
    }

    public List<String> showAllPassengers(){
        return _trainCompany.showAllPassengers();
    }


    //FIXME add other functions if necessary

}
