public class IkkeMerPlassException extends Exception {

    public IkkeMerPlassException(String id) {
        System.out.println("Det var ikke plass til " + id + " i bokhyllen.");
    }
}
