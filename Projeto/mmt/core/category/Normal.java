package mmt.core;

class Normal extends Category{

    Normal(Passenger passenger){
        this.super(passenger);
    }
    @Override
    String getNome(){
        return "Normal";
    }

    @Override
    float getDiscount(){
        return 1f;
    }

    @Override
    void update( int sum ) {
        if ( sum >= 250 ){
            _passenger._discount = new Frequent();
        }
        else if  ( sum >= 2500 ){
            _passenger._discount = new Special();
        }
    }
}
