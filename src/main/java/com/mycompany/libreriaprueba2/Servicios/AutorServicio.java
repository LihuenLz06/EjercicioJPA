package com.mycompany.libreriaprueba2.Servicios;

import com.mycompany.libreriaprueba2.Entidades.Autor;
import com.mycompany.libreriaprueba2.Entidades.Libro;
import com.mycompany.libreriaprueba2.Persistencia.AutorJpaController;
import com.mycompany.libreriaprueba2.Persistencia.LibroJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AutorServicio {

     private AutorJpaController autorcrud = new AutorJpaController();
     private LibroJpaController libcrud = new LibroJpaController();
         
      List<Autor> listaAutores = new ArrayList();
      List<Libro> Libros = new ArrayList();
       
      Scanner sc = new Scanner(System.in);
       /////// Crear
    public void crearAutor() {
        try {
            Autor autor1 = new Autor("Gabriel García Márquez", Boolean.TRUE, Libros);
            autorcrud.create(autor1);
            listaAutores.add(autor1);
            Autor autor2 = new Autor("William Golding", Boolean.TRUE, Libros);
            autorcrud.create(autor2);
            listaAutores.add(autor2);
            Autor autor3 = new Autor("Fiódor Dostoyevski ", Boolean.TRUE, Libros);
            autorcrud.create(autor3);
            listaAutores.add(autor3);
        } catch (Exception e) {
             System.out.println("ERROR");
        }
    }
    
    public void findListAutor(){
        listaAutores.clear();
        listaAutores = autorcrud.findAutorEnt();
    }
    
    public void borrarAutor(int id){
     try {
         System.out.println("Que id desea borrar");
         int idAutor = sc.nextInt();
         Autor aut = autorcrud.finID(idAutor);
         if(aut != null){
             aut.setAlta(Boolean.FALSE);
             listaAutores.remove(aut);
             autorcrud.delete(aut);
             Libros = aut.getListaLibro();
             for (Libro aux : Libros) {
                 aux.setAutor(null);
                 libcrud.update(aux);
             }
             System.out.println("El Autor fue borrado con exito");
         }
     } catch (Exception e) {
         System.out.println("No existe ese Autor");
     }
 }
    
    public void editarAutor(int id){
     try {
         System.out.println("Que Autor desea editar");
         int idAutor = sc.nextInt();
         Autor aut = autorcrud.finID(idAutor);
         if(aut != null){
             System.out.println("Cual es el nuevo nombre del Autor");
             String nomAutor = sc.next();
             aut.setNombre(nomAutor);
             autorcrud.update(aut);
             System.out.println("El Autor fue modificada con exito");
         }
     } catch (Exception e) {
         System.out.println("No existe ese Autor");
     }
 }
    
    public void buscarAutorNombre() {
        System.out.println("Ingrese el nombre del autor a buscar");
        String autorAbuscar = sc.next(); 
        List<Autor> autoresEncontrados = autorcrud.findNombreAutor(autorAbuscar);
        if (!autoresEncontrados.isEmpty()) {
            Autor autorEn = autoresEncontrados.get(0);
            System.out.println("Los datos del autor son: " + autorEn.toString());
        }else{
            System.out.println("No se encontro el autor");
        }
    }
    
    /*int isdnLibro = Integer.parseInt(sc.nextLine());*/
    
}
