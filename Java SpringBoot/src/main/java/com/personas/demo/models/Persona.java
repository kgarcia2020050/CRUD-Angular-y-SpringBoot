package com.personas.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefono",nullable = false)
    private String telefono;
    @Column(name = "edad",nullable = false)
    private int edad;

    public Persona() {
    }

    public Persona(Long idUsuario, String nombre, String apellido, String email, String telefono, int edad) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }


}
