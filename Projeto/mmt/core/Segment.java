package mmt.core;

public class Segment{
    TrainStop _firstStop;
    TrainStop _lastStop;

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
