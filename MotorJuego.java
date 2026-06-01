import java.util.ArrayList;
import java.util.List;

public class MotorJuego {
    // Definimos los estados posibles del motor
    public enum EstadoJuego { MENU, JUGANDO, PAUSA, GAME_OVER }
    
    private EstadoJuego estadoActual;
    private List<EntidadVideojuego> entidades;

    public MotorJuego() {
        this.estadoActual = EstadoJuego.MENU;
        this.entidades = new ArrayList<>();
    }

    public void setEstado(EstadoJuego nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("[MOTOR] Estado cambiado a: " + estadoActual);
    }

    public void agregarEntidad(EntidadVideojuego entidad) {
        entidades.add(entidad);
    }

    public EstadoJuego getEstadoActual() {
        return estadoActual;
    }

    // EL GAME LOOP SIMULADO
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
    public List<EntidadVideojuego> getEntidades() {
        return entidades;
    }
}