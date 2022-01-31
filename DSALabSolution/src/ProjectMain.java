import java.util.Scanner;
import java.util.ArrayList;

public class ProjectMain {

	public static void main(String[] args) 
	{
		int SelectProject= 0;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Select the Project you want to Run");
			System.out.println("1. Balancing Brackets ");
			System.out.println("2. Print the longest path from the root to the leaf in a binary tree.");
			System.out.println("3. Exit");
			SelectProject = sc.nextInt();
			switch (SelectProject)
			{
			case 1:
				//if the menu item 1 is entered requesting user to input the parenthesis string 
				String s;
				System.out.println("Please Input the parenthesis String?");
				s=sc.next();
				//call the CheckBalance method to check the user input		
				if (CheckBalanceParanthesis.CheckBalance(s))
					//if the returned value is true then the string is balanced
		            System.out.println("Balanced ");
		        else
		    		//if the returned value is false then the string is balanced
		            System.out.println("Not Balanced ");
				break;
			case 2:
				//if the menu item 2 is entered we need to create a BST and then search for the longest path
				BST.Node root = null;
				
				//calling Create Binary tree method to take inputs from user and 
				root = LongestPath.CreatBinaryTree();
				
				//Printing the root of BST basis the 
				System.out.println("Root is " + root.key);
				//Using Array list Data array to store the valued of the various paths in the Binary tree
				ArrayList<Integer> output =  LongestPath.longestPath(root);
				//output will have the largest array with longest path
				int n = output.size();
			   //displaying the size of the array which is the size of path
				System.out.println("Size is " + n);
				
			   //Displaying all the nodes in the longest path.
			    System.out.print(output.get(n - 1));
			    for(int i = n - 2; i >= 0; i--)
			    {
			       System.out.print(" -> " + output.get(i));
			    }
				break;
			case 3:
				System.out.println("Thank you !!!");
				break;
			default:
				break;
			}
			System.out.println("");
		}
		while(SelectProject !=3);
		sc.close();
	}

}
