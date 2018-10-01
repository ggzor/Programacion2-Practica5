import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MatricesIO {
  public Matriz leerMatriz(InputStream flujo) {
    Scanner entrada = new Scanner(flujo);

    int filas = entrada.nextInt();
    entrada.next(); // Leer el 'x'
    int columnas = entrada.nextInt();
    int elementos[][] = new int[filas][columnas];

    for (int i = 0; i < filas; i++)
      for (int j = 0; j < columnas; j++)
        elementos[i][j] = entrada.nextInt();

    return new Matriz(filas, columnas, elementos);
  }

  public void guardarMatriz(OutputStream archivo, Matriz m) {
    PrintStream salida = new PrintStream(archivo);
    salida.println(m.getFilas() + " x " + m.getColumnas());
    salida.println();

    for (int i = 0; i < m.getFilas(); i++) {
      for (int j = 0; j < m.getColumnas(); j++) {
        salida.print(m.getElementos()[i][j]);

        if (j + 1 < m.getColumnas())
          salida.print(" ");
      }

      if (i + 1 < m.getFilas())
        salida.println();
    }
  }
}
