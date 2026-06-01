public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulación de Motor 2D - Consola");
        
        MotorJuego motor = new MotorJuego();
        GestorEntradas input = new GestorEntradas(motor);

        // Simularemos el arranque del juego
        motor.setEstado(MotorJuego.EstadoJuego.JUGANDO);
        
        // Aquí en la siguiente fase crearemos a Mario, los Goombas y ejecutaremos el Game Loop simulado
    }
}
