//Program to generate first 50 prime numbers
class Prime
{
	public static void main(String args[])
	{
		int i,j,flag,count=0;
		for(i=1;count<50;i++)
		{
			flag=0;
			for(j=i;j>0;j--)
			{
				if(i%j==0)
				{
					flag++;
				}
			}
			if(flag==2)
			{
				System.out.print(i + "\t");
				count++;
			}
		}
		System.out.println();
		i=1;
		j=0;
		count=0;
		while(count<50)
		{
			flag=0;
			j=i;
			while(j>0)
			{
				if(i%j==0)
				{
					flag++;
				}
				j--;
			}
			if(flag==2)
			{
				System.out.print(i + "\t");
				count++;
			}
			i++;
		}
		System.out.println();
		i=1;
		j=0;
		count=0;
		do
		{
			flag=0;
			j=i;
			while(j>0)
			{
				if(i%j==0)
				{
					flag++;
				}
				j--;
			}
			if(flag==2)
			{
				System.out.print(i + "\t");
				count++;
			}
			i++;
		}while(count<50);
	}
}