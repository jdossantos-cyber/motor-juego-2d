import java.util.ArrayList;
import java.util.List;

/**
 * Motor del juego responsable de gestionar el estado global, el ciclo de
 * actualización (game loop) y las entidades presentes en la escena.
 */
public class MotorJuego {
    /** Estados posibles del motor de juego. */
    public enum EstadoJuego { MENU, JUGANDO, PAUSA, GAME_OVER }
    
    private EstadoJuego estadoActual;
    private List<EntidadVideojuego> entidades;

    /**
     * Crea e inicializa un nuevo motor de juego en estado MENU.
     */
    public MotorJuego() {
        this.estadoActual = EstadoJuego.MENU;
        this.entidades = new ArrayList<>();
    }

    /**
     * Cambia el estado actual del motor.
     *
     * @param nuevoEstado el nuevo estado a establecer
     */
    public void setEstado(EstadoJuego nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("[MOTOR] Estado cambiado a: " + estadoActual);
    }

    /**
     * Añade una entidad al motor para que sea procesada en cada tick.
     *
     * @param entidad la entidad a agregar
     */
    public void agregarEntidad(EntidadVideojuego entidad) {
        entidades.add(entidad);
    }

    /** Devuelve el estado actual del motor. */
    public EstadoJuego getEstadoActual() {
        return estadoActual;
    }

    /**
     * Ejecuta un ciclo de actualización simulado. Solo realiza acciones si el
     * estado actual es JUGANDO: actualiza cada entidad activa y verifica
     * colisiones.
     */
    public void actualizar() {
        if (estadoActual != EstadoJuego.JUGANDO) return;

        System.out.println("--- Tick del Motor ---");
        for (EntidadVideojuego e : entidades) {
            if (e.isActivo()) {
                e.actualizar(); 
            }
        }
        verificarColisiones();
    }

   /**
    * Verificador simple de colisiones que compara posiciones enteras X/Y de
    * las entidades. Si el jugador colisiona con un enemigo, pierde una vida.
    * (Implementación simple para demo; no considera bounding boxes ni
    * detección continua.)
    */
   private void verificarColisiones() {
        // Funcionalidad Avanzada 1: Detector de Colisiones Simple
        if (entidades.size() < 2) return;

        // Asumimos para la simulación que Mario es la primera entidad (índice 0)
        Personaje mario = (Personaje) entidades.get(0); 

        for (int i = 1; i < entidades.size(); i++) {
            EntidadVideojuego otraEntidad = entidades.get(i);
            
            if (otraEntidad.isActivo() && 
                mario.getX() == otraEntidad.getX() && 
                mario.getY() == otraEntidad.getY()) {
                
                System.out.println("💥 ¡COLISIÓN DETECTADA! " + mario.getNombre() + " chocó con " + otraEntidad.getNombre());
                
                if (otraEntidad instanceof Personaje) {
                    Personaje enemigo = (Personaje) otraEntidad;
                    if (enemigo.getTipo().equals("ENEMIGO")) {
                        mario.setVidas(mario.getVidas() - 1);
                        System.out.println("💔 Mario ha perdido una vida. Vidas restantes: " + mario.getVidas());
                        if (mario.getVidas() <= 0) {
                            setEstado(EstadoJuego.GAME_OVER);
                        }
                    }
                }
            }
        }
    }

    /** Devuelve la lista de entidades registradas en el motor. */
    public List<EntidadVideojuego> getEntidades() {
        return entidades;
    }
}