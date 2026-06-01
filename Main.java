/**
 * Punto de entrada de la aplicación. Crea el motor, las entidades y lanza
 * una pequeña simulación del game loop.
 */
public class Main {
    /**
     * Método principal que arranca la demo del motor de juego.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SUPER MARIO BROS ENGINE ===");
        
        MotorJuego motor = new MotorJuego();
        GestorEntradas input = new GestorEntradas(motor);

        // 1. Crear las entidades
        // Mario empieza en X=0, Y=0
        Personaje mario = new Personaje("Mario", 0, 0, 10, 10, 'M', "JUGADOR", 3);
        // El Goomba empieza en X=2, Y=0 (está a dos pasos a la derecha)
        Personaje goomba = new Personaje("Goomba", 2, 0, 10, 10, 'G', "ENEMIGO", 1);

        motor.agregarEntidad(mario);
        motor.agregarEntidad(goomba);

        // 2. Iniciar el juego
        motor.setEstado(MotorJuego.EstadoJuego.JUGANDO);

        // 3. Simular el Game Loop (3 Ticks)
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- TICK " + i + " ---");
          if (motor.getEstadoActual() == MotorJuego.EstadoJuego.GAME_OVER) {
                System.out.println("💀 FIN DEL JUEGO.");
                break;
            }
            
            // Simulamos que el jugador no pulsa nada, pero el motor se actualiza
            motor.actualizar();
        }
    }
}