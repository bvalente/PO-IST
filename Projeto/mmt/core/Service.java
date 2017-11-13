package mmt.core;

import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;

class Service {

    int _id;
    double _totalCost;
    List<TrainStop> list;

    Service (int id, double totalCost){
        _id = id;
        _totalCost = totalCost;

        list = new LinkedList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        list.add(ts);
    }

    int getID(){
        return _id;
    }
}
