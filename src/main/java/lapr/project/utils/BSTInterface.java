package lapr.project.utils;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 1201239 Francisco Redol
 * @param <E> Generic Class E
 */

public interface BSTInterface<E> {

    boolean isEmpty();
    void insert(E element);
    void remove(E element);

    int size();
    int height();

    E smallestElement();
    Iterable<E> inOrder();
//    Iterable<E> preOrder();
//    Iterable<E> posOrder();
//    Map<Integer, List<E>> nodesByLevel();

}

