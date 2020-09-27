package homeworks.lesson_2_collections.task_5;

import java.util.Iterator;
import java.util.List;

public class ReverseIterator<T> implements Iterable<T> {
    private final List<T> arrayList;
    private final int currentSize;

    public ReverseIterator(List<T> arrayList) {
        this.arrayList = arrayList;
        currentSize = arrayList.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                return arrayList.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
