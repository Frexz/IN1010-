public class TestLegesystem {
    public static void main(String[] args) throws UlovligUtskrift {
        
        Legesystem ls = new Legesystem();

        for (Resept resept : ls.resepter) {
            System.out.println(resept);
        }

        
    }
}
