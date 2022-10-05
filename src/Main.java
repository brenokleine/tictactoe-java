import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] field = new String[4][4];
        String endgame = "Game on";

        InitialFill(field);
        Print(field);

        for(int i=1; i < 10; i++){

            PlayerXMove(field);
            endgame = WinCheck(field);
            if(endgame.equalsIgnoreCase("X wins") || endgame.equalsIgnoreCase("Draw") && !CheckMissingPlay(field)){
                break;
            }

            PlayerOMove(field);
            endgame = WinCheck(field);
            if(endgame.equalsIgnoreCase("O wins") || endgame.equalsIgnoreCase("Draw") && !CheckMissingPlay(field)){
                break;
            }
        }

        if (endgame.equals("O wins")) {
            System.out.println(endgame);

        }
        if (endgame.equals("X wins")) {
            System.out.println(endgame);

        }
        if (endgame.equals("Draw") && !CheckMissingPlay(field)) {
            System.out.println(endgame);

        }
    }

    public static void PlayerXMove(String[][] field) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        String coordinate = scanner.nextLine();

        int coord2 = -1;
        int coord1 = -1;

        if (coordinate.charAt(0) == '1' || coordinate.charAt(0) == '2' || coordinate.charAt(0) == '3') {
            coord1 = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
        }
        if (coordinate.charAt(2) == '1' || coordinate.charAt(2) == '2' || coordinate.charAt(2) == '3') {
            coord2 = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
        }

        if (coord1 <= 3 && coord2 <= 3 && coord1 > 0 && coord2 > 0) {
            if (field[coord1][coord2].equals("_")) {
                field[coord1][coord2] = "X";
                Print(field);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                PlayerXMove(field);
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            PlayerXMove(field);
        }
    }

    public static void PlayerOMove(String[][] field) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        String coordinate = scanner.nextLine();

        int coord2 = -1;
        int coord1 = -1;

        if (coordinate.charAt(0) == '1' || coordinate.charAt(0) == '2' || coordinate.charAt(0) == '3') {
            coord1 = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
        }
        if (coordinate.charAt(2) == '1' || coordinate.charAt(2) == '2' || coordinate.charAt(2) == '3') {
            coord2 = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
        }

        if (coord1 <= 3 && coord2 <= 3 && coord1 > 0 && coord2 > 0) {
            if (field[coord1][coord2].equals("_")) {
                field[coord1][coord2] = "O";
                Print(field);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                PlayerOMove(field);
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            PlayerOMove(field);
        }
    }

    public static void Print(String[][] field) {
        System.out.println("---------");
        System.out.println("| " + field[1][1] + " " + field[1][2] + " " + field[1][3] + " |");
        System.out.println("| " + field[2][1] + " " + field[2][2] + " " + field[2][3] + " |");
        System.out.println("| " + field[3][1] + " " + field[3][2] + " " + field[3][3] + " |");
        System.out.println("---------");
    }

    public static void InitialFill(String[][] field) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                field[i][j] = "_";
            }
        }
    }

    public static String WinCheck(String[][] field) {

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
        else if(!CheckMissingPlay(field)){
            return "Draw";
        }
        else{
            return "Game on";
        }
    }

    public static boolean CheckMissingPlay(String[][] field){
        boolean missingPlay = false;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (field[i][j].equals("_")) {
                    missingPlay = true;
                    break;
                }
                else{
                    missingPlay = false;
                }
            }
            if(missingPlay){
                break;
            }
        }
        return missingPlay;
    }
}
