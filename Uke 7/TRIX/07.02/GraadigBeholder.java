public class GraadigBeholder<T extends Comparable<T>> {
    T element = null;

    public T settInnNyttElement(T x) {
        if (element == null) {
            element = x;
            return null;
        }

        T tmp;
        if (x.compareTo(element) >= 0) {
            tmp = element;
            element = x;
            return tmp;
        } else {
            return null;
        }
    }

    public T hentElement() {
        return element;
    }
}
