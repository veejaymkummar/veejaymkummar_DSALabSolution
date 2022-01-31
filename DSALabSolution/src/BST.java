
public class BST 
{
	static class Node 
	{
		int key;
		Node left, right;
	}
	
	static Node newNode(int data) 
	{
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	static Node insert(Node root, int key) 
	{
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;
		while (x != null) 
		{
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else 
			{
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (current_parent == null)
			current_parent = newnode;
		// assign new node node to the left child
		else if (key < current_parent.key)
			current_parent.left = newnode;
		// assign the new node to the right child
		else
			current_parent.right = newnode;
		// return pointer to new node
		return current_parent;
	}
	static Node deleteNode(Node root, int key) 
	{
        if(root == null) return root;
        if(key > root.key)
        { //move right
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.key)
        { //move left
        	root.left = deleteNode(root.left, key);
        }
        else
        { //oh yes, we finally found the target
        	if(root.left == null && root.right == null)
        	{ //hmm, its a leaf node; easy peasy
                root = null;
            }
        	else if(root.right != null)
        	{ // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
                root.key = successor(root); // my worthy successor
                root.right = deleteNode(root.right, root.key);
            }
        	else
        	{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key);
            }
        }
        return root;
	}
	 private static int predecessor(Node root){
	        root = root.left;
	        while(root.right != null){
	            root = root.right;
	        }
	        return root.key;
	    }
	 private static int successor(Node root){
	        root = root.right;
	        while(root.left != null){
	            root = root.left;
	        }
	        return root.key;
	    }
	
	
	static int minValue(Node root) 
	{
		// initially minval = root
		int minval = root.key;
		// find minval
		while (root.left != null) 
		{
			minval = root.left.key;
			root = root.left;
		}
		return minval;
	}
	
	static int maxValue(Node root) 
	{
		// initially maxval = root
		int maxval = root.key;
		// find maxval
		while (root.right != null) 
		{
			maxval = root.right.key;
			root = root.right;
		}
		return maxval;
	}
	
	
	static boolean search(Node root, int key) 
	{
		root = search_Recursive(root, key);
		if (root != null)
			return true;
		else
			return false;
	}
	static Node search_Recursive(Node root, int key) 
	{
		// when root is null or key is present at root
		if (root == null || root.key == key)
			return root;
		// when value is greater than root's key
		if (root.key > key)
			return search_Recursive(root.left, key);
		// when value is less than root's key
		return search_Recursive(root.right, key);
	}
	static void Inorder(Node root) 
	{
		if (root == null)
			return;
		else 
		{
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}
	static void LeftNodes(Node root)
	{
		if (root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.key + " ");
			LeftNodes(root.left);
		}
	}
	static void RightNodes(Node root)
	{
		if (root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.key + " ");
			RightNodes(root.right);
		}
	}
}
