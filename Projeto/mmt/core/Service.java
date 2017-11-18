package mmt.core;

import java.io.Serializable;
import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;


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

    Station getFirstStation(){
        return _trainStopList.get(0).getStation();
    }
    Station getLastStation(){
        return _trainStopList.get(_trainStopList.size()-1).getStation();
    }


    public List<String> showService(){
        List<String> list = new ArrayList<String>();

        list.add("Serviço #" + _id + " @ " +String.format("%.2f",_totalCost));
        for (TrainStop trainStop : _trainStopList){
            list.add( trainStop.toString() );
        }
        return list;
    }

    public static class ServiceComparator implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return (s1.getId() - s2.getId());
        }

    }
}
