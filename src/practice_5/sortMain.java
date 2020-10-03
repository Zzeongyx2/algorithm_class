package practice_5;

public class sortMain {
    public static void main(String[] args) {
        Integer[] a = {1,3,5,4};
        Integer[] arr = {7,3,2,16,24,4,11,9};
        Integer[] aux = new Integer[arr.length];


        InsectionSort<Integer> insectionSort = new InsectionSort<Integer>();

        insectionSort.sort(a);
        System.out.println("Insection sort : ");
        insectionSort.show(a);

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(arr, aux, 0, arr.length-1);
        System.out.println("Merge sort : ");
        mergeSort.show(arr);
    }
}
