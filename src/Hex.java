public class Hex {
    //Champs
    Integer event;          //indice du score minimal pour lancer un event
    Boolean hunt;       // droit de chasser
    Boolean fodder;     // droit de manger
    Integer type;

    String AbsOrd;              // id de la case
    Integer monument;           //id du monument

    // Constructor
    public Hex(String loc)
    {
        this.AbsOrd = loc;
    }

}
