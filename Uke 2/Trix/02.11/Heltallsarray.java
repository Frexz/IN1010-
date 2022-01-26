public class Heltallsarray {
    public static void main(String[] args) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 2;
        int t3 = 3;
        int t4 = 4;
        int t5 = 5;

        System.out.printf("Tall: %d %d %d %d %d\n", t0, t1, t2, t3, t4, t5);

        int[] heltallsarray = new int[5];

        for (int i = 0; i < 5; i++) {
            heltallsarray[i] = i;
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(heltallsarray[i]);
        }
    }
}
