package Personnages;

public class NewCharacter extends Character {


    public NewCharacter()
    {}

    public NewCharacter(String hisname, Integer id, Integer hisloads,
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



}
