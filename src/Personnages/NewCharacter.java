package Personnages;

public class NewCharacter extends Character {


    public NewCharacter()
    {}

    public NewCharacter(String hisname, Integer hisloads,
                        Integer hismount, Integer hiswealth, Integer hisendurance,
                        Integer hiscombat, Integer characterNumber){
        this.setCombat(hiscombat * characterNumber);
        this.setInitcombat(hiscombat * characterNumber);
        this.setEndurance(hisendurance * characterNumber);
        this.setWealth(hiswealth * characterNumber);
        this.setMount(hismount);
        this.setLoads(hisloads * characterNumber);
        this.setName(hisname);
        this.setCharacterNumber(characterNumber);
    }

    //FEED
    public void Feed(){
        if(this.getCombat() < this.getInitcombat()) {
            this.setCombat( this.getCombat() +1);
        }
        if(this.getLoads()<10)
            this.setLoads( this.getLoads() + 1);
    }

    //STARVE
    // if a character goes, without food for a day,
    // his ability to carry loads and his combat skill
    // is reduced by one. If he goes without food again, load carrying
    // and combat skill is reduced again. When food is available and eaten again,
    // each day's normal meal also eliminates the effect of one day of starvation.
    public void Starve(){
        if(this.getCombat()>0)
            this.setCombat(this.getCombat() -1);
        if(this.getLoads()>0)
            this.setLoads(this.getLoads() -1);
    }

    //HEAL
    public void Heal(){
        if (this.getEndurance() < this.getInitEndurance())
            setEndurance(getEndurance() +1);
    }

    //HUNT
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
