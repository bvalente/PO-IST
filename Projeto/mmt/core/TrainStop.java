package mmt.core;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * This class represents a train stop.<p>
 * A train stop has a time of departure, a station and service (that it belongs).
 *
 *
 * @author Bernardo Valente & Francisco Machado
 * @version 1.0
 */
class TrainStop implements Serializable{

    /** _time is a Departure time. */
    private LocalTime _time;
    private Station _station;

    /** A trainStop keeps track of what service it belongs to. */
    private Service _service;

    TrainStop (Station station, LocalTime time,  Service service) {
        _time = time;
        _station = station;
        _service = service;

    }

    LocalTime getTime(){ return _time; }

    Station getStation(){ return _station; }

    Service getService(){ return _service; }

    /**
    * @return string with departure time
    */
    public String toString(){
        return _time + " " + _station.toString();
    }


}
