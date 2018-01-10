import java.util.Map;

class main {
    public static void main(String[] args) {

        Map<String, Integer> monTerrain = Init.InitTypeTerrain();

        Hex caseActuelle = Init.GetTypeTerrain("0205", monTerrain);

    }
}