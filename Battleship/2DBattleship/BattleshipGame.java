import java.util.*;

public class BattleshipGame {

  private GameHelper helper = new GameHelper() ;
  private ArrayList<Battleship> BattleshipList = new ArrayList<Battleship>() ;
  private int numOfGuesses = 0 ;

  private void setUpGame() {
    Battleship one = new Battleship() ;
    one.setName("Pacifis") ;
    Battleship two = new Battleship() ;
    two.setName("Atlantis") ;
    Battleship three = new Battleship() ;
    three.setName("Indis") ;
    BattleshipList.add(one) ;
    BattleshipList.add(two) ;
    BattleshipList.add(three) ;

    System.out.println("Your goal is to sink three Battleships.") ;
    System.out.println("Pacifis, Atlantis, Indis") ;
    System.out.println("Try to sink them all in the fewest number of guesses") ;

    for (Battleship BattleshipToSet : BattleshipList) {
      ArrayList<String> newLocation = helper.placeBattleship(3) ;
      BattleshipToSet.setLocationCells(newLocation) ;
    }
  }

  private void startPlaying() {
    while (!BattleshipList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess") ;
      checkUserGuess(userGuess) ;
    }
    finishGame() ;
  }

  private void checkUserGuess(String userGuess) {

    numOfGuesses++ ;
    String result = "miss" ;

    for (Battleship BattleshipTest : BattleshipList) {
      result = BattleshipTest.checkYourself(userGuess) ;
      if (result.equals("hit")) {
        break ;
      }
      if (result.equals("kill")) {
        BattleshipList.remove(BattleshipTest) ;
        break ;
      }
    }
    System.out.println(result) ;
  }

  private void finishGame() {
    System.out.println("All Battleships are destroyed! Your stockpile is now worthless.") ;
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.") ;
      System.out.println(" You got out before your options sank.") ;
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.") ;
      System.out.println("Fish are dancing with your options.");
    }
  }

  public static void main(String[] args) {
    BattleshipGame game = new BattleshipGame() ;
    game.setUpGame() ;
    game.startPlaying() ;
  }
  
}
