package practica1;
import java.util.Scanner;
public class Practica1 {
    public static void main(String[] args) {
            Scanner leer = new Scanner(System.in);
            int opcion=0;
            do{
            try{
             //Menu Juego
        System.out.println("PACMAN - IPC 1 - 2022");
        System.out.println("----------------------");
        System.out.println("1.       INICIAR JUEGO");
        System.out.println("2     TABLA POSICIONES");
        System.out.println("3.               SALIR");
        System.out.println("----------------------");
        System.out.println("INGRESE UNA OPCION...");
        opcion = leer.nextInt();
        switch(opcion){
            case 1: //Iniciar Juego
                System.out.println("*****************************");
                System.out.println("       INICIAR JUEGO         ");
                System.out.println("*****************************");
                break;
            case 2: // Tabla de Posiciones
                System.out.println("******************************");
                System.out.println("*     TABLA DE POSICIONES    *");
                System.out.println("*****************************");
                break;
            case 3: //Salir de Menú
                System.out.println("*****************************");
                System.out.println("Adios, tenga un lindo día");
                System.out.println("*****************************");
                break;
            default:
                System.out.println("No ingrese valores no validos \n");
        }
        }
        catch(Exception e){
            System.out.println("Solo ingrese valores númericos \n");
            leer.nextLine();
        }
     }while(opcion !=3);      
    }
            }

                
