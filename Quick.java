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
   start = data[0];
   end = data[data.length - 1];

//   while(pivot != (data.length - 1) / 2)

}

// [0, 7, 9, 8, 5, 4] --> 4
