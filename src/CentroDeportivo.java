import java.lang.foreign.ValueLayout;
import java.util.Scanner;

/**
 * Representa un centro deportivo que gestiona un conjunto limitado de entrenadores
 * mediante un array unidimensional de tamaño fijo.
 *
 * El sistema permite:
 * <ul>
 *     <li>Registrar entrenadores evitando duplicados por identificador.</li>
 *     <li>Buscar entrenadores por su {@code id}.</li>
 *     <li>Eliminar entrenadores del sistema.</li>
 *     <li>Actualizar información relacionada con los entrenadores.</li>
 *     <li>Obtener una representación textual del conjunto almacenado.</li>
 * </ul>
 *
 * La estructura interna utiliza un array estático donde las posiciones libres
 * se representan mediante valores {@code null}. La gestión del espacio disponible
 * se realiza mediante métodos internos que localizan la primera posición libre.
 *
 * Esta clase actúa como contenedor y gestiona la lógica de almacenamiento
 * y acceso a los objetos {@link Entrenador}.
 *
 * @author Luis García Sánchez
 * @version 1.0
 */
public class CentroDeportivo {
    private Entrenador[] entrenadores;
    private final int NUM_MAX_ENTRENADORES;

    /**
     * Construye un CentroDeportivo con una capacidad máxima determinada.
     *
     * @param cantidadMaximaEntrenadores número máximo de entrenadores que puede almacenar el Centro Deportivo.
     */
    public CentroDeportivo(int cantidadMaximaEntrenadores) {

        NUM_MAX_ENTRENADORES = validarCantidadDeEntrenadores(cantidadMaximaEntrenadores);
        entrenadores = new Entrenador[NUM_MAX_ENTRENADORES];

    }


    /**
     * Valida que la cantidad de entrenadores sea un número positivo.
     * @param cantidadMaximaEntrenadores la cantidad Maxima de entrenadores.
     * @return cantidadDeEntrenadores proporcionada por el usuario si es positivo, si no devuelve 15 por defecto.
     */
    public int validarCantidadDeEntrenadores (int cantidadMaximaEntrenadores) {
        cantidadMaximaEntrenadores = Main.pedirCantidadDeEntrenadores(cantidadMaximaEntrenadores);
        int resultado = 15;

        if (cantidadMaximaEntrenadores >= 0) {
            resultado = cantidadMaximaEntrenadores;
        }

        return resultado;
    }

    /**
     *  Metodo para buscar un entrenador por su id.
     * @param id Del Entrenador
     * @return  El entrenador entero si lo encientra, si no nulo.
     */
    public Entrenador buscarEntrenador(int id){
        boolean seguirBuscando = true;
        Entrenador entrenador = null;

        for(int i = 0; i < NUM_MAX_ENTRENADORES && seguirBuscando; i++){
            if(entrenadores[i] != null && entrenadores[i].getId() == id){
                entrenador =  entrenadores[i];
                seguirBuscando = false;
            }
        }
        return entrenador;
    }

    /**
     * Metodo que busca la primera posición libre en el array de los entrenadores.
     * @return la primera posición libre del array entrenadores y si no hay -1.
     */
    private int buscarPrimerHuecoLibre(){
        int posicion = -1;
        boolean seguirBuscando = true;

        for (int i = 0; i < NUM_MAX_ENTRENADORES && seguirBuscando; i++) {
            if(entrenadores[i] == null) {
                posicion = i;
                seguirBuscando = false;
            }
        }
        return posicion;
    }

    /**
     * Metodo que registra a un entrenador en el primer hueco libre (si hay) antes asegurandose de que no esta ya añadido.
     * @param entrenador El entrenador que queremos registrar.
     * @return true si el entrenador ha sido añadido, false si no.
     */
    public boolean registrarEntrenador(Entrenador entrenador){
        boolean entrenadorRegistrado = false;
        int posicion;

        posicion = buscarPrimerHuecoLibre();

        if(buscarEntrenador(entrenador.getId()) == null){
            if(posicion >= 0){
                entrenadores[posicion] = entrenador;
                entrenadorRegistrado = true;
            }
        }
        return entrenadorRegistrado;
    }

    /**
     * Devuelve una representación textual del catálogo completo.
     *
     * @return una cadena de texto con todos los libros almacenados.
     */
    public String mostrarEntrenadores(){
        StringBuilder sb = new StringBuilder("Entrenadores: {");

        for (int i = 0; i < NUM_MAX_ENTRENADORES; i++) {
            if(entrenadores[i] != null){
                sb.append(entrenadores[i].toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public int contarEntrenadores(){
        int contador = 0;
        for (int i = 0; i < NUM_MAX_ENTRENADORES; i++) {
            if(entrenadores[i] != null){
                contador++;
            }
        }
        return contador;
    }


}
