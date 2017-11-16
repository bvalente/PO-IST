package mmt.core;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;


class Station implements Serializable{

    private String _name;
    private int _id;

    List<TrainStop> _trainStopList;

    Station(String name, int id){
        _name = new String(name);
        _id = id;
        _trainStopList = new ArrayList<TrainStop>();

    }

    TrainStop registerTrainStop(LocalTime ltime,Service service){
        TrainStop trainStop = new TrainStop(this, ltime, service);
        _trainStopList.add(trainStop);
        service.addTrainStop(trainStop);
        return trainStop;
    }
    Boolean compareName(String name){
        return _name.equals(name);
    }
}
