import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

class Legesystem{

    //instansvariabler
    private IndeksertListe<Legemiddel> legemidler = new IndeksertListe<Legemiddel>(); //ettersom ID er nevnt virker dette som den beste klassen for aa sortere
    private Prioritetskoe<Lege> leger = new Prioritetskoe<Lege>(); //her burde vi få inn listen fra compareTo funksjonen i Lege klassen, vet ikke om dette er den mest ordnede losningen her
    private IndeksertListe<Pasient> pasienter = new IndeksertListe<Pasient>(); //17.03 byttet om på listetypene
    private IndeksertListe<Resept> resepter = new IndeksertListe<Resept>();
    
    private Scanner Svar = new Scanner(System.in); //Bruk denne scanneren for aa sporre bruker om input
    private Boolean opprettObjekt = false;
  
    //fil lesings funksjon 
    public void lesFraFil(){ //17.03 laget metode
      String filNavn;
      if (opprettObjekt) { //sjekker om det finnes midlertidig fil
        filNavn = "midlertidligFil.txt";
        opprettObjekt = false;
        }
      else {
        System.out.println("Tast inn filnavn: ");
        filNavn = Svar.next();
        if (!filNavn.endsWith(".txt")) { //legger til .txt om det mangler
          filNavn += ".txt";
        }
      }

      Scanner fil = null;

      try {
        fil = new Scanner(new File(filNavn));
      }
      catch (FileNotFoundException e) {
        System.out.println("Filen finnes ikke!");
        return;
      }
      if (fil.nextLine().substring(0, 3).equals("# P") != true) { //sjekker om filen begynner riktig
        System.out.println("Filen du proever aa lese har feil format!");
        return;
      }
      while (fil.hasNextLine()) { //looper gjennom pasienter
        String linje = fil.nextLine();
        //System.out.println(linje);
        if (linje.substring(0, 7).equals("# Legem")) { //bryter ut av pasientloop naar den er ferdig
          //System.out.println("Ferdig med pasienter");
          break;
        }
        String[] linjeBiter = linje.split(","); //Splitter med komma og lager nytt pasientobjekt
        Pasient nyPasient = new Pasient(linjeBiter[0], linjeBiter[1]);
        nyttObjekt(nyPasient); //Legger til i listen
      }

      while (fil.hasNextLine()) { //looper gjennom legemidlere
        String linje = fil.nextLine();
        //System.out.println(linje);
        if (linje.substring(0, 7).equals("# Leger")) { //bryter ut naar den er ferdig
          //System.out.println("Ferdig med legemidler");
          break;
        }

        String[] linjeBiter = linje.split(",");
        int pris;
        Double prisDouble;
        Double virkestoff;
        try {
          prisDouble = Double.parseDouble(linjeBiter[2]); //caster string til int og double
          pris = (int)Math.round(prisDouble);
          //pris = prisDouble.intValue(); //maatte caste foerst til double og saa konvertere til int pga alle prisene er double i den store filen
          virkestoff = Double.parseDouble(linjeBiter[3]);
        }
        catch (NumberFormatException e){
          System.out.println("Linjen har feil format, kan ikke caste int eller double: " + linje);
          continue; //hopper over linjen om det fanges feil
        }

        if (linjeBiter[1].equals("vanlig")) { //lager vanlig objekt
          Vanlig nyLegemiddel = new Vanlig(linjeBiter[0], pris, virkestoff);
          nyttObjekt(nyLegemiddel);
        }
        if (linjeBiter[1].equals("vanedannende")) { //lager vanedannende objekt
          int styrke;
          try {
            styrke = Integer.parseInt(linjeBiter[4].trim()); //caster string til int og trim() for aa fjerne mellomrom paa slutten
          } 
          catch (NumberFormatException e) {
            System.out.println("Linjen har feil format, kan ikke caste int: " + linje);
            continue;
          }
          Vanedannende nyLegemiddel = new Vanedannende(linjeBiter[0], pris, virkestoff, styrke);
          nyttObjekt(nyLegemiddel);
        }
        if (linjeBiter[1].equals("narkotisk")) { //lager narkotisk, likt som vanedannende
          int styrke;
          try {
            styrke = Integer.parseInt(linjeBiter[4].trim());
          } 
          catch (NumberFormatException e) {
            System.out.println("Linjen har feil format, kan ikke caste int: " + linje);
            continue;
          }
          Narkotisk nyLegemiddel = new Narkotisk(linjeBiter[0], pris, virkestoff, styrke);
          nyttObjekt(nyLegemiddel);
        }
      }
      while (fil.hasNextLine()) { //looper gjennom leger
        String linje = fil.nextLine();
        //System.out.println(linje);
        if (linje.substring(0, 3).equals("# R")) { //bryter ut naar den er ferdig
          //System.out.println("Ferdig med leger");
          break;
        }
        String[] linjeBiter = linje.split(",");
        if (linjeBiter[1].trim().equals("0")) { //om kontrollID er 0, lages Lege objekt, ellers Spesialist objekt
          Lege nyLege = new Lege(linjeBiter[0]);
          nyttObjekt(nyLege);
        }
        else {
          Spesialist nyLege = new Spesialist(linjeBiter[0], linjeBiter[1]);
          nyttObjekt(nyLege);
        }
      }
      while (fil.hasNextLine()) { //looper gjennom resepter
        String linje = fil.nextLine();
        String[] linjeBiter = linje.split(",");
        int legemiddelNummer;
        int pasientID;
        try {
          legemiddelNummer = Integer.parseInt(linjeBiter[0]); //caster til int
          pasientID = Integer.parseInt(linjeBiter[2]);
        }
        catch (NumberFormatException e) {
          System.out.println("Linjen har feil format, kan ikke caste int: " + linje);
          continue;
        }
        Iterator<Lege> legeIterator = leger.iterator(); //Lager iterator objekt for aa lete gjennom listen av leger

        if (!legeIterator.hasNext()) {
          System.out.println("Det finnes ingen leger i systemet for aa skrive ut resept!");
          continue;
        }
        while (legeIterator.hasNext()) { //looper gjennom hele legelisten
          Lege denneLegen = legeIterator.next();
          if (denneLegen.hentNavn().equals(linjeBiter[1])) { //Sjekker om det er riktig lege
            if (linjeBiter[3].equals("militaer")) { //naar riktig lege er funnet, sjekker om det er milresept
              MilResept nyResept;
              try { //lager ny resept med legens skrivresept metode
                nyResept = denneLegen.skrivMilResept(legemidler.hent(legemiddelNummer - 1), pasienter.hent(pasientID - 1)); //reduserer posisjonen med 1, fordi listen vaar begynner med 0
                nyttObjekt(nyResept);
              } catch (UlovligUtskrift | UgyldigListeindeks e) {
                System.out.println(e); //printer ulovlig utskrift exception
                System.out.println("Legemiddel eller pasient finnes ikke i systemet!");
              }
              break;
            }
            int reit; //om det ikke er milresept trenger vi aa caste reit
            try {
              reit = Integer.parseInt(linjeBiter[4].trim());
            }
            catch (NumberFormatException e) {
              System.out.println("Linjen har feil format, kan ikke caste int: " + linje);
              break;
            }
            if (linjeBiter[3].equals("hvit")){ //sjekker for type resept og lager den
              HvitResept nyResept;
              try {
                nyResept = denneLegen.skrivHvitResept(legemidler.hent(legemiddelNummer - 1), pasienter.hent(pasientID - 1), reit);
                nyttObjekt(nyResept);
              } catch (UlovligUtskrift | UgyldigListeindeks e) {
                System.out.println(e + ", Legemiddel eller pasient finnes ikke i systemet!");
              }
              break;
            }
            if (linjeBiter[3].equals("blaa")) {
              BlaaResept nyResept;
              try {
                nyResept = denneLegen.skrivBlaaResept(legemidler.hent(legemiddelNummer -1), pasienter.hent(pasientID - 1), reit);
                nyttObjekt(nyResept);
              }
              catch (UlovligUtskrift | UgyldigListeindeks e) {
                System.out.println(e + ", Legemiddel eller pasient finnes ikke i systemet!");
              }
              break;
            }
            if (linjeBiter[3].equals("p")) {
              PResept nyResept;
              try {
                nyResept = denneLegen.skrivPResept(legemidler.hent(legemiddelNummer -1), pasienter.hent(pasientID - 1), reit);
                nyttObjekt(nyResept);
              }
              catch (UlovligUtskrift | UgyldigListeindeks e) {
                System.out.println(e + ", Legemiddel eller pasient finnes ikke i systemet!");
              }
              break;
            }
          }
          if (!legeIterator.hasNext()) {
            System.out.println("Legen " + linjeBiter[1] + " finnes ikke i systemet!");
          }
        }
      }
      fil.close();
    }
  
