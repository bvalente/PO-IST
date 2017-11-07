package mmt.core;

import mmt.app.NoSuchServiceException;

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

    public void showServiceId(int id){
        return id;
    }    
