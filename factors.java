class factors
{
	public static void main (String args[])
	{
		int a=Integer.parseInt(args[0]);
		int i;
		for(i=1;i<=a;i++)
		{
			if(a%i==0)
			{
				System.out.println(i);
			}
		}
	}
}