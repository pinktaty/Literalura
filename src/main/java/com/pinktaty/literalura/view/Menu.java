package com.pinktaty.literalura.view;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class Menu {

    private void printMenu() {
        var menu = """ 
                    
                    1 - Buscar libro por título.
                    2 - Listar libros registrados.
                    3 - Listar autores registrados.
                    4 - Listar autores vivos en un mismo año.
                    5 - Listar libros por idioma.
              
                    0 - Salir.
                    """;
        System.out.println(menu);
    }

    public int runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            printMenu();
            try {
                choice = scanner.nextInt();

                if (choice >= 0 && choice < 6) {
                    break;
                } else {
                    System.out.println("\nPor favor, ingresa un número entre 0 y 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPor favor, ingresa un número entero válido.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public String searchBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        return scanner.nextLine().toLowerCase();
    }

    public int getYearOfAliveness(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el año que desea consultar:");
        return scanner.nextInt();
    }

    public String getLanguageOfInterest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el lenguaje que quisiera consultar en código de idioma/lenguaje:");
        return scanner.nextLine().toLowerCase();
    }

    public void printBookNotFound(){
        System.out.println("\nEl libro buscado no existe.\n");
    }

    public void printNullRegisteredBooks(){
        System.out.println("\nNo hay libros registrados en la base de datos, buscar uno para registrar.\n");
    }

    public void printNullRegisteredAuthors(){
        System.out.println("\nNo hay autores registrados en la base de datos, buscar un libro para registrar su autor.\n");
    }

    public void printNullAliveAuthors(){
        System.out.println("\nNo hay autores registrados en la base de datos vivos en el año de consulta.\n");
    }

    public void printNullBooksLanguage(){
        System.out.println("\nNo hay libros registrados en la base de datos con el lenguaje buscado.\n");
    }
}
