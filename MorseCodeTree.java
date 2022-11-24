import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root = null;
	private String Letter;
	
	/**
	 * Calls the buildTree method
	 */
	public MorseCodeTree(){	
		buildTree();
	}
	
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 */
	@Override
	public void buildTree() {
		//Level 0
		root = new TreeNode<>("");
		//Level 1
		insert(".", "e");
		insert("-", "t");
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");

		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	/**
	 * Sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> RootNode) {
		root = RootNode;
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Adds letter to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * @param code the code for the new node to be added
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if(code.length() == 0) { 
			return;
		}else if(code.length() == 1){
            if (code.equals(".")){
                root.leftChild = new TreeNode<>(letter);
            }else if (code.equals("-")){
                root.rightChild = new TreeNode<>(letter);
            }
            return;
        }else{    
            if(code.substring(0, 1).equals(".")){ 
                addNode(root.leftChild, code.substring(1), letter);
            }else if(code.substring(0, 1).equals("-")){
                addNode(root.rightChild, code.substring(1), letter);        
            }        
        }     
       
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		
		String result = fetchNode(root, code);
		return result;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(code.length() == 0) {
			Letter = null;
		}else if(code.length() == 1) {
			if(code.equals(".")) {
				Letter = root.leftChild.getData();
			}else if(code.equals("-")) {
				Letter = root.rightChild.getData();
			}
		}else {
			if(code.substring(0, 1).equals(".")) {
				fetchNode(root.leftChild, code.substring(1));
			}else if(code.substring(0, 1).equals("-")) {
				fetchNode(root.rightChild, code.substring(1));
			}
		}
		
		return Letter;
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> temp = new ArrayList<String>();
		LNRoutputTraversal(root, temp);
		return temp;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root != null) {
			LNRoutputTraversal(root.getLeftChild(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
