package mmt.core;

import java.io.Serializable;

class Segment implements Serializable{
    private TrainStop _firstStop;
    private TrainStop _lastStop;
    private float _cost;
    //var para ver qual serviço a que o segmento está associado

    Segment(TrainStop firstStop, TrainStop lastStop, float cost){
        _firstStop = firstStop;
        _lastStop = lastStop;
        _cost = cost;
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

}
