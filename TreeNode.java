
public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	
	/**
	 * Create a new TreeNode with left and 
	 * right child set to null and data set to the dataNode
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this(dataNode, null, null);
	}
	
	public TreeNode(T dataNode, TreeNode<T> newleftChild, TreeNode<T> newrightChild) {
		data = dataNode;
		leftChild = newleftChild;
		rightChild = newrightChild;
	}

	/**
	 * Used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
	
	public void setData(T newdata) {
		this.data = newdata;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> newleftChild) {
		leftChild = newleftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> newrightChild) {
		rightChild = newrightChild;
	}
}