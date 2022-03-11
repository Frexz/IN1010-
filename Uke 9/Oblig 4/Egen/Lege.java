public class Lege implements Comparable<Lege>{

    // Instansvariabler
    protected String navn;
    protected IndeksertListe<Resept> utskrevneResepter;

    // Konstruktør
    // 11.03 F - Lagt til initiering av listen utskrevneResepter i konstruktøren 
    public Lege(String navn) {
        this.navn = navn;
        utskrevneResepter = new IndeksertListe<>();
    }

    // Returnerer legens navn
    public String hentNavn() {
        return navn;
    }

    // Skriver ut informasjon om legen
    @Override
    public String toString() {
        return "\nLege\n----" + "\nNavn: " + navn;
    }

    // Sammenlikner leger alfabetisk på etternavn
    @Override
    public int compareTo(Lege annenLege) {
        
        // Henter legenes etternavn etter "Dr. "
        String etternavn = navn.substring(4);
        String annetEtternavn = annenLege.hentNavn().substring(4);

        // Returnerer resultatet fra String sin compareTo-metode ettersom den er laget for å sortere alfabetisk.
        return etternavn.compareTo(annetEtternavn);
    }

    //Operetter en hvit resept.
    // 11.03 F - Endret metodenavn til slik den står i oppgaven, fikset syntax for exception og lagt til funksjonalitet for å legge resepten til i pasientens liste også. La også til
    // retur av resepten siden metoden krever det. Endret "this.Lege" til bare "this".
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
      if (legemiddel instanceof Narkotisk) {
        throw new UlovligUtskrift(this, legemiddel);
      }
      else{
        HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
      }
    }

    //Operetter en P resept.
    // 11.03 F - Endret metodenavn til slik den står i oppgaven, fikset syntax for exception og lagt til funksjonalitet for å legge resepten til i pasientens liste også. La også til
    // retur av resepten siden metoden krever det. Endret "this.Lege" til bare "this".
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
      if (legemiddel instanceof Narkotisk) {
        throw new UlovligUtskrift(this, legemiddel);
      }
      else{
        PResept resept = new PResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
      }
    }

    //Operetter en militaer resept.
    // 11.03 F - Endret metodenavn til slik den står i oppgaven, fikset syntax for exception og lagt til funksjonalitet for å legge resepten til i pasientens liste også. La også til
    // retur av resepten siden metoden krever det. Endret "this.Lege" til bare "this".
    public MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift{
      if (legemiddel instanceof Narkotisk) {
        throw new UlovligUtskrift(this, legemiddel);
      }
      else{
        MilResept resept = new MilResept(legemiddel, this, pasient);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
      }
    }

    //Operetter en blaa resept.
    // 11.03 F - Endret metodenavn til slik den står i oppgaven, fikset syntax for exception og lagt til funksjonalitet for å legge resepten til i pasientens liste også. La også til
    // retur av resepten siden metoden krever det. Endret "this.Lege" til bare "this".
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
      if (legemiddel instanceof Narkotisk) {
        if (this instanceof Spesialist) {
          BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
          utskrevneResepter.leggTil(resept);
          pasient.leggTilResept(resept);
          return resept;
        }
        else{
          throw new UlovligUtskrift(this, legemiddel);
        }
      }
      else{
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
      }
    }
}
