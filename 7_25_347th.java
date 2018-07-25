class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<Integer>();
        Map<Integer,Integer> a=new HashMap<Integer,Integer>();
        //a=null;
        for(int n:nums){
            if(a.containsKey(n)){
                int value=Integer.parseInt(a.get(n).toString());
                value++;
                a.put(n,value);
            }
            else{a.put(n,1);
        }
        }       
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(a.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> mapping1, Map.Entry<Integer, Integer> mapping2) {
                System.out.println("compare="+mapping1.getValue().compareTo(mapping2.getValue()));
                return mapping1.getValue().compareTo(mapping2.getValue());
            }
        });
        
        HashMap<Integer,Integer> mapKey=new HashMap<Integer,Integer>();
        int i = list.size()-1;
        int z=i;  
        for(Map.Entry<Integer,Integer> entry : list) {
            mapKey.put(i, entry.getKey());
            i--;
        }

        for(int j=0;j<k;j++){result.add( mapKey.get(j));}
        return result;
    }
    
}
