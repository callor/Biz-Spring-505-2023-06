package com.callor.hello.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class BCryptMainV2 {
	
	public static void main(String[] args) {
		// 컴퓨터 운영체제에 등록된 "환경변수"를 추출하는 코드
		Map<String, String> envList = System.getenv();
		String saltKey = envList.get("callor.com");
		
		// 암호문을 만드는 도구
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		
		// MD5 와 DES 방식으로 암호화를 하겠다.
//		pbe.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
		pbe.setPassword(saltKey);
		System.out.println(pbe.toString());
		
		String savePath = "./src/main/webapp/WEB-INF/spring/properties/db_info.properties";
		System.out.printf("SALT Password : %s\n",saltKey);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("DB Username >> ");
		String username = scan.nextLine();
		
		System.out.print("DB Password >> ");
		String password = scan.nextLine();
		
		String encUsername = pbe.encrypt(username);
		String encPassword = pbe.encrypt(password);
		
		String saveUsername = String.format("db.username=ENC(%s)", encUsername);
		String savePassword= String.format("db.password=ENC(%s)", encPassword);
		
		try {
			PrintWriter out = new PrintWriter(savePath);
			out.println(saveUsername);
			out.println(savePassword);
			out.flush();
			out.close();
			System.out.println("저장완료 !!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
