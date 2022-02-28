public class Parkeringsplass<E> {
    private E kjoretoy;

    public void parker(E kjoretoy) {
        this.kjoretoy = kjoretoy;
    }

    public E kjorUt() {
        E tmp = kjoretoy;

        kjoretoy = null;

        return tmp;
    }
}
