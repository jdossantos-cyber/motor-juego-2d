/**
 * Componente encargado de recibir y procesar entradas (teclado, táctiles,
 * etc.) para traducirlas a acciones sobre el {@link MotorJuego}.
 */
public class GestorEntradas {
    private MotorJuego motor;

    /**
     * Crea un gestor de entradas enlazado a un motor de juego.
     *
     * @param motor el motor de juego que responderá a las entradas
     */
    public GestorEntradas(MotorJuego motor) {
        this.motor = motor;
    }

    /**
     * Procesa un comando representado como String. Esta implementación
     * actualmente solo simula la recepción imprimiendo el comando; en una
     * versión extendida debería mapear a acciones concretas (mover jugador,
     * pausar, disparar, etc.).
     *
     * @param comando cadena que representa la entrada recibida
     */
    public void procesarComando(String comando) {
        // Simularemos las entradas táctiles o de teclado mediante Strings
        System.out.println("-> Input recibido: " + comando);
        // La lógica del switch (ARRIBA, DERECHA, ACCION, PAUSA) irá aquí
    }
}