    //kommandoLokke funksjon
    public void kommandoLokke(){
      boolean meny = true;
      while(meny){
          System.out.println("\nHva vil du gjore? \n" +
                    "0: Se all data\n" +
                    "1: Legge til et nytt element\n" +
                    "2: Bruke en resept\n" +
                    "3: Se statistikk\n" +
                    "4: Lagre data\n" +
                    "5: Les fra fil\n" +
                    "q: Gaa ut av programmet\n");

            String svaret = Svar.next();
            switch (svaret){
                case "0":
                  System.out.println("Skriver ut data...");
                  printElementer();
                  break;
                case "1":
                  lageObjekt();
                  break;
                case "2":
                  brukResept();
                  break;
                case "3":
                  statistikk();
                  break;
                case "4":
                  skrivTilFil();
                  break;
                case "5":
                  lesFraFil();
                  break;
                case "q":
                  meny = false; //her brytes while lokka
                  break;
                default: //alle andre inputs kjoerer default
                  System.out.println("Feil tall, oppgi riktig tall og proev på nytt");
                  break;

         }
      }
    }
  
    //utprint
    public void printElementer(){ //17.03 fjernet for loop printen fordi det er unoedvendig

      // Skriver ut denne beskjeden hvis det ikke finnes noe data i systemet - 20.03
      if (pasienter.stoerrelse() == 0 && leger.stoerrelse() == 0 && legemidler.stoerrelse() == 0 && resepter.stoerrelse() == 0) {
        System.out.println("Ingen data å vise.");
      } else {
        System.out.println("\n----------");
        System.out.println("LEGEMIDLER");
        System.out.println("----------");
        System.out.println(legemidler);
        System.out.println("---------");
        System.out.println("PASIENTER");
        System.out.println("---------");
        System.out.println(pasienter);
        System.out.println("-----");
        System.out.println("LEGER");
        System.out.println("-----");
        System.out.println(leger); //17.03 listen blir sortert alfabetisk naar man lager den, saa den printer sortert
        System.out.println("--------");
        System.out.println("RESEPTER");
        System.out.println("--------");
        System.out.println(resepter);
      }
    }
  
