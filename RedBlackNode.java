


public class RedBlackNode<T extends Comparable, E> {
	T key;
	myArrayList<E> values;
	RedBlackNode<T,E> left;
	RedBlackNode<T,E> right;
	RedBlackNode<T,E> parent;
	char color = 'R';
	
	public RedBlackNode() {
		key = null;
		values = null;
		left = null; right = null;
		color = 'R';
	}
	
	public RedBlackNode(T key) {
		this.key = key;
		values = null;
		left = null; right = null;
		color = 'R';
		parent = null;
	}
	
	public RedBlackNode(T key, E value) {
		this.key = key;
		values = new myArrayList<E>();
		values.add(value);
		left = null; right = null;
		color = 'R';
		parent = null;
	}
	
	public RedBlackNode(T key, E value, RedBlackNode<T,E> parent) {
		this.key = key;
		values = new myArrayList<E>();
		values.add(value);
		left = null; right = null;
		color = 'R';
		this.parent = parent;
	}
	
	public RedBlackNode(T key, E value, char color) {
		this.key = key;
		values = new myArrayList<E>();
		values.add(value);
		left = null; right = null;
		this.color = color;
	}
	
   
    public E getValue() {
    	if(values == null) return null;
        return values.get(0);
    }

   
    public myArrayList<E> getValues() {
        return values;
    }
    void setColor(char c) {
    	color = c;
    }
    void reColor() {
    	if(color == 'B') color = 'R';
    	else color = 'B';
    }
    public T getKey() {
    	return key;
    }
}
