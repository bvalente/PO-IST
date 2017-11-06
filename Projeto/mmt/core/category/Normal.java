package mmt.core.category;

public class Normal extends Category{

    @Override
    public String getNome(){
        return "Normal";
    }

    @Override
    public float getDiscount(){
        return 1f;
    }
}
