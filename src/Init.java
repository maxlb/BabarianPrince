import java.util.HashMap;
import java.util.Map;

public class Init {

    public static Map<String, Integer> InitRoute(){
        Map<String, Integer> isRoute = new HashMap<>();

        /* si route : 1
        sinon : 0
         */

        isRoute.put("0109",1);
        isRoute.put("0216",1);
        isRoute.put("0208",1);
        isRoute.put("0207",1);
        isRoute.put("0317",1);
        isRoute.put("0318",1);
        isRoute.put("0319",1);
        isRoute.put("0322",1);
        isRoute.put("0323",1);
        isRoute.put("0419",1);
        isRoute.put("0420",1);
        isRoute.put("0421",1);
        isRoute.put("0422",1);
        isRoute.put("0520",1);
        isRoute.put("0619",1);
        isRoute.put("0719",1);
        isRoute.put("0816",1);
        isRoute.put("0817",1);
        isRoute.put("0818",1);
        isRoute.put("0819",1);
        isRoute.put("0820",1);
        isRoute.put("0921",1);
        isRoute.put("0916",1);
        isRoute.put("1009",1);
        isRoute.put("1011",1);
        isRoute.put("1109",1);
        isRoute.put("1112",1);
        isRoute.put("1113",1);
        isRoute.put("1213",1);
        isRoute.put("1314",1);
        isRoute.put("1316",1);
        isRoute.put("1317",1);
        isRoute.put("1318",1);
        isRoute.put("1319",1);
        isRoute.put("1320",1);
        isRoute.put("1420",1);
        isRoute.put("1415",1);
        isRoute.put("1520",1);
        isRoute.put("1515",1);
        isRoute.put("1614",1);
        isRoute.put("1619",1);
        isRoute.put("1720",1);
        isRoute.put("1714",1);
        isRoute.put("1803",1);
        isRoute.put("1806",1);
        isRoute.put("1813",1);
        isRoute.put("1819",1);
        isRoute.put("1820",1);
        isRoute.put("1923",1);
        isRoute.put("1921",1);
        isRoute.put("1919",1);
        isRoute.put("1911",1);
        isRoute.put("1905",1);
        isRoute.put("1904",1);
        isRoute.put("2010",1);
        isRoute.put("2018",1);
        isRoute.put("2021",1);
        isRoute.put("2022",1);

        return isRoute;
    }


    public static Map<String, Integer> InitMonument() {

        Map<String, Integer> isMonument = new HashMap<>();

        /*Initialisation des emplacements de monuments
        Temples :       code 1
        Ruins :         code 2
        Castles :       code 3
        Towns :         code 4
        Oasis :         code 5
        */

        isMonument.put("0101", 4); // Town Ogon
        isMonument.put("0109", 4); // Town Angleae
        isMonument.put("0206", 5); // Oasis
        isMonument.put("0207", 2); // Ruins
        isMonument.put("0323", 3); // Drogat Castles
        isMonument.put("0419", 4); // Town Halowich
        isMonument.put("0422", 4); // Lower Drogat
        isMonument.put("0711", 1); // Branwyns Temple
        isMonument.put("0719", 4); // Town Brigud
        isMonument.put("0901", 2); // Ruins of Jakors Keep
        isMonument.put("0916", 4); // Town Erwyn
        isMonument.put("1004", 4); // Town Cumry
        isMonument.put("1009", 4); // Town Cawther
        isMonument.put("1212", 3); // Huldra Castle
        isMonument.put("1309", 1); // Temple Donats
        isMonument.put("1409", 5); // Oasis
        isMonument.put("1415", 4); // Town Tulith
        isMonument.put("1501", 4); // Town Weshor
        isMonument.put("1607", 5); // Oasis
        isMonument.put("1609", 5); // Oasis
        isMonument.put("1720", 4); // Town Lullwyn
        isMonument.put("1923", 3); // Aeravir Castle
        isMonument.put("2009", 2); // Ruins of Pelgar
        isMonument.put("2018", 1); // Temple of Duffyd

        return isMonument;
    }

