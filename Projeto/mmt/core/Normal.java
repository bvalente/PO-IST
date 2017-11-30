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
    void update( int sum ) {
        if ( sum >= 250 ){
            _passenger.changeDiscount( new Frequent(_passenger) );
        }
        else if  ( sum >= 2500 ){
            _passenger.changeDiscount( new Special(_passenger) );
        }
    }
}