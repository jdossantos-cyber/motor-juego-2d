public abstract class EntidadVideojuego {
    private String nombre;
    private int x, y, width, height;
    private boolean activo;
    private char representacionVisual; // Ej: 'M' para Mario, 'G' para Goomba

    public EntidadVideojuego(String nombre, int x, int y, int w, int h, char rep) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.activo = true;
        this.representacionVisual = rep;
    }

    // Getters y Setters básicos (omito escribirlos todos aquí por brevedad, pero debes generarlos)
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public String getNombre() { return nombre; }
    public char getRepresentacionVisual() { return representacionVisual; }

    // Método abstracto que cada hijo implementará a su manera
    public abstract void actualizar();
}