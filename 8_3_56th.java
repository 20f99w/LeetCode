/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//时间来不及了，我明天完善下面的自己的方法，今天先摘抄吧_(:з」∠)_
//啊，阅读了一下答案果然晚上想题目脑子不够用，明天要改进一下自己的方法，先排序start再if_(:з」∠)_；

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
         if (intervals.size() <= 1)
        return intervals;
    
    // Sort by ascending starting point using an anonymous Comparator
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    
    List<Interval> result = new LinkedList<Interval>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    
    for (Interval interval : intervals) {
        if (interval.start <= end) // Overlapping intervals, move the end if needed
            end = Math.max(end, interval.end);
        else {                     // Disjoint intervals, add the previous one and reset bounds
            result.add(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }
    
    // Add the last interval
    result.add(new Interval(start, end));
    return result;
    }
}
// List<Interval> result=new ArrayList<Interval>();
//         ArrayList<Interval> array=new ArrayList<Interval>();
//         array=(ArrayList)intervals;
        
//         //System.out.println("list="+intervals);
//         System.out.println("arraylist="+array);
//         if(array.size()==1) result.add(array.get(0));
            
//         for(int i=0;i<array.size()-1;i++){
//             Interval c=new Interval();
//             //System.out.println("array.get(i)="+c.start);
//             if(array.get(i).end>=array.get(i+1).start){
//                 Interval b=new Interval(array.get(i).start, array.get(i+1).end);
//                 result.add(b);
//                 i++;
//             }
//             else result.add(array.get(i));
//         }
        
//         if(array.size()>=2){
//             Interval c=new Interval();
//             Interval d=new Interval();
//             c=array.get(array.size()-2);
//             d=array.get(array.size()-1);
//             if(c.end<d.start) result.add(d);  
//         }
        
//         return result;
