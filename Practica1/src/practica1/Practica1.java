package practica1;
import java.util.Scanner;
import java.util.Random;
public class Practica1 {
    static int [][] matriz =null;
    static Scanner tecla = new Scanner(System.in);
    static int xd, yd;
    static String nombre;
    static String movimiento; 
    static int cantidad;
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                //Menu Juego
                System.out.println("PACMAN - IPC 1 - 2022");
                System.out.println("----------------------");
                System.out.println("1.       INICIAR JUEGO");
                System.out.println("2     TABLA POSICIONES");
                System.out.println("3.               SALIR");
                System.out.println("----------------------");
                System.out.println("INGRESE UNA OPCION...");
                opcion = tecla.nextInt();
                switch (opcion) {
                    case 1: //Iniciar Juego
                        System.out.println("*****************************");
                        System.out.println("*       INICIAR JUEGO       *");
                        System.out.println("*****************************");
                    InicioJuego();
                        break;
                    case 2: // Tabla de Posiciones
                        System.out.println("******************************");
                        System.out.println("*     TABLA DE POSICIONES    *");
                        System.out.println("******************************");
                    TablaPosiciones();    
                        
                        break;
                    case 3: //Salir de Menú
                        System.out.println("*****************************");
                        System.out.println("* Adios, tenga un lindo día *");
                        System.out.println("*****************************");
                        break;
                        
             
                    default:
                        System.out.println("No ingrese valores no validos \n");
                }
            } catch (Exception e) {
                System.out.println("Solo ingrese valores númericos \n");
                tecla.nextLine();
            }
        } while (opcion != 3);
    PantallaPausa();
    }
    
    public static void InicioJuego() {   Scanner tecla = new Scanner(System.in);//se llama al juego
        //String nombre;
        String tamano;
        int personaje;
        
        System.out.print(" POR FAVOR INGRESE SU NOMBRE:");
        nombre=tecla.nextLine();      
        System.out.println("POR FAVOR INGRESE EL TAMAÑO DE SU TABLERO[X,Y]:                  ");
        tamano=tecla.next();
        
        String[] Tamano = tamano.split(",");
         xd = Integer.parseInt(Tamano[0]);
         yd = Integer.parseInt(Tamano[1]);
        
        int comida = SolicitarComida("Ingresa un número entre 0 y 28: ", 0, 28);
        int paredes = SolicitarParedes("Ingresa un número entre 0 y 13: ", 0, 13);
        int trampas= SolicitarTrampas("Ingresa un número entre 0 y 10: ", 0, 10);

        
        System.out.println("✯DE LAS SIGUIENTES OPCIONES ELIJA UN PERSONAJE:");
        System.out.println("✯{1-☺}{2-☻}{3-♥}{4-♣}{5-♠}{6-♂}{7-♀}{8-☼}{9-♫}{10-♪}");
        personaje=tecla.nextInt();
        
        System.out.println("✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵");
        System.out.println(" ___   _   ____  _      _      ____  _      _   ___   ___  \n" +
"| |_) | | | |_  | |\\ | \\ \\  / | |_  | |\\ | | | | | \\ / / \\ \n" +
"|_|_) |_| |_|__ |_| \\|  \\_\\/  |_|__ |_| \\| |_| |_|_/ \\_\\_/");                                     
   
  System.out.println("                                        \n" +
" .-----.---.-.----.--------.---.-.-----.\n" +
" |  _  |  _  |  __|        |  _  |     |\n" +
" |   __|___._|____|__|__|__|___._|__|__|\n" +
" |__|"); 

        System.out.println("✵INGRESE SU NOMBRE:"+nombre);
        System.out.println("✵INGRESE EL TAMAÑO DE SU TABLERO:"+xd+","+yd);
        System.out.println("✵INGRESE EL TAMAÑO DE CANTIDAD DE COMIDA: [0-28]:  " + comida);
        System.out.println("✵INGRESE EL TAMAÑO DE CANTIDAD DE PAREDES: [0-13]:  " + paredes);
        System.out.println("✵INGRESE CANTIDAD DE TRAMPAS: [0-10]:              "+ trampas);
int resultado = (comida+paredes+trampas);
cantidad= resultado;
        System.out.println(+cantidad);
        System.out.println("----------------------------------------");
        System.out.println("JUGADOR:  "+nombre);
        System.out.println("----------------------------------------");
    
        matriz=mat(matriz); 
        //LLenarmatriz();
        switch(personaje){
            case 1:// personaje 1
                System.out.println("☺");// Agregué aca el v,w porque la matriz me da error
                break;
            case 2:// personaje 2
                System.out.println("☻");
                break;
            case 3:// personaje 3
                System.out.println("♥");
                break;        
            case 4:// personaje 4
                System.out.println("♣");
                break;
            case 5:// personaje 5
                System.out.println("♠");
                break;
            case 6:// personaje 6
                System.out.println("♂");
                break;
            case 7:// personaje 7
                System.out.println("♂");
                break;
            case 8:// personaje 8
                System.out.println("☼");
                break;
            case 9:// personaje 9
                System.out.println("♫");
                break;
            case 10:// personaje 10
                System.out.println("♪");
                break;               
        }
        PosicionInicial();
         System.out.println("✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯✯");
         System.out.println("TABLERO");//Aquí va el tablero 
        System.out.print("✯JUGADOR:"+nombre+"       PUNTEO;"+"          VIDAS");
    }
   
   public static int SolicitarComida(String mensaje, int minimo, int maximo) {//Rango comida [0-28]


        
        int comida;
          
        while (true) {
            System.out.println(mensaje);
            if (tecla.hasNextInt()) {
                comida = tecla.nextInt();
                if (comida >= minimo && comida <= maximo) {
                    return comida;
                } else {
                    System.out.println("Número fuera del rango, por favor intente de nuevo");
                }
            } else {
                tecla.next();
            }
        }
    }
    
    
    public static int SolicitarParedes(String mensaje, int minimo, int maximo) {//Rango paredes [0-13]

       
        int paredes;
    while (true) {
            System.out.println(mensaje);
            if (tecla.hasNextInt()) {
                paredes = tecla.nextInt();
                if (paredes >= minimo && paredes <= maximo) {
                    return paredes;
                } else {
                    System.out.println("Número fuera del rango, por favor intente de nuevo");
                }
            } else {
                tecla.next();
            }
        }
    }
    
    public static int SolicitarTrampas(String mensaje, int minimo, int maximo) {//Rango trampas [0-10]

       
        int trampas;
    while (true) {
            System.out.println(mensaje);
            if (tecla.hasNextInt()) {
                trampas = tecla.nextInt();
                if (trampas >= minimo && trampas <= maximo) {
                    return trampas;
                } else {
                    System.out.println("Número fuera del rango, por favor intente de nuevo");
                }
            } else {
                tecla.next();
            }
        }
    }
 
    public static int[][] mat(int[][]m) {

        m = new int [xd][yd];
      
    //Parte superior del tablero
            for(int i = 0; i < (m.length)+2; i++) {
              System.out.print("_");
            }
            System.out.println();
           
            //Centro del tablero
           for(int i = 0; i < (m.length); i++) {
               System.out.print("|");
               for(int j = 0; j < (m[i].length); j++) {
                    System.out.print(" ");//relleno de figuras
                    
               }
               
               System.out.println("|");
             //  System.out.println("         ");
            }
          
            //Parte inferior del tablero
           for(int i = 0; i < (m.length)+2; i++) {
                System.out.print("¯");
                
               //
          
            }
        System.out.println("        ");       
    return m;
        
    }// cierra metodo definirTamano 
