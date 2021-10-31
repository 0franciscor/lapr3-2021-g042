package lapr.project.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 1201239 Francisco Redol
 * @param <ShipLocation>
 */

public interface ShipLocationBST_Interface<ShipLocation> {

    boolean isEmpty();
    void insert(ShipLocation element);
    void remove(ShipLocation element);

    int size();
    int height();

    ShipLocation smallestElement();
    Iterable<ShipLocation> inOrder();
    Iterable<ShipLocation> preOrder();
    Iterable<ShipLocation> posOrder();
    Map<Integer, List<ShipLocation>> nodesByLevel();

}