    //legge til objekt
    public <obj> void nyttObjekt(obj x) { //17.03 caster objektet naar det sendes videre, fikk feilmelding naar jeg ikke
      if (x instanceof Legemiddel) {
        legemidler.leggTil((Legemiddel)x);
      }
      else if (x instanceof Lege) {
        leger.leggTil((Lege)x);
      }
      else if (x instanceof Pasient) {
        pasienter.leggTil((Pasient)x);
      }
      else if (x instanceof Resept) {
        resepter.leggTil((Resept)x);
      }
      else{
        System.out.println("Ugyldig objekt: " + x.getClass().getName());
        //throw new Exception("Ugyldig input");
      }
    }

    //E4
    public void lageObjekt(){
      System.out.println("Hvilket objekt vil du lage?\n" +
                        "0. Pasient\n" +
                        "1. Legemiddel\n" +
                        "2. Lege\n" +
                        "3. Resept\n" +
                        "q: Gaa ut av programmet\n");
      String info = "";
      Svar.nextLine(); //maatte kalle paa nextLine for aa fjerne data som allerede var i skanneren for aa unngaa feil?
      String svar = Svar.nextLine();
      if (svar.equals("q")) {
        return;
      }
      else if (svar.equals("0")) {
        System.out.println("Tast inn informasjonen til pasienten med dette formatet:\nnavn,foedselsnummer");
        svar = Svar.nextLine();
        info = "# Pasienter (navn, fnr)\n" +
              svar + "\n" +
              "# Legemidler (navn,type,pris,virkestoff,[styrke])\n" +
              "# Leger (navn,kontrollid / 0 hvis vanlig lege)\n" +
              "# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n";

      }
      else if (svar.equals("1")) {
        System.out.println("Tast inn informasjonen til legemiddelet med dette formatet:\nnavn,type,pris,virkestoff,narkotiskstyrke");
        svar = Svar.nextLine();
        info = "# Pasienter (navn, fnr)\n" +
              "# Legemidler (navn,type,pris,virkestoff,[styrke])\n" +
              svar + "\n" +
              "# Leger (navn,kontrollid / 0 hvis vanlig lege)\n" +
              "# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n";

      }
      else if (svar.equals("2")) {
        System.out.println("Tast inn informasjonen til legen med dette formatet:\nnavn,kontrollid");
        System.out.println("For en vanlig lege uten kontrollid er denne verdien 0.");
        svar = Svar.nextLine();
        info = "# Pasienter (navn, fnr)\n" +
              "# Legemidler (navn,type,pris,virkestoff,[styrke])\n" +
              "# Leger (navn,kontrollid / 0 hvis vanlig lege)\n" +
              svar + "\n" +
              "# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n";

      }
      else if (svar.equals("3")) {
        System.out.println("Tast inn informasjonen til resepten med dette formatet:\nlegemiddelNummer,legeNavn,pasientID,type,reit");
        System.out.println("Bruk se all data funksjonen i hovedmenyen for aa finne informasjon om leger/legemidler/pasienter.");
        svar = Svar.nextLine();
        info = "# Pasienter (navn, fnr)\n" +
              "# Legemidler (navn,type,pris,virkestoff,[styrke])\n" +
              "# Leger (navn,kontrollid / 0 hvis vanlig lege)\n" +
              "# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n" +
              svar + "\n";

      }
      else {
        System.out.println("Ugyldig input");
        return;
      }

      PrintWriter midlertidligFil = null;
      try {
        midlertidligFil = new PrintWriter("midlertidligFil.txt"); //fanger exception
      }
      catch (Exception e) {
        System.out.println("Kunne ikke opprette midlertidlig fil!");
        return;
      }
      //System.out.println(info);
      midlertidligFil.print(info);
      opprettObjekt = true;
      midlertidligFil.close();
      lesFraFil();
      File fileFil = new File("midlertidligFil.txt");
      Path pathFil = fileFil.toPath();
      //System.out.println(pathFil);
      try {
        Files.deleteIfExists(pathFil);
      } catch (IOException e) {
        System.out.println(e + "Kunne ikke slette midlertidlig fil");
        return;
      }
    }
  
