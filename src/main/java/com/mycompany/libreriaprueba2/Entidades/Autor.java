package com.mycompany.libreriaprueba2.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Boolean alta;
    @OneToMany (mappedBy = "autor")
    private List <Libro> listaLibro;
    
     public Autor() {
         this.alta = Boolean.TRUE;
    }

    public Autor(String nombre, Boolean alta, List<Libro> listaLibro) {
        this.nombre = nombre;
        this.alta = alta;
        this.listaLibro = listaLibro;
    }

    public List<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(List<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        String librosStr = "";
        for (Libro libro : listaLibro) {
            librosStr += "\n" + libro.getTitulo();
        }
        return "Autor [id=" + id + ", nombre=" + nombre + ", alta=" + alta + "]"
                + "\nLibros asociados:" + librosStr;
    }
     
     

}
