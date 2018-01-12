import Personnages.SoloChar;
import java.util.ArrayList;

public class game {
    //Parameters
    private Integer timeTrack;
    private Integer Gold;
    private Integer Food; //unité util.util nourriture disponible
    private Integer TotalLoad;
    private Boolean Status; //true : jeu en cours / False : game over
    private String currentCase; //case actuelle du jeu
    private ArrayList suite = new ArrayList(); //Liste des personnages présents dans la suite du prince
    private Integer suiteLoad; //capacité de portage util.util la suite
    private Integer suiteFood; //besoin en nourriture util.util la suite du Prince

    //Constructors
    // Au début util.util jeu, il reste 70 tours, on a 2 pièces d'or (donc 1 load à porter)
    public game(){
        this.timeTrack = 70;
        this.Gold = 2;
        this.Food = 5;
        this.TotalLoad = 1;
        this.Status = true;
        this.suite.add(0); //le premier membre util.util la suite est le Prince lui-même !
        this.suiteLoad = 10;
        this.suiteFood = 1;
    }


    //Gold

    public Integer getGold() {
        return Gold;
    }
    public void setGold(Integer gold) {
        Gold = gold;
    }

    //Food
    public Integer getFood() {
        return Food;
    }
    public void setFood(Integer food) {
        Food = food;
    }

    // Total Load : chaque point Food vaut 1, 100 pièces ou moins vaut 1
    public Integer getTotalLoad(){
        int goldLoad = this.Gold/100;
        if(this.Gold==0)
            this.TotalLoad= this.Food;
        else
            this.TotalLoad= this.Food + goldLoad;
        return TotalLoad;
    }

    //Status
    // Le jeu est terminé si
    // Le temps est écoulé : timeTrack <= 0
    // Le prince a récolté 50 pièces d'or : Gold >=500
    // L'endurance du prince est épuisée :
    public Boolean getStatus() {
        if (this.timeTrack<=0 || this.Gold>=500)
            this.Status=false;
        else
            this.Status=true;
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    //TimeTrack

    public Integer getTimeTrack() {
        return timeTrack;
    }

    public void setTimeTrack(Integer timeTrack) {
        this.timeTrack = timeTrack;
    }

    //Current Case

    public String getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(String currentCase) {
        this.currentCase = currentCase;
    }

    //Suite

    public ArrayList getSuite(){
        return suite;
        }

    public void setSuite(Integer newCharacterId){
        //ajout d'un personnage dans la suite du prince
        this.suite.add(newCharacterId);
    }

    public void removeSuite(Integer newCharacterId){
        //suppression d'un personnage dans la suite du prince
        this.suite.remove(newCharacterId);
    }

    public Integer getSuiteLoad(){
        // à calculer en fonction de la suite
        return suiteLoad;
    }

    public void setSuiteLoad(Integer newLoad){
        this.suiteLoad= newLoad;
    }

    public Integer getSuiteFood() {
        suiteFood = this.suite.size(); //1 unité par personne
        return suiteFood;
    }

    public void setSuiteFood(Integer suiteFood) {
        this.suiteFood = suiteFood;
    }


    //GESTION DE LA NOURRITURE EN FIN DE TOUR

    // 1 food unit par personne (avec ou sans monture) (règle simplifiée)
    // si dans le desert sans oasis 2 food unit par personne
    //calcul du besoin en nourriture
    public Integer FoodNeed(Hex macase){
        int Foodneed = 0;
        if(macase.type==6 && macase.monument!=5)
    Foodneed = this.suiteFood*2;
            else
    Foodneed = this.suiteFood;
    return Foodneed;
    }

    //AJOUT D'UN PERSONNAGE DANS LA SUITE
    public void AddCharacter(SoloChar newCharacter){
        this.setGold( this.getGold() + newCharacter.getWealth());
        this.setSuiteLoad( this.getSuiteLoad() + newCharacter.getLoads() ) ;
        this.setSuite(newCharacter.getIdentifiant());
        if (newCharacter.getMount()==1)
            this.setSuiteFood( this.getSuiteFood() + 1);
        else
            this.setSuiteFood( this.getSuiteFood() +2);
    }
}