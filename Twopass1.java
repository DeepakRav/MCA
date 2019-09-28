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
		int ch,countt=0,i,flag=0,countl=0,lc=0,flageq=0,elc=0;
		String str;
		String name[]={"START", "ADD", "SUB", "MULT", "DIV", "MOVER", "MOVEM", "COMP", "BC", "READ", "PRINT", "STOP", "END"};
		String str1="",str2="";
		//File fr=new File("Assemblycode.txt");
	    BufferedReader input=new BufferedReader(new FileReader("Assemblycode.txt"));
		/*while((str=input.readLine())!=null)
		{
			System.out.println(str);
		}*/
		FileWriter fw=new FileWriter("mnemonic.txt");
		FileWriter fw1=new FileWriter("symtab.txt");
		fw1.write("Symbols\tLC\r\n\r\n");
		while((str=input.readLine())!=null)
		{
			countl++;
			if(countl>2)
			{
				lc++;
			}
			StringTokenizer st1=new StringTokenizer(str, " ");
			//System.out.println(str);
			while(st1.hasMoreTokens())
			{
				countt++;
				str1=st1.nextToken();
				if(countt==1)
				{
					for(i=0;i<name.length;i++)
					{
						if(str1.equals(name[i]))
						{
							fw.write(name[i] + "\r\n");
							flag=1;
						}
					}
					if(flag!=1)
					{
						str2=str2 + "\t" + str1;
						fw1.write(str1);
					}
					
				}
				if(countl==1 && countt==2)
				{
					lc=Integer.parseInt(str1);
				}
				if(str1.equals("EQU"))
				{
					flageq=1;
				}
					//System.out.println(str1);
					//System.out.println(countt);
			}
			if(flag!=1)
			{
				if(flageq==1)
				{
					StringTokenizer st2=new StringTokenizer(str2, "\t");
					while(st2.hasMoreTokens())
					{
						//System.out.println(st2.nextToken());
						if(st2.nextToken().equals(str1))
						{
							elc=Integer.parseInt(st2.nextToken());
						}
					}
					str2=str2 + "\t" + elc;
					fw1.write("\t" + elc + "\r\n");
				}
				else
				{
					str2=str2 + "\t" + lc;
					fw1.write("\t" + lc + "\r\n");
				}
			}
			countt=0;
			flag=0;
			flageq=0;
		}
		fw.close();
		fw1.close();
	}
}