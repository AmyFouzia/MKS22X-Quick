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
   int pivot Math.random() * data.length; //index of pivot

   for(int i = 1; i < data.length - 1; i++){
     data.add(data[pivot], 0);

     start = data[i];
     end = data[data.length-1];

     if(start < data[pivot]){

     }
   }
  }
//  {0, 8, 7, 4, 9}
/*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public static int quickselect(int[] data, int k){

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
