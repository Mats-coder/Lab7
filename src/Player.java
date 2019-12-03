import java.util.Arrays;

public class Player {
    int chips;
    String name;
    Die[] die;
    public Player(String name,Die[] die,int chips){
        this.name = name;
        this.die = die;
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }


    public String[] playerRoll(int chips){
        String[] results = new String[chips];
        if (chips > 3){
            results = new String[3];
        }
        for (int i = 0; i < chips && i < 3 ; i++){
            results[i] = (die[i].rollDie());
        } return results;

    }

    @Override
    public String toString() {
        return this.name;
    }
}
