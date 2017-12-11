package mmt.core;

import java.io.Serializable;
import java.util.List;
import java.time.LocalTime;
import java.time.Duration;

/**
* This class represents a segment.<p>
* A Segment is a portion of a service, from the firstStop to the lastStop,
* A Segment has a cost based on its the length.
*
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Segment implements Serializable{

    private TrainStop _firstStop;
    private TrainStop _lastStop;
    private double _cost;

    /**Service associated to the segment*/
    private Service _service;

    /**
    * Constructor
    *
    * @param firstStop of the segment
    * @param lastStop of the segment
    * @param service containing the segment
    */
    Segment(TrainStop firstStop, TrainStop lastStop, Service service ){
        _firstStop = firstStop;
        _lastStop = lastStop;
        _service = service;
        _cost = service.segmentPrice(this);
    }

    /**
    * @return first stop of a segment*/
    TrainStop getFirstStop(){
        return _firstStop;
    }

    /**
    * @return last stop of a segment*/
    TrainStop getLastStop(){
        return _lastStop;
    }

    /**
    * @return cost of a segment*/
    double getCost(){
        return _cost;
    }

    /**
    * @return Service associated to the segment*/
    Service getService(){
        return _service;
    }

    /**
    * Shows segment information and details. <p>
    *
    * @return String list of the stations between the first and last stop of the segment.
    *
    */
    List<String> showSegment(){
        return _service.showSegment(this);
    }

    /**
    * @return time of arrival of the segments last stop.
    *
    */
    LocalTime timeOfArrival(){
        return _lastStop.getTime();
    }

    /**
    * @return time of departure of the segments first stop.
    *
    */
    LocalTime timeOfDeparture(){
        return _firstStop.getTime();
    }

    /**
    * @return Segments travel time. */
    long totalTime(){
        return Duration.between(this.timeOfDeparture(), this.timeOfArrival()).toMinutes();
    }
}
