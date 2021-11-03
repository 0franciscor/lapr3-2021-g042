package lapr.project.model;

import lapr.project.utils.BSTInterface;

import java.util.*;

/**
 * Class that represents a BstShip
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class BstShip<E> implements BSTInterface<Ship>{

    /** Nested static class for a binary search tree node. */

    protected static class Node<Ship> {
        private Ship ship;             // a Ship stored at this node
        private Node<Ship> left;       // a reference to the left child (if any)
        private Node<Ship> right;      // a reference to the right child (if any)

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param ship  the element to be stored
         * @param leftChild   reference to a left child node
         * @param rightChild  reference to a right child node
         */
        public Node(Ship ship, Node<Ship> leftChild, Node<Ship> rightChild) {
            this.ship = ship;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public Ship getShip() { return ship; }
        public Node<Ship> getLeft() { return left; }
        public Node<Ship> getRight() { return right; }

        // update methods
        public void setElement(Ship ship) { this.ship = ship; }
        public void setLeft(Node<Ship> leftChild) { left = leftChild; }
        public void setRight(Node<Ship> rightChild) { right = rightChild; }
    }

    //----------- end of nested Node class -----------

    protected Node<Ship> root = null;     // root of the tree

    /**
     * Constructs an empty binary search tree
     */
    public BstShip() { root = null; }


    /*
     * @return root Node of the tree (or null if tree is empty)
     */
    protected Node<Ship> root() {
        return root;
    }

    /*
     * Verifies if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return root==null;
    }

    /**
     * Returns the Node containing a specific Element, or null otherwise.
     *
     * @param ship    the element to find
     * @return the Node that contains the Element, or null otherwise
     *
     * This method despite not being essential is very useful.
     * It is written here in order to be used by this class and its
     * subclasses avoiding recoding.
     * So its access level is protected
     */
    protected Node<Ship> find(Node<Ship> node, Ship ship){
        if (node == null)
            return null;
        if (node.getShip().compareTo(ship)==0)
            return node;
        if (node.getShip().compareTo(ship) > 0)
            return find(node.getLeft(),ship);
        else
            return find(node.getRight(),ship);
    }

    /*
     * Inserts an element in the tree.
     */
    public void insert(Ship ship){
        root = insert(ship, root);
    }

    private Node<Ship> insert(Ship ship, Node<Ship> node){
        if(node == null)
            return new Node(ship, null, null);

        if(node.getShip().compareTo(ship) > 0)
            node.setLeft(insert(ship, node.getLeft()));

        else
        if(node.getShip().compareTo(ship) < 0)
            node.setRight(insert(ship, node.getRight()));

        return node;
    }

    /**
     * Removes an element from the tree maintaining its consistency as a Binary Search Tree.
     */
    public void remove(Ship ship){
        root = remove(ship, root());
    }

    private Node<Ship> remove(Ship ship, Node<Ship> node) {

        if (node == null) {
            return null;    //throw new IllegalArgumentException("Element does not exist");
        }
        if (ship.compareTo(node.getShip())==0) {
            // node is the Node to be removed
            if (node.getLeft() == null && node.getRight() == null) { //node is a leaf (has no childs)
                return null;
            }
            if (node.getLeft() == null) {   //has only right child
                return node.getRight();
            }
            if (node.getRight() == null) {  //has only left child
                return node.getLeft();
            }
            Ship min = smallestElement(node.getRight());
            node.setElement(min);
            node.setRight(remove(min, node.getRight()));
        }
        else if (ship.compareTo(node.getShip()) < 0)
            node.setLeft( remove(ship, node.getLeft()) );
        else
            node.setRight( remove(ship, node.getRight()) );

        return node;
    }

    /*
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    public int size(){
        return size(root);
    }

    private int size(Node<Ship> node){
        if(node == null)
            return 0;

        return 1 + size(node.getLeft()) + size(node.getRight());
    }


    public int height(){
        return height(root);
    }

    /*
     * Returns the height of the subtree rooted at Node node.
     * @param node A valid Node within the tree
     * @return height
     */
    protected int height(Node<Ship> node){
        if (node == null)
            return -1;

        int lDepth = height(node.left);
        int rDepth = height(node.right);

        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);
    }

    /**
     * Returns the smallest element within the tree.
     * @return the smallest element within the tree
     */
    public Ship smallestElement(){
        return smallestElement(root);
    }

    protected Ship smallestElement(Node<Ship> node) {
        if (node == null)
            return null;

        Node<Ship> auxNode;
        for(auxNode = node; auxNode.getLeft() !=  null; auxNode = auxNode.getLeft());

        return auxNode.getShip();
    }

    /*
     * Returns an iterable collection of elements of the tree, reported in in-order.
     * @return iterable collection of the tree's elements reported in in-order
     */
    public Iterable<Ship> inOrder(){
        List<Ship> snapshot = new ArrayList<>();
        if (root!=null)
            inOrderSubtree(root, snapshot);   // fill the snapshot recursively
        return snapshot;
    }
    /**
     * Adds elements of the subtree rooted at Node node to the given
     * snapshot using an in-order traversal
     * @param node       Node serving as the root of a subtree
     * @param snapshot  a list to which results are appended
     */
    private void inOrderSubtree(Node<Ship> node, List<Ship> snapshot) {
        if (node == null)
            return;
        inOrderSubtree(node.getLeft(), snapshot);
        snapshot.add(node.getShip());
        inOrderSubtree(node.getRight(), snapshot);
    }
    /**
     * Returns an iterable collection of elements of the tree, reported in pre-order.
     * @return iterable collection of the tree's elements reported in pre-order
     */
    public Iterable<Ship> preOrder(){
        List<Ship> snapshot = new ArrayList<>();
        if (root!=null)
            preOrderSubtree(root, snapshot);   // fill the snapshot recursively
        return snapshot;
    }
    /**
     * Adds elements of the subtree rooted at Node node to the given
     * snapshot using an pre-order traversal
     * @param node       Node serving as the root of a subtree
     * @param snapshot  a list to which results are appended
     */
    private void preOrderSubtree(Node<Ship> node, List<Ship> snapshot) {
        if(node == null)
            return;

        snapshot.add(node.getShip());
        preOrderSubtree(node.getLeft(), snapshot);
        preOrderSubtree(node.getRight(), snapshot);
    }
    /**
     * Returns an iterable collection of elements of the tree, reported in post-order.
     * @return iterable collection of the tree's elements reported in post-order
     */
    public Iterable<Ship> posOrder(){
        List<Ship> snapshot = new ArrayList<>();
        if (root!=null)
            posOrderSubtree(root, snapshot);
        return snapshot;
    }
    /**
     * Adds positions of the subtree rooted at Node node to the given
     * snapshot using an post-order traversal
     * @param node       Node serving as the root of a subtree
     * @param snapshot  a list to which results are appended
     */
    private void posOrderSubtree(Node<Ship> node, List<Ship> snapshot) {
        if(node == null)
            return;
        posOrderSubtree(node.getLeft(), snapshot);
        posOrderSubtree(node.getRight(), snapshot);
        snapshot.add(node.getShip());
    }

    /*
     * Returns a map with a list of nodes by each tree level.
     * @return a map with a list of nodes by each tree level
     */
    public Map<Integer,List<Ship>> nodesByLevel(){
        Map<Integer, List<Ship>> nodesBylevel = new HashMap<>();
        processBstByLevel(root, nodesBylevel, 0);
        return nodesBylevel;
    }

    private void processBstByLevel(Node<Ship> node, Map<Integer,List<Ship>> result, int level){
        if(node == null)
            return;

        if(result.get(level) == null)
            result.put(level, new ArrayList<>());

        result.get(level).add(node.getShip());
        processBstByLevel(node.getLeft(), result, level + 1);
        processBstByLevel(node.getRight(), result, level + 1);
    }


    /**
     * @param MMSI that identifies the desired ship.
     *
     * This method allows the user to search a certain ship on the BST through its MMSI code (unique code).
     *
     * @return the identified Ship
     */
    public Ship getShipByMmsiCode(String MMSI){
        Ship shipToFind = new Ship();
        shipToFind.setMMSI(MMSI);

        return find(root, shipToFind).getShip();
    }


    /**
     *
     * @param imoCode
     * @return
     */
    public Ship getShipByIMO(String imoCode){
        return new Ship();
    }

    /**
     *
     * @param callSign
     * @return
     */
    public Ship getShipByCallSign(String callSign){
        return new Ship();
    }
}


