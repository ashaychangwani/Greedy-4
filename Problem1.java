class Solution {
    public int shortestWay(String source, String target) {
        int first[] = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);

        ArrayList<Integer> locations[] = new ArrayList[26];
        for(int i=0;i<26;i++)
            locations[i] = new ArrayList<>();

        int c;
        for(int i=0;i<source.length();i++){
            c = source.charAt(i) - 'a';
            first[c] = 0;
            locations[c].add(i);
        }
        int backup[] = first.clone();
        int length = 0;
        int count = 0;
        int index = 0;
        for(int i=0;i<target.length();i++){
            c = target.charAt(i) - 'a';
            index = findNext(locations[c], first[c], index);
            if(index == -1)
                if(length == 0)
                    return -1;
                else{
                    first = backup.clone();
                    length = 0;
                    count++;
                    index = 0;
                    i--;
                }
            else{
                first[c] = index + 1;
                index = locations[c].get(index)+1;
                length++;
            }
        }
        return count+1;
    }
    public int findNext(ArrayList<Integer> locations, int low, int target){
        int high = locations.size();
        int mid;
        while(low<high){
            mid = low + (high - low)/2;
            if(locations.get(mid) == target)
                return mid;
            if(locations.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        if(low >= locations.size())
            return -1;
        return low;
    }
}