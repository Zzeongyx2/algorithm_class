package practice_10;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }

    private Node put(Node x, Key key, Value val){
        if(x == null){
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, val);
        }else if(cmp > 0){
            x.right = put(x.right, key, val);
        }else{
            x.val = val;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else if(cmp > 0){
                x = x.right;
            }else{
                return x.val;
            }
        }
        return null;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);

        if(cmp == 0){
            return x;
        }
        if(cmp < 0){
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null){
                return t;
            }
            else{
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.count;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.count = size(x.left) + size(x.right) +1;
        return x;
    }

    public void deleteMax(){
        root = deleteMin(root);
    }

    private Node deleteMax(Node x){
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        else{
            return min(x.left);
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null){
            return x;
        }
        else{
            return max(x.right);
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0){
            return rank(key, x.left);
        }
        else if (cmp > 0){
            return 1 + size(x.left) + rank(key, x.right);
        }
        else{
            return size(x.left);
        }
    }

    public void inorder(Node x){
        if(x == null){
            return;
        }
        inorder(x.left);
        System.out.println(x.key);
        inorder(x.right);
    }
}
