import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class App {
  public static void main(String[] args) {
    Matriz A = null, B = null, AMasB = null;

    A = leerMatriz("A");
    B = leerMatriz("B");
    
    System.out.println("Matriz A:");
    mostrarInformacionMatriz(A);

    System.out.println("Matriz B:");
    mostrarInformacionMatriz(B);

    if(A.puedeSumarseCon(B)) {
      AMasB = A.sumar(B);
      System.out.println("La suma de las matrices es: ");
      mostrarInformacionMatriz(AMasB);
    } else {
      System.out.println("Las matrices no se pueden sumar.");
    }

    intentarGuardarMatriz(A, "A");
    intentarGuardarMatriz(B, "B");
    intentarGuardarMatriz(AMasB, "A + B");
  }

  private static Matriz leerMatriz(String nombre) {
    Matriz M = null;
    MatricesIO matricesIO = new MatricesIO();
    Scanner entrada = new Scanner(System.in);

    boolean matrizLeida = false;
    do {
      System.out.print(
        "¿Cómo desea leer la matriz " + nombre + "?\n" + 
        "  1. Desde consola.\n" + 
        "  2. Desde archivo.\n" +
        "Opción: ");

      switch (entrada.nextInt()) {
        case 1:
          System.out.print("Introduzca la cantidad de filas, la cantidad de columnas y después la matriz: ");
          M = matricesIO.leerMatriz(System.in);
          matrizLeida = true;
          break;
        case 2:
          // Quitar salto de línea anterior
          entrada.nextLine();

          System.out.print("Introduzca el nombre del archivo: ");
          String nombreArchivo = entrada.nextLine();

          try {
            FileInputStream archivo = new FileInputStream(nombreArchivo);
            M = matricesIO.leerMatriz(archivo);
            matrizLeida = true;
          } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo especificado.");
          }
          break;
        default:
          System.out.println("Opción inválida.");
          break;
      }
      if (matrizLeida)
        System.out.println(
            "Matriz leída correctamente. (" + M.getFilas() + " x " + M.getColumnas() + ")");
    } while (!matrizLeida);

    return M;
  }

  private static void mostrarInformacionMatriz(Matriz M) {
    M.mostrar();
    System.out.print("Propiedades: ");

    if (M.esIdentidad())
      System.out.print("Identidad ");
    if (M.esSimetrica())
      System.out.print("Simétrica ");
    if (M.esTriangularSuperior())
      System.out.print("Triangular superior");

    boolean tieneAlgunaPropiedad = M.esIdentidad() || M.esSimetrica() || M.esTriangularSuperior();
    if (!tieneAlgunaPropiedad)
      System.out.print("Ninguna");

    System.out.println();
  }

  
  private static void intentarGuardarMatriz(Matriz M, String nombre) {
    Scanner entrada = new Scanner(System.in);

    if (M != null) {
      boolean opcionValida;
      do {
        opcionValida = true;
        System.out.print(
          "¿Desea guardar la matriz " + nombre + "?: \n" + 
          "  1. Sí\n" +
          "  2. No\n" +
          "Opción: ");

        switch (entrada.nextInt()) {
          case 1:
            // Quitar salto de línea anterior
            entrada.nextLine();

            System.out.print("Introduzca el nombre del archivo: ");
            String nombreArchivo = entrada.nextLine();

            try {
              FileOutputStream archivo = new FileOutputStream(nombreArchivo);
              MatricesIO matricesIO = new MatricesIO();
              
            } catch (Exception e) {
              //TODO: handle exception
            }
            break;
          case 2:
            break;
          default:
            System.out.println("Opción inválida.");
            opcionValida = false;
            break;
        }
      } while (!opcionValida);
    }

    entrada.close();
  }
}
