package LinkedList;

public class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((next == null) ? 0 : next.hashCode());
//		result = prime * result + value;
//		return result;
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
//		if (next == null) {
//			if (other.next != null)
//				return false;
//		} else if (!next.equals(other.next))
//			return false;
		if (value != other.value)
			return false;
		return true;
	}

}
