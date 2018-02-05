package Personnages;


public class Prince extends NewCharacter {

    public Prince(){
        this.setCombat(8);
        this.setInitcombat(8);
        this.setEndurance(9);
        this.setInitEndurance(9);
        this.setWealth(2);
        this.setMount(1);
        this.setLoads(10);
        this.setName("Cal Arath");
    }


    public int Hunt() {
        //Total his combat skill and half (Vz) his current endurance (his endurance minus wounds),
        // round fractions down, and then subtract from that the roll of two dice.
        // The result is the number of food units gained by hunting.

        int de = util.de.randomDice();
        int hunt = ((this.getCombat() + (this.getEndurance() / 2)) - de);



}







