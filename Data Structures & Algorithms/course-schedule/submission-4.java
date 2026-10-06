class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        int[] ind = new int[numCourses];

        for(int[] i: prerequisites){
            adj.get(i[0]).add(i[1]);
        }

        for(int i=0; i<numCourses; i++){
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
            int ele = qs.poll();
            vis++;
            for(int i: adj.get(ele)){
                ind[i]--;
                if(ind[i] == 0){
                    qs.offer(i);
                }
            }
        }
        return vis == numCourses;
    }
}
