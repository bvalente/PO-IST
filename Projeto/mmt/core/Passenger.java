package mmt.core;

import mmt.core.category.*;

import java.util.List;
import java.util.SequentialList;

public class Passenger {

    String _name;
    int _id;
    Category _discount;
    List<Itenerary> _travels; // ??
    int _totalMoneySpent;

    public Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal();
        _travels = new ArrayList<Itenerary>();
    }

    public void addItenerary(Itenerary itin){
        int sum = 0;
        int size = _travels.size();

        //ver os ultimos 10 itenerarios na lista
        if (size >= 10){
            for (int i = 0; i <10 ; i++)
                sum += _travels.get(size-i).getCost();
        } else {
            for (Itenerary i : _travels)
                sum += i.getCost();
        }


        if (sum >= 2500){
            _discount = new Special();
        } else if (sum >= 250){
            _discount = new Frequent();
        }

        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(itin);
    }


    public String toString(){
        return new String(_name);
    }
}
