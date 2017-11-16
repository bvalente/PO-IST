package mmt.core;

abstract class Category{

    abstract String getNome();

    abstract float getDiscount();

    abstract void update( Passenger p, int sum );
}
