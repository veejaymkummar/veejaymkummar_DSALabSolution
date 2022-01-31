
public class Stack 
{
	static final int StackSize = 1000;
	int StackPointer;
	char stack[]= new char[StackSize];
	
	Stack()
	{
		StackPointer = -1;
	}
	
	boolean push(char value)
	{
		if (StackPointer >= StackSize -1)
		{
			System.out.println("Stack Overflow");
			return false;
		}
		else
		{
			stack[++StackPointer]= value;
			
			return true;
		}
	}
	char pop()
	{
		if (StackPointer < 0)
		{
		
			System.out.println("Stack Underflow");
			return ' ';
		}
		else
		{
			char x = stack[StackPointer--];
			return x;
		}
	}
	boolean isEmpty()
	{
		if (StackPointer == -1)
			return true;
		else
			return false;
			
	}
	void printstack()
	{
		for (int i = StackPointer; i > -1; i--)
		{
			System.out.print(stack[i] + " ");
		}
	}
}
