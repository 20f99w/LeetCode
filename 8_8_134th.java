class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for(int i=0;i<gas.length;i++){
            if(gas[i]<cost[i]) continue;
            int gass=0;
            int p=0;
            for(int j=i;j<(i+gas.length);j++){
                if(gass<0) break;
                if(j>=gas.length) {
                    gass+=(gas[p]-cost[p]);
                    p++;
                    continue;
                }
                gass+=(gas[j]-cost[j]);
            }
            if(gass>=0) return i;
        }
        return -1;
    }
}
