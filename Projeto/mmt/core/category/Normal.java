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
}
