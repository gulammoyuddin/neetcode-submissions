class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Hashtable<String, ArrayList<String>> ht = new Hashtable<>();
        
        for(String w: wordList){
            for(int i =0; i<w.length(); i++){
                StringBuilder sb = new StringBuilder(w);
                sb.setCharAt(i, '*');
                String pattern = sb.toString();

                if(!ht.containsKey(pattern)){
                    ht.put(pattern, new ArrayList<String>());
                }
                ht.get(pattern).add(w);
            }
        }

        // ht.forEach((key, value) -> {
        //     System.out.println(key + " -> "+ value);
        // });
        // System.out.println("");

        Queue<String> qs = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        qs.add(beginWord);
        hs.add(beginWord);
        int n = 1;

        while(!qs.isEmpty()){
            int k = qs.size();
            for(int i=0; i<k; i++){
                String wo = qs.poll();
                hs.add(wo);
                for(int j = 0; j<wo.length(); j++){
                    StringBuilder sb = new StringBuilder(wo);
                    sb.setCharAt(j, '*');
                    String pattern = sb.toString();

                    // System.out.println(pattern + " -> "+ wo);

                    if(ht.get(pattern) == null) continue;

                    for(String wi: ht.get(pattern)){
                        if(wi.equals(endWord)){
                            return n+1;
                        }

                        if(!hs.contains(wi)) qs.offer(wi);
                    }
                }   
            }
            n++;
        }
        return 0;
    }
}
