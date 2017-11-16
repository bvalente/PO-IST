package mmt.core;

import java.io.Serializable;


abstract class Category implements Serializable{

    protected Passenger _passenger;
    Category (Passenger passenger){
        _passenger = passenger;
    }

    abstract String getNome();

    abstract float getDiscount();

    abstract void update( int sum );

}
