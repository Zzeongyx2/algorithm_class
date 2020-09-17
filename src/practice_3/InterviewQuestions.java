package practice_3;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

public class InterviewQuestions {

    static Stack<String> first_stack = new Stack<String>();
    static Stack<String> second_stack = new Stack<String>();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
        System.out.println("연산번호를 선택하세요.");
        System.out.println("1.pop 2.push 3.exit");

        int num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println(deQueue());
                    break;

                case 2:
                    System.out.println("데이터를 입력하세요.");
                    String data = scan.next();
                    enQueue(data);
                    break;

                default:
                    exit(0);
                    break;
            }
        }
    }

    private static String deQueue(){
        String data;
        
        if(first_stack.isEmpty() && second_stack.isEmpty()){
            data = "큐가 비어있습니다.";
        }else if(second_stack.isEmpty() && !first_stack.isEmpty()){
            while(!first_stack.isEmpty()) {
                second_stack.push(first_stack.pop());
            }
            data = second_stack.pop();
        }else{
            data = second_stack.pop();
        }
        return data;
    }

    private static void enQueue(String data){
        first_stack.push(data);
    }
}
