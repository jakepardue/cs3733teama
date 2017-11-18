package entities.PathRelated;

import entities.MapEdge;
import entities.MapNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnownPoint implements  Comparable {

    private MapNode node;
    private KnownPoint lastNode;
    private int pastCost,completeCost;
    private int layer;

    //constructor
    public KnownPoint(MapNode node, KnownPoint lastNode, int pastCost, int completeCost) {
        this.node = node;
        this.lastNode = lastNode;
        this.pastCost = pastCost;
        this.completeCost = completeCost;
    }

    public KnownPoint(MapNode node, int layer) {
        this.node=node;
        this.layer=layer;
    }

        /**
         * a little helper function
         * @return return the edges contained with stored node.
         */
    public ArrayList<MapEdge> getEdge()
    {
        return node.getEdges();
    }

    /**
     * a helper function for getting adjacentNodes.
     * @return  all the mapNodes linked by the edges in the node in ArrayList
     */
    public ArrayList<MapNode>  getAdjacentNodes()
    {
        ArrayList<MapNode> result = new ArrayList<>();
        for (MapEdge edge : node.getEdges()) {
            if(edge.getStart().getId().equals((node.getId()))) result.add(edge.getEnd());
            else result.add(edge.getStart());
        }
        return result;
    }


    /**
     * Implemented to allow PriorityQueue to sort this.
     * Compare based on the CompleteCost
     * @param o KnownPoint to compare to itself
     * @return 0 if equal. 1 if completeCost in this one is bigger, -1 if this one is smaller.
     */
    @Override
    public int compareTo(Object o) {
        KnownPoint node = (KnownPoint) o;
        if (this.completeCost > node.completeCost) return 1;
        else if (this.completeCost == node.completeCost) return 0;
        else if (this.completeCost < node.completeCost) return -1;
        return 0;
    }

    //////////// getter and setter
    public MapNode getNode() {
        return node;
    }

    public void setNode(MapNode node) {
        this.node = node;
    }

    public KnownPoint getLastNode() {
        return lastNode;
    }

    public void setLastNode(KnownPoint lastNode) {
        this.lastNode = lastNode;
    }

    public int getPastCost() {
        return pastCost;
    }

    public void setPastCost(int pastCost) {
        this.pastCost = pastCost;
    }

    public int getCompleteCost() {
        return completeCost;
    }

    public void setCompleteCost(int completeCost) {
        this.completeCost = completeCost;
    }


    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
