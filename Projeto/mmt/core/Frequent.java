package mmt.core;

protected class Frequent extends Category {

    @Override
    protected String getNome(){
        return "Frequent";
    }

    @Override
    protected float getDiscount(){
        return 0.85;

    }


}
