package Personnages;

public class SoloChar extends Character {


    public SoloChar()
    {}

    public SoloChar(String hisname, Integer id, Integer hisloads,
                    Integer hismount, Integer hiswealth, Integer hisendurance, Integer hiscombat){
        this.setCombat(hiscombat);
        this.setInitcombat(hiscombat);
        this.setEndurance(hisendurance);
        this.setWealth(hiswealth);
        this.setMount(hismount);
        this.setIdentifiant(id);
        this.setLoads(hisloads);
        this.setName(hisname);
    }


}
