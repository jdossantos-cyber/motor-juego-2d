public class Personaje extends EntidadVideojuego {
    private int vidas;
    private int puntuacion;
    private String tipo; // "JUGADOR", "ENEMIGO_PATRULLA", "ITEM"

    public Personaje(String nombre, int x, int y, int w, int h, char rep, String tipo, int vidas) {
        super(nombre, x, y, w, h, rep);
        this.tipo = tipo;
        this.vidas = vidas;
        this.puntuacion = 0;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public int getVidas() { return vidas; }
    public void setVidas(int vidas) { this.vidas = vidas; }
    public void sumarPuntos(int puntos) { this.puntuacion += puntos; }

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