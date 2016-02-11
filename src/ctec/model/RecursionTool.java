package ctec.model;

public class RecursionTool 
{

	public double fibonacciNumber(double position)
	{
		//bounds check
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		//base case
		if(position == 0 || position == 1)
		{
			return 1.0;
		}
		else //recursive case
		{
			return fibonacciNumber(position - 1) + fibonacciNumber(position - 2);
		}
	}
	public double factorialNumber(double position)
	{
		if (position < 0)
		{
			return Integer.MIN_VALUE;
		}
		if (position == 0)
		{
			return 1;
		}
		else
		{
			return position * factorialNumber(position - 1);
		}
	}
}
