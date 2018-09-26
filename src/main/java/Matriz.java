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
        if( i == j && elementos[i][j]!= 1){
          return false;
        }
        if(i!=j && elementos[i][i] != 0){
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean esSimetrica() {
    if (columnas == filas) {
      for (int i = 0; i < columnas; i++) {
        for (int j = 0; j <filas; j++) {
          if(elementos[j][i] != elementos[i][j]){
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }

  public boolean esTriangularSuperior() {
   for (int i = 0; i < columnas; i++) {
     for(int j = 0; j < filas; j++)
  }
    /* 
      Gracias Solecita. :)
     ¿oye quieres despertar temprano o más tarde?
     Creo que sera mejor temprano. Para
      que me levante a acabar.

      ¿Ya también dormirás?
sipí. zzzz
Bueño. :P :3 anda mi niño, apúrate!!!
Está bien, mi paquetito. 
Tú también ya duermete
adiós mi niño. <3
Adiós mi paquetito, <3, dulces sueños.
Igualmente, dulces sueños.
      ¿Cómo desea leer la matriz?
         1. Desde archivo
         2. Desde consola    
       La matriz A es ... 
       La matriz B es ...
       La matriz A + B es ....

       ¿Desea guardar la matriz A?
       ¿Desea guardar la matriz B?
       
       ¿e a m ? <3
       Y ya ahí termina el programa.
       ¿Cómo ves?perfecto. :D vale.
       ¿Me puedes ayudar?shi
       Vale :D
    */


    return false;
  }

  public boolean sumar(Matriz b) {
    if (filas == b.filas && columnas == b.columnas) {
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
