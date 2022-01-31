import java.util.Scanner;
import java.util.ArrayList;
public class LongestPath 
{
	public static ArrayList<Integer> longestPath(BST.Node root)
	{//recursive method to read the nodes till node is null
		if (root==null)
		{
			//if root is null return the array and stop the recursion
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		//recursive call to traverse right and left paths of the nodes
		ArrayList<Integer> right = longestPath(root.right);
		ArrayList<Integer> left = longestPath(root.left);
		if(right.size() < left.size())
		{
			left.add(root.key);
		}
		else
		{
			right.add(root.key);
		}
	//returning the largest array
		return (left.size() > right.size() ? left :right);
	}
	
	//Method to create Binary tree basis the inputs from user
	public static BST.Node CreatBinaryTree()
	{
		Scanner sc = new Scanner(System.in);
		BST.Node root = null;
		
		System.out.println("Enter the Number of Nodes in Binary Tree?");
		int NodesNumber = sc.nextInt();
		int value;	
		//basis the number of nodes entered this loop will iterate to get user inputs
		for (int i = 0 ; i < NodesNumber ; i++)
		{
			System.out.println("Enter the "+Integer.toString(i+1)+" Node: ");
			value = sc.nextInt();
			if (root == null)
			{
				root = BST.insert(root,value);
			}
			else
			{
				BST.insert(root, value);
			}
		}
		//returning the Binary Tree
	return root;	
	}
}
