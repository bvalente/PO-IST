package mmt.core;

import java.time.LocalTime;

class TrainStop {

    LocalTime _time;
    Station _station;
    Service _service;

    TrainStop (LocalTime time, Station station, Service service) {
        _time = time;
        _station = station;
        _service = service;

    }

    public LocalTime getTime(){ return _time; }

    public Station getStation(){ return _station; }

    public Service getService(){ return _service; }

}
