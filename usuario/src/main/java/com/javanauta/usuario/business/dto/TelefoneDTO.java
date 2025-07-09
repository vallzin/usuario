package com.javanauta.usuario.business.dto;

public class TelefoneDTO {

    private String numero;
    private String ddd;

    public TelefoneDTO(){}

    public TelefoneDTO(String  numero,
                    String ddd){
        this.numero = numero;
        this.ddd = ddd;
    }

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

        public Builder numero(String numero){ this.numero = numero; return this; }
        public Builder ddd(String ddd){ this.ddd = ddd; return this; }

        public TelefoneDTO build(){
            TelefoneDTO telefone = new TelefoneDTO();
            telefone.setNumero(this.numero);
            telefone.setDdd(this.ddd);
            return telefone;
        }
    }
}
