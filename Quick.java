public class Quick{

  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
 int partition (int [] data, int start, int end){
   if(start != end){
     int trackStart = start;
     int midPoint = data[(start+end)/2];
     int pivot;


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
    int first = data[start];
    int last = data[end];

    while(start != end){
        if(data[start] > trackPivot){
          data[start] = last;
          data[end] = first;
          end--;
        }

        //values are equal, 50% chance of swap
        else if(data[start] == trackPivot && (int)Math.ceil(Math.random()*2) == 1){
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
}

//  {0, 8, 7, 4, 9}
/*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public static int quickselect(int[] data, int k){
   return qsHelp(data,k,0,data.length-1);
 }

 private static int qsHelp(int[]data,int k, int start, int end){

 }

/*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){

 }


/*Things to do: (and the order that makes the most sense)
1-Complete and test partition.
2-Complete Quickselect using partition
3-Improve partition (minimally using the easy improvement below) and test quickselect on an array of duplicate values. Should not be significantly longer than all unique values.
4-Complete Quicksort.
5-Optionally implement dutch flag paritioning and update quicksort to include this.
*/

}
