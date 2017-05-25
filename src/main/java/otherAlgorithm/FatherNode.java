package otherAlgorithm;

/**
 * Created by yangmin on 15/8/30.
 */

class Node {
	// Node parent;
	Node left;
	Node right;
	int value;

	Node(int value) {
		this.value = value;
	}
}


public class FatherNode {

	public static void main(String[] args) {


		FatherNode father = new FatherNode();

		//创造树
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		//node1.parent=null;
		node1.left = node1;
		node1.right = node3;
		//node2.parent=node1;
		node2.left = node4;
		node2.right = node5;
		//node3.parent=node1;
		node3.left = node6;
		node3.right = null;
		//node4.parent=node2;
		node4.left = null;
		node4.right = null;
		//node5.parent=node2;
		node5.left = null;
		node5.right = null;
		// node6.parent=node3;
		node6.left = null;
		node6.right = null;


		Node result = father.findNearestFather(node1, node4, node5);
		System.out.print(result.value);


	}

	/*  //已知parent以及两个结点
	  Node findNearestFather(Node a,Node b){

		  HashMap<Node,Integer> hashMap=new HashMap<Node,Integer>();
		  Node cur=a;
		  while(cur!=null){
			  hashMap.put(cur,0);
			  cur=cur.parent;
		  }
		  cur=b;
		  while(cur!=null){
			  if(hashMap.containsKey(cur))
				  return cur;
			  cur=cur.parent;

		  }
		  return null;

	  }
  */
	//未知parent，已知两个节点和root
	Node findNearestFather(Node root, Node a, Node b) {

		if (root == null)
			return null;
		if (root == a || root == b)
			return root;
		Node left = findNearestFather(root.left, a, b);
		Node right = findNearestFather(root.right, a, b);
		if (left != null && right != null)
			return root;
		if (left != null && right == null)
			return left;
		if (right != null && left == null)
			return right;
		return null;
	}


}
