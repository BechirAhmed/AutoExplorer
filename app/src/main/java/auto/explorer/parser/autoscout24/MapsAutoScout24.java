package auto.explorer.parser.autoscout24;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eugene on 20.10.2016
 */

class MapsAutoScout24 {

    private static final Map<String, String[]> marksCar = new HashMap<>();
    static final Map<String, String> marksCarCodes = new HashMap<>();
    //
    static final Map<String, String> fuelTypeCodes = new HashMap<>();
    static final Map<String, String> gearTypeCodes = new HashMap<>();
    static final Map<String, String> extColorCodes = new HashMap<>();
    static final Map<String, String> sortTypeCodes = new HashMap<>();
    static final Map<String, String> landCodes = new HashMap<>();
    static final Map<String, String> carTypeCodes = new HashMap<>();
    static final Map<String, String> damagedCarsCodes = new HashMap<>();
    static final Map<String, String> providerCodes = new HashMap<>();
    static final Map<String, String> interiorEquipCodes = new HashMap<>();

    @Nullable
    static String getModelCode(@NonNull String mark, @NonNull String model) {
        final String[] modelArr = marksCar.get(mark);
        if (modelArr != null && modelArr.length > 1) {
            for (int i = 0; i < modelArr.length - 1; i += 2) {
                if (modelArr[i + 1].equals(model)) return modelArr[i];
            }
        }
        return null;
    }

