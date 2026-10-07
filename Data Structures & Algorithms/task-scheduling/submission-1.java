class Solution {
    public int leastInterval(char[] tasks, int n) {
     int[] freq = new int[26];
     int[] times = new int[26];


     for(char c: tasks){
        freq[c - 'A']++;
     }
     PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> {
        return Integer.compare(freq[b-'A'], freq[a-'A']);
     });
     
     Queue<Character> qs = new LinkedList<>();

     for(int i=0; i<26; i++){
        if(freq[i] == 0) continue;

        pq.add((char) (i+'A'));
     }
     int time = 0;

     while(!(pq.isEmpty() && qs.isEmpty())){
        if(!qs.isEmpty() && times[qs.peek() - 'A'] <= time){
            pq.add(qs.poll());
        }
        if(!pq.isEmpty()){
            char t = pq.poll();
            freq[t-'A']--;
            time++;
            if(freq[t-'A'] > 0) {
                qs.add(t);
                times[t-'A'] = time+n;
            }
        }else{
            if(!qs.isEmpty() && time < times[qs.peek()-'A']){
                time = times[qs.peek()-'A'];
            }
        }
     }
     return time;
    }
}
