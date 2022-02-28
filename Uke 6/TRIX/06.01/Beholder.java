public class Beholder<T> {
    private T figur;

    public void settInn(T figur) {
        this.figur = figur;
    }

    public T taUt() {
        return this.figur;
    }
}
