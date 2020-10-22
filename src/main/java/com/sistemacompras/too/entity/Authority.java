package com.sistemacompras.too.entity;

import javax.persistence.*;

@Entity
public class Authority { //Clase que sirve para los roles
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String authority;

    //Metodo que modifica el rol
    public void setAuthority(String authority){
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
