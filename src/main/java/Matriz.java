public class Matriz {
  private int elementos[][];
  private int filas;
  private int columnas;

  public Matriz(int valores[][]) {
    filas = valores.length;
    columnas = valores[0].length;
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
      for (int i = 0; i < filas - 1; i++) {
        for (int j = i + 1; j < columnas; j++) {
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
      for (int i = 1; i < filas; i++) {
        for (int j = 0; j < i; j++) {
          if (elementos[i][j] != 0) {
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

      return new Matriz(resultados);
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
