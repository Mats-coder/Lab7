import java.util.Arrays;

public class Die {
    String[] sides;
    String thisSideUp;
    public Die(){
        this.sides = new String[6];
        Arrays.fill(sides, ".");
        this.sides[0] = "C";
        this.sides[1] = "R";
        this.sides[2] = "L";
    }
    public String rollDie(){
        int rand = (int)(Math.random()*6);
        thisSideUp = this.sides[rand];
        return this.sides[rand];
    }

    @Override
    public String toString(){
        return thisSideUp;
    }
}
