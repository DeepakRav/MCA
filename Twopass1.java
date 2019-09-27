//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
class Twopass1
{
	public static void main(String args[]) throws IOException
	{
		int ch;
		String str;
		//File fr=new File("Assemblycode.txt");
	    BufferedReader input=new BufferedReader(new FileReader("Assemblycode.txt"));
		System.out.print("Hello");
		System.out.print((char)10);
		/*while((str=input.readLine())!=null)
		{
			System.out.println(str);
		}*/
		while((str=input.readLine())!=null)
		{
			StringTokenizer st1=new StringTokenizer(str, " ");
			while(st1.hasMoreTokens())
			{
				System.out.println(st1.nextToken());
			}
		}
	}
}