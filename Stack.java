
public class Stack<T>{
	myArrayList<T> data;
	
	public Stack() {
		data = new myArrayList<T>();
	}
	
	public void push(T e) {
		data.add(e);
	}
	
	public T pop() {
		T toBeReturned = data.get(data.size() - 1);
		data.delete();
		return toBeReturned;
	}
	
	public boolean hasAny() {
		return (data.size() > 0);
	}
}