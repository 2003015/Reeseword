package club.theexperiment.reeseword;

public class dNumber extends Die {
    //Creates object of Die class and sets number of dice and sides
    public dNumber(){
        setSides(10);
    }

    public void roll(int r) {
        String temp = "";
        super.roll(r);
        for (int i = 0; i < getRolls().length; i++) {
            for (int x = 0; x < getRolls()[i]; x++) {
                temp += Integer.toString(i);
            }
        }
        setWord(temp);
    }
} 
