package club.theexperiment.reeseword;

public class dLower extends Die {
    //Creates object of Die class and sets number of dice and sides
    public dLower(){
        setSides(26);
    }

    String options = "abcdefghijklmnopqrstuvwxyz";

    public void roll(int r) {
        String temp = "";
        super.roll(r);
        for (int i: getRolls()) {
            for (int x = 0; x < i; x++) {
                temp += options.substring(i, i+1);
            }
        }
        setWord(temp);
    }
}