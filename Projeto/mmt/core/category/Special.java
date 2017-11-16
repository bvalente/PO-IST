package mmt.core;

class Special extends Category {

    Special(Passenger passenger){
        super(passenger);
    }

    @Override
    String getNome(){
        return "Specials";
    }

    @Override
    float getDiscount(){
        return 0.5f;
    }

    @Override
    void update( int sum ) {
        if ( sum <= 250 ){
            _passenger._discount = new Normal(_passenger);
        }
        else if ( sum >= 2500 ) {
            _passenger._discount = new Frequent(_passenger);
        }
    }
}
