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
import java.util.Map;
import java.util.TreeMap;
import java.time.LocalTime;
import java.time.LocalDate;


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
    //List<Passenger> _passengerList;
    Map<Integer, Passenger> _passengerMap;

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
        _passengerMap = new TreeMap<Integer, Passenger>();
        _stationList = new ArrayList<Station>();
        _serviceList = new ArrayList<Service>();
    }

    /**
    * Resets the TrainCompany.
    * Destroys all Passenger and itinerary information.
    * Keeps all the services.
    */
    void reset(){
        _passengerMap.clear();
        _nextPassengerID = 0;
    }

    /**
     * Registers a Passenger to this TrainCompany.
     *
     * @param name the passenger's name.
     * @return the Passenger.
     */
    Passenger registerPassenger(String name){
        Passenger passenger = new Passenger(name, _nextPassengerID);
        _passengerMap.put( Integer.valueOf(_nextPassengerID) , passenger);
        _nextPassengerID++;
        return passenger;
    }

    Passenger getPassenger(int id) throws NoSuchPassengerIdException{

        Passenger passenger = _passengerMap.get( Integer.valueOf(id) );
        if (passenger != null){
            return passenger;
        }
        throw new NoSuchPassengerIdException( id );
    }

    Service getService(int id) throws NoSuchServiceIdException{
        for(Service service : _serviceList){
            if (service.getId() == id){
                return service;
            }
        }
        throw new NoSuchServiceIdException(id);
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
    Station getStation(String name){
        for ( Station station : _stationList ){
            if (station.compareName(name)){
                return station;
            }
        }
        return null; // ?
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

        Passenger passenger = _passengerMap.get( Integer.valueOf(id) );
        if (passenger != null){
            passenger.changeName(name);
            return;
        }
        throw new NoSuchPassengerIdException( id );
    }

    /**
     * Search Passenger with a given id.
     *
     * @param id the id of the Passenger we are searching form.
     * @return a String with the Passenger's info.
     * @see mmt.core.Passenger#toString()
     */
    String searchPassengerId(int id) throws NoSuchPassengerIdException{

        Passenger passenger = _passengerMap.get( Integer.valueOf(id) );
        if (passenger != null){
            return passenger.toString();
        }
        throw new NoSuchPassengerIdException( id );
    }

    /**
     * Search Service with certain id.
     *
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

        List<String> stringList = new ArrayList<String>();
        List<Passenger> passengerList = new ArrayList<Passenger>( _passengerMap.values() );
        for ( Passenger p : passengerList)
            stringList.add( p.toString() );
        List<String> unmodifiableList = Collections.unmodifiableList(stringList);
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

    List<String> showAllItineraries(){
        List<String> stringList = new ArrayList<String>();
        for(Passenger passenger: _passengerMap.values()){
            stringList.addAll(passenger.showAllItineraries());
        }
        return stringList;
    }

    /** Shows all services departing from a given station.<p>
    *
    * @param stationName String with the station name
    * @return an unmodifiable string list with services ordered by their departure time.
    */
    List<String> showServicesDepartingFromStation(String stationName) throws NoSuchStationNameException{

        Station station = searchStationName(stationName);
        List<Service> serviceList = new ArrayList<Service>();
        List<String> list = new ArrayList<String>();

        for (Service service : _serviceList){
            if( station.compareStationId( service.getFirstStation() ) ){
                serviceList.add(service);
            }
        }
         Collections.sort(serviceList, new Service.ServiceComparatorByDepartingTime());

        for (Service service : serviceList){
            list.addAll(service.showService());

        }

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }
    /** Shows all services arriving at a given station.<p>
    *
    * @param stationName String with the station name
    * @return an unmodifiable string list with services ordered by their arriving time.
    */
    List<String> showServicesArrivingAtStation(String stationName) throws NoSuchStationNameException{

        Station station = searchStationName(stationName);

        List<Service> serviceList = new ArrayList<Service>();
        List<String> list = new ArrayList<String>();

        for (Service service : _serviceList){
            if ( station.compareStationId( service.getLastStation() ) ){
                serviceList.add(service);
            }
        }
        Collections.sort(serviceList, new Service.ServiceComparatorByArrivingTime());
        for(Service service : serviceList){
            list.addAll(service.showService());
        }

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        return unmodifiableList;
    }

    //procura simples
    List<String> searchItinerary(Station departureStation, Station arrivalStation, LocalDate date, LocalTime time){

        //List<Service> list = departureStation.serviceList();

        return null; //para compilar
    }
    /*
    List<Segment> getSimpleSegments(Station s1,Station s2,LocalTime time ){
        List<Segment> lista = new ArrayList<Segment>();
        for (Service service : _serviceList){
            lista.add(service.getSimpleSegment(s1, s2,time));
        }
        return lista;
    }

    List<Itinerary> getAllItineraries(Station s1, Station s2){
    	List<TrainStop> trainStopList = s1.getTrainStopList();
    	List<Itinerary> itiList = new ArrayList<Itinerary>();

    	for(TrainStop ts : trainStopList){

    		Segment seg = ts.getService().getSimpleSegment(ts, s2);
    		if (seg != null)
    			itiList.add(new Itinerary(seg));

    	}
    	return itiList;
    }
    */

}
