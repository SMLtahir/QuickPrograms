package trees;

public class BinarySearchTree {

	Node root;
	
	public static void main(String[] args)	{
		
		BinarySearchTree theTree = new BinarySearchTree();
		
		theTree.addNode(50, "50");
		theTree.addNode(40, "40");
		theTree.addNode(45, "45");
		theTree.addNode(65, "65");
		theTree.addNode(50, "50");
		theTree.addNode(20, "20");
		
		theTree.inorderTraverseTree(theTree.root);
		theTree.findNode(20);
	}
	
	public void addNode(int key, String name)	{
		
		Node newNode = new Node(key, name);
		
		if(root == null)	{
			root = newNode;
		}
		else	{
			Node focusNode = root;
			Node parent;
			
			while(true)	{
				parent = focusNode;
				
				if(key < focusNode.key)	{
					focusNode = focusNode.leftChild;
					
					if(focusNode == null)	{
						parent.leftChild = newNode;
						return;
					}
				}
				else	{
					focusNode = focusNode.rightChild;
					
					if(focusNode == null)	{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		
	}
	
	public void inorderTraverseTree(Node focusNode)	{
		
		if(focusNode != null)	{
			inorderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inorderTraverseTree(focusNode.rightChild);
		}
		
	}
	
	public void preorderTraverseTree(Node focusNode)	{
		
		if(focusNode != null)	{
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
		
	}
	
	public void postorderTraverseTree(Node focusNode)	{
		
		if(focusNode != null)	{
			postorderTraverseTree(focusNode.leftChild);
			postorderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
		
	}
	
	public Node findNode(int key)	{
		Node focusNode = this.root;
		
		while(focusNode != null)	{
			if(focusNode.key == key)	{
				System.out.println("Node found: "+ focusNode);
				return focusNode;
			}
			else if(key < focusNode.key)	{ focusNode = focusNode.leftChild;}
			else	{focusNode = focusNode.rightChild;}
		}
		
		System.out.println("There is no node with this key value in the tree.");
		return null;
	}
	
	public boolean removeNode(int key)	{
		
		Node focusNode = this.root;
		Node parent = this.root;
		
		boolean isLeftChild = false;
		
		while(focusNode.key != key)	{
			
			parent = focusNode;
			
			if(key < focusNode.key)	{
				isLeftChild = true;
				focusNode = focusNode.leftChild;
			}
			else	{
				isLeftChild = false;
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null)	{
				System.out.println("Node was not found!");
				return false;
			}
		}
		
		//Leaf node
		if(focusNode.leftChild == null && focusNode.rightChild == null)	{
			if(focusNode == root)	{ root = null;}
			else if(isLeftChild)	{ parent.leftChild = null;}
			else	{ parent.rightChild = null;}
				
		}
		//If focus node has no right child
		else if(focusNode.rightChild == null)	{
			if(focusNode == root)	{ root = focusNode.leftChild;}
			else if(isLeftChild)	{parent.leftChild = focusNode.leftChild;}
			else	{parent.rightChild = focusNode.leftChild;}	
		}
		//If focus node has no left child
		else if(focusNode.leftChild == null)	{
			if(focusNode == root)	{ root = focusNode.rightChild;}
			else if(isLeftChild)	{parent.leftChild = focusNode.rightChild;}
			else	{parent.rightChild = focusNode.rightChild;}
		}
		
		//Most general case when the focus node has both children
		else	{
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root)	{ root = replacement;}
			else if(isLeftChild)	{parent.leftChild = replacement;}
			else	{parent.rightChild = replacement;}
			
			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.leftChild;
		
		while(focusNode != null)	{
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild)	{
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		
		return replacement;
	}
	
}

class Node	{
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	public Node(int key, String name)	{
		this.key = key;
		this.name = name;
	}
	
	public String toString()	{
		return name+ " has a key "+ key;
	}
}