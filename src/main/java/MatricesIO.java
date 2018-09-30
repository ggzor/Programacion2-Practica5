import java.io.InputStream;
import java.util.Scanner;

public class MatricesIO {
  public Matriz leerMatriz(InputStream flujo) {
    Scanner s = new Scanner(flujo);

    int filas = s.nextInt();
    int columnas = s.nextInt();
    int elementos[][] = new int[filas][columnas];

    for (int i = 0; i < filas; i++)
      for (int j = 0; j < columnas; j++)
        s.nextInt();
        
    return new Matriz(filas, columnas, elementos);
  }
}
