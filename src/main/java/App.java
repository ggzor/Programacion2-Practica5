public class App {
  public static void main(String[] args) {
    Matriz A, B, AMasB = null;
    Interfaz interfaz = new Interfaz();

    A = interfaz.leerMatriz("A");
    B = interfaz.leerMatriz("B");
    
    System.out.println("Matriz A:");
    interfaz.mostrarInformacionMatriz(A);

    System.out.println("Matriz B:");
    interfaz.mostrarInformacionMatriz(B);

    if(A.puedeSumarseCon(B)) {
      AMasB = A.sumar(B);
      System.out.println("La suma de las matrices es: ");
      interfaz.mostrarInformacionMatriz(AMasB);
    } else {
      System.out.println("Las matrices no se pueden sumar.");
    }

    interfaz.intentarGuardarMatriz(A, "A");
    interfaz.intentarGuardarMatriz(B, "B");
    interfaz.intentarGuardarMatriz(AMasB, "A + B");
  }
}