    //Bruk resept E5
    public void brukResept(){ // ikke helt sikker paa hvordan vi skal kunne kalle paa en resept best ved navn, derfor lite kode her.
          System.out.println("\nHvilken pasient vil du se resepter for? ");
          Iterator<Pasient> pasientIterator = pasienter.iterator(); 
          while (pasientIterator.hasNext()) { //Gaar gjennom alle pasienter
            Pasient dennePasient = pasientIterator.next(); //Printer en kompakt streng slik som i oppgaveteksten
            System.out.println(dennePasient.hentPasientID() + ": " + dennePasient.hentNavn() + " (fnr " + dennePasient.hentFnr() +")");
          }
          System.out.println("q: Gaa ut av programmet\n");

          String svaret = Svar.next(); 
          if (svaret.equals("q")) {
            return;
          }
          int svaretInt;
          try {
            svaretInt = Integer.parseInt(svaret); //caster til int
          }
          catch (NumberFormatException e) {
            System.out.println("Tast inn pasientID");
            return;
          }
          Pasient pasientObjekt;
          try {
          pasientObjekt = pasienter.hent(svaretInt - 1); //trekker fra 1 fordi pasientID begynner paa 1 mens listen begynner paa 0
          }
          catch (UgyldigListeindeks e) {
            System.out.println(e);
            return;
          }
          System.out.println("\nHvilken resept vil du bruke? ");
          Iterator<Resept> reseptIterator = pasientObjekt.hentResepter().iterator();
          int reseptIndex = 1;
          Resept denneResepten = null;
          if (!reseptIterator.hasNext()) { //sjekker om reseptlisten er tom
            System.out.println("Denne pasienten har ingen resepter!");
            return;
          }
          while (reseptIterator.hasNext()) { //gaar gjennom hele listen og printer ut informasjon, laget ikke egen metode her, kanskje gjoere det?
            denneResepten = reseptIterator.next();
            System.out.println(reseptIndex + ": " + denneResepten.hentLegemiddel().hentNavn() + " (" + denneResepten.hentReit() + " reit)");
            reseptIndex++;
          }
          System.out.println("q: Gaa ut av programmet\n");
          svaret = Svar.next();
          if (svaret.equals("q")) {
            return;
          }
          try {
            svaretInt = Integer.parseInt(svaret);
          }
          catch (NumberFormatException e) {
            System.out.println("Tast inn pasientID");
            return;
          }
          if (svaretInt >= reseptIndex | svaretInt < 1) { // UgyldigListeIndeks
            System.out.println("Fant ikke resepten");
            return;
          }
          Iterator<Resept> reseptIterator2 = pasientObjekt.hentResepter().iterator(); //Maatte lage ny iterator for aa gaa gjennom listen paa nytt
          reseptIndex = 0; // reseptlisten er en stabel, saa kan ikke hente bare med nummer i listen
          while (reseptIndex < svaretInt) { //Stopper naar den finner riktig resept
            denneResepten = reseptIterator2.next();
            reseptIndex++;
          }
          if (denneResepten != null) {
             if (denneResepten.bruk()) { //proever aa bruke resept
              System.out.println("Brukt en resept paa " + denneResepten.hentLegemiddel().hentNavn());
              return;
             }
             else {
               System.out.println("Kunne ikke bruke resept paa " + denneResepten.hentLegemiddel().hentNavn() + " (ingen gjenvaerende reit).");
               return;
             }
          }
         }
  
