
public class GameState {

    private final String[][] map;

    public GameState(int mapDimensions){
        //creates a square map according to the mapDimensions given
        this.map = new String[mapDimensions][mapDimensions];
        System.out.println("Welcome to UNDEAD IMMORTALS!!!");
        System.out.println("The goal of the game is to reach the Treasure (t)!");
        System.out.println("You can move the Player (p) using the keys bellow:");
        System.out.println("W for UP");
        System.out.println("S for DOWN");
        System.out.println("A for LEFT");
        System.out.println("D for RIGHT");
    }

    public void showGameState(int[] playerPosition, int[][] rocks, int[] treasure){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                this.map[i][j] = "□";
            }
        }
        for (int[] i : rocks){
            this.map[i[0]][i[1]] = "R";
        }
        this.map[playerPosition[0]][playerPosition[1]] = "p";
        this.map[treasure[0]][treasure[1]] = "t";

        for (String[] strings : this.map) {
            for (String string : strings) {
                System.out.print("\t" + string);
            }
            System.out.println();
        }
    }
}
