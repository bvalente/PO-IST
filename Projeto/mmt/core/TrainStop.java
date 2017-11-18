package mmt.core;

import java.io.Serializable;
import java.time.LocalTime;

class TrainStop implements Serializable{

    private LocalTime _time;
    private Station _station;
    private Service _service;

    TrainStop (Station station, LocalTime time,  Service service) {
        _time = time;
        _station = station;
        _service = service;

    }

    LocalTime getTime(){ return _time; }

    Station getStation(){ return _station; }

    Service getService(){ return _service; }

    public String toString(){
        return _time + " " + _station.toString();
    }


}
