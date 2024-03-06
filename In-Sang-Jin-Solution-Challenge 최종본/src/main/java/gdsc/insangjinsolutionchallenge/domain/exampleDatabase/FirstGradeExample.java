//package gdsc.insangjinsolutionchallenge.domain.exampleDatabase;
//
//import gdsc.insangjinsolutionchallenge.domain.example.Example;
//import gdsc.insangjinsolutionchallenge.domain.example.ExampleRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FirstGradeExample {
//
//    @Bean
//    CommandLineRunner firstGradeExamples(ExampleRepository exampleRepository) {
//        return args -> {
//            exampleRepository.save(Example.builder()
//                    .title("소수와 소인수")
//                    .content("20 이상이고 30 이하인 자연수 중에서 소수가 a개일 때, 다음 중 소인수가 a개인 것은?")
//                    .multipleChoice("①30 " + "②60 " + "③72 " + "④84 " + "⑤121  ")
//                    .correct("3")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("소인수 분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("소인수 분해")
//                    .content("다음 조건을 모두 만족시키는 자연수를 구하시오")
//                    .multipleChoice("가) 35보다 크고 40보다 작다.\n"
//                            + "(나) 2개의 소인수를 가지며, 두 소인수의 함은 5이다.")
//                    .correct("36")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("소인수 분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("서로소")
//                    .content("다음 중 옳은 것은?")
//                    .multipleChoice("① 서로소인 두 수는 모두 소수이다.\n" +
//                            "② 서로 다른 두 소수는 항상 서로소이다.\n" +
//                            "③ 서로 다른 두 홀수는 항상 서로소이다.\n" +
//                            "④ 모든 자연수와 서로소인 수는 없다.\n" +
//                            "⑤ 10 이하의 자연수 중에서 6과 서로소인 자연수는 4개이다.")
//                    .correct("36")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("소인수 분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("자연수 나누기")
//                    .content("어떤 자연수로 38, 56, 74를 나누면 항상 2가 남는다. 이러 한 자연수 중에서 가장 큰 수를 구하시오.")
//                    .multipleChoice("")
//                    .correct("18")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("소인수 분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("일정한 간격으로 나무 심기")
//                    .content("가로, 세로의 길이가 각각 120m, 90m인 직사각형 모양의 땅의 둘레에 일정한 간격으로 나무를 심으려고 한다. 나 무 사이의 간격이 최대가 되도록 할 때, 필요한 나무는 몇 그루인가? (단, 네 모퉁이에 반드시 나무를 심는다.)")
//                    .multipleChoice("① 12그루\n" +
//                            "② 18그루\n" +
//                            "③ 14그루\n" +
//                            "④ 15그루\n" +
//                            "⑤ 20그루")
//                    .correct("4")
//                    .score(40L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("소인수 분해")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("다항식과 일차식")
//                    .content("다항식 3x2-3x-1에 대한 다음 설명 중 옳은 것은?")
//                    .multipleChoice("① 다항식의 차수는 3이다.\n" +
//                            "② 항은 모두 2개이다.\n" +
//                            "③ 상수항은 - 1이다.\n" +
//                            "④ 2의 계수는 3이다.\n" +
//                            "⑤ x에 대한 일차식이다.")
//                    .correct("3")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("문자와 식")
//                    .correctPercentage(0.0)
//                    .build());
//            //답이 두개인 문제 제출시 애매함
//            exampleRepository.save(Example.builder()
//                    .title("일차방정식의 뜻")
//                    .content("다음 중 20에 대한 일차방정식을 모두 고르면? (정답 2개)")
//                    .multipleChoice("1. x2=5x-6\n" +
//                            "2. x+2x=x(x-2)+3\n" +
//                            "3. 3(x-2)=3x-6\n" +
//                            "4. x=5\n" +
//                            "5. x(x-1)+2=2x+1")
//                    .correct("2"+"4")
//                    .score(30L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("문자와 식")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("오각기둥")
//                    .content("그림과 같은 오각기둥에서 면의 개수를 a, 교점의 개수를 b, 교선의 개수를 c라 할 떄, a-b+c의 값을 구하시오.")
//                    .multipleChoice("")
//                    .correct("12")
//                    .score(30L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/1%ED%95%99%EB%85%84%20%EB%8F%84%ED%98%95%EC%9D%98%20%EA%B8%B0%EC%B4%88%201101%EB%B2%88.png?alt=media&token=759733f3-42bf-4f9e-97f2-df39d24c011b")
//                    .grade("1")
//                    .category("도형의 기초")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("직선의 길이")
//                    .content("그림과 같이 네 점 A, B, C, D가 한 직선 위에 있을 때, 다음 중 옳지 않은 것은?")
//                    .multipleChoice("①(AB) ⃡=(CD) ⃡\n" +
//                            "②(AB) ⃗=(AC) ⃗\n" +
//                            "③(CB) ⃗=(CD) ⃗\n" +
//                            "④(BD) ̅=(DB) ̅\n" +
//                            "⑤(AB) ⃡=(BA) ⃡")
//                    .correct("3")
//                    .score(20L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/1%ED%95%99%EB%85%84%20%EB%8F%84%ED%98%95%EC%9D%98%20%EA%B8%B0%EC%B4%88%201102%EB%B2%88.png?alt=media&token=db34e02d-3388-4300-b3d5-40d51b14caef")
//                    .grade("1")
//                    .category("도형의 기초")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("삼각형의 내각과 외각")
//                    .content("다음 그림에서 ∠x의 크기를 구하시오. (숫자만 기입)")
//                    .multipleChoice("")
//                    .correct("60")
//                    .score(40L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/1%ED%95%99%EB%85%84%20%EB%8F%84%ED%98%95%EC%9D%98%20%EC%84%B1%EC%A7%88%201121%EB%B2%88.png?alt=media&token=ec6fc604-6e89-4082-8bdb-c38bb189d57b")
//                    .grade("1")
//                    .category("도형의 성질")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("원의 각과 호")
//                    .content("그림과 같은 원 O에서 ■(⌢@AB):■(⌢@BC):■(⌢@CA)=2:3:4일 때, ∠AOB의 크기를 구하시오")
//                    .multipleChoice("")
//                    .correct("80")
//                    .score(40L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/1%ED%95%99%EB%85%84%20%EB%8F%84%ED%98%95%EC%9D%98%20%EC%84%B1%EC%A7%88%201122%EB%B2%88.png?alt=media&token=63ad8ccc-fb64-42af-a92e-8cb60d492672")
//                    .grade("1")
//                    .category("도형의 성질")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("도수분포표")
//                    .content("다음은 어느 마라톤 대회에서 10km 코스 부문에 참가한 40명의 완주 기록을 조사하여 나타낸 도수분포표이다. 기록이 49분 이상인 참가자 수를 구하시오.")
//                    .multipleChoice("")
//                    .correct("22")
//                    .score(10L)
//                    .imgPath("https://firebasestorage.googleapis.com/v0/b/lighthouse-7010a.appspot.com/o/1%ED%95%99%EB%85%84%20%ED%86%B5%EA%B3%84%201131%EB%B2%88.png?alt=media&token=b2f62ca2-8152-4fe6-a2bb-98160f4cb6c7")
//                    .grade("1")
//                    .category("통계")
//                    .correctPercentage(0.0)
//                    .build());
//
//            exampleRepository.save(Example.builder()
//                    .title("상대도수")
//                    .content("해리의 반과 제리의 반의 전체 학생 수의 비가 3:2이고, 어떤 계급에 속하는 학생 수의 비가 4:5일 때, 이 계급의 상대도수의 비를 가장 간단한 정수 A:B로 만들어 A+B를 구하시오.")
//                    .multipleChoice("")
//                    .correct("23")
//                    .score(20L)
//                    .imgPath("")
//                    .grade("1")
//                    .category("통계")
//                    .correctPercentage(0.0)
//                    .build());
//        };
//
//    }
//}
