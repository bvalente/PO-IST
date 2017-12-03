package mmt.core;

import java.io.Serializable;

class Segment implements Serializable{
    private TrainStop _firstStop;
    private TrainStop _lastStop;
    //var para ver qual serviço a que o segmento está associado

    Segment(TrainStop firstStop, TrainStop lastStop){
        _firstStop = firstStop;
        _lastStop = lastStop;
    }

    TrainStop getFirstStop(){
        return _firstStop;
    }

    TrainStop getLastStop(){
        return _lastStop;
    }


}
