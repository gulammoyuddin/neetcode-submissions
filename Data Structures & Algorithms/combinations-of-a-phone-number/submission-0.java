class Solution {
    public List<String> hs;
    public Hashtable<Character, char[]> ht;
    public List<String> letterCombinations(String digits) {
        hs = new ArrayList<String>();
        ht = makeCharMap();
        makeCombinations(digits.toCharArray(), 0, new StringBuilder());
        return hs;
    }
    public Hashtable<Character, char[]> makeCharMap(){
        Hashtable<Character, char[]> ht = new Hashtable<Character, char[]>();
        ht.put('2', new char[]{'a', 'b', 'c'});
        ht.put('3', new char[]{'d', 'e', 'f'});
        ht.put('4', new char[]{'g', 'h', 'i'});
        ht.put('5', new char[]{'j', 'k', 'l'});
        ht.put('6', new char[]{'m', 'n', 'o'});
        ht.put('7', new char[]{'p', 'q', 'r', 's'});
        ht.put('8', new char[]{'t', 'u', 'v'});
        ht.put('9', new char[]{'w', 'x', 'y', 'z'});
        return ht;
    }
    public void makeCombinations(char[] s, int curr, StringBuilder sb){
        if(s.length == curr){
            if(sb.length() > 0) hs.add(sb.toString());
            return;
        }
        char[] c = ht.get(s[curr]);
        for(int i=0; i<c.length; i++){
            sb.append(c[i]);
            makeCombinations(s, curr+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
