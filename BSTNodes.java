
public class BSTNodes {

	private String word;//data for node from file
	private int freq;//frequency of data
	private BSTNodes left, right;
	
	/*
	 * Constructor
	 * Takes in word data for node.
	 */
	public BSTNodes(String word) {
		setWord(word);
		setLeft(null);
		setRight(null);
	}

	/*
	 * Simple setter for the left
	 */
	public void setLeft(BSTNodes left) {
		this.left = left;
	}
	
	/*
	 * Simple setter for the right
	 */
	public void setRight(BSTNodes right) {
		this.right = right;
	}

	/*
	 * Simple setter for the node word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/*
	 * Simple setter for frequency
	 */
	public void setFreq(int f) {
		this.freq = f;
	}
	
	/*
	 * Simple Getter for node frequency
	 */
	public int getFreq() {
		return freq;
	}
	
	/*
	 * Simple Getter for the node word
	 */
	public String getWord() {
		return word;
	}
	/*
	 * Simple Getter for the left
	 */
	public BSTNodes getLeft() {
		return left;
	}
	
	/*
	 * Simple Getter for the right
	 */
	public BSTNodes getRight() {
		return right;
	}
	
}
