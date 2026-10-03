/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Hashtable<Integer, Node> hs;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        hs = new Hashtable<Integer, Node>();
        return cloneIt(node);
    }
    public Node cloneIt(Node node){
        Node res = new Node(node.val, new ArrayList<Node>());
        hs.put(res.val, res);
        for(int i=0; i<node.neighbors.size(); i++){
            Node neigh = node.neighbors.get(i);
            if(hs.containsKey(neigh.val)){
                res.neighbors.add(hs.get(neigh.val));
            }else{
                res.neighbors.add(cloneIt(neigh));
            }
        }
        return res;
    }
}