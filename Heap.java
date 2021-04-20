class Heap {

    private static void swap(int array[], int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }

    private static void buildMaxHeap(int array[]) {

        int size = array.length-1;

        for(int i=size/2;i>=1;i--) {
            maxHeapify(array,i,size);
        }

    }

    private static void maxHeapify(int array[], int i, int N) {

        int left = (i*2);
        int right = (i*2)+1;
        int largest = 0;

        if(left <= N && array[left]>array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if(right <= N && array[right]>array[largest]) {
            largest = right;
        }

        if(i!= largest) {

        swap(array,i,largest);
        maxHeapify(array,largest,N);

        }

        

    }

    private static void heapSort(int array[]) {

        buildMaxHeap(array);

        for(int i= array.length-1;i>=1;i--) {

            swap(array,1,i);
            maxHeapify(array,1,i-1);
            
        }

    }

    private static void descHeapSort(int array[]) {
        
        buildMinHeap(array);
        for(int i=array.length-1;i>=1;i--) {

            swap(array, 1, i);
            minHeapify(array, 1, i-1);

        }

    }

    private static void minHeapify(int array[], int i, int N) {

        int left = 2*i;
        int right = 2*i+1;
        int smallest = 0;

       

        if(left<=N && array[i]>array[left]) {
            smallest = left;
        } else {
            smallest = i ;
        }

        if(right<=N && array[smallest]>array[right]) {
            smallest = right;
        }

        if(smallest != i) {

            swap(array,smallest,i);
            minHeapify(array, smallest, N);

        }

    }

    private static void buildMinHeap(int array[]) {

        int len = array.length-1;
        int center = len/2;

        for(int i = center;i>=1;i--) {
            minHeapify(array, i, len);
        }

    }


    public static void main(String args[]) {
        int array[] = {0,7,6,5,11,5,4,33,37,9,10,4,3,2,1,8};
        // buildMaxHeap(array);
        // heapSort(array);
        // minHeapify(array,1, array.length-1);
        descHeapSort(array);
        for(int ii=1;ii<array.length;ii++)
            System.out.print(array[ii]+" ");
        
        System.out.println();
        
    }
}