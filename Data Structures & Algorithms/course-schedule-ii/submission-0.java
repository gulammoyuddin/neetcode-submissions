class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] i: prerequisites){
            adj.get(i[1]).add(i[0]);
        }

        int[] ind = new int[numCourses];
        int[] res = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            for(int j: adj.get(i)){
                ind[j]++;
            }
        }

        Queue<Integer> qs = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(ind[i] == 0) qs.offer(i);
        }

        int vis = 0;

        while(!qs.isEmpty()){
            int c = qs.poll();
            res[vis] = c;
            vis++;
            for(int i: adj.get(c)){
                ind[i]--;
                if(ind[i] == 0){
                    qs.offer(i);
                }
            }
        }
        return numCourses == vis ? res : new int[0];
    }
}
