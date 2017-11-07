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



//FIXME import other classes if necessary

/**
 * A train company has schedules (services) for its trains and passengers that
 * acquire itineraries based on those schedules.
 */
public class TrainCompany implements java.io.Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

  //creates a service list
  List<Service> serviceList = new ArrayList<Service>;

  void importFile(String filename) {
    //FIXME implement function
  }

  /*FIXME
   * add methods for
   *   registerPassenger, changePassengerName
   *   searchItineraries, commitItinerary
   */
   public Service searchServiceId() throws NoSuchServiceIdException{
       for ( Service s : serviceList ){ // search in service list
               if (s.showServiceId() == id){
                   return s;
               }
           }
       }
       return NoSuchServiceIdException;
   }

  //FIXME implement other functions if necessary

}
