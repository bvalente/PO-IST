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
import java.time.Duration;

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

    TrainStop getTrainStop(String name){
        for(TrainStop ts : _trainStopList){
            if (ts.getStation().compareName(name) ){
                return ts;
            }
        }
        //nao existe trainstop no servico
        return null;
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

    long totalTime(){
        return Duration.between(this.getFirstTrainStop().getTime(), this.getLastTrainStop().getTime()).toMinutes();
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
            String.format( new Locale("en", "US"), "%.2f", s.getCost()));
        for ( TrainStop ts : segment ){
            list.add( ts.toString() );
        }
        return list;
    }

    Segment getSegment(TrainStop s1, TrainStop s2){
        return new Segment(s1,s2, this );
    }

    public double segmentPrice(Segment seg){
        double cost;
        //preco * tempo segmento / tempo servico
        cost = _totalCost * seg.totalTime() / this.totalTime();
        return cost;
    }

    TrainStop hasStation(Station station){
        for (TrainStop ts : _trainStopList){
            if ( ts.getStation().compareStationId(station) ){
                return ts;
            }
        }
        return null;
    }



    Itinerary compute(TrainStop departure, Station arrival, List<Service> servicesUsed, List<Station> stationsUsed, LocalDate date, LocalTime time){
        //passar também tempo e data do Input como argumentos? a função dada pelo stor do search itineraries em ticket office recebe.
        Itinerary it = null;
        Itinerary itAux = null;

        //simple itinerary
        TrainStop arrivalTS = this.hasStation(arrival);
        if ( arrivalTS != null && departure.isBefore(arrivalTS) && departure.getTime().isAfter(time)){
            Segment segment = new Segment(departure, arrivalTS, this);
            return new Itinerary(segment, date);
        }
        //complex itinerary
        //else
        servicesUsed.add( departure.getService() );
        for ( TrainStop trainStop : _trainStopList ){   // percorre serviço
            if ( departure.isBefore( trainStop ) && trainStop.getTime().isAfter(time) ){ // selects trainStops : time

                Station station = trainStop.getStation();
                // checks if station was already used
                if ( stationsUsed.contains( trainStop.getStation() ) ) return it;
                stationsUsed.add(station );

                Segment seg = new Segment(departure, trainStop, this);
                for( Service service : station.getServiceList() ){
                    //checks if the service was already used, leaves the cycle for another service
                    if(! servicesUsed.contains(service) ) {
                        TrainStop ts = service.hasStation(station);

                        List<Service> copyServicesUsed = new ArrayList<Service>(servicesUsed);
                        List<Station> copyStationsUsed = new ArrayList<Station>(stationsUsed);
                        itAux = service.compute ( ts, arrival, copyServicesUsed, copyStationsUsed, date, trainStop.getTime());
                        if (itAux != null){

                            itAux.addSegment(seg);

                            if(it == null ){ //it = null, itAux = Itinerary
                                it = itAux;

                            } else { //it = Itinerary, itAux = Itinerary

                                //compare itineraries
                                int x = it.timeOfArrival().compareTo( itAux.timeOfArrival() );
                                //x < 0: it chega primeiro
                                //x = 0: chegam ao mesmo tempo, ver o que tiver menor custo
                                //x > 0: itAux cheaga primeiro
                                if ( ( x == 0 && it.getCost() > itAux.getCost() ) || x > 0 ) {
                                    it = itAux;
                                }
                            }
                        }
                    }
                    //compute nao deu nenhum itinerario
                }

            }
        } //fim do for

        return it; //erro, nao encontrou itinerario
        //fim da funcao
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


}
