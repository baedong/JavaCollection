package util.vector;

import java.util.Vector;
/*
 * 프로그램을 코딩하다 보면 자료구조를 다루는데 있어서 CRUD 액션의 반복을 경험하게 됩니다
 * Create : 입력, 생산
 * Read : 출력, 조회
 * Update : 수정 -> 저장된 값을 수정 DB
 * Delete : 삭제 - > 완전삭제 DB , null 값으로 바꾸는 삭제
 */
public class GradeServiceImpl implements GradeService{
	// 필드에 아래 메소드들이 공유할 자료구조를 뭘 쓸지 선택
	// 1. ArrayList 2. Vector 3. Stack 4. HashMap
	// 순서 O, 중복 O
	private Vector<Grade> vec = new Vector<Grade>();
	Grade grade = new Grade(); // 디폴트 생성자가 있어야 에러가 뜨지 않음
	
	
	@Override
	public void input(Grade grade) { //성적표입력
		vec.add(grade);
		
	}

	@Override
	public void printList() { //전체 출력
		System.out.println(vec.toString());

	}

	@Override
	public String searchGradebyHakbun(String hakbun) { //학번 검색
		String msg = "";
		Grade grade = null; // 지변으로 인스턴스 선언
		//List 계열의 클래스 길이는 size() 로 구한다
		for (int i = 0; i < vec.size(); i++) {
			String searchHakbun = vec.elementAt(i).getHakbun();  // 만약 vec가 배열이라면 vec.get(i)
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.elementAt(i).getName();
				int kor = vec.elementAt(i).getKor(); // 객체.메소드.메소드.메소드 이런 패턴은 반드시 return값이 있는 메소드들끼리 연결시에만 가능 이런방식을 메소드 체인이라함
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(searchHakbun,name,kor,eng,math);
				msg = grade.toString();
				break; // 중간이라도 학번이 일치하면 스톱
			} else {
				msg = "조회하는 학번이 없습니다";
			}
		}
		return msg;
	}

	@Override
	public void ascGradeTotal() { //성적 정렬

		
	}

}
