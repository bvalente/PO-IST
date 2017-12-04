package mmt.core;

import java.io.Serializable;

class Segment implements Serializable{
    private TrainStop _firstStop;
    private TrainStop _lastStop;
    private float _cost;
    private Service _service;
    //var para ver qual serviço a que o segmento está associado

    Segment(TrainStop firstStop, TrainStop lastStop, float cost, Service service){
        _firstStop = firstStop;
        _lastStop = lastStop;
        _cost = cost;
        _service = service;
    }

    TrainStop getFirstStop(){
        return _firstStop;
    }

    TrainStop getLastStop(){
        return _lastStop;
    }

    float getCost(){
        return _cost;
    }

    Service getService(){
        return _service;
    }
}
