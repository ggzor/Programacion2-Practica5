import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Interfaz {
  private Scanner entrada;
  private MatricesIO matricesIO;

  public Interfaz() {
    entrada = new Scanner(System.in);
    matricesIO = new MatricesIO();
  }

  public Matriz leerMatriz(String nombre) {
    Matriz M = null;

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

  public void mostrarInformacionMatriz(Matriz M) {
    System.out.println(M);
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

  
  public void intentarGuardarMatriz(Matriz M, String nombre) {
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
              matricesIO.guardarMatriz(archivo, M);
            } catch (Exception e) {
              System.err.println("No se pudo guardar el archivo. Intente otra vez.");
              opcionValida = false;
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
  }  
}