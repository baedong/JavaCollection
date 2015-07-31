package util.vector;
// 전체에서 특정 글자 바꾸는 단축키
// 컨트롤 a - > 컨트롤 f 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	private List<Grade> vec = new ArrayList<Grade>();
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
	public String searchGradeByHakbun(String hakbun) { //학번 검색
		String msg = "";
		Grade grade = null; // 지변으로 인스턴스 선언
		//List 계열의 클래스 길이는 size() 로 구한다
		for (int i = 0; i < vec.size(); i++) {
			String searchHakbun = vec.get(i).getHakbun();  // 만약 vec가 배열이라면 vec.get(i)
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.get(i).getName();
				int kor = vec.get(i).getKor(); // 객체.메소드.메소드.메소드 이런 패턴은 반드시 return값이 있는 메소드들끼리 연결시에만 가능 이런방식을 메소드 체인이라함
				int eng = vec.get(i).getEng();
				int math = vec.get(i).getMath();
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
	public Vector<Grade> searchGradeByName(String name) { //이름 검색
		Vector<Grade> temp = new Vector<Grade>();
		Grade grade = null;
		for (int i = 0; i < vec.size(); i++) {
			String searchName = vec.get(i).getName();
			if (name.equalsIgnoreCase(searchName)) { // equalsIgnoreCase (대소문자 구별안함) equals ( 대소문자 구별함)
				
				grade = new Grade(vec.get(i).getHakbun(),searchName,
						vec.get(i).getKor(),
						vec.get(i).getEng(),
						vec.get(i).getMath());
				temp.add(grade);
			} else {
				temp.remove(new Grade()); //temp 라는 백터를 완전히 비워서 null 로 리턴
			}
		}
		return temp;
	}
	

	@Override
	public void descByTotal() { // 성적순 정렬
		// Java API 중에서 정렬담당 클래스 Comparator
		// 인터페이스를 구현한 내부(익명) 클래스 (anonymous inner class)
		Comparator<Grade> desc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				/* 삼항연산자
					if(condition){
						--> true 면 statement 실행
					}else{
						--> false 면 statement 실행
					}
					
					(condition) ? 참 : 거짓 ;
				
				int temp = 0;
				if (g1.getTotal()<g2.getTotal()) {
					temp = 1 ;
				} else {
					if (g1.getTotal()==g2.getTotal()) {
						temp = 0 ;
					} else {
						temp = -1 ;
					}
				}return temp;
				*/
				return	(g1.getTotal()<g2.getTotal()) ? 1 :
						(g1.getTotal()==g2.getTotal()) ? 0 : -1 ;
			}
		};
		Collections.sort(vec,desc);		// 정열된값을 돌려주는기능
		System.out.println(vec.toString());
	}

	@Override
	public void ascByName() { // 이름순 정렬
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				//값(value)이 int 타입이 아니고 String 타입의 우선순위 결정방법
				//compareTo() 라는 메소드사용
				return g1.getName().compareTo(g2.getName());	
			}
		};
		Collections.sort(vec,asc);
		System.out.println(vec.toString());		
	}

}
