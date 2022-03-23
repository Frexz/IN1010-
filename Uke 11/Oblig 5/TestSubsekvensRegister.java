import java.util.Collection;
import java.util.HashMap;

public class TestSubsekvensRegister {
    public static void main(String[] args) {
        HashMap<String,Subsekvens> hash1 = SubsekvensRegister.lesImmunrepetoar("Fil1.txt");
        HashMap<String,Subsekvens> hash2 = SubsekvensRegister.lesImmunrepetoar("Fil2.txt");

        for (Subsekvens sub : SubsekvensRegister.flettImmunrepetoar(hash1, hash2).values()) {
            System.out.println(sub);
        }
        
    }
}
