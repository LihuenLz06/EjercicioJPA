package com.mycompany.libreriaprueba2.Entidades;

import com.mycompany.libreriaprueba2.Entidades.Libro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-05T12:04:15")
@StaticMetamodel(Editorial.class)
public class Editorial_ { 

    public static volatile ListAttribute<Editorial, Libro> listaLibro;
    public static volatile SingularAttribute<Editorial, Boolean> alta;
    public static volatile SingularAttribute<Editorial, Integer> id;
    public static volatile SingularAttribute<Editorial, String> nombre;

}