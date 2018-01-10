public class game {
    //Parameters
    private Integer timeTrack;
    private Integer Gold;
    private Integer Food;
    private Integer TotalLoad;
    private Boolean Status; //true : jeu en cours / False : game over

    //Constructors
    public game(){
        this.timeTrack = 70;
        this.Gold = 0;
        this.Food=0;
        this.TotalLoad = 0;
        this.Status=true;
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
    public Boolean getStatus() {
        if (this.timeTrack>0 && this.Gold<500)
            this.Status=true;
        else
            this.Status=false;
        return Status;
    }

    //TimeTrack

    public Integer getTimeTrack() {
        return timeTrack;
    }

    public void setTimeTrack(Integer timeTrack) {
        this.timeTrack = timeTrack;
    }
}
