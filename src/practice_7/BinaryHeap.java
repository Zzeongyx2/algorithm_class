package practice_7;

public class BinaryHeap <T extends Comparable<T>>{

    private T[] arr = (T[]) new Comparable[1];
    private int tail = 0;

    public void insert(T e){
        if(tail == arr.length-1){
            resize(arr.length*2);
        }
        tail++;
        arr[tail] = e;
        swim(tail);
    }

    private void swim(int pos){
        while(1<pos){
            T child = arr[pos];
            T parent = arr[pos/2];

            if(less(parent, child)){
                break;
            }else{
                exch(pos, pos/2);
                pos = pos/2;
            }
        }
    }

    public T delMin(){
        T min = arr[1];
        arr[1] = arr[tail--];
        sink(1);
        arr[tail+1] = null;
        if(tail <= arr.length/4){
            resize(arr.length/2);
        }
        sink(1);
        return min;
    }

    private void sink(int pos){
        while(2*pos <= tail){
            int j = 2*pos;
            if(j < tail && !less(arr[j], arr[j+1])){
                j++;
            }
            if(less(arr[pos], arr[j])){
                break;
            }
            exch(pos, j);
            pos = j;
        }
    }

    private boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }


    private void exch(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void resize(int max){

        T[] temp = (T[]) new Comparable[max];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void show(){
        for(int i=1; i<arr.length;i++){
            if(arr[i] == null){
                break;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
