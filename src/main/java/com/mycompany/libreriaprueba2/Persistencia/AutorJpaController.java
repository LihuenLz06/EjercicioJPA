package com.mycompany.libreriaprueba2.Persistencia;


import com.mycompany.libreriaprueba2.Entidades.Autor;
import com.mycompany.libreriaprueba2.Entidades.Editorial;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;



public class AutorJpaController extends CRUD<Autor> implements Serializable {

     public AutorJpaController() {
        super();
    }

    @Override
    public void delete(Autor autor) {
        super.delete(autor); 
    }

    @Override
    public void update(Autor autor) {
        super.update(autor); 
    }

    @Override
    public void create(Autor autor) {
        super.create(autor); 
    }
    
     //Este metodo trae todo lo que contiene la clase Autor
    public List<Autor> findAutorEnt (){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Autor.class));//Esta es la consulta en la base de datos, esta es la sintaxis
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public Autor finID(int id){
        try {
            return em.find(Autor.class, id);
        } catch (Exception e) {
            System.out.println("No existe ese id");
            return null;
        }
    }
    
    public List<Autor> findNombreAutor(String nombre){
        try {
           TypedQuery<Autor> query = em.createQuery("SELECT autor FROM Autor autor WHERE autor.nombre = :nombre", Autor.class);
        query.setParameter("nombre", nombre);
         if (!query.getResultList().isEmpty()) {
           // Autor autorEn = autoresEncontrados.get(0);
          //  System.out.println("Los datos del autor son: " + autorEn.toString());
             System.out.println("La lista esta vacia");
         }
        return query.getResultList();
        } catch (Exception e) {
            System.out.println("No existe un Autor con ese nombre");
            return null;
        }
    }
}
