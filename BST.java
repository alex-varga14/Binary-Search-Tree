import java.io.*;
import java.util.*;

public class BST {

	private String fileName; //String Field for CLI for input filename
	private static ArrayList<String[]> words = new ArrayList<String[]>();//ArrayList to Store String[] from file reading
	public static BSTTree tree = new BSTTree(); //BST Instance
	private static ArrayList<String> uWords = new ArrayList<String>(); //ArrayList to Store uniqueWords
	private int totalWords = 0, uniqueWord = 0, maxWords = 0;
	
	/*
	 * Main Method:
	 * Takes in CLI on which file should be read.
	 * Instantiates an Instance of BST 
	 * UI Menu for answering all assignment questions/outputs
	 */
	public static void main(String[] args) {
		Scanner fN = new Scanner(System.in);
		System.out.print("Enter the filename: ");
		String str = fN.nextLine();
		BST example = new BST(str);
		Scanner sc = new Scanner(System.in); //Scanner for menu input
        boolean on = true; //boolean for menu control
        
        while(on){
            System.out.println("\n\n(1) Search file for a word");
            System.out.println("(2) Print the BST(Binary Search Tree)");
            System.out.println("(3) EXIT \n\n");
            int in = sc.nextInt();
            if (in == 1){
                System.out.print("\nEnter the word to search for in " + str +  ".txt: ");
                tree.search(sc.next());
            }else if (in == 2){
                System.out.println("Enter BST traversal method:");
                System.out.println("(1) In-Order");
                System.out.println("(2) Pre-Order");
                System.out.println("(3) Post-Order\n");
                in = sc.nextInt();
                if (in == 1){
                	tree.uniqueWords(tree.getRoot());
                    System.out.println();
                    System.out.println("Total number of words in " + str +  ".txt = " + example.getTotalWords());
                    System.out.println("Total number of unique words in " + str +  ".txt = " + tree.getUniqueWords());
                    System.out.println("The word which occur most often = " + tree.getTargetWord() + " and the number of times it appears = " + tree.getMax());
                    System.out.println("The maximum height of the tree = " + tree.maxDepth(tree.getRoot()));
                    System.out.print("IN-ORDER Output: ");
                    tree.printInorder();
                } else if (in == 2){
                    System.out.println();
                    System.out.println("Total number of words in " + str +  ".txt = " + example.getTotalWords());
                    System.out.println("Total number of unique words in " + str +  ".txt = " + tree.getUniqueWords());
                    System.out.println("The word which occur most often = " + tree.getTargetWord() + "and the number of times it appear = "+ tree.getMax());
                    System.out.println("The maximum height of the tree = " + tree.maxDepth(tree.getRoot()));
                    System.out.print("PRE-ORDER Output: ");
                    tree.printPreorder();
                } else if (in == 3){
                    System.out.println();
                    System.out.println("Total number of words in " + str +  ".txt = " + example.getTotalWords());
                    System.out.println("Total number of unique words in " + str +  ".txt = " + tree.getUniqueWords());
                    System.out.println("The word which occur most often = " + tree.getTargetWord() + " and the number of times it appear = "+ tree.getMax());
                    System.out.println("The maximum height of the tree = " + tree.maxDepth(tree.getRoot()));
                    System.out.print("POST-ORDER Output: ");
                    tree.printPostorder();
                }
            } else if (in == 3){
                on = false;
            }
        } 
	}
	
	/*
	 * Constructor
	 * Takes in filename of input file.
	 * Sends the fileName to setFileName Method
	 */
	public BST(String fileName) {
		setFileName(fileName);
	} 
	
	/*
	 * Simple Setter for the Filename
	 * Sets the local field textFile to the inputed fileName
	 * Calls the readFile method to read from a file with "fileName" as its name
	 */
	public void setFileName(String fileName) {
		  this.fileName = fileName + ".txt";
		  readFile();
	}
	/*
	 * Simple Getter for the total words/nodes
	 */
	public int getTotalWords() {
		return totalWords;
	}
	
	   /*
	   * Method to read input file and extract information for ListA
	   */
	  public void readFile() {
		BufferedReader file = null;
		// No filename was set
		    if (this.fileName == null) {
		      System.err.printf("FileName must be specified with setter or method call.%n");
		      System.exit(1);
		    } try {
		      file = new BufferedReader(new FileReader(this.fileName));
		      String line;
		      while ((line = file.readLine()) != null) {
				  if(line.length() > 0) {
					  words.add(line.replaceAll("[^0-9a-zA-Z]", " ").toLowerCase().split("\\s+"));
				  }
		      }  
		    } catch (Exception e) {
		      System.err.println("I/O error opening/reading file.");
		      System.err.println(e.getMessage());
		      closeReader(file);
		      System.exit(1);
		    }
		    growTree();
		    closeReader(file);
		}
	  /*
	   * Method to insert words into BST
	   */
	  public void growTree() {
		  for(int i = 0; i < words.size(); i++) {
			  for(int j = 0; j < words.get(i).length; j++) {
				  if(uniqueWords(words.get(i)[j])){
					  totalWords++;
				  }
				  tree.insert(new BSTNodes(words.get(i)[j]));
			  }
		  }
	  }
	  
	  //public void frequencyCounter
	  
	  /*
		 * Boolean method that compares an a String argument (input) with the list of recurring words
		 * returns true if the word is unique from the list, false otherwise
		 */
		public static boolean uniqueWords(String input) {
			  boolean flag = true;
			  if(uWords.size() == 0) {
				  uWords.add(input);
				  return flag;
			  } else {
				  for(int i = 0; i < uWords.size(); i++) {
					  if(input.toLowerCase().strip().equals(uWords.get(i).toString().toLowerCase().strip())) {
						  return false;
					  }
				  }
				  uWords.add(input);
				  return flag;
			  }
		  }
	  
	  /*
	   * Private Method to close the reader file from readFile
	   * This method is from work in a previous class of mine. (ENSF 409)
	   */
	  private void closeReader(BufferedReader file) {
	      try {
	        if (file != null) {
	          file.close();
	        }
	      } catch (Exception e) {
	        System.err.println("I/O error closing file.");
	        System.err.println(e.getMessage());
	        System.exit(1);
	      }
	  }
}