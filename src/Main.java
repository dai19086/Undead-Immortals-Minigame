import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //initialize game state
        final int dimensions = 8;               //declare the size of the map
        int[] treasurePosition = {7,5};         //declare the position of the goal in the map
        int[] playerStartingPosition = {0,0};   //declare the original position of the player
        int[][] rockPositions = {               //place the rocks in the map
                                                   {0,5}, {0,6},
                       {1,1},        {1,3},
                       {2,1},        {2,3}, {2,4}, {2,5}, {2,6},
                       {3,1},                             {3,6},
                       {4,1}, {4,2}, {4,3}, {4,4},        {4,6},
                                            {5,4},        {5,6},
                {6,0}, {6,2},               {6,4}, {6,5}, {6,6},
                {7,0}, {7,1}, {7,2},                      {7,6},
        };

        Character player = new Player(playerStartingPosition, 50 ); //create the player
        GameState game = new GameState(dimensions);  //create the map

        for (int[] i : rockPositions) {// check if the player starting position is on a rock (this should be avoided)
            if (Arrays.equals(i,playerStartingPosition)){
                System.out.println("THE PLAYER IS ON TOP OF A ROCK!!!");
                System.out.println("MOVE TO LET HIM DOWN!");
            }
        }

        int steps = 0;//initialize the number of steps

        //START GAME
        do{
            //show map
            game.showGameState(player.getCharacterPosition(),rockPositions,treasurePosition);
            //move characters
            player.move(rockPositions,dimensions);
            steps += 1;
        }while(!Arrays.equals(treasurePosition,player.getCharacterPosition()));

        //GAME ENDS
        game.showGameState(player.getCharacterPosition(),rockPositions,treasurePosition);
        System.out.println("CONGRATULATIONS!!!");
        System.out.println("YOU REACHED THE TREASURE IN " + steps + " STEPS!!!");

    }
}