    //funksjon for aa vise statistikk om systemet E6
    public void statistikk(){
      boolean erLegeIListe = false;
      boolean erPasientIListe = false;
      int antallVanedannende = 0;
      int antallNarkotisk = 0;
      Prioritetskoe<Lege> muligMisbrukLeger = new Prioritetskoe<>();
      IndeksertListe<Pasient> muligMisbrukPasienter = new IndeksertListe<>();

      for (Resept resept : resepter) {
        
        // Teller hvis resepten er på vanedannende legemiddel
        if (resept.hentLegemiddel() instanceof Vanedannende) {
          antallVanedannende++;
        }

        if (resept.hentLegemiddel() instanceof Narkotisk) {

          // Teller hvis resepten er på narkotisk legemiddel
          antallNarkotisk++;

          // Sjekker om legen som skrev ut resepten allerede er listet i muligMisbrukLeger
          for (Lege lege : muligMisbrukLeger) {
            if (resept.hentLege() == lege) {
              erLegeIListe = true;
            }
          }

          // Legger til legen i en liste hvis den har skrevet ut et narkotisk legemiddel
          if (!erLegeIListe) {
            muligMisbrukLeger.leggTil(resept.hentLege());
          }

          // Sjekker om pasienten som har resepten allerede finnes i muligMisbrukPasienter
          for (Pasient pasient : muligMisbrukPasienter) {
            if (resept.hentPasient() == pasient) {
              erPasientIListe = true;
            }
          }

          // Legger til pasienten i en liste hvis den har en resept med narkotisk legemiddel
          if (!erPasientIListe) {
            muligMisbrukPasienter.leggTil(resept.hentPasient());
          }

          // Nullstiller til neste iterasjon
          erLegeIListe = false;
          erPasientIListe = false;
        }

      }

      // Meny med valg om visning av statistikk
      boolean meny = true;
      while (meny) {
        System.out.println("\nHvilken statistikk vil du se?\n" +
                          "0: Antall resepter - Vanedannende\n" +
                          "1: Antall resepter - Narkotisk\n" +
                          "2: Leger som har skrevet ut narkotisk legemiddel\n" +
                          "3: Pasienter som har gyldig resept paa narkotisk legemiddel\n" +
                          "q: Gaa tilbake til hovedmeny\n"
        );

        String svar = Svar.next();
        switch (svar) {
          case "0":
            System.out.println("Antall resepter med vanedannende legemidler: " + antallVanedannende);
            break;
          case "1":
            System.out.println("Antall resepter med narkotiske legemidler: " + antallNarkotisk);
            break;
          case "2":
            int antallUtskrevne = 0;
            System.out.println("LEGER SOM HAR SKREVET UT NARKOTISKE LEGEMIDLER");
            System.out.println("----------------------------------------------");
            for (Lege lege : muligMisbrukLeger) {

              // Teller antall resepter med narkotisk legemiddel
              for (Resept resept : lege.hentUtskrevneResepter()) {
                if (resept.hentLegemiddel() instanceof Narkotisk) {
                  antallUtskrevne++;
                }
              }

              System.out.println(lege.hentNavn() + ": " + antallUtskrevne);
              antallUtskrevne = 0;
            }
            break;
          case "3":
          int antallResepter = 0;
          System.out.println("PASIENTER MED GYLDIG RESEPT PAA NARKOTISKE LEGEMIDLER");
          System.out.println("------------------------------------------------");
          for (Pasient pasient : muligMisbrukPasienter) {

            // Teller antall resepter med narkotisk legemiddel
            for (Resept resept : pasient.hentResepter()) {
              if (resept.hentLegemiddel() instanceof Narkotisk) {
                antallResepter++;
              }
            }

            System.out.println(pasient.hentNavn() + ": " + antallResepter);
            antallResepter = 0;
          }
            break;
          case "q":
            meny = false;
            break;
          default:
            System.out.println("Ugyldig valg. Proev paa nytt!");
            break;
        }
      }
    }
  
