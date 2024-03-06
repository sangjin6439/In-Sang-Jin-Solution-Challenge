//package gdsc.insangjinsolutionchallenge.domain.exampleDatabase;
//
//import gdsc.insangjinsolutionchallenge.domain.example.Example;
//import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ThirdGradeExample {
//
//    @Bean
//    CommandLineRunner thirdGradeExamples(ExampleRepository exampleRepository) {
//        return args -> {
//            exampleRepository.save(Example.builder()
//                    .title("조건을 만족하는 제곱근의 합")
//                    .content("자연수 A와 B에 대해, 다음 조건을 만족하는 A와B의 최소값을 찾고 A+B를 구하여라")
//                    .multipleChoice("√A+√B=20")
//                    .correct("200")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("제곱근과 실수")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("근호 제거하기")
//                    .content("다음 수를 근호를 사용하지 않고 나타내시오.")
//                    .multipleChoice("√121")
//                    .correct("11")
//                    .score(10L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("제곱근과 실수")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("다항식의 계수 구하기")
//                    .content("다음 식을 전개하였을 때, xy의 계수를 구하시오.")
//                    .multipleChoice("(x+y)(2x-y-3)")
//                    .correct("1")
//                    .score(10L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("다항식의 곱셈과 인수분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("곱셈공식")
//                    .content("곱셈공식을 이용하여 다음을 계산하시오.")
//                    .multipleChoice("99^2")
//                    .correct("9801")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("다항식의 곱셈과 인수분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("이차방정식의 해 구하기")
//                    .content("다음 이차방정식의 두 해 A,B를 구하고 A+B를 입력하시오.")
//                    .multipleChoice("(x+2)(x-3)=0")
//                    .correct("1")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("이차방정식")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("이차방정식의 활용")
//                    .content("귤 120개를 학생들에게 남김없이 똑같이 나누어 주려고 한다. 한 학생이 받는 귤의 개수는 학생수보다 7만큼 작다고 할 때, 학생 수를 구하시오.")
//                    .multipleChoice("(x+2)(x-3)=0")
//                    .correct("15")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("이차방정식")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("삼각비와 삼각형의 넓이")
//                    .content("다음 그림과 같은 △ABC의 넓이를 구하시오.")
//                    .multipleChoice("")
//                    .correct("14")
//                    .score(20L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/3%ED%95%99%EB%85%84%20%EC%82%BC%EA%B0%81%EB%B9%84%203101%EB%B2%88.png?alt=media&token=5702cbb9-ebba-4bed-9c28-d11d4e215cbe")
//                    .grade("3")
//                    .category("삼각비")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("삼각비와 삼각형의 변의 길이")
//                    .content("그림과 같은 직각삼각형 ABC에서 sinC=4/5 일때, (AC) ̅의 길이를 구하시오.")
//                    .multipleChoice("")
//                    .correct("10")
//                    .score(40L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/3%ED%95%99%EB%85%84%20%EC%82%BC%EA%B0%81%EB%B9%84%203102%EB%B2%88.png?alt=media&token=d89e673b-500a-4fa3-9459-18b91ee64d65")
//                    .grade("3")
//                    .category("삼각비")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("원주각의 성질")
//                    .content("다음 그림과 같은 원 O에서 ∠x의 값을 구하시오.")
//                    .multipleChoice("")
//                    .correct("60")
//                    .score(30L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/3%ED%95%99%EB%85%84%20%EC%9B%90%EC%9D%98%20%EC%84%B1%EC%A7%88%203111%EB%B2%88.png?alt=media&token=8c0ed58c-2c49-4d37-8e13-26ac1fab8266")
//                    .grade("3")
//                    .category("원의 성질")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("접선과 현이 이루는 각")
//                    .content("다음 그림에서 (AT) ⃡는 원의 접선이고, 점 A는 접점일 때, ∠x의 값을 구하시오.")
//                    .multipleChoice("")
//                    .correct("49")
//                    .score(40L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/3%ED%95%99%EB%85%84%20%EC%9B%90%EC%9D%98%20%EC%84%B1%EC%A7%88%203112%EB%B2%88.png?alt=media&token=7f01dcf4-e3af-4051-bb66-83746b3e9091")
//                    .grade("3")
//                    .category("원의 성질")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("평균 구하기")
//                    .content("다음 자료의 평균을 구하시오.")
//                    .multipleChoice("2, 4, 8, 9, 7, 6")
//                    .correct("6")
//                    .score(10L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("통계")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("상관 관계")
//                    .content("다음 중 두 변량 사이의 상관관계가 나머지 넷과 다른 하나는?")
//                    .multipleChoice("① 바람의 세기와 체감 온도\n" +
//                            "② 자동차의 속력과 제동 거리\n" +
//                            "③ 인구 수와 교통량\n" +
//                            "④ 키와 몸무게\n" +
//                            "⑤ 운동량과 칼로리 소모량\n")
//                    .correct("1")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("3")
//                    .category("통계")
//                    .correctPercentage(0.0)
//                    .build());
//        };
//
//    }
//}