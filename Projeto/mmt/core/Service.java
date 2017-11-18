package mmt.core;

import java.io.Serializable;
import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


class Service implements Serializable{

    private int _id;
    private double _totalCost;
    private List<TrainStop> _trainStopList;

    Service (int id, double totalCost){
        _id = id;
        _totalCost = totalCost;

        _trainStopList = new LinkedList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        _trainStopList.add(ts);
    }

    int getId(){
        return _id;
    }


    public List<String> printService(){
        List<String> list = new ArrayList<String>();

        list.add("Serviço #" + _id + " @ " +_totalCost);
        for (TrainStop trainStop : _trainStopList){
            list.add( trainStop.toString() );
        }
        return list;

    }
}
