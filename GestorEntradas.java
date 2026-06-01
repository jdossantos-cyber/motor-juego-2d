public class GestorEntradas {
    private MotorJuego motor;

    public GestorEntradas(MotorJuego motor) {
        this.motor = motor;
    }

    public void procesarComando(String comando) {
        // Simularemos las entradas táctiles o de teclado mediante Strings
        System.out.println("-> Input recibido: " + comando);
        // La lógica del switch (ARRIBA, DERECHA, ACCION, PAUSA) irá aquí
    }
}