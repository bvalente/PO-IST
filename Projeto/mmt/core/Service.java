package mmt.core;

import java.io.Serializable;
import mmt.app.exceptions.NoSuchServiceException;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

/**
* This class represents a Service: a route made by a train over several Stations.<p>
* Each train stop has a departure time.<p>
* A Service has an numeric identifier and a total cost. It is assumed that a service is performed every day.
*
* @author Bernardo Valente & Francisco Machado
* @version 1.0
*/

class Service implements Serializable{

    private int _id;
    private double _totalCost;

    /** a service has a list of train stops*/
    private List<TrainStop> _trainStopList;
    /**
    *
    * @param id defined in creation moment
    * @param totalCost
    *
    */
    Service (int id, double totalCost){
        _id = id;
        _totalCost = totalCost;

        _trainStopList = new ArrayList<TrainStop>();

    }

    void addTrainStop(TrainStop ts){
        _trainStopList.add(ts);
    }

    int getId(){
        return _id;
    }

    /** This method returns the first TrainStop in the train Stop List.<p>
    * @return TrainStop
    */
    TrainStop getFirstTrainStop(){
        return _trainStopList.get(0);
    }


    /** This method returns the first TrainStop in the train Stop List.<p>
    * @return TrainStop
    */
    TrainStop getLastTrainStop(){
        return _trainStopList.get(_trainStopList.size()-1);
    }

    /** This method returns the first Station in the train Stop List.<p>
    * @return Station
    */
    Station getFirstStation(){
        return this.getFirstTrainStop().getStation();
    }

    /** This method returns the first Station in the train Stop List.<p>
    * @return Station
    */
    Station getLastStation(){
        return this.getLastTrainStop().getStation();
    }

    List<TrainStop> getTrainStopListFrom(TrainStop ts){

        return _trainStopList.subList(
            _trainStopList.indexOf(ts), _trainStopList.indexOf(getLastTrainStop()) + 1 );
    }

    /**
    * @return the list is ready to be printed.
    */
    public List<String> showService(){
        List<String> list = new ArrayList<String>();

        list.add("Serviço #" + _id + " @ " +String.format( new Locale("en", "US"), "%.2f",_totalCost));
        for (TrainStop trainStop : _trainStopList){
            list.add( trainStop.toString() );
        }
        return list;
    }

    /**
    * @return the segment ready to be printed.
    */
    public List<String> showSegment(Segment s){
        List<String> list = new ArrayList<String>();

        List<TrainStop> segment = _trainStopList.subList(
            _trainStopList.indexOf(s.getFirstStop()),
            _trainStopList.indexOf(s.getLastStop()) + 1 );

        list.add("Serviço #" + Integer.toString(_id) + " @ " +
            String.format( new Locale("en", "US"), "%.2f", _totalCost));
        for ( TrainStop ts : segment ){
            list.add( ts.toString() );
        }
        return list;
    }

    Segment getSegment(TrainStop s1, TrainStop s2){
        return new Segment(s1,s2, this );
    }

    Segment getSimpleSegment(Station s1, Station s2, LocalTime time){
        int i, j;
        int length = _trainStopList.size();
        for (i = 0; i < length-1 ; i++){
            if (_trainStopList.get(i).getStation() == s1
                && time.compareTo(_trainStopList.get(i).getTime()) > 0){
                    /*FIXME pode acontecer que os dias nao sao iguas
                     nota: s2 é pós meia-noite*/

                for (j = i; j < length-1 ; j++){
                    if (_trainStopList.get(j).getStation() == s2){
                        return new Segment(_trainStopList.get(i),
                            _trainStopList.get(j), this);
                    }
                }
                return null;
            }

        }
        return null;

    }

    Segment getSimpleSegment(TrainStop ts, Station station){
        int indice = _trainStopList.indexOf(ts);
        int i;
        for(i = indice+1; i < _trainStopList.size()-1; i++){
            TrainStop ts2 = _trainStopList.get(i);
            if ( ts2.getStation().compareStationId( station ) ){
                return new Segment(ts, ts2, this);
            }
        }
        return null;
    }

    public double segmentPrice(TrainStop s1, TrainStop s2){
        double price;

        price = ( _totalCost * _trainStopList.size() ) /
            ( _trainStopList.indexOf(s2) + 1 - _trainStopList.indexOf(s1) );

        return price;
    }

    /**This nested class is used to compare two Services by their id.
    */
    public static class ServiceComparator implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return (s1.getId() - s2.getId());
        }

    }
    /**This nested class is used to compare two Services by their First TrainStop departing time.
    */
    public static class ServiceComparatorByDepartingTime implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return s1.getFirstTrainStop().getTime().compareTo(s2.getFirstTrainStop().getTime());
        }
    }

    /**This nested class is used to compare two Services by their First TrainStop arriving time.
    */
    public static class ServiceComparatorByArrivingTime implements Comparator<Service>{
        public int compare(Service s1, Service s2){
            return s1.getLastTrainStop().getTime().compareTo(s2.getLastTrainStop().getTime());
        }
    }
    /*
    Itinerario compute (TrainStop partida, Station Target ...){
    //mais argumentos: servicos ja visitados, estacoes por ja passadas

    se existir trainStop com estacao Target em this(Service)
    e a hora for posterior a partida
        return Itinerario

    //else
    for cada estacao depois de departure
    //utilizar servicos cuja trainStop de estacao saia de estacao depois da hora de partida

        for cada servico em estacao(expeto os ja visitados)
            iti = servico.compute(trainStop, target, ...)
            //atualizar melhor itinerario( se for mais rapido)
            reconstruir itinerario com o segmento atual no inicio
            (porque estamos a constuir do fim para o inicio)
    return itin


    //nota
    procurar o itinerario que chega ao destino mais cedo
    as estacoes so podem ser consideradas uma vez
    }

    */

}
