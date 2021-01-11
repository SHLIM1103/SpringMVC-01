package com.example.demo.cmm.utl;

import static com.example.demo.cmm.utl.Util.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.Path;
import com.example.demo.sym.service.Manager;
import com.example.demo.sym.service.Teacher;
import com.example.demo.uss.service.Student;

@Service("dummy")
public class DummyGenerator {
	// 1970 ~ 2000년 사이의 랜덤한 연도수 뽑기 
	public String makeYear(int t, int u) {
		BiFunction<Integer, Integer, Integer> f = (a, b) -> (int)(Math.random() * (b - a)) + a;
		return String.valueOf(f.apply(t, u));
	}
	
	// 1 ~ 12월 사이의 랜덤한 월 뽑기 
	public String makeMonth() {
		Supplier<Integer> s = () -> (int)(Math.random() * 13) + 1;
		return String.valueOf(s.get());
	}
	
	// 1 ~ 31일 사이의 랜덤한 일자 뽑기 / 단, 2월은 28, 29일(윤년) 
	public String makeBirthday() {
		int year = random.apply(1970, 2000);
		int month = random.apply(1, 13);
		int date = 0;
		
		switch(month) {
		case 2: date = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? random.apply(1, 30) : random.apply(1, 29) ; break;
		case 4: case  6: case  9: case  11: date = random.apply(1, 31);	break;
		default: date = random.apply(1, 32); break;
		}
		return year+"-"+month+"-"+date;
	}
	
	public String makeRegdate() {
			int year = random.apply(2019, 2020);
			int month = random.apply(1, 13);
			int date = 0;
			
			switch(month) {
			case 2: date = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? random.apply(1, 30) : random.apply(1, 29) ; break;
			case 4: case  6: case  9: case  11: date = random.apply(1, 31);	break;
			default: date = random.apply(1, 32); break;
			}
			return year+"-"+month+"-"+date;
	}
	
	// 랜덤으로 성별 생성하기 / "F" - female "M" - male
	public String makeGender() {
		List<String> arr = Arrays.asList("F", "M");
		Collections.shuffle(arr);
		return arr.get(0);
	}
	
	// 랜덤으로 사용자 ID 생성하기 	 
	public String makeUserId() {
		List<String> ls = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split(""));
		Collections.shuffle(ls);
		return ls.get(0) + ls.get(1) + ls.get(2) + ls.get(3);
	}
	
	// 랜덤으로 전화번호 생성하기
	public String makeNumber() {
		return "010-" + random.apply(1000, 10000) + "-" + random.apply(1000, 10000);
	}
	
	// 랜덤으로 이름 생성하기
	public String makeName() {
		List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황",
		        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
		        "우", "구", "신", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양", "용",
		        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
		        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "안");
	    List<String> name2 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누",
		    	"다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바",
		        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
		        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
		        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
		        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
		        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
		        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
		        "열", "웅", "운", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
		        "흔", "악", "람", "현", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련", "박");
	    List<String> name3 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누",
	    		"다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바",
	    		"백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	    		"숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	    		"유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	    		"중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	    		"혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
	    		"솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
	    		"열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
	    		"흔", "운", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련", "박");
		
	    Collections.shuffle(fname);
	    Collections.shuffle(name2);
	    Collections.shuffle(name3);
	    String[] a = name2.stream()
				.flatMap(i -> name3.stream().map(j -> new String[] {i, j}))
				.collect(Collectors.toList())
				.get(0);
	    return fname.get(0)+a[0]+a[1] ;
	}
	public String makeSubject() {
		List<String> ls = Arrays.asList("Java", "Spring", "jQuery", "eGovFramework", "Python");
		Collections.shuffle(ls);
		return ls.get(0);
	}
	
	public String makeEmail() {
		List<String> ls = Arrays.asList("@gmail.com", "@naver.com", "@nate.com", "@hanmail.net");
		Collections.shuffle(ls);
		return makeUserId() + ls.get(0);
	}
	
	public Student makeStudent() {
		return new Student(0,
						   makeUserId(), 
						   "1", 
						   makeName(), 
						   makeBirthday(), 
						   makeGender(),
						   makeRegdate(),
						   Path.DEFAULT_PROFILE.toString(),
						   makeSubject());
	}
	
	public Manager makeManager() {
		return new Manager("", 
							makeEmail(), 
							"1", 
							makeName(), 
							Path.DEFAULT_PROFILE.toString());
	}
	
	public Teacher makeTeacher() {
		return new Teacher("", 
							makeName(), 
							"1", 
							makeSubject(), 
							Path.DEFAULT_PROFILE.toString());
	}
	
}