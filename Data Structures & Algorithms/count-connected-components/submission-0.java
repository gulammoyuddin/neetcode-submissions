class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        for(int[] e: edges){
            union(e[0], e[1], parent);
        }

        HashSet<Integer> hs = new HashSet<>();

        for(int i: parent){
            hs.add(find(i, parent));
        }

        return hs.size();
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
