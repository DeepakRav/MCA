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
		int ch,countt=0,i,flag=0,countl=0,lc=0,flageq=0,elc=0,flaglt=0,countp=0,flagend=0,endlit=0;
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
		FileWriter fw2=new FileWriter("littab.txt");
		FileWriter fw3=new FileWriter("pooltab.txt");
		fw1.write("Symbols\tLC\r\n\r\n");
		fw2.write("Literals\tLC\r\n\r\n");
		fw3.write("Literal No.\r\n\r\n");
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
				if(flagend!=1)
				{
					if(countt==1)
					{		
						if(str1.equals("END"))
						{
							flagend=1;
							lc--;
						}
						if(str1.equals("LTORG"))
						{
							flaglt=1;
							lc--;
							if(countp==0)
							{
								countp++;
							}
							fw3.write("#" + countp + "\r\n");
							continue;
						}
						for(i=0;i<name.length;i++)
						{
							if(str1.equals(name[i]))
							{
								fw.write(name[i] + "\r\n");
								flag=1;
							}
						}
						if(flaglt==1)
						{
							if(str1.substring(0,2).equals("='"))
							{
								fw2.write(str1 + "\t\t" + lc + "\r\n");
								countp++;
							}
							else
							{
								flaglt=0;
							}
							flag=1;
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
				else
				{
					if(str1.substring(0,2).equals("='"))
					{
						fw2.write(str1 + "\t\t" + lc + "\r\n");
						endlit++;
					}
				}
			}
			if(flag!=1 && flaglt!=1 && flagend!=1)
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
					lc--;
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
		if(endlit>0)
		{
			fw3.write("#" + countp + "\r\n");
		}
		fw.close();
		fw1.close();
		fw2.close();
		fw3.close();
	}
}
