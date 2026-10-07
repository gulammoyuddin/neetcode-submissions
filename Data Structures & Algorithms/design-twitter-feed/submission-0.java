class Twitter {
    Hashtable<Integer, LinkedList<Integer>> nft;
    Hashtable<Integer, HashSet<Integer>> ft;
    Hashtable<Integer, Integer> tt;
    int time;
    public Twitter() {
        nft = new Hashtable<Integer, LinkedList<Integer>>();
        ft = new Hashtable<Integer, HashSet<Integer>>();
        tt = new Hashtable<Integer, Integer>();
        time = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        makeUser(userId);
        if(nft.get(userId).size() < 10){
            nft.get(userId).offer(tweetId);
        }else{
            nft.get(userId).poll();
            nft.get(userId).offer(tweetId);
        }
        tt.put(tweetId, time);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> users = new ArrayList<Integer>(ft.get(userId));
        users.add(userId);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> {
            int distA = time - tt.get(a);
            int distB = time - tt.get(b);
            return Integer.compare(distB, distA);
        });

        for(int user: users){
            for(int tweet: nft.get(user)){
                if(pq.size() < 10){
                    pq.add(tweet);
                    continue;
                }
                int distA = time - tt.get(tweet);
                int distB = time - tt.get(pq.peek());
                if(distB > distA){
                    pq.poll();
                    pq.add(tweet);
                }
            }
        }

        List<Integer> res = new LinkedList<Integer>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll());
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        makeUser(followeeId);
        makeUser(followerId);
        ft.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(ft.get(followerId).contains(followeeId)){
            ft.get(followerId).remove(followeeId);
        }
    }

    public void makeUser(int userId){
        if(!ft.containsKey(userId)){
            ft.put(userId, new HashSet<Integer>());
        }
        if(!nft.containsKey(userId)){
            nft.put(userId, new LinkedList<Integer>());
        }
    }
}
