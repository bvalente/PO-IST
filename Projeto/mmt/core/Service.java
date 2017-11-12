package mmt.core;

import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;

class Service {

    int _id;
    int _totalCost;
    List<TrainStop> list;

    Service (int id, int totalCost){
        _id = id;
        _totalCost = totalCost;

        list = new LinkedList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        list.add(ts);
    }

    int showServiceId(){
        return _id;
    }
}
