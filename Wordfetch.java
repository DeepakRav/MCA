import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
class Wordfetch
{
	public static void main(String args[]) throws IOException
	{
		String str="File";
		int ch, count=0,flag=0,x=0;
		int posi[]=new int[20];
		FileReader fr=null;
		try
		{
			fr=new FileReader("output.txt");
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File Not Found!");
		}
		while((ch=fr.read())!=-1)
		{
			x++;
			if(flag==0)
			{
				if(ch==str.charAt(0))
				{
					flag=1;
				}
			}
			else
			{
				if(flag==1)
				{
					if(ch==str.charAt(1))
					{
						flag=2;
					}
					else
						flag=0;
				}
				else if(flag==2)
				{
					if(ch==str.charAt(2))
					{
						flag=3;
					}
					else
						flag=0;
				}
				else if(flag==3)
				{
					if(ch==str.charAt(3))
					{
						flag=4;
					}
					else
						flag=0;
				}
				else if(flag==4)
				{
					if((char)ch==' ')
					{
						posi[count]=x-4;
						count++;
						flag=0;
					}
					else
						flag=0;
				}
			}
		}
		fr.close();
		if(count>0)
		{
			System.out.println("The word " + str + " occurs " + count + " times in the file output.txt at following positions: ");
			for(int i=0;i<count;i++)
			{
				if(i==count-1)
				{
					System.out.print(posi[i]);
				}
				else
					System.out.print(posi[i] + ", ");
			}
		}
		else
		{
			System.out.println("Word not found");
		}
	}
}