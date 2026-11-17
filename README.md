import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char tablero [] [] = new char[10][10];

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                tablero[fila][columna]= '*';
            }
        }

        int Robot = 'R';
        int Meta = 'M';
        tablero[0][0] = (char) Robot;
        tablero[9][9] = (char) Meta;

        int vidas = 3;
        Random random = new Random();
        int filar = random.nextInt(10);
        int columnar = random.nextInt(10);

        for (int i = 0; i < 5; i++) {
            do {
                filar = random.nextInt(10);
                columnar = random.nextInt(10);
            } while (tablero[filar][columnar] != '*'); {
                tablero[filar][columnar] = 'X';
            }
        }
        for (int i = 0; i < 1; i++) {
            do {
                filar = random.nextInt(10);
                columnar = random.nextInt(10);
            } while (tablero[filar][columnar] != '*'); {
                tablero[filar][columnar] = 'B';
            }
        }

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }

        Scanner lector = new Scanner(System.in);
        int filaRobot = 0;
        int columnaRobot = 0;

        System.out.println("Te me mueves con AWSD");
        System.out.println("Tienes 3 vidas");
        System.out.println("Dime una letra con la que moverte");
        char Desplazamiento = lector.next().charAt(0);

        do{
            for (int fila = 0; fila < 10; fila++) {
                for (int columna = 0; columna < 10; columna++) {
                    System.out.print(tablero[fila][columna] + " ");
                }
                System.out.println();
            }

            System.out.println("Tienes " + vidas +" vidas");
            System.out.println("Dime otra letra con la que moverte");
            Desplazamiento = lector.next().charAt(0);

            if (Desplazamiento == 'D') {
                tablero[filaRobot][columnaRobot] = '*';
                columnaRobot++;
                tablero[filaRobot][columnaRobot] = 'R';

                if (columnaRobot > 9) {
                    System.out.println("Te vas fueraaaaa");
                    columnaRobot = 9;
                }

                if (tablero[filaRobot][columnaRobot] == 'X') {
                    System.out.println("Te has chocado con un MUROOOOOOOO (-1 vida)");
                    vidas--;
                    tablero[filaRobot][columnaRobot] = 'M';
                    columnaRobot--;
                    tablero[filaRobot][columnaRobot] = 'R';
                }

                if (tablero[filaRobot][columnaRobot] == 'B') {
                    System.out.println("Te has chocado con un BARRIL (+1 vida)");
                    vidas++;
                    tablero[filaRobot][columnaRobot] = '*';
                    columnaRobot--;
                    tablero[filaRobot][columnaRobot] = 'R';
                }

            }

        }while (vidas>0);
    }
}
