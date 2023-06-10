package com.mycompany.libreriaprueba2.Servicios;

import java.util.Scanner;


public class Servicio {
    
     Scanner sc = new Scanner(System.in).useDelimiter("\n");
    int opcion;
    int id;
    AutorServicio sAutor = new AutorServicio();
    EditorialServicio sEditorial = new EditorialServicio();
    LibroServicio sLibro = new LibroServicio();

    public void Menu() {
        do {
            System.out.println("============= MENÚ ====================");
            System.out.println(" Ingrese la consulta que desea ejecutar ");
            System.out.println("1. Crear un libro ");
            System.out.println("2. Crear una autor ");
            System.out.println("3. Crear un editorial ");
            System.out.println("4. Borrar un autor ");
            System.out.println("5. Borrar una editorial ");
            System.out.println("6. Borrar un libro ");
            System.out.println("7. Editar un autor ");
            System.out.println("8. Editar una editorial ");
            System.out.println("9. Editar un libro");
            System.out.println("10. Búsqueda de un Autor por nombre ");
            System.out.println("11. Búsqueda de un libro por ISBN ");
            System.out.println("12. Búsqueda de un libro por Título ");
            System.out.println("13. Búsqueda de un libro/s por nombre de Autor ");
            System.out.println("14. Búsqueda de un libro/s por nombre de Editorial ");
            System.out.println("15. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                     sLibro.crearLibro();
                    break;
                case 2:
                    sAutor.crearAutor();
                    break;
                case 3:
                           sEditorial.crearEditorial();            
                    break;
               case 4:
                    sAutor.borrarAutor(id);
                    break;
                case 5:
                    sEditorial.borrarEditorial(id);
                    break;
                case 6:
                    sLibro.borrarLibro(id);
                    break;
                case 7:
                    sAutor.editarAutor(id);
                    break;
                case 8:
                    sEditorial.editarEditorial(id);
                    break;
                case 9:
                    sLibro.editarLibro(id);
                    break;
               case 10:
                    sAutor.buscarAutorNombre();
                    break;
              case 11:
                    sLibro.libroIsbn();
                    break;
                case 12:
                    sLibro.libroTitulo();
                    break;
                case 13:
                    sLibro.libroAutor();
                    break;
                case 14:
                    sLibro.libroEditorial();
                    break;    
                case 15:
                    System.out.println("Ha salido con éxito");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 15);
    }

}
