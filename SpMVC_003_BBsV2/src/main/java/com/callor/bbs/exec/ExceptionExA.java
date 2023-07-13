package com.callor.bbs.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExA {

	/*
	 *  throws Exception
	 *  
	 *  현재 method 가 실행되는 과정에서 Exception 가능성이 있는
	 *  코드가 있다. 이럴때는 try...catch 를 사용하여 Exception 처리를
	 *  해 주어야 한다
	 *  
	 *  코드내에서 try...catch 를 사용하여 Exception 처리를 하다보면
	 *  상당히 보기 불편한 코드 모양이 만들어질수 있다
	 *  
	 *  이럴때 현재 method 에서는 Exception 처리를 상위 호출자에게
	 *  미룰수 있다.
	 *  
	 *  현재 코드 구조를 보면 main() method 에서 fileEx() method를
	 *  호출하는 구조적 분리가 되어 있다.
	 *  이럴때 fileEx() 에서 발생하는 Exception 을 직접 try..catch 로
	 *  처리 하지 않고, main() method 에게 미루는 코드를 작성할수 있다
	 *  
	 *  이때 선언하는 것이 throws 키워드 이다
	 *  
	 *  Exception 처리
	 *  	코드가 진행되는 과정에서 어떠한 이유로 Exception 이 발생하면
	 *  	코드의 진행이 중단되고 사용자는 혼란을 맞이하게 된다
	 *  	개발자는 사용자의 혼란을 방지하기 위하여
	 *  	코드가 진행되다가 Exception 이 발생할수 있는 곳에서
	 *  	try...catch 를 사용하여 적절한 조치를 취하고
	 *  	사용자에게 안내를 하고
	 *  	코드가 중단되는 것을 막을 의무가 있다
	 *  
	 */
	private static void fileEx() throws FileNotFoundException {

		String fileName = "score.txt";
		FileInputStream is = null;
		Scanner scan = null;

		is = new FileInputStream(fileName);
		scan = new Scanner(is);
		
		String strNum = scan.nextLine();
		int intNum = 0;
		try {
			intNum = Integer.valueOf(strNum);
		} catch (Exception e) {
			System.out.println("숫자로만 입력하세요");
		}
	}

	public static void main(String[] args) {
		try {
			fileEx();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