    //skriv elementer til fil E7
    public void skrivTilFil(){
      System.out.println("Filnavn: ");
      String lagreFilNavn = Svar.next(); //spoer etter filnavn
      if (!lagreFilNavn.endsWith(".txt")) { //legger til .txt om det mangler
        lagreFilNavn += ".txt";
      }
      PrintWriter lagreFil = null;
      try {
        lagreFil = new PrintWriter(lagreFilNavn); //fanger exception
      }
      catch (Exception e) {
        System.out.println("Kunne ikke opprette fil!");
        return;
      }
      lagreFil.println("# Pasienter (navn, fnr)");

      Iterator<Pasient> pasientIterator = pasienter.iterator(); //gaar gjennom pasient listen
      while (pasientIterator.hasNext()) {
        Pasient dennePasienten = pasientIterator.next();
        lagreFil.println(dennePasienten.hentNavn() + "," + dennePasienten.hentFnr()); //printer verdier med komma i riktig rekkefolge
      }
      lagreFil.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");

      Iterator<Legemiddel> legemiddelIterator = legemidler.iterator(); //gaar gjennom listen
      while (legemiddelIterator.hasNext()) {
        Legemiddel detteLegemiddelet = legemiddelIterator.next(); //printer det som er felles for alle legemiddel
        lagreFil.print(detteLegemiddelet.hentNavn() + "," + detteLegemiddelet.hentType() + "," + detteLegemiddelet.hentPris() + "," + detteLegemiddelet.hentVirkestoff());
        if (detteLegemiddelet instanceof Narkotisk) { //Maa caste for aa fa tak i hentNarkotiskStyrke metoden?
          Narkotisk temp = (Narkotisk) detteLegemiddelet;
          lagreFil.print("," + temp.hentNarkotiskStyrke());
        }
        if (detteLegemiddelet instanceof Vanedannende) { //Samme med vanedannende
          Vanedannende temp = (Vanedannende) detteLegemiddelet;
          lagreFil.print("," + temp.hentVanedannendeStyrke());
        }
        lagreFil.print("\n"); //nextline på slutten
      }
      lagreFil.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)"); //ferdig med legemiddel, starter neste linje

      Iterator<Lege> legeIterator = leger.iterator(); //gaar gjennom listen
      while (legeIterator.hasNext()) {
        Lege denneLegen = legeIterator.next();
        lagreFil.print(denneLegen.hentNavn() + ",");
        if (denneLegen instanceof Spesialist) { //sjekker om legen er spesialist
          Spesialist temp = (Spesialist) denneLegen;
          lagreFil.print(temp.hentKontrollID() + "\n");
        }
        else {
          lagreFil.print("0\n"); //er legen ikke spesialist, printer 0
        }
      }
      lagreFil.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])"); //ferdig med leger

      Iterator<Resept> reseptIterator = resepter.iterator();
      while (reseptIterator.hasNext()) {
        Resept denneResepten = reseptIterator.next(); //printer felles for alle resepter
        lagreFil.print(denneResepten.hentLegemiddel().hentId() + "," + denneResepten.hentLege().hentNavn() + "," 
        + denneResepten.hentPasientId() + ",");

        if (denneResepten instanceof MilResept) {
          lagreFil.print("militaer\n"); //milResept trenger ikke reit, printer ferdig stringen
          continue; //starter neste loop
        }
        else if (denneResepten instanceof PResept) {
          lagreFil.print("p," + denneResepten.hentReit() + "\n");
          continue;
        }
        else if (denneResepten instanceof BlaaResept) {
          lagreFil.print("blaa," + denneResepten.hentReit() + "\n");
          continue;
        }
        else if (denneResepten instanceof HvitResept) {
          lagreFil.print("hvit," + denneResepten.hentReit() + "\n");
          continue;
        }
      }
      lagreFil.close(); //lukker filen
    }
  }