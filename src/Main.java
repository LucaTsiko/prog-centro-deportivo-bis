import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


    }

    /**
     * Pide al usuario la cantidad maxima de entrenadores
     * @param cantidadMaximaEntrenadores es la cantidad de los entrenadores
     * @return la cantidad de entrenadores proporcionada por el usuario
     */
    public static int pedirCantidadDeEntrenadores (int cantidadMaximaEntrenadores) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa una cantidad positiva de entrenadores:");
        cantidadMaximaEntrenadores = sc.nextInt();

        return cantidadMaximaEntrenadores;
    }
}