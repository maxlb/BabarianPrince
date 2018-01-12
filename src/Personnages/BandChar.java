package Personnages;

public class BandChar extends Character {

    private Integer characterNumber;

    public BandChar(){

    }

    public BandChar(String hisname, Integer id, Integer hisloads,
                    Integer hismount, Integer hiswealth, Integer hisendurance,
                    Integer hiscombat, Integer characterNumber){
        this.setCombat(hiscombat * characterNumber);
        this.setInitcombat(hiscombat * characterNumber);
        this.setEndurance(hisendurance * characterNumber);
        this.setWealth(hiswealth * characterNumber);
        this.setMount(hismount);
        this.setIdentifiant(id);
        this.setLoads(hisloads * characterNumber);
        this.setName(hisname);
        this.setCharacterNumber(characterNumber);
    }

    public Integer getCharacterNumber() {
        return characterNumber;
    }
    public void setCharacterNumber(Integer newBandNumber) {
        this.characterNumber = newBandNumber;
    }
}

