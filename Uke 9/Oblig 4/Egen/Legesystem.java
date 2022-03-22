import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    // Listebeholdere
    public IndeksertListe<Pasient> pasienter;
    public IndeksertListe<Legemiddel> legemidler;
    public Prioritetskoe<Lege> leger;
    public IndeksertListe<Resept> resepter;

    public Legesystem() throws UlovligUtskrift {
        pasienter = new IndeksertListe<>();
        legemidler = new IndeksertListe<>();
        leger = new Prioritetskoe<>();
        resepter = new IndeksertListe<>();

        lesFil("eksempel1.txt");
    }

    // Les inn data fra fil - E1
    public void lesFil(String filnavn) throws UlovligUtskrift {
        Scanner fil = null;
        String typeObjekt = "";

        // Åpner datafilen
        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Kan ikke lese " + filnavn + ".");
            System.exit(1);
        }

        // Leser fra datafilen
        while (fil.hasNextLine()) {
            String line = fil.nextLine();
            
            // Bestemmer hva slags type objekt som skal opprettes
            if (line.startsWith("#")) {
                typeObjekt = line.split(" ")[1];
                continue;
            }

            // Oppretter et pasientobjekt og legger til i pasientlisten
            if (typeObjekt.equals("Pasienter")) {
                String[] data = line.split(",");
                String navn = data[0];
                String fnr = data[1];
                Pasient p = new Pasient(navn, fnr);

                pasienter.leggTil(p);
            
            // Oppretter et legemiddelobjekt og legger til i legemiddellisten
            } else if (typeObjekt.equals("Legemidler")) {
                String[] data = line.split(",");
                String navn = data[0];
                String type = data[1];
                int pris = Integer.parseInt(data[2]);
                double virkestoff = Double.parseDouble(data[3]);
                
                // Sjekker typen legemiddel
                if (type.equals("vanlig")) {
                    Vanlig l = new Vanlig(navn, pris, virkestoff);
                    legemidler.leggTil(l);
                } else if (type.equals("narkotisk")) {
                    int styrke = Integer.parseInt(data[4]);
                    Narkotisk l = new Narkotisk(navn, pris, virkestoff, styrke);
                    legemidler.leggTil(l);
                } else if (type.equals("vanedannende")) {
                    int styrke = Integer.parseInt(data[4]);
                    Vanedannende l = new Vanedannende(navn, pris, virkestoff, styrke);
                    legemidler.leggTil(l);
                }
            
            // Oppretter legeobjekter og legger dem til legelisten
            } else if (typeObjekt.equals("Leger")) {
                String[] data = line.split(",");
                String navn = data[0];
                String kontrollID = data[1];
                
                // Sjekker om legen er spesialist
                if (!kontrollID.equals("0")) {
                    Spesialist l = new Spesialist(navn, kontrollID);
                    leger.leggTil(l);
                } else {
                    Lege l = new Lege(navn);
                    leger.leggTil(l);
                }
            
            // Oppretter reseptobjekter og legger dem til reseptlisten
            } else if (typeObjekt.equals("Resepter")) {
                String[] data = line.split(",");
                int legemiddelNummer = Integer.parseInt(data[0]);
                String legeNavn = data[1];
                int pasientID = Integer.parseInt(data[2]);
                String type = data[3];
                
                Legemiddel legemiddel = legemidler.hent(legemiddelNummer - 1);
                Pasient pasient = pasienter.hent(pasientID - 1);

                for (Lege l : leger) {
                    if (l.hentNavn().equals(legeNavn)) {

                        try {
                            // Oppretter hvit resept
                        if (type.equals("hvit")) {
                            int reit = Integer.parseInt(data[4]);
                            resepter.leggTil(l.skrivHvitResept(legemiddel, pasient, reit));
                        
                        // Oppretter blå resept
                        } else if (type.equals("blaa")) {
                            int reit = Integer.parseInt(data[4]);
                            resepter.leggTil(l.skrivBlaaResept(legemiddel, pasient, reit));
                    
                        // Oppretter miltærresept
                        } else if (type.equals("militaer")) {
                            resepter.leggTil(l.skrivMilResept(legemiddel, pasient));
                        
                        // Oppretter p-resept
                        } else if (type.equals("p")) {
                            int reit = Integer.parseInt(data[4]);
                            resepter.leggTil(l.skrivPResept(legemiddel, pasient, reit));
                        }
                        } catch (UlovligUtskrift e) {
                            System.out.println("Legen " + l.hentNavn() + " har ikke lov til aa skrive ut " + legemiddel.hentNavn());
                            continue;
                        }
                    }
                }
            }
        }
    }
}
