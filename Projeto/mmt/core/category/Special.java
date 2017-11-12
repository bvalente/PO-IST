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
}
