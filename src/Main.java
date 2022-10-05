import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Field field = new Field();

        String endgame = "Game on";

        field.printField();

        for(int i=1; i < 10; i++){

            field.playerXMove();
            endgame = field.winCheck();
            if(endgame.equalsIgnoreCase("X wins") || endgame.equalsIgnoreCase("Draw") && !field.checkMissingPlay()){
                break;
            }

            field.playerOMove();
            endgame = field.winCheck();
            if(endgame.equalsIgnoreCase("O wins") || endgame.equalsIgnoreCase("Draw") && !field.checkMissingPlay()){
                break;
            }
        }

        if (endgame.equals("O wins")) {
            System.out.println(endgame);

        }
        if (endgame.equals("X wins")) {
            System.out.println(endgame);

        }
        if (endgame.equals("Draw") && !field.checkMissingPlay()) {
            System.out.println(endgame);

        }
    }


}
