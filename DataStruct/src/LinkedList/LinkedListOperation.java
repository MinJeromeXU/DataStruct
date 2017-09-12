package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedListOperation {

	public static void main(String[] args) {
		/**
		 * 获取数据构建一个链表
		 */
		Scanner in = new Scanner(System.in);
		Node head = null;
		if(in.hasNextInt()){
			head = new Node(in.nextInt());
		}
	    Node temp = head;
		while(in.hasNextInt()){
			temp.next=new Node(in.nextInt());
			temp = temp.next;
		}
		in.close();
		
//		System.out.println("====链表的个数======");
//		int count = getLinkedLength(head);
//		System.out.println(count);
//		System.out.println("=====获取倒数第K个节点=========");
//		Node node = Reverse_K_Node(head,3);
//		System.out.println(node.value);
//		Node node1 = Reverse_K_Node1(head,3);
//		System.out.println(node1.value);
//		Node node2 = Reverse_K_Node2(head,3);
//		System.out.println(node2.value);
//		Node node = insertionSortList(head);
//		shuchu(node);
		Node node = firstnodeInCycle(head);
		shuchu(node);
	}
	/**
	 * 求单个链表中节点个数
	 */
	public static  int getLinkedLength(Node head){
		int count=0;
		Node temp = head;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	/**
	 *1、 链表遍历
	 */
	public static void shuchu(Node node){
		while(node!=null){
			System.out.print(node.value+" ");
			 node=node.next;
		}
	}
	/**
	 * 2、单链表反转
	 */
	public static  Node reverseLinkedList(Node head){
		Node tail=null;
		if(head==null)return null;
		Node pre=null;
		Node nex=null;
		while(head!=null){
			nex = head.next;
			head.next = pre;
			pre = head;
			head = nex;
		}
		if(head==null){
			head=pre;
		}
		return head;
	}
	/**
	 * 3、求单链表中倒数第k个节点
	 */
	public static Node Reverse_K_Node(Node node,int k){
		//方法一：获取链表顺序的第几个节点
		int count = getLinkedLength(node);
		//方法二：链表反转，获取反转后的k个节点。
		if(k>count)return null;
		int n = count-k;
		Node temp = node;
		while(temp!=null&&n>0){
			n--;
			temp=temp.next;
		}
		node = temp;
		return node;
	}
	/**
	 * 4、倒数第k个节点
	 * @param node
	 * @param k
	 * @return
	 */
	public static Node Reverse_K_Node1(Node node,int k){
		//方法一：获取链表顺序的第几个节点
//		int count = getLinkedLength(node);
		//方法二：链表反转，获取反转后的k个节点。
		Node node1 = reverseLinkedList(node);
		shuchu(node1);
		System.out.println("\n");
		int n =1; 
		Node temp = node1;
		while(temp!=null&&n<k){
			n++;
			temp=temp.next;
		}
		node = temp;
		return node;
	}
	public static Node Reverse_K_Node2(Node node,int k){
		//方法一：获取链表顺序的第几个节点
//		int count = getLinkedLength(node);
		//方法二：链表反转，获取反转后的k个节点。
		Node target =node;
		Node temp = node;
		if(temp==null)return null;
		int i=0;
		for(i=0;i<k;i++){
			if(temp!=null)
				temp = temp.next;
		}
		if(i!=k){
			return null;
		}
		while(temp!=null){
			target = target.next;
			temp = temp.next;
		}
		return target;
	}
	/**
	 * 5、寻找单链表的中间节点
	 */
	public static Node MidNode(Node node){
		Node mid=null;
		if(node==null)return null;
		int length = getLinkedLength(node);
		int midLength =0;
		if(length%2!=0){
			midLength = length/2+1;
		}else{
			midLength=length/2;
		}
		while(midLength>0){
			node=node.next;
			midLength--;
		}
		mid=node;
		return mid;
	}
	/**
	 *6、 从尾到头打印节点,反转链表就ok
	 */
	/**
	 * 7、合并两个有序的单链表
	 */
	public static Node mergeInOrder(Node node1,Node node2){
		if(node1==null)return node2;
		if(node2==null)return node1;
		Node node =null;
		Node head1 =node;
		Node head2 =node;
		if(node1.value>node2.value){
			node =node2;
			head2=node2.next;
		}else if(node1.value<=node2.value){
			node =node1;
			head1 =node1.next;
		}
		while(head1!=null&head2!=null){
			if(head1.value>head2.value){
				node.next = head2;
				head2=head2.next;
			}else if(head1.value<=head2.value){
				node.next=head1;
			}
			node = node.next;
			node.next = null;
		}
		if(head1!=null){
			node.next =head1;
		}
		if(head2!=null){
			node.next =head2;
		}
		return node;
	}
	/**
	 * 8、对单链表进行排序 插入排序
	 */
    public static Node insertionSortList(Node head) {  
        if(head==null||head.next==null)return head;  
        Node pnex = head.next;  
        Node pnex_nex = null;  
        head.next=null;  
        while(pnex!=null){  
            pnex_nex=pnex.next;  
            Node temp=head;  
            Node temp_pre=null;  
            while(temp!=null){  
                if(pnex.value<temp.value)break;  
                temp_pre=temp;  
                temp=temp.next;  
            }  
            if(temp_pre==null){  
                head=pnex;  
                pnex.next=temp;  
            }else{  
                temp_pre.next=pnex;  
                pnex.next=temp;  
            }  
            pnex=pnex_nex;  
        }  
        return head;  
    }   
	/**
	 * 9、判断一个单链表中是否有环,快慢指针 
	 */
    public static boolean hasCycle(Node node ){
    	boolean flag = false;
    	Node p =node;
    	Node q =node;
    	if(node==null)return flag;
    	while(p!=null&&q!=null){
    		p=p.next;
    		q=q.next.next;
    		if(p==q){
    			flag = true; 
    			break;
    		}
    	}
    	return flag;
    }	
	/**
	 *10、判断两个单链表是否相交,如果相交返回第一个节点，否则返回null  
     *如果单纯的判断是否相交，只需要看最后一个指针是否相等
	 */
	public static Node InterSect(Node node1,Node node2){
		if(node1==null||node2==null)return null;
		int length1 = getLinkedLength(node1);
		int length2 = getLinkedLength(node2);
		int moreLength=0;
		if(length1>length2){
			moreLength = length1-length2;
			while(moreLength>0){
				node1 = node1.next;
				moreLength--;
			}
		}else if(length1<=length2){
			moreLength = length2-length1;
			while(moreLength>0){
				node2 = node2.next;
				moreLength--;
			}
		}
		while(node1!=null&&node2!=null){
			if(node1==node2)
				break;;	
			
		}
		if(node1==null||node2==null){
			return null;
		}else{
			return node1;
		}
	}
	/**
	 *11、已知一个单链表中存在环，求进入环中的第一个节点,不利用hashmap，快慢指针
	 *用快慢指针，与判断一个单链表中是否有环一样，找到快慢指针第一次相交的节点，
     *此时这个节点距离环开始节点的长度和链表投距离环开始的节点的长度相等  
	*/
	public static Node firstNodeInCycle(Node node){
		Node target =null;
		if(node==null||node.next==null)return target;
		Node p =node ;//慢指针
		Node q =node;//块指针
		//寻找环中快慢指针的第一次相遇节点
		while(p!=null&&q!=null){
			p=p.next;
			q=q.next.next;
			if(p==q){
				break;
			}
		}
		p=node;
		while(p!=q){
			p=p.next;
			q=q.next;
		}
		target = p;
		return target;
	}
	/**
	 * 12、已知一个单链表中存在环，求进入环中的第一个节点,使用hashmap  
	 */
    public static Node firstnodeInCycle(Node node){
    	if(node==null)return null;
    	Node target =null;
    	Map<Node,Integer> map = new HashMap<Node,Integer>();
    	while(node!=null){
    		if(map.containsKey(node))
    			break;
    		else
    			map.put(node, node.value);    		
    		node = node.next;
    	}
    	target = node;
    	return target;
    }
	/**
	 *13、给出一单链表头指针head和一节点指针delete，O(1)时间复杂度删除节点delete  
     *可以采用将delete节点value值与它下个节点的值互换的方法，
	 *但是如果delete是最后一个节点，则不行，但是总得复杂度还是O(1) 
	 *返回删除的节点
	 */
    public static void deleteLinkedNode1(Node node,Node delNode){
    	Node target=null;    	
    	if(node==null||delNode==null)return ;
    	while(node!=null){
    		target = node;
    		if(node.next!=null){
    			node = node.next.next;
    		}else{
    			break;
    		}
    	}
    	if(target.next==delNode){
    		target.next =null;
    	}
    	if(node==delNode)
    		target = null;    	
    	delNode.value=delNode.next.value;
    	delNode.next=delNode.next.next;
    	return ;
    }
    public static boolean  deleteLinkedNode0(Node node,Node delNode){
    	boolean  flag= false;
    	if(node==null||delNode==null)return flag;
    	if(delNode.next==null){
    		if(delNode == node){
    			node = null;
    			return flag;
    		}else{
    			while(node.next!=delNode){
    				node.next=delNode;
    			}
    			node.next=null;
    		}
    		
    	}else{
    		delNode.value = delNode.next.value;
    		delNode.next = delNode.next.next;
    		flag = true;
    	}
    	return flag;
    }

}
