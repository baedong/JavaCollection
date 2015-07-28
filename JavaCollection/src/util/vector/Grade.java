package util.vector;

public class Grade {
	private int kor,eng,math;
	private String hakbun, name;
	
	public Grade() {} // 아래처럼 파라미터가 있는 생성자를 만들면 디폴트를 별도로 추가해 줘야함

	public Grade(String hakbun,String name,int kor, int eng, int math) {
		this.hakbun=hakbun;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}

	public int getTotal(){
		int total = 0;
		total = this.kor+this.eng+this.math;
		return total;
	}	
	
	public int getTotal(int kor,int eng,int math){
		int total = 0;
		total = kor+eng+math;
		return total;
	}	
	
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public String getHakbun() {
		return hakbun;
	}

	public String getName() {
		return name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "성적표 [이름 : "+name+", 학번 : "+hakbun+"]\n"
				+ "국어 : "+kor+" , 영어 : "+eng+" , 수학 : "+math+"\n"
				+ "총합 : "+getTotal(kor,eng,math)+"\n";
	}
}
