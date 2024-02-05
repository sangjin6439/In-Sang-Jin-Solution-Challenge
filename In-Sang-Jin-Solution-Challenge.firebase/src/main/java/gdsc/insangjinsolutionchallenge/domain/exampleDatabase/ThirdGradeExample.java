package gdsc.insangjinsolutionchallenge.domain.exampleDatabase;

import gdsc.insangjinsolutionchallenge.domain.example.Example;
import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdGradeExample {

    @Bean
    CommandLineRunner thirdGradeExamples(ExampleRepository exampleRepository) {
        return args -> {
            exampleRepository.save(Example.builder()
                    .title("조건을 만족하는 제곱근의 합")
                    .content("자연수 A와 B에 대해, 다음 조건을 만족하는 A와B의 최소값을 찾고 A+B를 구하여라")
                    .multipleChoice("√A+√B=20")
                    .correct("200")
                    .score(30L)
                    .imgPath("")
                    .grade("3")
                    .category("제곱근과 실수")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("근호 제거하기")
                    .content("다음 수를 근호를 사용하지 않고 나타내시오.")
                    .multipleChoice("√121")
                    .correct("11")
                    .score(10L)
                    .imgPath("")
                    .grade("3")
                    .category("제곱근과 실수")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("다항식의 계수 구하기")
                    .content("다음 식을 전개하였을 때, xy의 계수를 구하시오.")
                    .multipleChoice("(x+y)(2x-y-3)")
                    .correct("1")
                    .score(10L)
                    .imgPath("")
                    .grade("3")
                    .category("다항식의 곱셈과 인수분해")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("곱셈공식")
                    .content("곱셈공식을 이용하여 다음을 계산하시오.")
                    .multipleChoice("99^2")
                    .correct("9801")
                    .score(30L)
                    .imgPath("")
                    .grade("3")
                    .category("다항식의 곱셈과 인수분해")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("이차방정식의 해 구하기")
                    .content("다음 이차방정식의 두 해 A,B를 구하고 A+B를 입력하시오.")
                    .multipleChoice("(x+2)(x-3)=0")
                    .correct("1")
                    .score(20L)
                    .imgPath("")
                    .grade("3")
                    .category("이차방정식")
                    .correctPercentage(0.0)
                    .build());

            exampleRepository.save(Example.builder()
                    .title("이차방정식의 활용")
                    .content("귤 120개를 학생들에게 남김없이 똑같이 나누어 주려고 한다. 한 학생이 받는 귤의 개수는 학생수보다 7만큼 작다고 할 때, 학생 수를 구하시오.")
                    .multipleChoice("(x+2)(x-3)=0")
                    .correct("15")
                    .score(20L)
                    .imgPath("")
                    .grade("3")
                    .category("이차방정식")
                    .correctPercentage(0.0)
                    .build());
        };
    }
}