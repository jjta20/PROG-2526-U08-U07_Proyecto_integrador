# ⚔️ Proyecto integrador: motor de combate RPG

¡Hola de nuevo, estudiantes! 👋 

Bienvenidos al **jefe final** de la programación orientada a objetos. 

En este repositorio encontraréis la solución al proyecto integrador donde por fin unimos los dos grandes pilares que hemos estudiado: **la herencia (unidad 7)** y **las interfaces (unidad 8)**. 

Recordad el contexto: hemos sido contratados por un estudio indie para programar el núcleo lógico de un nuevo videojuego de rol (RPG). ¡Aquí tenéis el código que da vida a nuestros héroes!

---

## 🎯 ¿Qué conceptos ponemos en práctica aquí?

Este proyecto es la culminación de todo lo aprendido. Para construir el motor hemos tenido que aplicar:

*   👻 **Clases abstractas (`abstract`)**: La clase `Personaje` como base. No existen "personajes genéricos" vagando por el juego, por lo que evitamos su instanciación pero definimos su ADN.
*   🛡️ **Encapsulación y visibilidad `protected`**: Los puntos de vida, el nombre y el nivel son heredados por las profesiones hijas, pero siguen ocultos al exterior para evitar trampas.
*   🤝 **Interfaces como capacidades**: `Atacante` y `Curador` funcionan como contratos que definen estrictamente qué sabe hacer cada profesión.
*   🧬 **Herencia múltiple de interfaces**: La interfaz `Paladin` une el ataque y la cura heredando de ambas.
*   🆕 **Métodos `default`**: La habilidad pasiva de protegerse, propia de los paladines, implementada directamente en la interfaz.
*   🎭 **Polimorfismo en estado puro**: Un array de tipo `Personaje` almacenando guerreros, magos y clérigos juntos para ejecutar métodos de forma dinámica.

---

## 🚀 Estructura del motor de juego

El código está organizado en **4 paquetes** siguiendo el documento de diseño (GDD) para que el juego sea escalable:

| Paquete | Archivos | Descripción |
| :---: | :--- | :--- |
| `entidades` | 🧍 **`Personaje.java`** | La clase **abstracta** base. Gestiona el daño (evitando que la vida baje de cero) y obliga a sus hijos a implementar un grito de batalla. |
| `habilidades` | 🗡️ **`Atacante.java`**<br>🩹 **`Curador.java`**<br>🛡️ **`Paladin.java`** | Las **interfaces** del juego. Definen las acciones en combate. Ojo a la herencia múltiple en el paladín y su método por defecto. |
| `profesiones` | 🪓 **`Guerrero.java`**<br>🔥 **`Mago.java`**<br>✝️ **`Clerigo.java`** | Las clases concretas jugables. Heredan de la clase personaje para tener vida y nivel, e implementan sus respectivas habilidades. |
| `motor_rpg` | 🎮 **`JuegoRPG.java`** | La clase con el método principal. Instancia el **batallón**, ejecuta el bucle polimórfico de los gritos y la simulación manual del combate. |

---

## 🛠️ ¿Cómo usar este repositorio?

1. **Explora la jerarquía:** Empieza leyendo `Personaje.java` (la base), luego ve a las interfaces en `habilidades` (los contratos) y, finalmente, abre las clases en `profesiones` para ver cómo unen ambas cosas.
2. **Analiza los constructores:** Fíjate cómo el guerrero, el mago y el clérigo usan `super(nombre, nivel)` para delegar la inicialización de los datos (y los 100 puntos de vida) al constructor de su padre.
3. **Ejecuta la simulación:** Ejecuta `JuegoRPG.java` y observa la salida por la consola de tu IDE. Presta especial atención al bucle `for (Personaje p : batallon)`. Entender cómo una misma variable `p` sabe qué grito dar según el objeto real que guarda es la clave de todo.

> **💡 Consejo del profe:** 
> *Este proyecto es vuestra prueba de fuego en programación orientada a objetos. Si sois capaces de entender por qué un clérigo puede guardarse en un array de tipo personaje, pero a la vez puede usar el método de protegerse de la interfaz paladín, ¡estáis listos para cualquier reto de diseño de software! Repasadlo bien.*

---
*Profe: Javier Torre Antúnez | IES Newton-Salas* 🏫