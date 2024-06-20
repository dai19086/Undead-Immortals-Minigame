import java.util.Arrays;

public abstract class Character {

    protected int[] characterPosition;  //keeps the character's coordinates in the game
    protected int characterHP;          //keeps the character's remaining hit points

    public Character(int[] cPosition, int cHP){
        this.characterPosition = cPosition;
        this.characterHP = cHP;
    }

    //this method changes the characterPosition for Characters that cannot pass through obstacles such as rocks
    //Parameters:
    //rocks: an Array of int Arrays that contain the positions of the rocks in the map
    //dimension: the size of the map
    public abstract void move(int[][] rocks,int dimension);

    //this method is used by the move method, to check if the Character can move to the new position
    //the current method is used for Characters that cannot pass through obstacles such as rocks
    //Parameters:
    //moveDirection: an int Array with the direction that the Character is trying to move to
    //rocks: an Array of int Arrays that contain the positions of the rocks in the map
    //dimension: the size of the map
    protected boolean validMove(int[] moveDirection,int[][] rocks, int dimension) {

        boolean vMove = true;   //assume that the move is valid

        //check if the Player didn't give a moveDirection (possibly because he entered false controls)
        boolean moved = false;  //assume that he didn't
        for (int i : moveDirection) {
            if (i != 0){
                moved = true;
                break;
            }
        }
        if (!moved){//if so, let the user know and return false, as not moving is an invalid move
            vMove = false;
            System.out.println("Try moving with the WASD controls as described above.");
            return vMove;
        }

        //create the new position that the Player is going to move to
        int[] newPosition = Arrays.copyOf(moveDirection,moveDirection.length);
        for (int i = 0; i < newPosition.length; i++)
            newPosition[i] += this.characterPosition[i];

        //check if the Player is trying to move out of the map
        for (int i : newPosition) {
            if (i < 0 || i >= dimension) {//if so, let the user know and return false
                vMove = false;
                System.out.println("That way is out of bounds.");
                return vMove;
            }
        }

        //check if the Player is trying to move on top of a rock
        for (int[] rockPosition : rocks) {
            if (Arrays.equals(newPosition,rockPosition)){
                vMove = false;
                System.out.println("There is a rock that way.");
                return vMove;
            }
        }

        return vMove;   //return the final check (should be true after passing all the tests)
    }

    public int[] getCharacterPosition() {
        return characterPosition;
    }

    /*public int getCharacterHP() {
        return characterHP;
    }*/

}
