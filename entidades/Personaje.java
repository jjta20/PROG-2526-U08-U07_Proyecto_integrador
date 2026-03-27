package entidades;

// --- 1. ENTIDAD BASE (clase abstracta) ---
// Es abstracta porque no puede existir un personaje genérico.
public abstract class Personaje {
    // Son protected para que las subclases accedan a ellos
    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = 100; // Siempre empiezan en 100
    }

    // Método común a todos
    public void recibirDano(int cantidad) {
        this.puntosVida -= cantidad;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
        System.out.println(this.nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + this.puntosVida);
    }
    
    // Método para curar
    public void recibirCura(int cantidad) {
        this.puntosVida += cantidad;
        System.out.println(this.nombre + " ha sido curado. Vida actual: " + this.puntosVida);
    }

    //get publico
    public String getNombre() {
        return this.nombre;
    }
    
    // Método es abstracto
    public abstract void gritoBatalla();
}