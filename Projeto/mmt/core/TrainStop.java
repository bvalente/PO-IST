package mmt.core;

import java.time.LocalTime;

class TrainStop {

    LocalTime _time;
    Station _station;
    Service _service;

    TrainStop (Station station, LocalTime time,  Service service) {
        _time = time;
        _station = station;
        _service = service;

    }

    LocalTime getTime(){ return _time; }

    Station getStation(){ return _station; }

    Service getService(){ return _service; }

}
