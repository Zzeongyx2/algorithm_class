package practice_9;

public class OrderedST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N = 0;
    private int size =100;

    public void orderedST(){
        keys = (Key[]) new Comparable[size];
        vals = (Value[]) new Object[size];
    }

    public void put(Key key, Value val){
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        N++;
        for(int j=N; j>i;j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0){
            return vals[i];
        }else{
            return null;
        }
    }

    public void delete(Key key){
        int i = rank(key);

        if(i<N || keys[i].compareTo(key) != 0){
            return;
        }
        for(int j=i; j<N;j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        N--;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        if(N == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return N;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N];
    }

    public int rank(Key key){
        int lo = 0;
        int hi = N-1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp<0){
                hi = mid -1;
            } else if (cmp > 0) {
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return lo;

    }

    public Key select(int k){
        return keys[k];
    }

    public void deleteMin(){
        delete(min());
    }

    public void deleteMax(){
        delete(max());
    }

    public int size(Key lo, Key hi){
        int x = rank(lo);
        int y = rank(hi);
        return y-x;
    }
}
