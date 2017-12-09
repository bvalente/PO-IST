package mmt.core;

class Normal extends Category{

    Normal(Passenger passenger){
        super(passenger);
    }

    @Override
    public String toString(){
        return "NORMAL";
    }

    @Override
    float getDiscount(){
        return 1f;
    }

    @Override
    void update( double sum ) {
        if ( sum >= 2500 ){
            _passenger.changeDiscount( new Special(_passenger) );
        }
        else if  ( sum >= 250 ){
            _passenger.changeDiscount( new Frequent(_passenger) );
        }
    }
}
