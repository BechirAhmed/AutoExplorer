package auto.explorer.parser.mobile.de;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eugene on 20.10.2016
 */

class MapsMobileDe {

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
        marksCar.put("Abarth", new String[]{"10", "124 Spider", "2", "500", "3", "500C", "6", "595", "7", "595C", "11", "595 Competizione", "12", "595 Turismo", "8", "695", "9", "695C", "5", "Grande Punto", "4", "Punto Evo", "1", "Sonstige"});
        marksCar.put("AC", new String[]{"1", "Sonstige"});
        marksCar.put("Acura", new String[]{"2", "MDX", "3", "NSX", "4", "RL", "5", "RSX", "6", "TL", "7", "TSX", "1", "Sonstige"});
        marksCar.put("Aixam", new String[]{"11", "City", "5", "Crossline", "12", "Roadline", "13", "Scouty R", "1", "Sonstige"});
        marksCar.put("Alfa Romeo", new String[] {"29", "4C", "25", "8C", "5", "Alfa 145", "6", "Alfa 146", "7", "Alfa 147", "8", "Alfa 155", "9", "Alfa 156", "10", "Alfa 159", "11", "Alfa 164", "12", "Alfa 166", "2", "Alfa 33", "3", "Alfa 75", "4", "Alfa 90", "13", "Alfasud", "14", "Alfetta", "15", "Brera", "23", "Crosswagon", "16", "Giulia", "17", "Giulietta", "18", "GT", "19", "GTV", "27", "Junior", "28", "MiTo", "21", "Spider", "22", "Sprint", "1", "Sonstige"});
        marksCar.put("Alpina", new String[] {"2", "B10", "3", "B12", "4", "B3", "14", "B4", "5", "B5", "6", "B6", "7", "B7", "8", "B8", "9", "D10", "11", "D3", "15", "D4", "12", "D5", "10", "Roadster S", "13", "XD3", "1", "Sonstige"});
        marksCar.put("Artega", new String[] {"2", "GT", "1", "Sonstige"});
        marksCar.put("Asia Motors", new String[] {"3", "Rocsta", "1", "Sonstige"});
        marksCar.put("Aston Martin", new String[] {"2", "AR1", "16", "Cygnet", "3", "DB", "17", "DB11", "4", "DB7", "5", "DB9", "14", "DBS", "6", "Lagonda", "12", "Rapide", "15", "V12 Vantage", "13", "V8 Vantage", "7", "Vanquish", "10", "Virage", "1", "Sonstige"});
        marksCar.put("Audi", new String[]{"2", "100", "3", "200", "5", "80", "6", "90", "25", "A1", "7", "A2", "8", "A3", "9", "A4", "33", "A4 Allroad", "31", "A5", "10", "A6", "12", "A6 Allroad", "34", "A7", "11", "A8", "13", "Cabriolet", "14", "Coupé", "45", "Q2", "37", "Q3", "32", "Q5", "15", "Q7", "16", "QUATTRO", "29", "R8", "26", "RS2", "36", "RS3", "27", "RS4", "17", "RS5", "28", "RS6", "40", "RS7", "41", "RSQ3", "42", "S1", "18", "S2", "19", "S3", "20", "S4", "30", "S5", "21", "S6", "38", "S7", "22", "S8", "39", "SQ5", "44", "SQ7", "23", "TT", "35", "TT RS", "4", "TTS", "24", "V8", "1", "Sonstige"});
        marksCar.put("Austin", new String[] {"1", "Sonstige"});
        marksCar.put("Austin Healey", new String[] {"1", "Sonstige"});
        marksCar.put("Bentley", new String[] {"2", "Arnage", "3", "Azure", "16", "Bentayga", "4", "Brooklands", "5", "Continental", "14", "Continental Flying Spur", "11", "Continental GT", "12", "Continental GTC", "13", "Continental Supersports", "6", "Eight", "15", "Flying Spur", "7", "Mulsanne", "8", "Turbo R", "9", "Turbo RT", "10", "Turbo S", "1", "Sonstige"});
        marksCar.put("BMW", new String[] {"73", "114", "2", "116", "3", "118", "4", "120", "59", "123", "61", "125", "5", "130", "58", "135", "87", "1er M Coupé", "71", "2002", "110", "214 Active Tourer", "116", "214 Gran Tourer", "106", "216", "111", "216 Active Tourer", "114", "216 Gran Tourer", "90", "218", "107", "218 Active Tourer", "112", "218 Gran Tourer", "84", "220", "108", "220 Active Tourer", "113", "220 Gran Tourer", "91", "225", "109", "225 Active Tourer", "104", "228", "7", "315", "8", "316", "9", "318", "75", "318 Gran Turismo", "10", "320", "76", "320 Gran Turismo", "11", "323", "12", "324", "13", "325", "88", "325 Gran Turismo", "14", "328", "77", "328 Gran Turismo", "15", "330", "103", "330 Gran Turismo", "56", "335", "78", "335 Gran Turismo", "118", "340", "72", "ActiveHybrid 3", "115", "418", "98", "418 Gran Coupé", "80", "420", "99", "420 Gran Coupé", "102", "425", "124", "425 Gran Coupé", "81", "428", "100", "428 Gran Coupé", "83", "430", "105", "430 Gran Coupé", "82", "435", "101", "435 Gran Coupé", "120", "440", "121", "440 Gran Coupé", "16", "518", "17", "520", "74", "520 Gran Turismo", "18", "523", "19", "524", "20", "525", "21", "528", "22", "530", "65", "530 Gran Turismo", "23", "535", "66", "535 Gran Turismo", "24", "540", "25", "545", "26", "550", "67", "550 Gran Turismo", "70", "ActiveHybrid 5", "27", "628", "28", "630", "29", "633", "30", "635", "68", "640", "94", "640 Gran Coupé", "31", "645", "32", "650", "95", "650 Gran Coupé", "33", "725", "34", "728", "35", "730", "36", "732", "37", "735", "38", "740", "39", "745", "40", "750", "41", "760", "63", "ActiveHybrid 7", "42", "840", "43", "850", "79", "i3", "89", "i8", "69", "M135", "122", "M140i", "117", "M2", "85", "M235", "123", "M240i", "45", "M3", "93", "M4", "46", "M5", "86", "M550", "47", "M6", "64", "ActiveHybrid X6", "6", "X1", "48", "X3", "92", "X4", "119", "X4 M40", "49", "X5", "53", "X5 M", "96", "X5 M50", "60", "X6", "62", "X6 M", "97", "X6 M50", "50", "Z1", "51", "Z3", "57", "Z3 M", "52", "Z4", "55", "Z4 M", "54", "Z8", "1", "Sonstige"});
        marksCar.put("Borgward", new String[] {"1", "Sonstige"});
        marksCar.put("Brilliance", new String[] {"2", "BC3", "3", "BS2", "4", "BS4", "5", "BS6", "1", "Sonstige"});
        marksCar.put("Bugatti", new String[] {"4", "Chiron", "2", "EB 110", "3", "Veyron", "1", "Sonstige"});
        marksCar.put("Buick", new String[] {"2", "Century", "3", "Electra", "11", "Enclave", "10", "La Crosse", "4", "Le Sabre", "5", "Park Avenue", "6", "Regal", "7", "Riviera", "8", "Roadmaster", "9", "Skylark", "1", "Sonstige"});
        marksCar.put("Cadillac", new String[] {"2", "Allante", "13", "ATS", "3", "BLS", "14", "CT6", "4", "CTS", "5", "Deville", "6", "Eldorado", "7", "Escalade", "8", "Fleetwood", "9", "Seville", "10", "SRX", "11", "STS", "12", "XLR", "15", "XT5", "1", "Sonstige"});
        marksCar.put("Casalini", new String[] {"1", "Sonstige"});
        marksCar.put("Caterham", new String[] {"1", "Sonstige"});
        marksCar.put("Chatenet", new String[] {"1", "Sonstige"});
        marksCar.put("Chevrolet", new String[] {"2", "2500", "3", "Alero", "4", "Astro", "5", "Avalanche", "45", "Aveo", "7", "Beretta", "8", "Blazer", "9", "C1500", "10", "Camaro", "11", "Caprice", "47", "Captiva", "12", "Cavalier", "43", "Chevelle", "14", "Chevy Van", "15", "Citation", "48", "Colorado", "16", "Corsica", "51", "Cruze", "20", "El Camino", "49", "Epica", "21", "Evanda", "18", "Express", "22", "G", "50", "HHR", "23", "Impala", "24", "K1500", "25", "K30", "26", "Kalos", "27", "Lacetti", "28", "Lumina", "29", "Malibu", "30", "Matiz", "32", "Nubira", "17", "Orlando", "33", "Rezzo", "34", "S-10", "35", "Silverado", "13", "Spark", "36", "SSR", "37", "Suburban", "39", "Tahoe", "41", "Trailblazer", "42", "Trans Sport", "31", "Trax", "44", "Venture", "19", "Volt", "1", "Sonstige"});
        marksCar.put("Chrysler", new String[] {"3", "300C", "2", "300 M", "22", "Aspen", "4", "Crossfire", "5", "Daytona", "6", "ES", "7", "Grand Voyager", "8", "GS", "9", "GTS", "23", "Imperial", "10", "Le Baron", "11", "Neon", "12", "New Yorker", "13", "Pacifica", "14", "PT Cruiser", "15", "Saratoga", "16", "Sebring", "17", "Stratus", "18", "Valiant", "19", "Viper", "20", "Vision", "21", "Voyager", "1", "Sonstige"});
        marksCar.put("Citroen", new String[] {"2", "2 CV", "4", "AX", "5", "Berlingo", "6", "BX", "7", "C1", "9", "C2", "11", "C3", "8", "C3 Picasso", "12", "C4", "36", "C4 Aircross", "37", "C4 Cactus", "32", "C4 Picasso", "13", "C5", "14", "C6", "15", "C8", "33", "C-Crosser", "38", "C-Elysée", "16", "CX", "31", "C-Zero", "17", "DS", "20", "DS3", "22", "DS4", "40", "DS4 Crossback", "35", "DS5", "18", "Evasion", "34", "Grand C4 Picasso", "19", "GSA", "10", "Jumper", "21", "Jumpy", "3", "Nemo", "23", "SAXO", "24", "SM", "39", "SpaceTourer", "25", "Visa", "26", "Xantia", "27", "XM", "28", "Xsara", "29", "Xsara Picasso", "30", "ZX", "1", "Sonstige"});
        marksCar.put("Cobra", new String[] {"1", "Sonstige"});
        marksCar.put("Corvette", new String[] {"8", "C1", "9", "C2", "2", "C3", "3", "C4", "4", "C5", "5", "C6", "10", "C7", "7", "Z06", "6", "ZR 1", "1", "Sonstige"});
        marksCar.put("Dacia", new String[] {"5", "Dokker", "2", "Duster", "3", "Lodgy", "6", "Logan", "4", "Logan Pick-Up", "7", "Pick Up", "24", "Sandero", "1", "Sonstige"});
        marksCar.put("Daewoo", new String[] {"3", "Espero", "4", "Evanda", "5", "Kalos", "6", "Korando", "7", "Lacetti", "8", "Lanos", "9", "Leganza", "10", "Matiz", "11", "Musso", "12", "Nexia", "13", "Nubira", "14", "Rezzo", "15", "Tacuma", "1", "Sonstige"});
        marksCar.put("Daihatsu", new String[] {"2", "Applause", "3", "Charade", "4", "Charmant", "5", "Copen", "6", "Cuore", "8", "Feroza/Sportrak", "9", "Freeclimber", "10", "Gran Move", "11", "Hijet", "19", "MATERIA", "12", "Move", "13", "Rocky/Fourtrak", "14", "Sirion", "16", "Terios", "20", "TREVIS", "18", "YRV", "1", "Sonstige"});
        marksCar.put("DeTomaso", new String[] {"2", "Guarà", "3", "Pantera", "1", "Sonstige"});
        marksCar.put("Dodge", new String[] {"18", "Avenger", "14", "Caliber", "8", "Challenger", "2", "Charger", "3", "Dakota", "17", "Demon", "4", "Durango", "5", "Grand Caravan", "15", "Hornet", "19", "Journey", "6", "Magnum", "7", "Neon", "16", "Nitro", "13", "RAM", "9", "Stealth", "12", "Viper", "1", "Sonstige"});
        marksCar.put("Donkervoort", new String[] {"2", "D8", "4", "S7", "3", "S8", "1", "Sonstige"});
        marksCar.put("DS Automobiles", new String[] {"2", "DS3", "3", "DS4", "5", "DS4 Crossback", "4", "DS5", "1", "Sonstige"});
        marksCar.put("Ferrari", new String[] {"4", "208", "5", "246", "6", "250", "7", "275", "8", "288", "9", "308", "10", "328", "11", "330", "12", "348", "14", "360", "15", "365", "16", "400", "17", "412", "18", "456", "2", "458", "28", "488 GTB", "40", "488 Spider", "19", "512", "33", "550", "21", "575", "37", "599 GTB", "32", "599 GTO", "39", "599 SA Aperta", "22", "612", "23", "750", "38", "California", "24", "Daytona", "25", "Dino GT4", "26", "Enzo Ferrari", "13", "F12", "27", "F355", "29", "F40", "30", "F430", "31", "F50", "3", "FF", "20", "LaFerrari", "34", "Mondial", "35", "Superamerica", "36", "Testarossa", "1", "Sonstige"});
        marksCar.put("Fiat", new String[] {"2", "124", "54", "124 Spider", "4", "126", "5", "127", "6", "130", "7", "131", "9", "500", "49", "500C", "48", "500L", "51", "500L Living", "52", "500L Trekking", "53", "500X", "25", "Albea", "10", "Barchetta", "11", "Brava", "12", "Bravo", "14", "Cinquecento", "15", "Coupe", "16", "Croma", "17", "Dino", "18", "Doblo", "19", "Ducato", "21", "Fiorino", "47", "Freemont", "55", "Fullback", "44", "Grande Punto", "22", "Idea", "46", "Linea", "23", "Marea", "24", "Marengo", "26", "Multipla", "50", "New Panda", "27", "Palio", "28", "Panda", "30", "Punto", "38", "Punto Evo", "13", "Qubo", "31", "Regata", "32", "Ritmo", "33", "Scudo", "45", "Sedici", "34", "Seicento", "29", "Siena", "35", "Spider Europa", "36", "Stilo", "37", "Strada", "56", "Talento", "39", "Tempra", "40", "Tipo", "41", "Ulysse", "42", "Uno", "43", "X 1/9", "1", "Sonstige"});
        marksCar.put("FISKER", new String[] {"2", "Karma", "1", "Sonstige"});
        marksCar.put("Ford", new String[] {"2", "Aerostar", "54", "B-Max", "3", "Bronco", "4", "Capri", "52", "C-Max", "5", "Cougar", "6", "Courier", "7", "Crown", "8", "Econoline", "9", "Econovan", "56", "EcoSport", "48", "Edge", "10", "Escape", "11", "Escort", "12", "Excursion", "13", "Expedition", "14", "Explorer", "15", "Express", "16", "F 150", "17", "F 250", "18", "F 350", "45", "Fairlane", "46", "Falcon", "19", "Fiesta", "53", "Flex", "20", "Focus", "22", "Fusion", "23", "Galaxy", "24", "Granada", "50", "Grand C-Max", "59", "Grand Tourneo", "44", "GT", "25", "Ka", "49", "Kuga", "27", "Maverick", "28", "Mercury", "29", "Mondeo", "30", "Mustang", "31", "Orion", "32", "Probe", "33", "Puma", "34", "Ranger", "55", "Raptor", "35", "Scorpio", "36", "Sierra", "47", "S-Max", "26", "Sportka", "37", "Streetka", "38", "Taunus", "39", "Taurus", "40", "Thunderbird", "41", "Tourneo", "61", "Tourneo Connect", "60", "Tourneo Courier", "62", "Tourneo Custom", "42", "Transit", "51", "Transit Connect", "58", "Transit Courier", "57", "Transit Custom", "43", "Windstar", "1", "Sonstige"});
        marksCar.put("Gac Gonow", new String[] {"1", "Sonstige"});
        marksCar.put("GEMBALLA", new String[] {"1", "Sonstige"});
        marksCar.put("GMC", new String[] {"11", "Acadia", "2", "Envoy", "3", "Safari", "4", "Savana", "5", "Sierra", "6", "Sonoma", "7", "Syclone", "8", "Typhoon", "9", "Vandura", "10", "Yukon", "1", "Sonstige"});
        marksCar.put("Grecav", new String[] {"2", "Sonique", "1", "Sonstige"});
        marksCar.put("Hamann", new String[] {"1", "Sonstige"});
        marksCar.put("Honda", new String[] {"2", "Accord", "21", "Aerodeck", "3", "Civic", "25", "Clarity", "4", "Concerto", "5", "CR-V", "6", "CRX", "24", "CR-Z", "7", "Element", "8", "FR-V", "9", "HR-V", "10", "Insight", "11", "Integra", "12", "Jazz", "13", "Legend", "14", "Logo", "15", "NSX", "16", "Odyssey", "17", "Prelude", "18", "S2000", "19", "Shuttle", "20", "Stream", "1", "Sonstige"});
        marksCar.put("HUMMER", new String[] {"3", "H1", "4", "H2", "5", "H3", "1", "Sonstige"});
        marksCar.put("Hyundai", new String[] {"2", "Accent", "3", "Atos", "24", "Azera", "4", "Coupe", "5", "Elantra", "6", "Excel", "7", "Galloper", "15", "Genesis", "8", "Getz", "9", "Grandeur", "38", "Grand Santa Fe", "13", "H-1", "10", "H 100", "14", "H-1 Starex", "11", "H 200", "39", "H350", "31", "i10", "32", "i20", "30", "i30", "33", "i40", "34", "i50", "40", "IONIQ", "36", "ix20", "12", "ix35", "35", "ix55", "16", "Lantra", "17", "Matrix", "18", "Pony", "19", "Santa Fe", "20", "Santamo", "22", "S-Coupe", "23", "Sonata", "25", "Terracan", "26", "Trajet", "27", "Tucson", "37", "Veloster", "21", "Veracruz", "28", "XG 30", "29", "XG 350", "1", "Sonstige"});
        marksCar.put("Infiniti", new String[] {"12", "EX30", "8", "EX35", "5", "EX37", "2", "FX", "3", "G35", "4", "G37", "9", "M30", "11", "M35", "10", "M37", "18", "Q30", "6", "Q45", "13", "Q50", "14", "Q60", "15", "Q70", "19", "QX30", "16", "QX50", "7", "QX56", "17", "QX70", "1", "Sonstige"});
        marksCar.put("Isuzu", new String[] {"2", "Campo", "10", "D-Max", "4", "Gemini", "5", "Midi", "8", "PICK UP", "9", "Trooper", "1", "Sonstige"});
        marksCar.put("Iveco", new String[] {"2", "Massif", "1", "Sonstige"});
        marksCar.put("Jaguar", new String[] {"2", "Daimler", "20", "E-Type", "6", "F-Pace", "3", "F-Type", "5", "MK II", "7", "S-Type", "4", "XE", "24", "XF", "9", "XJ", "10", "XJ12", "11", "XJ40", "12", "XJ6", "13", "XJ8", "14", "XJR", "15", "XJS", "16", "XJSC", "23", "XK", "22", "XKR", "19", "X-Type", "1", "Sonstige"});
        marksCar.put("Jeep", new String[] {"2", "Cherokee", "4", "CJ", "6", "Comanche", "12", "Commander", "13", "Compass", "7", "Grand Cherokee", "14", "Patriot", "8", "Renegade", "9", "Wagoneer", "10", "Willys", "11", "Wrangler", "1", "Sonstige"});
        marksCar.put("Kia", new String[] {"2", "Besta", "28", "Borrego", "3", "Carens", "4", "Carnival", "26", "cee'd", "31", "cee'd Sportswagon", "5", "Cerato", "6", "Clarus", "7", "Elan", "8", "Joice", "9", "K2500", "10", "K2700", "11", "Leo", "12", "Magentis", "13", "Mentor", "30", "Mini", "34", "Niro", "14", "Opirus", "33", "Optima", "15", "Picanto", "16", "Pregio", "17", "Pride", "27", "pro_cee'd", "18", "Retona", "19", "Rio", "20", "Roadster", "21", "Rocsta", "22", "Sephia", "23", "Shuma", "24", "Sorento", "29", "Soul", "25", "Sportage", "32", "Venga", "1", "Sonstige"});
        marksCar.put("KTM", new String[] {"2", "X-BOW", "1", "Sonstige"});
        marksCar.put("Lada", new String[] {"2", "110", "3", "111", "4", "112", "5", "1200", "6", "2107", "7", "2110", "8", "2111", "9", "2112", "10", "Aleko", "11", "Forma", "17", "Granta", "15", "Kalina", "12", "Niva", "13", "Nova", "16", "Priora", "14", "Samara", "19", "Taiga", "20", "Urban", "18", "Vesta", "21", "X-Ray", "1", "Sonstige"});
        marksCar.put("Lamborghini", new String[] {"11", "Aventador", "2", "Countach", "3", "Diablo", "4", "Espada", "5", "Gallardo", "12", "Huracán", "6", "Jalpa", "7", "LM", "8", "Miura", "9", "Murciélago", "10", "Urraco", "1", "Sonstige"});
        marksCar.put("Lancia", new String[] {"2", "Beta", "3", "Dedra", "4", "Delta", "5", "Flaminia", "17", "Flavia", "6", "Fulvia", "7", "Gamma", "9", "Kappa", "10", "Lybra", "11", "MUSA", "12", "Phedra", "13", "Prisma", "14", "Stratos", "15", "Thema", "16", "Thesis", "8", "Voyager", "18", "Ypsilon", "20", "Zeta", "1", "Sonstige"});
        marksCar.put("Land Rover", new String[] {"2", "Defender", "3", "Discovery", "11", "Discovery Sport", "4", "Freelander", "5", "Range Rover", "10", "Range Rover Evoque", "6", "Range Rover Sport", "7", "Serie I", "8", "Serie II", "9", "Serie III", "1", "Sonstige"});
        marksCar.put("Lexus", new String[] {"30", "CT 200h", "17", "ES 300", "26", "ES 330", "23", "ES 350", "31", "GS 250", "2", "GS 300", "27", "GS 350", "3", "GS 430", "18", "GS 450", "24", "GS 460", "37", "GS F", "4", "GX 470", "5", "IS 200", "15", "IS 220", "16", "IS 250", "6", "IS 300", "28", "IS 350", "21", "IS-F", "36", "LFA", "7", "LS 400", "8", "LS 430", "19", "LS 460", "20", "LS 600", "9", "LX 470", "25", "LX 570", "32", "NX 200", "33", "NX 300", "35", "RC 200", "38", "RC 300", "40", "RC 350", "34", "RC F", "39", "RX 200", "10", "RX 300", "11", "RX 330", "22", "RX 350", "12", "RX 400", "29", "RX 450", "13", "SC 400", "14", "SC 430", "1", "Sonstige"});
        marksCar.put("Ligier", new String[] {"3", "Ambra", "14", "Be Sun", "11", "JS 50", "12", "JS 50 L", "13", "JS RC", "5", "Nova", "6", "Optima", "7", "X - Too", "1", "Sonstige"});
        marksCar.put("Lincoln", new String[] {"2", "Aviator", "3", "Continental", "4", "LS", "5", "Mark", "6", "Navigator", "7", "Town Car", "1", "Sonstige"});
        marksCar.put("Lotus", new String[] {"2", "340 R", "3", "Cortina", "4", "Elan", "5", "Elise", "6", "Elite", "7", "Esprit", "8", "Europa", "11", "Evora", "9", "Excel", "10", "Exige", "12", "Super Seven", "1", "Sonstige"});
        marksCar.put("Mahindra", new String[] {"1", "Sonstige"});
        marksCar.put("Maserati", new String[] {"2", "222", "3", "224", "4", "228", "5", "3200", "6", "418", "7", "420", "8", "4200", "9", "422", "10", "424", "11", "430", "12", "Biturbo", "14", "Ghibli", "13", "GranCabrio", "15", "Gransport", "24", "Granturismo", "16", "Indy", "17", "Karif", "21", "Levante", "18", "MC12", "19", "Merak", "20", "Quattroporte", "22", "Shamal", "23", "Spyder", "1", "Sonstige"});
        marksCar.put("Maybach", new String[] {"2", "57", "3", "62", "4", "Pullman", "1", "Sonstige"});
        marksCar.put("Mazda", new String[] {"2", "121", "3", "2", "4", "3", "5", "323", "6", "5", "7", "6", "8", "626", "9", "929", "23", "Bongo", "10", "B series", "28", "BT-50", "34", "CX-3", "33", "CX-5", "26", "CX-7", "27", "CX-9", "11", "Demio", "12", "E series", "24", "Millenia", "13", "MPV", "14", "MX-3", "15", "MX-5", "16", "MX-6", "17", "Premacy", "25", "Protege", "18", "RX-6", "19", "RX-7", "20", "RX-8", "21", "Tribute", "22", "Xedos", "1", "Sonstige"});
        marksCar.put("McLaren", new String[] {"6", "540C", "11", "570GT", "7", "570S", "10", "650S", "3", "650S Coupé", "4", "650S Spider", "8", "675LT", "9", "675LT Spider", "2", "MP4-12C", "5", "P1", "1", "Sonstige"});
        marksCar.put("Mercedes-Benz", new String[] {"126", "190", "127", "200", "128", "220", "129", "230", "130", "240", "131", "250", "132", "260", "133", "270", "134", "280", "135", "290", "136", "300", "137", "320", "138", "350", "139", "380", "140", "400", "141", "416", "142", "420", "143", "450", "144", "500", "145", "560", "146", "600", "2", "A 140", "3", "A 150", "4", "A 160", "5", "A 170", "6", "A 180", "7", "A 190", "8", "A 200", "9", "A 210", "221", "A 220", "220", "A 250", "229", "A 45 AMG", "242", "AMG GT", "247", "AMG GT S", "12", "B 150", "11", "B 160", "13", "B 170", "14", "B 180", "15", "B 200", "222", "B 220", "223", "B 250", "241", "B Electric Drive", "32", "CE 200", "167", "CE 220", "216", "CE 230", "217", "CE 280", "33", "CE 300", "234", "CE 320", "224", "Citan", "16", "C 160", "17", "C 180", "18", "C 200", "19", "C 220", "20", "C 230", "21", "C 240", "22", "C 250", "23", "C 270", "24", "C 280", "44", "C 300", "25", "C 30 AMG", "27", "C 320", "26", "C 32 AMG", "28", "C 350", "29", "C 36 AMG", "245", "C 400", "30", "C 43 AMG", "246", "C 450 AMG", "31", "C 55 AMG", "198", "C 63 AMG", "225", "CLA 180", "255", "CLA 180 Shooting Brake", "226", "CLA 200", "256", "CLA 200 Shooting Brake", "227", "CLA 220", "257", "CLA 220 Shooting Brake", "228", "CLA 250", "258", "CLA 250 Shooting Brake", "230", "CLA 45 AMG", "259", "CLA 45 AMG Shooting Brake", "248", "CLA Shooting Brake", "46", "CLC 160", "200", "CLC 180", "201", "CLC 200", "202", "CLC 220", "203", "CLC 230", "107", "CLC 250", "204", "CLC 350", "168", "CLK 200", "169", "CLK 220", "186", "CLK 230", "187", "CLK 240", "188", "CLK 270", "170", "CLK 280", "171", "CLK 320", "172", "CLK 350", "173", "CLK 430", "174", "CLK 500", "45", "CLK 55 AMG", "189", "CLK 63 AMG", "210", "CL 160", "35", "CL 180", "36", "CL 200", "37", "CL 220", "38", "CL 230", "211", "CL 320", "39", "CL 420", "40", "CL 500", "41", "CL 55 AMG", "42", "CL 600", "197", "CL 63 AMG", "43", "CL 65 AMG", "240", "CLS 220", "260", "CLS 220 Shooting Brake", "212", "CLS 250", "261", "CLS 250 Shooting Brake", "205", "CLS 280", "117", "CLS 300", "147", "CLS 320", "148", "CLS 350", "262", "CLS 350 Shooting Brake", "239", "CLS 400", "263", "CLS 400 Shooting Brake", "149", "CLS 500", "264", "CLS 500 Shooting Brake", "150", "CLS 55 AMG", "176", "CLS 63 AMG", "265", "CLS 63 AMG Shooting Brake", "249", "CLS Shooting Brake", "47", "E 200", "48", "E 220", "49", "E 230", "50", "E 240", "51", "E 250", "52", "E 260", "53", "E 270", "54", "E 280", "55", "E 290", "56", "E 300", "57", "E 320", "58", "E 350", "59", "E 36 AMG", "60", "E 400", "61", "E 420", "62", "E 430", "272", "E 43 AMG", "177", "E 50", "64", "E 500", "178", "E 55 AMG", "66", "E 60 AMG", "179", "E 63 AMG", "152", "G 230", "151", "G 240", "153", "G 250", "154", "G 270", "155", "G 280", "156", "G 290", "157", "G 300", "158", "G 320", "160", "G 350", "159", "G 400", "161", "G 500", "68", "G 55 AMG", "218", "G 63 AMG", "219", "G 65 AMG", "238", "GLA 180", "231", "GLA 200", "232", "GLA 220", "233", "GLA 250", "236", "GLA 45 AMG", "253", "GLC 220", "254", "GLC 250", "278", "GLC 350", "279", "GLC 43 AMG", "266", "GLE 250", "251", "GLE 350", "252", "GLE 400", "243", "GLE 450 AMG", "267", "GLE 500", "250", "GLE 63 AMG", "175", "GLK 200", "206", "GLK 220", "63", "GLK 250", "207", "GLK 280", "65", "GLK 300", "208", "GLK 320", "209", "GLK 350", "180", "GL 320", "166", "GL 350", "244", "GL 400", "181", "GL 420", "182", "GL 450", "183", "GL 500", "196", "GL 55 AMG", "195", "GL 63 AMG", "268", "GLS 350", "269", "GLS 400", "270", "GLS 500", "271", "GLS 63", "70", "MB 100", "71", "ML 230", "215", "ML 250", "72", "ML 270", "73", "ML 280", "67", "ML 300", "74", "ML 320", "75", "ML 350", "76", "ML 400", "192", "ML 420", "77", "ML 430", "69", "ML 450", "78", "ML 500", "79", "ML 55 AMG", "162", "ML 63 AMG", "190", "R 280", "92", "R 300", "80", "R 320", "81", "R 350", "82", "R 500", "184", "R 63 AMG", "213", "S 250", "185", "S 260", "83", "S 280", "84", "S 300", "85", "S 320", "86", "S 350", "87", "S 400", "88", "S 420", "89", "S 430", "191", "S 450", "90", "S 500", "91", "S 55", "193", "S 550", "93", "S 600", "194", "S 63 AMG", "94", "S 65 AMG", "274", "SLC 180", "275", "SLC 200", "273", "SLC 250", "276", "SLC 300", "277", "SLC 43 AMG", "108", "SLK 200", "109", "SLK 230", "214", "SLK 250", "110", "SLK 280", "10", "SLK 300", "112", "SLK 320", "111", "SLK 32 AMG", "113", "SLK 350", "114", "SLK 55 AMG", "95", "SL 280", "96", "SL 300", "97", "SL 320", "98", "SL 350", "99", "SL 380", "237", "SL 400", "100", "SL 420", "101", "SL 450", "102", "SL 500", "103", "SL 55 AMG", "104", "SL 560", "105", "SL 600", "163", "SL 60 AMG", "199", "SL 63 AMG", "106", "SL 65 AMG", "164", "SL 70 AMG", "165", "SL 73 AMG", "115", "SLR", "34", "SLS AMG", "116", "Sprinter", "122", "Vaneo", "123", "Vario", "124", "Viano", "125", "Vito", "118", "V 200", "119", "V 220", "120", "V 230", "235", "V 250", "121", "V 280", "1", "Sonstige"});
        marksCar.put("MG", new String[] {"2", "MGA", "3", "MGB", "4", "MGF", "10", "Midget", "11", "Montego", "5", "TD", "6", "TF", "7", "ZR", "8", "ZS", "9", "ZT", "1", "Sonstige"});
        marksCar.put("Microcar", new String[] {"8", "DUÈ", "11", "Flex", "9", "M.Go", "10", "M-8", "2", "MC1", "3", "MC2", "12", "Virgo", "1", "Sonstige"});
        marksCar.put("MINI", new String[] {"22", "Cooper Cabrio", "23", "Cooper D Cabrio", "24", "Cooper S Cabrio", "25", "Cooper SD Cabrio", "26", "John Cooper Works Cabrio", "21", "One Cabrio", "8", "Cooper Clubman", "30", "Cooper D Clubman", "31", "Cooper S Clubman", "32", "Cooper SD Clubman", "33", "John Cooper Works Clubman", "27", "One Clubman", "28", "One D Clubman", "17", "Clubvan", "5", "Cooper Countryman", "37", "Cooper D Countryman", "38", "Cooper S Countryman", "39", "Cooper SD Countryman", "40", "John Cooper Works Countryman", "34", "One Countryman", "35", "One D Countryman", "11", "Cooper Coupé", "12", "Cooper S Coupé", "18", "Cooper SD Coupé", "13", "John Cooper Works Coupé", "2", "1000", "3", "1300", "4", "Cooper", "20", "Cooper D", "7", "Cooper S", "10", "Cooper SD", "9", "John Cooper Works", "6", "ONE", "19", "One D", "29", "One First", "42", "Cooper D Paceman", "41", "Cooper Paceman", "44", "Cooper SD Paceman", "43", "Cooper S Paceman", "45", "John Cooper Works Paceman", "14", "Cooper Roadster", "46", "Cooper SD Roadster", "15", "Cooper S Roadster", "16", "John Cooper Works Roadster", "1", "Sonstige"});
        marksCar.put("Mitsubishi", new String[] {"2", "3000 GT", "21", "ASX", "4", "Canter", "5", "Carisma", "6", "Colt", "7", "Cordia", "8", "Cosmos", "32", "Diamante", "9", "Eclipse", "25", "Electric Vehicle (i-MiEV)", "10", "Galant", "11", "Galloper", "12", "Grandis", "13", "L200", "14", "L300", "15", "L400", "16", "Lancer", "34", "Mirage", "17", "Montero", "18", "Outlander", "19", "Pajero", "20", "Pajero Pinin", "33", "Pick-up", "35", "Plug-in Hybrid Outlander", "22", "Santamo", "23", "Sapporo", "24", "Sigma", "26", "Space Gear", "27", "Space Runner", "28", "Space Star", "29", "Space Wagon", "30", "Starion", "31", "Tredia", "1", "Sonstige"});
        marksCar.put("Morgan", new String[] {"3", "4/4", "2", "Aero 8", "4", "Plus 4", "5", "Plus 8", "6", "Roadster", "1", "Sonstige"});
        marksCar.put("Nissan", new String[] {"42", "100 NX", "43", "200 SX", "44", "240 SX", "4", "280 ZX", "5", "300 ZX", "6", "350Z", "26", "370Z", "7", "Almera", "8", "Almera Tino", "45", "Altima", "9", "Armada", "10", "Bluebird", "11", "Cabstar", "12", "Cargo", "13", "Cherry", "3", "Cube", "59", "e-NV200", "57", "Evalia", "14", "Frontier", "49", "GT-R", "15", "Interstar", "52", "Juke", "16", "King Cab", "17", "Kubistar", "18", "Laurel", "53", "Leaf", "19", "Maxima", "20", "Micra", "21", "Murano", "22", "Navara", "23", "Note", "2", "NP 300", "54", "NV200", "56", "NV400", "24", "Pathfinder", "25", "Patrol", "55", "PickUp", "36", "Pixo", "27", "Prairie", "28", "Primastar", "29", "Primera", "58", "Pulsar", "47", "Qashqai", "50", "Qashqai+2", "30", "Quest", "46", "Sentra", "31", "Serena", "32", "Silvia", "33", "Skyline", "34", "Sunny", "35", "Terrano", "48", "Tiida", "37", "Titan", "38", "Trade", "39", "Urvan", "40", "Vanette", "41", "X-Trail", "1", "Sonstige"});
        marksCar.put("Oldsmobile", new String[] {"2", "Bravada", "3", "Custom Cruiser", "4", "Cutlass", "5", "Delta 88", "6", "Silhouette", "7", "Supreme", "8", "Toronado", "1", "Sonstige"});
        marksCar.put("Opel", new String[] {"38", "Adam", "2", "Agila", "28", "Ampera", "34", "Antara", "3", "Arena", "4", "Ascona", "5", "Astra", "6", "Calibra", "7", "Campo", "39", "Cascada", "32", "Cavalier", "8", "Combo", "9", "Commodore", "10", "Corsa", "11", "Diplomat", "12", "Frontera", "13", "GT", "35", "Insignia", "40", "Insignia CT", "14", "Kadett", "41", "Karl", "15", "Manta", "16", "Meriva", "37", "Mokka", "17", "Monterey", "18", "Monza", "19", "Movano", "33", "Nova", "20", "Omega", "21", "Pick Up Sportscap", "22", "Rekord", "23", "Senator", "24", "Signum", "25", "Sintra", "26", "Speedster", "27", "Tigra", "29", "Vectra", "30", "Vivaro", "31", "Zafira", "36", "Zafira Tourer", "1", "Sonstige"});
        marksCar.put("Pagani", new String[] {"3", "Huayra", "2", "Zonda", "1", "Sonstige"});
        marksCar.put("Peugeot", new String[] {"2", "1007", "3", "104", "4", "106", "5", "107", "47", "108", "46", "2008", "6", "204", "7", "205", "8", "206", "30", "207", "43", "208", "26", "3008", "45", "301", "9", "304", "10", "305", "11", "306", "12", "307", "32", "308", "13", "309", "31", "4007", "44", "4008", "14", "404", "15", "405", "16", "406", "17", "407", "35", "5008", "18", "504", "19", "505", "42", "508", "20", "604", "21", "605", "22", "607", "23", "806", "24", "807", "33", "Bipper", "39", "Bipper Tepee", "25", "Boxer", "27", "Expert", "40", "Expert Tepee", "38", "iOn", "28", "J5", "29", "Partner", "41", "Partner Tepee", "36", "RCZ", "34", "TePee", "48", "Traveller", "1", "Sonstige"});
        marksCar.put("Piaggio", new String[] {"3", "APE", "4", "APE TM", "2", "Porter", "1", "Sonstige"});
        marksCar.put("Plymouth", new String[] {"3", "Prowler", "1", "Sonstige"});
        marksCar.put("Pontiac", new String[] {"2", "6000", "4", "Bonneville", "5", "Fiero", "6", "Firebird", "7", "G6", "8", "Grand-Am", "9", "Grand-Prix", "10", "GTO", "11", "Montana", "12", "Solstice", "13", "Sunbird", "14", "Sunfire", "15", "Targa", "16", "Trans Am", "17", "Trans Sport", "18", "Vibe", "1", "Sonstige"});
        marksCar.put("Porsche", new String[] {"2", "356", "3", "911 Urmodell", "24", "930", "5", "964", "21", "991", "6", "993", "7", "996", "17", "997", "8", "912", "9", "914", "23", "918", "10", "924", "11", "928", "12", "944", "13", "959", "14", "962", "15", "968", "16", "Boxster", "20", "Carrera GT", "18", "Cayenne", "19", "Cayman", "22", "Macan", "4", "Panamera", "1", "Sonstige"});
        marksCar.put("Proton", new String[] {"2", "300 Serie", "7", "400 Serie", "1", "Sonstige"});
        marksCar.put("Renault", new String[] {"40", "Alpine A110", "2", "Alpine A310", "4", "Alpine V6", "5", "Avantime", "47", "Captur", "6", "Clio", "7", "Coupe", "8", "Espace", "9", "Express", "36", "Fluence", "10", "Fuego", "11", "Grand Espace", "42", "Grand Modus", "12", "Grand Scenic", "48", "Kadjar", "13", "Kangoo", "41", "Koleos", "14", "Laguna", "44", "Latitude", "15", "Mascott", "16", "Master", "17", "Megane", "18", "Modus", "19", "P 1400", "20", "R 11", "21", "R 14", "22", "R 18", "23", "R 19", "24", "R 20", "25", "R 21", "26", "R 25", "27", "R 30", "28", "R 4", "29", "R 5", "30", "R 6", "31", "R 9", "32", "Rapid", "33", "Safrane", "34", "Scenic", "35", "Spider", "49", "Talisman", "37", "Trafic", "38", "Twingo", "45", "Twizy", "39", "Vel Satis", "43", "Wind", "46", "ZOE", "1", "Sonstige"});
        marksCar.put("Rolls-Royce", new String[] {"3", "Corniche", "14", "Dawn", "4", "Flying Spur", "12", "Ghost", "5", "Park Ward", "6", "Phantom", "2", "Silver Cloud", "7", "Silver Dawn", "8", "Silver Seraph", "9", "Silver Shadow", "10", "Silver Spirit", "11", "Silver Spur", "13", "Wraith", "1", "Sonstige"});
        marksCar.put("Rover", new String[] {"2", "100", "3", "111", "4", "114", "34", "115", "5", "200", "6", "213", "7", "214", "8", "216", "35", "218", "9", "220", "10", "25", "11", "400", "12", "414", "13", "416", "14", "418", "15", "420", "16", "45", "17", "600", "18", "618", "19", "620", "20", "623", "21", "75", "22", "800", "23", "820", "24", "825", "25", "827", "36", "City Rover", "28", "Metro", "29", "Montego", "31", "SD", "32", "Streetwise", "1", "Sonstige"});
        marksCar.put("Ruf", new String[] {"1", "Sonstige"});
        marksCar.put("Saab", new String[] {"2", "90", "3", "900", "4", "9000", "5", "9-3", "10", "9-4X", "6", "9-5", "7", "96", "8", "9-7X", "9", "99", "1", "Sonstige"});
        marksCar.put("Santana", new String[] {"1", "Sonstige"});
        marksCar.put("SEAT", new String[] {"2", "Alhambra", "3", "Altea", "4", "Arosa", "13", "Ateca", "5", "Cordoba", "6", "Exeo", "7", "Ibiza", "8", "Inca", "9", "Leon", "10", "Malaga", "11", "Marbella", "12", "Mii", "14", "Terra", "15", "Toledo", "1", "Sonstige"});
        marksCar.put("Skoda", new String[] {"2", "105", "3", "120", "4", "130", "5", "135", "17", "Citigo", "6", "Fabia", "7", "Favorit", "8", "Felicia", "9", "Forman", "10", "Octavia", "14", "Pick-up", "16", "Praktik", "18", "Rapid", "13", "Roomster", "12", "Superb", "15", "Yeti", "1", "Sonstige"});
        marksCar.put("smart", new String[] {"2", "Crossblade", "3", "ForFour", "4", "ForTwo", "5", "Roadster", "1", "Sonstige"});
        marksCar.put("SpeedArt", new String[] {"1", "Sonstige"});
        marksCar.put("Spyker", new String[] {"3", "C8", "9", "C8 AILERON", "8", "C8 DOUBLE 12 S", "7", "C8 LAVIOLETTE SWB", "6", "C8 SPYDER SWB", "1", "Sonstige"});
        marksCar.put("SsangYong", new String[] {"8", "Actyon", "2", "Family", "3", "Korando", "4", "Kyron", "5", "MUSSO", "6", "REXTON", "7", "Rodius", "9", "Tivoli", "10", "XLV", "1", "Sonstige"});
        marksCar.put("Subaru", new String[] {"4", "B9 Tribeca", "5", "Baja", "12", "BRZ", "7", "Forester", "8", "Impreza", "9", "Justy", "10", "Legacy", "17", "Levorg", "11", "Libero", "13", "OUTBACK", "14", "SVX", "3", "Trezia", "2", "Tribeca", "15", "Vivio", "18", "WRX STI", "16", "XT", "6", "XV", "1", "Sonstige"});
        marksCar.put("Suzuki", new String[] {"2", "Alto", "3", "Baleno", "4", "Cappuccino", "5", "Carry", "13", "Celerio", "6", "Grand Vitara", "7", "Ignis", "14", "iK-2", "8", "Jimny", "11", "Kizashi", "9", "Liana", "10", "LJ", "17", "SJ Samurai", "24", "Splash", "18", "Super-Carry", "19", "Swift", "23", "SX4", "12", "SX4 S-Cross", "20", "Vitara", "21", "Wagon R+", "22", "X-90", "1", "Sonstige"});
        marksCar.put("Talbot", new String[] {"2", "Horizon", "3", "Samba", "1", "Sonstige"});
        marksCar.put("Tata", new String[] {"2", "Indica", "3", "Indigo", "10", "Nano", "4", "Safari", "6", "Sumo", "8", "Telcoline", "9", "Telcosport", "5", "Xenon", "1", "Sonstige"});
        marksCar.put("TECHART", new String[] {"1", "Sonstige"});
        marksCar.put("Tesla", new String[] {"5", "Model 3", "3", "Model S", "4", "Model X", "2", "Roadster", "1", "Sonstige"});
        marksCar.put("Toyota", new String[] {"2", "4-Runner", "47", "Alphard", "39", "Auris", "43", "Auris Touring Sports", "3", "Avalon", "4", "Avensis", "14", "Avensis Verso", "5", "Aygo", "6", "Camry", "7", "Carina", "8", "Celica", "48", "C-HR", "9", "Corolla", "40", "Corolla Verso", "10", "Cressida", "11", "Crown", "12", "Dyna", "45", "FCV", "38", "FJ", "49", "Fortuner", "31", "GT86", "16", "Hiace", "15", "Highlander", "17", "Hilux", "41", "IQ", "19", "Land Cruiser", "21", "Lite-Ace", "18", "Matrix", "46", "Mirai", "22", "MR 2", "23", "Paseo", "25", "Picnic", "26", "Previa", "27", "Prius", "42", "Prius+", "44", "Proace", "28", "RAV 4", "29", "Sequoia", "30", "Sienna", "32", "Starlet", "33", "Supra", "37", "Tacoma", "34", "Tercel", "35", "Tundra", "13", "Urban Cruiser", "20", "Verso", "24", "Verso-S", "36", "Yaris", "1", "Sonstige"});
        marksCar.put("Trabant", new String[] {"2", "601", "1", "Sonstige"});
        marksCar.put("Triumph", new String[] {"2", "Dolomite", "3", "Moss", "4", "Spitfire", "5", "TR3", "6", "TR4", "7", "TR5", "8", "TR6", "9", "TR7", "10", "TR8", "1", "Sonstige"});
        marksCar.put("TVR", new String[] {"3", "Chimaera", "4", "Griffith", "9", "Tuscan", "1", "Sonstige"});
        marksCar.put("Volkswagen", new String[] {"2", "181", "5", "Amarok", "10", "Beetle", "6", "Bora", "7", "Buggy", "9", "Caddy", "19", "CC", "12", "Corrado", "3", "Crafter", "41", "Eos", "13", "Fox", "14", "Golf", "55", "Golf Plus", "40", "Golf Sportsvan", "15", "Iltis", "16", "Jetta", "17", "Käfer", "18", "Karmann Ghia", "20", "LT", "21", "Lupo", "24", "New Beetle", "25", "Passat", "4", "Passat CC", "26", "Phaeton", "27", "Polo", "8", "Routan", "28", "Santana", "29", "Scirocco", "30", "Sharan", "42", "T1", "31", "T2", "46", "T3 andere", "44", "T3 Caravelle", "22", "T3 Kombi", "45", "T3 Multivan", "49", "T4 andere", "33", "T4 California", "47", "T4 Caravelle", "23", "T4 Kombi", "48", "T4 Multivan", "53", "T5 andere", "34", "T5 California", "50", "T5 Caravelle", "32", "T5 Kombi", "51", "T5 Multivan", "52", "T5 Shuttle", "61", "T5 Transporter", "59", "T6 andere", "58", "T6 California", "56", "T6 Caravelle", "57", "T6 Kombi", "43", "T6 Multivan", "60", "T6 Transporter", "35", "Taro", "54", "Tiguan", "36", "Touareg", "37", "Touran", "11", "up!", "39", "Vento", "38", "XL1", "1", "Sonstige"});
        marksCar.put("Volvo", new String[] {"2", "240", "3", "244", "4", "245", "5", "262", "6", "264", "7", "340", "8", "360", "9", "440", "10", "460", "11", "480", "12", "740", "13", "744", "14", "745", "15", "760", "17", "780", "18", "850", "19", "855", "20", "940", "21", "944", "22", "945", "23", "960", "24", "965", "38", "Amazon", "39", "C30", "25", "C70", "26", "Polar", "27", "S40", "28", "S60", "42", "S60 Cross Country", "29", "S70", "30", "S80", "31", "S90", "32", "V40", "41", "V40 Cross Country", "33", "V50", "16", "V60", "43", "V60 Cross Country", "34", "V70", "35", "V90", "40", "XC60", "36", "XC70", "37", "XC90", "1", "Sonstige"});
        marksCar.put("Wartburg", new String[] {"3", "311", "4", "353", "1", "Sonstige"});
        marksCar.put("Westfield", new String[] {"1", "Sonstige"});
        marksCar.put("Wiesmann", new String[] {"5", "MF 25", "2", "MF 28", "3", "MF 3", "4", "MF 30", "6", "MF 35", "7", "MF 4", "8", "MF 5", "1", "Sonstige"});
        marksCar.put("Sonstige", new String[] {"1", "Sonstige"});
    }

    static {
        marksCarCodes.put("Abarth", "140");
        marksCarCodes.put("AC", "203");
        marksCarCodes.put("Acura", "375");
        marksCarCodes.put("Aixam", "800");
        marksCarCodes.put("Alfa Romeo", "900");
        marksCarCodes.put("ALPINA", "1100");
        marksCarCodes.put("Artega", "121");
        marksCarCodes.put("Asia Motors", "1750");
        marksCarCodes.put("Aston Martin", "1700");
        marksCarCodes.put("Audi", "1900");
        marksCarCodes.put("Austin", "2000");
        marksCarCodes.put("Austin Healey", "1950");
        marksCarCodes.put("Bentley", "3100");
        marksCarCodes.put("BMW", "3500");
        marksCarCodes.put("Borgward", "3850");
        marksCarCodes.put("Brilliance", "4025");
        marksCarCodes.put("Bugatti", "4350");
        marksCarCodes.put("Buick", "4400");
        marksCarCodes.put("Cadillac", "4700");
        marksCarCodes.put("Casalini", "112");
        marksCarCodes.put("Caterham", "5300");
        marksCarCodes.put("Chatenet", "83");
        marksCarCodes.put("Chevrolet", "5600");
        marksCarCodes.put("Chrysler", "5700");
        marksCarCodes.put("Citroën", "5900");
        marksCarCodes.put("Cobra", "6200");
        marksCarCodes.put("Corvette", "6325");
        marksCarCodes.put("Dacia", "6600");
        marksCarCodes.put("Daewoo", "6800");
        marksCarCodes.put("Daihatsu", "7000");
        marksCarCodes.put("DeTomaso", "7400");
        marksCarCodes.put("Dodge", "7700");
        marksCarCodes.put("Donkervoort", "255");
        marksCarCodes.put("DS Automobiles", "235");
        marksCarCodes.put("Ferrari", "8600");
        marksCarCodes.put("Fiat", "8800");
        marksCarCodes.put("Fisker", "172");
        marksCarCodes.put("Ford", "9000");
        marksCarCodes.put("GAC Gonow", "205");
        marksCarCodes.put("Gemballa", "204");
        marksCarCodes.put("GMC", "9900");
        marksCarCodes.put("Grecav", "122");
        marksCarCodes.put("Hamann", "186");
        marksCarCodes.put("Holden", "10850");
        marksCarCodes.put("Honda", "11000");
        marksCarCodes.put("Hummer", "11050");
        marksCarCodes.put("Hyundai", "11600");
        marksCarCodes.put("Infiniti", "11650");
        marksCarCodes.put("Isuzu", "11900");
        marksCarCodes.put("Iveco", "12100");
        marksCarCodes.put("Jaguar", "12400");
        marksCarCodes.put("Jeep", "12600");
        marksCarCodes.put("Kia", "13200");
        marksCarCodes.put("Koenigsegg", "13450");
        marksCarCodes.put("KTM", "13900");
        marksCarCodes.put("Lada", "14400");
        marksCarCodes.put("Lamborghini", "14600");
        marksCarCodes.put("Lancia", "14700");
        marksCarCodes.put("Land Rover", "14800");
        marksCarCodes.put("Landwind", "14845");
        marksCarCodes.put("Lexus", "15200");
        marksCarCodes.put("Ligier", "15400");
        marksCarCodes.put("Lincoln", "15500");
        marksCarCodes.put("Lotus", "15900");
        marksCarCodes.put("Mahindra", "16200");
        marksCarCodes.put("Maserati", "16600");
        marksCarCodes.put("Maybach", "16700");
        marksCarCodes.put("Mazda", "16800");
        marksCarCodes.put("McLaren", "137");
        marksCarCodes.put("Mercedes-Benz", "17200");
        marksCarCodes.put("MG", "17300");
        marksCarCodes.put("Microcar", "30011");
        marksCarCodes.put("MINI", "17500");
        marksCarCodes.put("Mitsubishi", "17700");
        marksCarCodes.put("Morgan", "17900");
        marksCarCodes.put("Nissan", "18700");
        marksCarCodes.put("NSU", "18875");
        marksCarCodes.put("Oldsmobile", "18975");
        marksCarCodes.put("Opel", "19000");
        marksCarCodes.put("Pagani", "149");
        marksCarCodes.put("Peugeot", "19300");
        marksCarCodes.put("Piaggio", "19600");
        marksCarCodes.put("Plymouth", "19800");
        marksCarCodes.put("Pontiac", "20000");
        marksCarCodes.put("Porsche", "20100");
        marksCarCodes.put("Proton", "20200");
        marksCarCodes.put("Renault", "20700");
        marksCarCodes.put("Rolls-Royce", "21600");
        marksCarCodes.put("Rover", "21700");
        marksCarCodes.put("Ruf", "125");
        marksCarCodes.put("Saab", "21800");
        marksCarCodes.put("Santana", "22000");
        marksCarCodes.put("Seat", "22500");
        marksCarCodes.put("Skoda", "22900");
        marksCarCodes.put("Smart", "23000");
        marksCarCodes.put("speedART", "188");
        marksCarCodes.put("Spyker", "100");
        marksCarCodes.put("Ssangyong", "23100");
        marksCarCodes.put("Subaru", "23500");
        marksCarCodes.put("Suzuki", "23600");
        marksCarCodes.put("Talbot", "23800");
        marksCarCodes.put("Tata", "23825");
        marksCarCodes.put("TECHART", "189");
        marksCarCodes.put("Tesla", "135");
        marksCarCodes.put("Toyota", "24100");
        marksCarCodes.put("Trabant", "24200");
        marksCarCodes.put("Triumph", "24400");
        marksCarCodes.put("TVR", "24500");
        marksCarCodes.put("Volkswagen", "25200");
        marksCarCodes.put("Volvo", "25100");
        marksCarCodes.put("Wartburg", "25300");
        marksCarCodes.put("Westfield", "113");
        marksCarCodes.put("Wiesmann", "25650");
        marksCarCodes.put("Sonstige", "1400");
    }

    static {
        fuelTypeCodes.put("Benzin", "PETROL");
        fuelTypeCodes.put("Diesel", "DIESEL");
        fuelTypeCodes.put("Elektro", "ELECTRICITY");
        fuelTypeCodes.put("Ethanol (FFV, E85 etc.)", "ETHANOL");
        fuelTypeCodes.put("Hybrid (Benzin/Elektro)", "HYBRID");
        fuelTypeCodes.put("Hybrid (Diesel/Elektro)", "HYBRID_DIESEL");
        fuelTypeCodes.put("Autogaz (LPG)", "LPG");
        fuelTypeCodes.put("Erdgas (CNG)", "CNG");
        fuelTypeCodes.put("Wasserstoff", "HYDROGENIUM");
        fuelTypeCodes.put("Sonstige", "OTHER");
    }

    static {
        gearTypeCodes.put("Automatik", "AUTOMATIC_GEAR");
        gearTypeCodes.put("Halbautomatik", "SEMIAUTOMATIC_GEAR");
        gearTypeCodes.put("Manuell", "MANUAL_GEAR");
    }

    static {
        extColorCodes.put("Schwarz", "BLACK");
        extColorCodes.put("Grau", "GREY");
        extColorCodes.put("Silber", "SILVER");
        extColorCodes.put("Weiß", "WHITE");
        extColorCodes.put("Rot", "RED");
        extColorCodes.put("Blau", "BLUE");
        extColorCodes.put("Gelb", "YELLOW");
        extColorCodes.put("Grün", "GREEN");
        extColorCodes.put("Beige", "BEIGE");
        extColorCodes.put("Gold", "GOLD");
        extColorCodes.put("Braun", "BROWN");
        extColorCodes.put("Orange", "ORANGE");
        extColorCodes.put("Bronze", "GOLD");
        extColorCodes.put("Violett", "PURPLE");
    }

    static {
        sortTypeCodes.put("Preis aufsteigend", "searchNetGrossPrice&sortOption.sortOrder=ASCENDING");
        sortTypeCodes.put("Preis absteigend", "searchNetGrossPrice&sortOption.sortOrder=DESCENDING");
        sortTypeCodes.put("Neueste Angebote zuerst", "creationTime&sortOption.sortOrder=DESCENDING");
        sortTypeCodes.put("Kilometerstand aufsteigend", "specifics.mileage&sortOption.sortOrder=ASCENDING");
        sortTypeCodes.put("Kilometerstand absteigend", "specifics.mileage&sortOption.sortOrder=DESCENDING");
        sortTypeCodes.put("Erstzulassung aufsteigend", "specifics.firstRegistration&sortOption.sortOrder=ASCENDING");
        sortTypeCodes.put("Erstzulassung absteigend", "specifics.firstRegistration&sortOption.sortOrder=DESCENDING");
    }

    static {
        landCodes.put("Belgien", "BE");
        landCodes.put("Deutschland", "DE");
        landCodes.put("Frankreich", "FR");
        landCodes.put("Italien", "IT");
        landCodes.put("Luxembourg", "LU");
        landCodes.put("Niederlande", "NL");
        landCodes.put("Österreich", "AT");
        landCodes.put("Spanien", "ES");
    }

    static {
        carTypeCodes.put("Kleinwagen", "SmallCar");
        carTypeCodes.put("Cabrio", "Cabrio");
        carTypeCodes.put("Coupé", "SportsCar");
        carTypeCodes.put("SUV/Geländewagen", "OffRoad");
        carTypeCodes.put("Limousine", "Limousine");
        carTypeCodes.put("Kombi", "EstateCar");
        carTypeCodes.put("Transporter", "OtherCar");
        carTypeCodes.put("Van/Kleinbus", "Van");
    }

    static {
        damagedCarsCodes.put("Nicht anzeigen", "NO_DAMAGE_UNREPAIRED");
        damagedCarsCodes.put("Nur anzeigen", "ONLY_DAMAGE_UNREPAIRED");
        damagedCarsCodes.put("Auch anzeigen", "ALSO_DAMAGE_UNREPAIRED");
    }

    static {
        providerCodes.put("Händler", "ONLY_DEALER_ADS");
        providerCodes.put("Privat", "ONLY_FSBO");
    }

    static {
        interiorEquipCodes.put("Alcantara", "AL");
        interiorEquipCodes.put("Vollleder", "FL");
        interiorEquipCodes.put("Teilleder", "PL");
        interiorEquipCodes.put("Stoff", "CL");
        interiorEquipCodes.put("Velours", "VL");
    }

}