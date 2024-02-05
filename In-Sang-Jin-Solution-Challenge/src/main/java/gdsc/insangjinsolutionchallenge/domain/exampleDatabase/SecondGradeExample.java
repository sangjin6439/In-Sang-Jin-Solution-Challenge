package gdsc.insangjinsolutionchallenge.domain.exampleDatabase;

import gdsc.insangjinsolutionchallenge.domain.example.Example;
import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondGradeExample {

    @Bean
    CommandLineRunner secondGradeExamples(ExampleRepository exampleRepository) {
        return args -> {
            exampleRepository.save(Example.builder()
                    .title("유한소수 만들기")
                    .content("다음 분수가 유한소수가 되도록 하는 가장 작은 자연수 a를 구하시오")
                    .multipleChoice("3/〖7×2^2〗 ×a")
                    .correct("7")
                    .score(10L)
                    .imgPath("")
                    .grade("2")
                    .category("유한소수,무한소수,순환소수")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("유한소수 만들기 2")
                    .content("다음 분수가 유한소수가 되도록 하는 가장 작은 자연수 a를 구하시오")
                    .multipleChoice("8/〖3^2×5^2〗 ×a")
                    .correct("9")
                    .score(10L)
                    .imgPath("")
                    .grade("2")
                    .category("유한소수,무한소수,순환소수")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("다항식 간단히 하기")
                    .content("다음 식을 간단히 하시오")
                    .multipleChoice("3x × 5y")
                    .correct("15xy")
                    .score(10L)
                    .imgPath("")
                    .grade("2")
                    .category("다항식과 다항식")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("다항식 간단히 하기 2")
                    .content("다음 식을 간단히 하시오")
                    .multipleChoice("2a+3b-{5-(4a+9b)")
                    .correct("6a+12b-5")
                    .score(20L)
                    .imgPath("")
                    .grade("2")
                    .category("다항식과 다항식")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("일차부등식의 활용")
                    .content("어떤 자연수의 2배에서 6을 뺀 수는 그 자연수에서 5를 뺀 수의 3배보다 크다고 할 때, 이를 만족하는 자연수 중 가장 큰 수를 구하시오.")
                    .multipleChoice("")
                    .correct("8")
                    .score(30L)
                    .imgPath("")
                    .grade("2")
                    .category("다항식과 다항식")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("이등변 삼각형의 성질")
                    .content("다음 그림에서 △ABC가 이등변삼각형일 때, ∠x의 크기를 구하시오. (숫자만 기입)")
                    .multipleChoice("")
                    .correct("65")
                    .score(10L)
                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/2%ED%95%99%EB%85%84%20%ED%94%BC%ED%83%80%EA%B3%A0%EB%9D%BC%EC%8A%A4%202101%EB%B2%88.png?alt=media&token=38be5cb0-7f70-4612-a728-c09686ee3f9b")
                    .grade("2")
                    .category("삼각형과 사각형, 닮음과 피타고라스 정리")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("직사각형의 성질")
                    .content("그림과 같은 직사각형 ABCD에서 ∠BAC의 크기를 구하시오. (숫자만 기입)")
                    .multipleChoice("")
                    .correct("55")
                    .score(20L)
                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/2%ED%95%99%EB%85%84%20%ED%94%BC%ED%83%80%EA%B3%A0%EB%9D%BC%EC%8A%A4%202102%EB%B2%88.png?alt=media&token=ab25259d-e22a-4911-afc5-84e6b69a9d5e")
                    .grade("2")
                    .category("삼각형과 사각형, 닮음과 피타고라스 정리")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("동전 뒤집기")
                    .content("50원짜리 동전 1개, 100원짜리 동전 1개, 500원짜리 동전 1개를 동시에 던질 때, 모든 경우의 수 A와 모두 뒷면이 나오는 경우의 수 B를 구하고, A+B의 값을 입력하시오.")
                    .multipleChoice("")
                    .correct("9")
                    .score(20L)
                    .imgPath("")
                    .grade("2")
                    .category("확률")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("숫자 카드")
                    .content("5,6,7,8,9의 숫자가 각각 적힌5장의 카드에서 2장을 뽑아 만들 수 있는 두 자리 자연수 중 짝수의 개수를 구하시오.")
                    .multipleChoice("")
                    .correct("9")
                    .score(20L)
                    .imgPath("")
                    .grade("2")
                    .category("확률")
                    .correctPercentage(0.0)
                    .build());
        };
    }
}