    static {
        marksCar.put("9ff", new String[]{"20571", "F70 Etronic", "20977", "F97 A-Max", "20569", "GT9", "20568", "GTronic", "20567", "GTurbo", "20570", "Speed9", "20284", "Sonstige"});
        marksCar.put("Abarth", new String[]{"74336", "124 Spider", "19688", "500", "19689", "500C", "21170", "595", "20323", "595 Competizione", "20258", "595 Turismo", "20387", "595C", "19690", "695", "20386", "695C", "19691", "Grande Punto", "19692", "Punto EVO", "20956", "Punto Supersport", "20957", "Sonstige"});
        marksCar.put("AC", new String[]{"19550", "Ace", "14984", "Cobra", "21037", "Sonstige"});
        marksCar.put("ACM", new String[]{"21192", "4 WD", "21193", "Biagini Passo", "21194", "Sonstige"});
        marksCar.put("Acura", new String[]{"18451", "MDX", "18450", "NSX", "20042", "RDX", "18446", "RL", "18449", "RSX", "18447", "TL", "18448", "TSX", "20043", "ZDX", "21054", "Sonstige"});
        marksCar.put("Aixam", new String[]{"18334", "400", "18335", "500", "18582", "A.", "19164", "City", "20206", "Coupe", "19166", "Crossline", "20209", "Crossover", "20207", "GTI", "20208", "GTO", "18336", "Mac", "18649", "Mega", "19165", "Roadline", "19167", "Scouty R", "19736", "Sonstige"});
        marksCar.put("Alfa Romeo", new String[]{"1601", "145", "1602", "146", "16421", "147", "1603", "155", "15117", "156", "18681", "159", "1604", "164", "15636", "166", "20940", "1750", "20941", "2000", "1600", "33", "20291", "4C", "1606", "75", "19125", "8C", "1607", "90", "20772", "Alfa 6", "1608", "Alfasud", "1609", "Alfetta", "18581", "Brera", "19179", "Crosswagon", "18553", "Giulia", "1611", "Giulietta", "18412", "GT", "1612", "GTV", "19161", "MiTo", "16628", "RZ", "1614", "Spider", "18907", "Sportwagon", "18631", "Sprint", "20276", "SZ", "20942", "Sonstige"});
        marksCar.put("Alpina", new String[]{"-107", "B-Klasse (alle)", "15131", "B10", "20518", "B10 3,3", "20519", "B10 BITURBO", "20520", "B10 V8", "20521", "B10 V8 S", "19160", "B11", "15132", "B12", "20522", "B12 5,0", "20523", "B12 5,7", "15130", "B3", "20502", "B3 2,7", "20503", "B3 3,2", "20504", "B3 3,3", "20505", "B3 3,3 4x4", "20506", "B3 BITURBO", "20507", "B3 GT3", "20508", "B3 S", "20509", "B3 S BITURBO", "20510", "B4 BITURBO", "18601", "B5", "20511", "B5 BITURBO", "20512", "B5 S", "15682", "B6", "20513", "B6 BITURBO", "20514", "B6 S", "18346", "B7", "20515", "B7 BITURBO", "15711", "B8", "20516", "B8 4,6", "20517", "B9", "21172", "C1", "21173", "C2", "-108", "D-Klasse (alle)", "16435", "D10", "20527", "D10 BITURBO", "18717", "D3", "20524", "D3 BITURBO", "20490", "D4", "20525", "D4 BITURBO", "20129", "D5", "20526", "D5 BITURBO", "-109", "Roadster (alle)", "20528", "Roadster Limited Edition", "18544", "Roadster S", "20529", "Roadster V8", "20489", "XD3", "19786", "Sonstige"});
        marksCar.put("Amphicar", new String[]{"20480", "Typ 770", "20378", "Sonstige"});
        marksCar.put("Ariel", new String[]{"21120", "Atom", "21121", "Nomad", "21122", "Sonstige"});
        marksCar.put("Artega", new String[]{"21185", "GT", "21186", "Scalo", "21187", "Sonstige"});
        marksCar.put("Aspid", new String[]{"21200", "GT-21", "21201", "SS", "21202", "Sonstige"});
        marksCar.put("Aston Martin", new String[]{"18469", "AR1", "19735", "Cygnet", "16382", "DB", "74438", "DB11", "1615", "DB7", "18517", "DB9", "19068", "DBS", "1616", "Lagonda", "19531", "Rapide", "18261", "V12 Vanquish", "15119", "V8", "15120", "Vantage", "1617", "Virage", "15540", "Volante", "21000", "Sonstige"});
        marksCar.put("Audi", new String[]{"1619", "100", "1620", "200", "16581", "50", "1622", "80", "1623", "90", "19083", "A1", "16416", "A2", "1624", "A3", "1626", "A4", "20493", "A4 allroad", "19047", "A5", "1628", "A6", "20494", "A6 allroad", "19216", "A7", "1629", "A8", "16414", "Allroad", "1630", "Cabriolet", "1631", "Coupe", "74321", "Q1", "74373", "Q2", "19715", "Q3", "19155", "Q5", "18683", "Q7", "18000", "QUATTRO", "18925", "R8", "15735", "RS", "20385", "RS Q3", "19728", "RS2", "19729", "RS3", "19730", "RS4", "19731", "RS5", "19732", "RS6", "20295", "RS7", "20317", "RS7 Sportback", "20369", "S1", "2109", "S2", "15637", "S3", "2108", "S4", "19048", "S5", "1633", "S6", "20155", "S7", "15123", "S8", "20164", "SQ5", "74439", "SQ7", "15627", "TT", "20056", "TT RS", "20055", "TTS", "1634", "V8", "21001", "Sonstige"});
        marksCar.put("Austin", new String[]{"18618", "Estate", "20132", "Healey", "15806", "Maestro", "15807", "Metro", "20773", "Mini", "20774", "Mini Moke", "16383", "MK", "16453", "Montego", "21042", "Sonstige"});
        marksCar.put("Autobianchi", new String[]{"15831", "A 1000", "15799", "A 112", "15798", "Y10", "21043", "Sonstige"});
        marksCar.put("Auverland", new String[]{"74263", "A3", "74264", "A4", "74265", "Sonstige"});
        marksCar.put("Bedford", new String[]{"20732", "Astramax", "20731", "Astravan", "20733", "Beagle", "20726", "Blitz", "20735", "Brava", "20724", "CA", "20721", "CF2", "20728", "Chevanne", "20727", "Dormobile", "20723", "HA", "20729", "KB", "20730", "Midi", "20736", "MW", "20722", "Rascal", "20734", "TJ", "20737", "Sonstige"});
        marksCar.put("Bellier", new String[]{"21158", "Asso", "21101", "B8", "21111", "Divane", "21102", "Docker City", "21112", "Jade", "21113", "Opale", "21114", "Sturdy", "21115", "VX", "21103", "Sonstige"});
        marksCar.put("Bentley", new String[]{"15685", "Arnage", "15128", "Azure", "21181", "Bentayga", "15125", "Brooklands", "15127", "Continental", "15954", "Eight", "20362", "Flying Spur", "18402", "Mulsanne", "15683", "Turbo R", "15126", "Turbo RT", "15684", "Turbo S", "21002", "Sonstige"});
        marksCar.put("BMW", new String[]{"-37", "1er (alle)", "20149", "114", "18480", "116", "18481", "118", "18482", "120", "19078", "123", "19084", "125", "18588", "130", "19079", "135", "74386", "140", "2163", "2002", "-98", "2er (alle)", "20958", "214", "20397", "216", "20327", "218", "20326", "220", "20328", "225", "20481", "228", "74387", "230", "20329", "235 ", "74388", "240", "-38", "3er (alle)", "16558", "315", "1639", "316", "1640", "318", "1641", "320", "1642", "323", "1643", "324", "1644", "325", "1645", "328", "15779", "330", "18805", "335", "21097", "340", "20187", "Active Hybrid 3", "-97", "4er (alle)", "20398", "418", "20289", "420", "20399", "425", "20287", "428", "20330", "430", "20288", "435", "74335", "440", "-39", "5er (alle)", "1647", "518", "1648", "520", "1649", "523", "1650", "524", "1651", "525", "2145", "528", "1652", "530", "1653", "535", "1654", "540", "18383", "545", "18710", "550", "20027", "Active Hybrid 5", "-40", "6er (alle)", "15780", "628", "18491", "630", "16436", "633", "1656", "635", "19714", "640", "18400", "645", "18709", "650", "-41", "7er (alle)", "1657", "725", "1658", "728", "1659", "730", "15953", "732", "1660", "735", "1661", "740", "16598", "745", "1662", "750", "18327", "760", "19541", "Active Hybrid 7", "-42", "8er (alle)", "21100", "830", "1663", "840", "1664", "850", "20319", "i3", "20320", "i8", "-43", "M-Reihe (alle)", "19741", "1er M Coupé", "21157", "M2", "1646", "M3", "20393", "M4", "1655", "M5", "18577", "M6", "1667", "M1", "-44", "X-Reihe (alle)", "19242", "X1", "18387", "X3", "20364", "X4", "74322", "X4 M", "16406", "X5", "20174", "X5 M", "19110", "X6", "20175", "X6 M", "-45", "Z-Reihe (alle)", "1666", "Z1", "1665", "Z3", "20223", "Z3 M", "18308", "Z4", "19617", "Z4 M", "16402", "Z8", "21073", "Sonstige"});
        marksCar.put("Bolloré", new String[]{"21118", "Bluecar", "21197", "Bluesummer", "21220", "Blueutility", "21119", "Sonstige"});
        marksCar.put("Borgward", new String[]{"21154", "Arabella", "21143", "BX 7", "21145", "Hansa 1100", "21150", "Hansa 1500", "21146", "Hansa 1700", "21151", "Hansa 1800", "21148", "Hansa 2000", "21149", "Hansa 2300", "21152", "Hansa 2400", "21147", "Hansa 3500", "21144", "Hansa 400/500", "21153", "Isabella", "21155", "P100", "21156", "Sonstige"});
        marksCar.put("Brilliance", new String[]{"19135", "BC3", "19080", "BS2", "19186", "BS4", "19081", "BS6", "18700", "Granse", "18699", "Jinbei", "18702", "Zhonghua", "18701", "Zunchi", "21057", "Sonstige"});
        marksCar.put("Bugatti", new String[]{"74381", "Chiron", "15677", "EB 110", "20775", "EB 112", "18843", "Veyron", "21003", "Sonstige"});
        marksCar.put("Buick", new String[]{"1668", "Century", "1669", "Electra", "19058", "Enclave", "18523", "Le Sabre", "1670", "Park Avenue", "1671", "Regal", "1672", "Riviera", "15771", "Roadmaster", "1673", "Skylark", "20151", "Special", "21004", "Sonstige"});
        marksCar.put("BYD", new String[]{"20776", "e6", "19130", "F1", "19131", "F3", "19132", "F3R", "19133", "F6", "19134", "F8", "21060", "Sonstige"});
        marksCar.put("Cadillac", new String[]{"1674", "Allante", "20226", "ATS", "18602", "BLS", "20373", "Brougham", "74323", "CT6", "18405", "CTS", "1675", "Deville", "74425", "DTS", "1676", "Eldorado", "16399", "Escalade", "1677", "Fleetwood", "20372", "LaSalle", "20370", "Series 62", "20371", "Series 6200", "1678", "Seville", "18495", "SRX", "15853", "STS", "18543", "XLR", "74357", "XT5", "21005", "Sonstige"});
        marksCar.put("Caravans-Wohnm", new String[]{"15986", "Adria", "16630", "Ahorn", "18845", "Airstream", "16255", "Alpha", "16256", "Arca", "16257", "Autoroller", "18351", "Autostar", "18352", "Bavaria", "18846", "Bawemo", "18466", "Beisl", "18847", "Benimar", "16258", "Bimobil", "19210", "Biod", "16260", "Burow", "16595", "Burow-Mobil", "16259", "Bürstner", "16261", "Ca-Mo-Car", "20199", "Carado", "18848", "Caravelair", "16262", "Caro", "16263", "Carthago", "18849", "Challenger", "16264", "Chausson", "16265", "Chrysler", "16266", "Ci International", "16267", "Coachmen", "16268", "Concorde", "16269", "Cristall", "16270", "Cs Reisemobile", "16271", "Damon", "18265", "Dehler", "18850", "Delta", "16272", "Dethleffs", "19207", "Dream", "16631", "Due Erre", "16594", "Eifelland", "16273", "Elnagh", "16274", "Eriba", "16275", "Euramobil", "16276", "Euro Liner", "16571", "EVM", "16277", "Fendt", "16278", "Ffb / Tabbert", "16279", "Fiat", "16281", "Fleetwood", "19120", "Florence", "16282", "Ford", "16283", "Ford / Reimo", "16284", "Frankia", "16285", "General Motors", "18851", "Gigant", "18852", "Giottiline", "18853", "Globecar", "16286", "Granduca", "16287", "Hehn", "16288", "Heku", "16289", "Hobby", "16290", "Holiday Rambler", "18854", "Home-Car", "16291", "Hymer", "18855", "ICF", "18856", "Iveco", "16292", "Karmann", "19206", "Kentucky", "19211", "Kip", "16293", "Knaus", "16295", "La Strada", "16294", "Laika", "18857", "Linne-Liner", "16296", "LMC", "16297", "M+M Mobile", "16298", "Ma-Bu", "18858", "Maesss", "18369", "Man", "16299", "Mazda", "16615", "McLouis", "16300", "Mercedes-Benz", "16632", "Miller", "16301", "Mirage", "16302", "Mitsubishi", "19208", "Mizar", "16303", "Mobilvetta", "18729", "Monaco", "18859", "Moncayo", "20220", "Morelo", "18860", "Neotec", "18861", "Niesmann+Bischoff", "18862", "Niewiadow", "16410", "Nordstar", "18863", "Ormocar", "18354", "Peugeot", "18864", "Phoenix", "16304", "Pilote", "18353", "Poessl", "18865", "ProCab", "20197", "Pössl", "16305", "Rapido", "16306", "Reimo", "16307", "Reisemobile Beier", "16308", "Renault", "16309", "Rimor", "16310", "Riva", "16311", "Riviera", "16312", "RMB", "16313", "Roadtrek", "18866", "Robel-Mobil", "16314", "Rockwood", "16315", "Selbstbau", "18867", "Sterckeman", "18868", "Swift", "18841", "Tabbert", "16316", "TEC", "16317", "Tischer", "18869", "Trigano", "16318", "Triple E", "18357", "Ultra", "16319", "Vario", "16320", "VW", "16321", "Weinsberg", "18419", "Weippert", "16322", "Westfalia", "16323", "Wilk", "16324", "Winnebago", "16325", "Sonstige"});
        marksCar.put("Casalini", new String[]{"20850", "Kerry", "20851", "M10", "20852", "M110", "20853", "M12", "20854", "M14", "20855", "Pick Up12", "20856", "Sulky", "20857", "Sulkycar", "20858", "Sulkydea/Ydea", "20859", "Sonstige"});
        marksCar.put("Caterham", new String[]{"20458", "21", "20459", "Classic 7", "20460", "Classic S7", "20461", "Cosworth CSR 200", "20462", "CSR 175", "20463", "CSR 260", "20464", "R 400", "20465", "R300 Superlight", "20466", "Roadsport Seven", "20467", "Seven 458", "20468", "SP/300.R", "20469", "Super 7", "20470", "Superlight", "21047", "Sonstige"});
        marksCar.put("Changhe", new String[]{"20741", "CoolCar", "20738", "Freedom", "20740", "Ideal", "20739", "Mini Truck", "20742", "X5", "20743", "Sonstige"});
        marksCar.put("Chatenet", new String[]{"18462", "Barooder", "19705", "CH 26", "20847", "CH 28", "20848", "CH 30", "20849", "CH 32", "18461", "Media", "20777", "Pick-Up", "18460", "Speedino", "20778", "Sporteevo", "20779", "Stella", "21055", "Sonstige"});
        marksCar.put("Chery", new String[]{"19345", "A18", "19346", "A21", "19347", "A3", "19348", "Amulet", "19349", "B13", "19350", "B14", "19351", "CrossEastar", "19352", "Crossover", "19353", "Eastar", "19354", "FengYun", "19355", "Fora", "19356", "Karry", "19357", "Kimo", "19762", "M11", "19358", "M14", "19359", "Mikado", "19360", "MPV", "19361", "QQ6", "19761", "S18", "19362", "Sweet", "19363", "Tiggo", "20044", "Very", "19364", "WOW", "19760", "À13", "21063", "Sonstige"});
        marksCar.put("Chevrolet", new String[]{"16379", "2500", "15648", "Alero", "1679", "Astro", "18367", "Avalanche", "18685", "Aveo", "1680", "Beretta", "1681", "Blazer", "18516", "C1500", "1683", "Camaro", "1684", "Caprice", "18789", "Captiva", "1685", "Cavalier", "1687", "Celebrity", "19615", "Chevelle", "18420", "Chevy Van", "1686", "Citation", "19121", "Colorado", "1688", "Corsica", "1689", "Corvette", "15738", "Crew cab", "19172", "Cruze", "15772", "Dixie van", "18287", "El Camino", "18790", "Epica", "19122", "Equinox", "18572", "Evanda", "19203", "Express", "15739", "G", "19100", "HHR", "16455", "Impala", "15801", "K1500", "15854", "K30", "18571", "Kalos", "18573", "Lacetti", "19316", "Lanos", "16456", "Lumina", "1690", "Malibu", "18569", "Matiz", "16457", "Monte Carlo", "18719", "Niva", "18574", "Nubira", "19604", "Orlando", "18570", "Rezzo", "16378", "S-10", "15983", "Silverado", "19221", "Spark", "18654", "SSR", "16400", "Suburban", "18673", "Tacuma", "15136", "Tahoe", "19314", "Tracker", "16599", "Trailblazer", "15137", "Trans Sport", "20286", "Traverse", "20234", "Trax", "18901", "Uplander", "19315", "Viva", "19180", "Volt", "21006", "Sonstige"});
        marksCar.put("Chrysler", new String[]{"15139", "300 M", "18497", "300C", "19109", "Aspen", "18339", "Crossfire", "1694", "Daytona", "1691", "ES", "15140", "Grand Voyager", "1693", "GS", "1692", "GTS", "20498", "Imperial", "1695", "Le Baron", "1696", "Neon", "1697", "New Yorker", "18338", "Pacifica", "16587", "Prowler", "16420", "PT Cruiser", "20138", "Ram Van", "1698", "Saratoga", "2150", "Sebring", "1699", "Stratus", "19763", "Town & Country", "14992", "Valiant", "1700", "Viper", "1701", "Vision", "1702", "Voyager", "21007", "Sonstige"});
        marksCar.put("Citroen", new String[]{"1703", "2CV", "18629", "Acadiane", "1704", "AX", "20780", "Axel", "15142", "Berlingo", "1705", "BX", "19054", "C-Crosser", "20219", "C-Elysée", "19734", "C-Zero", "18651", "C1", "14811", "C15", "18373", "C2", "16458", "C25", "18264", "C3", "19170", "C3 Picasso", "19062", "C35", "18545", "C4", "20162", "C4 Aircross", "20406", "C4 Cactus", "18915", "C4 Picasso", "16525", "C5", "18585", "C6", "18281", "C8", "1706", "CX", "15716", "DS", "19523", "DS3", "19606", "DS4", "19718", "DS5", "20781", "Dyane", "1707", "Evasion", "19027", "Grand C4 Picasso", "1708", "GSA", "14710", "Jumper", "16363", "Jumpy", "1709", "LNA", "20293", "Méhari", "19117", "Nemo", "1710", "SAXO", "15717", "SM", "74441", "Spacetourer", "15638", "Visa", "1712", "Xantia", "1713", "XM", "14810", "Xsara", "15984", "Xsara Picasso", "1714", "ZX", "21008", "Sonstige"});
        marksCar.put("CityEL", new String[]{"20910", "CityEL", "20911", "CityEL Fact Four", "20909", "MiniEL", "20912", "Sonstige"});
        marksCar.put("CMC", new String[]{"20769", "Electric Mistry", "20770", "Gipsy 500", "20771", "Sonstige"});
        marksCar.put("Corvette", new String[]{"19709", "C1", "19710", "C2", "19711", "C3", "19712", "C4", "19713", "C5", "19141", "C6 Convertible", "19140", "C6 Coupe", "20290", "C7", "20782", "CZ6", "19142", "Z06", "19143", "ZR1", "21061", "Sonstige"});
        marksCar.put("Courb", new String[]{"21075", "C-Zen", "21076", "Sonstige"});
        marksCar.put("Dacia", new String[]{"20938", "1310", "18500", "Berlina", "18501", "Break", "20186", "Dokker", "18503", "Double Cab", "18504", "Drop Side", "19264", "Duster", "20036", "Lodgy", "18498", "Logan", "18705", "Nova", "18502", "Pick Up", "19129", "Sandero", "18499", "Solenza", "19233", "Stepway", "20939", "Sonstige"});
        marksCar.put("Daewoo", new String[]{"15952", "Aranos", "1715", "Espero", "18360", "Evanda", "18291", "Kalos", "18350", "Korando", "18436", "Lacetti", "14996", "Lanos", "14998", "Leganza", "20783", "Lublin", "15644", "Matiz", "18349", "Musso", "1716", "Nexia", "14997", "Nubira", "20931", "Rexton", "18348", "Rezzo", "16512", "Tacuma", "18396", "Truck Plus", "20932", "Sonstige"});
        marksCar.put("DAF", new String[]{"16459", "400", "21046", "Sonstige"});
        marksCar.put("Daihatsu", new String[]{"1717", "Applause", "1718", "Charade", "1719", "Charmant", "18426", "Copen", "1720", "Cuore", "18434", "Domino", "18811", "Extol", "20427", "F Modelle", "1721", "Feroza", "15741", "Freeclimber", "15145", "Gran Move", "2146", "Hijet", "18924", "Materia", "15144", "Move", "20784", "Pionier", "1722", "Rocky", "15639", "Sirion", "1723", "Taft", "15146", "Terios", "18897", "Trevis", "16460", "Valera", "16588", "YRV", "21009", "Sonstige"});
        marksCar.put("Daimler", new String[]{"20642", "Double Six", "20643", "Six", "20644", "Sovereign", "20640", "Super Eight", "20641", "Super V8", "20645", "Sonstige"});
        marksCar.put("Dangel", new String[]{"21208", "504", "21207", "505", "21217", "Berlingo", "21209", "Boxer", "21210", "C25", "21216", "Ducato", "21218", "Expert", "21211", "J5", "21213", "Jumper", "21212", "Jumpy", "21215", "Partner", "21214", "Scudo", "21219", "Sonstige"});
        marksCar.put("De la Chapelle", new String[]{"21139", "Atalante 57S", "21140", "Grand-Prix", "21141", "Roadster", "21137", "Type 55 Roadster", "21138", "Type 55 Tourer", "21142", "Sonstige"});
        marksCar.put("Derways", new String[]{"19662", "Aurora", "19663", "Cowboy", "19664", "Land Crown", "19665", "Plutus", "19666", "Shuttle", "21068", "Sonstige"});
        marksCar.put("Dodge", new String[]{"19050", "Avenger", "18825", "Caliber", "19318", "Caravan", "19102", "Challenger", "18693", "Charger", "20499", "Coronet", "16401", "Dakota", "20975", "Dart", "15802", "Durango", "2155", "Grand Caravan", "19317", "Intrepid", "19074", "Journey", "18566", "Magnum", "18567", "Neon", "18916", "Nitro", "15321", "RAM", "2154", "Stealth", "18568", "Stratus", "15855", "Van", "16450", "Viper", "20976", "Sonstige"});
        marksCar.put("Donkervoort", new String[]{"16605", "D8", "16606", "S8", "21048", "Sonstige"});
        marksCar.put("DR Motor", new String[]{"20309", "City Cross", "20967", "DR Zero", "19228", "DR1", "19229", "DR2", "19230", "DR3", "19231", "DR5", "19232", "KATAY", "20968", "Sonstige"});
        marksCar.put("DS Automobiles", new String[]{"21088", "DS 3", "21090", "DS 4", "21091", "DS 5", "21092", "Sonstige"});
        marksCar.put("Dutton", new String[]{"20533", "B Plus", "20541", "B Plus Series 2", "20532", "B Type", "20550", "Beneto", "20536", "Cantera", "20543", "Legerra", "20534", "Malaga", "20535", "Malaga B+", "20542", "Melos", "20531", "P1", "20537", "Phaeton Series 1", "20538", "Phaeton Series 2 	", "20539", "Phaeton Series 3 	", "20540", "Phaeton Series 4", "20548", "Rico", "20549", "Rico Shuttle", "20547", "Sierra Drop Head", "20544", "Sierra Series 1", "20545", "Sierra Series 2", "20546", "Sierra Series 3", "20530", "Sonstige"});
        marksCar.put("Estrima", new String[]{"74316", "Birò", "74317", "Sonstige"});
        marksCar.put("Ferrari", new String[]{"16385", "195", "16559", "206", "15753", "208", "16386", "246", "15754", "250", "16387", "275", "15755", "288", "2116", "308", "1725", "328", "16388", "330", "1726", "348", "16389", "360", "2115", "365", "2164", "400", "1727", "412", "1728", "456", "19245", "458", "21085", "488", "1729", "512", "1730", "550", "18347", "575", "18791", "599", "18468", "612", "15757", "750", "19157", "California", "15758", "Daytona", "18289", "Dino GT4", "18309", "Enzo Ferrari", "20140", "F12", "1731", "F355", "1732", "F40", "18547", "F430", "15668", "F50", "15671", "F512", "19719", "FF", "20139", "FXX", "74328", "GTC4 Lusso", "20331", "LaFerrari", "1733", "Mondial", "20785", "Scuderia Spider 16M", "18632", "Superamerica", "1734", "Testarossa", "21010", "Sonstige"});
        marksCar.put("Fiat", new String[]{"16487", "124 Coupè", "15351", "124 Spider", "1735", "126", "1736", "127", "19265", "128", "2130", "130", "1737", "131", "20786", "132", "20787", "133", "14838", "242", "15160", "500", "19612", "500 Abarth", "19533", "500C", "19613", "500C Abarth", "20172", "500L", "20628", "500X", "20254", "595 Abarth", "20788", "600", "20789", "850", "20944", "900", "19319", "Albea", "20790", "Argenta", "1739", "Barchetta", "1740", "Brava", "1741", "Bravo", "15964", "Campagnola", "1742", "Cinquecento", "1743", "Coupe", "1744", "Croma", "2168", "Dino", "16515", "Doblo", "14783", "Ducato", "15730", "Duna", "14827", "Fiorino", "19720", "Freemont", "74368", "Fullback", "18731", "Grande Punto", "18399", "Idea", "19056", "Linea", "1745", "Marea", "15768", "Marengo", "15769", "Maxi", "15640", "Multipla", "20038", "New Panda", "15161", "Palio", "1746", "Panda", "16407", "Penny", "20419", "Pininfarina", "20420", "Pininfarina Spider i.e.", "20421", "Pininfarina Volumex", "1747", "Punto", "19259", "Punto Evo", "19614", "Punto Evo Abarth", "19187", "Qubo", "1748", "Regata", "1749", "Ritmo", "15248", "Scudo", "18779", "Sedici", "15247", "Seicento", "1750", "Spider Europa", "16514", "Stilo", "16372", "Strada", "15989", "Talento", "1751", "Tempra", "1752", "Tipo", "1753", "Ulysse", "1754", "Uno", "1755", "X 1/9", "21011", "Sonstige"});
        marksCar.put("FISKER", new String[]{"20324", "Karma", "20792", "Latigo CS", "20322", "Sonstige"});
        marksCar.put("Ford", new String[]{"1767", "Aerostar", "19721", "B-Max", "1768", "Bronco", "19089", "C-Max", "1756", "Capri", "20426", "Connect Elekto", "15647", "Cougar", "15721", "Courier", "15861", "Crown", "18295", "Econoline", "18633", "Econovan", "20303", "EcoSport", "18913", "Edge", "18589", "Escape", "1757", "Escort", "16607", "Excursion", "16396", "Expedition", "1769", "Explorer", "16364", "Express", "20482", "F 1", "20483", "F 100", "16518", "F 150", "16519", "F 250", "18389", "F 350", "20484", "F 360", "20486", "F 450", "20485", "F 550", "20487", "F 650", "20488", "F Super Duty", "1758", "Fiesta", "19262", "Flex", "15537", "Focus", "18390", "Focus C-Max", "18993", "Focus CC", "18703", "Freestar", "18837", "Freestyle", "18274", "Fusion", "1759", "Galaxy", "20225", "Gran Torino", "1760", "Granada", "19260", "Grand C-Max", "18708", "GT", "1761", "Ka", "19072", "Kuga", "15860", "M", "1762", "Maverick", "18315", "Mercury", "1763", "Mondeo", "2149", "Mustang", "1764", "Orion", "1770", "Probe", "14803", "Puma", "15862", "Ranger", "18761", "S-Max", "1765", "Scorpio", "1766", "Sierra", "20277", "Sportka", "18372", "Streetka", "2159", "Taunus", "1771", "Taurus", "2161", "Thunderbird", "20224", "Torino", "-118", "Tourneo (alle)", "2107", "Tourneo", "20280", "Tourneo Connect", "20405", "Tourneo Courier", "74251", "Tourneo Custom", "-119", "Transit (alle)", "2160", "Transit", "74250", "Transit Bus", "20318", "Transit Connect", "74249", "Transit Courier", "74248", "Transit Custom", "1772", "Windstar", "21012", "Sonstige"});
        marksCar.put("Gac Gonow", new String[]{"20299", "GA200", "21191", "GX6", "20799", "Troy", "20800", "Victor", "20801", "Victory", "20300", "WAY", "20298", "Sonstige"});
        marksCar.put("Galloper", new String[]{"20961", "Exceed", "16562", "GALLOPER", "20793", "Santamo", "20962", "Super Exceed", "20963", "Sonstige"});
        marksCar.put("GAZ", new String[]{"19447", "22171", "19448", "22177", "19449", "24", "19450", "2401", "19451", "2402", "19452", "2404", "19453", "2410", "19454", "2411", "19455", "2412", "19456", "2434", "19457", "31", "19458", "3102", "19459", "31022", "19460", "310221", "19461", "31026", "19462", "31029", "19463", "3105", "19464", "3110", "19465", "31105", "19466", "3111", "19467", "38407", "19468", "38649", "19469", "38710", "20842", "Gazelle", "20843", "Next", "19470", "Siber", "20844", "Sobol", "21065", "Sonstige"});
        marksCar.put("Geely", new String[]{"19667", "MK", "19668", "Otaka", "19669", "Vision", "21069", "Sonstige"});
        marksCar.put("GEM", new String[]{"20749", "E2", "20750", "E4", "20755", "e6", "20751", "eL", "20752", "eS", "20753", "Four", "20754", "Two", "20756", "Sonstige"});
        marksCar.put("GEMBALLA", new String[]{"20285", "Sonstige"});
        marksCar.put("Giotti Victoria", new String[]{"21126", "Gladiator", "21127", "Gyppo", "21128", "Sonstige"});
        marksCar.put("GMC", new String[]{"18908", "Acadia", "18299", "Envoy", "18302", "Safari", "18296", "Savana", "18301", "Sierra", "18298", "Sonoma", "15087", "Syclone", "2157", "Typhoon", "18297", "Vandura", "18300", "Yukon", "18303", "Sonstige"});
        marksCar.put("Great Wall", new String[]{"19759", "Coolbear", "19194", "Cowry", "19200", "Deer", "19756", "Florid", "19193", "Gwperi", "20500", "H6", "19195", "Hover", "20407", "Hover 5", "19757", "Hover H3", "19197", "Pegasus", "19196", "Safe", "19201", "Sailor", "19198", "Sing", "19202", "Socool", "19218", "Steed", "20210", "Voleex", "19199", "Wingle", "19758", "Wingle 3", "21062", "Sonstige"});
        marksCar.put("Grecav", new String[]{"20875", "Amica", "20876", "EKE", "20877", "Sonique", "20878", "Sonstige"});
        marksCar.put("Haima", new String[]{"19767", "2", "19768", "3", "19769", "3 HB", "19770", "6", "19772", "Family", "19771", "Freema", "19766", "Sonstige"});
        marksCar.put("Hamann", new String[]{"20256", "Sonstige"});
        marksCar.put("Honda", new String[]{"1773", "Accord", "19620", "Ascot", "19273", "Avancier", "18749", "Beat", "19274", "Capa", "19621", "City", "1775", "Civic", "1776", "Concerto", "1777", "CR-V", "19269", "CR-Z", "20133", "Crosstour", "1778", "CRX", "18325", "Element", "19275", "Fit", "18559", "FR-V", "15650", "HR-V", "16522", "Insight", "19276", "Inspire", "14911", "Integra", "16490", "Jazz", "1781", "Legend", "19622", "Life", "15649", "Logo", "19277", "Mobilio", "1782", "NSX", "16523", "Odyssey", "19623", "Orthia", "19278", "Partner", "19279", "Pilot", "1783", "Prelude", "20794", "Quintet", "20045", "Ridgeline", "16408", "S 2000", "19280", "Saber", "19624", "Sabre", "1785", "Shuttle", "19625", "Sm-x", "19281", "Stepwgn", "16586", "Stream", "19282", "Torneo", "21106", "Sonstige"});
        marksCar.put("HUMMER", new String[]{"18765", "H1", "18766", "H2", "18767", "H3", "21044", "Sonstige"});
        marksCar.put("Hurtan", new String[]{"74369", "Albaycín", "74370", "Grand Albaycín", "74371", "T2", "74372", "Sonstige"});
        marksCar.put("Hyundai", new String[]{"1786", "Accent", "15166", "Atos", "19754", "Avante", "19163", "Azera", "1787", "Coupe", "16493", "Elantra", "20046", "Equus", "16157", "Excel", "15164", "Galloper", "19626", "Genesis", "19684", "Genesis Coupe", "18267", "Getz", "74376", "Grace", "20321", "Grand Santa Fe", "19753", "Grand Starex H1", "18600", "Grandeur", "15787", "H 100", "16524", "H 200", "19247", "H 300", "18663", "H 350", "16474", "H-1", "19220", "H-1 Cargo", "15165", "H-1 Starex", "19219", "H-1 Travel", "18524", "Highway", "19123", "i10", "19188", "i20", "19065", "i30", "19738", "i40", "20404", "i800", "74331", "Ioniq", "19607", "iX20", "19258", "iX35", "19212", "iX55", "1788", "Lantra", "16596", "Matrix", "19320", "NF", "1789", "Pony", "20134", "Porter", "16475", "S-Coupe", "16526", "Santa Fe", "15811", "Santamo", "18416", "Satellite", "19627", "Solaris", "1791", "Sonata", "18395", "Sonica", "19321", "Starex", "20795", "Stellar", "16597", "Terracan", "20796", "Tiburon", "16473", "Trajet", "18493", "Tucson", "19687", "Veloster", "19322", "Verna", "16370", "XG 30", "18359", "XG 350", "21013", "Sonstige"});
        marksCar.put("Infiniti", new String[]{"20040", "EX25", "19619", "EX30", "19106", "EX35", "19191", "EX37", "18452", "FX", "20159", "FX30", "20160", "FX50", "20161", "FX60", "20039", "G25", "18453", "G35", "19073", "G37", "18454", "I35", "20200", "JX35", "19707", "M30", "19790", "M35h", "19708", "M37", "18455", "M45", "21174", "Q30", "18456", "Q45", "20304", "Q50", "20305", "Q60", "20403", "Q70", "74377", "QX30", "20306", "QX50", "18457", "QX56", "20307", "QX70", "21053", "Sonstige"});
        marksCar.put("Innocenti", new String[]{"15788", "Clip", "15744", "Elba", "20954", "Mille", "20797", "Minitre", "15745", "Small", "20955", "Sonstige"});
        marksCar.put("Iso Rivolta", new String[]{"20744", "300", "20746", "Fidia", "20745", "Grifo", "20747", "Lele", "20748", "Sonstige"});
        marksCar.put("Isuzu", new String[]{"19764", "Axiom", "19323", "Bighorn", "16536", "Campo", "18987", "D-Max", "16513", "DLX", "18386", "Gemini", "14988", "Midi", "18619", "NKR", "20196", "NNR", "18275", "NPR", "18010", "PICK UP", "19213", "Rodeo", "1793", "Trooper", "15812", "WFR", "21014", "Sonstige"});
        marksCar.put("Iveco", new String[]{"20798", "Campagnola", "18670", "Daily", "15720", "LKW/TRUCKS", "19215", "Massif", "21035", "Sonstige"});
        marksCar.put("IZH", new String[]{"19471", "2106", "19472", "2125", "19473", "21251", "19474", "2126", "19475", "21261", "19476", "2715", "19477", "27156", "19478", "2717", "19479", "27171", "19480", "412", "19481", "Nika", "21066", "Sonstige"});
        marksCar.put("Jaguar", new String[]{"18949", "420", "16390", "D-Type", "1795", "Daimler", "2119", "E", "21099", "F-Pace", "20194", "F-Type", "2118", "MK II", "15654", "S-Type", "2129", "Sovereign", "16362", "X-Type", "18488", "X300", "21078", "XE", "19069", "XF", "15169", "XJ", "1798", "XJ12", "1797", "XJ40", "1799", "XJ6", "15168", "XJ8", "1800", "XJR", "1796", "XJS", "18627", "XJSC", "18821", "XK", "1801", "XK8", "15170", "XKR", "19737", "Sonstige"});
        marksCar.put("Jeep", new String[]{"1803", "Cherokee", "15713", "CJ-5", "1804", "CJ-7", "1805", "CJ-8", "18565", "Comanche", "18785", "Commander", "18967", "Compass", "1806", "Grand Cherokee", "20041", "Liberty", "19051", "Patriot", "15832", "Renegade", "18610", "Wagoneer", "15965", "Willys", "1807", "Wrangler", "21015", "Sonstige"});
        marksCar.put("Karabag", new String[]{"21104", "500e", "21105", "Sonstige"});
        marksCar.put("Kia", new String[]{"15796", "Besta", "16538", "Carens", "15882", "Carnival", "18923", "cee'd", "19239", "cee'd Sportswagon", "18418", "Cerato", "1808", "Clarus", "15777", "Elan", "15968", "Joice", "18515", "K2500", "18020", "K2700", "19716", "K2900", "15814", "Leo", "16583", "Magentis", "18528", "Mentor", "19116", "Mohave/Borrego", "74327", "Niro", "18361", "Opirus", "19544", "Optima", "18417", "Picanto", "15969", "Pregio", "1810", "Pride", "19150", "Pro_ceed", "15970", "Retona", "16476", "Rio", "16537", "Roadster", "15893", "Rocsta", "1811", "Sephia", "15678", "Shuma", "18280", "Sorento", "19171", "Soul", "19324", "Spectra", "1812", "Sportage", "19248", "Venga", "21016", "Sonstige"});
        marksCar.put("KTM", new String[]{"20879", "X-Bow GT", "20880", "X-Bow R", "20881", "X-Bow RR", "20882", "Sonstige"});
        marksCar.put("Lada", new String[]{"15653", "110", "16548", "111", "16549", "112", "18634", "1200", "20804", "1300/1500", "20802", "2106", "74379", "4x4", "16551", "Aleko", "19176", "C-Cross", "20803", "Carlota", "16535", "Forma", "20047", "Granta", "18911", "Kalina", "20135", "Largus", "20805", "Natacha", "1816", "Niva", "15652", "Nova", "19189", "Priora", "20806", "Sagona", "1817", "Samara", "20807", "Sprint", "20479", "Taiga", "20808", "Universal", "20809", "VAZ 215", "74378", "Vesta", "21017", "Sonstige"});
        marksCar.put("Lamborghini", new String[]{"19722", "Aventador", "15673", "Countach", "15174", "Diablo", "16391", "Espada", "18356", "Gallardo", "20361", "Huracán", "15672", "Jalpa", "16392", "LM", "15759", "Miura", "16618", "Murciélago", "19527", "Reventon", "16635", "Urraco P250", "21018", "Sonstige"});
        marksCar.put("Lancia", new String[]{"20428", "A 112", "20429", "A 112 Abarth", "20430", "A 112 Elite", "1819", "Beta", "1820", "Dedra", "1822", "Delta", "16415", "Flaminia", "19686", "Flavia", "14773", "Fulvia", "1823", "Gamma", "20810", "HPE", "16437", "K", "1824", "Kappa", "15985", "Lybra", "18541", "MUSA", "18313", "Phedra", "1825", "Prisma", "15876", "Stratos", "1826", "Thema", "16613", "Thesis", "20811", "Trevi", "19773", "Voyager", "1828", "Y", "18393", "Ypsilon", "15830", "Z", "18030", "ZETA", "21019", "Sonstige"});
        marksCar.put("Land Rover", new String[]{"15794", "Defender", "15791", "Discovery", "20913", "Discovery Sport", "15792", "Freelander", "19103", "LRX", "15793", "Range Rover", "19600", "Range Rover Evoque", "18555", "Range Rover Sport", "19537", "Series", "21041", "Sonstige"});
        marksCar.put("LDV", new String[]{"21183", "Convoy", "21196", "Maxus", "21184", "Sonstige"});
        marksCar.put("Lexus", new String[]{"19717", "CT 200h", "18823", "ES 350", "-47", "GS-Serie (alle)", "20193", "GS 250", "15709", "GS 300", "16568", "GS 430", "18817", "GS 450h", "19115", "GS 460", "74324", "GS F", "-48", "GX-Serie (alle)", "19529", "GX 460", "18414", "GX 470", "-49", "IS-Serie (alle)", "15710", "IS 200", "18740", "IS 220d", "18739", "IS 250", "18040", "IS 300h", "19159", "IS F", "74329", "LC 500h", "20192", "LFA", "-50", "LS-Serie (alle)", "15708", "LS 400", "16494", "LS 430", "18989", "LS 460", "19076", "LS 600", "-51", "LX-Serie (alle)", "16445", "LX 470", "19114", "LX 570", "-120", "NX-Serie (alle)", "20812", "NX 200t", "20491", "NX 300h", "-121", "RC-Serie (alle)", "21175", "RC 200t", "21176", "RC 300h", "21177", "RC 350", "20813", "RC F", "-52", "RX-Serie (alle)", "74252", "RX 200t", "16404", "RX 300", "18496", "RX 330", "18763", "RX 350", "18623", "RX 400", "19238", "RX 450h", "-53", "SC-Serie (alle)", "15714", "SC 400", "18050", "SC 430", "21020", "Sonstige"});
        marksCar.put("Lifan", new String[]{"19670", "Breez (520)", "20048", "Smily", "19671", "Solano (620)", "21070", "Sonstige"});
        marksCar.put("Ligier", new String[]{"18379", "162", "18378", "Ambra", "18873", "Be-Two", "18377", "Be-Up", "19702", "Due", "19701", "IXO", "20279", "JS", "18376", "Nova", "18381", "Optima", "19700", "Optimax", "18380", "Prima", "18872", "X-Pro", "18871", "X-Too", "19695", "X-TOO Max", "19696", "X-TOO R", "19697", "X-TOO R DCI", "19699", "X-TOO RS", "19698", "X-TOO S", "19694", "X-TOO2", "21052", "Sonstige"});
        marksCar.put("Lincoln", new String[]{"18326", "Aviator", "15863", "Continental", "20497", "Cosmopolitan", "16593", "LS", "18525", "Mark", "16397", "Navigator", "14894", "Town Car", "18713", "Zephyr", "21036", "Sonstige"});
        marksCar.put("Lotus", new String[]{"19243", "2-Eleven", "16557", "340 R", "16592", "Cortina", "1832", "Elan", "1833", "Elise", "16590", "Elite", "1834", "Esprit", "15033", "Europa", "19224", "Evora", "16589", "Excel", "16451", "Exige", "16591", "Omega", "2111", "Super Seven", "16393", "V8", "18294", "Venturi", "21021", "Sonstige"});
        marksCar.put("Mahindra", new String[]{"18834", "Bolero", "18494", "CJ", "21116", "Genio", "18833", "Goa", "18530", "Jeep", "74325", "Quanto", "19784", "Reva", "20814", "Thar", "20212", "XUV500", "21056", "Sonstige"});
        marksCar.put("Mansory", new String[]{"-124", "Aston Martin (alle)", "74276", "Aston Martin - Cyrus", "74273", "Aston Martin - DB9", "74275", "Aston Martin - Vanquish", "74274", "Aston Martin - Vantage", "74267", "Audi - R8", "-125", "Bentley (alle)", "74277", "Bentley - Continental GT", "74278", "Bentley - Flying Spur", "74279", "Bentley - Le Mansory", "74280", "Bentley - Vitesse Rosé", "-126", "BMW (alle)", "74281", "BMW - 7", "74282", "BMW - X5", "74283", "BMW - X6", "74268", "Bugatti - Veyron", "-127", "Ferrari (alle)", "74287", "Ferrari - 458", "74288", "Ferrari - 599 GTB", "74285", "Ferrari - F12", "74284", "Ferrari - La Revoluzione", "74286", "Ferrari - Siracusa", "74270", "Land Rover - Range Rover", "-128", "Lotus (alle)", "74289", "Lotus - Elise", "74290", "Lotus - Evora", "-129", "Maserati (alle)", "74292", "Maserati - Ghibli", "74291", "Maserati - Gran Turismo", "74269", "McLaren - 12C", "-130", "Mercedes-Benz (alle)", "74298", "Mercedes-Benz - C", "74297", "Mercedes-Benz - CLS", "74304", "Mercedes-Benz - E", "74293", "Mercedes-Benz - G", "74294", "Mercedes-Benz - GL", "74305", "Mercedes-Benz - M", "74295", "Mercedes-Benz - ML", "74296", "Mercedes-Benz - S", "74301", "Mercedes-Benz - SL", "74300", "Mercedes-Benz - SLK", "74306", "Mercedes-Benz - SLR", "74299", "Mercedes-Benz - SLS", "74303", "Mercedes-Benz - V", "74302", "Mercedes-Benz - Viano", "-131", "Porsche (alle)", "74310", "Porsche - 918", "74312", "Porsche - 991", "74311", "Porsche - 997", "74307", "Porsche - Cayenne", "74308", "Porsche - Macan", "74309", "Porsche - Panamera", "-132", "Rolls-Royce (alle)", "74313", "Rolls-Royce - Ghost", "74315", "Rolls-Royce - Phantom", "74314", "Rolls-Royce - Wraith", "74271", "Tesla - Model S", "74272", "Sonstige"});
        marksCar.put("Martin Motors", new String[]{"20888", "Bubble", "20889", "CEO", "20890", "CoolCar", "20891", "MM520", "20892", "MM620", "20893", "Sonstige"});
        marksCar.put("Maserati", new String[]{"18362", "222", "18363", "224", "18364", "228", "15667", "3200", "18365", "418", "18366", "420", "18403", "4200", "15833", "422", "15834", "424", "15987", "430", "1835", "Biturbo", "18263", "Coupe", "15189", "Ghibli", "19530", "GranCabrio", "18635", "GranSport", "19075", "GranTurismo", "15778", "Indy", "15665", "Karif", "74326", "Levante", "18661", "MC12", "15742", "Merak", "15190", "Quattroporte", "15963", "Racing", "15666", "Shamal", "16620", "Spyder", "19091", "TC", "21022", "Sonstige"});
        marksCar.put("Maybach", new String[]{"18304", "57", "18305", "62", "21050", "Sonstige"});
        marksCar.put("Mazda", new String[]{"1836", "121", "18342", "2", "18388", "3", "1837", "323", "18624", "5", "18266", "6", "1838", "626", "1839", "929", "19327", "Atenza", "19628", "Axela", "15820", "B 2500", "18835", "B 2600", "19325", "Bongo", "19049", "BT-50", "19329", "Capella", "21084", "CX-3", "19723", "CX-5", "18795", "CX-7", "19154", "CX-9", "15565", "Demio", "14777", "E", "19330", "Familia", "19629", "Millenia", "1840", "MPV", "1841", "MX-3", "1842", "MX-5", "1843", "MX-6", "18909", "Pick Up", "15659", "Premacy", "19326", "Protege", "1844", "RX-7", "18343", "RX-8", "16534", "Tribute", "1845", "Xedos", "19328", "Xedos 6", "21023", "Sonstige"});
        marksCar.put("McLaren", new String[]{"20422", "12 C", "21166", "540C", "74440", "570GT", "21167", "570S", "20423", "650S Coupe", "20424", "650S Spider", "21168", "675LT", "20029", "F1", "20030", "MP4-12C", "21169", "P1", "20028", "Sonstige"});
        marksCar.put("Melex", new String[]{"20657", "148", "20658", "341", "20690", "341 H", "20659", "343", "20691", "343 H", "20660", "345", "20692", "345 H", "20661", "363", "20693", "363 H", "20662", "364", "20694", "364 H", "20663", "366", "20695", "366 H", "20664", "378", "20665", "381", "20696", "381 H", "20666", "385", "20697", "385 H", "20667", "391", "20698", "391 H", "20668", "392", "20669", "395", "20700", "395 H", "20701", "563 XTR", "20702", "563 XTR H", "20703", "565 XTR", "20704", "565 XTR H", "20670", "627", "20671", "833", "20672", "835", "20673", "843", "20674", "845", "20675", "848", "20676", "860", "20705", "860 H", "20677", "861", "20706", "861 H", "20678", "864", "20707", "864 H", "20679", "865", "20708", "865 H", "20680", "943", "20709", "943 H", "20681", "945", "20710", "945 H", "20682", "947", "20683", "960", "20711", "960 H", "20684", "961", "20712", "961 H", "20713", "961 XTR PLUS H", "20714", "962 XTR Plus", "20685", "963", "20715", "963 H", "20716", "964 XTR Plus", "20717", "965 XTR Plus", "20718", "965 XTR Plus H", "20686", "966", "20687", "967", "20719", "967 H", "20688", "969", "20689", "986", "20720", "Sonstige"});
        marksCar.put("Mercedes-Benz", new String[]{"20400", "170", "20401", "180", "1846", "190", "1847", "200", "20927", "208", "20928", "210/310", "15690", "220", "1848", "230", "1849", "240", "1850", "250", "1851", "260", "15723", "270", "1852", "280", "1853", "300", "74334", "308", "1854", "320", "15383", "350", "1855", "380", "1856", "400", "18288", "416", "2126", "420", "14865", "450", "1857", "500", "2127", "560", "1858", "600", "-54", "A-Klasse (alle)", "15701", "A 140", "18485", "A 150", "14869", "A 160", "15702", "A 170", "18486", "A 180", "15703", "A 190", "18487", "A 200", "18273", "A 210", "20218", "A 220", "20165", "A 250", "20255", "A 45 AMG", "18293", "Actros", "20636", "AMG GT", "18292", "Atego", "-55", "B-Klasse (alle)", "18606", "B 150", "19240", "B 160", "18607", "B 170", "18608", "B 180", "18609", "B 200", "20185", "B 220", "20166", "B 250", "20627", "B Electric Drive", "-56", "C-Klasse (alle)", "18613", "C 160", "1859", "C 180", "1860", "C 200", "2147", "C 220", "1861", "C 230", "15693", "C 240", "15384", "C 250", "16488", "C 270", "2099", "C 280", "18371", "C 30 AMG", "19249", "C 300", "16582", "C 32 AMG", "15973", "C 320", "18614", "C 350", "14807", "C 36 AMG", "20916", "C 400", "15632", "C 43 AMG", "20918", "C 450", "18422", "C 55 AMG", "19107", "C 63 AMG", "-57", "CE (alle)", "16492", "CE 200", "20240", "CE 220", "20241", "CE 230", "20242", "CE 280", "15715", "CE 300", "20195", "Citan", "-58", "CL (alle)", "15725", "CL", "20243", "CL 160", "18507", "CL 180", "18508", "CL 200", "18509", "CL 220", "18510", "CL 230", "18511", "CL 420", "18512", "CL 500", "18423", "CL 55 AMG", "18513", "CL 600", "18991", "CL 63 AMG", "18636", "CL 65 AMG", "-96", "CLA (alle)", "20229", "CLA 180", "20230", "CLA 200", "20231", "CLA 220", "20232", "CLA 250", "20301", "CLA 45 AMG", "19144", "CLC", "-59", "CLK (alle)", "14926", "CLK", "18879", "CLK 200", "18881", "CLK 220", "18882", "CLK 230", "18883", "CLK 240", "18885", "CLK 270", "18886", "CLK 280", "18887", "CLK 320", "18889", "CLK 350", "18891", "CLK 430", "18892", "CLK 500", "16506", "CLK 55 AMG", "18815", "CLK 63 AMG", "-60", "CLS (alle)", "18505", "CLS", "20601", "CLS 220", "20244", "CLS 250", "20383", "CLS 280", "20384", "CLS 300", "19112", "CLS 320", "19113", "CLS 350", "20926", "CLS 400", "19118", "CLS 500", "18813", "CLS 55 AMG", "18814", "CLS 63 AMG", "-61", "E-Klasse (alle)", "1862", "E 200", "1863", "E 220", "15029", "E 230", "15517", "E 240", "15695", "E 250", "15955", "E 260", "15763", "E 270", "1864", "E 280", "1865", "E 290", "15543", "E 300", "2117", "E 320", "18546", "E 350", "15694", "E 36 AMG", "18368", "E 400", "1866", "E 420", "15698", "E 430", "15549", "E 50 AMG", "2162", "E 500", "15699", "E 55 AMG", "20176", "E 550", "18476", "E 60 AMG", "18804", "E 63 AMG", "-62", "G-Klasse (alle)", "15776", "G", "20245", "G 230", "20246", "G 240", "20247", "G 250", "20325", "G 270", "20248", "G 280", "20249", "G 290", "20169", "G 300", "20250", "G 320", "20215", "G 350", "20251", "G 400", "20216", "G 500", "18425", "G 55 AMG", "20167", "G 63 AMG", "20168", "G 65 AMG", "-63", "GL (alle)", "18769", "GL 320", "19252", "GL 350", "20924", "GL 400", "18770", "GL 420", "18771", "GL 450", "18772", "GL 500", "20252", "GL 55 AMG", "20253", "GL 63 AMG", "-102", "GLA (alle)", "20492", "GLA 180", "20343", "GLA 200", "20344", "GLA 220", "20345", "GLA 250", "20388", "GLA 45 AMG", "-116", "GLC (alle)", "21086", "GLC 220", "21087", "GLC 250", "74390", "GLC 350", "74389", "GLC 43 AMG", "-114", "GLE (alle)", "21093", "GLE 250", "20920", "GLE 350", "20921", "GLE 400", "74391", "GLE 43 AMG", "20922", "GLE 450", "21094", "GLE 500", "20923", "GLE 63 AMG", "-83", "GLK (alle)", "19616", "GLK 200", "19181", "GLK 220", "19253", "GLK 250", "19184", "GLK 280", "19254", "GLK 300", "19182", "GLK 320", "19183", "GLK 350", "-122", "GLS (alle)", "74254", "GLS 350", "74255", "GLS 400", "74256", "GLS 500", "74257", "GLS 63 AMG", "15944", "LKW/TRUCKS", "-64", "M-Klasse (alle)", "15201", "ML 230", "19747", "ML 250", "15866", "ML 270", "18615", "ML 280", "19255", "ML 300", "15202", "ML 320", "18319", "ML 350", "16555", "ML 400", "18803", "ML 420", "15705", "ML 430", "19256", "ML 450", "16556", "ML 500", "16438", "ML 55 AMG", "18753", "ML 63 AMG", "16575", "MB 100", "-65", "R-Klasse (alle)", "18801", "R 280", "19251", "R 300", "18603", "R 320", "18604", "R 350", "18605", "R 500", "18802", "R 63 AMG", "-66", "S-Klasse (alle)", "19726", "S 250", "19727", "S 260", "15103", "S 280", "15696", "S 300", "15105", "S 320", "15697", "S 350", "15775", "S 400", "15107", "S 420", "15704", "S 430", "18895", "S 450", "15108", "S 500", "16489", "S 55 AMG", "18787", "S 550", "15724", "S 560", "15109", "S 600", "18990", "S 63 AMG", "18580", "S 65 AMG", "-67", "SL (alle)", "20217", "SL 230", "20391", "SL 250", "1867", "SL 280", "15691", "SL 300", "1868", "SL 320", "16483", "SL 350", "16481", "SL 380", "20389", "SL 400", "16482", "SL 420", "16484", "SL 450", "1869", "SL 500", "18060", "SL 55 AMG", "16485", "SL 560", "19546", "SL 60 AMG", "1870", "SL 600", "19151", "SL 63 AMG", "18492", "SL 65 AMG", "19547", "SL 70 AMG", "19548", "SL 73 AMG", "-123", "SLC (alle)", "74258", "SLC 180", "74259", "SLC 200", "74260", "SLC 250", "74261", "SLC 300", "74262", "SLC 43 AMG", "-68", "SLK (alle)", "1871", "SLK", "18560", "SLK 200", "16446", "SLK 230", "19748", "SLK 250", "18617", "SLK 280", "19257", "SLK 300", "16509", "SLK 32 AMG", "15975", "SLK 320", "18561", "SLK 350", "18424", "SLK 55 AMG", "16381", "SLR", "19223", "SLS", "15943", "Sprinter", "20443", "T1", "20444", "T2", "-69", "V-Klasse (alle)", "15945", "V", "18562", "V 200", "15700", "V 220", "15199", "V 230", "20637", "V 250", "15200", "V 280", "16576", "Vaneo", "18272", "Vario", "18394", "Viano", "15942", "Vito", "20930", "Sonstige"});
        marksCar.put("MG", new String[]{"20818", "Metro", "16504", "MGA", "15204", "MGB", "1873", "MGF", "20130", "Midget", "19226", "RV8", "18521", "TD", "18269", "TF", "16577", "ZR", "16578", "ZS", "16579", "ZT", "21024", "Sonstige"});
        marksCar.put("Microcar", new String[]{"19703", "Cargo", "19704", "Due", "20945", "Ecology/Lyra", "20946", "Flex", "19272", "M.Go", "20061", "M8", "18519", "MC1", "19156", "MC2", "18520", "Virgo", "20947", "Sonstige"});
        marksCar.put("Minauto", new String[]{"74366", "Minauto", "74367", "Sonstige"});
        marksCar.put("MINI", new String[]{"16600", "1000", "16601", "1300", "-91", "Cabrio-Serie (alle)", "20000", "Cooper Cabrio", "20001", "Cooper D Cabrio", "20002", "Cooper S Cabrio", "20003", "Cooper SD Cabrio", "20015", "John Cooper Works Cabrio", "20018", "One Cabrio", "-92", "Clubman-Serie (alle)", "19053", "Cooper Clubman", "20004", "Cooper D Clubman", "20005", "Cooper S Clubman", "20006", "Cooper SD Clubman", "20016", "John Cooper Works Clubman", "19742", "One Clubman", "20023", "One D Clubman", "20278", "Clubvan", "16603", "Cooper", "19744", "Cooper D", "19743", "Cooper S", "19745", "Cooper SD", "-93", "Countryman-Serie (alle)", "20007", "Cooper Countryman", "20008", "Cooper D Countryman", "20009", "Cooper S Countryman", "20010", "Cooper SD Countryman", "20310", "John Cooper Works Countryman", "19267", "One Countryman", "20024", "One D Countryman", "-90", "Coupe-Serie (alle)", "20011", "Cooper Coupe", "20012", "Cooper D Coupe", "20013", "Cooper S Coupe", "20014", "Cooper SD Coupe", "20017", "John Cooper Works Coupe", "-103", "John Cooper Works (alle)", "20347", "Cabrio John Cooper Works", "20349", "Clubman John Cooper Works", "20350", "Countryman John Cooper Works", "20346", "Coupe John Cooper Works", "19706", "John Cooper Works", "20351", "Paceman John Cooper Works", "20348", "Roadster John Cooper Works", "16602", "One", "19746", "One D", "-95", "Paceman-Serie (alle)", "20292", "Cooper D Paceman", "20180", "Cooper Paceman", "20181", "Cooper S Paceman", "20182", "Cooper SD Paceman", "20183", "John Cooper Works Paceman", "-94", "Roadster-Serie (alle)", "20163", "Cooper Roadster", "20177", "Cooper S Roadster", "20178", "Cooper SD Roadster", "20179", "John Cooper Works Roadster", "16574", "Sonstige"});
        marksCar.put("Mitsubishi", new String[]{"1875", "3000 GT", "16366", "400", "19331", "Airtrek", "19268", "ASX", "20625", "Attrage", "14908", "Canter", "1876", "Carisma", "19337", "Chariot", "1877", "Colt", "18529", "Cordia", "16398", "Cosmos", "19335", "Delica", "19336", "Diamante", "19630", "DINGO", "19332", "Dion", "1879", "Eclipse", "20198", "FTO", "1882", "Galant", "15877", "Galloper", "18428", "Grandis", "19611", "I-MiEV", "2112", "L200", "2171", "L300", "16412", "L400", "1884", "Lancer", "19334", "Legnum", "19631", "Libero", "19338", "Mirage", "15731", "Montero", "18355", "Outlander", "1885", "Pajero", "18391", "Pajero Pinin", "18839", "Pajero Sport", "18070", "PICK UP", "19339", "RVR", "16439", "Santamo", "16464", "Sapporo", "1888", "Sigma", "1889", "Sigma Wagon", "1890", "Space Gear", "1891", "Space Runner", "15546", "Space Star", "1892", "Space Wagon", "1893", "Starion", "18645", "Tredia", "19333", "Sonstige"});
        marksCar.put("Morgan", new String[]{"20431", "100-Years-Special", "20432", "3-Wheeler", "20433", "4-Sitzer", "18773", "4/4", "16609", "Aero 8", "20434", "Aero Coupe", "20435", "Aero Max", "20436", "Aero Supersports", "20437", "EVA GT", "20438", "Lifecar", "16440", "Plus 4", "16441", "Plus 8", "20439", "Plus 8 Speedster", "20440", "Plus E", "19173", "Roadster", "20441", "Roadster Sport", "20442", "Supersport Pedal", "20600", "Sonstige"});
        marksCar.put("Moskvich", new String[]{"19482", "21215", "19483", "2137", "19484", "2138", "19485", "2140", "19486", "21406", "19487", "2141", "19488", "21412", "19489", "214145", "19490", "2142", "19491", "2335", "19492", "408", "19493", "412", "19494", "426", "19495", "427", "19496", "434", "19497", "Duet", "19498", "Ivan Kalita", "19501", "Jurij Dolgorukij", "19499", "Knjaz Vladimir", "19500", "Svjatogor", "21067", "Sonstige"});
        marksCar.put("MP Lafer", new String[]{"20561", "Lafer", "20560", "Sonstige"});
        marksCar.put("Nissan", new String[]{"1895", "100", "1896", "200 SX", "1897", "280 ZX", "1898", "300 ZX", "19077", "350", "18324", "350Z", "19190", "370Z", "19283", "AD", "1899", "Almera", "18411", "Almera Tino", "20239", "Altima", "18579", "Armada", "19284", "Avenir", "19632", "Bassara", "1900", "Bluebird", "18283", "Cabstar", "2169", "Cargo", "19285", "Cedric", "19286", "Cefiro", "1901", "Cherry", "18750", "Cube", "19287", "Datsun", "74436", "E-NV200", "19633", "Elgrand", "20213", "Evalia", "19288", "Expert", "18751", "Figaro", "18323", "Frontier", "19289", "Gloria", "19234", "GT-R", "18286", "Interstar", "19542", "Juke", "15850", "King Cab", "18392", "Kubistar", "18478", "Laurel", "19733", "Leaf", "19290", "Liberty", "19291", "March", "1903", "Maxima", "1904", "Micra", "18318", "Murano", "18307", "Navara", "18682", "Note", "19168", "NP300", "19266", "NV200", "19781", "NV400", "15207", "Pathfinder", "1905", "Patrol", "15851", "Pick Up", "19222", "Pixo", "1906", "Prairie", "19292", "Presage", "19634", "Presea", "18358", "Primastar", "1907", "Primera", "19293", "Pulsar", "18921", "Qashqai", "19175", "Qashqai+2", "16403", "Quest", "19294", "R Nessa", "19149", "Rogue", "19295", "Safari", "1908", "Serena", "18316", "Silvia", "18695", "Skyline", "20638", "Stagea", "20819", "Stanza", "1911", "Sunny", "19296", "Teana", "1912", "Terrano", "1913", "Terrano II", "19067", "Tiida", "19297", "Tino", "18625", "Titan", "15874", "Trade", "2134", "Urvan", "15782", "Vanette", "19298", "Wingroad", "16554", "X-Trail", "21025", "Sonstige"});
        marksCar.put("Oldsmobile", new String[]{"15967", "Bravada", "18535", "Custom Cruiser", "1914", "Cutlass", "2131", "Delta 88", "19787", "Dynamic 88", "18401", "Silhouette", "18536", "Supreme", "2132", "Toronado", "19785", "Sonstige"});
        marksCar.put("Oldtimer", new String[]{"15991", "Abarth", "15994", "AC", "15995", "Adler", "15996", "Alfa Romeo", "16158", "Allard", "15997", "Alvis", "15992", "AMC", "15998", "American", "15999", "Amphicar", "16161", "Ariel", "16162", "Aries", "16160", "Armstrong Siddeley", "16163", "Arnolt", "16164", "ASA", "15993", "ASC", "16000", "Aston Martin", "16001", "Auburn", "16002", "Audi", "16003", "Aurora", "16004", "Austin", "16005", "Austin-Healey", "16165", "Auto Union", "16006", "Autobianchi", "16007", "Avanti", "18415", "Barkas", "16009", "Beast", "19241", "Bedford", "18375", "Belsize", "16166", "Benjamin", "16010", "Bentley", "16167", "Berkeley", "16012", "Bitter", "16168", "Bizzarrini", "16008", "BMW", "16011", "Borgward", "18819", "Brennabor", "16013", "Bricklin", "16170", "Bugatti", "16014", "Buick", "16016", "Cadillac", "16171", "Chaika", "16172", "Champion", "16173", "Charron", "16017", "Checker", "16174", "Chenard & Walker", "16018", "Chevrolet", "16019", "Chrysler", "16175", "Cisitalia", "16020", "Citroen", "16015", "CJ Rayburn", "16176", "Clan", "16021", "Clenet", "16177", "Commer", "16022", "Continental", "16023", "Cord", "19174", "Corvette", "16178", "Cunningham", "16183", "D.F.P", "16024", "Daf", "16025", "Daimler", "16026", "Dante", "16027", "Datsun", "74448", "Day Elder", "16184", "De Dion Bouton", "16031", "De Lorean", "16030", "De Soto", "16029", "De Tomaso", "16179", "Delage", "16180", "Delahaye", "16181", "Denzel", "16182", "DeSoto", "16028", "Deutz", "16148", "DKW", "16032", "Dodge", "16033", "Dort", "16185", "Duesenberg", "16035", "Durant", "16034", "Dutton", "16036", "Edsel", "16186", "Elva", "16037", "EMW", "16038", "England", "16187", "Enzmann", "16039", "Essex", "16040", "Excalibur", "15978", "Facel Vega", "16188", "Fairthorpe", "16189", "Falcon", "16042", "Fenton-Riley", "16043", "Ferrari", "16044", "Fiat", "16045", "Fire Vehicle", "18534", "Fleur de Lys", "16190", "FN", "16046", "Ford", "16149", "Fordson", "16047", "Formula-Car", "16048", "Franklin", "16191", "Frazer Nash", "16192", "Fuldamobil", "18458", "Gaz", "16193", "Ghia", "16194", "Gilbern", "16195", "Ginatta", "16480", "Ginetta", "16196", "Glas", "16049", "GMC", "16050", "Goggomobil", "16051", "Goliath", "16198", "Gordon Keeble", "16052", "Graham-Paige", "16199", "GSM", "16200", "Gutbrod", "16053", "Hanomag", "16054", "Harley Davidson", "16201", "Healey", "16152", "Heinkel", "16055", "Heritage", "16056", "Hillman", "16202", "Hino", "16057", "Hispano-Suiza", "16153", "Holden", "16058", "Honda", "16150", "Horch", "16203", "Hotchkiss", "16204", "HRG", "16059", "Hudson", "16206", "Humber", "16060", "Hupmobile", "16151", "IFA", "16061", "IHC", "16374", "Innocenti", "16062", "International", "16207", "Iso Rivolta", "16063", "Isuzu", "16064", "Jaguar", "16065", "Jeep", "16066", "Jensen", "16067", "Kaiser", "16208", "Kaiser - Frazer", "16154", "Karmann", "15982", "Karmann Ghia", "16068", "Kelly", "16209", "Kleinschnittger", "16212", "La Licorne", "16210", "Lagonda", "16071", "Lamborghini", "16211", "Lanchester", "16373", "Lancia", "16072", "Land Rover", "16069", "Lanz", "16070", "LaSalle", "16073", "Lea Francis", "16214", "Ligier", "16074", "Lincoln", "16075", "LKW-Trucks", "16216", "Lloyd", "16217", "LMX", "16218", "Lombardi", "16215", "Lorraine Dietrich", "16076", "Lotus", "16078", "Mack", "16079", "Magirus", "16080", "MAN", "16219", "Marauder", "18531", "March", "16081", "Marcos", "16082", "Marmon", "16083", "Maserati", "16220", "Mathis", "16084", "Matra", "16085", "Maybach", "16086", "Mazda", "16087", "Mercedes Benz", "16088", "Mercury", "16249", "Merlin", "16089", "Messerschmitt", "16077", "MG", "16091", "Military Vehicle", "18374", "Minerva", "20313", "Mitsubishi", "16221", "Monica", "16222", "Monteverdi", "16223", "Moretti", "16092", "Morgan", "16224", "Morgan Darmont", "16225", "Morris Leon Bolle", "16093", "Morris Minor", "16094", "Moskvitch", "16375", "Motorräder-Bike", "16227", "Munga", "16228", "Muntz", "15976", "Nash", "16096", "Nissan", "16097", "NSU", "16229", "Ogle", "16098", "Oldsmobile", "16099", "Opel", "16230", "Osca", "18783", "Overland", "16100", "Packard", "16101", "Panhard", "16155", "Panther", "18784", "Paterson", "16102", "Peerless", "16231", "Pegaso", "16103", "Peugeot", "16104", "Pierce Arrow", "16106", "Pontiac", "16107", "Porsche", "20147", "Puch", "16156", "Puma", "16108", "Rambler", "16109", "Reliant", "16110", "Renault", "16232", "RenT Bonnet", "16111", "Republic", "16112", "Riley", "16113", "Rolls Royce", "16233", "Rosengart", "16114", "Rotus", "16115", "Roush", "16116", "Rover", "16234", "Rovin", "16117", "Saab", "16235", "Salmson", "16118", "Saurer", "16376", "Seat", "16119", "Sebring", "16120", "Setra", "16122", "Shelby", "16123", "Shores", "16236", "Siata", "16121", "Simca", "16124", "Skoda", "16125", "Spartan", "16126", "Spitzer", "20145", "Standard", "16237", "Stephens", "18532", "Steyr", "16127", "Studebaker", "16128", "Stutz", "16129", "Subaru", "16130", "Sunbeam", "18723", "Talbot", "16491", "Tatra", "16132", "Tempo", "16133", "Toyota", "16380", "Trabant", "16134", "Tractor", "16239", "Trident", "16135", "Triumph", "16240", "Tucker", "16241", "Turner", "16136", "TVR", "16251", "Uaz", "16242", "Unic", "16137", "Unimog", "16138", "Vanden Plas", "16243", "Veritas", "16244", "Vignale", "18533", "Vixen", "16245", "Voisin", "16139", "Volkswagen", "16140", "Volvo", "16141", "Wanderer", "16142", "Wartburg", "16143", "Westfalia", "16144", "Westfield", "16145", "Wetsch", "16146", "Willys", "16246", "Wolseley", "16252", "Yugo", "16147", "Zimmer", "16247", "Zündapp", "16248", "Sonstige"});
        marksCar.put("Opel", new String[]{"20191", "Adam", "16417", "Agila", "19749", "Ampera", "18827", "Antara", "15740", "Arena", "1915", "Ascona", "1916", "Astra", "1917", "Calibra", "15852", "Campo", "20221", "Cascada", "14825", "Combo", "14854", "Commodore", "1918", "Corsa", "2158", "Diplomat", "1919", "Frontera", "16604", "GT", "19101", "Insignia", "1920", "Kadett", "20639", "Karl", "1921", "Manta", "18341", "Meriva", "20148", "Mokka", "1922", "Monterey", "1923", "Monza", "15870", "Movano", "1924", "Omega", "18080", "Pick Up Sportscap", "1926", "Rekord", "1927", "Senator", "18345", "Signum", "1929", "Sintra", "16447", "Speedster", "1930", "Tigra", "1931", "Vectra", "16612", "Vivaro", "15660", "Zafira", "20381", "Zafira Tourer", "20960", "Sonstige"});
        marksCar.put("Pagani", new String[]{"20141", "Huayra", "16614", "Zonda C12", "21049", "Sonstige"});
        marksCar.put("Panther Westwinds", new String[]{"20564", " Lazer", "20563", "De Ville", "20566", "Kallista", "20552", "Lima", "20565", "Rio", "20551", "Sonstige"});
        marksCar.put("Peugeot", new String[]{"18621", "1007", "1932", "104", "1933", "106", "18647", "107", "20374", "108", "20237", "2008", "15764", "204", "1934", "205", "15401", "206", "18797", "207", "20057", "208", "19217", "3008", "20211", "301", "15867", "304", "1935", "305", "1936", "306", "16553", "307", "19055", "308", "1937", "309", "19066", "4007", "20153", "4008", "15718", "404", "1938", "405", "1939", "406", "18421", "407", "19235", "5008", "16573", "504", "1940", "505", "19553", "508", "18637", "604", "1942", "605", "16495", "607", "1943", "806", "18282", "807", "19145", "Bipper", "14821", "Boxer", "14845", "Camper", "14851", "Expert", "20037", "iOn", "16365", "J5", "20820", "J9", "14822", "Partner", "19685", "Ranch", "19246", "RCZ", "74332", "Traveller", "21107", "Sonstige"});
        marksCar.put("PGO", new String[]{"20884", "Cobra", "20883", "Cévennes", "20885", "Hemera", "20886", "Speedster", "20887", "Speedster II", "20616", "Sonstige"});
        marksCar.put("Piaggio", new String[]{"21195", "AL500", "19086", "Ape", "19087", "M500", "19088", "PK500", "18330", "Porter", "18799", "Quargo", "21108", "Sonstige"});
        marksCar.put("Plymouth", new String[]{"74395", "Acclaim", "74396", "Arrow", "74397", "Barracuda", "74398", "Belvedere", "74399", "Breeze", "74400", "Caravelle", "74401", "Colt", "74402", "Conquest", "74403", "Cricket", "74404", "Duster", "74405", "Fury", "74406", "Gran Fury", "74407", "GTX", "74408", "Horizon", "74409", "Laser", "74410", "Neon", "74411", "Prowler", "74412", "Reliant", "74413", "Road Runner", "74414", "Sapporo", "74415", "Satellite", "74416", "Savoy", "74417", "Scamp", "74418", "Sundance", "74419", "Trailduster", "74420", "Turismo", "74421", "Valiant", "74422", "Volaré", "74423", "Voyager", "74394", "Sonstige"});
        marksCar.put("Pontiac", new String[]{"1944", "6000", "18475", "Aztek", "1945", "Bonneville", "20495", "Catalina Safari", "15732", "Fiero", "1946", "Firebird", "18470", "G6", "1947", "Grand-Am", "1948", "Grand-Prix", "18471", "GTO", "18474", "Montana", "18611", "Solstice", "18410", "Sunbird", "18473", "Sunfire", "15629", "Targa", "14867", "Trans Am", "1949", "Trans Sport", "18472", "Vibe", "21026", "Sonstige"});
        marksCar.put("Porsche", new String[]{"15957", "356", "74380", "550", "-70", "911er (alle)", "1950", "911", "20845", "930", "15977", "964", "20025", "991", "15881", "993", "15880", "996", "18548", "997", "18527", "912", "15980", "914", "20156", "918", "1951", "924", "1952", "928", "1953", "944", "15743", "959", "18278", "962", "1954", "968", "1955", "Boxster", "15359", "Carrera GT", "18284", "Cayenne", "18684", "Cayman", "20311", "Macan", "19136", "Panamera", "19085", "Targa", "21027", "Sonstige"});
        marksCar.put("Proton", new String[]{"16539", "313", "16540", "315", "16541", "316", "16542", "318", "16543", "413", "16544", "415", "16545", "416", "16546", "418", "16547", "420", "20821", "Gen2", "20822", "Persona", "21040", "Sonstige"});
        marksCar.put("Puch", new String[]{"74383", "G", "74384", "Haflinger", "74385", "Sonstige"});
        marksCar.put("Qoros", new String[]{"20914", "Qoros 3", "20915", "Sonstige"});
        marksCar.put("Qvale", new String[]{"21164", "Mangusta"});
        marksCar.put("Reliant", new String[]{"20646", "Ant", "20647", "Fox", "20648", "Kitten", "20649", "Rebel", "20650", "Regal", "20651", "Regent", "20652", "Rialto", "20653", "Robin", "20654", "Sabre Four", "20655", "Scimitar", "20656", "Sonstige"});
        marksCar.put("Renault", new String[]{"20408", "Alpine A110", "1958", "Alpine A310", "1959", "Alpine A610", "1960", "Alpine V6", "16616", "Avantime", "20235", "Captur", "1961", "Clio", "14830", "Coupe", "20053", "Duster", "1962", "Espace", "2133", "Express", "19250", "Fluence", "20060", "Fluence Z.E.", "1963", "Fuego", "16505", "Grand Espace", "19169", "Grand Modus", "18711", "Grand Scenic", "21077", "Kadjar", "15317", "Kangoo", "20059", "Kangoo Z.E.", "19126", "Koleos", "1964", "Laguna", "19545", "Latitude", "19341", "Logan", "18277", "Mascott", "14717", "Master", "1965", "Megane", "21182", "Messenger", "18522", "Modus", "18100", "P 1400", "1966", "R 11", "1967", "R 14", "1968", "R 18", "1969", "R 19", "1970", "R 20", "1971", "R 21", "1972", "R 25", "1973", "R 30", "1974", "R 4", "1975", "R 5", "18337", "R 6", "1976", "R 9", "15737", "Rapid", "1977", "Safrane", "19755", "Sandero", "20054", "Sandero Stepway", "14786", "Scenic", "15706", "Spider", "1978", "Super 5", "19340", "Symbol", "21095", "Talisman", "2096", "Trafic", "1979", "Twingo", "20058", "Twizy", "16617", "Vel Satis", "19552", "Wind", "20228", "ZOE", "19725", "Sonstige"});
        marksCar.put("Rolls-Royce", new String[]{"20409", "Arnage Green Label", "20410", "Arnage Red Label", "20411", "Azure", "20412", "Azure Mulliner", "2165", "Cloud", "20413", "Continental  R Mulliner", "20414", "Continental R", "20415", "Continental SC", "2167", "Corniche", "74424", "Dawn", "15676", "Flying Spur", "19263", "Ghost", "20416", "Le Mains Series", "20417", "Park Ward", "15217", "Park Ward Turbo", "15821", "Phantom", "19057", "Phantom Drophead", "15215", "Silver Dawn", "15219", "Silver Seraph", "2166", "Silver Shadow", "15674", "Silver Spirit", "15675", "Silver Spur", "20236", "Silver Wraith", "20418", "T", "15218", "Touring", "20294", "Wraith", "21028", "Sonstige"});
        marksCar.put("Rover", new String[]{"15959", "100", "15726", "111", "1980", "114", "1981", "200", "18110", "213", "1982", "214", "1983", "216", "19209", "218", "1984", "220", "15871", "25", "15960", "400", "15781", "414", "1987", "416", "15949", "418", "1988", "420", "15872", "45", "15961", "600", "15761", "618", "1989", "620", "1990", "623", "15728", "75", "1991", "800", "1992", "820", "1993", "825", "1994", "827", "20823", "City Rover", "15962", "Estate", "16532", "Metro", "20824", "MINI", "15823", "Montego", "18639", "Rover", "16368", "SD", "18413", "Streetwise", "16517", "Tourer", "21029", "Sonstige"});
        marksCar.put("Ruf", new String[]{"20271", "3400S", "20272", "3600S", "20264", "BTR", "20260", "CTR", "20261", "CTR2", "20262", "CTR3", "20275", "Dakara", "20266", "R Kompressor", "20267", "R Turbo", "20263", "RGT", "20274", "RGT-8", "20273", "RK Coupe/Spyder", "20268", "RT 12", "20270", "RT 12R", "20269", "RT 12S", "20265", "Turbo R", "20259", "Sonstige"});
        marksCar.put("Saab", new String[]{"20450", "9-2X", "15057", "9-3", "20451", "9-4X", "15058", "9-5", "18597", "9-7X", "1999", "90", "2000", "900", "20447", "900 Sedan", "20448", "900 Sedan GL", "20449", "900 Turbo", "2001", "9000", "20445", "92", "20446", "93", "16511", "96", "20452", "96/95", "2002", "99", "20453", "GT 750", "20454", "Sonett I", "20455", "Sonett II", "20456", "Sonett III", "20457", "Sport / GT 850", "21030", "Sonstige"});
        marksCar.put("Santana", new String[]{"20825", "2500", "19093", "300", "19094", "350", "19095", "410", "19526", "Anibal", "18715", "PS-10", "20826", "S300", "20827", "S350", "20828", "Samurai", "20829", "Vitara", "20830", "Vitara Cabriolet", "21058", "Sonstige"});
        marksCar.put("Savel", new String[]{"20766", "Agora", "20767", "Spacia", "20768", "Sonstige"});
        marksCar.put("SDG", new String[]{"74442", "Auto Elettrica", "74443", "Sonstige"});
        marksCar.put("SEAT", new String[]{"2003", "Alhambra", "18427", "Altea", "19185", "Altea XL", "14763", "Arosa", "74330", "Ateca", "2004", "Cordoba", "19162", "Exeo", "18640", "Fura", "2006", "Ibiza", "14762", "Inca", "15869", "Leon", "2007", "Malaga", "2008", "Marbella", "19788", "Mii", "16510", "Panda", "18641", "Ronda", "15770", "Terra", "2010", "Toledo", "21031", "Sonstige"});
        marksCar.put("Skoda", new String[]{"18642", "105", "18120", "120", "18643", "130", "18130", "135", "19779", "Citigo", "15878", "Fabia", "2014", "Favorit", "2015", "Felicia", "2016", "Forman", "74375", "Kodiaq", "15222", "Octavia", "18140", "Pick-up", "19064", "Praktik", "20184", "Rapid/Spaceback", "18877", "Roomster", "21178", "Snowman", "16621", "Superb", "19236", "Yeti", "21032", "Sonstige"});
        marksCar.put("smart", new String[]{"20831", "brabus", "15748", "city-coupé/city-cabrio", "18442", "crossblade", "18438", "forFour ", "18439", "forTwo", "18440", "roadster", "21038", "Sonstige"});
        marksCar.put("SpeedArt", new String[]{"20283", "Sonstige"});
        marksCar.put("Spyker", new String[]{"19008", "C12", "19007", "C8", "19009", "D12", "21059", "Sonstige"});
        marksCar.put("SsangYong", new String[]{"18988", "Actyon", "18306", "Family", "20832", "Kallista", "15228", "Korando", "18679", "Kyron", "2017", "MUSSO", "18262", "REXTON", "18587", "Rodius", "20952", "Tivoli", "74333", "XLV", "20953", "Sonstige"});
        marksCar.put("Subaru", new String[]{"18150", "1200", "2019", "1800", "18657", "Baja", "20131", "BRZ", "2021", "E10", "20302", "E12", "15224", "Forester", "2023", "Impreza", "2024", "Justy", "2025", "Legacy", "20936", "Leone", "21096", "Levorg", "16367", "Libero", "20948", "M60", "20949", "M70", "20950", "M80", "16465", "Mini", "18160", "OUTBACK", "2026", "SVX", "19693", "Trezia", "18671", "Tribeca", "20834", "Vanille", "16466", "Vivio", "20363", "WRX", "2028", "XT", "19774", "XV", "20937", "Sonstige"});
        marksCar.put("Suzuki", new String[]{"2029", "Alto", "2030", "Baleno", "15868", "Cappuccino", "15733", "Carry", "20626", "Celerio", "19343", "Escudo", "18170", "Grand Vitara", "16530", "Ignis", "15662", "Jimny", "19609", "Kizashi", "16572", "Liana", "2031", "LJ 80", "15875", "Maruti", "2032", "SA 310", "2033", "Samurai", "15947", "Santana", "2034", "SJ 410", "2035", "SJ 413", "18180", "SJ Samurai", "19052", "Splash", "2148", "Super-Carry", "2036", "Swift", "18768", "SX4", "20312", "SX4 S-Cross", "2037", "Vitara", "15226", "Wagon R+", "2038", "X-90", "19342", "XL-7", "21109", "Sonstige"});
        marksCar.put("TagAZ", new String[]{"19682", "Accent", "20052", "C10", "20136", "C190", "19677", "Estina", "20137", "Hardy", "19678", "Road Partner", "19679", "Tager", "19680", "Tiggo", "19681", "Vega", "21072", "Sonstige"});
        marksCar.put("Talbot", new String[]{"21161", "Alpine", "20837", "Horizon", "20475", "Horizont GL", "20476", "Horizont GLS", "21159", "Matra Murena", "21160", "Matra Rancho", "20838", "Samba", "20835", "Simca 1100", "20836", "Simca 1510", "20472", "Solar GL", "20473", "Solar LS", "20474", "Solar Ralley", "20839", "Solara", "21162", "Sunbeam", "20840", "Tagora", "20471", "Sonstige"});
        marksCar.put("Tasso", new String[]{"20757", "Bingo", "20758", "C1DB", "20759", "C1DM", "20919", "Domino", "20760", "Hola", "20761", "King", "20762", "T2", "20763", "T3", "20764", "TD", "20765", "Sonstige"});
        marksCar.put("Tata", new String[]{"19789", "Aria", "16527", "Estate", "19204", "Indica", "19205", "Indigo", "19111", "Nano", "18899", "Pick-Up", "16529", "Safari", "16528", "Sumo", "16468", "Telcoline", "16371", "Telcosport", "19137", "Xenon", "21045", "Sonstige"});
        marksCar.put("Tazzari EV", new String[]{"20635", "EM1 Anniversary", "20634", "EM1 Citysport", "20630", "Zero Classic", "20631", "Zero Evo", "20632", "Zero Special Edition", "20633", "Zero Speedster", "20629", "Sonstige"});
        marksCar.put("TECHART", new String[]{"20257", "Sonstige"});
        marksCar.put("Tesla", new String[]{"20032", "Model S", "20033", "Model X", "20034", "Roadster", "20031", "Sonstige"});
        marksCar.put("Town Life", new String[]{"21123", "Ginevra", "21124", "Helektra", "21125", "Sonstige"});
        marksCar.put("Toyota", new String[]{"2045", "4-Runner", "19635", "Allion", "21171", "Alphard", "19636", "Altezza", "19637", "Aristo", "18992", "Auris", "18698", "Avalon", "15230", "Avensis", "19778", "Avensis Verso", "18655", "Aygo", "19638", "BB", "19639", "Belta", "74374", "C-HR", "19299", "Caldina", "19640", "Cami", "2046", "Camry", "2047", "Carina", "2050", "Celica", "19300", "Chaser", "20233", "Coaster", "2052", "Corolla", "20222", "Corolla Verso", "19301", "Corona", "19641", "Corsa", "2053", "Cressida", "19302", "Cresta", "18659", "Crown", "19642", "Duet", "16442", "Dyna", "19643", "Estima", "16469", "F", "18807", "FJ Cruiser", "20154", "FJ40", "18737", "Fortuner", "2055", "Fun Cruiser", "19303", "Funcargo", "19644", "Gaia", "20150", "GT86", "19304", "Harrier", "15858", "HDJ", "14711", "Hiace", "19305", "Highlander", "14789", "Hilux", "19306", "Ipsum", "19138", "iQ", "19307", "Ist", "15857", "KJ", "2056", "Land Cruiser", "19308", "Land Cruiser Prado", "15729", "LC", "2142", "Lite-Ace", "19309", "Mark II", "74358", "Matrix", "21098", "Mirai", "2058", "MR 2", "19646", "Nadia", "19645", "Noah", "19647", "Opa", "2059", "Paseo", "19648", "Passo", "15849", "Pick up", "2060", "Picnic", "19649", "Platz", "19310", "Premio", "2061", "Previa", "16516", "Prius", "20152", "Prius+", "20214", "Pro Ace", "19650", "Ractis", "19651", "Raum", "2143", "RAV 4", "18583", "Sequoia", "18314", "Sienna", "16443", "Solara", "19311", "Sprinter", "2062", "Starlet", "2063", "Supra", "20282", "Tacoma", "2064", "Tercel", "19652", "Town Ace", "16444", "Tundra", "19139", "Urban Cruiser", "19528", "Venza", "19653", "Verossa", "19225", "Verso", "19605", "Verso-S", "19312", "Vista", "19313", "Vitz", "19655", "Voxy", "19658", "Will", "19656", "Windom", "19657", "Wish", "15663", "Yaris", "21033", "Sonstige"});
        marksCar.put("Trabant", new String[]{"20620", "1.1", "20621", "P50", "20622", "P60", "20623", "P601", "20624", "Rallye", "15749", "Trabant", "21039", "Sonstige"});
        marksCar.put("Trailer-Anhänger", new String[]{"16326", "Sonstige"});
        marksCar.put("Triumph", new String[]{"15002", "Dolomite", "20143", "GT6", "20553", "Herald", "16479", "Moss", "15633", "Spitfire", "20951", "Stag", "16622", "TR3", "18344", "TR4", "2121", "TR5", "2122", "TR6", "16507", "TR7", "16508", "TR8", "20959", "Sonstige"});
        marksCar.put("Trucks-Lkw", new String[]{"16327", "Atlas", "16328", "Cat", "16329", "Citroen", "16330", "Daewoo", "16331", "DAF", "16332", "Deutz-Fahr", "16333", "Fiat", "16334", "Ford", "16335", "Fuchs", "16336", "Hanomag", "16337", "Hitachi", "16338", "Iveco", "16340", "Iveco Magirus", "16339", "Iveco-Fiat", "16341", "Jungheinrich", "16342", "Koegel", "16343", "Komatsu", "18620", "LDV", "16344", "Liebherr", "16345", "Linde", "16346", "MAN", "16347", "Mercedes-Benz", "16348", "Mitsubishi", "16409", "Multicar", "16349", "Neoplan", "19119", "Nissan", "16350", "O & K", "16351", "Peugeot", "16352", "Renault", "16353", "Scania", "16354", "Schaeff", "16355", "Setra", "16356", "Volvo", "16357", "VW", "16358", "Zeppelin", "16359", "Zettelmeyer", "16360", "Sonstige"});
        marksCar.put("TVR", new String[]{"15234", "Cerbera", "15232", "Chimaera", "15233", "Griffith", "16610", "S 2,8", "20933", "S2", "20934", "S3", "15680", "S4", "18690", "Sagaris", "18689", "T350", "20943", "Tamora", "18385", "Tuscan", "15681", "V8S", "20935", "Sonstige"});
        marksCar.put("UAZ", new String[]{"19502", "2206", "19503", "2315", "19504", "23632", "19505", "3151", "19506", "31512", "19507", "31514", "19508", "31519", "19509", "315195", "19510", "3153", "19511", "3159", "19512", "3160", "19513", "31601", "19514", "31602", "19515", "3162", "19516", "3163", "19517", "3303", "19518", "3692", "19519", "3909", "19520", "3962", "19521", "469", "21117", "Dakar", "19522", "Hunter", "20917", "Tigr", "20894", "Sonstige"});
        marksCar.put("VAZ", new String[]{"19365", "1111", "19366", "11113", "19367", "11118", "19368", "1113", "19369", "1117", "19370", "1118", "19371", "1119", "19372", "1706", "19373", "1922", "19374", "2016", "19375", "2101", "19376", "21011", "19377", "21013", "19378", "2102", "19379", "2103", "19380", "21033", "19381", "2104", "19382", "21043", "19383", "21045", "19384", "21046", "19385", "21047", "19386", "2105", "19387", "21051", "19388", "21053", "19389", "2106", "19390", "21060", "19391", "21061", "19392", "21063", "19393", "21065", "19394", "2107", "19395", "21073", "19396", "21074", "19397", "2108", "19398", "21081", "19399", "21083", "19400", "21086", "19401", "2109", "19402", "21091", "19403", "21093", "19404", "21096", "19405", "21099", "19406", "2110", "19407", "21101", "19408", "21102", "19409", "21103", "19410", "21104", "19411", "21106", "19412", "21108", "19413", "2111", "19414", "21111", "19415", "21112", "19416", "21113", "19417", "21114", "19418", "2112", "19419", "21120", "19420", "21121", "19421", "21122", "19422", "21123", "19423", "21124", "19424", "2113", "19425", "21130", "19426", "2114", "19427", "21140", "19428", "2115", "19429", "21150", "19430", "21150i", "19431", "2120", "19432", "2121", "19433", "21213", "19434", "21214", "19435", "21218", "19436", "212180", "19437", "2123", "19438", "2129", "19439", "2131", "19440", "21312", "19441", "2170", "19442", "2199", "19443", "2328", "19444", "2329", "19445", "2364", "19446", "Roadster", "21064", "Sonstige"});
        marksCar.put("VEM", new String[]{"21129", "Cargo", "21131", "Cover", "21134", "Double", "21135", "Multi", "21133", "Open", "21130", "People", "21132", "Ribaltabile", "21136", "Sonstige"});
        marksCar.put("Volkswagen", new String[]{"16585", "181", "19261", "Amarok", "2113", "Anfibio", "19724", "Beetle", "15535", "Bora", "15981", "Buggy", "2106", "Bus", "15734", "Caddy", "19780", "CC", "21179", "Coccinelle", "2083", "Corrado", "18781", "Crafter", "20316", "Cross Touran", "20841", "Derby", "18707", "Eos", "21180", "Escarabajo", "18599", "Fox", "-101", "Golf (alle)", "20315", "Cross Golf", "2084", "Golf", "20341", "Golf Cabriolet", "20342", "Golf GTI", "20026", "Golf Plus", "20376", "Golf Sportsvan", "20340", "Golf Variant", "16584", "Iltis", "2087", "Jetta", "16623", "Karmann Ghia", "2114", "Käfer", "16521", "L80", "15767", "LT", "15534", "Lupo", "15864", "Maggiolino", "15381", "New Beetle", "-100", "Passat (alle)", "2089", "Passat", "20339", "Passat Alltrack", "20337", "Passat CC", "20338", "Passat Variant", "18276", "Phaeton", "19344", "Pointer", "-99", "Polo (alle)", "2090", "Polo", "20170", "Polo Cross", "20335", "Polo GTI", "20333", "Polo Plus", "20336", "Polo R WRC", "19659", "Polo Sedan", "20334", "Polo Variant", "19127", "Routan", "2091", "Santana", "2092", "Scirocco", "2093", "Sharan", "19618", "T1", "15363", "T2", "-104", "T3 (alle)", "18317", "T3", "18200", "T3 Blue Star", "20354", "T3 California", "20356", "T3 Caravelle", "20360", "T3 Kombi", "20352", "T3 Multivan", "18240", "T3 White Star", "-105", "T4 (alle)", "14792", "T4", "18190", "T4 Allstar", "20355", "T4 California", "20357", "T4 Caravelle", "20359", "T4 Kombi", "20353", "T4 Multivan", "-106", "T5 (alle)", "18370", "T5", "18575", "T5 California", "18210", "T5 Caravelle", "20358", "T5 Kombi", "18220", "T5 Multivan", "18747", "T5 Shuttle", "-115", "T6 (alle)", "21083", "T6 California", "21081", "T6 Caravelle", "21082", "T6 Multivan", "21080", "T6 Transporter", "16520", "Taro", "19063", "Tiguan", "18285", "Touareg", "18329", "Touran", "18230", "Transporter", "19750", "up!", "2094", "Vento", "20380", "XL1", "21034", "Sonstige"});
        marksCar.put("Volvo", new String[]{"2065", "240", "2138", "244", "2144", "245", "18489", "262", "16580", "264", "21110", "265", "2066", "340", "2067", "360", "2068", "440", "2069", "460", "2070", "480", "2071", "740", "2136", "744", "16405", "745", "2072", "760", "2140", "764", "2073", "780", "2074", "850", "2141", "855", "2075", "940", "2137", "944", "2139", "945", "2076", "960", "2123", "965", "18912", "C30", "15236", "C70", "15237", "Polar", "2077", "S40", "16486", "S60", "2078", "S70", "15664", "S80", "2080", "S90", "2082", "V40", "20296", "V40 CC", "18404", "V50", "19610", "V60", "2079", "V70", "2081", "V90", "19124", "XC60", "18328", "XC70", "18268", "XC90", "20144", "Sonstige"});
        marksCar.put("Vortex", new String[]{"20049", "Corda", "20050", "Estina", "20051", "Tingo", "19777", "Sonstige"});
        marksCar.put("Wartburg", new String[]{"20558", "1.3", "20559", "1.6", "20619", "1000", "20554", "311", "20555", "312", "20556", "313", "20557", "353", "20562", "Barkas", "20618", "Framo", "20617", "IFA F9", "16567", "WARTBURG", "20610", "Sonstige"});
        marksCar.put("Westfield", new String[]{"20899", "7SE", "20895", "FW400", "20897", "Megablade", "20896", "Megabusa", "20898", "MegaS2000", "20904", "SDV", "20900", "SE", "20901", "SEi", "20903", "Seight", "20902", "Sport", "20905", "Sport Turbo", "20908", "XI", "20906", "XTR2", "20907", "XTR4", "19776", "Sonstige"});
        marksCar.put("Wiesmann", new String[]{"18331", "MF 28", "18332", "MF 3", "18333", "MF 30", "19152", "MF 4", "19153", "MF 5", "21051", "Sonstige"});
        marksCar.put("Zastava", new String[]{"20870", "10", "20866", "101", "20871", "1100 TF", "20865", "125 PZ", "20867", "128", "20864", "1300", "20861", "600", "20862", "750", "20863", "850", "20872", "850 AK", "20873", "900 AK", "20869", "Koral", "20868", "Skala", "20860", "Yugo", "20874", "Sonstige"});
        marksCar.put("ZAZ", new String[]{"19672", "1102", "19673", "1103", "19674", "1105", "19675", "Chance", "19676", "Sense", "21071", "Sonstige"});
        marksCar.put("Sonstige", new String[]{"18722", "AMC", "20390", "Apal", "18733", "ARO", "20121", "Asia", "18630", "Barkas", "20118", "Bertone", "18595", "Bitter", "18697", "Bristol", "74382", "British Leyland", "18745", "Burton", "20375", "can-am", "19061", "Canta", "19105", "Carver", "20123", "China Automobile", "20120", "Continental", "20501", "Cord", "20281", "Datsun Go", "20110", "De Lorean", "20116", "De Tomaso", "20379", "DFSK", "18919", "Effedi Maranello", "19683", "Excalibur", "18669", "FSO", "20107", "Fun Tech", "20100", "Gillet", "20103", "Ginetta", "19098", "Gonow", "19608", "Grandin Dallas", "20382", "Gumpert", "18734", "Hartge", "20124", "HDPIC", "19532", "Hobbycar", "18691", "Holden", "20314", "IHC", "20297", "Iseki", "19096", "Italcar", "20128", "JDM", "20102", "Keinath", "20101", "Koenigsegg", "20104", "La Forza", "20114", "Landwind", "19178", "Loremo", "20105", "Marcos", "19538", "Mega", "20203", "Melkus", "20126", "Mercury", "20238", "Mia", "20202", "Monteverdi", "19752", "Morris", "19271", "Mosler", "20109", "Noble", "20127", "Plymouth", "20125", "Polaris", "20205", "Quadix", "20201", "Radical", "19534", "Reva", "20392", "Romeo Ferraris", "18875", "Saleen", "19782", "Sam", "19543", "Scion", "20332", "Shandong", "20108", "Teener", "19536", "Think City", "19661", "Tiger", "20158", "Tramontana", "18644", "Trax", "19099", "Turner", "18777", "Van Diemen", "20111", "Vauxhall", "20106", "Venturi", "20146", "Weineck", "20117", "YES!", "20142", "Zenvo", "20173", "Zoyte", "16564", "Sonstige"});
    }

