package mmt.core;

protected class Normal extends Category{

    @Override
    protected String getNome(){
        return "Normal";
    }

    @Override
    protected float getDiscount(){
        return 1f;
    }
}
