package club.theexperiment.reeseword;

public class dSymbol extends Die {
    //Creates object of Die class and sets number of dice and sides
    public dSymbol(){
        setSides(31);
    }

    String options = "~!@#$%^&*()_+-=[]{}\"|';:/\\?.>,<";

    public void roll(int r) {
        String temp = "";
        super.roll(r);
        for (int i = 0; i < getRolls().length; i++) {
            for (int x = 0; x < getRolls()[i]; x++) {
                temp += options.substring(i, i+1);
            }
        }
        setWord(temp);
    }
}
