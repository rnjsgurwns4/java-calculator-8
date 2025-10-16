package calculator;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        int result = add(input);
        System.out.println("결과 : " + result);
        
    }


    // 주어진 문자열에 포함된 숫자들의 합을 반환
    public static int add(String text) {
        // 1. 빈 문자열 또는 null 입력 처리
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // 2. 구분자 및 숫자 문자열 분리
        String[] numbers = splitNumbers(text);

        // 3. 숫자 합산 및 유효성 검사
        return sumNumbers(numbers);
    }


    // 입력된 문자열을 구분자를 기준으로 분리하여 숫자 문자열 배열로 반환
    private static String[] splitNumbers(String text) {
        // 커스텀 구분자 "//"와 "\n" 확인
        if (text.startsWith("//") && text.contains("\\n")) {
            int newlineIndex = text.indexOf("\\n");

            String numbersText = text.substring(newlineIndex + 2);

            // 먼저 기본 구분자인 콜론을 쉼표로 통일
            String normalizedText = numbersText.replace(":", ",");

            // "//"와 "\\n" 사이에 커스텀 구분자가 있는지 확인
            if (newlineIndex > 2) {
                // 커스텀 구분자 찾기
                String customDelimiter = text.substring(2, newlineIndex);
                // 그 다음 커스텀 구분자도 쉼표로 통일
                normalizedText = normalizedText.replace(customDelimiter, ",");
            }
            // 쉼표로 스플릿
            return normalizedText.split(",");
        }


        // 기본 구분자(쉼표, 콜론)만 있는 경우, 콜론을 쉼표로 변경 후 분리
        return text.replace(":", ",").split(",");
    }


    //숫자 문자열 배열을 받아 합계를 계산하고 반환 + 에러 처리
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String numberStr : numbers) {
            try {
                int number = Integer.parseInt(numberStr);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력값에 문제가 있습니다.");
            }
        }
        return sum;
    }
}

