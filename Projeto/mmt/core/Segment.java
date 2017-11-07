package mmt.core;

public class Segment{
    TrainStop _firstStop;
    TrainStop _lastStop;

    public Segment(TrainStop firstStop, TrainStop lastStop){
        _firstStop = firstStop;
        _lastStop = lastStop;

    }

    public getFirstStop(){
        return _firstStop;
    }

    public getLastStop(){
        return _lastStop;
    }

}
