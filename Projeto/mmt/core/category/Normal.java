package mmt.core;

class Normal extends Category{

    @Override
    String getNome(){
        return "Normal";
    }

    @Override
    float getDiscount(){
        return 1f;
    }

    @Override
    void update( Passanger p, int sum ) {
        if ( sum >= 250 ){
            p._discount = new Frequent();
        }
        else if  ( sum >= 2500 ){
            p._discount = new Special();
        }
    }
}
