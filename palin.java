import java.util.*;

class palin{
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String msg = sc.nextLine();
		char str[] = msg.toCharArray();
		String hello = "";
		for(int i=0 ; i<msg.length(); i++){
			char tmp = msg.charAt(i);
			for(int j=msg.length()-1;j>i;j--){
				char temp = msg.charAt(j);
				if(tmp == temp){
					hello=hello+tmp;
					//break;
					//continue;
				}
			}
		}
		System.out.println("Palindrome String is "+hello);
	}
}