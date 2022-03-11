class Legesystem {

  //instansvariabler
  private Prioritetskoe<Legemiddel> legemidler; //ettersom ID er nevnt virker dette som den beste klassen for aa sortere
  private IndeksertListe<Lege> leger; //her burde vi få inn listen fra compareTo funksjonen i Lege klassen, vet ikke om dette er den mest ordnede losningen her
  private Prioritetskoe<Pasient> pasienter;
  private Prioritetskoe<Resept> resepter;

  //fil lesings funksjon
  public void lesFraFil(){
    //oppgave E1
  }

  //komandolokke funksjon
  public void komandolokke(){
    //oppgave E2
  }

  //utprint
  public void printElementer(){
    for (Legemiddel legemiddel : legemidler ) {
      println(legemiddel.toString);
    }
    for (Lege lege : leger ) { //denne listen maa vaere ordnet for utskrift
      println(lege.toString);
    }
    for (Pasient pasient : pasienter ) {
      println(pasient.toString);
    }
    for (Resept resept : resepter ) {
      println(resept.toString);
    }
  }

  //legge til objekt
  public void nyttObjekt(obj x){
    if (x instanceof Legemiddel) {
      legemidler.leggTil(x);
    }
    else if (x instanceof Lege) {
      leger.leggTil(x);
    }
    else if (x instanceof Pasient) {
      pasienter.leggTil(x);
    }
    else if (x instanceof Resept) {
      resepter.leggTil(x);
    }
    else{
      throw new Exception("Ugyldig input");
    }
  }

  //Bruk resept E5
  public void brukResept(Resept resept){ // ikke helt sikker paa hvordan vi skal kunne kalle paa en resept best ved navn, derfor lite kode her.
    resept.bruk();
  }

  //funksjon for aa vise statistikk om systemet E6
  public void meny(){

  }

  //skriv elementer til fil E7
  public void skrivTilFil(){

  }
}
