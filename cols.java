class cols
{
	public static void main (String args[])
	{
		int i;
		for(i=1;i<=100;i++)
		{
			System.out.print(i + "\t");
			if(i%5==0)
			{
				System.out.println();
			}
		}
	}
}