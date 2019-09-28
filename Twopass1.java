//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
class Twopass1
{
	public static void main(String args[]) throws IOException
	{
		int ch,count=0,i,flag=0;
		String str;
		String name[]={"START", "READ", "MOVER", "MOVEM"};
		String str1;
		//File fr=new File("Assemblycode.txt");
	    BufferedReader input=new BufferedReader(new FileReader("Assemblycode.txt"));
		/*while((str=input.readLine())!=null)
		{
			System.out.println(str);
		}*/
		FileWriter fw=new FileWriter("mnemonic.txt");
		FileWriter fw1=new FileWriter("symtab.txt");
		while((str=input.readLine())!=null)
		{
			StringTokenizer st1=new StringTokenizer(str, " ");
			System.out.println(str);
			while(st1.hasMoreTokens())
			{
				count++;
				str1=st1.nextToken();
				if(count==1)
				{
					for(i=0;i<name.length;i++)
					{
						if(str1.equals(name[i]))
						{
							fw.write(name[i] + " ");
							flag=1;
							System.out.println("Trial!"+ name[i]);
						}
					}
					System.out.println(flag);
					if(flag!=1)
					{
						fw1.write(str1);
						System.out.println(str1+flag);
					}
					
				}
					System.out.println(str1);
					System.out.println(count);
			}
			count=0;
			flag=0;
		}
		fw.close();
		fw1.close();
	}
}