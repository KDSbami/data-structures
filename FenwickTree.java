class FenwickTree {

    int[] fenwikSum;
    FenwickTree(int[] array) {
        this.fenwikSum = new int[array.length+1];
        this.fenwikSum[0] = 0;
        for(int i=1;i<array.length+1;i++){

            this.update(i,array[i-1]);
        }
    }
    void replace(int index, int value){

        int newValue = index == 0?this.query(0):value-(this.query(index) - this.query(index-1));
        for(int i = index+1;i<this.fenwikSum.length;i += (i & (-i))) {
            this.fenwikSum[i] += newValue;
        }
    }

    void update(int index, int value){
        for(int i = index;i<this.fenwikSum.length;i += (i & (-i))) {
            this.fenwikSum[i] =this.fenwikSum[i] + value;
        }
    }

    int query(int index){
        int n = index+1;
        int sum = 0;
        for(int i=n;i>0;i-=(i &(-i))) {
            sum += this.fenwikSum[i];
        }
        return sum;
    }

    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        FenwickTree bit = new FenwickTree(arr);
        bit.replace(4, 6);
        bit.replace(0,2);
        for(int i=0;i<arr.length;i++)
            System.out.println(bit.query(i));
    }
}