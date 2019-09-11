class bell
{
	public static void main (String args[])
	{
		int a=Integer.parseInt(args[0]);
		while(a>=0)
		{
			if(a==0)
			{
				System.out.println("\u0007");
			}
			a--;
		}
	}
}