package Personnages;


public class Prince extends NewCharacter {

    public Prince(){
        this.setCombat(8);
        this.setInitcombat(8);
        this.setEndurance(9);
        this.setInitEndurance(9);
        this.setWealth(2);
        this.setMount(1);
        this.setIdentifiant(0);
        this.setLoads(10);
        this.setName("Cal Arath");
    }


    public int Hunt() {
        //Total his combat skill and half (Vz) his current endurance (his endurance minus wounds),
        // round fractions down, and then subtract from that the roll of two dice.
        // The result is the number of food units gained by hunting.
        int de = util.de.randomDice();
        int hunt = ((this.getCombat() + (this.getEndurance() / 2)) - de);

        //If the dice roll was "12" exactly, the hunter himself was hurt,
        // regardless of success or failure, roll one die for the number of wounds he suffered.
        // If knocked unconscious or killed, the hunt automatically fails and the hunter dies.
        if (de == 12) {
            int hurt = util.de.randomDie();
            this.setEndurance(this.getEndurance() - hurt);
            if (this.getEndurance() <= 0)
                hunt = -1; } //perdu
        else if (hunt <= 0) //If the total is zero or less, then the hunting was unsuccessful
            hunt = 0;

        return hunt;
    }

}







