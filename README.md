# ⚔️ Proyecto Integrador: Motor de Combate RPG

¡Bienvenidos al **Jefe Final** de la Programación Orientada a Objetos! 👾

Una empresa de desarrollo de videojuegos *indie* nos ha pasado un Documento de Diseño (GDD) con las reglas de su nuevo juego de rol. Nuestra misión ha sido traducir esas reglas a código Java puro, uniendo los dos grandes pilares que hemos estudiado: **La Herencia (Unidad 7)** y **Las Interfaces (Unidad 8)**. 

En este repositorio encontraréis el motor del juego totalmente funcional y estructurado en paquetes profesionales.

---

## 🏗️ Arquitectura del Motor (Paquetes)

Para que un juego sea escalable, no podemos tener todos los archivos mezclados. Fijaos en cómo hemos estructurado el proyecto en **4 paquetes** distintos:

### 📦 1. `entidades` (La Base)
*   🧍 **`Personaje.java`**: La madre de todas las clases. Es **abstracta** porque en el juego no existen "personajes genéricos", todos tienen una profesión. 
    *   Usa visibilidad `protected` para que las profesiones hereden la vida y el nivel sin romper la encapsulación frente a ataques externos.
    *   Obliga a sus hijos a implementar el método `gritoBatalla()`.

### 📦 2. `habilidades` (Los Contratos)
*   🗡️ **`Atacante.java`**: Interfaz que obliga a programar el método `atacar()`.
*   🩹 **`Curador.java`**: Interfaz que obliga a programar el método `curar()`.
*   🛡️ **`Paladin.java`**: ¡La élite! Aplica la **herencia múltiple de interfaces** (`extends Atacante, Curador`). Además, utiliza la magia de Java 8 regalando un método **`default`** llamado `proteger()` que ya viene con código incluido.

### 📦 3. `profesiones` (Las Clases Jugables)
Todas estas clases hacen un `extends Personaje` (herencia) y un `implements` de alguna habilidad (interfaces):
*   🪓 **`Guerrero.java`**: Implementa `Atacante`. Quita 20 puntos de vida por golpe fijo. *"¡Por la alianza!"*.
*   🔥 **`Mago.java`**: Implementa `Atacante`. Su daño es dinámico: si su nivel supera el 5, quita 30 puntos de vida; si no, quita 10. *"¡Fuego y destrucción!"*.
*   ✝️ **`Clerigo.java`**: Implementa la súper-interfaz `Paladin` (y por tanto, está obligado a atacar y curar). *"¡La luz me guía!"*.

### 📦 4. `motor_rpg` (La Ejecución)
*   🎮 **`JuegoRPG.java`**: Contiene nuestro `public static void main`. Aquí es donde la teoría cobra vida.

---

## 🎯 ¿En qué debes fijarte al leer el código?

Al revisar los archivos, prestad especial atención a estos tres momentos clave:

1. **El uso de `super(nombre, nivel)`**: Abrid las clases `Guerrero`, `Mago` o `Clerigo`. Veréis que su constructor es muy pequeño, porque delegan la tarea de inicializar los datos básicos (y asignar los 100 puntos de vida) al constructor de su padre `Personaje`.
2. **El Polimorfismo en acción**: En `JuegoRPG.java`, fijaos en estas líneas:
   ```java
   // Guardamos objetos distintos (Guerrero, Mago, Clerigo) en un array de su clase Padre
   Personaje