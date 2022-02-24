package br.com.gilson.quarkus.crud;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Representa a entidade Produto. 
 * O {@link PanacheEntity} fornece implementações do ORM Hibernate
 */
@Entity
public class Produto extends PanacheEntity {
    
    public String nome;
    public BigDecimal valor;

    @CreationTimestamp
    public Date dataCriacao;
    
    @UpdateTimestamp
    public Date dataAtualizacao;
}
