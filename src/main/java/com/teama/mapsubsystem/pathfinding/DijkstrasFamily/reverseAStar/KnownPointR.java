package com.teama.mapsubsystem.pathfinding.DijkstrasFamily.reverseAStar;

import com.teama.mapsubsystem.data.MapNode;
import com.teama.mapsubsystem.pathfinding.DijkstrasFamily.KnownPoint;

public class KnownPointR extends KnownPoint {


    private KnownPointR lastNode;
    private int completeCost;

    //constructor
    public KnownPointR(MapNode node, KnownPointR lastNode, int pastCost, int completeCost) {
        this.node = node;
        this.lastNode = lastNode;
        this.pastCost = pastCost;
        this.completeCost = completeCost;
    }
    /**
     * Implemented to allow PriorityQueue to sort this.
     * Compare based on the CompleteCost
     * @param o KnownPoint to compare to itself
     * @return 0 if equal. 1 if completeCost in this one is bigger, -1 if this one is smaller.
     */
    @Override
    public int compareTo(Object o) {
        KnownPointR node = (KnownPointR) o;
        if (this.completeCost > node.completeCost) return -1;
        else if (this.completeCost == node.completeCost) return 0;
        else if (this.completeCost < node.completeCost) return 1;
        return 0;
    }

    //////////// getter and setter
    public KnownPointR getLastNode() {
        return lastNode;
    }

    public void setLastNode(KnownPointR lastNode) {
        this.lastNode = lastNode;
    }

    public int getCompleteCost() {
        return completeCost;
    }

    public void setCompleteCost(int completeCost) {
        this.completeCost = completeCost;
    }

}
