public class Matriz {
  private int elementos[][];
  private int filas;
  private int columnas;

  public Matriz(int fil, int col, int valores[][]) {
    filas = fil;
    columnas = col;
    elementos = valores;
  }

  public boolean esIdentidad() {
    if (filas == columnas) {
      for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
          if (i == j && elementos[i][i] != 1) {
            return false;
          }
          if (i != j && elementos[i][j] != 0) {
            return false;
          }
        }
      }

      return true;
    }
    
    return false;
  }

  public boolean esSimetrica() {
    if (columnas == filas) {
      for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
          if (elementos[i][j] != elementos[j][i]) {
            return false;
          }
        }
      }

      return true;
    }
    return false;
  }

  public boolean esTriangularSuperior() {
    if (columnas == filas) {
      for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
          if (j < i && elementos[i][j] != 0) {
            return false;
          }
        }
      }

      return true;
    }

    return false;
  }

  public boolean puedeSumarseCon(Matriz b) {
    return filas == b.filas && columnas == b.columnas;
  }

  public Matriz sumar(Matriz b) {
    if (puedeSumarseCon(b)) {
      int resultados[][] = new int[filas][columnas];
      for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
          resultados[i][j] = elementos[i][j] + b.elementos[i][j];
        }
      }

      return new Matriz(filas, columnas, resultados);
    }

    return null;
  }

  public int getFilas() {
    return filas;
  }

  public int getColumnas() {
    return columnas;
  }
  
  public int[][] getElementos() {
    return elementos;
  }

  public String toString() {
    String resultado = "";

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        resultado += elementos[i][j];

        if(j + 1 < columnas)
          resultado += " ";
      }

      if(i + 1 < filas)
        resultado += "\n";
    }

    return resultado;
  }
}
