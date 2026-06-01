/**
 * Clase base que representa una entidad genérica dentro del videojuego.
 * <p>
 * Cada entidad tiene una posición (x,y), dimensiones (width,height), un nombre,
 * una representación visual (un carácter) y un estado activo/inactivo.
 * Subclases deben implementar el método {@link #actualizar()} para definir su
 * comportamiento por tick.
 */
public abstract class EntidadVideojuego {
    /** Nombre identificador de la entidad. */
    private String nombre;
    /** Posición X de la entidad en el mundo de juego. */
    private int x, y, width, height;
    /** Indica si la entidad está activa y debe procesarse. */
    private boolean activo;
    /** Carácter usado para una representación visual simple en consola. */
    private char representacionVisual; // Ej: 'M' para Mario, 'G' para Goomba

    /**
     * Construye una nueva entidad de videojuego.
     *
     * @param nombre nombre identificador de la entidad
     * @param x posición X inicial
     * @param y posición Y inicial
     * @param w ancho de la entidad
     * @param h alto de la entidad
     * @param rep carácter de representación visual
     */
    public EntidadVideojuego(String nombre, int x, int y, int w, int h, char rep) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.activo = true;
        this.representacionVisual = rep;
    }

    /** Devuelve la coordenada X actual. */
    public int getX() { return x; }

    /** Establece la coordenada X. */
    public void setX(int x) { this.x = x; }

    /** Devuelve la coordenada Y actual. */
    public int getY() { return y; }

    /** Establece la coordenada Y. */
    public void setY(int y) { this.y = y; }

    /** Devuelve el ancho de la entidad. */
    public int getWidth() { return width; }

    /** Devuelve el alto de la entidad. */
    public int getHeight() { return height; }

    /** Indica si la entidad está activa. */
    public boolean isActivo() { return activo; }

    /** Activa o desactiva la entidad para el procesamiento. */
    public void setActivo(boolean activo) { this.activo = activo; }

    /** Devuelve el nombre de la entidad. */
    public String getNombre() { return nombre; }

    /** Devuelve el carácter que representa visualmente a la entidad. */
    public char getRepresentacionVisual() { return representacionVisual; }

    /**
     * Lógica de actualización que se ejecuta en cada tick del motor.
     * Las subclases deben implementar este método para definir comportamiento
     * específico (movimiento, IA, animaciones, etc.).
     */
    public abstract void actualizar();
}