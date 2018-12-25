import java.util.ArrayList;

public class BattleshipGame {

public static void main(String[] args) {
    int numOfGuesses = 0;
    GameHelper helper = new GameHelper();
    Battleship Battle = new Battleship();

    int randomNum = (int) (Math.random()*5);
    ArrayList<String> locations = new ArrayList<String>();
    String r1 = Integer.toString(randomNum);
    String r2 = Integer.toString(randomNum+1);
    String r3 = Integer.toString(randomNum+2);
    locations.add(r1);
    locations.add(r2);
    locations.add(r3);
    Battle.setLocationCells(locations);

    boolean isAlive = true;

    while(isAlive == true) {
        String guess = helper.getUserInput("enter a number");
        String result = Battle.checkYourself(guess);
        numOfGuesses++;
        if (result.equals("kill")) {
            isAlive = false;
            System.out.println("You took " + numOfGuesses + " guesses, to" + "destroy the Battleship");
        }
      }
    }
}
