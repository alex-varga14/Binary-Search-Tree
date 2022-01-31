import java.util.HashMap;

public class BSTTree {

	private BSTNodes root;
	private boolean match = false;
	private int uniqueWords = 0, max = 0, counter = 0;
	private String targetWord;
	
	/*
	 * Default Constructor
	 */
	public BSTTree() {
		setRoot(null);
	}

	/*
	 * Simple setter for the root
	 */
	public void setRoot(BSTNodes root) {
		this.root = root;
	}
	
	/*
	 * Simple Getter for the root
	 */
	public BSTNodes getRoot() {
		return root;
	}
	
	/*
	 * Simple Getter for max frequency
	 */
	public int getMax() {
		return (max+1);
	}
	
	/*
	 * Simple Getter for total unique Words
	 */
	public int getUniqueWords() {
		return uniqueWords;
	}
	
	/*
	 * Method to set the max frequency
	 */
	public void maxFreq(int t) {
		max = t;
	}
	
	/*
	 * Simple Getter for target word for max frequency
	 */
	public String getTargetWord() {
		return targetWord;
	}
	
	/*
	 * Simple Getter/formatter for total matches
	 */
	
	/*
	 * Simple boolean method to check if BST is empty
	 * From in-class coding session
	 */
	public boolean isEmpty() {
		if(getRoot() == null)
			return true;
		return false;
	}
	
	/*
	 * Insert method for the BST, takes node and sorts the BST alphabetically
	 */
	public void insert(BSTNodes st) {
		if(st == null)
			return;
		st.setLeft(null);
		st.setRight(null);
		if(isEmpty()) {
			root = st;
		} else {
			BSTNodes cursor = getRoot();
			while(true) {
				BSTNodes parent = cursor;
				String k = st.getWord();
				int compare = k.compareTo(cursor.getWord());
				if(compare < 0) {
					cursor = cursor.getLeft();
					if(cursor == null) {
						parent.setLeft(st);
						return;
					}
					// root 
				} else if (compare > 0) {
					cursor = cursor.getRight();
					if(cursor == null) {
						parent.setRight(st);
						return;
					}
				} else {
					root.setFreq(root.getFreq());
					parent.setFreq(cursor.getFreq()+1);
					return;
				}
			}			
		}
	} 
	
	/*
	 * Method for determining the amount of unique words
	 */
	public int uniqueWords(BSTNodes Node) {
		if(Node != null) {
			this.counter += uniqueWords(Node.getLeft());;
			if(Node.getFreq() > max) {
				targetWord = Node.getWord();
				maxFreq(Node.getFreq());
			}
			this.counter += uniqueWords(Node.getRight());
		}
		//System.out.println("This is counter: " + getCounter());
		return counter;
	} 
	
	
	public BSTNodes search(BSTNodes cursor, String key) {
		if(cursor == null || key.equals(cursor.getWord())) {
			System.out.println("\nTarget Word: "+ cursor.getWord() + " was FOUND a total of "+ (cursor.getFreq()+1) + " time(s).");
			match = true;
			return cursor;
		}
		if(key.compareTo(cursor.getWord()) > 0) {
			return search(cursor.getRight(), key);
		}
		
		return search(cursor.getLeft(),key);
			
	}
	
	public BSTNodes search(String key) {
		return search(root, key);
	}
	
	

	public void printPostOrder(BSTNodes n) {
		if(n == null) 
			return;
		//recur left subtree
		printPostOrder(n.getLeft());
		//recur right subtree
		printPostOrder(n.getRight());
		//print node word
		System.out.print(n.getWord() + " ");
	}
	
	public void printInOrder(BSTNodes n) {
		if(n == null) 
			return;
		//recur on left child
		printInOrder(n.getLeft());
		//print node word
		System.out.print(n.getWord() + " ");
		//recur on right child
		printInOrder(n.getRight());
	}
	
	/*
	 * Method to determine the max depth/height of the BST
	 * returns integer value of height
	 */
	public int maxDepth(BSTNodes n) {
		if (n == null) {
			return 0;
		}
		else {
			int lDepth = maxDepth(n.getLeft());
			int rDepth = maxDepth(n.getRight());
			
			if(lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	
	public void printPreOrder(BSTNodes n) {
		if(n == null) 
			return;
		//print node word
		System.out.print(n.getWord() + " ");
		//recur on left subtree
		printPreOrder(n.getLeft());
		//recur on right subtree
		printPreOrder(n.getRight());
	}
	
	// Wrappers over above recursive functions
    void printPostorder() { printPostOrder(root); }
    void printInorder() { printInOrder(root); }
    void printPreorder() { printPreOrder(root); }
	
	
}
