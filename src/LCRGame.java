import java.util.Arrays;

public class LCRGame {
    Player[] players = new Player[3];
    Die[] dice = new Die[3];
    int chipsPot = 0;
    int previousChips;
    public LCRGame(String name1, String name2, String name3){
        for (int i = 0; i < 3; i++){
            dice[i]= new Die();
        }
        players[0] = new Player(name1, dice,3);
        players[1] = new Player(name2, dice,3);
        players[2] = new Player(name3, dice,3);
    }

    public Die[] getGameDice(int i) {
        Die[] currentDice;
        if (i < 3) {
            currentDice = new Die[i];
        } else {
            currentDice = new Die[3];
        }
        for (int k = 0; k < i && k < 3; k++){
            currentDice[k] = dice[k];
        }
        return currentDice;
    }

    public Player[] getPlayers() {
        return players;
    }
    public void playTurn(int i){

        players[i].playerRoll(players[i].chips);
        previousChips = players[i].chips;
        for(Die d: getGameDice(players[i].chips)){
            if (d.thisSideUp == "C"){
                players[i].chips -= 1;

            } else if (d.thisSideUp == "R"){
                players[i].chips -= 1;
                if (i == 0){
                    players[1].chips+=1;
                } else if (i == 1){
                    players[2].chips+=1;
                } else {
                    players[0].chips+=1;
                }
            } else if (d.thisSideUp == "L"){
                players[i].chips -= 1;
                if (i == 0){
                    players[2].chips+=1;
                } else if (i == 1){
                    players[0].chips+=1;
                } else {
                    players[1].chips+=1;
                }
            }
        }
    }

    public boolean checkForWinner(){
        int playersLeft = 0;
        for (int i = 0; i < players.length; i++){
            if (players[i].chips > 0){
                playersLeft += 1;
            } else {
                continue;
            }
        }
        if (playersLeft < 2){
            return true;
        } else {
            return false;
        }
    }

    public Player getWinner(){
        Player winner = players[0];
        for (int i = 0; i < players.length; i++){
            if (players[i].chips > 0){
                winner = players[i];
            } else {
                continue;
            }
        }
        return winner;
    }


}


