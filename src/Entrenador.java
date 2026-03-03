/**
 * Representa a un entrenador dentro del sistema del centro deportivo.
 *
 * Cada entrenador está identificado de manera única mediante un {@code id}
 * y dispone de información básica como nombre, especialidad y años de experiencia.
 *
 * Esta clase actúa como entidad del dominio y encapsula sus datos,
 * permitiendo el acceso únicamente a través de métodos públicos.
 *
 * @author Luca Tsiklauri Bukhrashvili
 * @version 1.0
 */
public class Entrenador {
    private int id;
    private String nombre;
    private String especialidad;
    private int aniosExperiencias;


    /**
     * Metodo constructor de objetos tipo {@code Libro}
     * @param id identificador del Entrenador
     * @param nombre nombre del entrenador
     * @param especialidad escpecialidad del Entrenador
     * @param AniosExperiencias Años de experiencia del Entrenador
     */
    public Entrenador(int id, String nombre, String especialidad, int AniosExperiencias ) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencias = AniosExperiencias;
    }

    /**
     * Devuelve el id del entrenador
     * @return id del entrenador
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el nombre del entrenador
     * @return nombre del entrenador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la especialidad del entrenador
     * @return especialidad del entrenador
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Devuelve los años de experiencia del entrenador
     * @return años de experiencia del entrenador
     */
    public int getAniosExperiencias() {
        return aniosExperiencias;
    }

    /**
     * Devuelve una representación textual del Entrenador con todos sus atributos.
     *
     * @return cadena de texto formateada con la información del Entrenador.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Entrenador: { ");
        sb.append(String.format("\n id: %d;", id));
        sb.append(String.format(" nombre: %s;", nombre));
        sb.append(String.format(" especialidad: %s;", especialidad));
        sb.append(String.format(" Años de Experiencia: %d;", aniosExperiencias));
        sb.append("}");

        return sb.toString();
    }
}
