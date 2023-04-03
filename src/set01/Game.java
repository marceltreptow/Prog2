package set01;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Column[] columns;
    private Row[] rows;
    private int assigment = 1;

    public Game (){
        columns = new Column[7];
        for (int i = 0; i < 7; i++){
            Column column = new Column();
            columns[i] = column;

        }

        rows = new Row[6];
        for (int i = 0; i < 6; i++) {
            Row row = new Row();
            rows[i] = row;

        }
        start();

    }

    public void start(){
        input(42);

    }

    public void input(int a) {
        System.out.println("Wähle eine Reihe zwischen 1 und 7");

        int in = 0;
        try {
            in = scanner.nextInt();

            if (columns[in - 1].puton())
                throw new Exception();

            rows[columns[in - 1].getHeight()].fillfield(assigment, in - 1);

        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Die Eingabe konnte nicht aufgenommen werden!");
            input(a);

        }
        update();
        check(a);

    }

    public void update() {
        switchassignment();

        for (int i = 1; i < 8; i++){
            System.out.print("0" + i + "  ");

        }
        for (int rowcounter = 5; rowcounter >= 0; rowcounter-- ){
            System.out.println();

            for (int columncounter = 0; columncounter < 7; columncounter++){
                switch (rows[rowcounter].getRowassignment(columncounter)) {
                    case 0:
                        System.out.print("-   ");
                        break;
                    case 1:
                        System.out.print("0   ");
                        break;
                    case 2:
                        System.out.print("X   ");

                }
            }
        }
        System.out.println();

    }

    public void check(int a) {
        int siu = 0;

        for (int rowcounter = 5; rowcounter >= 0; rowcounter--) {
            for (int columncounter = 0; columncounter < 7; columncounter++) {
                if (columncounter > 2 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter].getRowassignment(columncounter-1), rows[rowcounter].getRowassignment(columncounter-2), rows[rowcounter].getRowassignment(columncounter-3));

                }
                if (columncounter < 4 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter].getRowassignment(columncounter+1), rows[rowcounter].getRowassignment(columncounter+2), rows[rowcounter].getRowassignment(columncounter+3));

                }
                if (rowcounter > 2 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter-1].getRowassignment(columncounter), rows[rowcounter-2].getRowassignment(columncounter), rows[rowcounter-3].getRowassignment(columncounter));

                }
                if (rowcounter < 3 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter+1].getRowassignment(columncounter), rows[rowcounter+2].getRowassignment(columncounter), rows[rowcounter+3].getRowassignment(columncounter));

                }
                if (rowcounter < 3 && columncounter > 2 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter+1].getRowassignment(columncounter-1), rows[rowcounter+2].getRowassignment(columncounter-2), rows[rowcounter+3].getRowassignment(columncounter-3));

                }
                if (rowcounter < 3 && columncounter < 4 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter+1].getRowassignment(columncounter+1), rows[rowcounter+2].getRowassignment(columncounter+2), rows[rowcounter+3].getRowassignment(columncounter+3));

                }
                if (rowcounter > 2 && columncounter < 4 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter-1].getRowassignment(columncounter+1), rows[rowcounter-2].getRowassignment(columncounter+2), rows[rowcounter-3].getRowassignment(columncounter+3));

                }
                if (rowcounter > 2 && columncounter > 2 && siu == 0) {
                    siu = assigmentcheck(rows[rowcounter].getRowassignment(columncounter), rows[rowcounter-1].getRowassignment(columncounter-1), rows[rowcounter-2].getRowassignment(columncounter-2), rows[rowcounter-3].getRowassignment(columncounter-3));

                }


           }
        }
        if (a > 0 && siu == 0)
                input(a--);

        else {
            switch (siu) {
                case 0:
                    System.out.println("Niemand hat gewonnen!");
                    break;

                    case 1:
                        System.out.println("Spieler 1 hat gewonnen! SIUU!");
                        break;

                        case 2:
                            System.out.println("Spieler 2 hat gewonnen! Muchas gracias afiction! SIUUUUUUUUUUUUUUUUUUU");
                            break;

            }
        }
    }

    public int assigmentcheck(int a, int b, int c, int d){
        if ((a == b && b == c && c == d) && (a == 1 || a == 2))
            return a;

        else
            return 0;

    }

    public void switchassignment(){
        if(assigment == 1)
            assigment = 2;

        else
            assigment = 1;

    }

    public static void main(String[] args) {
        Game n = new Game();

    }
}
