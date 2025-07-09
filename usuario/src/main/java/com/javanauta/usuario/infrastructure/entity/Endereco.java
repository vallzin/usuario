package com.javanauta.usuario.infrastructure.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero", length = 20)
    private String numero;
    @Column(name = "complemento", length = 150)
    private String complemento;
    @Column(name = "bairro", length = 100)
    private String bairro;
    @Column(name = "cidade", length = 150)
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "cep", length = 9)
    private String cep;

    public Endereco(){}

    public Endereco(String rua,
                    String numero,
                    String complemento,
                    String bairro,
                    String cidade,
                    String estado,
                    String cep){
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getRua(){ return rua; }
    public void setRua(String rua){ this.rua = rua; }
    public String getNumero(){ return numero; }
    public void setNumero(String numero){ this.numero = numero; }
    public String getComplemento(){ return complemento; }
    public void setComplemento(String complemento){ this.complemento = complemento; }
    public String getBairro(){ return bairro; }
    public void setBairro(String bairro){ this.bairro = bairro; }
    public String getCidade(){ return cidade; }
    public void setCidade(String cidade){ this.cidade = cidade; }
    public String getEstado(){ return estado; }
    public void setEstado(String estado){ this.estado = estado; }
    public String getCep(){ return cep; }
    public void setCep(String cep){ this.cep = cep; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String rua;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String estado;
        private String cep;

        public Builder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public Builder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder complemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Endereco build() {
            Endereco endereco = new Endereco();
            endereco.setRua(this.rua);
            endereco.setNumero(this.numero);
            endereco.setComplemento(this.complemento);
            endereco.setBairro(this.bairro);
            endereco.setCidade(this.cidade);
            endereco.setEstado(this.estado);
            endereco.setCep(this.cep);
            return endereco;
        }
    }

}
