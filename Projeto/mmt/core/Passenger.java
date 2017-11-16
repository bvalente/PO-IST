package mmt.core;

import mmt.core.category.*;

import java.util.List;
import java.util.ArrayList;
//state design pattern (wikialameda)

public class Passenger {

    private String _name;
    private int _id;
    Category _discount;
    private List<Itinerary> _travels; // ??
    private int _totalMoneySpent;

    Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal();
        _travels = new ArrayList<Itinerary>();
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
        _discount.update(this, sum);
        
        //receber o valor do desconto que pode ter mudado ou nao _discount.getDiscount

        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(itin);
    }

    int getID(){
        return _id;
    }
    void changeName(String name){
        _name = new String(name);
    }

    public String toString(){
        return new String(_name);
    }
}
