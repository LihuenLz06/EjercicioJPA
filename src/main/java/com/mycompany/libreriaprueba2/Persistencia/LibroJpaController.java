package com.mycompany.libreriaprueba2.Persistencia;


import com.mycompany.libreriaprueba2.Entidades.Libro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;



public class LibroJpaController extends CRUD<Libro> implements Serializable {

    public LibroJpaController() {
        super();
    }

    @Override
    public void delete(Libro libro) {
        super.delete(libro); 
    }

    @Override
    public void update(Libro libro) {
        super.update(libro); 
    }

    @Override
    public void create(Libro libro) {
        super.create(libro); 
    }
    
     public List<Libro> findLibroEnt (){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libro.class));//Esta es la consulta en la base de datos, esta es la sintaxis
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    public Libro find(int isbn) {
        try {
            return em.find(Libro.class, isbn);
        } catch (Exception e) {
            System.out.println("Error al buscar el libro");
            return null;
        }
    }
    
     public List<Libro> libroIsbn(Integer isbn) {
        TypedQuery<Libro> query = em.createQuery("SELECT libro FROM Libro libro WHERE libro.isbn = :isbn", Libro.class);
        query.setParameter("isbn", isbn);
        return query.getResultList();
    }

    public List<Libro> libroTitulo(String titulo) {
        TypedQuery<Libro> query = em.createQuery("SELECT libro FROM Libro libro WHERE libro.titulo = :titulo", Libro.class);
        query.setParameter("titulo", titulo);
        return query.getResultList();
    }

    public List<Libro> libroAutor(String nombreAutor) {
        TypedQuery<Libro> query = em.createQuery("SELECT libro FROM Libro libro JOIN libro.autor autor WHERE autor.nombre = :nombreAutor", Libro.class);
        query.setParameter("nombreAutor", nombreAutor);
        return query.getResultList();
    }

    public List<Libro> libroEditorial(String nombreEditorial) {
        TypedQuery<Libro> query = em.createQuery("SELECT libro FROM Libro libro JOIN libro.editorial editorial WHERE editorial.nombre = :nombreEditorial", Libro.class);
        query.setParameter("nombreEditorial", nombreEditorial);
        return query.getResultList();
    }
}
    
