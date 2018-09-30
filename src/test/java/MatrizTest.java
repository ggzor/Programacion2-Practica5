import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MatrizTest {
  @Test
  public void esTriangularSuperior_deberiaRegresarTrue_cuandoEsTriangularSuperior() {
    int elementos[][] = {
      {1, 2, 3},
      {0, 1, 2},
      {0, 0, 1}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertTrue(matriz.esTriangularSuperior());
  }

  @Test
  public void esTriangularSuperior_deberiaRegresarFalse_cuandoNoEsTriangularSuperior() {
    int elementos[][] = {
      {1, 2, 3},
      {0, 1, 2},
      {0, 3, 1}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertFalse(matriz.esTriangularSuperior());
  }

  @Test
  public void esTriangularSuperior_deberiaRegresarFalse_cuandoNoEsCuadrada() {
    int elementos[][] = {
      {1, 2, 3},
      {0, 1, 2}
    };
    Matriz matriz = new Matriz(2, 3, elementos);

    assertFalse(matriz.esTriangularSuperior());
  }

  @Test 
  public void esSimetrica_deberiaRegresarTrue_cuandoEsSimetrica() {
    int elementos[][] = {
      {1, 2, 3},
      {2, 4, 5},
      {3, 5, 6}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertTrue(matriz.esSimetrica());
  }

  @Test 
  public void esSimetrica_deberiaRegresarFalse_cuandoNoEsSimetrica() {
    int elementos[][] = {
      {1, 2, 3},
      {4, 4, 5},
      {4, 5, 6}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertFalse(matriz.esSimetrica());
  }

  @Test 
  public void esSimetrica_deberiaRegresarFalse_cuandoNoEsCuadrada() {
    int elementos[][] = {
      {1, 2, 3, 7},
      {4, 4, 8, 5},
      {4, 5, 7, 6}
    };
    Matriz matriz = new Matriz(3, 4, elementos);

    assertFalse(matriz.esSimetrica());
  }

  @Test
  public void esIdentidad_deberiaRegresarTrue_cuandoEsIdentidad(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertTrue(matriz.esIdentidad());
  }

  @Test
  public void esIdentidad_deberiaRegresarFalse_cuandoNoEsIdentidad(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 2},
      {0, 0, 1}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertFalse(matriz.esIdentidad());
  }
  @Test
  public void esIdentidad_deberiaRegresarFalse_cuandoDiagonalPrincipalEsDiferenteDeUno(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 2}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    assertFalse(matriz.esIdentidad());
  }
  
  @Test
  public void esIdentidad_deberiaRegresarFalse_cuandoNoEsCuadrada(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
    };
    Matriz matriz = new Matriz(2, 3, elementos);

    assertFalse(matriz.esIdentidad());
  }

  @Test
  public void puedeSumarseCon_deberiaRegresarFalse_cuandoNoSonDelMismoTamano(){
    int elementos1[][] = {
      {1, 0, 0},
      {0, 1, 0},
    };

    int elementos2[][] = {
      {0, 0},
      {0, 0}      
    };
    Matriz matriz = new Matriz(2, 3, elementos1);
    Matriz matriz2 = new Matriz(2, 2, elementos2);

    assertFalse(matriz.puedeSumarseCon(matriz2));
  }
  
  @Test
  public void puedeSumarseCon_deberiaRegresarTrue_cuandoSonDelMismoTamano(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 2}
    };
    int elementos2[][] = {
      {2, 2, 2},
      {2, 2, 2},
      {2, 2, 2}
    };
    Matriz matriz = new Matriz(3, 3, elementos);
    Matriz matriz2 =new Matriz(3, 3, elementos2);

    assertTrue(matriz.puedeSumarseCon(matriz2));
  }    

  @Test
  public void sumar_deberiaRegresarSuma_cuandoSonDelMismoTamano(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
    };
    int elementos2[][] = {
      {2, 2, 2},
      {2, 2, 2},
      {2, 2, 2}
    };
    Matriz matriz = new Matriz(3, 3, elementos);
    Matriz matriz2 =new Matriz(3, 3, elementos2);
    
    Matriz resultado = matriz.sumar(matriz2);
    
    int esperado[][] = {
      {3, 2, 2},
      {2, 3, 2},
      {2, 2, 3}
    };
    assertArrayEquals(esperado, resultado.getElementos());
  }    

  @Test
  public void sumar_deberiaRegresarNull_cuandoNoSonDelMismoTamano(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0}
    };
    int elementos2[][] = {
      {2, 2, 2},
      {2, 2, 2},
      {2, 2, 2}
    };
    Matriz matriz = new Matriz(2, 3, elementos);
    Matriz matriz2 =new Matriz(3, 3, elementos2);
    
    Matriz resultado = matriz.sumar(matriz2);
    
    assertNull(resultado);
  }
  
  @Test
  public void getFilas_deberiaRegresarNumeroFilas_cuandoEsMatriz(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 2}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    int resultado = matriz.getFilas();

    assertEquals(3 , resultado);
  }
  
  @Test
  public void getColumnas_deberiaRegresarInt_cuandoEsMatriz(){
    int elementos[][] = {
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 2}
    };
    Matriz matriz = new Matriz(3, 3, elementos);

    int resultado = matriz.getColumnas();
    
    assertEquals(3, resultado);
  }
}