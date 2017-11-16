package mmt.core;

class Frequent extends Category {

    Frequent(Passenger passenger){
        super(passenger);
    }

    @Override
    String getNome(){
        return "Frequent";
    }

    @Override
    float getDiscount(){
        return 0.85f;
    }

    @Override
    void update ( int sum ) {
        if ( sum <= 250 ){
            _passenger._discount = new Normal(_passenger);
        }
        else if ( sum >= 2500 ) {
            _passenger._discount = new Special(_passenger);
        }
    }


}
