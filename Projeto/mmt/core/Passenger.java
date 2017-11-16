package mmt.core;

import java.io.Serializable;


import mmt.core.category.*;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
//state design pattern (wikialameda)

class Passenger implements Serializable{

    private String _name;
    private int _id;
    Category _discount;
    private List<Itinerary> _travels; // ??
    private int _totalMoneySpent;
    private LocalTime _totalTime;

    Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal(this);
        _travels = new ArrayList<Itinerary>();
        _totalTime = LocalTime.MIN;
    }

    void addItenerary(Itinerary itin){
        int sum = 0;
        int size = _travels.size();

        //ver os ultimos 10 itenerarios na lista
        if (size >= 10){
            for (int i = 0; i <10 ; i++)
                sum += _travels.get(size-i).getCost();
        } else {
            for (Itinerary i : _travels)
                sum += i.getCost();
        }


        //atualizar o desconto com _discount.update
        _discount.update(sum);

        //receber o valor do desconto que pode ter mudado ou nao _discount.getDiscount

        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(itin);
    }

    int getID(){
        return _id;
    }
    String getName(){
        return _name;
    }
    void changeName(String name){
        _name = new String(name);
    }

    public String toString(){
        //apresentar com duas casas decimais

        return _id + "|" + _name.toString() + "|" + _travels.size() + "|" + String.format("%.2f",_totalMoneySpent) + "|" + _totalTime.toString()+"";
    }
}
