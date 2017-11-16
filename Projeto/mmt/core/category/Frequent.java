package mmt.core;

class Frequent extends Category {

    @Override
    String getNome(){
        return "Frequent";
    }

    @Override
    float getDiscount(){
        return 0.85f;
    }

    @Override
    void update ( Passenger p, int sum ) {
        if ( sum <= 250 ){
            p._discount = new Normal();
        }
        else if ( sum >= 2500 ) {
            p._discount = new Special();
        }
    }


}