    static {
        marksCarCodes.put("9ff", "51539");
        marksCarCodes.put("Abarth", "16396");
        marksCarCodes.put("AC", "14979");
        marksCarCodes.put("ACM", "16429");
        marksCarCodes.put("Acura", "16356");
        marksCarCodes.put("Aixam", "16352");
        marksCarCodes.put("Alfa Romeo", "6");
        marksCarCodes.put("Alpina", "14");
        marksCarCodes.put("Amphicar", "51545");
        marksCarCodes.put("Ariel", "16419");
        marksCarCodes.put("Artega", "16427");
        marksCarCodes.put("Aspid", "16431");
        marksCarCodes.put("Aston Martin", "8");
        marksCarCodes.put("Audi", "9");
        marksCarCodes.put("Austin", "15643");
        marksCarCodes.put("Autobianchi", "15644");
        marksCarCodes.put("Auverland", "16437");
        marksCarCodes.put("Bedford", "16400");
        marksCarCodes.put("Bellier", "16416");
        marksCarCodes.put("Bentley", "11");
        marksCarCodes.put("BMW", "13");
        marksCarCodes.put("Bolloré", "16418");
        marksCarCodes.put("Borgward", "16424");
        marksCarCodes.put("Brilliance", "16367");
        marksCarCodes.put("Bugatti", "15");
        marksCarCodes.put("Buick", "16");
        marksCarCodes.put("BYD", "16379");
        marksCarCodes.put("Cadillac", "17");
        marksCarCodes.put("Caravans-Wohnm", "15672");
        marksCarCodes.put("Casalini", "16407");
        marksCarCodes.put("Caterham", "16335");
        marksCarCodes.put("Changhe", "16401");
        marksCarCodes.put("Chatenet", "16357");
        marksCarCodes.put("Chery", "16384");
        marksCarCodes.put("Chevrolet", "19");
        marksCarCodes.put("Chrysler", "20");
        marksCarCodes.put("Citroen", "21");
        marksCarCodes.put("CityEL", "16411");
        marksCarCodes.put("CMC", "16406");
        marksCarCodes.put("Corvette", "16380");
        marksCarCodes.put("Courb", "51558");
        marksCarCodes.put("Dacia", "16360");
        marksCarCodes.put("Daewoo", "22");
        marksCarCodes.put("DAF", "16333");
        marksCarCodes.put("Daihatsu", "23");
        marksCarCodes.put("Daimler", "16397");
        marksCarCodes.put("Dangel", "16434");
        marksCarCodes.put("De la Chapelle", "16423");
        marksCarCodes.put("Derways", "16391");
        marksCarCodes.put("Dodge", "2152");
        marksCarCodes.put("Donkervoort", "16339");
        marksCarCodes.put("DR Motor", "16383");
        marksCarCodes.put("DS Automobiles", "16415");
        marksCarCodes.put("Dutton", "51552");
        marksCarCodes.put("Estrima", "16436");
        marksCarCodes.put("Ferrari", "27");
        marksCarCodes.put("Fiat", "28");
        marksCarCodes.put("FISKER", "51543");
        marksCarCodes.put("Ford", "29");
        marksCarCodes.put("Gac Gonow", "51542");
        marksCarCodes.put("Galloper", "16337");
        marksCarCodes.put("GAZ", "16386");
        marksCarCodes.put("Geely", "16392");
        marksCarCodes.put("GEM", "16403");
        marksCarCodes.put("GEMBALLA", "51540");
        marksCarCodes.put("Giotti Victoria", "16421");
        marksCarCodes.put("GMC", "2153");
        marksCarCodes.put("Great Wall", "16382");
        marksCarCodes.put("Grecav", "16409");
        marksCarCodes.put("Haima", "51512");
        marksCarCodes.put("Hamann", "51534");
        marksCarCodes.put("Honda", "31");
        marksCarCodes.put("HUMMER", "15674");
        marksCarCodes.put("Hurtan", "51767");
        marksCarCodes.put("Hyundai", "33");
        marksCarCodes.put("Infiniti", "16355");
        marksCarCodes.put("Innocenti", "15629");
        marksCarCodes.put("Iso Rivolta", "16402");
        marksCarCodes.put("Isuzu", "35");
        marksCarCodes.put("Iveco", "14882");
        marksCarCodes.put("IZH", "16387");
        marksCarCodes.put("Jaguar", "37");
        marksCarCodes.put("Jeep", "38");
        marksCarCodes.put("Karabag", "16417");
        marksCarCodes.put("Kia", "39");
        marksCarCodes.put("KTM", "50060");
        marksCarCodes.put("Lada", "40");
        marksCarCodes.put("Lamborghini", "41");
        marksCarCodes.put("Lancia", "42");
        marksCarCodes.put("Land Rover", "15641");
        marksCarCodes.put("LDV", "16426");
        marksCarCodes.put("Lexus", "43");
        marksCarCodes.put("Lifan", "16393");
        marksCarCodes.put("Ligier", "16353");
        marksCarCodes.put("Lincoln", "14890");
        marksCarCodes.put("Lotus", "44");
        marksCarCodes.put("Mahindra", "16359");
        marksCarCodes.put("Mansory", "16435");
        marksCarCodes.put("Martin Motors", "16410");
        marksCarCodes.put("Maserati", "45");
        marksCarCodes.put("Maybach", "16348");
        marksCarCodes.put("Mazda", "46");
        marksCarCodes.put("McLaren", "51519");
        marksCarCodes.put("Melex", "16399");
        marksCarCodes.put("Mercedes-Benz", "47");
        marksCarCodes.put("MG", "48");
        marksCarCodes.put("Microcar", "16361");
        marksCarCodes.put("Minauto", "51766");
        marksCarCodes.put("MINI", "16338");
        marksCarCodes.put("Mitsubishi", "50");
        marksCarCodes.put("Morgan", "51");
        marksCarCodes.put("Moskvich", "16388");
        marksCarCodes.put("MP Lafer", "51554");
        marksCarCodes.put("Nissan", "52");
        marksCarCodes.put("Oldsmobile", "53");
        marksCarCodes.put("Oldtimer", "15670");
        marksCarCodes.put("Opel", "54");
        marksCarCodes.put("Pagani", "16341");
        marksCarCodes.put("Panther Westwinds", "51553");
        marksCarCodes.put("Peugeot", "55");
        marksCarCodes.put("PGO", "50083");
        marksCarCodes.put("Piaggio", "16350");
        marksCarCodes.put("Plymouth", "51770");
        marksCarCodes.put("Pontiac", "56");
        marksCarCodes.put("Porsche", "57");
        marksCarCodes.put("Proton", "15636");
        marksCarCodes.put("Puch", "15646");
        marksCarCodes.put("Puch", "51768");
        marksCarCodes.put("Qoros", "16412");
        marksCarCodes.put("Qvale", "16425");
        marksCarCodes.put("Reliant", "16398");
        marksCarCodes.put("Renault", "60");
        marksCarCodes.put("Rolls-Royce", "61");
        marksCarCodes.put("Rover", "62");
        marksCarCodes.put("Ruf", "51536");
        marksCarCodes.put("Saab", "63");
        marksCarCodes.put("Santana", "16369");
        marksCarCodes.put("Savel", "16405");
        marksCarCodes.put("SDG", "51771");
        marksCarCodes.put("SEAT", "64");
        marksCarCodes.put("Skoda", "65");
        marksCarCodes.put("smart", "15525");
        marksCarCodes.put("SpeedArt", "51538");
        marksCarCodes.put("Spyker", "16377");
        marksCarCodes.put("SsangYong", "66");
        marksCarCodes.put("Subaru", "67");
        marksCarCodes.put("Suzuki", "68");
        marksCarCodes.put("TagAZ", "16395");
        marksCarCodes.put("Talbot", "51551");
        marksCarCodes.put("Tasso", "16404");
        marksCarCodes.put("Tata", "16327");
        marksCarCodes.put("Tazzari EV", "51557");
        marksCarCodes.put("TECHART", "51535");
        marksCarCodes.put("Tesla", "51520");
        marksCarCodes.put("Town Life", "16420");
        marksCarCodes.put("Toyota", "70");
        marksCarCodes.put("Trabant", "15633");
        marksCarCodes.put("Trailer-Anhänger", "16326");
        marksCarCodes.put("Triumph", "2120");
        marksCarCodes.put("Trucks-Lkw", "16253");
        marksCarCodes.put("TVR", "71");
        marksCarCodes.put("UAZ", "16389");
        marksCarCodes.put("VAZ", "16385");
        marksCarCodes.put("VEM", "16422");
        marksCarCodes.put("Volkswagen", "74");
        marksCarCodes.put("Volvo", "73");
        marksCarCodes.put("Vortex", "51514");
        marksCarCodes.put("Wartburg", "16336");
        marksCarCodes.put("Westfield", "51513");
        marksCarCodes.put("Wiesmann", "16351");
        marksCarCodes.put("Zastava", "16408");
        marksCarCodes.put("ZAZ", "16394");
        marksCarCodes.put("Sonstige", "16328");
    }

