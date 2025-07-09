package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;

    public Telefone(){}

    public Telefone(String  numero,
                    String ddd){
        this.numero = numero;
        this.ddd = ddd;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getNumero(){ return numero; }
    public void setNumero(String numero){ this.numero = numero; }
    public String getDdd(){ return ddd; }
    public void setDdd(String ddd){ this.ddd = ddd; }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String numero;
        private String ddd;

        public Builder numero(String numero){
            this.numero = numero;
            return this;
        }

        public Builder ddd(String ddd){
            this.ddd = ddd;
            return this;
        }

        public Telefone build(){
            Telefone telefone = new Telefone();
            telefone.setNumero(this.numero);
            telefone.setDdd(this.ddd);
            return telefone;
        }

    }
}
