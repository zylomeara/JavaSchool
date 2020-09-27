package homeworks.lesson_3_generics.task_2;

import org.junit.Test;

import java.util.*;

public class TestCollectionGenerics {
    @Test
    public void testAddAll() {
        List<Parent> parents = new ArrayList<>();
        List<Child> children = new ArrayList<>();

        CollectionUtils.addAll(children, parents);
    }

    @Test
    public void testNewArrayList() {
        assert Collections.emptyList().equals(CollectionUtils.newArrayList());
    }

    @Test
    public void testIndexOf() {
        List<Parent> lst = new ArrayList<>();
        Child child = new Child();
        lst.add(child);

        assert CollectionUtils.indexOf(lst, child) == 0;
    }

    @Test
    public void testLimit() {
        Child child = new Child();
        List<Child> lst = Arrays.asList(child, child, child);
        List<Parent> limitedLst = CollectionUtils.limit(lst, 2);

        assert limitedLst.equals(Arrays.asList(child, child));
    }

    @Test
    public void testAdd() {
        List<Parent> lst = new ArrayList<>();
        Child child = new Child();

        CollectionUtils.add(lst, child);

        assert lst.equals(Collections.singletonList(child));
    }

    @Test
    public void testRemoveAll() {
        Child child = new Child();
        Child child2 = new Child();
        ArrayList<Parent> lst = new ArrayList<>(Arrays.asList(child, child2));
        List<Child> lst2 = Collections.singletonList(child);

        CollectionUtils.removeAll(lst, lst2);

        assert lst.equals(Collections.singletonList(child2));
    }

    @Test
    public void testContainsAll() {
        Child child = new Child();
        Child child2 = new Child();
        List<Parent> lst = Arrays.asList(child, child2);
        List<Child> lst2 = Collections.singletonList(child);

        assert CollectionUtils.containsAll(lst, lst2);
    }

    @Test
    public void testContainsAny() {
        Child child = new Child();
        Child child2 = new Child();
        List<Parent> lst = Arrays.asList(child, child2);
        List<Child> lst2 = Collections.singletonList(child);

        assert CollectionUtils.containsAny(lst, lst2);
    }

    @Test
    public void testRange() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> filteredList = CollectionUtils.range(integerList, 3, 7);

        assert filteredList.equals(Arrays.asList(3, 4, 5, 6 ,7));
    }

    @Test
    public void testRangeWithComparator() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

        List<Integer> filteredList = CollectionUtils.range(integerList, 3, 7, comparator);

        assert filteredList.equals(Arrays.asList(3, 4, 5, 6 ,7));
    }
}
