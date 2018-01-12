package Personnages;

//Classe pour définir les personnages
//
public class Character {
    private Integer combat; //indice de combativité
    private Integer initcombat; //indice de combativité initial
    private Integer endurance; //indice d'endurance
    private Integer initEndurance; //indice d'endurance initial
    private Integer wealth; //indice de richesse
    private Integer mount; //monture : 1: à pied, 2: sur monture, 3: sur monture ailée
    private Integer loads; //poids qu'il peut porter
    private Integer identifiant;

    //Indice de combat actuel
    public Integer getCombat() {
        return combat;
    }
    public void setCombat(Integer combat) {
        this.combat = combat;
    }
    public Integer getInitcombat() {return initcombat;}
    public void setInitcombat(Integer initcombat) { this.initcombat = initcombat; }

    //Endurance
    public Integer getEndurance() {
        return endurance;
    }
    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }
    public Integer getInitEndurance() { return initEndurance; }
    public void setInitEndurance(Integer initEndurance) { this.initEndurance = initEndurance; }

    //Wealth
    public Integer getWealth() {
        return wealth;
    }
    public void setWealth(Integer wealth) {
        this.wealth = wealth;
    }

    //Mount
    public Integer getMount() {
        return mount;
    }
    public void setMount(Integer mount) {
        this.mount = mount;
    }

    //Identifiant
    public Integer getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    //Loads
    public Integer getLoads() {
        return loads;
    }

    public void setLoads(Integer mount) { //ATTENTION, Loads est fonction util.util la monture !
        if (mount<2)
            this.loads = 10; //capacité util.util 10 sans monture
        else
            this.loads = 40; //capacité util.util 40 avec monture
    }




}




