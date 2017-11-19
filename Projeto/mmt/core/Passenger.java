package mmt.core;

import java.io.Serializable;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Class que representa um passageiro.
 *
 * @author Bernardo Valente & Francisco Machado
 */

class Passenger implements Serializable{

    /** Nome do Passageiro. */
    private String _name;

    /** Id do Passageiro. */
    private int _id;

    /** Categoria dos discontos do Passageiro. */
    Category _discount;

    /** Lista de Itenerários que o Passageiro já realizou. */
    private List<Itinerary> _travels; // terceira entrega

    /** Dinheiro total que o Passageiro já gastou em viagens. */
    private float _totalMoneySpent;

    /** Tempo total de vaigem do Passageiro. */
    private LocalTime _totalTime;

    /**
     * Construtor.
     *
     * @param name nome do Passegeiro.
     * @param id id do Passageiro.
     */
    Passenger(String name, int id){
        _id = id;
        _name = name;
        _discount = new Normal(this);
        _travels = new ArrayList<Itinerary>();
        _totalTime = LocalTime.MIN;
    }

    /**
     * Adiciona um itenerário à lista de itenerários do passageiros.
     *
     * @param itin itenerário a adicionar à lista.
     */

    void addItenerary(Itinerary itin){
        int sum = 0;
        int size = _travels.size();

        //ver os ultimos 10 itenerários na lista
        if (size >= 10){
            for (int i = 0; i <10 ; i++)
            sum += _travels.get(size-i).getCost();
        } else {
            for (Itinerary i : _travels)
            sum += i.getCost();
        }

        //atualizar o desconto segundo o dinheiro gasto anterioramente
        _discount.update(sum);

        //receber o valor do desconto que pode ter mudado ou nao
        _totalMoneySpent += _discount.getDiscount() * itin.getCost();
        _travels.add(itin);
    }

    /**
     * @return id do passageiro.
     */
    int getID(){
        return _id;
    }

    /**
     * @return nome do passageiro.
     */
    String getName(){
        return _name;
    }

    /**
     * Muda o nome do passageiro.
     *
     * @param name nome a substituir.
     */
    void changeName(String name){
        _name = new String(name);
    }

    /**
     * @return uma String com as informações do passageiro.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        // estrutura do String
        // id|nome|categoria|n´ umero-de-itiner´ arios|valor-pago|tempo-acumulado

        return  _id + "|" + _name.toString() + "|" + _discount.toString() +"|" +
        _travels.size() + "|" + String.format( new Locale("en", "US"), "%.2f",_totalMoneySpent) +
        "|" + _totalTime.toString() ;
    }
}
