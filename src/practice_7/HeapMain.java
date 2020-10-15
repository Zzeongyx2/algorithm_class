package practice_7;
import java.util.Scanner;
import static java.lang.System.exit;
public class HeapMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BinaryHeap<Integer> binaryHeap = new BinaryHeap<Integer>();

        System.out.println("10개의 숫자를 입력해주세요 : ");
        for(int i=0;i<10;i++){
            int n = scan.nextInt();
            binaryHeap.insert(n);
        }

        while(true){
            System.out.println("1.add  2.delete 3.show 4.exit");
            int n = scan.nextInt();

            switch (n){
                case 1:
                    System.out.println("추가할 숫자를 입력하세요 : ");
                    int num = scan.nextInt();
                    binaryHeap.insert(num);
                    break;
                case 2:
                    Integer del = binaryHeap.delMin();
                    System.out.println(del +"이 삭제되었습니다.");
                    break;
                case 3:
                    binaryHeap.show();
                    break;
                default:
                    exit(0);
                    break;
            }
        }
    }
}