    public static Map<String, Integer> InitTypeTerrain() {

        Map<String, Integer> typeTerrain = new HashMap<>();

        /* Initialisation util.util la Map
        Open CountrySide :  code 1
        FarmLand :          code 2
        Forest :            code 3
        Hills :             code 4
        Mountains :         code 5
        Desert :            code 6
        Swamp :             code 7
        */

        //colonne 20
        typeTerrain.put("2023", 2);
        typeTerrain.put("2022", 2);
        typeTerrain.put("2021", 2);
        typeTerrain.put("2020", 3);
        typeTerrain.put("2019", 1);
        typeTerrain.put("2018", 1);
        typeTerrain.put("2017", 3);
        typeTerrain.put("2016", 7);
        typeTerrain.put("2015", 3);
        typeTerrain.put("2014", 1);
        typeTerrain.put("2013", 4);
        typeTerrain.put("2012", 5);
        typeTerrain.put("2011", 5);
        typeTerrain.put("2010", 4);
        typeTerrain.put("2009", 4);
        typeTerrain.put("2008", 5);
        typeTerrain.put("2007", 4);
        typeTerrain.put("2006", 5);
        typeTerrain.put("2005", 4);
        typeTerrain.put("2004", 1);
        typeTerrain.put("2003", 4);
        typeTerrain.put("2002", 5);
        typeTerrain.put("2001", 5);

        //colonne 19
        typeTerrain.put("1923", 2);
        typeTerrain.put("1922", 2);
        typeTerrain.put("1921", 2);
        typeTerrain.put("1920", 3);
        typeTerrain.put("1919", 1);
        typeTerrain.put("1918", 1);
        typeTerrain.put("1917", 3);
        typeTerrain.put("1916", 3);
        typeTerrain.put("1915", 1);
        typeTerrain.put("1914", 1);
        typeTerrain.put("1913", 4);
        typeTerrain.put("1912", 4);
        typeTerrain.put("1911", 1);
        typeTerrain.put("1910", 5);
        typeTerrain.put("1909", 5);
        typeTerrain.put("1908", 5);
        typeTerrain.put("1907", 5);
        typeTerrain.put("1906", 1);
        typeTerrain.put("1905", 1);
        typeTerrain.put("1904", 4);
        typeTerrain.put("1903", 5);
        typeTerrain.put("1902", 5);
        typeTerrain.put("1901", 5);

        //colonne 18
        typeTerrain.put("1823", 1);
        typeTerrain.put("1822", 2);
        typeTerrain.put("1821", 1);
        typeTerrain.put("1820", 1);
        typeTerrain.put("1819", 1);
        typeTerrain.put("1818", 4);
        typeTerrain.put("1817", 3);
        typeTerrain.put("1816", 7);
        typeTerrain.put("1815", 3);
        typeTerrain.put("1814", 1);
        typeTerrain.put("1813", 4);
        typeTerrain.put("1812", 4);
        typeTerrain.put("1811", 4);
        typeTerrain.put("1810", 5);
        typeTerrain.put("1809", 5);
        typeTerrain.put("1808", 4);
        typeTerrain.put("1807", 5);
        typeTerrain.put("1806", 5);
        typeTerrain.put("1805", 5);
        typeTerrain.put("1804", 5);
        typeTerrain.put("1803", 1);
        typeTerrain.put("1802", 5);
        typeTerrain.put("1801", 5);

        //colonne 17
        typeTerrain.put("1723", 1);
        typeTerrain.put("1722", 3);
        typeTerrain.put("1721", 7);
        typeTerrain.put("1720", 1);
        typeTerrain.put("1719", 4);
        typeTerrain.put("1718", 1);
        typeTerrain.put("1717", 3);
        typeTerrain.put("1716", 3);
        typeTerrain.put("1715", 4);
        typeTerrain.put("1714", 1);
        typeTerrain.put("1713", 4);
        typeTerrain.put("1712", 5);
        typeTerrain.put("1711", 4);
        typeTerrain.put("1710", 6);
        typeTerrain.put("1709", 4);
        typeTerrain.put("1708", 6);
        typeTerrain.put("1707", 6);
        typeTerrain.put("1706", 5);
        typeTerrain.put("1705", 5);
        typeTerrain.put("1704", 1);
        typeTerrain.put("1703", 5);
        typeTerrain.put("1702", 4);
        typeTerrain.put("1701", 4);

        //colonne 16
        typeTerrain.put("1623", 7);
        typeTerrain.put("1622", 7);
        typeTerrain.put("1621", 3);
        typeTerrain.put("1620", 1);
        typeTerrain.put("1619", 1);
        typeTerrain.put("1618", 3);
        typeTerrain.put("1617", 7);
        typeTerrain.put("1616", 1);
        typeTerrain.put("1615", 1);
        typeTerrain.put("1614", 1);
        typeTerrain.put("1613", 1);
        typeTerrain.put("1612", 4);
        typeTerrain.put("1611", 5);
        typeTerrain.put("1610", 4);
        typeTerrain.put("1609", 6);
        typeTerrain.put("1608", 6);
        typeTerrain.put("1607", 6);
        typeTerrain.put("1606", 6);
        typeTerrain.put("1605", 5);
        typeTerrain.put("1604", 3);
        typeTerrain.put("1603", 5);
        typeTerrain.put("1602", 1);
        typeTerrain.put("1601", 2);

        //colonne 15
        typeTerrain.put("1523", 7);
        typeTerrain.put("1522", 7);
        typeTerrain.put("1521", 3);
        typeTerrain.put("1520", 3);
        typeTerrain.put("1519", 3);
        typeTerrain.put("1518", 3);
        typeTerrain.put("1517", 3);
        typeTerrain.put("1516", 1);
        typeTerrain.put("1515", 2);
        typeTerrain.put("1514", 1);
        typeTerrain.put("1513", 1);
        typeTerrain.put("1512", 4);
        typeTerrain.put("1511", 4);
        typeTerrain.put("1510", 6);
        typeTerrain.put("1509", 6);
        typeTerrain.put("1508", 6);
        typeTerrain.put("1507", 6);
        typeTerrain.put("1506", 5);
        typeTerrain.put("1505", 5);
        typeTerrain.put("1504", 3);
        typeTerrain.put("1503", 3);
        typeTerrain.put("1502", 7);
        typeTerrain.put("1501", 2);

        //colonne 14
        typeTerrain.put("1423", 7);
        typeTerrain.put("1422", 7);
        typeTerrain.put("1421", 7);
        typeTerrain.put("1420", 1);
        typeTerrain.put("1419", 3);
        typeTerrain.put("1418", 1);
        typeTerrain.put("1417", 3);
        typeTerrain.put("1416", 1);
        typeTerrain.put("1415", 2);
        typeTerrain.put("1414", 2);
        typeTerrain.put("1413", 3);
        typeTerrain.put("1412", 4);
        typeTerrain.put("1411", 4);
        typeTerrain.put("1410", 6);
        typeTerrain.put("1409", 6);
        typeTerrain.put("1408", 6);
        typeTerrain.put("1407", 4);
        typeTerrain.put("1406", 4);
        typeTerrain.put("1405", 4);
        typeTerrain.put("1404", 3);
        typeTerrain.put("1403", 1);
        typeTerrain.put("1402", 1);
        typeTerrain.put("1401", 7);

        //colonne 13
        typeTerrain.put("1323", 1);
        typeTerrain.put("1322", 1);
        typeTerrain.put("1321", 1);
        typeTerrain.put("1320", 1);
        typeTerrain.put("1319", 1);
        typeTerrain.put("1318", 1);
        typeTerrain.put("1317", 1);
        typeTerrain.put("1316", 2);
        typeTerrain.put("1315", 1);
        typeTerrain.put("1314", 1);
        typeTerrain.put("1313", 5);
        typeTerrain.put("1312", 3);
        typeTerrain.put("1311", 5);
        typeTerrain.put("1310", 6);
        typeTerrain.put("1309", 6);
        typeTerrain.put("1308", 6);
        typeTerrain.put("1307", 5);
        typeTerrain.put("1306", 4);
        typeTerrain.put("1305", 1);
        typeTerrain.put("1304", 3);
        typeTerrain.put("1303", 1);
        typeTerrain.put("1302", 7);
        typeTerrain.put("1301", 1);

        //colonne 12
        typeTerrain.put("1223", 3);
        typeTerrain.put("1222", 3);
        typeTerrain.put("1221", 1);
        typeTerrain.put("1220", 3);
        typeTerrain.put("1219", 3);
        typeTerrain.put("1218", 3);
        typeTerrain.put("1217", 1);
        typeTerrain.put("1216", 1);
        typeTerrain.put("1215", 4);
        typeTerrain.put("1214", 5);
        typeTerrain.put("1213", 1);
        typeTerrain.put("1212", 5);
        typeTerrain.put("1211", 5);
        typeTerrain.put("1210", 4);
        typeTerrain.put("1209", 4);
        typeTerrain.put("1208", 4);
        typeTerrain.put("1207", 5);
        typeTerrain.put("1206", 5);
        typeTerrain.put("1205", 1);
        typeTerrain.put("1204", 5);
        typeTerrain.put("1203", 4);
        typeTerrain.put("1202", 3);
        typeTerrain.put("1201", 3);

        //colonne 11
        typeTerrain.put("1123", 5);
        typeTerrain.put("1122", 5);
        typeTerrain.put("1121", 5);
        typeTerrain.put("1120", 3);
        typeTerrain.put("1119", 4);
        typeTerrain.put("1118", 1);
        typeTerrain.put("1117", 3);
        typeTerrain.put("1116", 1);
        typeTerrain.put("1115", 1);
        typeTerrain.put("1114", 5);
        typeTerrain.put("1113", 4);
        typeTerrain.put("1112", 4);
        typeTerrain.put("1111", 5);
        typeTerrain.put("1110", 1);
        typeTerrain.put("1109", 4);
        typeTerrain.put("1108", 4);
        typeTerrain.put("1107", 4);
        typeTerrain.put("1106", 5);
        typeTerrain.put("1105", 5);
        typeTerrain.put("1104", 1);
        typeTerrain.put("1103", 7);
        typeTerrain.put("1102", 4);
        typeTerrain.put("1101", 4);

        //colonne 10
        typeTerrain.put("1023", 4);
        typeTerrain.put("1022", 5);
        typeTerrain.put("1021", 5);
        typeTerrain.put("1020", 5);
        typeTerrain.put("1019", 4);
        typeTerrain.put("1018", 3);
        typeTerrain.put("1017", 1);
        typeTerrain.put("1016", 7);
        typeTerrain.put("1015", 7);
        typeTerrain.put("1014", 1);
        typeTerrain.put("1013", 1);
        typeTerrain.put("1012", 1);
        typeTerrain.put("1011", 4);
        typeTerrain.put("1010", 4);
        typeTerrain.put("1009", 2);
        typeTerrain.put("1008", 1);
        typeTerrain.put("1007", 3);
        typeTerrain.put("1006", 5);
        typeTerrain.put("1005", 1);
        typeTerrain.put("1004", 1);
        typeTerrain.put("1003", 4);
        typeTerrain.put("1002", 3);
        typeTerrain.put("1001", 4);

        //colonne 9
        typeTerrain.put("0923", 4);
        typeTerrain.put("0922", 4);
        typeTerrain.put("0921", 1);
        typeTerrain.put("0920", 1);
        typeTerrain.put("0919", 1);
        typeTerrain.put("0918", 3);
        typeTerrain.put("0917", 1);
        typeTerrain.put("0916", 2);
        typeTerrain.put("0915", 3);
        typeTerrain.put("0914", 7);
        typeTerrain.put("0913", 3);
        typeTerrain.put("0912", 4);
        typeTerrain.put("0911", 3);
        typeTerrain.put("0910", 1);
        typeTerrain.put("0909", 1);
        typeTerrain.put("0908", 3);
        typeTerrain.put("0907", 1);
        typeTerrain.put("0906", 1);
        typeTerrain.put("0905", 1);
        typeTerrain.put("0904", 4);
        typeTerrain.put("0903", 3);
        typeTerrain.put("0902", 1);
        typeTerrain.put("0901", 5);

        //colonne 8
        typeTerrain.put("0823", 1);
        typeTerrain.put("0822", 1);
        typeTerrain.put("0821", 1);
        typeTerrain.put("0820", 1);
        typeTerrain.put("0819", 1);
        typeTerrain.put("0818", 1);
        typeTerrain.put("0817", 1);
        typeTerrain.put("0816", 2);
        typeTerrain.put("0815", 3);
        typeTerrain.put("0814", 3);
        typeTerrain.put("0813", 3);
        typeTerrain.put("0812", 3);
        typeTerrain.put("0811", 3);
        typeTerrain.put("0810", 1);
        typeTerrain.put("0809", 3);
        typeTerrain.put("0808", 3);
        typeTerrain.put("0807", 3);
        typeTerrain.put("0806", 4);
        typeTerrain.put("0805", 3);
        typeTerrain.put("0804", 5);
        typeTerrain.put("0803", 3);
        typeTerrain.put("0802", 3);
        typeTerrain.put("0801", 4);

        //colonne 7
        typeTerrain.put("0723", 3);
        typeTerrain.put("0722", 1);
        typeTerrain.put("0721", 3);
        typeTerrain.put("0720", 1);
        typeTerrain.put("0719", 2);
        typeTerrain.put("0718", 1);
        typeTerrain.put("0717", 1);
        typeTerrain.put("0716", 3);
        typeTerrain.put("0715", 3);
        typeTerrain.put("0714", 1);
        typeTerrain.put("0713", 7);
        typeTerrain.put("0712", 3);
        typeTerrain.put("0711", 3);
        typeTerrain.put("0710", 7);
        typeTerrain.put("0709", 3);
        typeTerrain.put("0708", 1);
        typeTerrain.put("0707", 1);
        typeTerrain.put("0706", 1);
        typeTerrain.put("0705", 3);
        typeTerrain.put("0704", 1);
        typeTerrain.put("0703", 5);
        typeTerrain.put("0702", 1);
        typeTerrain.put("0701", 1);

        //colonne 6
        typeTerrain.put("0623", 1);
        typeTerrain.put("0622", 1);
        typeTerrain.put("0621", 1);
        typeTerrain.put("0620", 1);
        typeTerrain.put("0619", 1);
        typeTerrain.put("0618", 2);
        typeTerrain.put("0617", 1);
        typeTerrain.put("0616", 3);
        typeTerrain.put("0615", 1);
        typeTerrain.put("0614", 1);
        typeTerrain.put("0613", 1);
        typeTerrain.put("0612", 1);
        typeTerrain.put("0611", 7);
        typeTerrain.put("0610", 3);
        typeTerrain.put("0609", 7);
        typeTerrain.put("0608", 1);
        typeTerrain.put("0607", 1);
        typeTerrain.put("0606", 6);
        typeTerrain.put("0605", 4);
        typeTerrain.put("0604", 5);
        typeTerrain.put("0603", 5);
        typeTerrain.put("0602", 1);
        typeTerrain.put("0601", 1);

        //colonne 5
        typeTerrain.put("0523", 1);
        typeTerrain.put("0522", 3);
        typeTerrain.put("0521", 1);
        typeTerrain.put("0520", 1);
        typeTerrain.put("0519", 2);
        typeTerrain.put("0518", 3);
        typeTerrain.put("0517", 1);
        typeTerrain.put("0516", 3);
        typeTerrain.put("0515", 1);
        typeTerrain.put("0514", 3);
        typeTerrain.put("0513", 3);
        typeTerrain.put("0512", 1);
        typeTerrain.put("0511", 7);
        typeTerrain.put("0510", 1);
        typeTerrain.put("0509", 3);
        typeTerrain.put("0508", 3);
        typeTerrain.put("0507", 1);
        typeTerrain.put("0506", 4);
        typeTerrain.put("0505", 3);
        typeTerrain.put("0504", 5);
        typeTerrain.put("0503", 5);
        typeTerrain.put("0502", 1);
        typeTerrain.put("0501", 3);

        //colonne 4
        typeTerrain.put("0423", 2);
        typeTerrain.put("0422", 2);
        typeTerrain.put("0421", 3);
        typeTerrain.put("0420", 2);
        typeTerrain.put("0419", 2);
        typeTerrain.put("0418", 2);
        typeTerrain.put("0417", 1);
        typeTerrain.put("0416", 1);
        typeTerrain.put("0415", 1);
        typeTerrain.put("0414", 3);
        typeTerrain.put("0413", 1);
        typeTerrain.put("0412", 1);
        typeTerrain.put("0411", 7);
        typeTerrain.put("0410", 1);
        typeTerrain.put("0409", 3);
        typeTerrain.put("0408", 3);
        typeTerrain.put("0407", 6);
        typeTerrain.put("0406", 4);
        typeTerrain.put("0405", 5);
        typeTerrain.put("0404", 5);
        typeTerrain.put("0403", 5);
        typeTerrain.put("0402", 3);
        typeTerrain.put("0401", 3);

        //colonne 3
        typeTerrain.put("0323", 2);
        typeTerrain.put("0322", 2);
        typeTerrain.put("0321", 1);
        typeTerrain.put("0320", 1);
        typeTerrain.put("0319", 2);
        typeTerrain.put("0318", 1);
        typeTerrain.put("0317", 2);
        typeTerrain.put("0316", 1);
        typeTerrain.put("0315", 3);
        typeTerrain.put("0314", 3);
        typeTerrain.put("0313", 7);
        typeTerrain.put("0312", 7);
        typeTerrain.put("0311", 1);
        typeTerrain.put("0310", 3);
        typeTerrain.put("0309", 3);
        typeTerrain.put("0308", 1);
        typeTerrain.put("0307", 4);
        typeTerrain.put("0306", 6);
        typeTerrain.put("0305", 1);
        typeTerrain.put("0304", 5);
        typeTerrain.put("0303", 3);
        typeTerrain.put("0302", 3);
        typeTerrain.put("0301", 5);

        //colonne 2
        typeTerrain.put("0223", 1);
        typeTerrain.put("0222", 2);
        typeTerrain.put("0221", 3);
        typeTerrain.put("0220", 3);
        typeTerrain.put("0219", 1);
        typeTerrain.put("0218", 3);
        typeTerrain.put("0217", 2);
        typeTerrain.put("0216", 2);
        typeTerrain.put("0215", 3);
        typeTerrain.put("0214", 7);
        typeTerrain.put("0213", 7);
        typeTerrain.put("0212", 1);
        typeTerrain.put("0211", 1);
        typeTerrain.put("0210", 1);
        typeTerrain.put("0209", 1);
        typeTerrain.put("0208", 1);
        typeTerrain.put("0207", 4);
        typeTerrain.put("0206", 6);
        typeTerrain.put("0205", 4);
        typeTerrain.put("0204", 4);
        typeTerrain.put("0203", 3);
        typeTerrain.put("0202", 3);
        typeTerrain.put("0201", 5);

        //colonne 1
        typeTerrain.put("0123", 3);
        typeTerrain.put("0122", 1);
        typeTerrain.put("0121", 1);
        typeTerrain.put("0120", 1);
        typeTerrain.put("0119", 1);
        typeTerrain.put("0118", 3);
        typeTerrain.put("0117", 3);
        typeTerrain.put("0116", 3);
        typeTerrain.put("0115", 7);
        typeTerrain.put("0114", 7);
        typeTerrain.put("0113", 1);
        typeTerrain.put("0112", 1);
        typeTerrain.put("0111", 3);
        typeTerrain.put("0110", 1);
        typeTerrain.put("0109", 1);
        typeTerrain.put("0108", 1);
        typeTerrain.put("0107", 4);
        typeTerrain.put("0106", 6);
        typeTerrain.put("0105", 4);
        typeTerrain.put("0104", 1);
        typeTerrain.put("0103", 5);
        typeTerrain.put("0102", 1);
        typeTerrain.put("0101", 1);

        return typeTerrain;
    }


