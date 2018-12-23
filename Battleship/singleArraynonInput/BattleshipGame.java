class BattleshipGame {

  public static void main(String[] args) {
    Battleship battle = new Battleship();

    int[] locations = {2,3,4};
    battle.setLocationCells(locations);

    String userGuess = "2";
    String result = battle.checkYourself(userGuess);
  }
  
}
