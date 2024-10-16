package com.a3.api.Entity;

/**
 * @author Dhomyny R F Souza
 * @version 1.0
 */

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Map<Item,String> itens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Item, String> getItens() {
        return itens;
    }

    public void setItens(Map<Item, String> itens) {
        this.itens = itens;
    }

    public Pedido(Integer id, Map<Item, String> itens) {
        this.id = id;
        this.itens = itens;
    }

    public Pedido() {
    }

    
}
