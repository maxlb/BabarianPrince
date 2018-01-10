import java.util.HashMap;
import java.util.Map;

public class Init {

    public static Map<String, Integer> InitTypeTerrain(){

        Map<String, Integer>  typeTerrain = new HashMap<>();

        typeTerrain.put("0204", 1);
        typeTerrain.put("0254", 2);

        return typeTerrain;
    }

    public static Hex GetTypeTerrain(String loc,  Map<String, Integer> terrain){
        Hex maCase = new Hex(loc);
        Integer type = terrain.get(loc);

        if(type != null){
            switch (type)
            {
                case 1:
                    maCase.event = 9;          //indice du score minimal pour lancer un event
                    maCase.hunt = false;       // droit de chasser
                    maCase.fodder = false;     // droit de manger
                    maCase.type = 1;
                    break;
                default:
                    break;
            }
        }
        return maCase;
    }
}
