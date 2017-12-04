package mmt.core;

import java.io.Serializable;

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
        _cost = service.segmentPrice(firstStop, lastStop);
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
}
