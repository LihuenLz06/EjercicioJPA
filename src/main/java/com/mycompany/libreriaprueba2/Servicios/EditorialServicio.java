package com.mycompany.libreriaprueba2.Servicios;

import com.mycompany.libreriaprueba2.Entidades.Editorial;
import com.mycompany.libreriaprueba2.Entidades.Libro;
import com.mycompany.libreriaprueba2.Persistencia.EditorialJpaController;
import com.mycompany.libreriaprueba2.Persistencia.LibroJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EditorialServicio {
    
     private EditorialJpaController editcrud = new EditorialJpaController();
     Scanner sc = new Scanner(System.in);
    
    List<Editorial> listaEditoriales = new ArrayList();
    List<Libro> Libros = new ArrayList();
    LibroJpaController libcrud = new LibroJpaController();
    
     /////// Crear
    public void crearEditorial() {
        try {
            Editorial editorial1 = new Editorial( "Planeta", Boolean.TRUE, Libros);
            editcrud.create(editorial1);
            listaEditoriales.add(editorial1);
            Editorial editorial2 = new Editorial("Santillana", Boolean.TRUE, Libros);
            editcrud.create(editorial2);
            listaEditoriales.add(editorial2);
            Editorial editorial3 = new Editorial("Torre de Papel", Boolean.TRUE, Libros);
            editcrud.create(editorial3);
            listaEditoriales.add(editorial3);
        } catch (Exception e) {
            System.out.println("Error al crear editorial");
        }
    }
    
    public void findListEditorial(){
        listaEditoriales.clear();
        listaEditoriales = editcrud.findEditorialEnt();
    }
    
 public void borrarEditorial(int id){
     try {
         System.out.println("Que id desea borrar");
         int idEditorial = sc.nextInt();
         Editorial edit = editcrud.finID(idEditorial);
         if(edit != null){
             edit.setAlta(Boolean.FALSE);
             listaEditoriales.remove(edit);
             editcrud.delete(edit);
             Libros = edit.getListaLibro();
             for (Libro aux : Libros) {
                 aux.setEditorial(null);
                 libcrud.update(aux);
             }
             System.out.println("La editorial fue borrada con exito");
         }
     } catch (Exception e) {
         System.out.println("No existe esa editorial");
     }
 }
 
 public void editarEditorial(int id){
     try {
         System.out.println("Que editorial desea editar");
         int idEditorial = sc.nextInt();
         Editorial edit = editcrud.finID(idEditorial);
         if(edit != null){
             System.out.println("Cual es el nuevo nombre de la editorial");
             String nomEdit = sc.next();
             edit.setNombre(nomEdit);
             editcrud.update(edit);
             System.out.println("La editorial fue modificada con exito");
         }
     } catch (Exception e) {
         System.out.println("No existe esa editorial");
     }
 }

}
