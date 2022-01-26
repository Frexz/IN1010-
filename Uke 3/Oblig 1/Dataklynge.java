import java.util.ArrayList;

public class Dataklynge {
    
    // Deklarerer instansvariabler
    ArrayList<Rack> dataklynge = new ArrayList<Rack>();

    // Setter inn node i et ledig rack
    public void settInnIRack(Node node) {
        Rack ledigRack;

        // Sjekker om det finnes noen racks og oppretter et hvis ikke
        if (dataklynge.isEmpty()) {
            dataklynge.add(new Rack());
        }

        // Sjekker om siste rack i klyngen er fullt og lager nytt rack hvis det er det
        if (dataklynge.get(dataklynge.size() - 1).erFullt()) {
            dataklynge.add(new Rack());
        }

        // Setter inn node i ledig rack
        ledigRack = dataklynge.get(dataklynge.size() - 1);
        ledigRack.settInnNode(node);
    }

    // Returnerer antall prosessorer i dataklyngen
    public int antProsessorer() {
        int totalPros = 0;

        for (Rack rack : dataklynge) {
            totalPros += rack.antProsessorer();
        }

        return totalPros;
    }

    // Returnerer antall noder med nok minne
    public int noderMedNokMinne(int paakrevdMinne) {
        int antall = 0;

        for (Rack rack : dataklynge) {
            antall += rack.noderMedNokMinne(paakrevdMinne);
        }

        return antall;
    }

    // Returnerer antall racks
    public int antallRack() {
        return dataklynge.size();
    }
}
