package mmt.core.category;

public class Frequent extends Category {

    @Override
    public String getNome(){
        return "Frequent";
    }

    @Override
    public float getDiscount(){
        return 0.85;

    }


}
