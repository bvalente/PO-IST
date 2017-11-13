package mmt.core;

class Station{

    String _name;
    int _id;

    Station(String name, int id){
        _name = new String(name);
        _id = id;

    }

    Boolean compareName(String name){
        return _name.equals(name);
    }
}
