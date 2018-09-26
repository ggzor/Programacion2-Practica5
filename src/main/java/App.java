import java.io.FileInputStream;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Scanner entrada2 = new Scanner(System.in);
    LectorMatrices lectorMatrices = new LectorMatrices();
    Matriz A = null, B = null, AMasB = null;

    do {
      System.out.print(
        "¿Cómo desea leer la matriz A?\n" + 
        "  1. Desde consola.\n" + 
        "  2. Desde archivo.\n" + 
        "Opción: ");
      switch (entrada.nextInt()) {
        case 1:
          System.out.println("Introduzca la matriz: ");
          A = lectorMatrices.leer(System.in);
          System.out.println("Matriz leída.");                  
          break;
        case 2:
          System.out.print("Introduzca el nombre del archivo: ");
          String nombre = entrada.next();     
          FileInputStream archivo = new FileInputStream(nombre);
          B = lectorMatrices.leer(archivo);     
          break;

        default:
          System.out.println("Opción inválida.");
          break;
      }
    } while (A == null);
    
    do {
      System.out.print(
        "¿Qué matriz desea guardar?\n" +
        "  1.Matriz A.\n" + 
        "  2.Matriz B.\n" + 
        "  3.Matriz A+B\n" +
        "Opción: ");
      switch (entrada2.nextInt()) {
        case 1:

          break;
        case 2:

          break;
        case 3:

          break;                          

        default:
          System.out.println("Opción inválida.");
          break;
      }
    System.out.println();
    } while(!salir);
  }
}