public static void TablaPosiciones() {
System.out.println("---------------------");    
System.out.println("1."+nombre);    
System.out.println("2."+nombre); 
System.out.println("3."+nombre); 
System.out.println("4."+nombre); 
System.out.println("5."+nombre); 
System.out.println("6."+nombre); 
System.out.println("7."+nombre); 
System.out.println("8."+nombre); 
System.out.println("9."+nombre); 
System.out.println("10."+nombre); 
System.out.println("---------------------");   
}  
public static void PosicionInicial() {//para llamar posición incial
System.out.println("-----------------------------------");
System.out.println("INTRODUZCA SU POSICIÓN INICIAL: ");
System.out.println("-----------------------------------");
        movimiento=tecla.next();
       String[] Movimiento = movimiento.split(",");
        int v = Integer.parseInt(Movimiento[0]);
        int w = Integer.parseInt(Movimiento[1]);
        System.out.println("La Posición inicial elegida es:"+v+","+w);    
}
public static void PantallaPausa() {//Para llamar pantalla de pausa
System.out.println("     JUEGO PAUSADO     "); 
System.out.println("-----------------------"); 
System.out.println("1. CONTINUAR PARTIDA "); 
System.out.println("2.  TABLA POSICIONES "); 
System.out.println("3.     SALIR PARTIDA"); 
System.out.println("-----------------------"); 
}
public static void LLenarmatriz() {//Para llenar la matriz
 
    int filas = xd;
    int columnas = yd;   
    System.out.println(xd+","+yd);
     String[][] matriz= new String[filas][columnas] ;
   
  for(int a = 0; a < matriz.length; a++) for(int b = 0; b < matriz[0].length; b++)matriz [a][b]="";
   int aux = 0; 
          
   Random posx = new Random ();
   Random posy = new Random ();
   Random alimento = new Random();
    while(aux < cantidad){
        int auxX = posx.nextInt(filas);
        int auxY = posy.nextInt(columnas);
      //  System.out.println(auxX + "-" + auxY);
        if (matriz[auxX][auxY] == ""){
            switch (alimento.nextInt(4)){
            case 0:
                matriz[auxX][auxY] = "@";
                break;
            case 1:
                matriz[auxX][auxY] = "?";
                break;  
            case 2:
                matriz[auxX][auxY] = "#";
                break;
            case 3:
                matriz[auxX][auxY] = "X";
                break;    
        }
        aux++;
    }
 }
   for (int a = 0; a < matriz.length; a++){
    for(int b = 0; b < matriz[0].length; b++){
   if (matriz[a][b] == ""){
        System.out.print("  ");
   }else{ 
        System.out.print(" " + matriz[a][b] + " ");
   }
   }
   System.out.println();
   
   } 
}//fin llenar matriz
}

    


