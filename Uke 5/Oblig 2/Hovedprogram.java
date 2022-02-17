public class Hovedprogram {
    public static void main(String[] args) {
        
        // Oppretter legemiddel-objekter
        Vanlig vanlig1 = new Vanlig("Aerius", 85, 5);
        Vanlig vanlig2 = new Vanlig("Microgynon", 110, 5);
        Narkotisk narkotisk = new Narkotisk("Paralgin forte", 86, 60, 2);
        Vanedannende vanedannende = new Vanedannende("Valium", 100, 5, 2);

        // Oppretter lege-objekter
        Lege lege = new Lege("Hans Hansen");
        Spesialist spesialist = new Spesialist("Line Li", "123456");

        // Oppretter resept-objekter
        HvitResept hvit = new HvitResept(vanlig1, lege, 1, 3);
        MilResept mil = new MilResept(narkotisk, spesialist, 2);
        PResept pres = new PResept(vanlig2, lege, 3, 5);
        BlaaResept blaa = new BlaaResept(vanedannende, spesialist, 4, 1);

        // Skriver ut informasjon om objektene
        System.out.println(vanlig1);
        System.out.println(vanlig2);
        System.out.println(narkotisk);
        System.out.println(vanedannende);

        System.out.println(lege);
        System.out.println(spesialist);

        System.out.println(hvit);
        System.out.println(mil);
        System.out.println(pres);
        System.out.println(blaa);
    }
}
