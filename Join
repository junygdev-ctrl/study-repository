import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Join{
    List<String> list = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    void add(){
        while(true) {
            System.out.print("추가할 닉네임을 입력하시오 : ");
            String nickName = sc.nextLine();
            if (list.contains(nickName)) {
                System.out.println("이미 사용 중인 닉네임입니다.");
            }
            else {
                list.add(nickName);
                System.out.println("\"" + nickName + "\"이 추가되었습니다.");
                break;
            }
        }
    }
    void remove(){
        while(true) {
            System.out.print("삭제할 닉네임을 입력하시오 : ");
            String nickName = sc.nextLine();
            if (list.contains(nickName)) {
                list.remove(nickName);
                System.out.println("\"" + nickName + "\"이 제거되었습니다.");
                break;
            }
            else {
                System.out.println("존재하지 않는 닉네임입니다.");
            }
        }
    }
    void printList(){
        System.out.print(list);
    }
}
public class Main{
    public static void main(String[] args){
        Join jn = new Join();
        jn.add();        // 첫번째 닉네임 추가
        jn.add();        // 두번째 닉네임 추가
        jn.remove();     // 닉네임 삭제
        jn.printList();  // 현재 닉네임 목록 출력
    }
}
