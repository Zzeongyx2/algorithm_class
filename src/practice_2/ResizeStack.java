package practice_2;

import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class ResizeStack {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();

        while (true) {

            System.out.println("연산번호를 선택하세요.");
            System.out.println("1.pop 2.push 3.reverse-iterator 4.exit");

            int num = scan.nextInt();

            switch (num) {
                case 1:
                    if (stack.isEmpty()) {
                        System.out.println("스택이 비어있습니다.");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;

                case 2:
                    System.out.println("데이터를 입력하세요.");
                    String data = scan.next();
                    stack.push(data);
                    break;

                case 3:
                    Iterator<String> reverse = stack.iterator();
                    while (reverse.hasNext()) {
                        System.out.println(reverse.next());
                    }
                    break;

                default:
                    exit(0);
                    break;
            }

        }

    }

}


