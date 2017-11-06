package mmt.core;

import mmt.core.category.*;

public class Passenger {

    String _name;
    int _id;
    Category _discount;
    List<Itenerary> historico; // ??

    public Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal();
    }

    public String toString(){
        return new String(_name);
    }

    public ChangeDiscount(){
        /* ve o historico do passageiro e altera consoante o dinheiro gasto
        nos ultimos 10 itenerarios
        250 euros -> frequente
        2500 euros -> especial
        */

    }
}
