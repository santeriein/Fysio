package com.hyte.fysio;

import java.util.ArrayList;
import java.util.List;

public class GlobalModel {
    private List<Muscle> muscles;
    private static final GlobalModel ourInstance = new GlobalModel();
    private String instructions;

    public static GlobalModel getInstance() { return ourInstance; }
    /**
     * Alla luodaan useita yksilöllisiä "muscle"-olioita, joihin lisätään samalla nimi, harjoituksen nimi, ohjeet, kuva lihaksesta ja tieto-osio.
     * Nämä tiedot näytetään käyttäjän klikatessa valittua lihasta joko kehokuvasta tai listanäkymästä.
     * @author Santeri
     * pvm. 2.12.2019, 5.12.2019
     */
    private GlobalModel() {
        instructions = "• Tee kevyt venyttely päivittäin.\n" +
                "• Verryttele ennen venyttelyä lämmittääksesi kehoasi ja avataksesi nivelten liikeradat.\n" +
                "• Venytä kaikki päälihasryhmät, ethän myöskään unohda venytellä vastakkaisen puolen lihaksia.\n" +
                "• Keskity rentouttamaan venytettävää lihasta ja minimoi kehon muut liikkeet.\n" +
                "• Pidä venytys 10 - 30 sekuntia.\n" +
                "• Venytä liikeradan loppuun, mutta vältä kivun tunnetta.\n" +
                "• Hengitä hitaasti ja rytmikkäästi koko venytyksen ajan.\n" +
                "• Alku- ja loppuverryttelyn aikana venytykset ovat lyhytkestoisia ja tunnustelevia, noin 5-10 sekuntia kestäviä.";

        muscles = new ArrayList<>();
        muscles.add(new Muscle("hartia_taka", "Hartioiden nosto", "Tartutaan kiinni venytettävän puolen ranteesta ja viedään venytettävä hartia\n" +
                "alaspäin. Päätä kallistetaan ja kierretään vastakkaiselle puolelle, kunnes\n" +
                "venytys tuntuu hartiassa ja kaulan sivulla.", "hartioidennosto.png","Lapaluun kohottajalihas, epäkäslihas yläosa\n" +
                "Sijainti: Hartioiden yläosa\n" +
                "Lähtö: Lapaluun kohottaja: kaulanikamien poikki-\n" +
                "haarakkeet, epäkäslihas\n" +
                "Kiinnitys: Lapaluun ylempi kulma\n" +
                "Toiminta: Hartian nosto"));
        muscles.add(new Muscle("niska_taka", "Kaulan ja niskan ojentajat", "Selkä pidetään suorana. Kädet asetetaan ristiin takaraivolle. Kaula ja niska\n" +
                "rentoutetaan sekä annetaan käsien oman painon painaa päätä alaspäin.", "kaulanjaniskanojentajat.png","Kaulan ja pään ohjaslihakset\n" +
                "Sijainti: Kaulan ja niskan takana\n" +
                "Lähtö: Kaularangan ja ylimpien rintarangan nikamien\n" +
                "okahaarakkeet\n" +
                "Kiinnitys: Kaulan ohjaslihas: ylimpien kaularangan nikamien\n" +
                "poikkihaarakkeet, pään ohjaslihas: kartiolisäke \n" +
                "takaraivolla\n" +
                "Toiminta: Kaulan ja pään ojennus, sivutaivutus"));
        muscles.add(new Muscle("rinta_etu", "Rintalihakset", "Yläraaja nostetaan seinälle ja vartaloa kierretään, kunnes venytys tuntuu rinnassa. Vaihtamalla käden asentoa seinällä ylemmäs ja alaspäin venytyksen saa kohdistettua rintalihasten eri osiin.",
                "rintalihakset.png","Rintalihas\n" +
                "Sijainti: Rintakehä\n" +
                "Lähtö: Solisluu, rintalasta, kylkiluut\n" +
                "Kiinnitys: Olkaluun yläosa\n" +
                "Toiminta: Yläosa: yläraajan ylösvienti, keskiosa: yläraajan \n" +
                "lähennys, alaosa: yläraajan alavienti"));
        muscles.add(new Muscle("olkas_etu","Olkavarren sisäkiertäjät","Venytettävän käden olkavarsi laitetaan toisen käden kyynärvarren päälle. \n" +
                "Venytettävän puolen peukalosta otetaan kiinni ja sitä viedään alaspäin, kunnes\n" +
                "venytys tuntuu olkavarren etupuolella.","olkavarsisisa.png","Lavanaluslihas\n" +
                "Sijainti: Lapaluun sisäpinta\n" +
                "Lähtö: Lapaluun sisäpinta\n" +
                "Kiinnitys: Olkaluun etu-yläosa\n" +
                "Toiminta: Olkavarren sisäkierto\n"));
        muscles.add(new Muscle("olkau_taka","Olkavarren ulkokiertäjät","Seisotaan seinää vasten ja painetaan lapaluun ulkoreuna kiinni seinään. Vastakkai-\n" +
                "sella kädellä tartutaan kiinni venytettävän puolen kyynärpäästä. Venytettävää \n" +
                "kättä vedetään pään takaa toiselle puolelle, kunnes venytys tuntuu lapaluun \n" +
                "sisällä.","olkavarsiulko.png","Alempi lapalihas\n" +
                "Sijainti: Lapaluun ulkopinta\n" +
                "Lähtö: Lapaluun alempi kuoppa\n" +
                "Kiinnitys: Olkaluun iso olkakyhmy\n" +
                "Toiminta: Olkanivelen ulkokierto\n"));
        muscles.add(new Muscle("lapa_taka","Lavan lähentäjä","Tartutaan kädellä penkin reunasta. Hartia rentoutetaan ja yläselkä painetaan \n" +
                "köyryssä taaksepäin, kunnes venytys tuntuu hartiassa ja lapaluiden välissä.","lapa.png","Epäkäslihas\n" +
                "Sijainti: Keski- ja yläselkä\n" +
                "Lähtö: Takaraivonluu, niskaside, kaula- ja rintanikamien \n" +
                "okahaarakkeet\n" +
                "Kiinnitys: Solisluu, lapaluun olkalisäke, lapaluun harju\n" +
                "Toiminta: Yläosa: hartian nosto, keskiosa: hartian taakse \n" +
                "vetäminen, alaosa: hartian alas vetäminen"));
        muscles.add(new Muscle("vartalo_etu","Vartalon eteentaivutus","Vastamakuulla maatessa kyynärpäät ojennetaan sekä lantio pidetään lattiassa. \n" +
                "Venytys tehostuu, kun hengitetään syvään sisään.","vartalo.png","Vatsalihakset\n" +
                "Sijainti: Alavartalon etupuoli ja kyljet\n" +
                "Lähtö: Kylkiluut, rintalasta\n" +
                "Kiinnitys: Häpyluu, suoliluu\n" +
                "Toiminta: Vartalon eteentaivutus ja kierto"));
        muscles.add(new Muscle("selka_taka","Leveä selkälihas","Venytettävän puolen ranteesta tartutaan kiinni. Venytettävä käsi nostetaan ylös \n" +
                "niin, että käännetään samalla venytettävän käden peukaloa ulospäin, jolloin \n" +
                "olkanivel on ulkokierrossa. Vartaloa kallistetaan ja vedetään sitä vastakkaisen \n" +
                "puolen kädellä sivulle alas, kunnes venytys tuntuu alaselässä ja kyljessä. Hengi-\n" +
                "tetään rauhallisesti ja lisätään venytystä uloshengityksen aikana.","selka.png","Leveä selkälihas\n" +
                "Sijainti: Ala- ja keskiselkä\n" +
                "Lähtö: Lannerangan ja rintarangan okahaarakkeet, lanne-\n" +
                "alueen sidekudoksinen kalvo, suoliluun harju\n" +
                "Kiinnitys: Olkaluun pieni olkakyhmy\n" +
                "Toiminta: Olkanivelen ojennus, lähennys ja sisäkierto"));
        muscles.add(new Muscle("kyynar_taka","Kyynärpään koukistajat 1","Seisotaan kylki seinää kohti. Nostetaan venytettävä yläraaja seinää vasten, \n" +
                "käännetään olkavarsi sisäkiertoon ja työnnetään hartiaa eteenpäin, kunnes \n" +
                "venytys tuntuu olkavarren etupuolella.\n","kyynar1.png","Kaksipäinen hauislihas\n" +
                "Sijainti: Olkavarren etupuoli\n" +
                "Lähtö: Pitkä pää, olkanivelen nivelkuopan yläpuolella oleva \n" +
                "kyhmy, lyhyt pää, lapaluun korppilisäke\n" +
                "Kiinnitys: Värttinäluun yläpää\n" +
                "Toiminta: Kyynärnivelen koukistus ja uloskierto, olkanivelen \n" +
                "lähennys ja koukistus"));
        muscles.add(new Muscle("kyynar_etu","Kyynärpään koukistajat 2","Venytettävän käden kämmen asetetaan pöydän päälle ja tuetaan toisella \n" +
                "kädellä kyynärpää suoraksi. Vartaloa siirretään taaksepäin, kunnes venytys \n" +
                "tuntuu kyynärvarren sisäpinnalla ja ranteessa.","kyynar2.png","Olkalihas\n" +
                "Sijainti: Olkavarren etupinta hauislihaksen alla\n" +
                "Lähtö: Olkaluun etupinta\n" +
                "Kiinnitys: Kyynärluun yläosa\n" +
                "Toiminta: Kyynärnivelen koukistus"));
        muscles.add(new Muscle("sormet_etu","Sormien ojentajat", "Venytettävän käden sormet puristetaan nyrkkiin ja otetaan venytettävästä kä-\n" +
                "destä kiinni. Venytettävän käden kyynärpää suoristetaan ja sitä vedetään toisella\n" +
                "kädellä ylöspäin, kunnes venytys tuntuu kyynärvarressa ja sormien ojentajajän-\n" +
                "teissä.","sormet.png","Sormien ojentajalihas\n" +
                "Lähtö: Olkaluun ulompi nivelnasta\n" +
                "Kiinnitys: Toisen ja viidennen sormiluiden kärki\n" +
                "Toiminta: Sormien ojennus\n"));
        muscles.add(new Muscle("lonkka_etu","Lonkan ojentajat","Vastakkaisen puolen kädellä vedetään venytettävän jalan polvea kohti\n" +
                "kainaloa. Venytys tuntuu pakarassa. On tärkeää pitää selkä suorana.","lonkka.png","Sijainti: Pakara\n" +
                "Lähtö: Ristiluun ja häntäluun reuna\n" +
                "Kiinnitys: Reisiluun yläpää\n" +
                "Toiminta: Lonkan ojennus\n" +
                "Yläsäikeet: Lonkan loitonnus\n" +
                "Alasäikeet: Lonkan lähennys\n"));
        muscles.add(new Muscle("reisi_taka","Reiden loitontajat","Jalka nostetaan penkille. Venytettävää lonkkaa vedetään sivulle alas, kunnes \n" +
                "venytys tuntuu pakaran ulkoreunassa.","reisi.png","Keskimmäinen pakaralihas\n" +
                "Sijainti: Pakara\n" +
                "Lähtö: Suoliluu\n" +
                "Kiinnitys: Reisiluun yläpää, iso sarvennoinen\n" +
                "Toiminta: Lonkan loitonnus\n" +
                "Takasäikeet: Lonkan ulkokierto\n" +
                "Etusäikeet: Lonkan sisäkierto"));
    }

    public Muscle getMuscle(Integer i) {
        return muscles.get(i);
    }

    public List<Muscle> getMuscles() { return muscles; }

    public String getInstructions() {
        return this.instructions;
    }
}

