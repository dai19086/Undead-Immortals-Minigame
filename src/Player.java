import java.util.Arrays;
import java.util.Scanner;

public class Player extends Character{

    public Player(int[] cPosition, int cHP){
        super(cPosition, cHP);
    }

    public void move (int[][] rocks,int dimension){
        //get the position the Player started in, so we can distinguish if (s)he moved
        int[] lastPosition = Arrays.copyOf(this.characterPosition,this.characterPosition.length);
        //create the scanner to get user's input
        Scanner scanner = new Scanner(System.in);
        //prompt user
        System.out.println("Please enter a direction for the Player to move:");

        //start getting directions until the Player moves
        do {
            String direction = scanner.next();

            int[] moveDirection = {0,0};
            //check the input and translate the direction to use it to move
            //UP will be {-1,0}
            //DOWN will be {1,0}
            //LEFT will be {0,-1}
            //RIGHT will be {0,1}
            switch (direction) {
                case "w", "W" -> moveDirection[0] += (-1);
                case "s", "S" -> moveDirection[0] += 1;
                case "a", "A" -> moveDirection[1] += (-1);
                case "d", "D" -> moveDirection[1] += 1;
                default -> System.out.println("Invalid direction!!!");
            }
            if (this.validMove(moveDirection, rocks, dimension)){//if the position that the Player is going to move to is valid
                //update the Player's position
                for (int i = 0; i < moveDirection.length; i++)
                    this.characterPosition[i] += moveDirection[i];
            }else if (moveDirection[0]==0 && moveDirection[1]==0){//if the Player didn't move because he used the wrong controls
                System.out.println();
            }else{//if the player didn't pass the move validation tests
                System.out.println("Try moving in another direction!");
            }
        }while (Arrays.equals(this.characterPosition, lastPosition));//check if the Player moved to terminate the method

    }

}
