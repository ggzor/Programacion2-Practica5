public class Matriz {
  private int elementos[][];
  private int filas;
  private int columnas;

  public Matriz(int valores[][]) {
    elementos = valores;
  }

  public boolean esIdentidad() {
    
    for (int i = 0; i < columnas; i++) {
      for (int j = 0; j < filas; j++) {
        if(i==j){
          if(elementos[i][j] == 1){
          }
        }else{
          if(elementos[i][j]== 0)
        }
        
      }
    }
    return false;
  }

  public boolean esSimetrica() {
    // TODO: Implementar
    return false;
  }

  public boolean esTriangularSuperior() {
    // Gracias por programar conmigo. <3 
    // No me tienes por que agredecer, es un placer estar contigo y también programar juntos.
    // Gracias, aún así. 
    return false;
  }

  public boolean sumar(Matriz b) {
    if (filas == b.filas && columnas == b.columnas){
      for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
          elementos[i][j] += b.elementos[i][j];
        }
      }
      return true;
    }
      return false;
  }
}
