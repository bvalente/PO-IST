package mmt.core;

import java.io.Serializable;
import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadEntryException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.InvalidPassengerNameException;
import mmt.core.exceptions.NoSuchDepartureException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import mmt.core.exceptions.NonUniquePassengerNameException;
import java.util.Collections;

import java.util.List;
import java.util.ArrayList;

/**
* A train company has schedules (services) for its trains and passengers that
* acquire itineraries based on those schedules.
*/
class TrainCompany implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 201708301010L;

    /** Has the next Passenger ID.
    * When a Passenger is registered it uses this int and adds 1 unit.
    */
    private int _nextPassengerID;

    /** Has the next Station Id.
     * When a Station is registered it uses this int and adds 1 unit.
     */
    private int _nextStationID;

    /** Holds a List of all the Passengers of this TrainCompany. */
    List<Passenger> _passengerList;

    /** Holds a List of all the Staitons of this TrainCompany. */
    List<Station> _stationList;

    /** Holds a List of all the Services of this TrainCompany. */
    List<Service> _serviceList;

    /**
    * Constructor
    * initializes all the atributes.
    */
    TrainCompany(){
        _nextPassengerID = 0;
        _nextStationID = 0;
        _passengerList = new ArrayList<Passenger>();
        _stationList = new ArrayList<Station>();
        _serviceList = new ArrayList<Service>();
    }

    /**
    * Resets the TrainCompany
    * destroys all the information about the Passengers and the Itinerarys.
    * keeps all the services.
    */
    void reset(){
        _passengerList.clear();
        _nextPassengerID = 0;
    }

    /**
     * Registers a Passenger to this TrainCompany.
     *
     * @param name the passenger's name.
     * @return the Passenger.
     */
    Passenger registerPassenger(String name){
        Passenger passenger = new Passenger(name, _nextPassengerID++);
        _passengerList.add(passenger);
        return passenger;
    }

    /**
     * Registers a Station to this TrainCompany.
     *
     * @param name the station's name.
     * @return the Station.
     */
     Station registerStation (String name){
        Station station = new Station(name, _nextStationID++);
        _stationList.add(station);
        return station;
    }

    /**
     * Registers a Service to this TrainCompany.
     *
     * @param serviceId the service's id.
     * @param cost the service's total cost.
     * @return the Service.
     */
    Service registerService (int serviceId,double cost){
        Service service = new Service(serviceId, cost);
        _serviceList.add(service);
        return service;
    }

    /**
     * Changes the Passenger with certain id's name.
     *
     * @param id the passenger's id wich name is going to change.
     * @param name String with the name to change to.
     */
    void changePassengerName(int id, String name) throws NoSuchPassengerIdException{
        for (Passenger p : _passengerList){
            if (p.getID() == id){
                p.changeName(name);
                return;
            }
        }
        throw new NoSuchPassengerIdException( id );
    }

    /**
     * Search Passegner with certain id.
     *
     * @param id the id of the Passenger we are searching form.
     * @return a String with the Passenger's info.
     * @see mmt.core.Passenger#toString()
     */
    String searchPassengerId(int id) throws NoSuchPassengerIdException{
        for (Passenger p : _passengerList){
            if (p.getID() == id){
                return p.toString();
            }
        }
        throw new NoSuchPassengerIdException( id );
    }

    /**
     * Search Service with ceratin id.
     *
     * @param id the id of the Service.
     * @return a List of String with the Service info.
     * @see mmt.core.Service#showService()
     */
    List<String> searchServiceId(int id) throws NoSuchServiceIdException{
        for ( Service s : _serviceList ){ // search in service list
            if (s.getId() == id){
                return s.showService();
            }
        }
        throw new NoSuchServiceIdException( id );
    }

    /**
     * Search Station with certain name.
     *
     * @param name String with the Station name.
     * @return the Station.
     */
    Station searchStationName(String name) throws NoSuchStationNameException{

        for(Station s : _stationList){
            if (s.compareName(name))
            return s;
        }
        throw new NoSuchStationNameException(name);
    }

    /**
     * Shows all Passengers in this TrainCompany.
     *
     * @return a String List with all the Passengers's info.
     */
    List<String> showAllPassengers(){
        //não é necessario ordenar passageiros porque sao sempre inseridos por ordem.
        List<String> list = new ArrayList<String>();
        for ( Passenger p : _passengerList )
            list.add( p.toString() );
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }

    /**
     * Shows all Services in this TrainCompany.
     *
     * @return a String List with all the Services.
     * @see mmt.core.Service#showService()
     */
    List<String> showAllServices(){
        Collections.sort(_serviceList, new Service.ServiceComparator());
        List<String> list = new ArrayList<String>();

        for (Service service : _serviceList){
            list.addAll( service.showService() );
        }
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }

    /** Shows all services departing from a given station.<p>
    *
    * @param stationName String with the station name
    * @return an unmodifiable string list with services ordered by their departure time.
    */
    List<String> showServicesDepartingFromStation(String stationName) throws NoSuchStationNameException{

        Station station = searchStationName(stationName);
        List<String> list = new ArrayList<String>();

        for (Service service : _serviceList){
            if ( station.compareStationId( service.getFirstStation() ) ){
                list.addAll(service.showService());
            }
        }

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }
    /** Shows all services arrivinf at a given station.<p>
    *
    * @param stationName String with the station name
    * @return an unmodifiable string list with services ordered by their arriving time.
    */
    List<String> showServicesArrivingAtStation(String stationName) throws NoSuchStationNameException{

        Station station = searchStationName(stationName);
        List<String> list = new ArrayList<String>();

        for (Service service : _serviceList){
            if ( station.compareStationId( service.getLastStation() ) ){
                list.addAll(service.showService());
            }
        }

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }
    
}
