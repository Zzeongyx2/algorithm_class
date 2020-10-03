package practice_5;

public class InsectionSort<T extends Comparable<T>> {
    public void sort(T[] a){
        for(int i=0; i<a.length; i++){
            for(int j=i; j>0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
                assert isSorted(a);
            }
            assert  isSorted(a);
        }
    }

    private boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }


    private void exch(Object[] arr, int i, int j){
        Object temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isSorted(T[] a){
        return isSorted(a, 0, a.length-1);
    }

    private boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Object[] a){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
