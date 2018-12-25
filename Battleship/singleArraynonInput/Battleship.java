import java.util.ArrayList;

class Battleship {

  private ArrayList<String> locationCells = new ArrayList<>();

  public void setLocationCells(ArrayList<String> loc) {
    locationCells.clear();

    if (loc != null) {
      locationCells.addAll(loc);
    }
  }

  public String checkYourself(String userInput){

    String result = "miss";

    int index = locationCells.indexOf(userInput);

    if (index >= 0) {
      locationCells.remove(index);

      if (locationCells.isEmpty()) {
        result = "kill";
      } else {
        result = "hit";
      }
    }
    System.out.println(result);
    return result;
  }
}
