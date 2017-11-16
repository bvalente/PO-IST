package mmt.core;

import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;

class Service {

    int _id;
    double _totalCost;
    List<TrainStop> _trainStopList;

    Service (int id, double totalCost){
        _id = id;
        _totalCost = totalCost;

        _trainStopList = new LinkedList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        _trainStopList.add(ts);
    }

    int getID(){
        return _id;
    }
}
