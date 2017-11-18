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
//FIXME import other classes if necessary

/**
 * A train company has schedules (services) for its trains and passengers that
 * acquire itineraries based on those schedules.
 */
class TrainCompany implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

  private int _nextPassengerID = 0; //static?
  private int _nextStationID = 0;

  //creates lists
  List<Passenger> _passengerList = new ArrayList<Passenger>();
  List<Station> _stationList = new ArrayList<Station>();
  List<Service> _serviceList = new ArrayList<Service>();

   void registerPassenger(String name){
       _passengerList.add(new Passenger(name, _nextPassengerID++));
   }


   Station registerStation (String name){
       Station station = new Station(name, _nextStationID++);
       _stationList.add(station);
       return station;
   }

   Service registerService (int serviceId,double cost){
       Service service = new Service(serviceId, cost);
       _serviceList.add(service);
       return service;
   }

   // void ou Passenger ??
   void changePassengerName(int id, String name) throws NoSuchPassengerIdException{
       for (Passenger p : _passengerList){
           if (p.getID() == id){
               p.changeName(name);
               return;
           }
       }
       throw new NoSuchPassengerIdException( id );
   }

   String searchPassengerId(int id) throws NoSuchPassengerIdException{
       for (Passenger p : _passengerList){
           if (p.getID() == id){
               return p.toString();
           }
       }
       throw new NoSuchPassengerIdException( id );
   }

   List<String> searchServiceId(int id) throws NoSuchServiceIdException{
       for ( Service s : _serviceList ){ // search in service list
           if (s.getId() == id){
               return s.printService();
           }
       }
       throw new NoSuchServiceIdException( id );
   }

   Station searchStationName(String name) throws NoSuchStationNameException{

       //acho que temos de utilizar excepcoes aqui
       //NoSuchStationNameException
       for(Station s : _stationList){
           if (s.compareName(name))
            return s;
       }
       throw new NoSuchStationNameException(name);
   }

   List<String> showAllPassengers(){
//não é necessario ordenar passageiros. inseridos por ordem.
       List<String> list = new ArrayList<String>();
       for ( Passenger p : _passengerList ){
           list.add( p.toString() );
       }
       List<String> unmodifiableList = Collections.unmodifiableList(list);
       return unmodifiableList;
   }


  //FIXME implement other functions if necessary

}
