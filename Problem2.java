class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int index = tops[0];
        int index2 = bottoms[0];

        int top,bottom = top = 0;

        for(int i=0;i<tops.length;i++)
            if(tops[i] == index && bottoms[i] == index)
                continue;
            else if(tops[i]==index)
                bottom++;
            else if(bottoms[i] == index)
                top++;
            else{
                top = -1;
                break;
            }

        int top2,bottom2 = top2 = 0;

        for(int i=0;i<tops.length;i++)
            if(tops[i] == index2 && bottoms[i] == index2)
                continue;
            else if(tops[i]==index2)
                bottom2++;
            else if(bottoms[i] == index2)
                top2++;
            else{
                top2 = -1;
                break;
            }
        return Math.max(Math.min(top2, bottom2),Math.min(top,bottom));
    }


}