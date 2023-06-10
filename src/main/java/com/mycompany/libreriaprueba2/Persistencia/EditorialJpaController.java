package com.mycompany.libreriaprueba2.Persistencia;


import com.mycompany.libreriaprueba2.Entidades.Editorial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;



public class EditorialJpaController extends CRUD<Editorial> {

    public EditorialJpaController() {
        super ();
    }

   
    public void delete(Editorial editorial) {
        super.delete(editorial); 
    }

    
    public void update(Editorial editorial) {
        super.update(editorial); 
    }

   
    public void create(Editorial editorial) {
        super.create(editorial); 
    }
    
    //Este metodo trae todo lo que contiene la clase Editorial
    public List<Editorial> findEditorialEnt (){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Editorial.class));//Esta es la consulta en la base de datos, esta es la sintaxis
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public Editorial finID(int id){
        try {
            return em.find(Editorial.class, id);
        } catch (Exception e) {
            System.out.println("No existe ese id");
            return null;
        }
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
