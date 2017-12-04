package mmt.core;

import java.io.Serializable;
import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;


/**
* This class represents a Service: a route made by a train over several Stations.<p>
* Each train stop has a departure time.<p>
* A Service has an numeric identifier and a total cost. It is assumed that a service is performed every day.
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Service implements Serializable{

    private int _id;
    private double _totalCost;

    /** a service has a list of train stops*/
    private List<TrainStop> _trainStopList;
    /**
    *
    * @param id defined in creation moment
    * @param totalCost
    *
    */
    Service (int id, double totalCost){
        _id = id;
        _totalCost = totalCost;

        _trainStopList = new ArrayList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        _trainStopList.add(ts);
    }

    int getId(){
        return _id;
    }

    /** This method returns the first TrainStop in the train Stop List.<p>
    * @return TrainStop
    */
    TrainStop getFirstTrainStop(){
        return _trainStopList.get(0);
    }


    /** This method returns the first TrainStop in the train Stop List.<p>
    * @return TrainStop
    */
    TrainStop getLastTrainStop(){
        return _trainStopList.get(_trainStopList.size()-1);
    }

    /** This method returns the first Station in the train Stop List.<p>
    * @return Station
    */
    Station getFirstStation(){
        return this.getFirstTrainStop().getStation();
    }

    /** This method returns the first Station in the train Stop List.<p>
    * @return Station
    */
    Station getLastStation(){
        return this.getLastTrainStop().getStation();
    }



    /**
    * @return the list is ready to be printed.
    */
    public List<String> showService(){
        List<String> list = new ArrayList<String>();

        list.add("Serviço #" + _id + " @ " +String.format( new Locale("en", "US"), "%.2f",_totalCost));
        for (TrainStop trainStop : _trainStopList){
            list.add( trainStop.toString() );
        }
        return list;
    }

    /**
    * @return the segment ready to be printed.
    */
    public List<String> showSegment(Segment s){
        List<String> list = new ArrayList<String>();

        List<TrainStop> segment = _trainStopList.sublist(indexOf(s.getFirstStop), indexOf(s.getLastStop) + 1 );

        //add introductory string in SHOWitinerary
        for ( TrainStop trainStop : segment ){
            list.add( trainStop.toString() );
        }
        return segment;
    }

    public int segmentPrice(Segment s){
        float price;

        price = ( _totalCost * _trainStopList.size() ) / _trainStopList.sublist(indexOf(s.getFirstStop()), indexOf(s.getLastStop()) +1 ).size();

        return price;
    }

    /**This nested class is used to compare two Services by their id.
    */
    public static class ServiceComparator implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return (s1.getId() - s2.getId());
        }

    }
    /**This nested class is used to compare two Services by their First TrainStop departing time.
    */
    public static class ServiceComparatorByDepartingTime implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return s1.getFirstTrainStop().getTime().compareTo(s2.getFirstTrainStop().getTime());
        }
    }

    /**This nested class is used to compare two Services by their First TrainStop arriving time.
    */
    public static class ServiceComparatorByArrivingTime implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return s1.getLastTrainStop().getTime().compareTo(s2.getLastTrainStop().getTime());
        }
    }

}
