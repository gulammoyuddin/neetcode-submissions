class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int[] e: edges){
            if(!union(e[0], e[1], parent)){
                return false;
            }
        }
        int x = find(0, parent);
        for(int p: parent){
            if(x != find(p, parent)) return false;
        }
        return true;
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
