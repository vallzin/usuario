package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    public Usuario(){}

    public Usuario(String nome,
                   String email,
                   String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public List<Endereco> getEnderecos(){
        return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos){
        this.enderecos = enderecos;
    }
    public List<Telefone> getTelefones(){
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones){
        this.telefones = telefones;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    @Override
    public String getPassword() {
        return senha;
    }
    @Override
    public String getUsername() {
        return email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String nome;
        private String email;
        private String senha;
        private List<Endereco> enderecos;
        private List<Telefone> telefones;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder enderecos(List<Endereco> enderecos) {
            this.enderecos = enderecos;
            return this;
        }

        public Builder telefones(List<Telefone> telefones) {
            this.telefones = telefones;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setNome(this.nome);
            usuario.setEmail(this.email);
            usuario.setSenha(this.senha);
            usuario.setEnderecos(this.enderecos);
            usuario.setTelefones(this.telefones);
            return usuario;
        }
    }
}
