package mmt.core;

import java.io.Serializable;
import java.util.List;
import java.time.LocalTime;
import java.time.Duration;

class Segment implements Serializable{
    private TrainStop _firstStop;
    private TrainStop _lastStop;
    private double _cost;
    private Service _service;
    //var para ver qual serviço a que o segmento está associado

    Segment(TrainStop firstStop, TrainStop lastStop, Service service ){
        _firstStop = firstStop;
        _lastStop = lastStop;
        _service = service;
        _cost = service.segmentPrice(this);
    }

    TrainStop getFirstStop(){
        return _firstStop;
    }

    TrainStop getLastStop(){
        return _lastStop;
    }

    double getCost(){
        return _cost;
    }

    Service getService(){
        return _service;
    }

    List<String> showSegment(){
        return _service.showSegment(this);
    }

    LocalTime timeOfArrival(){
        return _lastStop.getTime();
    }

    LocalTime timeOfDeparture(){
        return _firstStop.getTime();
    }

    long totalTime(){
        return Duration.between(this.timeOfDeparture(), this.timeOfArrival()).toMinutes();
    }
}
