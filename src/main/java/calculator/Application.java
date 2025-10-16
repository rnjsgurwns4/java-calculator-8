package calculator;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 요구사항에 따라 예외 발생 시 애플리케이션이 종료
            System.err.println("에러가 발생했습니다: " + e.getMessage());
        }
    }
}

