class pos<T>{
	public T v;
	public pos<T> n;
	public pos(T val, pos<T> next){
		v = val;
		n = next;
	}
	public T value(){
		return v;
	}
	public pos<T> after(){
		return n;
	}
}

class LinkedListIterator<T>{
	public pos<T> head;
	public LinkedListIterator(pos<T> p){
		head = new pos<T>(null,p);	
	}
	public boolean hasNext(){
		return (head.after() != null);
	}
	public pos<T> next(){
		head = head.after();
		return head;
	}
	public void remove(){
	}
}

public class LinkedList<T> implements List<T>{
	public pos<T> head;
	public LinkedList(){
		head = null;
	}
	public pos<T> add(T e){
		if(head == null){
			head = new pos<T>(e, null);
			return head;
		}
		else{
			pos<T> node = (head);
			while(node.n != null){
				node = node.n;
			}
			node.n = new pos<T>(e, null);
			return node.n;
		}
	}
 
	public LinkedListIterator<T> positions(){
		return new LinkedListIterator<T>(head);
	}
	
	public int count(){
		int i = 0;
		pos<T> current = head;
		while(current != null){
			current = current.n;
			i = i + 1;
		}
		return i;
	}
}

