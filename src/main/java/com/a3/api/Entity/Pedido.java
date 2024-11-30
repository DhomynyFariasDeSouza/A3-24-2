package com.a3.api.Entity;

/**
 * @author Dhomyny R F Souza
 * @version 1.0
 */


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   
     
    @Column
    @Enumerated(EnumType.STRING)
    private statusPedido status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id) {
        this.id = id;
    
    }

    public Pedido() {
    }

    
}
