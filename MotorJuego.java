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
        // Aquí implementaremos nuestra funcionalidad avanzada 1
    }
    
    public List<EntidadVideojuego> getEntidades() {
        return entidades;
    }
}