package com.javanauta.usuario.business.dto;


import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTO> enderecos;
    private List<TelefoneDTO> telefones;

    public UsuarioDTO(){}

    public UsuarioDTO(String nome,
                      String email,
                      String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome = nome; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public String getSenha(){ return senha; }
    public void setSenha(String senha){ this.senha = senha; }
    public List<EnderecoDTO> getEnderecos(){ return enderecos; }
    public  void setEnderecos(List<EnderecoDTO> enderecos){ this.enderecos = enderecos; }
    public List<TelefoneDTO> getTelefones(){ return telefones; }
    public void setTelefones(List<TelefoneDTO> telefones){ this.telefones = telefones; }

    public static Builder builder(){ return new Builder(); }

    public static class Builder{
        private Long id;
        private String nome;
        private String email;
        private String senha;
        private List<EnderecoDTO> enderecos;
        private List<TelefoneDTO> telefones;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder senha(String senha){
            this.senha = senha;
            return this;
        }

        public Builder enderecos(List<EnderecoDTO> enderecos){
            this.enderecos = enderecos;
            return this;
        }

        public Builder telefones(List<TelefoneDTO> telefones){
            this.telefones = telefones;
            return this;
        }

        public UsuarioDTO build(){

            UsuarioDTO usuario = new UsuarioDTO();

            usuario.setId(this.id);
            usuario.setNome(this.nome);
            usuario.setEmail(this.email);
            usuario.setSenha(this.senha);
            usuario.setEnderecos(this.enderecos);
            usuario.setTelefones(this.telefones);

            return usuario;
        }

    }

}
