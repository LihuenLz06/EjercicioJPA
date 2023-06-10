
package com.mycompany.libreriaprueba2;

import com.mycompany.libreriaprueba2.Persistencia.AutorJpaController;
import com.mycompany.libreriaprueba2.Servicios.AutorServicio;
import com.mycompany.libreriaprueba2.Servicios.EditorialServicio;
import com.mycompany.libreriaprueba2.Servicios.LibroServicio;
import com.mycompany.libreriaprueba2.Servicios.Servicio;


public class LibreriaPrueba2 {

    public static void main(String[] args) {
        
        Servicio serv = new Servicio();
        AutorJpaController autorcrud = new AutorJpaController();
        
        autorcrud.findNombreAutor("Gabriel García Márquez");
        //serv.Menu();
        
        
        
        
      /*AutorServicio servAutor1 = new AutorServicio();
        LibroServicio servLibro1 = new LibroServicio();
        EditorialServicio servEditorial1 = new EditorialServicio();

        servAutor1.crearAutor();
       servEditorial1.crearEditorial();
       servLibro1.crearLibro();*/
       
       
    }
}
