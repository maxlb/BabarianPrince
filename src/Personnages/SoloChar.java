package Personnages;

public class SoloChar extends Character {
    private Integer combat; //indice de combativité en cours
    private Integer initcombat; //indice de combativité initial
    private Integer endurance; //indice d'endurance
    private Integer wealth; //indice util.util richesse
    private Integer mount; //monture : 1: à pied, 2: sur monture, 3: sur monture ailée
    private Integer loads; //poids qu'il peut porter
    private Integer identifiant;
    private String name;

    public SoloChar(String hisname, Integer id, Integer hisloads,
                    Integer hismount, Integer hiswealth, Integer hisendurance, Integer hiscombat){
        this.combat = hiscombat;
        this.initcombat = hiscombat;
        this.endurance = hisendurance;
        this.wealth = hiswealth;
        this.mount = hismount;
        this.name= hisname;
        this.identifiant= id;
        this.loads= hisloads;
    }

    public String getName() {
        return name;
    }
}
