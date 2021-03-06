package util.vector;

import java.util.Scanner;

public class GradeController {
	public static void main(String[] args) {
		GradeService service = new GradeServiceImpl();
		Grade hong = new Grade("1301","홍길동",30,30,30);
		Grade kim = new Grade("1302","김유신",50,50,50);
		Grade lee = new Grade("1303","이순신",100,100,100);
		//Grade 타입의 인스턴스(객체) hong 이 서비스인터페이스를 구현한 서비스임플 클래스의 input() 메소드에 할당된다
		service.input(hong);
		service.input(kim);
		service.input(lee);
		//지시값을 전달할 스캐너
		Scanner scanner = new Scanner(System.in);
		int input =0 , key = 0;
		// 무한루프 엔진
		while (true) {
			//메뉴판
			System.out.println("1. 성적입력 2. 성적조회(학번) 3. 성적조회(이름) 4. 전체성적 5. 성적순 6. 이름순 0. 종료");
			input = scanner.nextInt();
			//입력값 체크(밸류데이션)			
			key = inputCheck(input,0,6);
			if (input != 0) {
				switch (key) {
				case 1:
					System.out.println("학번 : ");
					String hakbun = scanner.next();
					System.out.println("이름 : ");
					String name =  scanner.next();
					System.out.println("국어 : ");
					int kor =  scanner.nextInt();
					System.out.println("영어 : ");
					int eng =  scanner.nextInt();
					System.out.println("수학 : ");
					int math =  scanner.nextInt();
					Grade grade = new Grade(hakbun, name, kor, eng, math);
					service.input(grade);
					break; //1. 성적입력
				
				case 2:
					System.out.println("학번 : ");
					System.out.println(service.searchGradeByHakbun(scanner.next()));
					break; //2. 성적조회(학번)
				
				case 3:
					System.out.println("이름 : ");
					System.out.println(service.searchGradeByName(scanner.next()));
					break; //3. 성적조회(이름)
			
				case 4:service.printList();
					break; //4. 전체성적
			
				case 5:service.descByTotal();				
					break; //5. 성적순
				
				case 6:service.ascByName();					
					break; //6. 이름순
				
				default: System.out.println("에러발생");	
					break;
				}
			} else {
				System.out.println("시스템 종료");
				break;
			}
		}
	}

	private static int inputCheck(int input, int i, int j) {
		if (input < i || input >j) {
			System.out.println("선택메뉴에서 범위값 외의 수를 입력했습니다");
			return 0; // 시스템종료    리턴타입의 디폴트값을 리턴했기 때문
		} else {
			return input;
		}
	}
}

/*
 *인터페이스구현객체 + 스캐너 + 인풋변수 장착
 *while(true){
 *	if(intut !=0){
 *
 * 	}else{
 * 
 * 	}
 */
