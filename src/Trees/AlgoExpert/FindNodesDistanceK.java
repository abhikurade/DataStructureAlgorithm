package Trees.AlgoExpert;

import Utils.AlgoExpert.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;

public class FindNodesDistanceK {
    public static void main(String[] args) {

    }

    public boolean buildMap(BinaryTree node, int target, HashMap<BinaryTree, Boolean> map){
        if(node == null) return false;

        boolean left = buildMap(node.left, target, map);
        boolean right = buildMap(node.right, target, map);

        boolean thisVal = ( node.value == target ) || left || right ;
        // something is missing here
        map.put(node, thisVal);

        return thisVal;
    }

    public ArrayList<Integer> getKDistanceNodes(BinaryTree node, HashMap<BinaryTree, Boolean> map, int k, int dist, ArrayList<Integer> nodes){
        if(node == null) return  nodes;

        int curr_dist = map.get(node) ? dist - 1 : dist + 1;

        if(curr_dist == k) nodes.add(node.value);
        getKDistanceNodes(node.left, map, k, curr_dist, nodes);
        getKDistanceNodes(node.right, map, k, curr_dist, nodes);

        return nodes;
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        HashMap<BinaryTree, Boolean> map = new HashMap<>();
        buildMap(tree, target, map);
        //System.out.println(map);
        int dist = 0;
        for(BinaryTree nd : map.keySet()) if(map.get(nd)) dist += 1;
        ArrayList<Integer> nodes = new ArrayList<>();
        return getKDistanceNodes(tree, map, k, dist, nodes);
    }

}
