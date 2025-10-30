/*Vamos a implementar una batalla entre 2 pokemon.

Datos que necesitamos de cada pokemon:
Para cada pokemon, tenéis que definir:

Su nombre
La vida
Los TP
El daño de su ataque normal
Su defensa
El nombre de su ataque especial
El daño de su ataque especial
El consumo de puntos de su ataque especial
Por ejemplo:


String pokemon1 = "Pikachu";
int vida1 = 120;
int mp1 = 50;
int danhoGolpe1 = 10;
int defensa1 = 5;
String golpeEspecial = "Impactrueno";
int danhoEspecial = 40;
int mpGolpeEspecial = 15;
Batalla
Tenéis que simular una pelea entre los dos pokemon hasta que uno gana - un bucle While hasta que uno de los dos tiene 0 o menos vida. En cada ejecución del bucle:

Imprimís el estado de ambos Pokemon
Imprimís a qué pokemon le toca atacar
Le pedís al usuario que diga qué hacer, si el ataque especial o el ataque normal
Si hace el ataque normal, le hace daño al otro Pokemon por valor de (ataque - defensa)
Si hace el ataque especial, ocurre lo mismo que con el normal, salvo que el ataque hace más daño. PERO, si no tiene suficientes MP para ejecutar el ataque, pierde el turno.
Imprimís el efecto del ataque ...(pokemon1 + " le hace " + danho + " puntos de daño a " + pokemon2)

--------AÑADIDO-------

Tienes que mejorar el Sistema de Batallas Pokemon que habías implementado. Ahora toca añadirle funciones. En concreto, tienes que hacer funciones para:

Imprimir el estado de un pokemon (recibe como parámetros los valores actuales del pokemon).
Pedir al usuario qué ataque realiza. La función tiene que pedir de nuevo la información en caso de que el usuario dé información incorrecta (por ejemplo, si le dices "1 para el ataque principal, 2 para el especial" y pone otro valor, tienes que volver a pedirlo).
Realizar un ataque. Le pasas a la función el daño de ataque, la vida del enemigo y su defensa, y devuelves cuanta vida le queda después del ataque. */

import java.util.Scanner;

public class batallasMejoradas {
    public static void Estado(String nombre, int vida, int mp) {
        System.out.println(nombre + " tiene " + vida + " puntos de vida y " + mp + " mps");
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        String pokemon1 = "Pikachu";
        int vida1 = 120;
        int mp1 = 50;
        int danhoGolpe1 = 10;
        int defensa1 = 5;
        String golpeEspecial = "Impactrueno";
        int danhoEspecial = 40;
        int mpGolpeEspecial = 15;
        System.out.println("\n===== ESTADO DE PIKACHU =====");
        System.out.println("Puntos de vida: " + vida1);
        System.out.println("Puntos de energía: " + mp1);
        System.out.println("Puntos de defensa: " + defensa1);
        System.out.println("Su golpe hace " + danhoGolpe1 + " puntos de daño.");
        System.out.println("Su golpe especial es Impactrueno.");
        System.out.println("Su golpe especial hace " + danhoEspecial + " puntos de daño.");
        System.out.println("Su golpe especial gasta " + mpGolpeEspecial + " puntos de energía.");


        String pokemon2 = "Gyarados";
        int vida2 = 400;
        int mp2 = 50;
        int danhoGolpe2 = 25;
        int defensa2 = 18;
        String golpeEspecial2 = "Ciclón";
        int danhoEspecial2 = 40;
        int mpGolpeEspecial2 = 15;
        System.out.println("\n===== ESTADO DE GYARADOS =====");
        System.out.println("Puntos de vida: " + vida2);
        System.out.println("Puntos de energía: " + mp2);
        System.out.println("Puntos de defensa: " + defensa2);
        System.out.println("Su golpe hace " + danhoGolpe2 + " puntos de daño.");
        System.out.println("Su golpe especial es Ciclón.");
        System.out.println("Su golpe especial hace " + danhoEspecial2 + " puntos de daño.");
        System.out.println("Su golpe especial gasta " + mpGolpeEspecial2 + " puntos de energía.");
        boolean turnoPikachu = true;

        System.out.println("Empieza la batalla entre " + pokemon1 + " y " + pokemon2 + ".");
        while (vida1 > 0 && vida2 > 0) {
            Estado(pokemon1, vida1, mp1);
            Estado(pokemon2, vida2, mp2);

            if (turnoPikachu) {
                System.out.println("Turno de " + pokemon1 + ". ¿Qué golpe quieres hacer?");
                System.out.println("1. Ataque normal");
                System.out.println("2. Impactrueno");
                int ataquePK = lector.nextInt();

                if (ataquePK == 1) {
                    int danho = danhoGolpe1 - defensa2;
                    if (danho < 0) {
                        danho = 1;
                    }
                    vida2 = vida2 - danho;

                } else if (ataquePK == 2) {
                    if (mp1 >= mpGolpeEspecial) {
                        mp1 = mp1 - mpGolpeEspecial;
                        int danho = danhoGolpe1 - defensa2;
                        if (danho < 0) {
                            danho = 1;
                        }
                        vida2 = vida2 - danho;

                    } else {
                        System.out.println(pokemon1 + " no tiene suficientes MP y pierde el turno.");

                    }

                } else {
                    System.out.println("Opción no válida, pierde el turno");
                }

            } else {
                System.out.println("Turno de " + pokemon2 + ", ¿qué tipo de ataque quieres usar?");
                System.out.println("1. Ataque normal");
                System.out.println("2. Ciclón");
                int ataqueGY = lector.nextInt();

                if (ataqueGY == 1) {
                    int danho = danhoGolpe2 - defensa1;
                    if (danho < 0) {
                        danho = 1;
                    }
                    vida1 = vida1 - danho;

                } else if (ataqueGY == 2) {
                    if (mp2 >= mpGolpeEspecial2) {
                        mp2 = mp2 - mpGolpeEspecial2;
                        int danho = danhoGolpe2 - defensa1;
                        if (danho < 0) {
                            danho = 1;
                        }
                        vida1 = vida1 - danho;

                    } else {
                        System.out.println(pokemon2 + " no tiene suficientes MP y pierde el turno.");
                    }
                } else {
                    System.out.println("Opción no válida, turno perdido.");
                }
            }
            turnoPikachu = !turnoPikachu;
        }

        if (vida1 <= 0 && vida2 <= 0) {
            System.out.println("Es un empate");
        } else if (vida1 <= 0) {
            System.out.println(pokemon2 + " gana!");
        } else {
            System.out.println(pokemon1 + " gana!");
        }

    }
}



