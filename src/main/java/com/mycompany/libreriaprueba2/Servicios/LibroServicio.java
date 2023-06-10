package com.mycompany.libreriaprueba2.Servicios;

import com.mycompany.libreriaprueba2.Entidades.Autor;
import com.mycompany.libreriaprueba2.Entidades.Editorial;
import com.mycompany.libreriaprueba2.Entidades.Libro;
import com.mycompany.libreriaprueba2.Persistencia.LibroJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibroServicio {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
     private LibroJpaController libcrud = new LibroJpaController();
    private AutorServicio autorServ = new AutorServicio();
    private EditorialServicio editorialServ = new EditorialServicio();
    List<Editorial> Editoriales = new ArrayList();
    List<Libro> listaLibros = new ArrayList();
    List<Autor> Autores = new ArrayList();
    
    /////// Crear
    public void crearLibro() {
        try {
            autorServ.findListAutor();
            Autores = autorServ.listaAutores;
            editorialServ.findListEditorial();
            Editoriales = editorialServ.listaEditoriales;
            
            Libro libro1 = new Libro("Cien Años de Soledad", 1987, 200, 190, 10, Boolean.TRUE, Autores.get(0), Editoriales.get(0));
            libcrud.create(libro1);
            listaLibros.add(libro1);
            Libro libro2 = new Libro("El señor de Las Moscas", 1956, 150, 100, 50, Boolean.TRUE, Autores.get(1), Editoriales.get(1));
            libcrud.create(libro2);
            listaLibros.add(libro2);
            Libro libro3 = new Libro("Crímen y Castigo", 1967, 100, 70, 30, Boolean.TRUE, Autores.get(2), Editoriales.get(2));
            libcrud.create(libro3);
            listaLibros.add(libro3);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    
     public void findListLibro(){
        listaLibros.clear();
        listaLibros = libcrud.findLibroEnt();
    }
    
    public void borrarLibro(int isbn){
     try {
         System.out.println("Que isbn desea borrar");
         int idLibro = sc.nextInt();
         Libro lib = libcrud.find(isbn);
         if(lib != null){
             lib.setAlta(Boolean.FALSE);
             listaLibros.remove(lib);
             libcrud.delete(lib);
             System.out.println("La editorial fue borrada con exito");
         }
     } catch (Exception e) {
         System.out.println("No existe esa editorial");
     }
 }
    
  public void editarLibro(int isbn){
     try {
         System.out.println("Que Libro desea editar");
         int idLibro = sc.nextInt();
         Libro lib = libcrud.find(isbn);
         if(lib != null){
             System.out.println("Cual es el nuevo nombre del Libro");
             String nomLibro = sc.next();
             lib.setTitulo(nomLibro);
             libcrud.update(lib);
             System.out.println("Ingrese el nuevo año de edicion");
             lib.setAnio(sc.nextInt());
              System.out.println("Ingrese la cantidad de ejemplares creados");
             lib.setEjemplares(sc.nextInt());
              System.out.println("Ingrese los ejemplares prestados");
             lib.setEjemplaresPrestados(sc.nextInt());
              System.out.println("Ingrese los ejemplares restantes");
             lib.setEjemplaresRestantes(sc.nextInt());
             
             libcrud.update(lib);
         } else {
                System.out.println("El libro con el ISBN " + isbn + " no existe.");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar la editorial.");
        }
 }
  public void libroIsbn() {
        System.out.println("Ingrese el isbn del libro que desea consultar");
        Integer isbn = sc.nextInt();
        List<Libro> librosEncontrados = libcrud.libroIsbn(isbn);
        if (!librosEncontrados.isEmpty()) {
            Libro libroEncontrado = librosEncontrados.get(0);
            System.out.println("El libro solicitado tiene los siguientes datos:");
            System.out.println(libroEncontrado.toString());
        } else {
            System.out.println("No se ha encontrado el libro en la tabla");
        }
    }
  
  public void libroTitulo() {
        System.out.println("Ingrese el título del libro que desea consultar");
        String titulo = sc.nextLine();
        List<Libro> librosEncontrados = libcrud.libroTitulo(titulo);
        if (!librosEncontrados.isEmpty()) {
            Libro libroEncontrado = librosEncontrados.get(0);
            System.out.println("El libro solicitado tiene los siguientes datos:");
            System.out.println(libroEncontrado.toString());
        } else {
            System.out.println("No se ha encontrado el libro en la tabla");
        }
    }
  
  public void libroAutor() {
        System.out.println("Indique el nombre del autor y desplegaremos los libros que tiene asociados");
        String nombre = sc.nextLine();
        List<Libro> librosEncontrados = libcrud.libroAutor(nombre);
        if (!librosEncontrados.isEmpty()) {
            Libro libroEncontrado = librosEncontrados.get(0);
            System.out.println("El autor tiene los siguientes libros asociados");
            System.out.println(libroEncontrado.toString());
        } else {
            System.out.println("No se ha encontrado ese autor en la tabla");
        }
    }
  
  public void libroEditorial() {
        System.out.println("Indique el nombre de la editorial y desplegaremos los libros que tiene asociados");
        String nombre = sc.nextLine();
        List<Libro> librosEncontrados = libcrud.libroEditorial(nombre);
        if (!librosEncontrados.isEmpty()) {
            Libro libroEncontrado = librosEncontrados.get(0);
            System.out.println("La editorial tiene los siguientes libros asociados");
            System.out.println(libroEncontrado.toString());
        } else {
            System.out.println("No se ha encontrado esa editorial en la tabla");
        }
    }
 }


