package mmt.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

/**
 * This class represents a Station.
 * A Station has an numeric identifier (assigned automatically and sequentially) and a name.
 *
 * @author Bernardo Valente & Francisco Machado
 */
class Station implements Serializable{

    /** Station's name.*/
    private String _name;

     /** Station's numeric identifier. */
    private int _id;

    /** This Station's correspondent TrainStops, in the form of a list. */
    List<TrainStop> _trainStopList;

    /**
     * Constructor
     *
     * @param name station name.
     * @param id station numeric identifier.
     */
    Station(String name, int id){
        _name = new String(name);
        _id = id;
        _trainStopList = new ArrayList<TrainStop>();
    }

    /**
     * Register a TrainSop to this Station.
     *
     * @param ltime the time of departure of the train.
     * @param service wich service this TrainStop corresponds to.
     */
    TrainStop registerTrainStop(LocalTime ltime,Service service){
        TrainStop trainStop = new TrainStop(this, ltime, service);
        _trainStopList.add(trainStop);
        service.addTrainStop(trainStop);
        return trainStop;
    }

    /**
     * @return station id.
     */
    int getId(){
        return _id;
    }

    /**
     * Compares the station's id with  the id of another station.
     *
     * @param station station to compare to.
     */
    Boolean compareStationId(Station station){
        return this.getId() == station.getId();
    }

    /**
     * Compares this station's name with anoter name.
     *
     * @param name name to compare to.
     */
    Boolean compareName(String name){
        return _name.equals(name);
    }

    /**
     * @return a String with the Station's name.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return _name;
    }
    
}
