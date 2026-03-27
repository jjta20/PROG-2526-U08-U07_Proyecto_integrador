package habilidades;

// --- 2.3. HABILIDADES (interfaz) ---
// Herencia múltiple de interfaces y el método default
public interface Paladin extends Atacante, Curador {
    default void proteger() {
        System.out.println(" El paladín levanta su escudo sagrado y bloquea el ataque.");
    }
}