    public static Hex GetTypeTerrain(String loc, Map<String, Integer> terrain, Map<String, Integer> monum, Map<String, Integer> road) {
        Hex maCase = new Hex(loc);
        Integer type = terrain.get(loc);
        Integer monument = monum.get(loc);
        Integer route = road.get(loc);

        if (route != null){
            switch (route){
                case 1: // il y a une route
                    maCase.road = 1;
                    break;
                case 0: //pas util.util route
                    maCase.road = 0;
                    break;
                default:
                    break;
            }
        }



        if (type != null) {
            switch (type) {
                case 1: //Open Country Side
                    maCase.event = 5;          //indice du score minimal pour lancer un event
                    maCase.hunt = true;       // droit util.util chasser
                    maCase.fodder = true;     // droit util.util manger
                    maCase.type = 1;
                    break;

                case 2: //Farmland
                    maCase.event = 3;          //indice du score minimal pour lancer un event
                    maCase.hunt = false;       // droit util.util chasser
                    maCase.fodder = false;     // droit util.util manger
                    maCase.type = 2;
                    break;

                case 3: //Forest
                    maCase.event = 9;          //indice du score minimal pour lancer un event
                    maCase.hunt = true;       // droit util.util chasser
                    maCase.fodder = true;     // droit util.util manger
                    maCase.type = 3;
                    break;

                case 4: //Hills
                    maCase.event = 7;          //indice du score minimal pour lancer un event
                    maCase.hunt = true;       // droit util.util chasser
                    maCase.fodder = true;     // droit util.util manger
                    maCase.type = 4;
                    break;

                case 5: //Mountains
                    maCase.event = 6;          //indice du score minimal pour lancer un event
                    maCase.hunt = false;       // droit util.util chasser
                    maCase.fodder = false;     // droit util.util manger
                    maCase.type = 5;
                    break;

                case 6: //Desert
                    maCase.event = 3;          //indice du score minimal pour lancer un event
                    maCase.hunt = false;       // droit util.util chasser
                    maCase.fodder = false;     // droit util.util manger
                    maCase.type = 6;
                    break;

                case 7: //Swamp
                    maCase.event = 8;          //indice du score minimal pour lancer un event
                    maCase.hunt = true;       // droit util.util chasser
                    maCase.fodder = false;     // droit util.util manger
                    maCase.type = 7;
                    break;

                default:
                    break;

            }


            if (monument != null) {
                    switch (monument) {
                        case 1: //Temple
                            maCase.monument = 1;
                            break;
                        case 2: //Ruins
                            maCase.monument = 2;
                            break;
                        case 3: //Castles
                            maCase.monument = 3;
                            break;
                        case 4: //Towns
                            maCase.monument = 4;
                            break;
                        case 5: //Oasis
                            maCase.monument = 5;
                            break;
                        default:break;
                    }
                }
            }

        return maCase;
    }


}