    static {
        fuelTypeCodes.put("Benzin", "B");
        fuelTypeCodes.put("Diesel", "D");
        fuelTypeCodes.put("Elektro", "E");
        fuelTypeCodes.put("Ethanol (FFV, E85 etc.)", "M");
        fuelTypeCodes.put("Hybrid (Benzin/Elektro)", "2");
        fuelTypeCodes.put("Hybrid (Diesel/Elektro)", "3");
        fuelTypeCodes.put("Autogaz (LPG)", "L");
        fuelTypeCodes.put("Erdgas (CNG)", "C");
        fuelTypeCodes.put("Wasserstoff", "H");
        fuelTypeCodes.put("Sonstige", "O");
    }

    static {
        gearTypeCodes.put("Automatik", "A");
        gearTypeCodes.put("Halbautomatik", "S");
        gearTypeCodes.put("Manuell", "M");
    }

    static {
        extColorCodes.put("Schwarz", "11");
        extColorCodes.put("Grau", "6");
        extColorCodes.put("Silber", "12");
        extColorCodes.put("Weiß", "14");
        extColorCodes.put("Rot", "10");
        extColorCodes.put("Blau", "2");
        extColorCodes.put("Gelb", "5");
        extColorCodes.put("Grün", "7");
        extColorCodes.put("Beige", "1");
        extColorCodes.put("Gold", "16");
        extColorCodes.put("Braun", "3");
        extColorCodes.put("Orange", "15");
        extColorCodes.put("Bronze", "4");
        extColorCodes.put("Violett", "13");
    }

