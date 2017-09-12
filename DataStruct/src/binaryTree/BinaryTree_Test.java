package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree_Test {
	public static void main(String[] args) {
		Node root = creatTree();
//		System.out.println("======递归=====");
//		preOrderRec(root);
//		System.out.println("\n"+root+"=======非递归前序遍历========");
//		preOrderRec_NonDiGui(root);
//		System.out.println("\n"+" 非递归中序遍历=====");
//		inOrderTree_NonDiGui(root);
		System.out.println("=========非递归后续遍历=====");

		System.out.println("==========层级========");
		levelTravel(root);
	}
	/**
	 * 构建一颗二叉树
	 * @return root
	 */
	public static Node creatTree(){
		Node root = new Node(15);
		root.left = new Node(13);
		root.right = new Node(18);
		root.left.left = new Node(28);
		root.left.right = new Node(34);
		root.right.left = new Node(12);
		root.right.right= new Node(19);
		root.right.right.right = new Node(23);
		return root;
	}
	/**
	 * 递归遍历一颗二叉树前序遍历
	 * 
	 * 对于递归的另外两种方法同样道理
	 */
	public static void preOrderRec(Node root){
		if(root!=null){
			System.out.print(root.value+" ");				
				preOrderRec(root.left);						
				preOrderRec(root.right);			
		}
	}
	/**
	 * 非递归前序遍历一颗二叉树
	 */	
	public static void preOrderRec_NonDiGui(Node root){
		Stack<Node> st = new Stack<Node>();	
		if(root!=null){
			st.push(root);
		}
		Node node =null;
		while(!st.isEmpty()){
			node =st.pop();
			System.out.print(node.value+" ");
			if(node.right!=null)st.push(node.right);
			if(node.left!=null)st.push(node.left);
		}
	}
	/**
	 * 非递归的二叉树中序遍历
	 */
	    public static void inOrderTree_NonDiGui(Node root){
	    	Stack<Node> st = new Stack<Node>();
	    	if(root==null)return;
	    	while(root!=null||!st.isEmpty()){
	    		while(root!=null){
	    			st.push(root);
	    			root=root.left;
	    		}
	    		root=st.pop();
	    		System.out.print(root.value+" ");
	    		root = root.right;
	    	}
	    }
	    /**
	     * 非递归遍历的后续遍历：
	     * 使用一个map标记已经输出的节点；
	     * 先是递归到最左节点，输出，然后回到上一节点，找他的有节点，看有没有右子树，
	     * 有添加入栈中，然后回来看该节点是否有左子树，有使用同样的方法入栈。
	     * 没有左右子树，则输出这个上一节点，然后又回到上上一节点。
	     */
	    public static void postOrderStack(Node root){  
	        if(root==null)return;  
	        Stack<Node> s=new Stack<Node>();  
	        Map<Node,Boolean> map=new HashMap<Node,Boolean>();   
	        s.push(root);  
	        while(!s.isEmpty()){  
	            Node temp=s.peek();  
	            if(temp.left!=null&&!map.containsKey(temp.left)){  
	                temp=temp.left;  
	                while(temp!=null){  
	                    if(map.containsKey(temp))break;  
	                    else s.push(temp);  
	                    temp=temp.left;  
	                }  
	                continue;  
	            }  
	            if(temp.right!=null&&!map.containsKey(temp.right)){  
	                s.push(temp.right);  
	                continue;  
	            }  
	            Node t=s.pop();  
	            map.put(t,true);  
	            System.out.println(t.value);  
	        }  
	    }
    /*
     * 层级遍历
     */
	    public static void levelTravel(Node root){
	    	if(root==null)return ;
	    	Queue<Node> q = new LinkedList<Node>();
	    	q.add(root);
	    	Node node =null;
	    	while(!q.isEmpty()){
	    		node = q.poll();
	    		System.out.print(node.value+" ");
	    		if(node.left!=null)q.add(node.left);
	    		if(node.right!=null)q.add(node.right);	    		
	    	}
	    }
}
