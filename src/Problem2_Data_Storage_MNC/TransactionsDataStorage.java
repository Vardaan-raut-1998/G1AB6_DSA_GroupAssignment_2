package Problem2_Data_Storage_MNC;

public class TransactionsDataStorage {

	public static Node root = null;
	static Node prevNode = null;
	static Node headNode = null;

	// Function to flatten BST into right skewed tree
	static void makeRightSkewed(Node root) {
		// Base condition
		if (root == null)
			return;

		// Make left subtree of parent -skewed
		makeRightSkewed(root.left);

		// To define new root of skewed tree
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} 
		 else {
			   prevNode.right = root;
			   root.left = null;
			   prevNode = root;
		       }
		
		// similarly recurse for right subtree-skewed
		makeRightSkewed(root.right);
	}

	// function to create BST
	static Node createBST(Node node, int key) {
		if (node == null)
			return (new Node(key));

		if (key < node.key)
			node.left = createBST(node.left, key);
		else if (key > node.key)
			node.right = createBST(node.right, key);

		else
			System.out.println("No Duplicate allowed this node is not going to add in BST");

		return node;
	}

	// As instructed there is no left node
	// Traversal towards right node of BST results ascending order of all data transactions:
	void traverseRightSkewed(Node root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		TransactionsDataStorage o = new TransactionsDataStorage();

		// Hard coded input of transactions as BST:
		root = createBST(root, 50);
		root = createBST(root, 30);
		root = createBST(root, 60);
		root = createBST(root, 10);
		root = createBST(root, 55);

		// Passing root node for operation -only right skew nodes present
		makeRightSkewed(root);

	//Traversal of transactions in Ascending order( headNode->new root for this requirements)
		o.traverseRightSkewed(headNode);

		System.out.println("\n\n ----Program Completed Successfully----");
	}
}