    static {
        sortTypeCodes.put("Standard", "standard");
        sortTypeCodes.put("Preis aufsteigend", "price");
        sortTypeCodes.put("Preis absteigend", "price&desc=1");
        sortTypeCodes.put("Neueste Angebote zuerst", "age&desc=1");
        sortTypeCodes.put("Kilometerstand aufsteigend", "mileage");
        sortTypeCodes.put("Kilometerstand absteigend", "mileage&desc=1");
        sortTypeCodes.put("Erstzulassung aufsteigend", "year");
        sortTypeCodes.put("Erstzulassung absteigend", "year&desc=1");
    }

    static {
        landCodes.put("Belgien", "B");
        landCodes.put("Deutschland", "D");
        landCodes.put("Frankreich", "F");
        landCodes.put("Italien", "I");
        landCodes.put("Luxembourg", "L");
        landCodes.put("Niederlande", "NL");
        landCodes.put("Österreich", "A");
        landCodes.put("Spanien", "E");
    }

    static {
        carTypeCodes.put("Kleinwagen", "1");
        carTypeCodes.put("Cabrio", "2");
        carTypeCodes.put("Coupé", "3");
        carTypeCodes.put("SUV/Geländewagen", "4");
        carTypeCodes.put("Limousine", "6");
        carTypeCodes.put("Kombi", "5");
        carTypeCodes.put("Transporter", "13");
        carTypeCodes.put("Van/Kleinbus", "12");
    }

    static {
        damagedCarsCodes.put("Nicht anzeigen","N,U");
        damagedCarsCodes.put("Nur anzeigen","A");
        damagedCarsCodes.put("Auch anzeigen","A,N,U");
    }

    static {
        providerCodes.put("Händler","D");
        providerCodes.put("Privat","P");
    }

    static {
        interiorEquipCodes.put("Alcantara","AL");
        interiorEquipCodes.put("Vollleder","FL");
        interiorEquipCodes.put("Teilleder","PL");
        interiorEquipCodes.put("Stoff","CL");
        interiorEquipCodes.put("Velours","VL");
    }

}