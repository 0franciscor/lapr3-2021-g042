package lapr.project.model;

import java.awt.geom.Point2D;
import java.util.Comparator;

/**
 * Class that represents a Ports2DTree
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 * @param <Ports> Generic Class E
 */
public class Ports2DTree<Ports> {

    /* Nested static class for a 2D tree node. */

    protected static class Node<Ports> {

        protected Point2D.Double coords;
        protected Node<Ports> left;
        protected Node<Ports> right;
        protected Ports port;

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param port
         * @param latitude
         * @param longitude
         */
        public Node(Ports port, double latitude, double longitude) {
            this.coords = new Point2D.Double(latitude,longitude);
            this.port = port;
        }

        // accessor methods
        public Ports getPort() { return port; }
        public Point2D.Double getCoords() { return coords; }
        public Double getX() { return coords.x; }
        public Double getY() { return coords.y; }
        public Node<Ports> getLeft() { return left; }
        public Node<Ports> getRight() { return right; }

        // update methods
        public void setElement(Ports port) { this.port = port; }
        public void setLeft(Node<Ports> leftChild) { left = leftChild; }
        public void setRight(Node<Ports> rightChild) { right = rightChild; }
        public void setCoords(Double latitude, Double longitude){
            this.coords =new Point2D.Double(latitude,longitude);
        }
    }

    //----------- end of nested Node class -----------

    private final Comparator<Node<Ports>> compareX = new Comparator<Node<Ports>>() {
        @Override
        public int compare(Node<Ports> p1, Node<Ports> p2) {
            return Double.compare(p1.getX(), p2.getX());
        }
    };

    private final Comparator<Node<Ports>> compareY = new Comparator<Node<Ports>>() {
        @Override
        public int compare(Node<Ports> p1, Node<Ports> p2) {
            return Double.compare(p1.getY(), p2.getY());
        }
    };

    protected Node<Ports> root; // root of the tree

    /**
     * Constructs an empty 2D tree
     */
    public Ports2DTree(){
        root=null;
    }

    /**
     *
     * @return root Node of the tree (or null if tree is empty)
     */
    protected Node<Ports> root() {
        return root;
    }

    /**
     * Verifies if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty(){
        return root==null;
    }

    public void insert(Ports ports, double latitude, double longitude) {
        Node<Ports> node = new Node<>(ports, latitude, longitude);
        if (root == null)
            root = node;
        else
            insert(node, root, true);
    }

    private void insert(Node<Ports> node, Node<Ports> currentNode, boolean divX) {
        if (node == null)
            return;
        if (node.coords.equals(currentNode.coords))
            return;
        int compareResult = (divX ? compareX : compareY).compare(node, currentNode);
        if (compareResult == -1)
            if(currentNode.left == null)
                currentNode.left = node;
            else
                insert(node, currentNode.left, !divX);
        else
        if(currentNode.right == null)
            currentNode.right = node;
        else
            insert(node, currentNode.right, !divX);
    }

    public Ports findNearestNeighbour(double latitude, double longitude) {
        return findNearestNeighbour(root, latitude, longitude,root, true);
    }

    private Ports findNearestNeighbour(Node<Ports> node, double x, double y,Node<Ports> closestNode ,boolean divX) {

        if (node == null)
            return null;

        double d = Point2D.distanceSq(node.coords.x, node.coords.y, x, y);
        double closestDist = Point2D.distanceSq(closestNode.coords.x, closestNode.coords.y, x, y);

        if (closestDist > d) {
            closestNode.setElement(node.getPort());
            closestNode.setLeft(node.getLeft());
            closestNode.setRight(node.getRight());
            closestNode.setCoords(node.getX(),node.getY());
        }

        double delta = divX ? x - node.coords.x : y - node.coords.y;
        double delta2 = delta * delta;

        Node<Ports> node1 = delta < 0 ? node.left : node.right;
        Node<Ports> node2 = delta < 0 ? node.right : node.left;

        findNearestNeighbour(node1,x,y,closestNode, !divX);

        if (delta2 < closestDist) {
            findNearestNeighbour(node2, x,y,closestNode,!divX);
        }

        return closestNode.getPort();
    }
}
