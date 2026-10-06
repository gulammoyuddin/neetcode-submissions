class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
      int[] parent = new int[n+1];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int[] e: edges){
            if(!union(e[0], e[1], parent)){
                return e;
            }
        }
        return new int[0];
    }

    public int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public boolean union(int i, int j, int[] parent){
        int root1 = find(i, parent);
        int root2 = find(j, parent);

        if(root1 == root2){
            return false;
        }

        parent[root2] = root1;
        return true;
    }
}
