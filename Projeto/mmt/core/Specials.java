package mmt.core;

protected class Frequent extends Category {

    @Override
    protected String getNome(){
        return "Specials";
    }

    @Override
    protected float getDiscount(){
        return 0.5;
    }
