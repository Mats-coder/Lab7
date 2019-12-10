import java.util.Arrays;
import java.util.Scanner;


/**
 * This class is a skeleton. Don't change the overall
 * structure but just uncomment and add code where needed.
 */
public class CommandLineLCR {



  public static void main(String[] args) {
    // Use this as an test area when starting out
    // I.e. instantiate objects and test
    // Later just comment out (don't erase the test code!)
    LCRGame lcr = new LCRGame("Anna", "Benny", "Gunnar");
    GraphicalCR GraphicalLCR = new GraphicalCR(lcr);









    // TODO: Uncomment this when you are done
    //runCommandLineLCR();
  }

  // TODO: For each class you implement, add a method here to test it.
  // private static void testXXX() { ... }
  public static Die testDie(){
    Die die = new Die();
    die.rollDie();
    return die;
  }
  public static void testPlayer(){
    Die[] die = new Die[3];
    for (int i = 0; i < 3; i++){
      die[i]= new Die();
    }
    Player Glenn = new Player("Glenn",die, 3);
    System.out.println(Arrays.toString(Glenn.playerRoll(Glenn.getChips())));
  }



  // TODO: Uncomment below when possible
  public static void runCommandLineLCR() {

    LCRGame lcr = buildLCRGame();
    int i = 0;
    System.out.println("LCR started");
    render(lcr);

    Scanner s = new Scanner(System.in);

    boolean done = false;
    while (!done) {
      if (!lcr.checkForWinner()) {
          System.out.println("Current player is " + lcr.players[i].name);
          System.out.print("> ");
          String cmd = s.nextLine();
          switch (cmd) {
              case "r":
                  lcr.playTurn(i);
                  render(lcr);
                  i++;
                  if (i > 2) {
                      i = 0;
                  }
                  break;
              case "q":
                  done = true;
                  break;
              default:
                  System.out.println("Enter 'r' to continue or 'q' to quit");
          }
      } else {
          done = true;
          break;
      }
    }

    if (lcr.checkForWinner()) {
      System.out.println("Game over! Winner is " + lcr.getWinner());
    } else {
      System.out.println("Game aborted");
      render(lcr);
    }
  }

  private static LCRGame buildLCRGame() {
    LCRGame lcr = new LCRGame("Anna", "Pernilla", "Gunnar");
    return lcr;
  }


    public static void render(LCRGame lcr) {

    for (Die d : lcr.getGameDice(lcr.previousChips)) {
        if (d.thisSideUp != null)
            System.out.print(d + "  ");
        else
            continue;
    }
    System.out.println();
    System.out.print("Players: ");
    for (Player p : lcr.getPlayers()) {
      System.out.print(p + " ("+p.chips+" chips) ");
    }
    System.out.println();
  }


}
