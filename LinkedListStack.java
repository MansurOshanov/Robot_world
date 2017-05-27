package robot_world;



public class LinkedListStack<T> implements Stack<T>{

	private Node<T> top;
	private int size;
	
	public LinkedListStack() {
		size = 0;
		top = null;
	}
	
	@Override
	public void push(T value) {
		Node<T> newNode = new Node(value);
		newNode.setLink(top);
		top = newNode;
		size++;		
	}

	@Override
	public T pop() throws Exception {	
		if (size > 1) {
			T temp = top.getValue();
			top = top.getLink();
			size--;
			return temp;
		} else if (size == 1){
			T temp = top.getValue();
			top = null;
			size = 0;
			return temp;
		}
		throw new Exception("Stack is empty");
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		top = null;
	}
	
	public String toString() {
		String accum = "------top-------\n";
		Node<T> curr = top;
		while (curr != null) {
			accum += " " + curr.getValue();
			curr = curr.getLink();
		}
		accum += "-----bottom-----";
		return accum;
	}
}
