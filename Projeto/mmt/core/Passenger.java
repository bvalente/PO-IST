package mmt.core;

protected class Passenger {

    String _name;
    int _id;
    Category _discount;
    List<Itenerary> historico; // ??

    protected Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal();
    }

    protected String toString(){
        return new String(_name);
    }

    protected ChangeDiscount(){
        /* ve o historico do passageiro e altera consoante o dinheiro gasto
        nos ultimos 10 itenerarios
        250 euros -> frequente
        2500 euros -> especial
        */

    }
}
