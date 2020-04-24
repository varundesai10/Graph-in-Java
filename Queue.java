
public class Queue<T>{
	LinkedList<T> data = new LinkedList<T>();
	int size;
	public Queue() {
		LinkedList<T> data = new LinkedList<T>();
		size = 0;
	}
	
	public void enqueue(T e) {
		data.add(e);
		size += 1;
	}
	
	public T dequeue() {
		T popped = data.head.v;
		data.head = data.head.n;
		size--;
		return popped;
	}
	
	public boolean hasAny() {
		return (size > 0);
	}
	
	public int size() {
		return size();
	}
}