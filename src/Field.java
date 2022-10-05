import java.util.Scanner;

public class Field {

    Scanner scanner = new Scanner(System.in);

    protected String[][] field = new String[4][4];

    public Field(){
        initialFill();
    }

    private void initialFill() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                field[i][j] = "_";
            }
        }
    }

    protected void printField() {
        System.out.println("---------");
        System.out.println("| " + field[1][1] + " " + field[1][2] + " " + field[1][3] + " |");
        System.out.println("| " + field[2][1] + " " + field[2][2] + " " + field[2][3] + " |");
        System.out.println("| " + field[3][1] + " " + field[3][2] + " " + field[3][3] + " |");
        System.out.println("---------");
    }

    protected String winCheck() {
        if (field[1][1].equals("X") && field[2][2].equals("X") && field[3][3].equals("X")
                || field[1][3].equals("X") && field[2][2].equals("X") && field[3][1].equals("X")
                || field[1][1].equals("X") && field[2][1].equals("X") && field[3][1].equals("X")
                || field[1][2].equals("X") && field[2][2].equals("X") && field[3][2].equals("X")
                || field[1][3].equals("X") && field[2][3].equals("X") && field[3][3].equals("X")
                || field[1][1].equals("X") && field[1][2].equals("X") && field[1][3].equals("X")
                || field[2][1].equals("X") && field[2][2].equals("X") && field[2][3].equals("X")
                || field[3][1].equals("X") && field[3][2].equals("X") && field[3][3].equals("X")) {
            return "X wins";
        } else if (field[1][1].equals("O") && field[2][2].equals("O") && field[3][3].equals("O")
                || field[1][3].equals("O") && field[2][2].equals("O") && field[3][1].equals("O")
                || field[1][1].equals("O") && field[2][1].equals("O") && field[3][1].equals("O")
                || field[1][2].equals("O") && field[2][2].equals("O") && field[3][2].equals("O")
                || field[1][3].equals("O") && field[2][3].equals("O") && field[3][3].equals("O")
                || field[1][1].equals("O") && field[1][2].equals("O") && field[1][3].equals("O")
                || field[2][1].equals("O") && field[2][2].equals("O") && field[2][3].equals("O")
                || field[3][1].equals("O") && field[3][2].equals("O") && field[3][3].equals("O")) {
            return "O wins";
        }
        else if(!checkMissingPlay()){
            return "Draw";
        }
        else{
            return "Game on";
        }
    }

    protected boolean checkMissingPlay(){
        boolean missingPlay = false;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (field[i][j].equals("_")) {
                    missingPlay = true;
                    break;
                }
            }
            if(missingPlay){
                break;
            }
        }
        return missingPlay;
    }

    protected void playerXMove() {

        System.out.print("Enter the coordinates with a space between numbers (coord1 coord2): ");
        String coordinate = scanner.nextLine();

        int coord1 = -1, coord2 = -1;

        if (coordinate.charAt(0) == '1' || coordinate.charAt(0) == '2' || coordinate.charAt(0) == '3') {
            coord1 = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
        }
        if (coordinate.charAt(2) == '1' || coordinate.charAt(2) == '2' || coordinate.charAt(2) == '3') {
            coord2 = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
        }

        if (coord1 <= 3 && coord2 <= 3 && coord1 > 0 && coord2 > 0) {
            if (field[coord1][coord2].equals("_")) {
                field[coord1][coord2] = "X";
                printField();
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                playerXMove();
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            playerXMove();
        }
    }

    protected void playerOMove() {

        System.out.print("Enter the coordinates with a space between numbers (coord1 coord2): ");
        String coordinate = scanner.nextLine();

        int coord1 = -1, coord2 = -1;

        if (coordinate.charAt(0) == '1' || coordinate.charAt(0) == '2' || coordinate.charAt(0) == '3') {
            coord1 = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
        }
        if (coordinate.charAt(2) == '1' || coordinate.charAt(2) == '2' || coordinate.charAt(2) == '3') {
            coord2 = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
        }

        if (coord1 <= 3 && coord2 <= 3 && coord1 > 0 && coord2 > 0) {
            if (field[coord1][coord2].equals("_")) {
                field[coord1][coord2] = "O";
                printField();
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                playerOMove();
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            playerOMove();
        }
    }
}
