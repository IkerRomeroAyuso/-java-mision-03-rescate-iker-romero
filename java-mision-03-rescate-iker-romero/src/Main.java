import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matriz = new char[10][10];
        int Robot;
        int meta;

        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz.length; columnas++) {
                matriz[filas][columnas] = '*';
            }
        }

        matriz[0][0] = 'R';
        matriz[9][9] = 'F';

        Random random = new Random();
        int filaRandom = random.nextInt();
        int columnaRandom = random.nextInt();

        for (int i = 0; i < 5; i++) {
            do {
                filaRandom = random.nextInt(10);
                columnaRandom = random.nextInt(10);
            } while (matriz[filaRandom][columnaRandom] != '*'); {
                matriz[filaRandom][columnaRandom] = 'X';
            }
        }
        for(int i=0;i<1;i++){
            do {
                filaRandom = random.nextInt(10);
                columnaRandom = random.nextInt(10);
            } while (matriz[filaRandom][columnaRandom] != '*'); {
                matriz[filaRandom][columnaRandom] = 'B';
            }
        }

        for (int filas = 0; filas < matriz.length; filas++) {
            for (int columnas = 0; columnas < matriz.length; columnas++) {
                System.out.print(matriz[filas][columnas] + " ");
            }
            System.out.println();
        }

        int filaRobot=0;
        int columnaRobot=0;
        int vida=10;

        Scanner Scanner = new Scanner(System.in);
        char letra;
        do{
            System.out.println("Dime una letra: ");
            letra = Scanner.next().charAt(0);
            if (letra == 'D') {
                matriz[filaRobot][columnaRobot]='*';
                columnaRobot = columnaRobot + 1;
                matriz[filaRobot][columnaRobot]='R';

                if (columnaRobot > 9) {
                    System.out.println("Te vas fueraa");
                    columnaRobot = 9;
                } else {
                    if (matriz[filaRobot][columnaRobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                        columnaRobot = columnaRobot -1;

                        if (matriz[filaRobot][columnaRobot] == 'B') {
                            System.out.println("+2 vidas");
                            vida++;
                            vida++;
                        }
                        if (matriz[filaRobot][columnaRobot] == 'F') {
                            System.out.println("Rescate completado");
                            matriz[filaRobot][columnaRobot] = 'R';
                            return;
                        }
                    }
                }
            }
            if (letra == 'A') {
                matriz[filaRobot][columnaRobot]='*';
                columnaRobot = columnaRobot - 1;
                matriz[filaRobot][columnaRobot]='R';

                if (columnaRobot > 0) {
                    System.out.println("Te vas fueraa");
                    columnaRobot = 0;
                } else {
                    if (matriz[filaRobot][columnaRobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                        columnaRobot = columnaRobot -1;

                        if (matriz[filaRobot][columnaRobot] == 'B') {
                            System.out.println("+2 vidas");
                            vida++;
                            vida++;
                        }
                        if (matriz[filaRobot][columnaRobot] == 'F') {
                            System.out.println("Rescate completado");
                            matriz[filaRobot][columnaRobot] = 'R';
                            return;
                        }
                    }
                }
            }
            if (letra == 'W') {
                matriz[filaRobot][columnaRobot]='*';
                filaRobot = filaRobot - 1;
                matriz[filaRobot][columnaRobot]='R';

                if (filaRobot < 0) {
                    System.out.println("Te vas fueraa");
                    filaRobot = 0;
                } else {
                    if (matriz[filaRobot][columnaRobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                        filaRobot = filaRobot -1;

                        if (matriz[filaRobot][columnaRobot] == 'B') {
                            System.out.println("+2 vidas");
                            vida++;
                            vida++;
                        }
                        if (matriz[filaRobot][columnaRobot] == 'F') {
                            System.out.println("Rescate completado");
                            matriz[filaRobot][columnaRobot] = 'R';
                            return;
                        }
                    }
                }
            }
            if (letra == 'S') {
                matriz[filaRobot][columnaRobot]='*';
                filaRobot = filaRobot + 1;
                matriz[filaRobot][columnaRobot]='R';

                if (filaRobot > 9) {
                    System.out.println("Te vas fueraa");
                    filaRobot = 9;
                }
                    if (matriz[filaRobot][columnaRobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                        filaRobot = filaRobot -1;
                    }
                    if (matriz[filaRobot][columnaRobot] == 'B') {
                            System.out.println("+2 vidas");
                            vida++;
                            vida++;
                    }
                    if (matriz[filaRobot][columnaRobot] == 'F') {
                            System.out.println("Rescate completado");
                            matriz[filaRobot][columnaRobot] = 'R';
                            return;
                    }
            }


            for (int filas = 0; filas < matriz.length; filas++) {
                for (int columnas = 0; columnas < matriz.length; columnas++) {
                    System.out.print(matriz[filas][columnas] + " ");
                }
                System.out.println();
            }
            System.out.println("Te quedan " + vida + "vidas");
        }while(vida>0);



    }
}