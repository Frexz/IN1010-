public class DuplikatException extends Exception {
    
    public DuplikatException(String id) {
        System.out.println("Boken " + id + " finnes allerede i bokhyllen.");
    }
}
