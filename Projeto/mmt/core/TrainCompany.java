package mmt.core;

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


import java.util.List;
import java.util.ArrayList;
//FIXME import other classes if necessary

/**
 * A train company has schedules (services) for its trains and passengers that
 * acquire itineraries based on those schedules.
 */
class TrainCompany implements java.io.Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

  private int nextPassengerID = 0; //static?

  //creates lists
  List<Service> serviceList = new ArrayList<Service>();
  List<Passenger> passengerList = new ArrayList<Passenger>();

  void importFile(String filename) {
    //FIXME implement function
  }

  /*FIXME
   * add methods for
   *   registerPassenger, changePassengerName
   *   searchItineraries, commitItinerary
   */

   void registerPassenger(String name){
       passengerList.add(new Passenger(name, nextPassengerID++));
   }

   void changePassengerName(int id, String name) throws NoSuchPassengerIdException{
       for (Passenger p :passengerList){
           if (p.getID() == id){
               p.changeName(name);
               return;
           }
       }
       throw new NoSuchPassengerIdException( id );
   }

   Service searchServiceId(int id) throws NoSuchServiceIdException{
       for ( Service s : serviceList ){ // search in service list
           if (s.showServiceId() == id){
               return s;
           }
       }
       throw new NoSuchServiceIdException( id );
   }

  //FIXME implement other functions if necessary

}
