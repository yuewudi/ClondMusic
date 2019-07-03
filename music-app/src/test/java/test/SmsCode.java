package test;

import java.util.Random;

public class SmsCode {

	
	public static void main(String[] args) {
		String str = "0123456789";
		String smsCode = "";
		Random r = new Random();
		for (int i = 1; i <= 4; i++) {
			int index = r.nextInt(str.length()); // 随机获取字符串的某个字符的下标
			char ch = str.charAt(index);
			System.out.println(ch);
			smsCode=smsCode+(ch+"");
		}
		System.out.println(smsCode);
	}
}
