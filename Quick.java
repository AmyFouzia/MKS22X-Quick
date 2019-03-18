import java.util.*;

public class Quick{

  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
 public static int partition (int [] data, int start, int end){
   if(start != end){
     int trackStart = start;
     int midPoint = data[(start+end)/2];
     int pivot = 0;


     //median becomes the pivot
    if((data[start] <= data[end] && data[start] >= midPoint) || (data[start] >= data[end] && data[start] <= midPoint)){
      pivot = start;
    }
    if((data[end] <= data[start] && data[end] >= midPoint) || (data[end] >= data[start] && data[end] <= midPoint)){
      pivot = end;
    }
    if((midPoint <= data[start] && midPoint >= data[end]) || (midPoint >= data[start] && midPoint <= data[end])){
      pivot = (start+end)/2;
    }

    //swap
    int trackPivot = data[pivot];
    data[pivot] = data[start];
    data[start] = trackPivot;
    start ++;

    //start is greater than pivot --> swap values, move end
    while(start != end){
        if(data[start] > trackPivot){
          int first = data[start];
          int last = data[end];
          data[start] = last;
          data[end] = first;
          end--;
        }

        //values are equal, 50% chance of swap
        else if(data[start] == trackPivot && (int)Math.ceil(Math.random()*2) == 1){
          int first = data[start];
          int last = data[end];
          data[start] = last;
          data[end] = first;
          end--;
        }

        //move start
        else start++;
      }


      //swap first and start-1 if num is greater
      int temp1 = data[start];
      int temp2 = data[start-1];

      if(data[trackStart] < data[start]){
        data[start-1] = data[trackStart];
        data[trackStart] = temp2;
        return start-1;
      }

      //swap first and start if num is lesser
      else{
        data[start] = data[trackStart];
        data[trackStart] = temp1;
        return start;
      }
    }

   return start;
}

//  {0, 8, 7, 4, 9}
/*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public static int quickselect(int[] data, int k){
   return qsHelp(data,k,0,data.length-1);
 }

 private static int qsHelp(int[]data,int k, int start, int end){
   int pivot = partition(data,start,end);
   if(pivot < k) return qsHelp(data,k,pivot+1,end);
   if(pivot == k) return data[pivot];
   if(pivot > k) return qsHelp(data,k,start,pivot-1);
   return -1;
 }

/*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){
   dutchSort(data, 0, data.length-1);
 }

 private static void quicksortHelp(int[] data2, int low, int high){
  if(!(low > high)){
    int pivot = partition(data2, low, high);
    quicksortHelp(data2, low, pivot-1);
    quicksortHelp(data2, pivot+1, high);
  }
}

  private static int[] dutchPartition(int[] data, int start, int end){
    //op- part both sides
  }

  private static void dutchSort(int[] ary, int lo, int hi){
    //op- sort after parted w dutchPart
    if(lo<hi){
      int[] pivot = dutchPartition(ary,lo,hi);
      dutchSort(ary,lo,pivot[0]-1);
      dutchSort(ary,pivot[1]+1,hi);
    }
  }
/*Things to do: (and the order that makes the most sense)
1-Complete and test partition.
2-Complete Quickselect using partition
3-Improve partition (minimally using the easy improvement below) and test quickselect on an array of duplicate values. Should not be significantly longer than all unique values.
4-Complete Quicksort.
5-Optionally implement dutch flag paritioning and update quicksort to include this.
*/
public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
