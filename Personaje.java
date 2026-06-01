/**
 * Representa un personaje dentro del juego. Puede ser el jugador o un enemigo
 * según el valor de {@code tipo}.
 */
public class Personaje extends EntidadVideojuego {
    private int vidas;
    private int puntuacion;
    private String tipo; // "JUGADOR", "ENEMIGO_PATRULLA", "ITEM"

    /**
     * Crea un nuevo personaje con los atributos especificados.
     *
     * @param nombre nombre del personaje
     * @param x posición X inicial
     * @param y posición Y inicial
     * @param w ancho
     * @param h alto
     * @param rep carácter de representación visual
     * @param tipo tipo de personaje (p.ej. "JUGADOR" o "ENEMIGO")
     * @param vidas vidas iniciales
     */
    public Personaje(String nombre, int x, int y, int w, int h, char rep, String tipo, int vidas) {
        super(nombre, x, y, w, h, rep);
        this.tipo = tipo;
        this.vidas = vidas;
        this.puntuacion = 0;
    }

    // Getters y Setters
    /** Devuelve el tipo de personaje. */
    public String getTipo() { return tipo; }

    /** Devuelve las vidas restantes del personaje. */
    public int getVidas() { return vidas; }

    /** Establece el número de vidas del personaje. */
    public void setVidas(int vidas) { this.vidas = vidas; }

    /** Suma puntos a la puntuación del personaje. */
    public void sumarPuntos(int puntos) { this.puntuacion += puntos; }

    /**
     * Actualización por tick. Cuando el personaje es un enemigo, se comporta
     * como un NPC simple que patrulla moviéndose un paso a la izquierda.
     */
    @Override
    public void actualizar() {
        // Funcionalidad Avanzada 2: Comportamiento Básico NPC
        if (getTipo().equals("ENEMIGO") && isActivo()) {
            // Simulamos que el enemigo patrulla moviéndose hacia la izquierda (restando X)
            setX(getX() - 1);
            System.out.println("[NPC] " + getNombre() + " patrullando. Nueva posición X: " + getX());
        }
    }
}