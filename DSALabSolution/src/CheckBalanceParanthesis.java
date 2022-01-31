
public class CheckBalanceParanthesis {
	
	
	static boolean CheckBalance(String s)
	{
		Stack stack = new Stack();
		//run a loop to iterate through all the characters in the string
		for (int i = 0; i < s.length(); i++)
		{
			char x = s.charAt(i);
			//if it is opening bracket we push the bracket to the stack
			if (x == '(' || x == '{' || x=='[')
			{
				stack.push(x);
				continue;
			}
			//else if the bracket is closing we check for each case of closing bracket and check the top of the stack
			if (x==')' || x=='}' || x==']')
			{
				//if stack is empty that means we have a closing bracket from string without any opening bracket in stack
				//hence the string expression is not balanced.
				if (stack.isEmpty())
				{
					return false;
				}
				//else if it is not empty then we check for the matching bracket using check variable
				char check;
				switch (x)
				{
				case ')':
					check = stack.pop();
					if (check =='{' || check =='[')
						return false;
					break;
				case '}':
					check = stack.pop();
					if (check =='(' || check =='[')
						return false;
					break;
				case ']':
					check = stack.pop();
					if (check =='{' || check =='(')
						return false;
					break;
				}
			}
		}
		//if all the conditions are check we return the stack isempty status 
		return stack.isEmpty();	
	}

}
