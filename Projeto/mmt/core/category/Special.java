package mmt.core;

class Special extends Category {

    @Override
    String getNome(){
        return "Specials";
    }

    @Override
    float getDiscount(){
        return 0.5f;
    }

    @Override
    void update( Passenger p, int sum ) {
        if ( sum <= 250 ){
            p._discount = new Normal();
        }
        else if ( sum >= 2500 ) {
            p._discount = new Frequent();
        }
    }
}
