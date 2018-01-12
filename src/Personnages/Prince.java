package Personnages;

public class Prince extends Character {

    private Integer combat = 8; //indice de combativité en cours
    private Integer initcombat = 8; //indice de combativité initial
    private Integer endurance = 9; //indice d'endurance
    private Integer wealth = 2; //indice util.util richesse
    private Integer mount = 1; //monture : 1: à pied, 2: sur monture, 3: sur monture ailée
    private Integer loads = 10; //poids qu'il peut porter
    private Integer identifiant = 0;


    public int Hunt() {
        //Total his combat skill and half (Vz) his current endurance (his endurance minus wounds),
        // round fractions down, and then subtract from that the roll of two dice.
        // The result is the number of food units gained by hunting.
        int de = util.de.randomDice();
        int hunt = ((combat + (endurance / 2)) - de);
        System.out.println("votre indice random de chasse = " + hunt);

        //If the dice roll was "12" exactly, the hunter himself was hurt,
        // regardless of success or failure, roll one die for the number of wounds he suffered.
        // If knocked unconscious or killed, the hunt automatically fails and the hunter dies.
        if (de == 12) {
            int hurt = util.de.randomDie();
            this.endurance = this.endurance - hurt;
            if (this.endurance <= 0)
                hunt = -1; } //perdu
        else if (hunt <= 0) //If the total is zero or less, then the hunting was unsuccessful
            hunt = 0;

        return hunt;
    }
}







