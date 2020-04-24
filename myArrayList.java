
public class myArrayList<T>{
	int final_index = 0;
	int max_length = 100;
	T[] array = (T[]) new Object[max_length];
	public myArrayList() {
		T[] array = (T[]) new Object[max_length];
		final_index = 0;
		max_length = 100;
	}
	public int add(T e) { //return index where it has inserted it.
		if(final_index < max_length) {
			array[final_index] = e;
			return final_index++;
		}
		else {
			expandArray();
			array[final_index] = e;
			return final_index++;
		}
	}
	
	void expandArray() {
		//System.out.println("EXPANDING!");
		if(final_index >= max_length) {
			T[] new_array = (T[]) new Object[2*max_length];
			for(int i = 0; i < final_index; i++) {
				new_array[i] = array[i];
			}
			array = new_array;
			max_length = 2*max_length;
		}
	}
	
	public T get(int i) {
		if(i < final_index) return array[i];
		else return null;
	}
	
	public boolean contains(T e) {
		for(int i = 0; i < final_index; i++) {
			if(array[i].toString().compareTo(e.toString()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return final_index;
	}
	
	public String toString() {
		String s = "[ ";
		for(int i = 0; i<final_index; i++) {
			s = s + array[i].toString() + ",";
		}
		s = s + "]";
		return s;
	}
	
	public void sort() {
		//sorts array. uses .toString() function of each element to sort it. Uses
	}
	
	public void delete() {
		final_index--;
	}

}