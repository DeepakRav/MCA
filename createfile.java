import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
class createfile
{
	public static void main(String args[]) throws IOException
	{
		String str = "File handling in JAVA using " + "FileWriter and File Reader";
		
		FileWriter fw=new FileWriter("output.txt", false);
		
		for(int i=0;i<str.length();i++)
		{
			fw.write(str.charAt(i));
		}
		
		System.out.println("Writing successful");
		fw.close();
		int ch;
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
			System.out.print((char)ch);
		}
		fr.close();
	}
}